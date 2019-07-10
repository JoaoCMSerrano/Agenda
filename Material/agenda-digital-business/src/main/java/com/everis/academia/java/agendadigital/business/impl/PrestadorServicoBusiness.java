package com.everis.academia.java.agendadigital.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.academia.java.agendadigital.business.BusinessException;
import com.everis.academia.java.agendadigital.business.IPrestadorServicoBusiness;
import com.everis.academia.java.agendadigital.dao.IPrestadorServicoDAO;
import com.everis.academia.java.agendadigital.dao.impl.PrestadorServicoDAO;
import com.everis.academia.java.agendadigital.model.PrestadorServico;

@Service
public class PrestadorServicoBusiness implements IPrestadorServicoBusiness {

	@Autowired
	private IPrestadorServicoDAO dao;

	@Override
	public void create(PrestadorServico prestadorServico) throws BusinessException {

		//TODO Falta colocar todas as excepções que se possam prever relativamente à camada de negócio
		
		// Validar se o nome é vazio (regra de negócio)
		if (prestadorServico.getNome() == null || prestadorServico.getNome().trim().isEmpty()) {
			throw new BusinessException("Nome obrigatório");
		}

		// Validar se existe
		if(dao.jaExistePrestadorServico(prestadorServico.getNome())) {
			throw new BusinessException("Esse nome já consta na lista de prestadores de servicos");
		}

		dao.create(prestadorServico);

	}

	@Override
	public Collection<PrestadorServico> read() {
		return dao.read();
	}

	@Override
	public void update(PrestadorServico prestadorServico) throws BusinessException {

		//TODO Falta colocar todas as excepções que se possam prever relativamente à camada de negócio
		
		// Validar se o nome é vazio
		if (prestadorServico.getNome() == null || prestadorServico.getNome().trim().isEmpty()) {
			throw new BusinessException("Descrição obrigatória.");
		}

		// Validar se o nome já se encontra na lista e se não se trata do registo que pretendemos alterar
		for(PrestadorServico ps : PrestadorServicoDAO.prestadoresServico) {
			if(ps.getNome().trim().equalsIgnoreCase(prestadorServico.getNome()) && !(ps.getCodigo()==prestadorServico.getCodigo())) {
				throw new BusinessException("Esse tipo de serviço já existe.");
			}
		}

		dao.update(prestadorServico);

	}

	@Override
	public void delete(PrestadorServico prestadorServico) {
		dao.delete(prestadorServico);

	}

}
