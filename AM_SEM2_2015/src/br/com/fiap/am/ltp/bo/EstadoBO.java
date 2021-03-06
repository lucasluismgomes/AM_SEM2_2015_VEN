package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Estado;
import br.com.fiap.am.ltp.dao.EstadoDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descri��o da classe/m�todo
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class EstadoBO 
{
	/**
	 * 
	 * @param estado 
	 * 			Leva o objeto estado para a grava��o no banco de dados.
	 * @param conexao
	 *				As credencias da conex�o.
	 * @return <code>estadoDAO().gravar(estado,conexao)</code> Retorna um boolean true caso ocorra a grava��o
	 * e false caso nao consiga gravar.
	 * @throws Excecao
	 * @see Estado,EstadoDAO
	 */
	public static boolean gravar(Estado estado, Connection conexao) throws Excecao {
		try {
			return new EstadoDAO().gravar(estado, conexao);
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	/**
	 * 
	 * @param estado 
	 * @param conexao
	 * 				As credencias da conex�o.
	 * @return <code>estadoDAO().gravar(estado,conexao)</code> Retorna um boolean true caso ocorra a grava��o
	 * e false caso nao consiga gravar.
	 * @throws Excecao
	 * @see Estado,EstadoDAO
	 */
	public static boolean editar(Estado estado, Connection conexao) throws Excecao {
		try {
			return new EstadoDAO().editar(estado, conexao);
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	public static List<Estado> buscarTodos(Connection conexao) throws Excecao {
		try {
			return new EstadoDAO().buscarTodos(conexao);
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	/**
	 * 
	 * @param estado
	 * 				Leva o objeto estado para realizar uma pesquisa no banco de dados.
	 * @param conexao
	 * 				As credencias da conex�o.
	 * @return
	 * @throws Excecao
	 * @see Estado,EstadoDAO
	 */
	public static List<Estado> buscarPorNome(String pesquisaEstado, Connection conexao) throws Excecao
	{
		try {
			return new EstadoDAO().buscarPorNome(pesquisaEstado, conexao);
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	/**
	 * 
	 * @param estado
	 * 				Leva o Objeto estado para a exclusao de um registro no banco de dados.
	 * @param conexao
	 * 				As credencias da conex�o.
	 * @return
	 * @throws Excecao
	 * @see Estado,EstadoDAO
	 */
	public static boolean excluir(int codigo, Connection conexao) throws Excecao {
		try {
			return new EstadoDAO().excluir(codigo, conexao);
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
}
