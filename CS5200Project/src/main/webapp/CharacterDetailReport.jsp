<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Character</title>
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
    <h1>${messages.title}</h1>
    <hr>
    <h2>Basic Info</h2>
    <p><strong>Player: </strong> ${character.getPlayers().getFirstName()} ${character.getPlayers().getLastName()} (${character.getPlayers().getEmailAddress()})</p>
	<p><strong>Clan: </strong> ${character.getClan().getClanName()}</p>
	<p><strong>Job: </strong> ${character.getWeaponWeared().getWearableJob()}</p>
    <hr>
    
    <h2>Equipments</h2>
    <hr>
    
    <h2>Jobs</h2>
    <c:choose>
    	<c:when test="${empty unlockedJobs}">
    		<p>No jobs unlocked for this character.</p>
    	</c:when>
    	<c:otherwise>
    		<table>
				<tr>
					<th>Job Name</th>
					<th>Job Level</th>
					<th>XP</th>
					<th>Status</th>
				</tr>
				<c:forEach items="${unlockedJobs}" var="job">
				<tr>
				  <td><c:out value="${job.getJob()}" /></td>
				  <td>
					  <c:choose>
			              <c:when test="${job.getJobLevel() != null}">
			                ${job.getJobLevel()}
			              </c:when>
			              <c:otherwise>
			                --
			              </c:otherwise>
			          </c:choose>
			      </td>
			      <td>
			          <c:choose>
			              <c:when test="${job.getxP() != null}">
			                ${job.getxP()}
			              </c:when>
			              <c:otherwise>
			                --
			              </c:otherwise>
			          </c:choose>
			      </td>
			      <td>
					  <c:choose>
			              <c:when test="${job.getJobLevel() != null}">
			                Unlocked
			              </c:when>
			              <c:otherwise>
			                Locked
			              </c:otherwise>
			          </c:choose>
			      </td>
				</tr>
				</c:forEach>
			</table>
    	</c:otherwise>
    </c:choose>
		
    <hr>
    
    <h2>Wealth</h2>
<table border="1">
    <tr>
        <th>Currency</th>
        <th>Amount</th>
        <th>Weekly Acquired</th>
    </tr>
    <c:forEach var="wealth" items="${characterWealthList}">
        <tr>
            <td>${wealth.currency.currencyName}</td>
            <td>${wealth.amount}</td>
            <td>${wealth.weeklyAcquired}</td>
        </tr>
    </c:forEach>
</table>
    <hr>
    
    <h2>Inventory</h2>
    
    <div class="button-container">
  		<input type="button" value="Back to Find Characters" onclick="window.location.href='findcharacter'">
	</div>
  </body>
  
</html>
