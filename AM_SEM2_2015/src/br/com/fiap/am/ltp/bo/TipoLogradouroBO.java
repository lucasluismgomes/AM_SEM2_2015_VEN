package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.TipoLogradouro;
import br.com.fiap.am.ltp.dao.TipoLogradouroDAO;

/**
 * Descrição da classe/método
 * 
 * @author Mateus 74793
 * @version 1.0
 * @since 1.0
 */
public class TipoLogradouroBO 
{
	/**
	 * Método que leva as informações para a classe DAO para a gravação no banco de dados.
	 * @param tipoLogradouro Leva as informações para a gravação no banco de dados.
	 * @param conexao Leva a Credenciais de conexão
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
	 * Método que leva as informações para a classe DAO para a edição no banco de dados.
	 * @param tipoLogradouro Leva as informações para a edição de um registro.
	 * @param conexao Leva a Credenciais de conexâo
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
	 * Método que leva as informações para a classe DAO para a exclusão no banco de dados.
	 * @param tipoLogradouro Leva as informações para a exclusão no banco de dados.
	 * @param conexao Leva a Credenciais de conexâo
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
	 * Método que retorna todos os registros do banco de dados.
	 * @param conexao Leva credencial de conexão
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
	 * Método que realiza uma pesquisa no banco de dados e retorna os dados encontrados.
	 * @param tipoLogradouro Leva um parametro para pesquisa no banco de dados.
	 * @param conexao Leva Credencial de conexão
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
