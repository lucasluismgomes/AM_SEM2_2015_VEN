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
	private int nrBanco;
	private int qtParcelas;
	private double vlParcelas;
	private int nrCheque;
	
	public Pagamento() {
		super();
	}

	public Pagamento(Hospedagem hospedagem, FormaPagamento formaPagamento,
			Calendar dtPagamento, double vlPagamento, int nrBanco,
			int qtParcelas, double vlParcelas, int nrCheque) {
		super();
		this.hospedagem = hospedagem;
		this.formaPagamento = formaPagamento;
		this.dtPagamento = dtPagamento;
		this.vlPagamento = vlPagamento;
		this.nrBanco = nrBanco;
		this.qtParcelas = qtParcelas;
		this.vlParcelas = vlParcelas;
		this.nrCheque = nrCheque;
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

	public int getNrBanco() {
		return nrBanco;
	}

	public void setNrBanco(int nrBanco) {
		this.nrBanco = nrBanco;
	}

	public int getQtParcelas() {
		return qtParcelas;
	}

	public void setQtParcelas(int qtParcelas) {
		this.qtParcelas = qtParcelas;
	}

	public double getVlParcelas() {
		return vlParcelas;
	}

	public void setVlParcelas(double vlParcelas) {
		this.vlParcelas = vlParcelas;
	}

	public int getNrCheque() {
		return nrCheque;
	}

	public void setNrCheque(int nrCheque) {
		this.nrCheque = nrCheque;
	}
}
