package game.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import game.model.*;

public class WeaponsDao {
	private WeaponsDao() {}
	
	public static Weapons create(
			Connection cxn,
			String itemName,
			int level,
			int maxStackSize,
			double price,
			int requiredLevel,
			String job,
			int damage
			) throws SQLException {
		String insertWeapons = """
				INSERT INTO Weapons (itemID, wearableJob, damage)
				VALUES (?,?,?);
				""";
		
		try (PreparedStatement insertStmt = cxn.prepareStatement(insertWeapons)) {
			int itemID = EquipmentsDao.create(cxn,itemName,level,maxStackSize,price,requiredLevel);
			insertStmt.setInt(1, itemID);
			insertStmt.setString(2, job);
			insertStmt.setInt(3, damage);
			insertStmt.executeUpdate();
			
			return new Weapons(
					itemID,
					itemName,
					level,
					maxStackSize,
					price,
					requiredLevel,
					job,
					damage);
		}
	}
	
	public static Weapons getWeaponByItemID(Connection cxn, int itemID) throws SQLException {
		String selectWeapon = """
				SELECT itemName,
					   level,
					   maxStackSize,
					   price,
					   requiredLevel,
					   wearableJob,
					   damage
				FROM Weapon W
				JOIN Equipments E
				ON W.ItemID = E.ItemID
				JOIN Items I
				ON E.itemID = I.itemID
				WHERE W.itemID = ?;
				""";
		
		try (PreparedStatement selectStmt = cxn.prepareStatement(selectWeapon)) {
			selectStmt.setInt(1, itemID);
			
			try (ResultSet result = selectStmt.executeQuery()) {
				if (result.next()) {
					return new Weapons(
							itemID,
							result.getString("itemName"),
							result.getInt("level"),
							result.getInt("maxStackSize"),
							result.getDouble("price"),
							result.getInt("requiredLevel"),
							result.getString("wearableJob"),
							result.getInt("damage"));
				} else {
					return null;
				}
			}
		}
	}

}
