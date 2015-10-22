package br.com.fiap.am.ltp.beans;

import java.util.List;

/**
 * Descri��o da classe/m�todo
 * 
 * @author Lucas 74795, Estev�o 74803, Gustavo
 * @version 4.0
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
	private List<Integer> idadeCriancas;

	public Quarto() {
		super();
	}

	public Quarto(int codigo, TipoQuarto tipo, short nrCapacidade, int nrAndar, boolean status, int qtCrianca,
			int qtAdulto, List<Integer> idadeCriancas) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.nrCapacidade = nrCapacidade;
		this.nrAndar = nrAndar;
		this.status = status;
		this.qtCrianca = qtCrianca;
		this.qtAdulto = qtAdulto;
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

	public List<Integer> getIdadeCriancas() {
		return idadeCriancas;
	}

	public void setIdadeCriancas(List<Integer> idadeCriancas) {
		this.idadeCriancas = idadeCriancas;
	}
}
