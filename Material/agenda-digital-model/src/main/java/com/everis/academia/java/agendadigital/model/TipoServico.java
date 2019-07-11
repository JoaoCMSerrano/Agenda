package com.everis.academia.java.agendadigital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TIPOSERVICO", schema = "public")
@SequenceGenerator(name = "SQ_TIPOSERVICO", sequenceName = "SQ_TIPOSERVICO", initialValue = 1, allocationSize = 1)
public class TipoServico {
	
	@Id
	@GeneratedValue(generator = "SQ_TIPOSERVICO", strategy = GenerationType.SEQUENCE)
	@Column(name = "COD_TIPOSERVICO", unique = true, nullable = false)
	private Short codigo;
	
	@Column(name = "DESCRICAO_TIPOSERVICO", unique = true, nullable = false, length = 15)
	private String descricao;

	public TipoServico() {
		super();
	}

	public TipoServico(Short codigo) {
		this();
		this.codigo = codigo;
	}

	public TipoServico(Short codigo, String descricao) {
		this(codigo);
		this.descricao = descricao;
	}

	public Short getCodigo() {
		return codigo;
	}

	public void setCodigo(Short codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		TipoServico other = (TipoServico) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "TipoServico [codigo=" + codigo + ", descricao=" + descricao + "]";
	}
		
}
