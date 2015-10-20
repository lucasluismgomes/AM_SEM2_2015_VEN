package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Telefone;
import br.com.fiap.am.ltp.dao.TelefoneDAO;

/**
 * Regras de neg�cio e chamadas da DAO da classe Telefone.
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class TelefoneBO {
	/**
	 * Faz a grava��o de um telefone no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param telefone
	 * 			O telefone que ser� gravado no banco de dados.
	 * @param conexao
	 * 			As credenciais da conex�o.
	 * @throws Exception
	 * @see Telefone, TelefoneDAO
	 */
	public static void gravar(Telefone telefone, Connection conexao) throws Exception {
		new TelefoneDAO().gravar(telefone, conexao);
	}
	
	/**
	 * Faz a busca de todos os telefones no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param conexao
	 * 			As credenciais da conex�o.
	 * @return <code>lstTelefone</code> A lista com todos os telefones do banco de dados.
	 * @throws Exception
	 * @see Telefone, TelefoneDAO
	 */
	public static List<Telefone> buscarTodos(Connection conexao) throws Exception {
		return new TelefoneDAO().buscarTodos(conexao);
	}
	
	/**
	 * Faz a busca de todos os telefones no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param codigoPessoa
	 * 			O c�digo da pessoa o qual os telefones ser�o buscados no banco de dados.
	 * @param conexao
	 * 			As credenciais da conex�o.
	 * @return <code>lstTelefone</code> A lista com todos os telefones de uma pessoa do banco de dados.
	 * @throws Exception
	 * @see Telefone, TelefoneDAO
	 */
	public static List<Telefone> buscarPorCodigoPessoa(int codigoPessoa, Connection conexao) throws Exception {
		return new TelefoneDAO().buscarPorCodigoPessoa(codigoPessoa, conexao);
	}
	
	/**
	 * Edita um telefone no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param telefone
	 * 			O telefone que ser� editado no banco de dados.
	 * @param conexao
	 * 			As credenciais da conex�o.
	 * @throws Exception
	 * @see Telefone, TelefoneDAO
	 */
	public static void editar(Telefone telefone, Connection conexao) throws Exception {
		new TelefoneDAO().editar(telefone, conexao);
	}
	
	/**
	 * Exclu� um telefone do banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param codigo
	 * 			O c�digo do telefone que ser� exclu�do do banco de dados.
	 * @param conexao
	 * 			As credenciais da conex�o.
	 * @throws Exception
	 * @see Telefone, TelefoneDAO
	 */
	public static void excluir(int codigo, Connection conexao) throws Exception {
		new TelefoneDAO().excluir(codigo, conexao);
	}
}
