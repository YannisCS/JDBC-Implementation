package game.dal;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import game.model.*;


public class ItemsDao {
	
	protected ItemsDao() { }

	public static int create(
		    Connection cxn,
		    String itemName, 
		    int level, 
		    int maxStackSize,
		    BigDecimal price
			) throws SQLException{
		
	    final String insertItems = """
	    	      INSERT INTO Items (itemName, level, maxStackSize, price) VALUES (?, ?, ?, ?);
	    		""";
	    try(PreparedStatement insertStmt = cxn.prepareStatement(insertItems, Statement.RETURN_GENERATED_KEYS)){
	    	
	        insertStmt.setString(1, itemName);
	        insertStmt.setInt(2, level);
	        insertStmt.setInt(3, maxStackSize);
	        insertStmt.setBigDecimal(4, price);

	        insertStmt.executeUpdate();
	        
	        try (ResultSet rs = insertStmt.getGeneratedKeys()) {
	            if (rs.next()) {
	              return rs.getInt(1);
	            } else {
	              throw new SQLException("Unable to retrieve auto-generated key");
	            }
	          }

	    }
		
	}
	
	
	public static String getNameByItemID(Connection cxn, int itemID) throws SQLException {
		String selectItem = """
				SELECT itemName
				FROM Items 
				WHERE itemID = ?;
				""";
		
		try (PreparedStatement selectStmt = cxn.prepareStatement(selectItem)) {
			selectStmt.setInt(1, itemID);
			
			try (ResultSet result = selectStmt.executeQuery()) {
				if (result.next()) {
					return result.getString("itemName");
				} else {
					return null;
				}
			}
		}
	}
	
	
	public static void delete(Connection cxn, Items item) throws SQLException{
	    String deleteItems = "DELETE FROM Items WHERE itemID = ?;";

	    try (PreparedStatement deleteStmt = cxn.prepareStatement(deleteItems)) {
	      deleteStmt.setInt(1, item.getItemID());
	      deleteStmt.executeUpdate();
	    }
		
	}
	

}
