package br.com.fiap.am.ltp.beans;

import java.util.Calendar;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class Cliente extends Pessoa {
	private long cpf;
	private long rg;
	private Calendar dtNascimento;
	private int quartoFavorito;
	private String email;
	private String senha;

	public Cliente() {
		super();
	}

	public Cliente(int codigo, String nome, Telefone telefone, Logradouro endereco) {
		super(codigo, nome, telefone, endereco);
	}

	public Cliente(long cpf, long rg, Calendar dtNascimento, int quartoFavorito, String email, String senha) {
		super();
		this.cpf = cpf;
		this.rg = rg;
		this.dtNascimento = dtNascimento;
		this.quartoFavorito = quartoFavorito;
		this.email = email;
		this.senha = senha;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public long getRg() {
		return rg;
	}

	public void setRg(long rg) {
		this.rg = rg;
	}

	public Calendar getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public int getQuartoFavorito() {
		return quartoFavorito;
	}

	public void setQuartoFavorito(int quartoFavorito) {
		this.quartoFavorito = quartoFavorito;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
