<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Equipamento</title>
</head>
<body>
	<a href="index.html">Home</a> <br/>
	<form action="PortaDeEntrada" method="post">
			Nome do equipamento: <input type="text" placeholder="nome" name="nome"/><br/>
			Tipo do equipamento: <input type="text" placeholder="tipo" name="tipo"/><br/>
			Peso do equipamento: <input type="text" placeholder="peso" name="peso"/><br/>
			<input type="submit" name="acao" value="Cadastrar"/><br/>	
		</form>
</body>
</html>