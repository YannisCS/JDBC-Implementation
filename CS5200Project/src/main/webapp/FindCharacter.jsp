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
  .debug-box {
    background-color: #f0f0f0;
    border: 1px solid #ccc;
    padding: 10px;
    margin: 10px 0;
    font-family: monospace;
  }
</style>
</head>
<body>
<form action="findcharacter" method="get">
<h1>Search by Player last name</h1>
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
</script>

<h1>Matching Characters</h1>
<table border="1">
<tr>
<th>Char First Name</th>
<th>Char Last Name</th>
<th>Player First Name</th>
<th>Player Last Name</th>
<th>Clan</th>
<th>Job</th>
</tr>
<c:forEach items="${characters}" var="character">
<tr>
  <td><c:out value="${character.getFirstName()}" /></td>
  <td><a href="characterdetail?charid=${character.getCharID()}"><c:out value="${character.getLastName()}" /></a></td>
  <td><c:out value="${character.getPlayers().getFirstName()}" /></td>
  <td><c:out value="${character.getPlayers().getLastName()}" /></td>
  <td><c:out value="${character.getClan().getClanName()}" /></td>
  <td><c:out value="${character.getWeaponWeared().getWearableJob()}" /></td>
</tr>
</c:forEach>
</table>

<ul>
  <li><a href="findcharacter">Show All Characters</a></li>
</ul>
</body>
</html>