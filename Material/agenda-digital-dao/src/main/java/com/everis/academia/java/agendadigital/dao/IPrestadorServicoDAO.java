package com.everis.academia.java.agendadigital.dao;

import java.util.Collection;

import com.everis.academia.java.agendadigital.model.PrestadorServico;

public interface IPrestadorServicoDAO {

	void create(PrestadorServico prestadorServico);
	
	Collection<PrestadorServico> read();
	
	void update(PrestadorServico prestadorServico);
	
	void delete(PrestadorServico prestadorServico);
	
	Boolean jaExistePrestadorServico(String nome);
}
