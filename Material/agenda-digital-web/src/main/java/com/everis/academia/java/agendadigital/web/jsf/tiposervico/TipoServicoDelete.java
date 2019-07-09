package com.everis.academia.java.agendadigital.web.jsf.tiposervico;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agendadigital.business.ITipoServicoBusiness;
import com.everis.academia.java.agendadigital.business.impl.TipoServicoBusiness;
import com.everis.academia.java.agendadigital.model.TipoServico;

@ManagedBean(name = "tipoServicoDelete")
public class TipoServicoDelete {
	private ITipoServicoBusiness business = new TipoServicoBusiness();
	
	private TipoServico tipoServico = new TipoServico();

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}
	
	public String delete() {
		try {
			business.delete(tipoServico);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, tipoServico.getDescricao(), ": eliminado com sucesso!"));
			return "delete";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao eliminar!", e.getMessage()));
		}
		return null;
	}
}
