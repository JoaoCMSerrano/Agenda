<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
    Short id = Short.valueOf(request.getParameter("id"));
 	String nome = request.getParameter("nome");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
			<form action="<%=request.getContextPath()%>updatecontroller">
			<table border="1">
				Editar Cidade<br><br>
				<tr>
					<td>Id:</td>
					<td><input type="text" name="id" readonly="true" value=<%=id%>></td>
				</tr>
				<tr>
					<td>Nome:</td>
					<td><input type="text" name="nome" value=<%=nome%>></td>
				</tr>
			</table>
			<input type="submit" value="Enviar">
		</form>
		<br>
		<a href="<%=request.getContextPath()%>create.jsp">Voltar</a>
	
	</body>
</html>