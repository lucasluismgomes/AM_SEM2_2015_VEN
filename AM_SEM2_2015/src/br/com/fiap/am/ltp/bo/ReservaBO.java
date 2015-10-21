package br.com.fiap.am.ltp.bo;

import java.sql.Connection;

import br.com.fiap.am.ltp.beans.Reserva;
import br.com.fiap.am.ltp.dao.ReservaDAO;

/**
 * Descri��o da classe/m�todo
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class ReservaBO {
	/**
	 * Descri��o.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param reserva
	 * 			A reserva cujo valor est� sendo calculado.
	 * @param conexao
	 * 			As credenciais da conex�o.
	 * @return <code>valorReserva</code> O pre�o final da reserva, apenas com os quartos.
	 * @throws Exception
	 */
	public static double calcularReserva(Reserva reserva, Connection conexao)
			throws Exception {
		try {
			return new ReservaDAO().calcularReserva(reserva, conexao);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}
