package com.everis.academia.java.agendadigital.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		List<String> parametros = new ArrayList<String>();
		parametros.add(request.getParameterNames());
		request.getParameterValues(name);
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
