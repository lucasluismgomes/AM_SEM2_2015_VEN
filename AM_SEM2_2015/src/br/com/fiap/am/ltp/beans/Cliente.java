package br.com.fiap.am.ltp.beans;

import java.util.Calendar;

/**
 * Descrição da classe/método
 * @since 1.0
 * @version 1.0
 * @author Lucas 74795
 */
public class Cliente extends Pessoa {
	private String cpf;
	private String rg;
	private Calendar dtNascimento;
	private String email;
	private String senha;
	
	public Cliente() {
		super();
	}

	public Cliente(String cpf, String rg, Calendar dtNascimento, String email,
			String senha) {
		super();
		this.cpf = cpf;
		this.rg = rg;
		this.dtNascimento = dtNascimento;
		this.email = email;
		this.senha = senha;
	}
	
	public Cliente(int codigo, String nome, Telefone telefone,
			Logradouro endereco) {
		super(codigo, nome, telefone, endereco);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Calendar getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
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
