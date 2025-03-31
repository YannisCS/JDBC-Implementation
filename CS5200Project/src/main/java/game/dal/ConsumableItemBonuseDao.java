package game.dal;

import game.model.*;

import java.sql.*;

public class ConsumableItemBonuseDao {
	/**
	 * create a new ConsumableItemBonuse record in the database
	 * @return a ConsumableItemBonuse object
	 */
	public static ConsumableItemBonuse create(
			Connection cxn,
			Items item,
			Statistics statistics,
			float bonusePercent,
			int valueCap
	) throws SQLException {
		String insertBonuse = "INSERT INTO ConsumableItemBonuse (itemID, statistics, bonusePercent, valueCap) VALUES (?, ?, ?, ?);";
		
		try (PreparedStatement pstmt = cxn.prepareStatement(insertBonuse)) {
			pstmt.setInt(1, item.getItemID());
			pstmt.setString(2, statistics.getStatsName());
			pstmt.setFloat(3, bonusePercent);
			pstmt.setInt(4, valueCap);
			
			pstmt.executeUpdate();
			
			return new ConsumableItemBonuse (item, statistics, bonusePercent, valueCap);
		}
	}
	
	/**
	 * retrieves a single record based on pk(itemID + statistics)
	 * @return an ConsumableItemBonuse object or null if not found
	 */
	public static ConsumableItemBonuse getBonuseByItemAndStatistics(
			Connection cxn,
			Items item,
			Statistics statistics
	) throws SQLException {
		String query_BonuseByItemAndStatistics = """
				SELECT *
				FROM ConsumableItemBonuse
				WHERE itemID = ? AND statistics = ?;
				""";
		try (PreparedStatement pstmt = cxn.prepareStatement(query_BonuseByItemAndStatistics)) {
			pstmt.setInt(1, item.getItemID());
			pstmt.setString(2, statistics.getStatsName());
			
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return new ConsumableItemBonuse(
							item, 
							statistics, 
							rs.getFloat("bonusePercent"),
							rs.getInt("valueCap")
							);
				} else {
					return null;
				}
			}
		}
	}

}
