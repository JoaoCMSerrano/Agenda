package com.everis.academia.java.agendadigital.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.everis.academia.java.agendadigital.dao.ICidadeDAO;
import com.everis.academia.java.agendadigital.model.Cidade;

public class CidadeDAO implements ICidadeDAO {

	public static List<Cidade> cidades = new ArrayList<Cidade>();
	
	private static Short id = 0;
	
	@Override
	public void create(Cidade cidade) {
		
		// Incrementa o id e coloca no registo da cidade
		id++;
		cidade.setCodigo(id);
		
		// Adiciona a cidade
		cidades.add(cidade);
	}

	@Override
	public Collection<Cidade> read() {
		return cidades;
	}

	@Override
	public void update(Cidade cidade) {
		cidades.set(cidades.indexOf(cidade), cidade);
	}

	@Override
	public void delete(Cidade cidade) {
		cidades.remove(cidade);		// Sem loop explicito, sem necessidade de implementaçao de equals
	}

	@Override
	public Boolean jaExisteCidade(String nome) {
		for(Cidade cidade : cidades) {
			if(cidade.getNome().trim().equalsIgnoreCase(nome)) {
				return Boolean.TRUE;
			}		
		}
		
		return Boolean.FALSE;
	}

}
