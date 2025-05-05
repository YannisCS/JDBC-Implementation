package game.dal;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import game.model.*;

public class CurrenciesDao {

	private CurrenciesDao() {}

	// Create currency in the currency table
	// Assumes currencyName is NOT NULL
	public static Currencies create(
			Connection cxn, 
			String currencyName, 
			BigDecimal cap, 
			BigDecimal weeklyCap
			) throws SQLException{
		final String insertCurrencies = "INSERT INTO currencies (currencyName, cap, weeklyCap) VALUES (?, ?, ?);";

		try (PreparedStatement insertStmt = cxn.prepareStatement(insertCurrencies)){

			insertStmt.setString(1, currencyName);
			insertStmt.setBigDecimal(2,  cap); 
			insertStmt.setBigDecimal(3, weeklyCap); 
			insertStmt.executeUpdate();

			return new Currencies(currencyName,cap,weeklyCap);
		}
	}



	// retrieve currencyName by currency name (primary key)
	public static Currencies getCurrenciesByName(
			Connection cxn,
			String currencyName
			) throws SQLException{
		final String getCurrency = "SELECT currencyName, cap, weeklyCap FROM currencies WHERE currencyName = ?;";

		try(PreparedStatement getStmt = cxn.prepareStatement(getCurrency)){

			getStmt.setString(1, currencyName);

			try(ResultSet rs = getStmt.executeQuery()){		
				if(rs.next()) {
					return new Currencies(currencyName,rs.getBigDecimal("cap"),rs.getBigDecimal("weeklyCap"));			
				}else {
					return null;
				}
			}
		} 		
	}

	// update given currency's cap with new cap
	public static Currencies updateCap(
	        Connection cxn,
	        Currencies currency,
	        BigDecimal newCap
	) throws SQLException {
	    final String updateCurrencyCap = "UPDATE currencies SET cap = ? WHERE currencyName = ?;";

	    try (PreparedStatement updateStmt = cxn.prepareStatement(updateCurrencyCap)) {
	        updateStmt.setBigDecimal(1, newCap);
	        updateStmt.setString(2, currency.getCurrencyName());

	        int rowsAffected = updateStmt.executeUpdate();
	        if (rowsAffected > 0) {
	            return new Currencies(currency.getCurrencyName(), newCap, currency.getWeeklyCap());
	        } else {
	            return null;
	        }
	    }
	}
}
