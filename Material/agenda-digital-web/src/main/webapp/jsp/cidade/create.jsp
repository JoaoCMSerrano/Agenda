<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<%@include file="header.jsp" %>
	</head>
	<body>
		<form action="<%=request.getContextPath()%>/cidade/createcontroller">
		Criar cidade<br><br>
			<table border="1">
				<tr>
					<td>Nome:</td>
					<td><input type="text" name="nome"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Enviar"> 
						<input type="reset" name="Limpar">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
