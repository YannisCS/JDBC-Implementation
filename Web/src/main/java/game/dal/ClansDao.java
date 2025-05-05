package game.dal;

import java.sql.*;
import java.util.*;

import game.model.*;

public class ClansDao {
	/**
	 * create a new Clans record (clanName + race) in the database
	 * @return a Clans object
	 */
	public static Clans create(
			Connection cxn,
			String clanName,
			Clans.Races race
	) throws SQLException {
		String insertDegree = "INSERT INTO Clans (clanName, race) VALUES (?, ?);";
		
		try (PreparedStatement pstmt = cxn.prepareStatement(insertDegree)) {
			pstmt.setString(1,  clanName);
			pstmt.setString(2,  race.name().toLowerCase());
			
			pstmt.executeUpdate();
			
			return new Clans(clanName, race);
		}
	}
	
	/**
	 * retrieves a single record based on pk(clanName)
	 * return an Clans object or null if not found
	 */
	public static Clans getClanRacebyClanName(
			Connection cxn,
			String clanName
	) throws SQLException {
		String query_ClanName = """
				SELECT *
				FROM Clans
				WHERE clanName = ? ;
				""";
		try (PreparedStatement pstmt = cxn.prepareStatement(query_ClanName)) {
			pstmt.setString(1, clanName);
			
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return new Clans(
							clanName,
							Clans.Races.valueOf(rs.getString("race").toUpperCase())
							);
				} else {
					return null;
				}
			}
		}
	}
	
	
	/**
	 * update an existing Clans record (clanName) in the database
	 * returns a Clans object
	 */
	public static Clans updateClanName(
			Connection cxn,
			Clans oldClan,
			String newClanName
	) throws SQLException {
		String query_updateClanName = """
				UPDATE Clans
				SET clanName = ?
				WHERE clanName = ?;
				""";
		
		try (PreparedStatement pstmt = cxn.prepareStatement(query_updateClanName)) {
			pstmt.setString(1, newClanName);
			pstmt.setString(2, oldClan.getClanName());
			
			pstmt.executeUpdate();
			
			return new Clans(
					newClanName,
					oldClan.getRace()
					);
		}
	}
	
	
	/**
	 * delete an existing Clans record
	 */
	public static void deleteClan(
			Connection cxn,
			Clans clan
	) throws SQLException {
		String deleteClan = "DELETE FROM Clans WHERE clanName = ?;";
		
		try (PreparedStatement pstmt = cxn.prepareStatement(deleteClan)) {
			pstmt.setString(1, clan.getClanName());
			pstmt.executeUpdate();
		}
	}
	
	/*
	 * return a list of clans of a specific race
	 */
	public static List<Clans> getClansbyRace(
			Connection cxn,
			Clans.Races race
	) throws SQLException {
		String query_RaceClan = """
				SELECT *
				FROM Clans
				WHERE race = ?;
				""";
		
		List<Clans> clans = new ArrayList<>();
		
		try (PreparedStatement pstmt = cxn.prepareStatement(query_RaceClan)) {
			pstmt.setString(1, race.name().toLowerCase());
			
			try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                String clanName = rs.getString("clanName");
	                Clans.Races clanRace = Clans.Races.valueOf(rs.getString("race").toUpperCase());
	                clans.add(new Clans(clanName, clanRace));
	            }
	        }
		}
		return clans;
	}

}
