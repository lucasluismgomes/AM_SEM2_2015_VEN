package br.com.fiap.am.ltp.bo;

import java.sql.Connection;

import br.com.fiap.am.ltp.beans.Consumo;
import br.com.fiap.am.ltp.dao.ConsumoDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Estevão 74803
 * @version 1.0
 * @since 1.0
 */
public class ConsumoBO {

	/**
	 * Faz a gravação de um Consumo no banco de dados. A quantidade deve ser maior que zero 
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param Consumo
	 *            O Consumo que está sendo gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Consumo, ConsumoDAO
	 */
	public static void gravar(Consumo consumo, Connection conexao) throws Exception {
		if (consumo.getQuantidade() <= 0) {
			throw new Excecao("A quantidade não confere.");
		}

		new ConsumoDAO().gravar(consumo, conexao);
	}
}
