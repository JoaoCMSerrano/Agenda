package com.everis.academia.java.agendadigital.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agendadigital.model.Cidade;

@WebServlet(name = "cidadeedit", urlPatterns = "/cidadeedit")
public class CidadeEdit extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Short id = Short.valueOf(request.getParameter("id"));
		String nome = request.getParameter("nome");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<table border=\"1\">");
		out.println("<tr><td colspan=\"2\">Editar Cidade</td></tr>");
		out.println("<tr><td>Id:</td><td>" + id + "</td></tr>");
		out.println("<tr><td>Nome:</td><td><input type=\"text\" name=\"nome\" value=\"" + nome + "\"></td></tr>");
		out.println("</table>");
		out.println("<td><a href=\"http://localhost:8080/agenda-digital-web/cidadelist\">Voltar para a Lista</a></td>");
		out.println("</body>");
		out.println("</html>");

		// Modificar nome da cidade
		/*
		 * for(int i = 0; i < CidadeDao.cidades.size(); i++) { Cidade cidade =
		 * CidadeDao.cidades.get(i); if(cidade.getCodigo().equals(id)) {
		 * 
		 * } }
		 */
		CidadeDao.cidades.add(new Cidade(id, nome));

		/*
		 * Cidade cidade = new Cidade(); 
		 * cidade.setCodigo(id); 
		 * cidade.setNome(nome);
		 */
	}
}
