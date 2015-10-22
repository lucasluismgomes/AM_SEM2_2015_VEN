package br.com.fiap.am.ltp.beans;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795, Estevão 74803
 * @version 1.0
 * @since 1.0
 */
public class TipoConsumo {
	private int codigo;
	private String nome;
	private short tipo;
	private double valor;
	public TipoConsumo() {
		super();
	}
	public TipoConsumo(int codigo, String nome, short tipo, double valor) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public short getTipo() {
		return tipo;
	}
	public void setTipo(short tipo) {
		this.tipo = tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
