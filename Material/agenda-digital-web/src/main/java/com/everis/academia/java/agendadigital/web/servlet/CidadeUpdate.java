package com.everis.academia.java.agendadigital.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cidade/update", urlPatterns = "/cidade/update")
public class CidadeUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Recuperar dados
		Short id = Short.valueOf(request.getParameter("id"));
		String nome = request.getParameter("nome");

		// Como alternativa para n�o ser passado tudo no request, podemos recuperar o nome por:
		//
		// int indexof = CidadeDao.cidades.indexOf(new Cidade(codigo));
		// Cidade cidade = CidadeDao.cidades.get(indexof);
		
		// Imprimir informa��o
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Cidade - Update</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"updatecontroller\">");
		out.println("<table border=\"1\">");
		out.println("Editar Cidade<br><br>");
		out.println("<tr><td>Id:</td><td><input type=\"text\" name=\"id\" readonly=\"true\" value=\"" + id + "\"</td></tr>");
		out.println("<tr><td>Nome:</td><td><input type=\"text\" name=\"nome\" value=\"" + nome + "\"></td></tr>");
		out.println("</table>");
		out.println("<input type=\"submit\" value=\"Enviar\">");
		out.println("</form>");
		out.print("<a href=\"" + request.getContextPath() + "/cidade/read\">Voltar Servlet</a><br>");
		out.print("<a href=\"" + request.getContextPath() + "/jsp/cidade/read.jsp\">Voltar JSP</a><br>");
		out.println("</body>");
		out.println("</html>");



	}
}
