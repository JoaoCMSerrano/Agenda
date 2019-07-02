package com.everis.academia.java.agendadigital.web.servlet;


	import java.io.IOException;
	import java.io.PrintWriter;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	@WebServlet(name = "cidadecontroller", urlPatterns = "/cidadecontroller")

	public class CidadeController extends HttpServlet{

		private static final long serialVersionUID = 1L;

		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<table border=\"1\">");
			out.println("Formulário de Cidades<br><br>");
			out.println("<a href=\"http://localhost:8080/agenda-digital-web/cidadecreat\">Adicionar</a><br>");
			
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");

		}
		
		
			//Short id = Short.valueOf(request.getParameter("id"));
			//String nome = request.getParameter("nome");
	}