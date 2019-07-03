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

@WebServlet(name = "cidadecreatcontroller", urlPatterns = "/cidadecreatcontroller")

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
			Cidade cidade = new Cidade();
			cidade.setNome(nome);
			business.create(cidade);

			// Imprimir informa�ao
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("Registado com sucesso<br>");
			out.println("<br><a href=\"http://localhost:8080/agenda-digital-web/cidadelist\">Voltar para a Lista</a><br>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
