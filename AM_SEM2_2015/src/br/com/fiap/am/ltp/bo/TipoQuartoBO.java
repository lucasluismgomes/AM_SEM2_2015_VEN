package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Quarto;
import br.com.fiap.am.ltp.beans.TipoQuarto;
import br.com.fiap.am.ltp.dao.QuartoDAO;
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
			throw new Excecao("Caracteres insuficientes no nome do tipo de quarto.");
		}

		new TipoQuartoDAO().gravar(tipoQuarto, conexao);
	}
	
	/**
	 * Edita os dados do tipo de quarto no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param quarto
	 *            O Tipo de Quarto que está sendo editado.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see TipoQuarto, TipoQuartoDAO
	 */
	public static void editar(TipoQuarto tipoQuarto, Connection conexao) throws Exception {
		if (tipoQuarto.getNomeTipo().length() < 3) {
			throw new Excecao("Caracteres insuficientes no nome do tipo de quarto.");
		}

		new TipoQuartoDAO().editar(tipoQuarto, conexao);
	}
	
	/**
	 * Excluí um Tipo de Quarto do banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param codigo
	 *            O código do Tipo de Quarto que será excluído do banco de dados.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @throws Exception
	 * @see TipoQuarto, TipoQuartoDAO
	 */
	public static void excluir(int codigo, Connection conexao) throws Exception {
		new TipoQuartoDAO().excluir(codigo, conexao);
	}
	
		
	/**
	 * Busca todos os tipos de quartos cadastrados no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param conexao
	 *            As credenciais da conexão.
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
	 * @author Estevão 74803
	 * @since 1.0
	 * @param codigo
	 *            O codigo do Tipo de Quarto que está sendo buscado.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return tipoQuarto
	 * @throws Exception
	 * @see TipoQuarto, TipoQuartoDAO
	 */
	public static TipoQuarto buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		return new TipoQuartoDAO().buscarPorCodigo(codigo, conexao);
	}
	
}