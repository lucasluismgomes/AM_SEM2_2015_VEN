package br.com.fiap.am.ltp.beans;

/**
 * Descrição da classe/método
 * @since 1.0
 * @version 1.0
 * @author Lucas 74795
 */
public class Telefone {
	private int codigo;
	private TipoTelefone tipo;
	private int ddd;
	private Long numero;
	
	public Telefone() {
		super();
	}

	public Telefone(int codigo, TipoTelefone tipo, int ddd, Long numero) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.ddd = ddd;
		this.numero = numero;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}
}
