<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css"/>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<title>GestionSession</title>
</head>
<body>
	<header id="header">
		<h3>Gestion De Session</h3>
			
			<ul id= "menu">
				<li class="menu_p">
					<a href="${pageContext.request.contextPath}/pageNonFiltre/Accueil.jsp">Accueil</a>
				</li>
				<li class="menu_p"><a href="${pageContext.request.contextPath}/pageNonFiltre/Inscription.jsp">S'inscrire</a></li>
				<li class="menu_p"><a href="${pageContext.request.contextPath}/pageNonFiltre/Login.jsp">Login</a></li>
			</ul>
			</header>
</body>
</html>