package com.everis.academia.java.agendadigital.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.everis.academia.java.agendadigital.enums.TipoLogradouro;

@Entity
@Table(name = "TB_PRESTADORSERVICO", schema = "public")
@SequenceGenerator(name = "SQ_PRESTADORSERVICO", sequenceName = "SQ_PRESTADORSERVICO", initialValue = 1, allocationSize = 1)
public class PrestadorServico {

	@Id
	@GeneratedValue(generator = "SQ_PRESTADORSERVICO", strategy = GenerationType.SEQUENCE)
	@Column(name = "COD_PS", unique = true, nullable = false)
	private Integer codigo;
	
	@Column(name = "NOME_PS", unique = true, nullable = false, length = 50)
	private String nome;
	
	@Transient
	private Cidade cidade;
	
	@Column(name = "BAIRRO_PS", unique = true, nullable = false, length = 30)
	private String bairro;
	
	@Column(name = "CEP_PS", unique = true, nullable = false)
	private String cep;
	
	@Transient
	private TipoLogradouro tipoLogradouro;
	
	@Column(name = "LOGRADOURO_PS", unique = true, nullable = false)
	private String logradouro;
	
	@Column(name = "COMPLEMENTO_PS", unique = true, nullable = false, length = 50)
	private String complemento;
	
	@Column(name = "NUMERO_PS", unique = true, nullable = false)
	private String numero;
	
	@Column(name = "EMAIL_PS", unique = true, nullable = false)
	private String email;
	
	@Transient
	private Set<Telefone> telefones;
	
	@Transient
	private Set<TipoServico> servicosCredenciados;
	
	@Transient
	private Set<PrestacaoServico> prestacoesServicos;
	
	public PrestadorServico() {
		super();
	}

	public PrestadorServico(Integer codigo) {
		
		this();
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Set<TipoServico> getServicosCredenciados() {
		return servicosCredenciados;
	}

	public void setServicosCredenciados(Set<TipoServico> servicosCredenciados) {
		this.servicosCredenciados = servicosCredenciados;
	}

	public Set<PrestacaoServico> getPrestacoesServicos() {
		return prestacoesServicos;
	}

	public void setPrestacoesServicos(Set<PrestacaoServico> prestacoesServicos) {
		this.prestacoesServicos = prestacoesServicos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrestadorServico other = (PrestadorServico) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
