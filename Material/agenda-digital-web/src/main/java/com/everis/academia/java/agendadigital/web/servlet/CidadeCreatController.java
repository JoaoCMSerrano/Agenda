package com.everis.academia.java.agendadigital.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agendadigital.model.Cidade;

@WebServlet(name = "cidadecreatcontroller", urlPatterns = "/cidadecreatcontroller")

public class CidadeCreatController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Short id = 0;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		// Recuperar dados
		String nome = request.getParameter("nome");

		// Validar dados
		if (nome == null || nome.trim().isEmpty()) {
			throw new ServletException("Nome obrigat�rio");
		}
		
		// Verificar se j� existe
		for(int i = 0; i < CidadeDao.cidades.size(); i++) {
			if(nome == CidadeDao.cidades.get(i).getNome()) {
				throw new ServletException("O nome inserido j� existe na base de dados");
			}
		}

		// Adicionar cidade
		Cidade cidade = new Cidade();
		cidade.setCodigo(id++);
		cidade.setNome(nome);
		
		CidadeDao.cidades.add(cidade);
		
		// Imprimir informa�ao
		out.write("<html>");
		out.write("<body>");
		out.write("Registado com sucesso<br>");
		out.write("<a href=\"http://localhost:8080/agenda-digital-web/cidadelist\">Voltar para a Lista</a><br>");
		out.write("</body>");
		out.write("</html>");
	}

}