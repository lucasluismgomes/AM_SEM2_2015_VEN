package br.com.fiap.am.ltp.beans;

/**
 * Descri��o da classe/m�todo
 * @since 1.0
 * @version 1.0
 * @author Lucas 74795
 */
public class TipoQuarto {
	private int codigo;
	private String nomeTipo;
	private double valor;
	
	public TipoQuarto() {
		super();
	}

	public TipoQuarto(int codigo, String nomeTipo, double valor) {
		super();
		this.codigo = codigo;
		this.nomeTipo = nomeTipo;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeTipo() {
		return nomeTipo;
	}

	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
