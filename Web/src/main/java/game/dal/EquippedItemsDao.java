package game.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import game.model.Characters;
import game.model.EquippedItems;
import game.model.Gears;


public class EquippedItemsDao {
	
	private EquippedItemsDao() { }
	

	public static EquippedItems create( Connection cxn,
	           Characters character,
	           String equipmentSlot,
	           Gears gears
	           ) throws SQLException{
		
        String insertInventorySQL = """
                INSERT INTO EquippedItems (charID, equipPosition, itemID) 
                VALUES (?, ?, ?);
            """;

            try (PreparedStatement ps = cxn.prepareStatement(insertInventorySQL)) {
                ps.setInt(1, character.getCharID()); 
                ps.setString(2, equipmentSlot);
                ps.setInt(3, gears.getItemID());
                ps.executeUpdate();
            }

            return new EquippedItems(character.getCharID(), equipmentSlot, gears.getItemID());
	}
	
	
	
	public static EquippedItems getEquippedItemsByCharIDAndSlot( Connection cxn,
			int charID,
			String equipmentSlot
	         ) throws SQLException{
		
       String query = """
             SELECT charID, equipPosition, itemID
             FROM EquippedItems
             WHERE charID = ? AND equipPosition = ?;
         """;

	    try (PreparedStatement selectStmt = cxn.prepareStatement(query)) {
	    	
	      selectStmt.setInt(1, charID); 
	      selectStmt.setString(2, equipmentSlot);  

	      try (ResultSet results = selectStmt.executeQuery()) {
	        if (results.next()) {
	          return new EquippedItems(
	            results.getInt("charID"),
	            results.getString("equipPosition"),
	            results.getInt("itemID")

	          );
	        } else {
	          return null;
	        }
	      }
	    }
	}
	
	
	public static List<EquippedItems> getEquippedItemsOnlyByCharacters( Connection cxn,
			Characters character
	         ) throws SQLException{
		
	     String query = """
	             SELECT charID, equipPosition, itemID
	             FROM EquippedItems
	             WHERE charID = ?;
	         """;

	        List<EquippedItems> equippedItems = new ArrayList<>();

	        try (PreparedStatement ps = cxn.prepareStatement(query)) {
	            ps.setInt(1, character.getCharID()); 

	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                	EquippedItems equippedItem = new EquippedItems(
	                        rs.getInt("charID"),
	        	            rs.getString("equipPosition"),
	                        rs.getInt("itemID")
	                        );
	                	equippedItems.add(equippedItem);
	                }
	    	        return equippedItems; // 如果没有找到数据，返回空列表（而不是 null）
	            }
	        }
	    }
	
	public static EquippedItems updateEquippedItems(Connection cxn, EquippedItems equippedItems, Gears newGear) throws SQLException {

		String updateInventorySQL = """
				    UPDATE EquippedItems
				    SET itemID = ?
				    WHERE charID = ? AND equipPosition = ?;
				""";

		try (PreparedStatement ps = cxn.prepareStatement(updateInventorySQL)) {
			ps.setInt(1, newGear.getItemID());
			ps.setInt(2, equippedItems.getCharID());
			ps.setString(3, equippedItems.getEquipPosition());
		    ps.executeUpdate();
		    equippedItems.setItemID(newGear.getItemID());
		    
		    return equippedItems;
		}
	}
	
	
	public static void delete(Connection cxn, EquippedItems equippedItems) throws SQLException{
	    String deletePerson = "DELETE FROM EquippedItems WHERE  charID = ? AND equipPosition = ?;";

	    try (PreparedStatement deleteStmt = cxn.prepareStatement(deletePerson)) {
	      deleteStmt.setInt(1, equippedItems.getCharID());
	      deleteStmt.setString(2, equippedItems.getEquipPosition());
	      deleteStmt.executeUpdate();
	    }
	}
	

}
