package game.dal;

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
			float cap, 
			float weeklyCap
			) throws SQLException{
		final String insertCurrencies = "INSERT INTO currencies (currencyName, cap, weeklyCap) VALUES (?, ?, ?);";

		try (PreparedStatement insertStmt = cxn.prepareStatement(insertCurrencies)){

			insertStmt.setString(1, currencyName);
			insertStmt.setFloat(2,  cap); 
			insertStmt.setFloat(3, weeklyCap); 
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
					return new Currencies(currencyName,rs.getFloat("cap"),rs.getFloat("weeklyCap"));			
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
			float newCap
			) throws SQLException{
		final String updateCurrencyCap = "UPDATE currencies SET cap = ? WHERE currencyName = ?;";

		try(PreparedStatement updateStmt = cxn.prepareStatement(updateCurrencyCap)){

			updateStmt.setFloat(1, newCap);
			updateStmt.setString(2, currency.getCurrencyName());

			try(ResultSet rs = updateStmt.executeQuery()){		
				if(rs.next()) {
					return new Currencies(currency.getCurrencyName(),currency.getCap(),currency.getWeeklyCap());			
				}else {
					return null;
				}
			}
		}
	}
}
