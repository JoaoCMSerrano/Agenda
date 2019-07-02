package com.everis.academia.java.agendadigital.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agendadigital.model.Cidade;

@WebServlet(name = "cidadeeditcontroller", urlPatterns = "/cidadeeditcontroller")

public class CidadeEditController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Short id = Short.valueOf(request.getParameter("id"));
		String nome = request.getParameter("nome");

		// Validar se está vazia
		if (nome == null || nome.trim().isEmpty()) {
			throw new ServletException("Nome obrigatório");
		}

		// Validação
		for(Cidade cidade : CidadeDao.cidades) {
			if(cidade.getNome().trim().equalsIgnoreCase(nome) && !(cidade.getCodigo()==id)) {
				throw new ServletException("Esse nome de cidade já existe");
			}		
		}

		// Modificar nome da cidade
		Cidade cidade = new Cidade(id, nome);	
		int index = CidadeDao.cidades.indexOf(cidade);
		CidadeDao.cidades.set(index, cidade);


		// Imprimir informaçao
		PrintWriter out = response.getWriter();
		out.write("<html>");
		out.write("<body>");
		out.write("Modificado com sucesso<br>");
		out.write("<a href=\"http://localhost:8080/agenda-digital-web/cidadelist\">Voltar para a Lista</a><br>");
		out.write("</body>");
		out.write("</html>");

	}
}
