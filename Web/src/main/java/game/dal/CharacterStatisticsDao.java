package game.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import game.model.*;

public class CharacterStatisticsDao {
	
	// create method
	public static CharacterStatistics create(
			Connection cxn, 
			Characters character,
			Statistics statistic,
			int value
			) throws SQLException{
		final String insertCharacterStat = "INSERT INTO characterStatistics (charID, statistics, value) VALUES (?, ?, ?);";

		try (PreparedStatement insertStmt = cxn.prepareStatement(insertCharacterStat)){

			insertStmt.setInt(1, character.getCharID());
			insertStmt.setString(2,  statistic.getStatsName()); 
			insertStmt.setFloat(3, value); 
			insertStmt.executeUpdate();

			return new CharacterStatistics(character,statistic,value);
		}
	}
	
	// getCharacterStatByCharacterAndStat
	// returns the character statistics (character, stat, that value of the given stat)
	// given a particular character and stat (both primary keys)
	public static CharacterStatistics getCharacterStatByCharacterAndStat(
			Connection cxn,
			Characters character,
			Statistics statistic
			) throws SQLException{
		final String getCharacterStat = "SELECT value FROM characterStatistics WHERE charID = ? AND statistics = ?;";
		
		try(PreparedStatement getStmt = cxn.prepareStatement(getCharacterStat)){
			getStmt.setInt(1, character.getCharID());
			getStmt.setString(2, statistic.getStatsName());
			
			try(ResultSet rs = getStmt.executeQuery()){		
				if(rs.next()) {
					return new CharacterStatistics(character, statistic, rs.getInt("value"));			
				}else {
					return null;
				}
			}
		}
	}

}
