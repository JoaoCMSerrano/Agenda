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

@WebServlet(name = "cidade/creatcontroller", urlPatterns = "/cidade/creatcontroller")

public class CidadeCreatController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ICidadeBusiness business = new CidadeBusiness();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// Recuperar dados
			String nome = request.getParameter("nome");

			// Adicionar cidade
			business.create(nome);

			// Imprimir informaçao
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("Registado com sucesso<br>");
			out.println("<br><a href=\"http://localhost:8080/agenda-digital-web/cidade/list\">Voltar para a Lista</a><br>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
