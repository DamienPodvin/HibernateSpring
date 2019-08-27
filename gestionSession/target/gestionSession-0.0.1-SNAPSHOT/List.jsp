<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<title>Hello World!</title>
 <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> 
</head>
<body>
	
	<h1>Liste des employees</h1>
	<table class="table table-bordered table-striped table-sm">
		<tr>
			<th>ID</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Start Date</th>
			<th colspan="2">Action</th>
		</tr>

		<c:forEach items="${list}" var="e">
		
		<tr>
			<td>${e.getEmpId()}</td>
			<td>${e.getFirstName()}</td>
			<td>${e.getLastName()}</td>
			<td>${e.getStartDate()}</td>
			<form action="Test.jsp" method="post">
			<input type="hidden" name="id" value="${e.getEmpId()}">
			<td><button onclick="Test.jsp">Update</button></td>
			</form>
			<form action="Delete.jsp" method="post">
			<input type="hidden" name="idDelete" value="${e.getEmpId()}">
			<td><button type="submit">Delete</button></td>
			</form>

		</tr>
		</c:forEach>
		
	</table>
	
</body>
</html>
