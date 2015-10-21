package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Cliente;
import br.com.fiap.am.ltp.beans.Quarto;
import br.com.fiap.am.ltp.dao.ClienteDAO;
import br.com.fiap.am.ltp.dao.QuartoDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descri��o da classe/m�todo
 * 
 * @author Estev�o 74803
 * @version 1.0
 * @since 1.0
 */
public class QuartoBO {

	/**
	 * Faz a grava��o de um Quarto no banco de dados. A descri��o deve possuir no
	 * min�mo 5 caracteres.
	 * 
	 * @author Estev�o 74803
	 * @since 1.0
	 * @param quarto
	 *            O quarto que est� sendo gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @throws Exception
	 * @see Quarto, QuartoDAO
	 */
	public static void gravar(Quarto quarto, Connection conexao) throws Exception {
		if (quarto.getNrAndar() < 0 && quarto.getNrAndar() > 11) {
			throw new Excecao("O andar n�o confere.");
		}

		new QuartoDAO().gravar(quarto, conexao);
	}
	
	/**
	 * Busca todos os clientes cadastrados no banco de dados.
	 * 
	 * @author Estev�o 74803
	 * @since 1.0
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @return lstQuarto
	 * @throws Exception
	 * @see Quarto, QuartoDAO
	 */
	public static List<Quarto> buscarTodos(Connection conexao) throws Exception {
		return new QuartoDAO().buscarTodos(conexao);
	}
}