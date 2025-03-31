package game.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import game.model.*;

public class EquipmentsDao {
	private EquipmentsDao() {}
	
	public static int create(
			Connection cxn,
			String itemName,
			int level,
			int maxStackSize,
			double price,
			int requiredLevel
			) throws SQLException {
		String insertEquipments = """
				INSERT INTO Equipments (itemID, requiredLevel)
				VALUES (?,?);
				""";
		
		try (PreparedStatement insertStmt = cxn.prepareStatement(insertEquipments)) {
			int itemID = ItemsDao.create(cxn,itemName,level,maxStackSize,price);
			insertStmt.setInt(1, itemID);
			insertStmt.setInt(2, requiredLevel);
			insertStmt.executeUpdate();
			
			return itemID;
		}
	}
	
	public static Equipments getEquipmentByItemID(Connection cxn, int itemID) throws SQLException {
		String selectEquipment = """
				SELECT itemName,
					   level,
					   maxStackSize,
					   price,
					   requiredLevel
				FROM Equipments E
				JOIN Items I
				ON E.itemID = I.itemID
				WHERE E.itemID = ?;
				""";
		
		try (PreparedStatement selectStmt = cxn.prepareStatement(selectEquipment)) {
			selectStmt.setInt(1, itemID);
			
			try (ResultSet result = selectStmt.executeQuery()) {
				if (result.next()) {
					return new Equipments(
							itemID,
							result.getString("itemName"),
							result.getInt("level"),
							result.getInt("maxStackSize"),
							result.getDouble("price"),
							result.getInt("requiredLevel"));
				} else {
					return null;
				}
			}
		}
	}
}
