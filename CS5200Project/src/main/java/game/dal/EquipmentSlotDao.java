package game.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import game.model.EquipmentSlot;



public class EquipmentSlotDao {
	
	public static EquipmentSlot create( Connection cxn,
	        String bodyPartName
	      ) throws SQLException{
		
	    String insertEquipmentSlot = "INSERT INTO EquipmentSlot (bodyPartName) VALUES (?);";
	    
	    try (PreparedStatement insertStmt = cxn.prepareStatement(insertEquipmentSlot)) {
	    	
	        insertStmt.setString(1, bodyPartName);
	        insertStmt.executeUpdate();
	        return new EquipmentSlot(bodyPartName);
	      }
	}
	
	public static void delete(Connection cxn, String bodyPartName) throws SQLException{
	    String deletePerson = "DELETE FROM EquipmentSlot WHERE bodyPartName = ?;";

	    try (PreparedStatement deleteStmt = cxn.prepareStatement(deletePerson)) {
	      deleteStmt.setString(1, bodyPartName);
	      deleteStmt.executeUpdate();
	    }
		
	}
	

}
