package pt.com.everis.academia.java.agendadigital.model;

public class Cidade {

	private Integer codigo;
	private String nome;

	public Cidade() {
		super();
	}

	public Cidade(Integer codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
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

	@Override
	public String toString() {
		return "Cidade [codigo=" + codigo + ", nome=" + nome + "]";
	}

}
