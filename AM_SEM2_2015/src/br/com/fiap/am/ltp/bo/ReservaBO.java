package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

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
	 * 
	 * @param reserva
	 * @param conexao
	 * @throws Exception
	 */
	public static void gravar(Reserva reserva, Connection conexao) throws Exception {
		new ReservaDAO().gravar(reserva, conexao);
	}
	
	/**
	 * 
	 * @param codigo
	 * @param conexao
	 * @return
	 * @throws Exception
	 */
	public static Reserva buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		return new ReservaDAO().buscarPorCodigo(codigo, conexao);
	}
	
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
	
	/**
	 * Descri��o
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param reserva
	 * @param conexao
	 * @return
	 * @throws Exception
	 */
	public static List<Boolean> verificarDisponibilidadeQuarto(Reserva reserva, Connection conexao) throws Exception {
		return new  ReservaDAO().verificarDisponibilidadeQuarto(reserva, conexao);
	}
	
	/**
	 * 
	 * @param reserva
	 * @param conexao
	 * @return
	 * @throws Exception
	 */
	public static List<Integer> verificarQtQuartosDisponiveis(Reserva reserva, Connection conexao) throws Exception {
		return new  ReservaDAO().verificarQtQuartosDisponiveis(reserva, conexao);
	}
}
