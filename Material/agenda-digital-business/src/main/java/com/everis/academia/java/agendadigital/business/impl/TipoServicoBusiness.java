package com.everis.academia.java.agendadigital.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.everis.academia.java.agendadigital.business.BusinessException;
import com.everis.academia.java.agendadigital.business.ITipoServicoBusiness;
import com.everis.academia.java.agendadigital.dao.ITipoServicoDAO;
import com.everis.academia.java.agendadigital.model.TipoServico;

@Service
public class TipoServicoBusiness implements ITipoServicoBusiness {
	
	@Autowired
	private ITipoServicoDAO dao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void create(TipoServico tipoServico) throws BusinessException {

		String descricao = tipoServico.getDescricao();
		
		// Validar se o nome é vazio (regra de negócio)
		if (descricao == null || descricao.trim().isEmpty()) {
			throw new BusinessException("Descrição obrigatória");
		}

		// Validar se existe
		if(dao.jaExisteTipoServico(tipoServico)) {
			throw new BusinessException("Esse tipo de serviço já existe");
		}

		dao.create(tipoServico);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<TipoServico> read() {
		return dao.read();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void update(TipoServico tipoServico) throws BusinessException {

		String descricao = tipoServico.getDescricao();
		
		// Validar se o nome é vazio
		if (descricao == null || descricao.trim().isEmpty()) {
			throw new BusinessException("Descrição obrigatória.");
		}

		// Validar se a descricao já se encontra na lista e se, caso se encontre, não se trate do mesmo
		if(dao.jaExisteTipoServico(tipoServico)) {
			throw new BusinessException("Esse tipo de serviço já existe");
		}
		
		dao.update(tipoServico);
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void delete(TipoServico tipoServico) {
		dao.delete(tipoServico);
	}

}
