package game.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import game.model.*;

public class CharacterUnlockedJobDao{
  protected CharacterUnlockedJobDao() {};
	
  /**
   * Save the CharacterUnlockedJob instance by storing it in MySQL instance.
   * This runs a INSERT statement.
   * This returns a CharacterUnlockedJob instance.
   */
  public static CharacterUnlockedJob create(
	Connection cxn,
	Characters character,
	String jobName,
	int jobLevel,
	int xP
	) throws SQLException {
	  final String insertCharacterUnlockedJob =
	    "INSERT INTO CharacterUnlockedJob (charID, jobName, jobLevel, XP) VALUES (?, ?, ?, ?);";

      try (PreparedStatement insertStmt = cxn.prepareStatement(insertCharacterUnlockedJob)) {
    	insertStmt.setInt(1, character.getCharID());
        insertStmt.setString(2, jobName);
        insertStmt.setInt(3, jobLevel);
        insertStmt.setInt(4, xP);
        insertStmt.executeUpdate();
        return new CharacterUnlockedJob(character, jobName, jobLevel, xP);
      }
	}
  
  /**
   * Get the CharacterUnlockedJob record by fetching it from MySQL instance.
   * This runs a SELECT statement and returns a single CharacterUnlockedJob instance based on charID and jobName.
   */
  public static CharacterUnlockedJob getCharacterUnlockedJobByID(
	Connection cxn,
    int charID
  )  throws SQLException {
     final String selectCharacterUnlockedJob =
       """
       SELECT charID, jobName, jobLevel, XP
       FROM CharacterUnlockedJob 
       WHERE charID = ? AND jobName = ?;
       """;

     try (PreparedStatement selectStmt = cxn.prepareStatement(selectCharacterUnlockedJob)) {
    	  selectStmt.setInt(1, charID);

     try (ResultSet results = selectStmt.executeQuery()) {
        if (results.next()) {
          return new CharacterUnlockedJob(
            CharactersDao.getCharacterByCharID(cxn, results.getInt("charID")),
            results.getString("jobName"),
            results.getInt("jobLevel"),
            results.getInt("XP")
          );
        } else {
          return null;
        }
      }
    }
  }
  
}