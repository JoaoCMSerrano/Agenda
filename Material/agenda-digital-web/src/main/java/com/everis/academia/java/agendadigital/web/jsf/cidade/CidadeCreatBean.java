package com.everis.academia.java.agendadigital.web.jsf.cidade;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agendadigital.business.BusinessException;
import com.everis.academia.java.agendadigital.business.ICidadeBusiness;
import com.everis.academia.java.agendadigital.model.Cidade;

@Component("cidadeCreat")
@ManagedBean(name = "cidadeCreat")
@RequestScope
public class CidadeCreatBean {

	@Autowired
	private ICidadeBusiness business;
	private Cidade cidade = new Cidade();

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
