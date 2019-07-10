package com.everis.academia.java.agendadigital.web.jsf.cidade;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agendadigital.business.BusinessException;
import com.everis.academia.java.agendadigital.business.ICidadeBusiness;
import com.everis.academia.java.agendadigital.business.impl.CidadeBusiness;
import com.everis.academia.java.agendadigital.model.Cidade;

@ManagedBean(name = "cidadeCreat")
public class CidadeCreat {

	private Cidade cidade = new Cidade();
	private ICidadeBusiness business = new CidadeBusiness();

	public Cidade getCidade() {

		return cidade;
	}

	public void setNome(Cidade cidade) {

		this.cidade = cidade;
	}

	public String createCidade() {
	
		try {
			business.create(cidade.getNome());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, cidade.getNome(), ": registado com sucesso!"));
			return "read";
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao registar!", e.getMessage()));
		}
		
		return null;
	}
	
	public String cleanCidade() {	//Como fiz inicialmente, poderia ser void mas, dependendo da versão, poderia dar erro
		this.cidade = new Cidade();
		return null;
	}
	
}
