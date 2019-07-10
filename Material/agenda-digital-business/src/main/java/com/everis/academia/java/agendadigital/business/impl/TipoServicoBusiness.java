package com.everis.academia.java.agendadigital.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.academia.java.agendadigital.business.BusinessException;
import com.everis.academia.java.agendadigital.business.ITipoServicoBusiness;
import com.everis.academia.java.agendadigital.dao.ITipoServicoDAO;
import com.everis.academia.java.agendadigital.dao.impl.TipoServicoDAO;
import com.everis.academia.java.agendadigital.model.TipoServico;

@Service
public class TipoServicoBusiness implements ITipoServicoBusiness {
	
	@Autowired
	private ITipoServicoDAO dao;
	
	@Override
	public void create(String descricao) throws BusinessException {

		// Validar se o nome � vazio (regra de neg�cio)
		if (descricao == null || descricao.trim().isEmpty()) {
			throw new BusinessException("Descri��o obrigat�ria");
		}

		// Validar se existe
		if(dao.jaExisteTipoServico(descricao)) {
			throw new BusinessException("Esse tipo de servi�o j� existe");
		}

		dao.create(descricao);
		
	}

	@Override
	public Collection<TipoServico> read() {
		return dao.read();
	}

	@Override
	public void update(TipoServico tipoServico) throws BusinessException {
		// Validar se o nome � vazio
		if (tipoServico.getDescricao() == null || tipoServico.getDescricao().trim().isEmpty()) {
			throw new BusinessException("Descri��o obrigat�ria.");
		}

		// Validar se o nome j� se encontra na lista e se, caso se encontre, n�o se trate do mesmo
		for(TipoServico ts : TipoServicoDAO.tiposServico) {
			if(ts.getDescricao().trim().equalsIgnoreCase(tipoServico.getDescricao()) && !(ts.getCodigo()==tipoServico.getCodigo())) {
				throw new BusinessException("Esse tipo de servi�o j� existe.");
			}
		}
		
		dao.update(tipoServico);
		
	}

	@Override
	public void delete(TipoServico tipoServico) {
		dao.delete(tipoServico);
	}

}
