package com.everis.academia.java.agendadigital.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cidade/create", urlPatterns = "/cidade/create")

public class CidadeCreate extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Cidade - Create</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"createcontroller\">");
		out.println("<table border=\"1\">");
		out.println("Criar cidade<br><br>");
		out.println("<tr><td>Nome:</td><td><input type=\"text\" name=\"nome\"></td></tr>");
		out.println("<tr><td colspan=\"2\" align=\"center\">");
		out.println("<input type=\"submit\" value=\"Enviar\">");
		out.println("<input type=\"reset\" name=\"Limpar\">");
		out.println("</td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

}
