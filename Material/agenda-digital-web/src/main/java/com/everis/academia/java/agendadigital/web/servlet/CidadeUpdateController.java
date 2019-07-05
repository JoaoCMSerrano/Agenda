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

@WebServlet(name = "cidade/updatecontroller", urlPatterns = "/cidade/updatecontroller")

public class CidadeUpdateController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private ICidadeBusiness business = new CidadeBusiness();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		try {
			// Recuperar dados
			Short id = Short.valueOf(request.getParameter("id"));
			String nome = request.getParameter("nome");

			// Modificar nome da cidade
			business.update(new Cidade(id, nome));

			// Imprimir informação
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("<title>Cidade - Update</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("Modificado com sucesso.<br>");
			out.print("<br><a href=\"" + request.getContextPath() + "/cidade/read\">Voltar Servlet</a>");
			out.print("<br><a href=\"" + request.getContextPath() + "/jsp/cidade/read.jsp\">Voltar JSP</a>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
