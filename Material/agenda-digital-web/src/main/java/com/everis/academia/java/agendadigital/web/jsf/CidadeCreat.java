package com.everis.academia.java.agendadigital.web.jsf;

import javax.faces.bean.ManagedBean;

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

	public String createCidade() throws BusinessException {

		business.create(cidade.getNome());

		return "read";
	}
	
	public String cleanCidade() {	//Como fiz inicialmente, poderia ser void mas, dependendo da versão, poderia dar erro
		this.cidade = new Cidade();
		return null;
	}
	
}
