package game.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        insertStmt.setString(2, player.getFirstName());
        insertStmt.setString(3, player.getLastName());
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
            ClansDao.getClanByClanName(cxn, results.getString("clan")),
            WeaponsDao.getWeaponByItemID(cxn, results.getInt("weaponWeared"))
          );
        } else {
          return null;
        }
      }
    }
  }
  
}