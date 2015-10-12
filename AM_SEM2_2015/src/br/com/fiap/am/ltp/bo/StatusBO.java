package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Status;
import br.com.fiap.am.ltp.dao.StatusDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Regras de negócio de Status.
 * 
 * @author Lucas 74795
 * @version 3.0
 * @since 1.0
 */
public class StatusBO {
	/**
	 * Grava um Status no banco de dados. O nome precisa ter no mínimo 3 caracteres para ser gravado.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param status
	 * 			O status que está sendo gravado no banco de dados.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @throws Exception
	 * @see StatusDAO, Status
	 */
	public static void gravar(Status status, Connection conexao)
			throws Exception {
		if (status.getNome().length() < 2) {
			throw new Excecao("Caracteres insuficientes no nome do Status");
		}

		new StatusDAO().gravar(status, conexao);
	}
	
	/**
	 * Busca todos os Status do banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 2.0
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @return <code>lstStatus</code>
	 * 			Uma lista com todos os status disponiveis no banco de dados.
	 * @throws Exception
	 * @see StatusDAO
	 */
	public static List<Status> buscarTodos(Connection conexao) throws Exception {
		return new StatusDAO().buscarTodos(conexao);
	}
	
	/**
	 * Busca apenas o status com o código fornecido.
	 * 
	 * @author Lucas 74795
	 * @since 3.0
	 * @param codigo
	 * 			Código do status que está sendo buscado.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @return <code>status</code>
	 * 			O status que foi buscado, caso o código passado esteja correto.
	 * @throws Exception
	 * @see StatusDAO
	 */
	public static Status buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		return new StatusDAO().buscarPorCodigo(codigo, conexao);
	}
	
	/**
	 * Edita um status de acordo com seu código. O novo nome deve ser único no
	 * banco de dados e deve possuir 3 ou mais caracteres
	 * 
	 * @author Lucas 74795
	 * @since 3.0
	 * @param status
	 * 			Status que está sendo editado, contendo seu código e novo nome
	 * @param conexao
	 * 			Credenciais da conexão.
	 * @throws Exception
	 * @see StatusDAO
	 */
	public static void editar(Status status, Connection conexao) throws Exception {
		if (status.getNome().length() < 2) {
			throw new Excecao("Caracteres insuficientes no nome do Status");
		}
		
		new StatusDAO().editar(status, conexao);
	}
	
	/**
	 * Excluí um Status do banco que tenha o código correspondente ao código passado.
	 * 
	 * @author Lucas 74795
	 * @since 3.0
	 * @param codigo
	 * 			Código do Status que será excluído.
	 * @param conexao
	 * 			Credenciais da conexão.
	 * @throws Exception
	 * @see StatusDAO
	 */
	public static void excluir(int codigo, Connection conexao) throws Exception {
		new StatusDAO().excluir(codigo, conexao);
	}
}
