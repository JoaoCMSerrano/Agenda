package com.everis.academia.java.agendadigital.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.everis.academia.java.agendadigital.dao.ICidadeDAO;
import com.everis.academia.java.agendadigital.model.Cidade;

public class CidadeSetDAO implements ICidadeDAO{
	
	public static Set<Cidade> cidades = new HashSet<Cidade>();
	
	private static Short id = 0;
	
	@Override
	public void create(String nome) {
		// Incrementa o id e coloca no registo da cidade
		id++;
		
		// Adiciona a cidade
		cidades.add(new Cidade(id,nome));
		
	}

	@Override
	public Collection<Cidade> read() {
		return cidades;
	}

	@Override
	public void update(Cidade cidade) {
		CidadeDAO.cidades.remove(new Cidade(cidade.getCodigo()));
		CidadeDAO.cidades.add(cidade);
	}

	@Override
	public void delete(Short id2) {
		cidades.remove(new Cidade(id2));
		
	}

	@Override
	public Boolean jaExisteCidade(Cidade cidade) {
		for(Cidade c : cidades) {
			if(c.getNome().trim().equalsIgnoreCase(cidade.getNome())) {
				return Boolean.TRUE;
			}		
		}
		
		return Boolean.FALSE;
	}
}
