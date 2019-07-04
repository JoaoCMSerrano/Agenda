<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<body>
		<form action="<%=request.getContextPath()%>/cidade/createcontroller">
			<table border="1">
				Criar cidade<br><br>
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
