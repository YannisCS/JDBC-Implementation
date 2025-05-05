package game.servlet;

import game.dal.*;
import game.model.*;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

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
			
			// get sorting parameter
			String sortBy = req.getParameter("sortBy");
			String sortOrder = req.getParameter("sortOrder");
			// default sorting if not not specified
			if (sortBy == null || sortBy.isEmpty() ) {
				sortBy = "playerLastName";
			}
			if (sortOrder == null || sortOrder.isEmpty() ) {
				sortOrder = "asc";
			}
			
			// check if on the initial page load (no parameter) or if doing a search (has parameter)
			if (hasParameter) {
				if (playerLastName != null && !playerLastName.trim().isEmpty()) {
					// non-empty search
					// debugInfo += "Filtering characters by name |";
					characters = getCharactersByPlayerLastName(cxn, playerLastName, sortBy, sortOrder);
					messages.put(
							RESPONSE_MESSAGE, 
							"Displaying characters for player with last name: " + playerLastName
							);	
				} else {
					// empty search
					// debugInfo += "Empty searching term |";
					messages.put(RESPONSE_MESSAGE, "No search term provided. PLease enter a player's last name.");
				}
			} else {
				// initial page - show all characters
				// debugInfo += "Initial page load |";
				characters = CharactersDao.getAllCharacters(cxn, sortBy, sortOrder);
				messages.put(RESPONSE_MESSAGE, "Displaying all characters: ");
			}
			
			req.setAttribute("characters", characters);
			// req.setAttribute("debugInfo", debugInfo);
			req.setAttribute("currentSortBy", sortBy);
			req.setAttribute("currentSortOrder", sortOrder);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		req.getRequestDispatcher("/FindCharacter.jsp").forward(req, resp);
	}
	
	/**
	 * add in pm4
	 * Get all Characters records by similar Player's lastName
	 * @return a list of all characters
	 */

	public static List<Characters> getCharactersByPlayerLastName(
			final Connection cxn,
			final String playerLastName,
			final String sortBy,
		    final String sortOrder
	) throws SQLException {
		  List<Players> players = PlayersDao.getPlayersFromLastName(cxn, playerLastName);
		  
		  List<Integer> playerIDs = players.stream()
				  .map(Players::getPlayerID)
				  .collect(Collectors.toList());
		  
		  return CharactersDao.getCharactersByPlayerIDs(cxn, playerIDs, sortBy, sortOrder);
	  }  	

	
}

