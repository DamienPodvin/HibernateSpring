<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="fr.formation.inti.entities.Employee" %>
    <%@page import="fr.formation.inti.service.EmployeeService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header>
 <jsp:include page="pageNonFiltre/Entete.jsp"/>
 </header>
<form action="valider" method="post">
<p>
			<label>Etes vous sur de vouloir supprimer cet employé ?</label> <br/>
			<input type="radio" name="Yes/No" value="oui" checked> Oui<br>
  			<input type="radio" name="Yes/No" value="non"> Non
		</p>
		<input type="hidden" name="id" value="<%=Integer.parseInt(request.getParameter("idDelete")) %>">
		<% System.out.println("Delete.jsp ================" + request.getAttribute("id")); %>
		<input type="submit" value="Valider">
		</form>
</body>
</html>