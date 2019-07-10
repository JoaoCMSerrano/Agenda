package com.everis.academia.java.agendadigital.web.jsf.exemplos;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloJSF")
public class HelloJSF {

	private String mensagem = "Academistas!";

	public String getMensagem() {

		return mensagem;
	}

	public void setMensagem(String mensagem) {

		this.mensagem = mensagem;
	}

	
}