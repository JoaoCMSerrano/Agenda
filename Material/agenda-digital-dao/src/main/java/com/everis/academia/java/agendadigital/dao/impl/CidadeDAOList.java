package com.everis.academia.java.agendadigital.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.everis.academia.java.agendadigital.dao.ICidadeDAO;
import com.everis.academia.java.agendadigital.model.Cidade;

public class CidadeDAOList implements ICidadeDAO {

	public static List<Cidade> cidades = new ArrayList<Cidade>();
	
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
		cidades.set(cidades.indexOf(cidade), cidade);
	}

	@Override
	public void delete(Short id2) {
		cidades.remove(new Cidade(id2));		// Necessidade de implementaçao de equals
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
