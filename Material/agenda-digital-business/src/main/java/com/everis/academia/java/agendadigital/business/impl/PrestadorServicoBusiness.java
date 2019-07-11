package com.everis.academia.java.agendadigital.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.everis.academia.java.agendadigital.business.BusinessException;
import com.everis.academia.java.agendadigital.business.IPrestadorServicoBusiness;
import com.everis.academia.java.agendadigital.dao.IPrestadorServicoDAO;
import com.everis.academia.java.agendadigital.model.PrestadorServico;

@Service
public class PrestadorServicoBusiness implements IPrestadorServicoBusiness {

	@Autowired
	private IPrestadorServicoDAO dao;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void create(PrestadorServico prestadorServico) throws BusinessException {

		//TODO Falta colocar todas as excepções que se possam prever relativamente à camada de negócio

		dao.create(prestadorServico);

	}
	
	@Transactional(readOnly = true)
	@Override
	public Collection<PrestadorServico> read() {
		return dao.read();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void update(PrestadorServico prestadorServico) throws BusinessException {

		//TODO Falta colocar todas as excepções que se possam prever relativamente à camada de negócio
		
		dao.update(prestadorServico);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void delete(PrestadorServico prestadorServico) {
		dao.delete(prestadorServico);

	}

}
