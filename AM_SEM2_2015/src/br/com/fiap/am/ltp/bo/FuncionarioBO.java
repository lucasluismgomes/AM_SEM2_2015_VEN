package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Funcionario;
import br.com.fiap.am.ltp.dao.FuncionarioDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class FuncionarioBO {
	/**
	 * Grava um novo funcionário no banco de dados. O nome do funcionário deve
	 * ter no minimo 3 caracteres.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param funcionario
	 *            O funcionário que será gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Funcionario, FuncionarioDAO
	 */
	public static void gravar(Funcionario funcionario, Connection conexao) throws Exception {
		if (funcionario.getNome().length() < 2) {
			throw new Excecao("Número insuficiente de caracteres no nome do funcionário");
		}

		new FuncionarioDAO().gravar(funcionario, conexao);
	}

	/**
	 * @author Lucas 74795
	 * @since 1.0
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @return <code>lstFuncionario</code> Uma lsiat com todos os funcionários do banco de dados.
	 * @throws Exception
	 * @see Funcionario, FuncionarioDAO
	 */
	public static List<Funcionario> buscarTodos(Connection conexao) throws Exception {
		return new FuncionarioDAO().buscarTodos(conexao);
	}
}
