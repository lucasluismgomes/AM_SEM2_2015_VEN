package br.com.fiap.am.ltp.bo;

import java.sql.Connection;

import br.com.fiap.am.ltp.beans.Bairro;
import br.com.fiap.am.ltp.dao.BairroDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descri��o da classe/m�todo
 * 
 * @author Lucas 74795
 * @version 2.0
 * @since 1.0
 */
public abstract class BairroBO {
	/**
	 * Cadastra um Bairro no banco de dados. Seu nome deve ter mais de dois caracteres.
	 * 
	 * @param bairro Leva as informa��es do bairro para a grava��o no banco de dados.
	 * @param conexao Leva as crendencias
	 * @throws Exception
	 * @see Bairro, BairroBO
	 */
	public static void gravar(Bairro bairro, Connection conexao)
			throws Exception {
		if (bairro.getNome().length() < 2) {
			throw new Excecao("Caracteres insuficientes no nome do Bairro");
		}

		new BairroDAO().gravar(bairro, conexao);
	}
}
