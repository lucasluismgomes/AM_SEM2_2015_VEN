package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.TipoLogradouro;
import br.com.fiap.am.ltp.dao.TipoLogradouroDAO;

/**
 * Descri��o da classe/m�todo
 * 
 * @author Mateus 74793
 * @version 1.0
 * @since 1.0
 */
public class TipoLogradouroBO 
{
	/**
	 * M�todo que leva as informa��es para a classe DAO para a grava��o no banco de dados.
	 * @param tipoLogradouro Leva as informa��es para a grava��o no banco de dados.
	 * @param conexao Leva a Credenciais de conex�o
	 * @return <code> TipoLogradouroDAO().gravar(tipoLogradouro, conexao); </code>
	 * Retorna um true ou false.
	 * @throws Exception
	 * @see TipoLogradouro, TipoLogradouroDAO
	 */
	public static boolean gravar(TipoLogradouro tipoLogradouro,Connection conexao) throws Exception
	{
		return new TipoLogradouroDAO().gravar(tipoLogradouro, conexao);
	}
	/**
	 * M�todo que leva as informa��es para a classe DAO para a edi��o no banco de dados.
	 * @param tipoLogradouro Leva as informa��es para a edi��o de um registro.
	 * @param conexao Leva a Credenciais de conex�o
	 * @return <code> TipoLogradouroDAO().editar(tipoLogradouro, conexao); </code>
	 * Retorna um true ou false.
	 * @throws Exception
	 * @see TipoLogradouro, TipoLogradouroDAO
	 */
	public static boolean editar(TipoLogradouro tipoLogradouro,Connection conexao) throws Exception
	{
		return new TipoLogradouroDAO().editar(tipoLogradouro, conexao);
	}
	/**
	 * M�todo que leva as informa��es para a classe DAO para a exclus�o no banco de dados.
	 * @param tipoLogradouro Leva as informa��es para a exclus�o no banco de dados.
	 * @param conexao Leva a Credenciais de conex�o
	 * @return <code> TipoLogradouroDAO().excluir(tipoLogradouro, conexao); </code>
	 * Retorna um true ou false.
	 * @throws Exception
	 * @see TipoLogradouro, TipoLogradouroDAO
	 */
	public static boolean excluir(int codigo,Connection conexao) throws Exception
	{	
		return new TipoLogradouroDAO().excluir(codigo, conexao);
	}
	/**
	 * M�todo que retorna todos os registros do banco de dados.
	 * @param conexao Leva credencial de conex�o
	 * @return <code> TipoLogradouroDAO().buscarTodos(conexao); </code>
	 * Retorna todos os registros do banco de dados.
	 * @throws Exception
	 * @see TipoLogradouro, TipoLogradouroDAO
	 */
	public static List<TipoLogradouro> buscarTodos(Connection conexao) throws Exception
	{
		return new TipoLogradouroDAO().buscarTodos(conexao);
	}
	/**
	 * M�todo que realiza uma pesquisa no banco de dados e retorna os dados encontrados.
	 * @param tipoLogradouro Leva um parametro para pesquisa no banco de dados.
	 * @param conexao Leva Credencial de conex�o
	 * @return <code> TipoLogradouroDAO().buscarPorNome(tipoLogradouro, conexao); </code>
	 * Retorna uma Lista de Tipos de Logradouros a partir de uma pesquisa.
	 * @throws Exception
	 * @see TipoLogradouro, TipoLogradouroDAO
	 */
	public static List<TipoLogradouro> buscarPorNome(String pesquisaTipoLogradouro,Connection conexao) throws Exception
	{
		return new TipoLogradouroDAO().buscarPorNome(pesquisaTipoLogradouro, conexao);
	}
}
