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
  </head>
  <h1>${messages.title}</h1>
  <body>
    <h1>Basic Info</h1>
    <ul>
      <li>First Name: ${character.getFirstName()}</>
      <li>Last Name: ${character.getLastName()}</>
    </ul>
    <h1>Equipments</h1>
    <h1>Jobs</h1>
    <h1>Wealth</h1>
    <h1>Inventory</h1>
  </body>
</html>
