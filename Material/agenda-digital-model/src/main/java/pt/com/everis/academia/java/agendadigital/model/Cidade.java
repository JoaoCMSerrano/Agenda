package pt.com.everis.academia.java.agendadigital.model;

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
	public String toString() {
		return "Cidade [codigo=" + codigo + ", nome=" + nome + "]";
	}

}
