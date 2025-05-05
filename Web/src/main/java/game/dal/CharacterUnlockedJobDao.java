package game.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

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
	Integer jobLevel,
	Integer xP
	) throws SQLException {
	  final String insertCharacterUnlockedJob =
	    "INSERT INTO CharacterUnlockedJob (charID, jobName, jobLevel, XP) VALUES (?, ?, ?, ?);";

      try (PreparedStatement insertStmt = cxn.prepareStatement(insertCharacterUnlockedJob)) {
    	insertStmt.setInt(1, character.getCharID());
        insertStmt.setString(2, jobName);
        
        // Handle null for jobLevel
        if (jobLevel != null) {
            insertStmt.setInt(3, jobLevel);
        } else {
            insertStmt.setNull(3, Types.INTEGER);
        }

        // Handle null for xP
        if (xP != null) {
            insertStmt.setInt(4, xP);
        } else {
            insertStmt.setNull(4, Types.INTEGER);
        }
        insertStmt.executeUpdate();
        
        // Use the null constructor and set values
        CharacterUnlockedJob cuj = new CharacterUnlockedJob(character, jobName);
        if (jobLevel != null) cuj.setJobLevel(jobLevel);
        if (xP != null) cuj.setxP(xP);
        return cuj;
      }
	}
  
  /**
   * Get the CharacterUnlockedJob record by fetching it from MySQL instance.
   * This runs a SELECT statement and returns a single CharacterUnlockedJob instance based on charID and jobName.
   */
  public static CharacterUnlockedJob getCharacterUnlockedJobByID(
	Connection cxn,
    int charID,
    String jobName
  )  throws SQLException {
     final String selectCharacterUnlockedJob =
       """
       SELECT charID, jobName, jobLevel, XP
       FROM CharacterUnlockedJob 
       WHERE charID = ? AND jobName = ?;
       """;

     try (PreparedStatement selectStmt = cxn.prepareStatement(selectCharacterUnlockedJob)) {
    	  selectStmt.setInt(1, charID);
    	  selectStmt.setString(2, jobName);

     try (ResultSet results = selectStmt.executeQuery()) {
        if (results.next()) {
          Integer jobLevel = (Integer) results.getObject("jobLevel");
          Integer xP = (Integer) results.getObject("XP");
          return new CharacterUnlockedJob(
            CharactersDao.getCharacterByCharID(cxn, results.getInt("charID")),
            results.getString("jobName"),
            jobLevel,
            xP
          );
        } else {
          return null;
        }
      }
    }
  }
  
  /**
   * Get the a list of CharacterUnlockedJob record by fetching it from MySQL instance.
   * This runs a SELECT statement and returns a list of CharacterUnlockedJob instance based on charID.
   */
  public static List<CharacterUnlockedJob> getCharacterUnlockedJobByCharID(
	Connection cxn,
    int charID
  )  throws SQLException {
	 List<CharacterUnlockedJob> unlockJobs = new ArrayList<>();
     final String selectCharacterUnlockedJobs =
       """
       SELECT charID, jobName, jobLevel, XP
       FROM CharacterUnlockedJob 
       WHERE charID = ?;
       """;

     try (PreparedStatement selectStmt = cxn.prepareStatement(selectCharacterUnlockedJobs)) {
    	  selectStmt.setInt(1, charID);

	     try (ResultSet results = selectStmt.executeQuery()) {
            while (results.next()) {
            	Integer jobLevel = results.getObject("jobLevel", Integer.class);
            	Integer xP = results.getObject("XP", Integer.class);
            	
                unlockJobs.add(
                  new CharacterUnlockedJob(
                    CharactersDao.getCharacterByCharID(cxn, charID),
                    results.getString("jobName"),
                    jobLevel,
                    xP
                  )
                );
            }
        }
    }
    return unlockJobs;
  }
  
}