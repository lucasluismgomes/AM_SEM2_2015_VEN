package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Quarto;
import br.com.fiap.am.ltp.dao.QuartoDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Métodos onde consta as regras de neócio para a classe Quarto.
 * 
 * @author Estevão 74803
 * @version 1.0
 * @since 1.0
 */
public class QuartoBO {

	/**
	 * Faz a gravação de um Quarto no banco de dados. A descrição deve possuir no
	 * minímo 5 caracteres.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param quarto
	 *            O quarto que está sendo gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Quarto, QuartoDAO
	 */
	public static void gravar(Quarto quarto, Connection conexao) throws Exception {
		if (quarto.getNrAndar() < 0 && quarto.getNrAndar() > 11) {
			throw new Excecao("O andar não confere.");
		}

		new QuartoDAO().gravar(quarto, conexao);
	}
	
	/**
	 * Edita os dados do quarto no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param quarto
	 *            O Quarto que está sendo editado.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Quarto, QuartoDAO
	 */
	public static void editar(Quarto quarto, Connection conexao) throws Exception {
		if (quarto.getNrAndar() < 0 && quarto.getNrAndar() > 11) {
			throw new Excecao("O andar não confere.");
		}

		new QuartoDAO().editar(quarto, conexao);
	}
	
	/**
	 * Excluí um Quarto do banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param codigo
	 *            O código do Quarto que será excluído do banco de dados.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @throws Exception
	 * @see Quarto, QuartoDAO
	 */
	public static void excluir(int codigo, Connection conexao) throws Exception {
		new QuartoDAO().excluir(codigo, conexao);
	}
	
	/**
	 * Busca todos os quartos cadastrados no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return lstQuarto
	 * @throws Exception
	 * @see Quarto, QuartoDAO
	 */
	public static List<Quarto> buscarTodos(Connection conexao) throws Exception {
		return new QuartoDAO().buscarTodos(conexao);
	}
	
	
	/**
	 * Busca um Quarto especifico no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param codigo
	 *            O codigo do Quarto que está sendo buscado.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return quarto
	 * @throws Exception
	 * @see Quarto, QuartoDAO
	 */
	public static Quarto buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		return new QuartoDAO().buscarPorCodigo(codigo, conexao);
	}
}