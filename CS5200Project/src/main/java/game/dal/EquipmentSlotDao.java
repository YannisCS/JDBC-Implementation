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
	

}
