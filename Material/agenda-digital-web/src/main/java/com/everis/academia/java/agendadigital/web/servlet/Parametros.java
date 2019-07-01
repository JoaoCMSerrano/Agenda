package com.everis.academia.java.agendadigital.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "parametros", urlPatterns = "/parametros")

public class Parametros extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		Integer idade = Integer.valueOf(request.getParameter("idade"));
		Double salario = Double.valueOf(request.getParameter("salario"));
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body bgcolor=\"#FF0000\">");
		out.println("<table border=\"1\">");
		out.println("<tr><td colspan=\"2\">Parametros Recebidos</td></tr>");
		out.println("<tr><td>Nome:</td><td>" + nome + "</td></tr>");
		out.println("<tr><td>Idade:</td><td>" + idade + "</td></tr>");
		out.println("<tr><td>Salario:</td><td>" + salario + "</td></tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");

	}

}