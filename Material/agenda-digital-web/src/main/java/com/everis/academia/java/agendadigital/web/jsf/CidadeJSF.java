package com.everis.academia.java.agendadigital.web.jsf;

import javax.faces.bean.ManagedBean;

import com.everis.academia.java.agendadigital.business.BusinessException;
import com.everis.academia.java.agendadigital.business.ICidadeBusiness;
import com.everis.academia.java.agendadigital.business.impl.CidadeBusiness;

@ManagedBean(name = "cidadeJSF")
public class CidadeJSF {

	private String nome;
	private ICidadeBusiness business = new CidadeBusiness();
	
	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public String createCidade() {
		try {
			business.create(nome);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
