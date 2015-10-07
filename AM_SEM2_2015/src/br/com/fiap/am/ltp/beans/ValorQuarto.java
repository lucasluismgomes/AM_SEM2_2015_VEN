package br.com.fiap.am.ltp.beans;

/**
 * Descrição da classe/método
 * @since 1.0
 * @version 1.0
 * @author Lucas 74795
 */
public class ValorQuarto {
	private int qtHospedes;
	private double valor;
	
	public ValorQuarto() {
		super();
	}

	public ValorQuarto(int qtHospedes, double valor) {
		super();
		this.qtHospedes = qtHospedes;
		this.valor = valor;
	}

	public int getQtHospedes() {
		return qtHospedes;
	}

	public void setQtHospedes(int qtHospedes) {
		this.qtHospedes = qtHospedes;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
