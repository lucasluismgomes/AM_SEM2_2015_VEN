package br.com.fiap.am.ltp.bo;

import java.sql.Connection;

import br.com.fiap.am.ltp.beans.Reserva;
import br.com.fiap.am.ltp.dao.ReservaDAO;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class ReservaBO {
	/**
	 * Descrição.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param reserva
	 * 			A reserva cujo valor está sendo calculado.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @return <code>valorReserva</code> O preço final da reserva, apenas com os quartos.
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
