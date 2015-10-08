package br.com.fiap.am.ltp.beans;

import java.util.Calendar;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class Pedido {
	private int codigo;
	private Consumo consumo;
	private Hospedagem hospedagem;
	private int quantidade;
	private Calendar dtSolicitacao;
	private double valorTotal;
	private Funcionario funcionario;
	
	public Pedido() {
		super();
	}

	public Pedido(int codigo, Consumo consumo, Hospedagem hospedagem,
			int quantidade, Calendar dtSolicitacao, double valorTotal,
			Funcionario funcionario) {
		super();
		this.codigo = codigo;
		this.consumo = consumo;
		this.hospedagem = hospedagem;
		this.quantidade = quantidade;
		this.dtSolicitacao = dtSolicitacao;
		this.valorTotal = valorTotal;
		this.funcionario = funcionario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Consumo getConsumo() {
		return consumo;
	}

	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}

	public Hospedagem getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Calendar getDtSolicitacao() {
		return dtSolicitacao;
	}

	public void setDtSolicitacao(Calendar dtSolicitacao) {
		this.dtSolicitacao = dtSolicitacao;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
