package br.com.fiap.am.ltp.beans;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class Consumo {
	private int codigo;
	private TipoConsumo tipo;
	private String nome;
	private double valor;
	
	public Consumo() {
		super();
	}

	public Consumo(int codigo, TipoConsumo tipo, String nome, double valor) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.nome = nome;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public TipoConsumo getTipo() {
		return tipo;
	}

	public void setTipo(TipoConsumo tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
