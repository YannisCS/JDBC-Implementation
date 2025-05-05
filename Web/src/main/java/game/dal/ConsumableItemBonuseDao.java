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
			int itemID,
			String statistics
	) throws SQLException {
		String query_BonuseByItemAndStatistics = """
				SELECT cb.*, s.*, i.itemName, i.level, i.maxStackSize, i.price
				FROM ConsumableItemBonuse cb
				JOIN Statistics s ON cb.statistics = s.statsName
				JOIN Items i ON cb.itemID = i.itemID
				WHERE cb.itemID = ? AND statistics = ?;
				""";
		try (PreparedStatement pstmt = cxn.prepareStatement(query_BonuseByItemAndStatistics)) {
			pstmt.setInt(1, itemID);
			pstmt.setString(2, statistics);
			
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Items item = new Items(
							rs.getInt("itemID"),
							rs.getString("itemName"),
							rs.getInt("level"),
							rs.getInt("maxStackSize"),
							rs.getBigDecimal("price")
							);
					
					Statistics stat = new Statistics(
							rs.getString("statsName"),
							rs.getString("description")
							);
					
					return new ConsumableItemBonuse(
							item, 
							stat, 
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
