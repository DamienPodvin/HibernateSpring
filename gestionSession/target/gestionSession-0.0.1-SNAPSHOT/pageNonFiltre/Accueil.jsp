    <%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="fr.formation.inti.entities.Employee" %>
    <%@page import="fr.formation.inti.service.EmployeeService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> 
<title>GestionSession</title>
</head>
<body>
 <jsp:include page="Entete.jsp"/>
 			
<%
EmployeeService service = new EmployeeService();
List<Employee> list = service.findAll();
System.out.println("=============apercu de la liste======="+ list);
%> 
	<table class="table table-bordered table-striped table-sm">
		  <thead class="thead-dark">
		<tr>
			<th>ID</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Start Date</th>
			<th colspan="2">Action</th>
		</tr>
</thead>
<% for(Employee e : list) { %>
		
		<tr>
			<td><%=e.getEmpId()%></td>
			<td><%=e.getFirstName()%></td>
			<td><%=e.getLastName()%></td>
			<td><%=e.getStartDate()%></td>
			<form action="Test.jsp" method="post">
			<input type="hidden" name="id" value="${e.getEmpId()}">
			<td><button onclick="Test.jsp">Update</button></td>
			</form>
			<form action="Delete.jsp" method="post">
			<input type="hidden" name="idDelete" value="${e.getEmpId()}">
			<td><button type="submit">Delete</button></td>
			</form>

		</tr>
<% }%>
		
	</table>
</body>
</html>