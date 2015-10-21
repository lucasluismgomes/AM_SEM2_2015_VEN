package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Quarto;
import br.com.fiap.am.ltp.beans.TipoQuarto;
import br.com.fiap.am.ltp.dao.QuartoDAO;
import br.com.fiap.am.ltp.dao.TipoQuartoDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descri��o da classe/m�todo
 * 
 * @author Estev�o 74803
 * @version 1.0
 * @since 1.0
 */
public class TipoQuartoBO {

	/**
	 * Faz a grava��o de um Tipo de Quarto no banco de dados. O nome do tipo deve possuir no
	 * min�mo 3 caracteres.
	 * 
	 * @author Estev�o 74803
	 * @since 1.0
	 * @param tipo de quarto
	 *            O tipo de quarto que est� sendo gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @throws Exception
	 * @see TipoQuarto, TipoQuartoDAO
	 */
	public static void gravar(TipoQuarto tipoQuarto, Connection conexao) throws Exception {
		if (tipoQuarto.getNomeTipo().length() < 3) {
			throw new Excecao("Caracteres insuficientes na descri��o do quarto");
		}

		new TipoQuartoDAO().gravar(tipoQuarto, conexao);
	}
	
	/**
	 * Busca todos os tipos de quartos cadastrados no banco de dados.
	 * 
	 * @author Estev�o 74803
	 * @since 1.0
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @return lstTipoQuarto
	 * @throws Exception
	 * @see TipoQuarto, TipoQuartoDAO
	 */
	public static List<TipoQuarto> buscarTodos(Connection conexao) throws Exception {
		return new TipoQuartoDAO().buscarTodos(conexao);
	}
	
	/**
	 * Busca um Tipo de Quarto especifico no banco de dados.
	 * 
	 * @author Estev�o 74803
	 * @since 1.0
	 * @param codigo
	 *            O codigo do Tipo de Quarto que est� sendo buscado.
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @return tipoQuarto
	 * @throws Exception
	 * @see TipoQuarto, TipoQuartoDAO
	 */
	public static TipoQuarto buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		return new TipoQuartoDAO().buscarPorCodigo(codigo, conexao);
	}
	
}