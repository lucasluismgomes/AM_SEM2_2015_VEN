package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Logradouro;
import br.com.fiap.am.ltp.dao.LogradouroDAO;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class LogradouroBO 
{
	/**
	 * Leva o Objeto Logradouro para a gravação no banco de dados
	 * @param logradouro Leva as informações para a gravação
	 * @param conexao Leva a credencial de conexao
	 * @return <code> LogradouroDAO().gravar(logradouro, conexao); </code> Retorna um true ou false
	 * @throws Exception
	 * @see Logradouro, LogradouroBO
	 */
	public static boolean gravar(Logradouro logradouro,Connection conexao) throws Exception
	{
		return new LogradouroDAO().gravar(logradouro, conexao);
	}
	/**
	 * Leva o Objeto Logradouro para a edição no banco de dados
	 * @param logradouro Leva as informações para a edição
	 * @param conexao Leva a credencial de conexao
	 * @return <code> LogradouroDAO().editar(logradouro, conexao); </code> Retorna um true ou false
	 * @throws Exception
	 * @see Logradouro, LogradouroBO
	 */
	public static boolean editar(Logradouro logradouro,Connection conexao) throws Exception
	{
		return new LogradouroDAO().editar(logradouro, conexao);
	}
	/**
	 * Leva o Objeto Logradouro para a exclusão no banco de dados
	 * @param logradouro Leva as informações para a exclusao
	 * @param conexao Leva a credencial de conexao
	 * @return <code> LogradouroDAO().exclusao(logradouro, conexao); </code> Retorna um true ou false
	 * @throws Exception
	 * @see Logradouro, LogradouroBO
	 */
	public static boolean excluir(Logradouro logradouro,Connection conexao) throws Exception
	{
		return new LogradouroDAO().excluir(logradouro, conexao);
	}
	/**
	 * Retorna uma lista de Logradouros cadastrados.
	 * @param conexao Leva a credencial de conexao
	 * @return <code> LogradouroDAO().buscasTodos(conexao); </code> retorna uma lista de logradouros cadastrados
	 * @throws Exception
	 * @see Logradouro, LogradouroBO
	 */
	public static List<Logradouro> buscaTodos(Connection conexao) throws Exception
	{
		return new LogradouroDAO().buscasTodos(conexao);
	}
	/**
	 * Retorna o resultado de um pesquisa
	 * @param logradouro Leva o Objeto Logradouro para realizar uma pesquisa no banco de dados
	 * @param conexao Leva a credencial de Conexao
	 * @return <code> LogradouroDAO().buscasPorNome(logradouro, conexao); </code> Retorna uma lista de logradouros a partir de uma busca
	 * @throws Exception
	 * @see Logradouro, LogradouroBO
	 */
	public static List<Logradouro> buscaPorNome(Logradouro logradouro,Connection conexao) throws Exception
	{
		return new LogradouroDAO().buscasPorNome(logradouro, conexao);
	}
}
