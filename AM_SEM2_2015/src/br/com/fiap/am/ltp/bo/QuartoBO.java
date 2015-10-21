package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Cliente;
import br.com.fiap.am.ltp.beans.Quarto;
import br.com.fiap.am.ltp.dao.ClienteDAO;
import br.com.fiap.am.ltp.dao.QuartoDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
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
	 * Busca todos os clientes cadastrados no banco de dados.
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
}