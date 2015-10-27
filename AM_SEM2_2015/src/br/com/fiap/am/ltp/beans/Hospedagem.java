package br.com.fiap.am.ltp.beans;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class Hospedagem {
	private Reserva reserva;
	private Funcionario funcionario;
	private Calendar dtCheckIn;
	private Calendar dtCheckOut;
	
	public Hospedagem() {
		super();
	}

	public Hospedagem(Reserva reserva, Funcionario funcionario,
			Calendar dtCheckIn, Calendar dtCheckOut) {
		super();
		this.reserva = reserva;
		this.funcionario = funcionario;
		this.dtCheckIn = dtCheckIn;
		this.dtCheckOut = dtCheckOut;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Calendar getDtCheckIn() {
		return dtCheckIn;
	}

	public void setDtCheckIn(Calendar dtCheckIn) {
		this.dtCheckIn = dtCheckIn;
	}

	public Calendar getDtCheckOut() {
		return dtCheckOut;
	}

	public void setDtCheckOut(Calendar dtCheckOut) {
		this.dtCheckOut = dtCheckOut;
	}
	
	public String getDtEntradaFormatted(){
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return df.format(this.dtCheckIn.getTime());
	}
	public String getDtSaidaFormatted(){
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return df.format(this.dtCheckOut.getTime());
	}
	
}