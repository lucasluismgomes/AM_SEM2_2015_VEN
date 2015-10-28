package br.com.fiap.am.ltp.bo;

import java.sql.Connection;

import br.com.fiap.am.ltp.beans.Pagamento;
import br.com.fiap.am.ltp.dao.PagamentoDAO;

/**
 * Descri��o da classe/m�todo
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class PagamentoBO {

	/**
	 * Faz a grava��o de um Pagamento no banco de dados. 
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param Pagamento
	 *            O Pagamento que est� sendo gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @throws Exception
	 * @see Pagamento, PagamentoDAO
	 */
	public static void gravar(Pagamento pagamento, Connection conexao) throws Exception {
		new PagamentoDAO().gravar(pagamento, conexao);
	}
	
	/**
	 * Faz a calculo do total a ser pago pelo Cliente. 
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param Hospedagem
	 *            O c�digo de Hospedagem que ser� utilizado para calculo do total a ser pago.
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @throws Exception
	 * @see Pagamento, PagamentoDAO
	 */
	public static double calcularTotal (Pagamento pagamento, Connection conexao) throws Exception {
		return new PagamentoDAO().calcularTotal(pagamento, conexao);
	}
	
}
