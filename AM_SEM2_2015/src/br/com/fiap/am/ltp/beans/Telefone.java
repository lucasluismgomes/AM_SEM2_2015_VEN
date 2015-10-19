package br.com.fiap.am.ltp.beans;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 2.0
 * @since 1.0
 */
public class Telefone {
	private int codigo;
	private TipoTelefone tipo;
	private short ddd;
	private Long numero;
	
	public Telefone() {
		super();
	}

	public Telefone(int codigo, TipoTelefone tipo, short ddd, Long numero) {
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

	public short getDdd() {
		return ddd;
	}

	public void setDdd(short ddd) {
		this.ddd = ddd;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}
}
