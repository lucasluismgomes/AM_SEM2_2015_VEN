package br.com.fiap.am.ltp.beans;

/**
 * Descrição da classe/método
 * @since 1.0
 * @version 1.0
 * @author Lucas 74795
 */
public class Logradouro {
	private int cep;
	private Bairro bairro;
	private TipoLogradouro tipo;
	private String descricao;
	
	public Logradouro() {
		super();
	}

	public Logradouro(int cep, Bairro bairro, TipoLogradouro tipo,
			String descricao) {
		super();
		this.cep = cep;
		this.bairro = bairro;
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public TipoLogradouro getTipo() {
		return tipo;
	}

	public void setTipo(TipoLogradouro tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
