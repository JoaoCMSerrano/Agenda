package com.everis.academia.java.agendadigital.model;

public class Cidade {

	private Short codigo;
	private String nome;
	
	public Cidade() {
		super();
	}
	
	public Cidade(Short codigo) {
		this();
		this.codigo = codigo;
	}
	
	public Cidade(Short codigo, String nome) {
		
		this(codigo);
		this.nome = nome;
	}

	public Short getCodigo() {
		return codigo;
	}

	public void setCodigo(Short codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cidade [codigo=" + codigo + ", nome=" + nome + "]";
	}

}
