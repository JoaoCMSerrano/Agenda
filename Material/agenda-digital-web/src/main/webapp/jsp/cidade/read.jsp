<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.everis.academia.java.agendadigital.model.Cidade" %>
<%@ page import="com.everis.academia.java.agendadigital.business.impl.CidadeBusiness" %>
<%@ page import="com.everis.academia.java.agendadigital.business.ICidadeBusiness" %>

<%! 	
	ICidadeBusiness business = new CidadeBusiness();
%>

<!DOCTYPE html>
	
<html>
	<head>
		<%@include file="header.jsp" %>
	</head>
	<body>
		Lista de Cidades<br>
		<br><a href="<%=request.getContextPath()%>/jsp/cidade/create.jsp">Adicionar nova cidade</a>
		<br><a href="<%=request.getContextPath()%>/cidade/read">Voltar para Servlet</a>
		<br><table border="1">
			<tr>
				<td>Id</td>
				<td>Cidade</td>
				<td>Editar</td>
				<td>Eliminar</td>
			</tr>
			<% for(Cidade cidade : business.read()) { %>
			<tr>
				<td><%=cidade.getCodigo()%></td>
				<td><%=cidade.getNome()%></td>
				<td><a href="<%=request.getContextPath()%>/jsp/cidade/update.jsp?id=<%=cidade.getCodigo()%>&nome=<%=cidade.getNome()%>">X</a></td>
				<td><a href="<%=request.getContextPath()%>/cidade/delete?id=<%=cidade.getCodigo()%>">X</a></td>
			</tr>
			<% } %>
		</table>
	</body>
</html>
