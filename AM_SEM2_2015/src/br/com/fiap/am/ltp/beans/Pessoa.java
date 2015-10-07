package br.com.fiap.am.ltp.beans;

/**
 * Descrição da classe/método
 * @since 1.0
 * @version 1.0
 * @author Lucas 74795
 */
public class Pessoa {
	private int codigo;
	private String nome;
	private Telefone telefone;
	private Logradouro endereco;
	
	public Pessoa() {
		super();
	}

	public Pessoa(int codigo, String nome, Telefone telefone,
			Logradouro endereco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Logradouro getEndereco() {
		return endereco;
	}

	public void setEndereco(Logradouro endereco) {
		this.endereco = endereco;
	}
}
