package br.com.fiap.am.ltp.beans;

/**
 * Descrição da classe/método
 * @since 1.0
 * @version 1.0
 * @author Lucas 74795
 */
public class TipoTelefone {
	private int codigo;
	private String nomeTipo;
	
	public TipoTelefone() {
		super();
	}
	
	public TipoTelefone(int codigo, String nomeTipo) {
		super();
		this.codigo = codigo;
		this.nomeTipo = nomeTipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeTipo() {
		return nomeTipo;
	}

	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}
}
