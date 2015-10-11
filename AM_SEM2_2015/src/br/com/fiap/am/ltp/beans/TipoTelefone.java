package br.com.fiap.am.ltp.beans;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class TipoTelefone {
	private int codigo;
	private String nome;
	
	public TipoTelefone() {
		super();
	}
	
	public TipoTelefone(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeTipo() {
		return nome;
	}

	public void setNomeTipo(String nome) {
		this.nome = nome;
	}
}
