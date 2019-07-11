package com.everis.academia.java.agendadigital.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.everis.academia.java.agendadigital.dao.IPrestadorServicoDAO;
import com.everis.academia.java.agendadigital.model.PrestadorServico;

@Repository
public class PrestadorServicoDAO implements IPrestadorServicoDAO {

	public static List<PrestadorServico> prestadoresServico = new ArrayList<PrestadorServico>();
	
	private static Integer id = 0;
	
	@Override
	public void create(PrestadorServico prestadorServico) {
		
		// Incrementa o id e coloca no registo do prestadorServico
		id++;
		prestadorServico.setCodigo(id);
		
		// Adiciona o prestadorServico
		prestadoresServico.add(prestadorServico);
	}

	@Override
	public Collection<PrestadorServico> read() {
		return prestadoresServico;
	}

	@Override
	public void update(PrestadorServico prestadorServico) {
		prestadoresServico.set(prestadoresServico.indexOf(prestadorServico), prestadorServico);
		
	}

	@Override
	public void delete(PrestadorServico prestadorServico) {
		prestadoresServico.remove(prestadorServico);
		
	}

	@Override
	public Boolean jaExistePrestadorServico(String nome) {
		
		//TODO Ver como ei de comparar os prestadores de servico pois o nome não deve ser suficiente
		
		for(PrestadorServico prestadorServico : prestadoresServico) {
			if(prestadorServico.getNome().trim().equalsIgnoreCase(nome)) {
				return Boolean.TRUE;
			}		
		}
		
		return Boolean.FALSE;
	}

}
