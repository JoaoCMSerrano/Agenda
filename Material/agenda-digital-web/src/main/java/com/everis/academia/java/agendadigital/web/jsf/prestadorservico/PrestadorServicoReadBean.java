package com.everis.academia.java.agendadigital.web.jsf.prestadorservico;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agendadigital.business.IPrestadorServicoBusiness;
import com.everis.academia.java.agendadigital.model.PrestadorServico;

@Component("prestadorServicoRead")
@ManagedBean(name = "prestadorServicoRead")
@RequestScope
public class PrestadorServicoReadBean {
	
	@Autowired
	private IPrestadorServicoBusiness business;
	private Collection<PrestadorServico> prestadoresServico;
	
	@PostConstruct
	public void init() {
		this.prestadoresServico = business.read();
	}

	public Collection<PrestadorServico> getPrestadoresServico() {
		return prestadoresServico;
	}

	public void setPrestadoresServico(Collection<PrestadorServico> prestadoresServico) {
		this.prestadoresServico = prestadoresServico;
	}
	
}
