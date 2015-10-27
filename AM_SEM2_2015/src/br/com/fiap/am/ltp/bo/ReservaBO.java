package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.ltp.beans.Reserva;
import br.com.fiap.am.ltp.dao.ReservaDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

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
		try {
			List<Boolean> disponibilidadeQuarto = new ArrayList<Boolean>();
			
			disponibilidadeQuarto = ReservaBO.verificarDisponibilidadeQuarto(reserva, conexao);
			
			int index = 0;
			for (Boolean boolean1 : disponibilidadeQuarto) {
				if (!boolean1 && index == 0) {
					throw new Excecao("N�o tem quartos STANDART suficientes para a quantidade solicitada.");
				} else if ((!boolean1 && index == 1)) {
					throw new Excecao("N�o tem quartos MASTER suficientes para a quantidade solicitada.");
				} else if ((!boolean1 && index == 2)) {
					throw new Excecao("N�o tem quartos LUXO suficientes para a quantidade solicitada.");
				} else if ((!boolean1 && index == 3)) {
					throw new Excecao("N�o tem quartos MASTER LUXO suficientes para a quantidade solicitada.");
				}
				index++;
			}
			
			new ReservaDAO().gravar(reserva, conexao);
		} catch(Exception e) {
			throw new Exception(e);
		}
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
