package pt.com.everis.academia.java.agendadigital.model;

import java.util.Date;

public class PrestacaoServico {
	private Integer codigo;
	private Date data;
	private PrestadorServico prestador;
	
	public PrestacaoServico(Integer codigo, Date data, PrestadorServico prestador) {
		this.codigo = codigo;
		this.data = data;
		this.prestador = prestador;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public PrestadorServico getPrestador() {
		return prestador;
	}

	public void setPrestador(PrestadorServico prestador) {
		this.prestador = prestador;
	}


	@Override
	public String toString() {
		return "PrestacaoServico [codigo=" + codigo + ", data=" + data + ", prestador=" + prestador + "]";
	}
	
}
