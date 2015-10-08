package br.com.fiap.am.ltp.bo;

import java.sql.Connection;

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
	 * @author Lucas 74795
	 * @since 2.0
	 * @param bairro
	 * @param conexao
	 * @throws Exception
	 */
	public static void novoBairro(Bairro bairro, Connection conexao)
			throws Exception {
		if (bairro.getNome().length() < 2) {
			throw new Excecao("Caracteres insuficientes no nome do Bairro");
		}

		new BairroDAO().gravar(bairro, conexao);
	}
}
