package com.everis.academia.java.agendadigital.dao;

import java.util.Collection;
import java.util.Set;

import com.everis.academia.java.agendadigital.enums.TipoLogradouro;
import com.everis.academia.java.agendadigital.model.Cidade;
import com.everis.academia.java.agendadigital.model.PrestadorServico;
import com.everis.academia.java.agendadigital.model.TipoServico;

public interface IPrestadorServicoDAO {

	void create(String nome, Cidade cidade, String bairro, String cep, TipoLogradouro tipoLogradouro,
			String logradouro, String complemento, String numero, String email, Set<TipoServico> servicosCredenciados
			/*, Set<Telefone> telefones, Set<PrestacaoServico> prestacoesServicos*/);
	
	Collection<PrestadorServico> read();
	
	void update(PrestadorServico prestadorServico);
	
	void delete(PrestadorServico prestadorServico);
	
	Boolean jaExistePrestadorServico(String nome);
}
