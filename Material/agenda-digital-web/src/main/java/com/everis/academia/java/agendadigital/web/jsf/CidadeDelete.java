package com.everis.academia.java.agendadigital.web.jsf;

import javax.faces.bean.ManagedBean;
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
		business.delete(cidade.getCodigo());
		return "delete";
	}

}
