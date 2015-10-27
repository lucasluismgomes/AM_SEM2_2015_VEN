package br.com.fiap.am.ltp.beans;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class Reserva {
	private int codigo;
	private Cliente cliente;
	private Funcionario funcionario;
	private Status status;
	private Calendar dtEntrada;
	private Calendar dtSaida;
	private Calendar dtSolicitacao;
	private short qtAdulto;
	private short qtCrianca;
	private List<Quarto> quarto;
	private String observacao;
	private double vlReserva;
	private int qtDias;

	public Reserva() {
		super();
	}

	public Reserva(int codigo, Cliente cliente, Funcionario funcionario, Status status, Calendar dtEntrada,
			Calendar dtSaida, Calendar dtSolicitacao, short qtAdulto, short qtCrianca, List<Quarto> quarto,
			String observacao, double vlReserva, int qtDias) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.status = status;
		this.dtEntrada = dtEntrada;
		this.dtSaida = dtSaida;
		this.dtSolicitacao = dtSolicitacao;
		this.qtAdulto = qtAdulto;
		this.qtCrianca = qtCrianca;
		this.quarto = quarto;
		this.observacao = observacao;
		this.vlReserva = vlReserva;
		this.qtDias = qtDias;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Calendar getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(Calendar dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public Calendar getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(Calendar dtSaida) {
		this.dtSaida = dtSaida;
	}

	public Calendar getDtSolicitacao() {
		return dtSolicitacao;
	}

	public void setDtSolicitacao(Calendar dtSolicitacao) {
		this.dtSolicitacao = dtSolicitacao;
	}

	public short getQtAdulto() {
		return qtAdulto;
	}

	public void setQtAdulto(short qtAdulto) {
		this.qtAdulto = qtAdulto;
	}

	public short getQtCrianca() {
		return qtCrianca;
	}

	public void setQtCrianca(short qtCrianca) {
		this.qtCrianca = qtCrianca;
	}

	public double getVlReserva() {
		return vlReserva;
	}

	public void setVlReserva(double vlReserva) {
		this.vlReserva = vlReserva;
	}

	public List<Quarto> getQuarto() {
		return quarto;
	}

	public void setQuarto(List<Quarto> quarto) {
		this.quarto = quarto;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getQtDias() {
		return qtDias;
	}

	public void setQtDias(int qtDias) {
		this.qtDias = qtDias;
	}	
	
	public String getDtEntradaFormatted(){
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return df.format(this.dtEntrada.getTime());
	}
	public String getDtSaidaFormatted(){
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return df.format(this.dtSaida.getTime());
	}

}
