package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Hospedagem;
import br.com.fiap.am.ltp.dao.HospedagemDAO;

/**
 * Regras de Negócio referentes a Hospedagem
 * 
 * @author Victor 74820
 * @version 1.0
 * @since 1.0
 */
public class HospedagemBO {
	
	/**
	 * Faz a gravação de uma Hospedagem no banco de dados. 
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param FormaPagamento
	 *            A Hospedagem que está sendo gravada no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Hospedagem, HospedagemDAO
	 */
	public static void gravar(Hospedagem hospedagem, Connection conexao) throws Exception {
		new HospedagemDAO().gravar(hospedagem, conexao);
	}

	/**
	 * Busca todos as Hospedagens cadastradas no banco de dados.
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param conexao
	 *            As credenciais da conexão.
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
	 *            O codigo da Hospedagem que está sendo buscada.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return Hospedagem
	 * @throws Exception
	 * @see Hospedagem, HospedagemDAO
	 */
	public static Hospedagem buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		return new HospedagemDAO().buscarPorCodigo(codigo, conexao);
	}
	
	/**
	 * Edita os dados de uma Hospedagem no banco de dados.
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param Hospedagem
	 *            A Hospedagem que está sendo editada.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Hospedagem, HospedagemDAO
	 */
	public static void editar(Hospedagem hospedagem, Connection conexao) throws Exception {
		new HospedagemDAO().editar(hospedagem, conexao);
	}

	/**
	 * Excluí uma Hospedagem do banco de dados. 
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param codigo
	 *            O código da Hospedagem que será excluída do banco de dados.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @throws Exception
	 * @see Hospedagem, HospedagemDAO
	 */
	public static void excluir(int codigo, Connection conexao) throws Exception {
		new HospedagemDAO().excluir(codigo, conexao);
	}
	
}
