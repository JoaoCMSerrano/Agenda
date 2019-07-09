package com.everis.academia.java.agendadigital.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agendadigital.business.ICidadeBusiness;
import com.everis.academia.java.agendadigital.business.impl.CidadeBusiness;
import com.everis.academia.java.agendadigital.model.Cidade;

@ManagedBean(name = "cidadeDelete")
public class CidadeDelete {
	
	private ICidadeBusiness business = new CidadeBusiness();

	private Cidade cidade = new Cidade();

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String delete(){	
		
		try {
			business.delete(cidade.getCodigo());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, cidade.getNome(), ": eliminado com sucesso!"));
			return "delete";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao eliminar!", e.getMessage()));
		}
		
		return null;
	}

}
