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

		// Validar se o nome é vazio
		if (nome == null || nome.trim().isEmpty()) {
			throw new ServletException("Nome obrigatório");
		}
		
		// Validar se existe
		for(Cidade cidade : CidadeDao.cidades) {
			if(cidade.getNome().trim().equalsIgnoreCase(nome)) {
				throw new ServletException("Esse nome de cidade já existe");
			}		
		}

		// Adicionar cidade
		Cidade cidade = new Cidade();
		cidade.setCodigo(id++);
		cidade.setNome(nome);
		
		CidadeDao.cidades.add(cidade);
		
		// Imprimir informaçao
		out.write("<html>");
		out.write("<body>");
		out.write("Registado com sucesso<br>");
		out.write("<a href=\"http://localhost:8080/agenda-digital-web/cidadelist\">Voltar para a Lista</a><br>");
		out.write("</body>");
		out.write("</html>");
	}

}
