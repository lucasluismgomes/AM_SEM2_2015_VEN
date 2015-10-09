package br.com.fiap.am.ltp.beans;

/**
 * 
 * @author Lucas 74795
 *
 */
public class Cargo {
	private int codigo;
	private String nome;
	private double salarioBase;

	public Cargo() {
		super();
	}

	public Cargo(int codigo, String nome, double salarioBase) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.salarioBase = salarioBase;
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

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

}
