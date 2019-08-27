<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
*<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css"/>
<title>Login</title>
</head>
<body>
<header>
 <jsp:include page="Entete.jsp"/></header>

	<form class="formulaire" method="post" action="login">
	<p>
			<label for="text">Pseudo</label>
			<input type="text" name="pseudo" placeholder="exemple" id="text"> 
		</p>
		<p>
			<label>password</label>
			<input type="password" name="mdp">
		</p>
		<p>
			<label>Login :</label>
			<input type="submit" value="Ok" >
		</p>
		</form>
</body>
</html>