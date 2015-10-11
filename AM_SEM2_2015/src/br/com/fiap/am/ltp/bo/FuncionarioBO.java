package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Funcionario;
import br.com.fiap.am.ltp.dao.FuncionarioDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descri��o da classe/m�todo
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class FuncionarioBO {
	/**
	 * Grava um novo funcion�rio no banco de dados. O nome do funcion�rio deve
	 * ter no minimo 3 caracteres.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param funcionario
	 *            O funcion�rio que ser� gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @throws Exception
	 * @see Funcionario, FuncionarioDAO
	 */
	public static void gravar(Funcionario funcionario, Connection conexao) throws Exception {
		if (funcionario.getNome().length() < 2) {
			throw new Excecao("N�mero insuficiente de caracteres no nome do funcion�rio");
		}

		new FuncionarioDAO().gravar(funcionario, conexao);
	}

	/**
	 * @author Lucas 74795
	 * @since 1.0
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @return <code>lstFuncionario</code> Uma lista com todos os funcion�rios
	 *         do banco de dados.
	 * @throws Exception
	 * @see Funcionario, FuncionarioDAO
	 */
	public static List<Funcionario> buscarTodos(Connection conexao) throws Exception {
		return new FuncionarioDAO().buscarTodos(conexao);
	}

	/**
	 * Faz a busca de um funcion�rio no banco de dados que tenha um id
	 * especifico.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param codigo
	 *            O c�digo do funcion�rio que ser� buscado.
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @return <code>funcionario</code> O funcionario que foi buscado no banco
	 *         de dados.
	 * @throws Exception
	 * @see Funcionario, FuncionarioDAO
	 */
	public static Funcionario buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		return new FuncionarioDAO().buscarPorCodigo(codigo, conexao);
	}
	
	/**
	 * Edita as informa��es de um funcion�rio no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param funcionario
	 * 			O funcion�rio que ser� editado no banco de dados.
	 * @param conexao
	 * 			As credenciais da conex�o.
	 * @throws Exception
	 * @see Funcionario, FuncionarioDAO
	 */
	public static void editar(Funcionario funcionario, Connection conexao) throws Exception {
		if (funcionario.getNome().length() < 2) {
			throw new Excecao("N�mero insuficiente de caracteres no nome do funcion�rio");
		}
		
		new FuncionarioDAO().editar(funcionario, conexao);
	}
	
	/**
	 * Apaga um funcion�rio do banco de dados. Essa a��o ir� apgar todas as
	 * informa��es dele, bem como hospedagens e consumos que registrou.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param codigo
	 * 			O c�digo do funcion�rio que ser� exclu�do.
	 * @param conexao
	 * 			As credenciais da conex�o.
	 * @throws Exception
	 * @see Funcionario, FuncionarioDAO
	 */
	public static void excluir(int codigo, Connection conexao) throws Exception {
		new FuncionarioDAO().excluir(codigo, conexao);
	}
}
