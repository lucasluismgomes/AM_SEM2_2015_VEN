package br.com.fiap.am.ltp.beans;

/**
 * Descrição da classe/método
 * @since 1.0
 * @version 1.0
 * @author Lucas 74795
 */
public class FormaPagamento {
	private int codigo;
	private String descricao;
	
	public FormaPagamento() {
		super();
	}

	public FormaPagamento(int codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
