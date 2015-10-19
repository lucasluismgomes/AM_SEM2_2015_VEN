package br.com.fiap.am.ltp.bo;

import java.sql.Connection;

import br.com.fiap.am.ltp.beans.TipoQuarto;
import br.com.fiap.am.ltp.dao.TipoQuartoDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Estevão 74803
 * @version 1.0
 * @since 1.0
 */
public class TipoQuartoBO {

	/**
	 * Faz a gravação de um Tipo de Quarto no banco de dados. O nome do tipo deve possuir no
	 * minímo 3 caracteres.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param tipo de quarto
	 *            O tipo de quarto que está sendo gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see TipoQuarto, TipoQuartoDAO
	 */
	public static void gravar(TipoQuarto tipoQuarto, Connection conexao) throws Exception {
		if (tipoQuarto.getNomeTipo().length() < 3) {
			throw new Excecao("Caracteres insuficientes na descrição do quarto");
		}

		new TipoQuartoDAO().gravar(tipoQuarto, conexao);
	}
	
}