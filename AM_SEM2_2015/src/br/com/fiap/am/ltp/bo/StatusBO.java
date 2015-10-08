package br.com.fiap.am.ltp.bo;

import java.sql.Connection;

import br.com.fiap.am.ltp.beans.Status;
import br.com.fiap.am.ltp.dao.StatusDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class StatusBO {
	/**
	 * 
	 * 
	 * @param status
	 * @param conexao
	 * @throws Exception
	 */
	public static void novoStatus(Status status, Connection conexao)
			throws Exception {
		if (status.getNomeStatus().length() < 2) {
			throw new Excecao("Caracteres insuficientes no nome do Bairro");
		}

		new StatusDAO().gravar(status, conexao);
	}
}
