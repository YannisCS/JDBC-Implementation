package game.servlet;

import game.dal.*;
import game.model.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update")
public class WeaponUpdate extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String RESPONSE_MESSAGE = "response";

  @Override
  public void doGet(
    HttpServletRequest req,
    HttpServletResponse resp
  ) throws ServletException, IOException {
    handleRequest(req, resp);
  }

  @Override
  public void doPost(
    HttpServletRequest req,
    HttpServletResponse resp
  ) throws ServletException, IOException {
    handleRequest(req, resp);
  }

  private void handleRequest(
    HttpServletRequest req,
    HttpServletResponse resp
  ) throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<>();
    req.setAttribute("messages", messages);

    // Retrieve user and validate.
    String charid = req.getParameter("charid");
    if (charid == null || charid.trim().isEmpty()) {
      messages.put(RESPONSE_MESSAGE, "Not a valid character.");
    } else {
      try (Connection cxn = ConnectionManager.getConnection()) {
        Characters chara =
          CharactersDao.getCharacterByCharID(cxn, Integer.parseInt(charid));
        if (chara == null) {
          messages.put(
            RESPONSE_MESSAGE,
            "Character does not exist."
          );
        } else {
          String weaponName = req.getParameter("weapon");
          if (weaponName == null || weaponName.trim().isEmpty()) {
            messages.put(RESPONSE_MESSAGE, "You do not have this weapon in bag.");
          } else {
        	Weapons weapon = WeaponsDao.getWeaponByWeaponName(cxn, weaponName);
            CharactersDao.updateWeaponWeared(cxn, chara, weapon);
            messages.put(RESPONSE_MESSAGE, "Successfully equiptted " + weapon);
          }
        }
        req.setAttribute("character", chara);
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }

    req.getRequestDispatcher("/WeaponUpdate.jsp").forward(req, resp);
  }
}
