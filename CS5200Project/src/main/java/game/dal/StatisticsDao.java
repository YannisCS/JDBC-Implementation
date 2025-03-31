package game.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import game.model.*;

public class StatisticsDao {

	private StatisticsDao() {}
	
	// Create a statistic given name and description
	public static Statistics create(
			Connection cxn, 
			String statsName, 
			String description
			) throws SQLException{
		final String insertStat = "INSERT INTO statistics (statsName, description) VALUES (?, ?);";

		try (PreparedStatement insertStmt = cxn.prepareStatement(insertStat)){

			insertStmt.setString(1, statsName);
			insertStmt.setString(2,  description); 
			insertStmt.executeUpdate();

			return new Statistics(statsName, description);
		}
	}
	
	// getStatisticsByName
	// retrieve currencyName by currency name (primary key)
	public static Statistics getStatisticsByName(
			Connection cxn,
			String statsName
			) throws SQLException{
		final String getStatistics = "SELECT statsName, description FROM statistics WHERE statsName = ?;";

		try(PreparedStatement getStmt = cxn.prepareStatement(getStatistics)){

			getStmt.setString(1, statsName);

			try(ResultSet rs = getStmt.executeQuery()){		
				if(rs.next()) {
					return new Statistics(statsName,rs.getString("description"));			
				}else {
					return null;
				}
			}
		} 		
	}
}
