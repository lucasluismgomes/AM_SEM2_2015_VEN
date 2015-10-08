package br.com.fiap.am.ltp.beans;

import java.util.Calendar;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class Funcionario extends Pessoa {
	private Calendar dtAdmissao;
	private String cargo;
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(int codigo, String nome, Telefone telefone,
			Logradouro endereco) {
		super(codigo, nome, telefone, endereco);
	}

	public Funcionario(Calendar dtAdmissao, String cargo) {
		super();
		this.dtAdmissao = dtAdmissao;
		this.cargo = cargo;
	}

	public Calendar getDtAdmissao() {
		return dtAdmissao;
	}

	public void setDtAdmissao(Calendar dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
