<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
    Short id = Short.valueOf(request.getParameter("id"));
 	String nome = request.getParameter("nome");
%>
<!DOCTYPE html>
<html>
	<head>
		<%@include file="header.jsp" %>
	</head>
	<body>
			<form action="<%=request.getContextPath()%>/cidade/updatecontroller">
			Editar Cidade<br><br>
			<table border="1">
				<tr>
					<td>Id:</td>
					<td><input type="text" name="id" readonly=readonly value=<%=id%>></td>
				</tr>
				<tr>
					<td>Nome:</td>
					<td><input type="text" name="nome" value=<%=nome%>></td>
				</tr>
			</table>
			<input type="submit" value="Enviar">
		</form>
		<br><a href="<%=request.getContextPath()%>/cidade/read">Voltar Servlet</a>
		<br><a href="<%=request.getContextPath()%>/jsp/cidade/read.jsp">Voltar JSP</a>
	</body>
</html>