package com.everis.academia.java.agendadigital.business;

import java.util.Collection;

import com.everis.academia.java.agendadigital.model.PrestadorServico;

public interface IPrestadorServicoBusiness {
	void create(PrestadorServico prestadorServico) throws BusinessException;

	Collection<PrestadorServico> read();

	void update(PrestadorServico prestadorServico) throws BusinessException;

	void delete(PrestadorServico prestadorServico);
}
