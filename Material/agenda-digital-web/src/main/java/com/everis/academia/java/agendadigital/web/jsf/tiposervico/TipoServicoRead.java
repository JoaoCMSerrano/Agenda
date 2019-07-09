package com.everis.academia.java.agendadigital.web.jsf.tiposervico;

import java.util.Collection;

import javax.faces.bean.ManagedBean;

import com.everis.academia.java.agendadigital.business.ITipoServicoBusiness;
import com.everis.academia.java.agendadigital.business.impl.TipoServicoBusiness;
import com.everis.academia.java.agendadigital.model.TipoServico;

@ManagedBean(name = "tipoServicoRead")
public class TipoServicoRead {
	private ITipoServicoBusiness business = new TipoServicoBusiness();
	
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
