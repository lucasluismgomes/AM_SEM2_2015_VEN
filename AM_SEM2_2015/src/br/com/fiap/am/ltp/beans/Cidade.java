package br.com.fiap.am.ltp.beans;

/**
 * Descri��o da classe/m�todo
 * 
 * @author Lucas 74795, Mateus 74793
 * @version 1.0
 * @since 1.0
 */
public class Cidade {
	private int codigo;
	private Estado estado;
	private String nome;
	
	public Cidade() {
		super();
	}
	
	public Cidade(int codigo, Estado estado, String nome) {
		super();
		this.codigo = codigo;
		this.estado = estado;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
