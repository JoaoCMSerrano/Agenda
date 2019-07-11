package com.everis.academia.java.agendadigital.business;

import java.util.Collection;

import com.everis.academia.java.agendadigital.model.TipoServico;

public interface ITipoServicoBusiness {
	void create(TipoServico tipoServico) throws BusinessException;

	Collection<TipoServico> read();

	void update(TipoServico tipoServico) throws BusinessException;

	void delete(TipoServico tipoServico);
}
