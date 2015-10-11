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
	 *            As credenciais da conexão.
	 * @return <code>lstFuncionario</code> Uma lista com todos os funcionários
	 *         do banco de dados.
	 * @throws Exception
	 * @see Funcionario, FuncionarioDAO
	 */
	public static List<Funcionario> buscarTodos(Connection conexao) throws Exception {
		return new FuncionarioDAO().buscarTodos(conexao);
	}

	/**
	 * Faz a busca de um funcionário no banco de dados que tenha um id
	 * especifico.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param codigo
	 *            O código do funcionário que será buscado.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return <code>funcionario</code> O funcionario que foi buscado no banco
	 *         de dados.
	 * @throws Exception
	 * @see Funcionario, FuncionarioDAO
	 */
	public static Funcionario buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		return new FuncionarioDAO().buscarPorCodigo(codigo, conexao);
	}
	
	/**
	 * Edita as informações de um funcionário no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param funcionario
	 * 			O funcionário que será editado no banco de dados.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @throws Exception
	 * @see Funcionario, FuncionarioDAO
	 */
	public static void editar(Funcionario funcionario, Connection conexao) throws Exception {
		if (funcionario.getNome().length() < 2) {
			throw new Excecao("Número insuficiente de caracteres no nome do funcionário");
		}
		
		new FuncionarioDAO().editar(funcionario, conexao);
	}
	
	/**
	 * Apaga um funcionário do banco de dados. Essa ação irá apgar todas as
	 * informações dele, bem como hospedagens e consumos que registrou.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param codigo
	 * 			O código do funcionário que será excluído.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @throws Exception
	 * @see Funcionario, FuncionarioDAO
	 */
	public static void excluir(int codigo, Connection conexao) throws Exception {
		new FuncionarioDAO().excluir(codigo, conexao);
	}
}
