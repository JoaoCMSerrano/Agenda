package com.everis.academia.java.agendadigital.dao;

import java.util.Collection;
import com.everis.academia.java.agendadigital.model.Cidade;

public interface ICidadeDAO {
	
	void create(String nome);
	
	Collection<Cidade> read();
	
	void update(Cidade cidade);
	
	void delete(Short id);
	
	Boolean jaExisteCidade(String nome);
	
}
