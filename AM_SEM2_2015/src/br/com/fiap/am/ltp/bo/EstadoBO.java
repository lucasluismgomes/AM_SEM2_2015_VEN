package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Estado;
import br.com.fiap.am.ltp.dao.EstadoDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
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
	 * 			Leva o objeto estado para a gravação no banco de dados.
	 * @param conexao
	 *				As credencias da conexão.
	 * @return <code>estadoDAO().gravar(estado,conexao)</code> Retorna um boolean true caso ocorra a gravação
	 * e false caso nao consiga gravar.
	 * @throws Excecao
	 * @see Estado,EstadoDAO
	 */
	public boolean gravar(Estado estado, Connection conexao) throws Excecao {
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
	 * 				As credencias da conexão.
	 * @return <code>estadoDAO().gravar(estado,conexao)</code> Retorna um boolean true caso ocorra a gravação
	 * e false caso nao consiga gravar.
	 * @throws Excecao
	 * @see Estado,EstadoDAO
	 */
	public boolean editar(Estado estado, Connection conexao) throws Excecao {
		try {
			return new EstadoDAO().editar(estado, conexao);
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	public List<Estado> buscarTodos(Connection conexao) throws Excecao {
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
	 * 				As credencias da conexão.
	 * @return
	 * @throws Excecao
	 * @see Estado,EstadoDAO
	 */
	public List<Estado> buscarPorNome(Estado estado, Connection conexao) throws Excecao
	{
		try {
			return new EstadoDAO().buscarPorNome(estado, conexao);
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	/**
	 * 
	 * @param estado
	 * 				Leva o Objeto estado para a exclusao de um registro no banco de dados.
	 * @param conexao
	 * 				As credencias da conexão.
	 * @return
	 * @throws Excecao
	 * @see Estado,EstadoDAO
	 */
	public boolean excluir(Estado estado, Connection conexao) throws Excecao {
		try {
			return new EstadoDAO().excluir(estado, conexao);
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
}
