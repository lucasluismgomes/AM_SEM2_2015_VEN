package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Cliente;
import br.com.fiap.am.ltp.dao.ClienteDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Regras de negócio da classe Cliente.
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 * @see Cliente, ClienteDAO
 */
public class ClienteBO {
	/**
	 * Faz a gravação de um Cliente no banco de dados. Seu nome deve possuir no
	 * minímo 3 caracteres.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param cliente
	 *            O cliente que está sendo gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Cliente, ClienteDAO
	 */
	public static void gravar(Cliente cliente, Connection conexao) throws Exception {
		if (cliente.getNome().length() < 2) {
			throw new Excecao("Caracteres insuficientes no nome do Cliente");
		}

		new ClienteDAO().gravar(cliente, conexao);
	}

	/**
	 * Busca todos os clientes cadastrados no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return lstCliente
	 * @throws Exception
	 * @see Cliente, ClienteDAO
	 */
	public static List<Cliente> buscarTodos(Connection conexao) throws Exception {
		return new ClienteDAO().buscarTodos(conexao);
	}

	/**
	 * Busca um Cliente especifico no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param codigo
	 *            O codigo do Cliente que está sendo buscado.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return cliente
	 * @throws Exception
	 * @see Cliente, ClienteDAO
	 */
	public static Cliente buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		return new ClienteDAO().buscarPorCodigo(codigo, conexao);
	}

	/**
	 * Edita os dados do cliente no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param cliente
	 *            O Cliente que está sendo editado.
	 * @param conexao
	 *            As credenciais da conexão.
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
	 * Excluí um Cliente do banco de dados. isso irá excluir suas reservas,
	 * hospedagens, telefone, endereço e consumos.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param codigo
	 *            O código do Cliente que será excluído do banco de dados.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @throws Exception
	 * @see Cliente, ClienteDAO
	 */
	public static void excluir(int codigo, Connection conexao) throws Exception {
		new ClienteDAO().excluir(codigo, conexao);
	}
}
