package com.everis.academia.java.agendadigital.web.jsf.cidade;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agendadigital.business.BusinessException;
import com.everis.academia.java.agendadigital.business.ICidadeBusiness;
import com.everis.academia.java.agendadigital.business.impl.CidadeBusiness;
import com.everis.academia.java.agendadigital.model.Cidade;

@ManagedBean(name = "cidadeUpdate")
public class CidadeUpdate {
	
	private ICidadeBusiness business = new CidadeBusiness();
	
	private Cidade cidade = new Cidade();

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String edit(Cidade cidade){
		
		this.cidade = cidade;
		
		return "update";
	}
	
	public String update() throws BusinessException {
	
		
		try {
			business.update(cidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, cidade.getNome(), ": modificado com sucesso!"));
			return "read";
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao editar!", e.getMessage()));
		}
		
		return null;
	}

}
