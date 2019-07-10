package com.everis.academia.java.agendadigital.web.jsf.tiposervico;

import java.util.Collection;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agendadigital.business.ITipoServicoBusiness;
import com.everis.academia.java.agendadigital.model.TipoServico;

@Component("tipoServicoRead")
@ManagedBean(name = "tipoServicoRead")
@RequestScope
public class TipoServicoRead {
	
	@Autowired
	private ITipoServicoBusiness business;
	
	private Collection<TipoServico> tiposServico = null;
	
	public void init() {
		this.tiposServico = business.read();
	}

	public Collection<TipoServico> getTiposServico() {
		return tiposServico;
	}

	public void setTiposServico(Collection<TipoServico> tiposServico) {
		this.tiposServico = tiposServico;
	}
	
}
