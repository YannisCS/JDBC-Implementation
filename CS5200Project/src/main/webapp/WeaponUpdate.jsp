<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Change a weapon</title>
    	<style>
		body {
		    font-family: sans-serif;
		    margin: 30px
		}
		hr {
		  border: 0;
		  border-top: 1px solid LightGray;
		}
		table {
			border-collapse: collapse;
			border: 1px solid #ddd;
		}
		th {
			background-color: LightGray;
			color: black;
			border: 1px solid #ddd;
			padding: 6px;
		}
		td {
			padding: 6px;
			border: 1px solid #ddd;
		}
		tr:hover {
			background-color: #F5F5F5;
		}
		.button-container {
			margin-top: 20px;
		  	margin-bottom: 20px;
		}
		.button-container input {
			padding: 5px 10px;
			margin-right: 10px;
		}
	</style>
  </head>
  <body>
    <h1>Change a weapon</h1>
    <form action="weaponupdate" method="post">
      <p> <strong>Current Weapon for character ${character.getFirstName()} ${character.getLastName()}</strong> </p>
      <p> ${character.getWeaponWeared().getItemName()} </p>
      <p>
        <label for="weapon">Enter the weapon</label>
        <input id="weapon" name="weapon" value="">
      </p>
      <p>
        <input type="submit">
      </p>
    </form>
    <br/><br/>
    <p>
      <span id="responseMessage"><b>${messages.response}</b></span>
    </p>
  </body>
</html>
