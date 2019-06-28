package pt.com.everis.academia.java.agendadigital.model;

public class Telefone {
	
	private Integer codigo;
	private Integer ddd;
	private Integer numero;

	public Telefone() {
		super();
	}
	
	public Telefone(Integer codigo, Integer ddd, Integer numero) {
		super();
		this.codigo = codigo;
		this.ddd = ddd;
		this.numero = numero;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	@Override
	public String toString() {
		return "Telefone [codigo=" + codigo + ", ddd=" + ddd + ", numero=" + numero + "]";
	}
	
}
