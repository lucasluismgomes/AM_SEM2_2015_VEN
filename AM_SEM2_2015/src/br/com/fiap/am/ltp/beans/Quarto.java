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
	private int qtCrianca = 0;
	private int qtAdulto = 0;
	private int[] idadeCriancas;
	
	public Quarto() {
		super();
	}

	public Quarto(int codigo, TipoQuarto tipo, short nrCapacidade, int nrAndar,
			boolean status, int qtCrianca, int qtAdulto) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.nrCapacidade = nrCapacidade;
		this.nrAndar = nrAndar;
		this.status = status;
		this.qtCrianca = qtCrianca;
		this.qtAdulto = qtAdulto;
		this.idadeCriancas = new int[qtCrianca];
	}
	
	public Quarto(int codigo, TipoQuarto tipo, short nrCapacidade, int nrAndar,
			boolean status, int qtCrianca, int qtAdulto, int[] idadeCriancas ) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.nrCapacidade = nrCapacidade;
		this.nrAndar = nrAndar;
		this.status = status;
		this.qtCrianca = qtCrianca;
		this.qtAdulto = qtAdulto;
		this.idadeCriancas = new int[qtCrianca];
		this.idadeCriancas = idadeCriancas;
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

	public int getQtCrianca() {
		return qtCrianca;
	}

	public void setQtCrianca(int qtCrianca) {
		this.qtCrianca = qtCrianca;
	}

	public int getQtAdulto() {
		return qtAdulto;
	}

	public void setQtAdulto(int qtAdulto) {
		this.qtAdulto = qtAdulto;
	}

	public int[] getIdadeCriancas() {
		return idadeCriancas;
	}

	public void setIdadeCriancas(int[] idadeCriancas) {
		this.idadeCriancas = idadeCriancas;
	}
	
}
