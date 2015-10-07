package br.com.fiap.am.ltp.beans;

import java.util.Calendar;

/**
 * Descrição da classe/método
 * @since 1.0
 * @version 1.0
 * @author Lucas 74795
 */
public class Reserva {
	private int codigo;
	private Cliente cliente;
	private Status status;
	private Calendar dtEntrada;
	private Calendar dtSaida;
	private int qtHospedes;
	private int qtQuartos;
	private double vlReserva;
	private Quarto quarto;
	
	public Reserva() {
		super();
	}

	public Reserva(int codigo, Cliente cliente, Status status,
			Calendar dtEntrada, Calendar dtSaida, int qtHospedes,
			int qtQuartos, double vlReserva, Quarto quarto) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.status = status;
		this.dtEntrada = dtEntrada;
		this.dtSaida = dtSaida;
		this.qtHospedes = qtHospedes;
		this.qtQuartos = qtQuartos;
		this.vlReserva = vlReserva;
		this.quarto = quarto;
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

	public int getQtHospedes() {
		return qtHospedes;
	}

	public void setQtHospedes(int qtHospedes) {
		this.qtHospedes = qtHospedes;
	}

	public int getQtQuartos() {
		return qtQuartos;
	}

	public void setQtQuartos(int qtQuartos) {
		this.qtQuartos = qtQuartos;
	}

	public double getVlReserva() {
		return vlReserva;
	}

	public void setVlReserva(double vlReserva) {
		this.vlReserva = vlReserva;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
}
