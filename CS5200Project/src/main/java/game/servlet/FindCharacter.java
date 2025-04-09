package game.servlet;

import game.dal.*;
import game.model.*;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FindCharacter is the primary entry point into the application.
 * all user to search for game characters by player's lastName
 */
@WebServlet("/findcharacter")
public class FindCharacter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Message label for response messages
	private static final String RESPONSE_MESSAGE = "response";

	@Override
	public void doGet(
			HttpServletRequest req,
			HttpServletResponse resp
	) throws ServletException, IOException {
		// debug info
		// String debugInfo = "Method: GET |";
		
		// for get requests, always show all characters
		handleRequest(
				req, 
				resp 
				//, debugInfo
				);
	}

	@Override
	public void doPost(
			HttpServletRequest req,
			HttpServletResponse resp
	) throws ServletException, IOException {
		// String debugInfo = "Method: POST |";
		// for post requests, filter characters if a search term is provided
		handleRequest(
				req, 
				resp
				//, debugInfo
				);
	}
	
	private void handleRequest(
			HttpServletRequest req,
			HttpServletResponse resp
			// String debugInfo
	) throws ServletException, IOException {
		// Map for storing messages
		Map<String, String> messages = new HashMap<>();
		req.setAttribute("messages", messages);
		
		try (Connection cxn = ConnectionManager.getConnection()) {
			List<Characters> characters = new ArrayList<>();
			
			// retrieve the player last name
			String playerLastName = req.getParameter("playerlastname");
			// debugInfo += "Parameter: " + (playerLastName == null ? "null" : "'" + playerLastName + "'") + " | ";
			
			boolean hasParameter = req.getParameterMap().containsKey("playerlastname");
			// debugInfo += "Has Parameter: " + hasParameter + " | ";
			
			// check if on the initial page load (no parameter) or if doing a search (has parameter)
			if (hasParameter) {
				if (playerLastName != null && !playerLastName.trim().isEmpty()) {
					// non-empty search
					// debugInfo += "Filtering characters by name |";
					characters = getCharactersByPlayerLastName(cxn, playerLastName);
					messages.put(RESPONSE_MESSAGE, "Displaying characters for player with last name: " + playerLastName);	
				} else {
					// empty search
					// debugInfo += "Empty seach term |";
					messages.put(RESPONSE_MESSAGE, "No search term provided. PLease enter a player's last name.");
				}
			} else {
				// initial page - show all characters
				// debugInfo += "Initial page load |";
				characters = CharactersDao.getAllCharacters(cxn);
				messages.put(RESPONSE_MESSAGE, "Displaying all characters");
			}
			
			req.setAttribute("characters", characters);
			// req.setAttribute("debugInfo", debugInfo);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		req.getRequestDispatcher("/FindCharacter.jsp").forward(req, resp);
	}
	
	
	/**
	 * Get all Characters records by similar Player's lastName
	 * @return a list of all characters
	 */
	private List<Characters> getCharactersByPlayerLastName(
			Connection cxn,
			String playerLastName
	) throws SQLException {
		  List<Characters> result = new ArrayList<>();
		  List<Players> players = PlayersDao.getPlayersFromLastName(cxn, playerLastName);
		  for (Players p : players) {
			  List<Characters> characters = CharactersDao.getCharactersByPlayer(cxn, p);
			  result.addAll(characters);
		  }
		  return result;
	  }	  
}

