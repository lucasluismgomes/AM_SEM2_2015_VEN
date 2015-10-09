package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Cliente;
import br.com.fiap.am.ltp.dao.ClienteDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class ClienteBO {
	/**
	 * Descrição
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param cliente
	 * @param conexao
	 * @throws Exception
	 * @see Cliente, ClienteDAO
	 */
	public static void gravar(Cliente cliente, Connection conexao)
			throws Exception {
		if (cliente.getNome().length() < 2) {
			throw new Excecao("Caracteres insuficientes no nome do Cliente");
		}

		new ClienteDAO().gravar(cliente, conexao);
	}

	/**
	 * Descrição
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param conexao
	 * @return lstCliente
	 * @throws Exception
	 * @see Cliente, ClienteDAO
	 */
	public static List<Cliente> buscarTodos(Connection conexao) throws Exception {
		return new ClienteDAO().buscarTodos(conexao);
	}

	/**
	 * Descrição
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param id
	 * @param conexao
	 * @return cliente
	 * @throws Exception
	 * @see Cliente, ClienteDAO
	 */
	public static Cliente buscarPorCodigo(int id, Connection conexao) throws Exception {
		return new ClienteDAO().buscarPorCodigo(id, conexao);
	}

	/**
	 * Descrição
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param cliente
	 * @param conexao
	 * @throws Exception
	 * @see Cliente, ClienteDAO
	 */
	public static void editar(Cliente cliente, Connection conexao) throws Exception {
		if (cliente.getNome().length() < 2) {
			throw new Excecao("Caracteres insuficientes no nome do Cliente");
		}
		
		new ClienteDAO().editar(cliente, conexao);
	}

	/**
	 * Descrição
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param id
	 * @param conexao
	 * @throws Exception
	 * @see Cliente, ClienteDAO
	 */
	public static void excluir(int id, Connection conexao) throws Exception {
		new ClienteDAO().excluir(id, conexao);
	}
}
