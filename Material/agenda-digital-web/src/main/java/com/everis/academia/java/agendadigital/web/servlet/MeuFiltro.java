package com.everis.academia.java.agendadigital.web.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "MeuFiltro", urlPatterns = "/cidade/*")

public class MeuFiltro implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		long tempoInicial = System.currentTimeMillis();
		chain.doFilter(request, response);
		long tempoFinal = System.currentTimeMillis();
		String uri = ((HttpServletRequest) request).getRequestURI();
		System.out.println("Tempo da requisicao de " + uri + " demorou (ms): " + (tempoFinal-tempoInicial));
		 */

		chain.doFilter(request, response);

		//Imprimir o recurso
		String uri = ((HttpServletRequest) request).getRequestURI();
		System.out.println("Página: " + uri);

		//Imprimir os parametros
		Map<String, String[]> parametros = request.getParameterMap();
		for (Entry<String, String[]> map : parametros.entrySet()) {
			System.out.println(map.getKey() + ": " + Arrays.toString(map.getValue()));
		}
		
		/*
		while(request.getAttributeNames().hasMoreElements()) {
			
			String nome = request.getAttributeNames().nextElement();
			String valor = request.getParameter(nome);
			
			System.out.println(nome + ": "+ valor);
					
		}
		*/
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
