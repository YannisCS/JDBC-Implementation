<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Find Characters</title>
		<style>
			body {
		    	font-family: sans-serif;
		    	margin: 30px
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
		<form action="findcharacter" method="get">
			<h1>Search Characters by Player's last name</h1>
			<p>
				<label for="playerlastname">Player last name</label>
				<input id="playerlastname" name="playerlastname" value="${fn:escapeXml(param.playerlastname)}">
				<input type="submit" value="Filter">
				<input type="button" value="Clear" onclick="clearFilter()">
			</p>
			<p>
				<span id="responseMessage"><b>${messages.response}</b></span>
			</p>
		</form>
		
		<script>
			function clearFilter() {
				document.getElementById('playerlastname').value = '';
			  	window.location.href = 'findcharacter';
			}
			
			function showAllCharacters() {
			  	window.location.href = 'findcharacter';
			}
		</script>
		
		<h1>Matching Characters</h1>
		<table>
			<tr>
			<th>Character First Name</th>
			<th>Character Last Name</th>
			<th>Player First Name</th>
			<th>Player Last Name</th>
			<th>Clan</th>
			<th>Job</th>
			</tr>
			<c:forEach items="${characters}" var="character">
			<tr>
			  <td><c:out value="${character.getFirstName()}" /></td>
			  <td><a href="characterdetailreport?charid=${character.getCharID()}"><c:out value="${character.getLastName()}" /></a></td>
			  <td><c:out value="${character.getPlayers().getFirstName()}" /></td>
			  <td><c:out value="${character.getPlayers().getLastName()}" /></td>
			  <td><c:out value="${character.getClan().getClanName()}" /></td>
			  <td><c:out value="${character.getWeaponWeared().getWearableJob()}" /></td>
			</tr>
			</c:forEach>
		</table>
		
		<div class="button-container">
		  <input type="button" value="Show All Characters" onclick="showAllCharacters()">
		</div>
	
	</body>
</html>