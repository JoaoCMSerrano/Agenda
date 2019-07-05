package com.everis.academia.java.agendadigital.web.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "nomeJSF")
public class NomeJSF {

	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String digaOi() {
		return null;
	}
}
