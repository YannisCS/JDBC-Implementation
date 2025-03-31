package game.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import game.model.*;

public class JobsForGearDao{
  protected JobsForGearDao() {};
	
  /**
   * Save the JobsForGear instance by storing it in MySQL instance.
   * This runs a INSERT statement.
   * This returns a JobsForGear instance.
   */
  public static JobsForGear create(
	Connection cxn,
	Gears gear,
	String job
	) throws SQLException {
	  final String insertJobsForGear =
	    "INSERT INTO JobsForGear (gear, jobName) VALUES (?, ?);";

      try (PreparedStatement insertStmt = cxn.prepareStatement(insertJobsForGear)) {
        insertStmt.setInt(1, gear.getItemID());
        insertStmt.setString(2, job);
        insertStmt.executeUpdate();
        return new JobsForGear(gear, job);
        
      }
	}
  
  /**
   * Get the JobsForGear record by fetching it from MySQL instance.
   * This runs a SELECT statement and returns a single JobsForGear instance based on gear and job.
   */
  public static JobsForGear getJobsForGearByID(
	Connection cxn,
	Gears gear,
	String job
  )  throws SQLException {
     final String selectJobsForGearr =
       """
       SELECT gear, jobName
       FROM JobsForGear 
       WHERE gear = ? AND jobName = ?;
       """;

     try (PreparedStatement selectStmt = cxn.prepareStatement(selectJobsForGearr)) {
    	  selectStmt.setInt(1, gear.getItemID());
    	  selectStmt.setString(2, job);

     try (ResultSet results = selectStmt.executeQuery()) {
        if (results.next()) {
          return new JobsForGear(
            GearsDao.getGearByItemID(cxn, results.getInt("gear")),
            results.getString("jobName")
          );
        } else {
          return null;
        }
      }
    }
  }
  
}