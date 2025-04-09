package game.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import game.model.*;

public class PlayersDao{
  protected PlayersDao() {};
	
  /**
   * Save the User instance by storing it in MySQL instance.
   * This runs a INSERT statement.
   * This returns a Players.
   */
  public static Players create(
	Connection cxn,
    String firstName,
	String lastName,
	String emailAddress
	) throws SQLException {
	  final String insertPlayers =
	    "INSERT INTO Players (firstName, lastName, emailAddress) VALUES (?, ?, ?);";

      try (PreparedStatement insertStmt = cxn.prepareStatement(insertPlayers, Statement.RETURN_GENERATED_KEYS)) {
    	insertStmt.setString(1, firstName);
        insertStmt.setString(2, lastName);
        insertStmt.setString(3, emailAddress);
        insertStmt.executeUpdate();
        
        try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
          if (generatedKeys.next()) {
      	    int playersID = generatedKeys.getInt(1);
      	    return new Players(playersID, firstName, lastName, emailAddress);
      	  } else {
      	  throw new SQLException("Failed to retrieve generated userID.");
      	  }
      	} 
      }
	}
  
  /**
   * Get the Players record by fetching it from MySQL instance.
   * This runs a SELECT statement and returns a single Players instance based on playerID.
   */
  public static Players getPlayerByPlayerID(
	Connection cxn,
    int playerID
  )  throws SQLException {
     final String selectPlayer =
       """
       SELECT playerID, firstName, lastName, emailAddress
       FROM Players 
       WHERE playerID = ?;
       """;

     try (PreparedStatement selectStmt = cxn.prepareStatement(selectPlayer)) {
    	  selectStmt.setInt(1, playerID);

     try (ResultSet results = selectStmt.executeQuery()) {
        if (results.next()) {
          return new Players(
            results.getInt("playerID"),
            results.getString("firstName"),
            results.getString("lastName"),
            results.getString("emailAddress")
          );
        } else {
          return null;
        }
      }
    }
  }
  
  /**
   * Delete the Players record by fetching it from MySQL instance.
   * This runs a DELETE statement.
   */
  public static void deletePlayerByPlayerID(
	Connection cxn,
    int playerID
    ) throws SQLException {
	    String deletePlayer = "DELETE FROM Players WHERE playerID = ?;";

	    try (PreparedStatement deleteStmt = cxn.prepareStatement(deletePlayer)) {
	      deleteStmt.setInt(1, playerID);
	      deleteStmt.executeUpdate();
	    }

	}
  
  /**
   * Get the Players record by fetching it from MySQL instance.
   * This runs a SELECT statement and returns a list of Players based on firstName.
   */
  public static List<Players> getPlayersFromFirstName(
    Connection cxn,
    String firstName
  ) throws SQLException {
    List<Players> players = new ArrayList<>();
    String selectPlayers = """
      SELECT playerID, firstName, lastName, emailAddress
      FROM Players 
      WHERE firstName = ?""";

    try (PreparedStatement selectStmt = cxn.prepareStatement(selectPlayers)) {
      selectStmt.setString(1, firstName);
      try (ResultSet results = selectStmt.executeQuery()) {
        while (results.next()) {
          players.add(
            new Players(
              results.getInt("playerID"),
              firstName,
              results.getString("lastName"),
              results.getString("emailAddress")
            )
          );
        }
        return players;
      }
    }
  }
  
  /**
   * add in pm4
   * Get the Players record by lastName.
   * @return a list of Players
   */
  public static List<Players> getPlayersFromLastName(
		    Connection cxn,
		    String lastName
  ) throws SQLException {
    List<Players> players = new ArrayList<>();
    String selectPlayers = """
      SELECT playerID, firstName, lastName, emailAddress
      FROM Players 
      WHERE lastName LIKE ?; """;

    try (PreparedStatement selectStmt = cxn.prepareStatement(selectPlayers)) {
      selectStmt.setString(1, "%" + lastName + "%");
      try (ResultSet results = selectStmt.executeQuery()) {
        while (results.next()) {
          players.add(
            new Players(
              results.getInt("playerID"),
              results.getString("firstName"),
              results.getString("lastName"),
              results.getString("emailAddress")
            )
          );
        }
        return players;
      }
    }
  }
  
  
  /**
   * Update the emailAddress of the Player instance.
   * This runs a UPDATE statement.
   */
  public static Players updatePlayerEmailAddress(
    Connection cxn,
    Players player,
    String newEmailAddress
	  ) throws SQLException {
    String updatePlayerEmailAddress = """
      UPDATE Players
      SET emailAddress = ?
      WHERE playerID = ?;""";

    try (PreparedStatement updateStmt = cxn.prepareStatement(updatePlayerEmailAddress)) {
      updateStmt.setString(1, newEmailAddress);
      updateStmt.setInt(2, player.getPlayerID());
      updateStmt.executeUpdate();
      
      player.setEmailAddress(newEmailAddress);
      return player;
    }
  }

  /**
   * Update the firstName of the Player instance.
   * This runs a UPDATE statement.
   */
  public static Players updatePlayerFirstName(
    Connection cxn,
    Players player,
    String newFirstName
	  ) throws SQLException {
    String updatePlayerFirstName = """
      UPDATE Players
      SET firstName = ?
      WHERE playerID = ?;""";

    try (PreparedStatement updateStmt = cxn.prepareStatement(updatePlayerFirstName)) {
      updateStmt.setString(1, newFirstName);
      updateStmt.setInt(2, player.getPlayerID());
      updateStmt.executeUpdate();
      
      player.setFirstName(newFirstName);
      return player;
    }
  }
  
  /**
   * Update the lastName of the Player instance.
   * This runs a UPDATE statement.
   */
//  public static Players updatePlayerLastName(
//    Connection cxn,
//    Players player,
//    String newLastName
//	  ) throws SQLException {
//    String updatePlayerLastName = """
//      UPDATE Players
//      SET lastName = ?
//      WHERE playerID = ?;""";
//
//    try (PreparedStatement updateStmt = cxn.prepareStatement(updatePlayerLastName)) {
//      updateStmt.setString(1, newLastName);
//      updateStmt.setInt(2, player.getPlayerID());
//      updateStmt.executeUpdate();
//      
//      player.setLastName(newLastName);
//      return player;
//    }
//  }
  
  public static Players updatePlayerLastName(
		  Connection cxn,
		  Players player,
		  String newLastName
		) throws SQLException {
		  System.out.println("Updating player ID " + player.getPlayerID() + 
		                    " last name from '" + player.getLastName() + 
		                    "' to '" + newLastName + "'");
		  
		  String updatePlayerLastName = """
		    UPDATE Players
		    SET lastName = ?
		    WHERE playerID = ?;""";

		  try (PreparedStatement updateStmt = cxn.prepareStatement(updatePlayerLastName)) {
		    updateStmt.setString(1, newLastName);
		    updateStmt.setInt(2, player.getPlayerID());
		    int rowsAffected = updateStmt.executeUpdate();
		    System.out.println("Rows affected by update: " + rowsAffected);
		    
		    player.setLastName(newLastName);
		    return player;
		  }
		}
  
}