package game.servlet;

import game.dal.*;
import game.model.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/characterdetailreport")
public class CharacterDetailReport extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private static final String TITLE_MESSAGE = "title";


  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<>();
    req.setAttribute("messages", messages);

    // Retrieve character ID
    String charIdStr = req.getParameter("charid");
    if (charIdStr == null || charIdStr.trim().isEmpty()) {
      messages.put(TITLE_MESSAGE, "nvalid Character ID");
    } else {
      messages.put(TITLE_MESSAGE, "Character Detail for " + charIdStr);
    }

    // Retrieve Character, and store in the request.
    try (Connection cxn = ConnectionManager.getConnection()) {
      int charId = Integer.parseInt(charIdStr);
      Characters character = CharactersDao.getCharacterByCharID(cxn, charId);
      if (character == null) {
          messages.put(TITLE_MESSAGE, "No character found with ID: " + charId);
          req.getRequestDispatcher("/FindCharacter.jsp").forward(req, resp);
          return;
      }
      
      // Get character unlocked jobs
      List<CharacterUnlockedJob> unlockedJobs = new ArrayList<>();
      unlockedJobs = CharacterUnlockedJobDao.getCharacterUnlockedJobByCharID(cxn, charId);
      
      // Get character wealth
      List<CharacterWealth> wealthList = CharacterWealthDao.getCharacterWealthByCharacter(cxn, character);
      
      
      //Get Gears
      List<Gears> gearList = new ArrayList<Gears>();
      // first Get EquippedItems
      List<EquippedItems> equippedItems = EquippedItemsDao.getEquippedItemsOnlyByCharacters(cxn, character);
      for(EquippedItems eachItem:equippedItems) {
          Gears gear = GearsDao.getGearByItemID(cxn, eachItem.getItemID());
          gearList.add(gear);

      }
      
      //get Inventory 
      List<Inventory>  inventoryList = new ArrayList<Inventory>();
      inventoryList = InventoryDao.getInventoryOnlyByCharacters(cxn, character);
      
      //get Item Name from ItemId
      List<String> itemNameList = new ArrayList<String>();
      for(Inventory inven:inventoryList) {
    	  itemNameList.add(ItemsDao.getNameByItemID(cxn,inven.getInstance()));
      }
      
      req.setAttribute("character", character);
      req.setAttribute("unlockedJobs", unlockedJobs);
      req.setAttribute("characterWealthList", wealthList);
      req.setAttribute("gearList", gearList);
      req.setAttribute("inventoryList", inventoryList);
      req.setAttribute("itemNameList", itemNameList);

      
      messages.put(TITLE_MESSAGE, character.getFirstName() + " " + character.getLastName());
      
      req.getRequestDispatcher("/CharacterDetailReport.jsp").forward(req, resp);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new IOException(e);
    }
  }
 
  
}
