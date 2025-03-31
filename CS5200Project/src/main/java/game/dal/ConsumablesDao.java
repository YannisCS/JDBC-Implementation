package game.dal;

import game.model.*;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class ConsumablesDao {

	/**
	 * create rows in both Items and Consumables tables
	 */
	public static Consumables create(
			Connection cxn,
			String itemName,
			int level,
			int maxStackSize,
			BigDecimal price,
			String description
	) throws SQLException {
		int itemID = ItemsDao.create(cxn, itemName, level, maxStackSize, price);
		String insertConsumables = "INSERT INTO Consumables (itemID, description) VALUES (?, ?,);";
		
		try (PreparedStatement pstmt = cxn.prepareStatement(insertConsumables)) {
			pstmt.setInt(1, itemID);
			pstmt.setString(2, description);
			
			pstmt.executeUpdate();
			
			return new Consumables(itemID, itemName, level, maxStackSize, price, description);
		}
	}
	
	/**
	 * update an existing Consumables record (description) in the database
	 */
	public static Consumables updateConsumablesDescription(
			Connection cxn,
			Consumables old,
			String newDescription
	) throws SQLException {
		String query_updateConsumables = """
				UPDATE Consumables
				SET description = ?
				WHERE itemID = ?;
				""";
		
		try (PreparedStatement pstmt = cxn.prepareStatement(query_updateConsumables)) {
			pstmt.setString(1, newDescription);
			pstmt.setInt(2, old.getItemID());
			
			pstmt.executeUpdate();
			
			return new Consumables(
					old.getItemID(),
					old.getItemName(),
					old.getLevel(),
					old.getMaxStackSize(),
					old.getPrice(),
					newDescription
					);
		}
	}
	

}
