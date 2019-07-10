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

		//TODO Falta colocar todas as excep��es que se possam prever relativamente � camada de neg�cio
		
		// Validar se o nome � vazio (regra de neg�cio)
		if (prestadorServico.getNome() == null || prestadorServico.getNome().trim().isEmpty()) {
			throw new BusinessException("Nome obrigat�rio");
		}

		// Validar se existe
		if(dao.jaExistePrestadorServico(prestadorServico.getNome())) {
			throw new BusinessException("Esse nome j� consta na lista de prestadores de servicos");
		}

		dao.create(prestadorServico);

	}

	@Override
	public Collection<PrestadorServico> read() {
		return dao.read();
	}

	@Override
	public void update(PrestadorServico prestadorServico) throws BusinessException {

		//TODO Falta colocar todas as excep��es que se possam prever relativamente � camada de neg�cio
		
		// Validar se o nome � vazio
		if (prestadorServico.getNome() == null || prestadorServico.getNome().trim().isEmpty()) {
			throw new BusinessException("Descri��o obrigat�ria.");
		}

		// Validar se o nome j� se encontra na lista e se n�o se trata do registo que pretendemos alterar
		for(PrestadorServico ps : PrestadorServicoDAO.prestadoresServico) {
			if(ps.getNome().trim().equalsIgnoreCase(prestadorServico.getNome()) && !(ps.getCodigo()==prestadorServico.getCodigo())) {
				throw new BusinessException("Esse tipo de servi�o j� existe.");
			}
		}

		dao.update(prestadorServico);

	}

	@Override
	public void delete(PrestadorServico prestadorServico) {
		dao.delete(prestadorServico);

	}

}
