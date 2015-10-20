package br.com.fiap.am.ltp.beans;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795, Estevão 74803
 * @version 1.0
 * @since 1.0
 */
public class Quarto {
	private int codigo;
	private TipoQuarto tipo;
	private short nrCapacidade;
	private int nrAndar;
	private boolean status;
	
	public Quarto() {
		super();
	}
	
	public Quarto(int codigo, TipoQuarto tipo, short nrCapacidade, int nrAndar,
			boolean status) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.nrCapacidade = nrCapacidade;
		this.nrAndar = nrAndar;
		this.status = status;
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
	public short getNrCapacidade() {
		return nrCapacidade;
	}
	public void setNrCapacidade(short nrCapacidade) {
		this.nrCapacidade = nrCapacidade;
	}
	public int getNrAndar() {
		return nrAndar;
	}
	public void setNrAndar(int nrAndar) {
		this.nrAndar = nrAndar;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
