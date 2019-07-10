package com.everis.academia.java.agendadigital.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.academia.java.agendadigital.business.BusinessException;
import com.everis.academia.java.agendadigital.business.ICidadeBusiness;
import com.everis.academia.java.agendadigital.dao.ICidadeDAO;
import com.everis.academia.java.agendadigital.dao.impl.CidadeDAO;
import com.everis.academia.java.agendadigital.model.Cidade;

@Service
public class CidadeBusiness implements ICidadeBusiness {

	@Autowired
	private ICidadeDAO dao;
	
	@Override
	public void create(String nome) throws BusinessException {

		// Validar se o nome é vazio (regra de negócio)
		if (nome == null || nome.trim().isEmpty()) {
			throw new BusinessException("Nome obrigatório");
		}

		// Validar se existe
		if(dao.jaExisteCidade(nome)) {
			throw new BusinessException("Esse nome de cidade já existe");
		}

		dao.create(nome);
	}

	@Override
	public Collection<Cidade> read() {
		return dao.read();
	}

	@Override
	public void update(Cidade cidade) throws BusinessException {
		// Validar se o nome é vazio
		if (cidade.getNome() == null || cidade.getNome().trim().isEmpty()) {
			throw new BusinessException("Nome obrigatório.");
		}

		// Validar se o nome já se encontra na lista e se, caso se encontre, não se trate do mesmo
		for(Cidade c : CidadeDAO.cidades) {
			if(c.getNome().trim().equalsIgnoreCase(cidade.getNome()) && !(c.getCodigo()==cidade.getCodigo())) {
				throw new BusinessException("Esse nome de cidade já existe.");
			}
		}
		
		dao.update(cidade);
	}

	@Override
	public void delete(Short id) {
		dao.delete(id);
	}

}
