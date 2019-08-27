<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css"/>
<title>Inscription</title>
</head>
<body>

 <jsp:include page="Entete.jsp"/>

	
<form class="formulaire" action="reg" method="post">

		<p>
			<label for="text">Nom</label>
			<input type="text" name="nom" placeholder="exemple" id="text"> 
		</p>
		<p>
			<label for="text">Prenom</label>
			<input type="text" name="prenom" placeholder="exemple" id="text"> 
		</p>
			<p>
			<label>DateDeNaissance</label>
			<input type="date" name="Date">
		</p>

		
		<p>
			<label>submit</label>
			<input type="submit">
		</p>
		
			</form>
</body>
</html>