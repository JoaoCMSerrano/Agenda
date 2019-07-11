package com.everis.academia.java.agendadigital.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.everis.academia.java.agendadigital.business.BusinessException;
import com.everis.academia.java.agendadigital.business.ICidadeBusiness;
import com.everis.academia.java.agendadigital.dao.ICidadeDAO;
import com.everis.academia.java.agendadigital.model.Cidade;

@Service
public class CidadeBusiness implements ICidadeBusiness {

	@Autowired
	private ICidadeDAO dao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void create(Cidade cidade) throws BusinessException {
		String nome = cidade.getNome();
		// Validar se o nome é vazio (regra de negócio)
		if (nome == null || nome.trim().isEmpty()) {
			throw new BusinessException("Nome obrigatório");
		}

		// Validar se existe
		if(dao.jaExisteCidade(cidade)) {
			throw new BusinessException("Esse nome de cidade já existe");
		}

		dao.create(nome);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Cidade> read() {
		return dao.read();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void update(Cidade cidade) throws BusinessException {
		// Validar se o nome é vazio
		if (cidade.getNome() == null || cidade.getNome().trim().isEmpty()) {
			throw new BusinessException("Nome obrigatório.");
		}

		// Validar se o nome já se encontra na lista e se, caso se encontre, não se trate do mesmo
		if(dao.jaExisteCidade(cidade)) {
			throw new BusinessException("Esse nome de cidade já existe");
		}
		
		/* Ciclo anterior de validação do nome já existente
		 * for(Cidade c : CidadeDAO.cidades) {
		 * if(c.getNome().trim().equalsIgnoreCase(cidade.getNome()) &&
		 * !(c.getCodigo()==cidade.getCodigo())) { throw new
		 * BusinessException("Esse nome de cidade já existe."); } }
		 */
		
		dao.update(cidade);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void delete(Short id) {
		dao.delete(id);
	}

}
