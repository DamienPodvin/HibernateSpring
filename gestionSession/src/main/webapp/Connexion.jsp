<%@page import="fr.formation.inti.entities.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connecté ! </title>
</head>
<body>
<header>
 <jsp:include page="pageNonFiltre/Entete.jsp"/>
 </header>

      <br>
         <br>

<p> Bonjour ${emp.firstName}<p>

<form id=logout action="logout">
			<input type="submit" value="Logout" >
</form>
</body>
</html>