package com.everis.academia.java.agendadigital.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agendadigital.model.Cidade;

@WebServlet(name = "cidadeform", urlPatterns = "/cidadeform")

public class CidadeForm extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private List<Cidade> cidades = new ArrayList<Cidade>();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		cidades.add(new Cidade(Short.valueOf(request.getParameter("id")),request.getParameter("nome")));
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<table border=\"1\">");
//		out.println("Formulário de Cidades<br><br>");
//		out.println("<a href=\"http://localhost:8080/agenda-digital-web/cidadecreat\">Adicionar</a><br>");
//		out.println("<a href=\"http://localhost:8080/agenda-digital-web/cidadelist\">Consultar lista</a>");
		out.println("<table border=\"1\">");
		out.println("<tr><td colspan=\"2\">Cidade Recebida</td></tr>");
		out.println("</table>");
		out.println("</td></tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");

	}

}