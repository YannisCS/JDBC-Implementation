package game.dal;

import java.sql.*;

import game.model.*;

public class ClansDao {
	/**
	 * create a new Clans record (clanName + race) in the database
	 * @return a Clans object
	 */
	public static Clans create(
			Connection cxn,
			String clanName,
			Clans.Races race
	) throws SQLException {
		String insertDegree = "INSERT INTO Clans (clanName, race) VALUES (?, ?);";
		
		try (PreparedStatement pstmt = cxn.prepareStatement(insertDegree)) {
			pstmt.setString(1,  clanName);
			pstmt.setString(2,  race.name().toLowerCase());
			
			pstmt.executeUpdate();
			
			return new Clans(clanName, race);
		}
	}
	
	/**
	 * update an existing Clans record
	 * 
	 * change raceName (pk) == delete exist , add new (lots of )
	 * add enum race?
	 */
	
	
	
	/**
	 * delete an existing Clans record
	 */

}
