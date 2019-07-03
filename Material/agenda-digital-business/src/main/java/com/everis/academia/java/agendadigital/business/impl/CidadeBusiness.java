package com.everis.academia.java.agendadigital.business.impl;

import java.util.Collection;

import com.everis.academia.java.agendadigital.business.BusinessException;
import com.everis.academia.java.agendadigital.business.ICidadeBusiness;
import com.everis.academia.java.agendadigital.dao.ICidadeDAO;
import com.everis.academia.java.agendadigital.dao.impl.CidadeDAO;
import com.everis.academia.java.agendadigital.model.Cidade;

public class CidadeBusiness  implements ICidadeBusiness {

	private ICidadeDAO dao = new CidadeDAO();

	@Override
	public void create(Cidade cidade) throws BusinessException {

		// Validar se o nome � vazio (regra de neg�cio)
		if (cidade.getNome() == null || cidade.getNome().trim().isEmpty()) {
			throw new BusinessException("Nome obrigat�rio");
		}

		// Validar se existe
		if(dao.jaExisteCidade(cidade.getNome())) {
			throw new BusinessException("Esse nome de cidade j� existe");
		}

		dao.create(cidade);
	}

	@Override
	public Collection<Cidade> read() {
		return dao.read();
	}

	@Override
	public void update(Cidade cidade) throws BusinessException {
		// Validar se o nome � vazio
		if (cidade.getNome() == null || cidade.getNome().trim().isEmpty()) {
			throw new BusinessException("Nome obrigat�rio.");
		}

		// Validar se o nome j� se encontra na lista e se, caso se encontre, n�o se trate do mesmo
		for(Cidade c : CidadeDAO.cidades) {
			if(c.getNome().trim().equalsIgnoreCase(cidade.getNome()) && !(c.getCodigo()==cidade.getCodigo())) {
				throw new BusinessException("Esse nome de cidade j� existe.");
			}
		}
		
		dao.update(cidade);
	}

	@Override
	public void delete(Cidade cidade) {
		dao.delete(cidade);
	}

}
