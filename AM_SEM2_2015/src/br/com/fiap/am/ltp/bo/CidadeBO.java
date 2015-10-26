package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Cidade;
import br.com.fiap.am.ltp.dao.CidadeDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Mateus 74793
 * @version 1.0
 * @since 1.0
 */
public class CidadeBO 
{
	/**
	 * 
	 * @param cidade 
	 * 			Leva o objeto Cidade para a gravação no banco de dados.
	 * @param conexao
	 *				As credencias da conexão.
	 * @return <code>CidadeDAO().gravar(cidade,conexao)</code> Retorna um boolean true caso ocorra a gravação
	 * e false caso nao consiga gravar.
	 * @throws Excecao
	 * @see Cidade,CidadeDAO
	 */
	public static boolean gravar(Cidade cidade, Connection conexao) throws Excecao {
		try {
			return new CidadeDAO().gravar(cidade, conexao);
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	/**
	 * 
	 * @param cidade 
	 * @param conexao
	 * 				As credencias da conexão.
	 * @return <code>CidadeDAO().gravar(cidade,conexao)</code> Retorna um boolean true caso ocorra a gravação
	 * e false caso nao consiga gravar.
	 * @throws Excecao
	 * @see Cidade,CidadeDAO
	 */
	public static boolean editar(Cidade cidade, Connection conexao) throws Excecao {
		try {
			return new CidadeDAO().editar(cidade, conexao);
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	public static List<Cidade> buscarTodos(Connection conexao) throws Excecao {
		try {
			return new CidadeDAO().buscarTodos(conexao);
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	/**
	 * 
	 * @param cidade
	 * 				Leva o objeto cidade para realizar uma pesquisa no banco de dados.
	 * @param conexao
	 * 				As credencias da conexão.
	 * @return
	 * @throws Excecao
	 * @see Cidade,CidadeDAO
	 */
	public static List<Cidade> buscarPorNome(String pesquisaCidade, Connection conexao) throws Excecao
	{
		try {
			return new CidadeDAO().buscarPorNome(pesquisaCidade, conexao);
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	/**
	 * 
	 * @param cidade
	 * 				Leva o Objeto Cidade para a exclusao de um registro no banco de dados.
	 * @param conexao
	 * 				As credencias da conexão.
	 * @return
	 * @throws Excecao
	 * @see Cidade,CidadeDAO
	 */
	public static boolean excluir(int codigo, Connection conexao) throws Excecao {
		try {
			return new CidadeDAO().excluir(codigo, conexao);
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
}
