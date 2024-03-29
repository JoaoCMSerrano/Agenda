package com.everis.academia.java.agendadigital.web.jsf.prestadorservico;

import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agendadigital.business.BusinessException;
import com.everis.academia.java.agendadigital.business.ICidadeBusiness;
import com.everis.academia.java.agendadigital.business.IPrestadorServicoBusiness;
import com.everis.academia.java.agendadigital.model.Cidade;
import com.everis.academia.java.agendadigital.model.PrestadorServico;

@Component("prestadorServicoUpdate")
@ManagedBean(name = "prestadorServicoUpdate")
@RequestScope
public class PrestadorServicoUpdateBean {

	@Autowired
	private IPrestadorServicoBusiness business;
	@Autowired
	private ICidadeBusiness cidadeBusiness;
	
	private PrestadorServico prestadorServico = new PrestadorServico();

	public Collection<Cidade> getCidades() {

		return cidadeBusiness.read();
	}
	
	public PrestadorServico getPrestadorServico() {

		return prestadorServico;
	}

	public void setPrestadorServico(PrestadorServico prestadorServico) {

		this.prestadorServico = prestadorServico;
	}

	public String edit(PrestadorServico prestadorServico){

		this.prestadorServico = prestadorServico;

		return "update";
	}
	
	public String update() throws BusinessException {

		try {
			business.update(prestadorServico);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, prestadorServico.getNome(), ": modificado com sucesso!"));
			return "read";
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao editar!", e.getMessage()));
		}

		return null;
	}
}
