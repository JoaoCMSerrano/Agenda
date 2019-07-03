package com.everis.academia.java.agendadigital.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cidadeedit", urlPatterns = "/cidadeedit")
public class CidadeEdit extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Recuperar dados
		Short id = Short.valueOf(request.getParameter("id"));
		String nome = request.getParameter("nome");

		// Como alternativa para não ser passado tudo no request, podemos recuperar o nome por:
		//
		// int indexof = CidadeDao.cidades.indexOf(new Cidade(codigo));
		// Cidade cidade = CidadeDao.cidades.get(indexof);
		
		// Imprimir informação
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<form action=\"cidadeeditcontroller\">");
		out.println("<table border=\"1\">");
		out.println("Editar Cidade<br><br>");
		//out.println("<tr><td>Id:</td><td>" + id + "</td></tr>");
		out.println("<tr><td>Id:</td><td><input type=\"text\" name=\"id\" readonly=\"true\" value=\"" + id + "\"</td></tr>");
		out.println("<tr><td>Nome:</td><td><input type=\"text\" name=\"nome\" value=\"" + nome + "\"></td></tr>");
		out.println("</table>");
		out.println("<input type=\"submit\" value=\"Enviar\">");
		out.println("</form>");
		out.println("<br><a href=\"http://localhost:8080/agenda-digital-web/cidadelist\">Voltar para a Lista</a>");
		out.println("</body>");
		out.println("</html>");



	}
}
