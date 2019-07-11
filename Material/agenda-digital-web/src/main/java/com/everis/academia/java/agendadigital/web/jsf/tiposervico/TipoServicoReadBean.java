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
public class TipoServicoReadBean {
	
	@Autowired
	private ITipoServicoBusiness business;

	public Collection<TipoServico> getTiposServico() {
		return business.read();
	}
	
}
