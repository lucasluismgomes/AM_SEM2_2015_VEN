package br.com.fiap.am.ltp.beans;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class Status {
	private int codigo;
	private String nomeStatus;
	
	public Status() {
		super();
	}
	
	public Status(int codigo, String nomeStatus) {
		super();
		this.codigo = codigo;
		this.nomeStatus = nomeStatus;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeStatus() {
		return nomeStatus;
	}

	public void setNomeStatus(String nomeStatus) {
		this.nomeStatus = nomeStatus;
	}
}
