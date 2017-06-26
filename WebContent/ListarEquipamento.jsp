<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="br.com.rcm.model.Equipamento" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Listar equipamentos</title>
	</head>
	<body>
		<a href = "index.html">home</a>
		<% List <Equipamento> equipamentos = (List <Equipamento>) request.getAttribute("Equipamentos");%>
		<table>
			<thead>
				<tr><th>ID</th> <th>Nome</th> <th> Tipo </th> <th> Peso </th></tr>
			</thead>
			<tbody>
				<% for (int i = 0; i < equipamentos.size() ; i++){ %>
					<tr>
						<td><% out.print(equipamentos.get(i).getId()); %></td>
						<td><% out.print(equipamentos.get(i).getNome()); %></td>
						<td><% out.print(equipamentos.get(i).getTipo()); %></td>
						<td><% out.print (equipamentos.get(i).getPeso()); %></td>
					</tr>
				<%}%>
			</tbody>
		</table>
	</body>
</html>