package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Bairro;
import br.com.fiap.am.ltp.dao.BairroDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 2.0
 * @since 1.0
 */
public abstract class BairroBO {
	/**
	 * Cadastra um Bairro no banco de dados. Seu nome deve ter mais de dois caracteres.
	 * 
	 * @param bairro Leva as informações do bairro para a gravação no banco de dados.
	 * @param conexao Leva as crendencias
	 * @throws Exception
	 * @see Bairro, BairroBO
	 */
	public static boolean gravar(Bairro bairro, Connection conexao)
			throws Exception {
		if (bairro.getNome().length() < 2) {
			throw new Excecao("Caracteres insuficientes no nome do Bairro");
		}

		return new BairroDAO().gravar(bairro, conexao);
	}
	public static boolean editar(Bairro bairro,Connection conexao) throws Exception
	{
		return new BairroDAO().editar(bairro, conexao);
	}
	public static boolean apagar(int codigo,Connection conexao) throws Exception
	{
		return new BairroDAO().excluir(codigo, conexao);
	}
	public static List<Bairro> buscarPorNome(String pesquisaBairro,Connection conexao) throws Exception
	{
		return new BairroDAO().buscarPorNome(pesquisaBairro, conexao);
	}
	public static List<Bairro> buscarTodos(Connection conexao) throws Exception
	{
		return new BairroDAO().buscarTodos(conexao);
	}
}
