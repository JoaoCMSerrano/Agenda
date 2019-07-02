package com.everis.academia.java.agendadigital.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agendadigital.model.Cidade;

@WebServlet(name = "cidadelist", urlPatterns = "/cidadelist")

public class CidadeList extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<table border=\"1\">");
		out.println("Formulário de Cidades<br><br>");
		out.println("<a href=\"http://localhost:8080/agenda-digital-web/cidadecreat\">Adicionar</a><br>");
		out.println("<tr><td>Id</td><td>Cidade</td><td>Editar</td><td>Eliminar</td></tr>");
		for(Cidade cidade : CidadeDao.cidades) {
			out.write("<tr><td>" + cidade.getCodigo() + "</td>");
			out.write("<td>" + cidade.getNome() + "</td>");
			out.write("<td><a href=\"http://localhost:8080/agenda-digital-web/cidadeedit?id=" + cidade.getCodigo() + "&nome=" + cidade.getNome() +"\">X</a></td>");
			out.write("<td><a href=\"http://localhost:8080/agenda-digital-web/cidadedelete?id=" + cidade.getCodigo() + "&nome=" + cidade.getNome() + "\">X</a></td></tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}
