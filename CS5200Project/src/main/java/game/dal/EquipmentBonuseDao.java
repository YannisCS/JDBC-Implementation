package game.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import game.model.*;

public class EquipmentBonuseDao {
	private EquipmentBonuseDao() { }

	  public static EquipmentBonuse create(
	    Connection cxn,
	    Equipments equipment,
	    Statistics stats,
	    int value
	  ) throws SQLException {
	    String insertEquipmentBonuse = """
	    		INSERT INTO EquipmentBonuse (equipmentID,statistics,value)
	    		VALUES (?,?,?);
	    		""";
	    try (PreparedStatement insertStmt = cxn.prepareStatement(insertEquipmentBonuse)) {
	    	insertStmt.setInt(1, equipment.getItemID());
	    	insertStmt.setString(2, stats.getStatsName());
	    	insertStmt.setInt(3, value);
	    	insertStmt.executeUpdate();
	        return new EquipmentBonuse(equipment, stats, value);
	    }
	  }
	  
	  public static EquipmentBonuse getEquipmengBonuseByEquipmentAndStats(
			  Connection cxn,
			  Equipments equipment, Statistics stats
			  ) throws SQLException {
		  String selectEquipmentBonuse = """
		  		SELECT value
		  		FROM EquipmentBonuse
		  		WHERE equipmentID = ? AND statistics = ?;
		  		""";
		  try (PreparedStatement selectStmt = cxn.prepareStatement(selectEquipmentBonuse)) {
			  selectStmt.setInt(1, equipment.getItemID());
			  selectStmt.setString(2, stats.getStatsName());
			  
			  try (ResultSet result = selectStmt.executeQuery()) {
				  if (result.next()) {
					  return new EquipmentBonuse(equipment,stats,result.getInt("value"));
				  } else {
					  return null;
				  }
			  }
		  }
	  }
}
