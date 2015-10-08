package br.com.fiap.am.ltp.beans;

import java.util.Calendar;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class Pagamento {
	private Hospedagem hospedagem;
	private FormaPagamento formaPagamento;
	private Calendar dtPagamento;
	private double vlPagamento;
	
	public Pagamento() {
		super();
	}

	public Pagamento(Hospedagem hospedagem, FormaPagamento formaPagamento,
			Calendar dtPagamento, double vlPagamento) {
		super();
		this.hospedagem = hospedagem;
		this.formaPagamento = formaPagamento;
		this.dtPagamento = dtPagamento;
		this.vlPagamento = vlPagamento;
	}

	public Hospedagem getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Calendar getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(Calendar dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

	public double getVlPagamento() {
		return vlPagamento;
	}

	public void setVlPagamento(double vlPagamento) {
		this.vlPagamento = vlPagamento;
	}
}
