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

@WebServlet(name = "cidadeeditcontroller", urlPatterns = "/cidadeeditcontroller")

public class CidadeEditController extends HttpServlet {
	
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
			out.println("<body>");
			out.println("Modificado com sucesso.<br>");
			out.println("<br><a href=\"http://localhost:8080/agenda-digital-web/cidadelist\">Voltar para a Lista</a><br>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
