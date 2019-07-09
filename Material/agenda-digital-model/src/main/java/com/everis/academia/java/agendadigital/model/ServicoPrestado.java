package com.everis.academia.java.agendadigital.model;

import com.everis.academia.java.agendadigital.model.TipoServico;

public class ServicoPrestado {
	
	private Integer codigo;
	private PrestacaoServico prestacaoServico;
	private TipoServico tipoServico;
	private Float valor;
	
	public ServicoPrestado(){
		super();
	}
	
	public PrestacaoServico getPrestacaoServico() {
		return prestacaoServico;
	}

	public void setPrestacaoServico(PrestacaoServico prestacaoServico) {
		this.prestacaoServico = prestacaoServico;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Integer getCodigo() {
		return codigo;
	}
	

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	

	@Override
	public String toString() {
		return "ServicoPrestado [codigo=" + codigo + "prestacaoServico=" + prestacaoServico + ", tipoServico=" 
				+ tipoServico + ", valor=" + valor + "]";
	}
	
}
