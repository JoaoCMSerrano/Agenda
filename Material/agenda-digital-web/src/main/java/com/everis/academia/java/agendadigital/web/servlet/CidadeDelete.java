package com.everis.academia.java.agendadigital.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agendadigital.model.Cidade;

@WebServlet(name = "cidadedelete", urlPatterns = "/cidadedelete")
public class CidadeDelete extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Imprimir informação
		Short id = Short.valueOf(request.getParameter("id"));
		String nome = request.getParameter("nome");
		
		// Eliminar a cidade da lista
		CidadeDao.cidades.remove(new Cidade(id,nome));		//Necessita equals no Cidade
		
		// CidadeDao.cidades.remove(new Cidade(id,nome));	//Alternativa: sem loop explicito, sem necessidade de implementaçao de equals
		
		// Imprimir informação
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Eliminado com sucesso<br>");
		out.println("<br><a href=\"http://localhost:8080/agenda-digital-web/cidadelist\">Voltar para a Lista</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
