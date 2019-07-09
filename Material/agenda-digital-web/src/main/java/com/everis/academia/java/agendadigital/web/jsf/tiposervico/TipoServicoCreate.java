package com.everis.academia.java.agendadigital.web.jsf.tiposervico;

import com.everis.academia.java.agendadigital.model.TipoServico;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agendadigital.business.BusinessException;
import com.everis.academia.java.agendadigital.business.ITipoServicoBusiness;
import com.everis.academia.java.agendadigital.business.impl.TipoServicoBusiness;

@ManagedBean(name = "tipoServicoCreate")
public class TipoServicoCreate {

	private TipoServico tipoServico = new TipoServico();
	private ITipoServicoBusiness business = new TipoServicoBusiness();
	
	public TipoServico getTipoServico() {
		
		return tipoServico;
	}
	
	public void setTipoServico(TipoServico tipoServico) {

		this.tipoServico = tipoServico;
	}
	
	public String createTipoServico() {
		try {
			business.create(tipoServico.getDescricao());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, tipoServico.getDescricao(), ": registado com sucesso!"));
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao registar!", e.getMessage()));
		}
		return null;
	}
}
