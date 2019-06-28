package pt.com.everis.academia.java.agendadigital.model;

public class ServicoPrestado {
	private PrestacaoServico prestacaoServico;
	private TipoServico tipoServico;
	private Double valor;
	
	public ServicoPrestado(){
		super();
	}
	
	public ServicoPrestado(PrestacaoServico prestacaoServico, TipoServico tipoServico, Double valor){
		super();
		this.prestacaoServico = prestacaoServico;
		this.tipoServico = tipoServico;
		this.valor = valor;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "ServicoPrestado [prestacaoServico=" + prestacaoServico + ", tipoServico=" + tipoServico + ", valor="
				+ valor + "]";
	}
	
}
