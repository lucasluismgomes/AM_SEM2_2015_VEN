package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Hospedagem;
import br.com.fiap.am.ltp.dao.HospedagemDAO;

/**
 * Descri��o da classe/m�todo
 * 
 * @author Victor 74820
 * @version 1.0
 * @since 1.0
 */
public class HospedagemBO {

	
	
	/**
	 * Busca todos as Hospedagens cadastradas no banco de dados.
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @return lstHospedagem
	 * @throws Exception
	 * @see FormaPagamento, FormaPagamentoDAO
	 */
	public static List<Hospedagem> buscarTodos(Connection conexao) throws Exception {
		return new HospedagemDAO().buscarTodos(conexao);
	}
	
	/**
	 * Busca uma Hospedagem especifico no banco de dados.
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param codigo
	 *            O codigo da Hospedagem que est� sendo buscada.
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @return Hospedagem
	 * @throws Exception
	 * @see Hospedagem, HospedagemDAO
	 */
	public static Hospedagem buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		return new HospedagemDAO().buscarPorCodigo(codigo, conexao);
	}
}
