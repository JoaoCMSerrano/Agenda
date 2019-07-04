package com.everis.academia.java.agendadigital.business;

import java.util.Collection;
import com.everis.academia.java.agendadigital.model.Cidade;

public interface ICidadeBusiness {

	void create(String nome) throws BusinessException;

	Collection<Cidade> read();

	void update(Cidade cidade) throws BusinessException;

	void delete(Short id);

}
