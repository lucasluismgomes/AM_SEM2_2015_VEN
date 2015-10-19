package br.com.fiap.am.ltp.beans;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class Quarto {
	private int codigo;
	private TipoQuarto tipo;
	private String descricaoQuarto;
	private int nrAndar;

	public Quarto() {
		super();
	}

	public Quarto(int codigo, TipoQuarto tipo, String descricaoQuarto,
			int nrAndar) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.descricaoQuarto = descricaoQuarto;
		this.nrAndar = nrAndar;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public TipoQuarto getTipo() {
		return tipo;
	}

	public void setTipo(TipoQuarto tipo) {
		this.tipo = tipo;
	}

	public String getDescricaoQuarto() {
		return descricaoQuarto;
	}

	public void setDescricaoQuarto(String descricaoQuarto) {
		this.descricaoQuarto = descricaoQuarto;
	}

	public int getNrAndar() {
		return nrAndar;
	}

	public void setNrAndar(int nrAndar) {
		this.nrAndar = nrAndar;
	}

}
