package com.everis.academia.java.agendadigital.dao;

import java.util.Collection;

import com.everis.academia.java.agendadigital.model.TipoServico;

public interface ITipoServicoDAO {
	
	void create(TipoServico tipoServico);
	
	Collection<TipoServico> read();
	
	void update(TipoServico tipoServico);
	
	void delete(TipoServico tipoServico);
	
	Boolean jaExisteTipoServico(String descricao);
	
}

