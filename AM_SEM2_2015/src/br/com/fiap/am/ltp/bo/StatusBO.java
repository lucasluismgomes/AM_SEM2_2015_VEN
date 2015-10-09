package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Status;
import br.com.fiap.am.ltp.dao.StatusDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 2.0
 * @since 1.0
 */
public class StatusBO {
	/**
	 * Grava um Status no banco de dados. O nome precisa ter no mínimo 3 caracteres para ser gravado.
	 * 
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
			throw new Excecao("Caracteres insuficientes no nome do Bairro");
		}

		new StatusDAO().gravar(status, conexao);
	}
	
	/**
	 * Busca todos os Status do banco de dados.
	 * 
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
	 * @param id
	 * 			Código do status que está sendo buscado.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @return <code>status</code>
	 * 			O status que foi buscado, caso o código passado esteja correto.
	 * @throws Exception
	 * @see StatusDAO
	 */
	public static Status buscar(int id, Connection conexao) throws Exception {
		return new StatusDAO().buscar(id, conexao);
	}
}
