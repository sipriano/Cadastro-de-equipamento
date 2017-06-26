<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="br.com.rcm.model.Equipamento" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Equipamento cadastrado</title>
	</head>
	<body>
		<a href="index.html">Home</a> <br/> 
		<% Equipamento equi = (Equipamento) request.getAttribute("l"); %>
		Equipamento com id <% out.print(equi.getId()); %>  inserido com sucesso.
	</body>
</html>