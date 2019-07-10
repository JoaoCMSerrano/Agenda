package com.everis.academia.java.agendadigital.web.jsf.cidade;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.academia.java.agendadigital.business.ICidadeBusiness;
import com.everis.academia.java.agendadigital.model.Cidade;

@Component
@ManagedBean(name = "cidadeRead")
public class CidadeRead {
	
	@Autowired
	private ICidadeBusiness business;
	
	private Collection<Cidade> cidades = null;
	
	//Boa prática: não inicializar o objecto na declaração ou no construtor
	@PostConstruct
	public void init() {
		this.cidades = business.read();
	}

	public Collection<Cidade> getCidades() {

		return cidades;
	}

	public void setCidades(Collection<Cidade> cidades) {

		this.cidades = cidades;
	}
	
}
