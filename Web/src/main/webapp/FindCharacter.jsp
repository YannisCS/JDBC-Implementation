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
				position: relative; /* For positioning sort indicators */
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
			.sort-indicator {
			  	margin-left: 5px;
			}
			.sort-container {
			  	margin: 15px 0;
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
			function applySort() {
				  // Get the current values from the dropdowns
				  const sortBy = document.getElementById('sortBy').value;
				  const sortOrder = document.getElementById('sortOrder').value;
				  
				  // Get the current player last name (if any)
				  const playerLastName = document.getElementById('playerlastname').value;
				  
				  // Build the URL with sorting parameters
				  let url = 'findcharacter?sortBy=' + sortBy + '&sortOrder=' + sortOrder;
				  
				  // Add the player last name parameter if it exists
				  if (playerLastName && playerLastName.trim() !== '') {
				    url += '&playerlastname=' + encodeURIComponent(playerLastName);
				  }
				  
				  // Redirect to the new URL
				  window.location.href = url;
			}
		</script>
		
		<div class="sort-container">
		  <label for="sortBy">Sort by:</label>
		  <select id="sortBy" name="sortBy">
		    <option value="">-- Select Field --</option>
		    <option value="characterFirstName" ${currentSortBy == 'characterFirstName' ? 'selected' : ''}>Character First Name</option>
		    <option value="characterLastName" ${currentSortBy == 'characterLastName' ? 'selected' : ''}>Character Last Name</option>
		    <option value="playerFirstName" ${currentSortBy == 'playerFirstName' ? 'selected' : ''}>Player First Name</option>
		    <option value="playerLastName" ${currentSortBy == 'playerLastName' ? 'selected' : ''}>Player Last Name</option>
		    <option value="clan" ${currentSortBy == 'clan' ? 'selected' : ''}>Clan</option>
		    <option value="job" ${currentSortBy == 'job' ? 'selected' : ''}>Job</option>
		  </select>
		
		  <label for="sortOrder">Order:</label>
		  <select id="sortOrder" name="sortOrder">
		    <option value="">-- Select Order --</option>
		    <option value="asc" ${currentSortOrder == 'asc' ? 'selected' : ''}>Ascending</option>
		    <option value="desc" ${currentSortOrder == 'desc' ? 'selected' : ''}>Descending</option>
		  </select>
		  
		  <input type="button" value="Apply Sort" onclick="applySort()">
		</div>
		
		<h1>Matching Characters</h1>
		<table>
		<tr>
		  <th>Character First Name 
		    <c:if test="${currentSortBy == 'characterFirstName'}">
		      <c:choose>
		        <c:when test="${currentSortOrder == 'asc'}"><span>[ASC]</span></c:when>
		        <c:otherwise><span>[DESC]</span></c:otherwise>
		      </c:choose>
		    </c:if>
		  </th>
		  <th>Character Last Name 
		    <c:if test="${currentSortBy == 'characterLastName'}">
		      <c:choose>
		        <c:when test="${currentSortOrder == 'asc'}"><span>[ASC]</span></c:when>
		        <c:otherwise><span>[DESC]</span></c:otherwise>
		      </c:choose>
		    </c:if>
		  </th>
		  <th>Player First Name 
		    <c:if test="${currentSortBy == 'playerFirstName'}">
		      <c:choose>
		        <c:when test="${currentSortOrder == 'asc'}"><span>[ASC]</span></c:when>
		        <c:otherwise><span>[DESC]</span></c:otherwise>
		      </c:choose>
		    </c:if>
		  </th>
		  <th>Player Last Name 
		    <c:if test="${currentSortBy == 'playerLastName'}">
		      <c:choose>
		        <c:when test="${currentSortOrder == 'asc'}"><span>[ASC]</span></c:when>
		        <c:otherwise><span>[DESC]</span></c:otherwise>
		      </c:choose>
		    </c:if>
		  </th>
		  <th>Clan 
		    <c:if test="${currentSortBy == 'clan'}">
		      <c:choose>
		        <c:when test="${currentSortOrder == 'asc'}"><span>[ASC]</span></c:when>
		        <c:otherwise><span>[DESC]</span></c:otherwise>
		      </c:choose>
		    </c:if>
		  </th>
		  <th>Job 
		    <c:if test="${currentSortBy == 'job'}">
		      <c:choose>
		        <c:when test="${currentSortOrder == 'asc'}"><span>[ASC]</span></c:when>
		        <c:otherwise><span>[DESC]</span></c:otherwise>
		      </c:choose>
		    </c:if>
		  </th>
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