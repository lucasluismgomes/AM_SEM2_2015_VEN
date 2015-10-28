package br.com.fiap.am.ltp.beans;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795, Estevão 74803
 * @version 1.0
 * @since 1.0
 */
public class Consumo {
	private int codigo;
	private Hospedagem hospedagem;
	private TipoConsumo tipoConsumo;
	private Funcionario funcionario;
	private Calendar dtSolicitacao;
	private int quantidade;
	private double valorTotal;

	public Consumo() {
		super();
	}

	public Consumo(int codigo, Hospedagem hospedagem, TipoConsumo tipoConsumo, Funcionario funcionario,
			Calendar dtSolicitacao, int quantidade, double valorTotal) {
		super();
		this.codigo = codigo;
		this.hospedagem = hospedagem;
		this.tipoConsumo = tipoConsumo;
		this.funcionario = funcionario;
		this.dtSolicitacao = dtSolicitacao;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Hospedagem getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}

	public TipoConsumo getTipoConsumo() {
		return tipoConsumo;
	}

	public void setTipoConsumo(TipoConsumo tipoConsumo) {
		this.tipoConsumo = tipoConsumo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Calendar getDtSolicitacao() {
		return dtSolicitacao;
	}

	public void setDtSolicitacao(Calendar dtSolicitacao) {
		this.dtSolicitacao = dtSolicitacao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorTotal() {

		valorTotal = quantidade * tipoConsumo.getValor();

		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public String getDtConsumoFormated(){
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,new Locale("pt", "BR"));
		return df.format(this.getDtSolicitacao().getTime());
	}
}
