package com.everis.academia.java.agendadigital.web.jsf.tiposervico;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agendadigital.business.BusinessException;
import com.everis.academia.java.agendadigital.business.ITipoServicoBusiness;
import com.everis.academia.java.agendadigital.business.impl.TipoServicoBusiness;
import com.everis.academia.java.agendadigital.model.TipoServico;

@ManagedBean(name = "tipoServicoUpdate")
public class TipoServicoUpdate {
	
	private ITipoServicoBusiness business = new TipoServicoBusiness();
	private TipoServico tipoServico = new TipoServico();
	
	public TipoServico getTipoServico() {
		
		return tipoServico;
	}
	
	public void setTipoServico(TipoServico tipoServico) {

		this.tipoServico = tipoServico;
	}
	
public String edit(TipoServico tipoServico){
		
		this.tipoServico = tipoServico;
		
		return "update";
	}
public String update() throws BusinessException {
	
	
	try {
		business.update(tipoServico);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, tipoServico.getDescricao(), ": modificado com sucesso!"));
		return "read";
	} catch (BusinessException e) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao editar!", e.getMessage()));
	}
	
	return null;
}
}
