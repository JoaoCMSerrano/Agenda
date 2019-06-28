package pt.com.everis.academia.java.agendadigital.model;

public class TipoServico {
	private Integer codigo;
	private String descricao;

	public TipoServico() {
		super();
	}

	public TipoServico(Integer codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "TipoServico [codigo=" + codigo + ", descricao=" + descricao + "]";
	}
		
}
