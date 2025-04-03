package game.dal;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import game.model.*;

public class GearsDao {
	private GearsDao() {}
	
	public static Gears create(
			Connection cxn,
			String itemName,
			int level,
			int maxStackSize,
			BigDecimal price,
			int requiredLevel
			) throws SQLException {
		String insertGears = """
				INSERT INTO Gears (itemID)
				VALUES (?);
				""";
		
		try (PreparedStatement insertStmt = cxn.prepareStatement(insertGears)) {
			int itemID = EquipmentsDao.create(cxn,itemName,level,maxStackSize,price,requiredLevel);
			insertStmt.setInt(1, itemID);
			insertStmt.executeUpdate();
			
			return new Gears(
					itemID,
					itemName,
					level,
					maxStackSize,
					price,
					requiredLevel);
		}
	}
	
	public static Gears getGearByItemID(Connection cxn, int itemID) throws SQLException {
		String selectGear = """
				SELECT itemName,
					   level,
					   maxStackSize,
					   price,
					   requiredLevel
				FROM Gears G
				JOIN Equipments E
				ON G.ItemID = E.ItemID
				JOIN Items I
				ON E.itemID = I.itemID
				WHERE G.itemID = ?;
				""";
		
		try (PreparedStatement selectStmt = cxn.prepareStatement(selectGear)) {
			selectStmt.setInt(1, itemID);
			
			try (ResultSet result = selectStmt.executeQuery()) {
				if (result.next()) {
					return new Gears(
							itemID,
							result.getString("itemName"),
							result.getInt("level"),
							result.getInt("maxStackSize"),
							result.getBigDecimal("price"),
							result.getInt("requiredLevel"));
				} else {
					return null;
				}
			}
		}
	}
}