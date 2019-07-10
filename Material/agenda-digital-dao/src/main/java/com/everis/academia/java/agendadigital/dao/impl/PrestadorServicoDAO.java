package com.everis.academia.java.agendadigital.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.everis.academia.java.agendadigital.dao.IPrestadorServicoDAO;
import com.everis.academia.java.agendadigital.enums.TipoLogradouro;
import com.everis.academia.java.agendadigital.model.Cidade;
import com.everis.academia.java.agendadigital.model.PrestadorServico;
import com.everis.academia.java.agendadigital.model.TipoServico;

public class PrestadorServicoDAO implements IPrestadorServicoDAO {

	public static List<PrestadorServico> prestadoresServico = new ArrayList<PrestadorServico>();
	
	private static Integer id = 0;
	
	@Override
	public void create(String nome, Cidade cidade, String bairro, String cep, TipoLogradouro tipoLogradouro,
			String logradouro, String complemento, String numero, String email, Set<TipoServico> servicosCredenciados
			/*, Set<Telefone> telefones, Set<PrestacaoServico> prestacoesServicos*/) {
		
		id++;
	
		PrestadorServico prestadorServico = new PrestadorServico();
		
		prestadorServico.setCodigo(id);
		prestadorServico.setNome(nome);
		prestadorServico.setBairro(bairro);
		prestadorServico.setCep(cep);
		prestadorServico.setTipoLogradouro(tipoLogradouro);
		prestadorServico.setLogradouro(logradouro);
		prestadorServico.setComplemento(complemento);
		prestadorServico.setNumero(numero);
		prestadorServico.setEmail(email);
		prestadorServico.setServicosCredenciados(servicosCredenciados);
//		prestadorServico.setTelefones(telefones);
//		prestadorServico.setPrestacoesServicos(prestacoesServicos);
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
