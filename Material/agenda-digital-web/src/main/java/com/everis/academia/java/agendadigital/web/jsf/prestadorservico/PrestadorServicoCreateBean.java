package com.everis.academia.java.agendadigital.web.jsf.prestadorservico;

import com.everis.academia.java.agendadigital.model.PrestadorServico;
import com.everis.academia.java.agendadigital.model.TipoServico;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agendadigital.business.BusinessException;
import com.everis.academia.java.agendadigital.business.IPrestadorServicoBusiness;
import com.everis.academia.java.agendadigital.business.ITipoServicoBusiness;

@Component("prestadorServicoCreate")
@ManagedBean(name = "prestadorServicoCreate")
@RequestScope
public class PrestadorServicoCreateBean {

	@Autowired
	private IPrestadorServicoBusiness business;
	
	private PrestadorServico prestadorServico = new PrestadorServico();
	
	public PrestadorServico getPrestadorServico() {
		
		return prestadorServico;
	}
	
	public void setPrestadorServico(PrestadorServico prestadorServico) {

		this.prestadorServico = prestadorServico;
	}
	
	public String createTipoServico() {
		try {
			business.create(prestadorServico);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, prestadorServico.getNome(), ": registado com sucesso!"));
			return "read";
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao registar!", e.getMessage()));
		}
		return null;
	}
	
	public String cleanPrestadorServico() {
		this.prestadorServico = new PrestadorServico();
		return null;
	}
	
}
