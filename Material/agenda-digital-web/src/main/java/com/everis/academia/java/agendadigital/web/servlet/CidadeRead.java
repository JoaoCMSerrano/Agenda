package com.everis.academia.java.agendadigital.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agendadigital.business.ICidadeBusiness;
import com.everis.academia.java.agendadigital.business.impl.CidadeBusiness;
import com.everis.academia.java.agendadigital.model.Cidade;

@WebServlet(name = "cidade/read", urlPatterns = "/cidade/read")

public class CidadeRead extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private ICidadeBusiness business = new CidadeBusiness();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<table border=\"1\">");
			out.println("Lista de Cidades<br><br>");
			out.println("<a href=\"http://localhost:8080/agenda-digital-web/cidade/create\">Adicionar</a><br>");
			out.println("<tr><td>Id</td><td>Cidade</td><td>Editar</td><td>Eliminar</td></tr>");
			for(Cidade cidade : business.read()) {
				out.println("<tr><td>" + cidade.getCodigo() + "</td>");
				out.println("<td>" + cidade.getNome() + "</td>");
				out.println("<td><a href=\"http://localhost:8080/agenda-digital-web/cidade/update?id=" + cidade.getCodigo() + "&nome=" + cidade.getNome() + "\">X</a></td>");
				out.println("<td><a href=\"http://localhost:8080/agenda-digital-web/cidade/delete?id=" + cidade.getCodigo() + "\">X</a></td></tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			throw new ServletException(e);
		}


	}

}
