package game.dal;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import game.model.*;

public class CharacterWealthDao {
	
	private CharacterWealthDao() {}
	
	// Create method
	// inserts a new record in the character wealth table
	public static CharacterWealth create(
			Connection cxn, 
			Characters character,
			Currencies currency,
			BigDecimal amount,
			BigDecimal weeklyAcquired
			) throws SQLException{
		final String insertCharacterWealth = "INSERT INTO characterWealth (charID, currencyName, amount, weeklyAcquired) VALUES (?, ?, ?, ?);";

		try (PreparedStatement insertStmt = cxn.prepareStatement(insertCharacterWealth)){

			insertStmt.setInt(1, character.getCharID());
			insertStmt.setString(2,  currency.getCurrencyName()); 
			insertStmt.setBigDecimal(3, amount); 
			insertStmt.setBigDecimal(4, weeklyAcquired);
			insertStmt.executeUpdate();

			return new CharacterWealth(character,currency,amount,weeklyAcquired);
		}
	}

	
	// getCharacterWealthByCharacterAndCurrency
	// returns the character wealth (amount and weekly acquired) given a particular character and currency (both primary keys)
	public static CharacterWealth getCharacterWealthByCharacterAndCurrency(
			Connection cxn,
			Characters character,
			Currencies currency
			) throws SQLException{
		final String getCharacterWealth = "SELECT amount, weeklyAcquired FROM characterWealth WHERE charID = ? AND currencyName = ?;";
		
		try(PreparedStatement getStmt = cxn.prepareStatement(getCharacterWealth)){
			getStmt.setInt(1, character.getCharID());
			getStmt.setString(2, currency.getCurrencyName());
			
			try(ResultSet rs = getStmt.executeQuery()){		
				if(rs.next()) {
					return new CharacterWealth(character, currency, rs.getBigDecimal("amount"), rs.getBigDecimal("weeklyAcquired"));			
				}else {
					return null;
				}
			}
		}
	}
	
	
	// getCharacterWealthByCharacter
	// returns a list of characterWealth a character has, given character
	
	public static List<CharacterWealth> getCharacterWealthByCharacter(
			Connection cxn,
			Characters character
			) throws SQLException{
		
        final String query = "SELECT currencyName, amount, weeklyAcquired FROM characterWealth WHERE charID = ?;";

        List<CharacterWealth> characterWealthList = new ArrayList<>();
        
        try (PreparedStatement stmt = cxn.prepareStatement(query)) {
            stmt.setInt(1, character.getCharID());

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                	Currencies currency = CurrenciesDao.getCurrenciesByName(cxn, rs.getString("currencyName"));
                	
                    characterWealthList.add(new CharacterWealth(character, currency, rs.getBigDecimal("amount"), rs.getBigDecimal("weeklyAcquired")));
                }
            }
        }
		return characterWealthList;
	}
}
