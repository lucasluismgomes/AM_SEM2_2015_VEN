package br.com.fiap.am.ltp.bo;

import java.sql.Connection;

import br.com.fiap.am.ltp.beans.Consumo;
import br.com.fiap.am.ltp.dao.ConsumoDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descri��o da classe/m�todo
 * 
 * @author Estev�o 74803
 * @version 1.0
 * @since 1.0
 */
public class ConsumoBO {

	/**
	 * Faz a grava��o de um Consumo no banco de dados. A quantidade deve ser maior que zero 
	 * 
	 * @author Estev�o 74803
	 * @since 1.0
	 * @param Consumo
	 *            O Consumo que est� sendo gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @throws Exception
	 * @see Consumo, ConsumoDAO
	 */
	public static void gravar(Consumo consumo, Connection conexao) throws Exception {
		if (consumo.getQuantidade() <= 0) {
			throw new Excecao("A quantidade n�o confere.");
		}

		new ConsumoDAO().gravar(consumo, conexao);
	}
}
