package game.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import game.model.*;

public class CharactersDao{
  protected CharactersDao() {};
	
  /**
   * Save the Characters instance by storing it in MySQL instance.
   * This runs a INSERT statement.
   * This returns a Characters instance.
   */
  public static Characters create(
	Connection cxn,
	Players player,
	String firstName,
	String lastName,
	Clans clan,
	Weapons weaponWeared
	) throws SQLException {
	  final String insertCharacters =
	    "INSERT INTO Characters (playerID, firstName, lastName, clan, weaponWeared) VALUES (?, ?, ?, ?, ?);";

      try (PreparedStatement insertStmt = cxn.prepareStatement(insertCharacters, Statement.RETURN_GENERATED_KEYS)) {
    	insertStmt.setInt(1, player.getPlayerID());
        insertStmt.setString(2, firstName);
        insertStmt.setString(3, lastName);
        insertStmt.setString(4, clan.getClanName());
        insertStmt.setInt(5, weaponWeared.getItemID());
        insertStmt.executeUpdate();
        
        try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
          if (generatedKeys.next()) {
      	    int charID = generatedKeys.getInt(1);
      	    return new Characters(charID, player, firstName, lastName, clan, weaponWeared);
      	  } else {
      	  throw new SQLException("Failed to retrieve generated charID.");
      	  }
      	} 
      }
	}
  
  /**
   * Get the Characters record by fetching it from MySQL instance.
   * This runs a SELECT statement and returns a single Characters instance based on charID.
   */
  public static Characters getCharacterByCharID(
	Connection cxn,
    int charID
  )  throws SQLException {
     final String selectCharacter =
       """
       SELECT charID, playerID, firstName, lastName, clan, weaponWeared
       FROM Characters 
       WHERE charID = ?;
       """;

     try (PreparedStatement selectStmt = cxn.prepareStatement(selectCharacter)) {
    	  selectStmt.setInt(1, charID);

     try (ResultSet results = selectStmt.executeQuery()) {
        if (results.next()) {
          return new Characters(
            results.getInt("charID"),
            PlayersDao.getPlayerByPlayerID(cxn, results.getInt("playerID")),
            results.getString("firstName"),
            results.getString("lastName"),
            ClansDao.getClanRacebyClanName(cxn, results.getString("clan")),
            WeaponsDao.getWeaponByItemID(cxn, results.getInt("weaponWeared"))
          );
        } else {
          return null;
        }
      }
    }
  }
  
  /**
   * add in pm4
   * Get all Characters records join with player's name, clan, and weapon in the database
   * @return a list of all ordered characters
   */
  public static List<Characters> getAllCharacters(
		    Connection cxn,
		    String sortBy,
		    String sortOrder
  ) throws SQLException {
    List<Characters> characters = new ArrayList<>();
    
    String validatedSortAttribute = validateSortAttribute(sortBy);
    String validatedSortOrder = validateSortOrder(sortOrder);
    String selectCharacters = "SELECT c.*, p.*, cl.*, w.* " + 
    						  "FROM Characters c " +
    						  "JOIN Players p ON c.playerID = p.playerID " +
    						  "JOIN Clans cl ON c.clan = cl.clanName " +
    						  "JOIN Weapons w ON c.weaponWeared = w.itemID " +
    						  "ORDER BY " + validatedSortAttribute + " " + validatedSortOrder;

    try (PreparedStatement selectStmt = cxn.prepareStatement(selectCharacters)) {
    	try (ResultSet rs = selectStmt.executeQuery()) {
    		while (rs.next()) {
    			Players player = PlayersDao.getPlayerByPlayerID(cxn, rs.getInt("p.playerID"));
    			Clans clan = ClansDao.getClanRacebyClanName(cxn, rs.getString("cl.clanName"));
    			Weapons weapon = WeaponsDao.getWeaponByItemID(cxn, rs.getInt("w.itemID"));
    			
    			characters.add(
    					new Characters(
    						rs.getInt("charID"),
    						player,
    						rs.getString("firstName"),
    						rs.getString("lastName"),
    						clan,
    						weapon
    					)
    			);
    		}
    	}
    }
    return characters;
  }
  
  /**
   * add in pm4
   * Get all Characters records by a list of PlayerIDs
   * @return a list of all ordered characters
   */
  public static List<Characters> getCharactersByPlayerIDs(
		    Connection cxn,
		    List<Integer> playerIDs,
		    String sortBy,
		    String sortOrder
  ) throws SQLException {
	  if (playerIDs == null || playerIDs.isEmpty()) {
		  return new ArrayList<>();
	  }
    List<Characters> characters = new ArrayList<>();
    
    String validatedSortAttribute = validateSortAttribute(sortBy);
    String validatedSortOrder = validateSortOrder(sortOrder);
    // create the IN clause placeholder (?, ?, ..., ?)
    String placeholders = String.join(",", Collections.nCopies(playerIDs.size(), "?"));
    
    String selectCharactersByPlayer = "SELECT c.*, p.*, cl.*, w.* " + 
									  "FROM Characters c " +
									  "JOIN Players p ON c.playerID = p.playerID " +
									  "JOIN Clans cl ON c.clan = cl.clanName " +
									  "JOIN Weapons w ON c.weaponWeared = w.itemID " +
									  "WHERE p.playerID IN (" + placeholders + ") " +
									  "ORDER BY " + validatedSortAttribute + " " + validatedSortOrder;

    try (PreparedStatement pstmt = cxn.prepareStatement(selectCharactersByPlayer)) {
    	// set player id in the IN clause
    	for (int i = 0; i < playerIDs.size(); i++) {
    		pstmt.setInt(i + 1, playerIDs.get(i));
    	}
    	
    	try (ResultSet rs = pstmt.executeQuery()) {
    		while (rs.next()) {
    			characters.add(
    					new Characters(
    						rs.getInt("c.charID"),
    						PlayersDao.getPlayerByPlayerID(cxn, rs.getInt("p.playerID")),
    						rs.getString("c.firstName"),
    						rs.getString("c.lastName"),
    						ClansDao.getClanRacebyClanName(cxn, rs.getString("cl.clanName")),
    						WeaponsDao.getWeaponByItemID(cxn, rs.getInt("w.itemID"))
    					)
    			);
    		}
    	}
    }
    return characters;
  }

  /**
   * add in pm4
   * validates the sort order parameter in query
   * @param sortOrder
   * @return a string (ASC / DESC)
   */
  public static String validateSortOrder(String sortOrder) {
	  if (sortOrder == null || sortOrder.trim().isEmpty()) {
		  return "ASC"; // default
	  }
	  
	  if (sortOrder.equals("descending")) {
		  return "DESC";
	  } else {
		  return "ASC";
	  }
  }
  /**
   * add in pm4
   * validates the sort attribute in query
   * @param sortBy
   * @return a string (the attribute name)
   */
  public static String validateSortAttribute(String sortBy) {
	  if (sortBy == null || sortBy.trim().isEmpty()) {
		  return "p.lastName"; // default
	  }
	  
	  switch (sortBy.toLowerCase()) {
	  case "characterfirstname": return "c.firstName";
	  case "characterlastname": return "c.lastName";
	  case "playerfirstname": return "p.firstName";
	  case "playerlastname": return "p.lastName";
	  case "clan": return "cl.clanName";
	  case "job": return "w.wearablejob";
	  default: return "p.lastName";
	  }
  }
  
  public static Characters updateWeaponWeared(Connection cxn, Characters character, Weapons weapon) throws SQLException {
	  final String updateWeapon = """
	  		UPDATE Characters
	  		SET weaponWeared = ?
	  		WHERE charID = ?
	  		""";
	  
	  try (PreparedStatement updateStmt = cxn.prepareStatement(updateWeapon)) {
		  updateStmt.setInt(1, weapon.getItemID());
		  updateStmt.setInt(2, character.getCharID());
		  updateStmt.executeUpdate();
		  
		  character.setWeaponWeared(weapon);
		  return character;
	  }
	  
  }
  
}