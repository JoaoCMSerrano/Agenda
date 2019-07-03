package com.everis.academia.java.agendadigital.dao;

import java.util.Collection;
import com.everis.academia.java.agendadigital.model.Cidade;

public interface ICidadeDAO {
	
	void create(Cidade cidade);
	
	Collection<Cidade> read();
	
	void update(Cidade cidade);
	
	void delete(Cidade cidade);
	
	Boolean jaExisteCidade(String nome);
	
}
