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
</head>
<body>
<form action="findcharacters" method="post">
<h1>Search by Player last name</h1>
<p>
    <label for="playerlastname">Player last name</label>
    <input id="playerlastname" name="playerlastname" value="${fn:escapeXml(param.playerlastname)}">
    <input type="submit" value="Filter">
</p>
<p>
    <span id="responseMessage"><b>${messages.response}</b></span>
</p>
</form>
<br/>
<div id="characterCreate"><a href="charactercreate">Create New Character</a></div>
<br/>
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
</body>
</html>