package com.everis.academia.java.agendadigital.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.everis.academia.java.agendadigital.dao.ITipoServicoDAO;
import com.everis.academia.java.agendadigital.model.TipoServico;

@Repository
public class TipoServicoDAO implements ITipoServicoDAO{

	public static List<TipoServico> tiposServico = new ArrayList<TipoServico>();
	
	private static Short id = 0;
	
	@Override
	public void create(String descricao) {

		// Incrementa o id e coloca no registo do tipoServico
		id++;
		
		// Adiciona o tipoServico
		tiposServico.add(new TipoServico(id,descricao));
	}

	@Override
	public Collection<TipoServico> read() {
		return tiposServico;
	}

	@Override
	public void update(TipoServico tipoServico) {
		tiposServico.set(tiposServico.indexOf(tipoServico), tipoServico);
	}

	@Override
	public void delete(TipoServico tipoServico) {
		tiposServico.remove(tipoServico);
		
	}

	@Override
	public Boolean jaExisteTipoServico(String descricao) {
		for(TipoServico tipoServico : tiposServico) {
			if(tipoServico.getDescricao().trim().equalsIgnoreCase(descricao)) {
				return Boolean.TRUE;
			}		
		}
		
		return Boolean.FALSE;
	}

}