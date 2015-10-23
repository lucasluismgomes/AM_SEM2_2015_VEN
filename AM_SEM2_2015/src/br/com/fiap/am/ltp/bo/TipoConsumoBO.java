package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.TipoConsumo;
import br.com.fiap.am.ltp.dao.TipoConsumoDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descri��o da classe/m�todo
 * 
 * @author Estev�o 74803
 * @version 1.0
 * @since 1.0
 */
public class TipoConsumoBO {

	/**
	 * Faz a grava��o de um Tipo de Consumo no banco de dados. O nome do tipo deve possuir no
	 * min�mo 3 caracteres.
	 * 
	 * @author Estev�o 74803
	 * @since 1.0
	 * @param tipo de Consumo
	 *            O tipo de Consumo que est� sendo gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @throws Exception
	 * @see TipoConsumo, TipoConsumoDAO
	 */
	public static void gravar(TipoConsumo tipoConsumo, Connection conexao) throws Exception {
		if (tipoConsumo.getNome().length() < 3) {
			throw new Excecao("Caracteres insuficientes no nome do tipo de Consumo.");
		}
		if (tipoConsumo.getTipo() > 2 || tipoConsumo.getTipo() < 1) {
			throw new Excecao("N�o existe o tipo de Consumo.");
		}
		
		new TipoConsumoDAO().gravar(tipoConsumo, conexao);
	}
	
	/**
	 * Edita os dados do tipo de Consumo no banco de dados.
	 * 
	 * @author Estev�o 74803
	 * @since 1.0
	 * @param Consumo
	 *            O Tipo de Consumo que est� sendo editado.
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @throws Exception
	 * @see TipoConsumo, TipoConsumoDAO
	 */
	public static void editar(TipoConsumo tipoConsumo, Connection conexao) throws Exception {
		if (tipoConsumo.getNome().length() < 3) {
			throw new Excecao("Caracteres insuficientes no nome do tipo de Consumo.");
		}
		if (tipoConsumo.getTipo() > 2 || tipoConsumo.getTipo() < 1) {
			throw new Excecao("N�o existe o tipo de Consumo.");
		}
		
		TipoConsumo tipoConsumoAtual = new TipoConsumo();
		
		tipoConsumoAtual = buscarPorCodigo(tipoConsumo.getCodigo(), conexao);
		
		double valorAtual = tipoConsumoAtual.getValor();
		double valorNovo = tipoConsumo.getValor();
		
		if(valorAtual != valorNovo){
			new TipoConsumoDAO().gravarHistoricoValor(tipoConsumo, conexao);
		}

		new TipoConsumoDAO().editar(tipoConsumo, conexao);
	}
	
	/**
	 * Exclu� um Tipo de Consumo do banco de dados.
	 * 
	 * @author Estev�o 74803
	 * @since 1.0
	 * @param codigo
	 *            O c�digo do Tipo de Consumo que ser� exclu�do do banco de dados.
	 * @param conexao
	 * 			As credenciais da conex�o.
	 * @throws Exception
	 * @see TipoConsumo, TipoConsumoDAO
	 */
	public static void excluir(int codigo, Connection conexao) throws Exception {
		new TipoConsumoDAO().excluir(codigo, conexao);
	}
	
		
	/**
	 * Busca todos os tipos de Consumo cadastrados no banco de dados.
	 * 
	 * @author Estev�o 74803
	 * @since 1.0
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @return lstTipoConsumo
	 * @throws Exception
	 * @see TipoConsumo, TipoConsumoDAO
	 */
	public static List<TipoConsumo> buscarTodos(Connection conexao) throws Exception {
		return new TipoConsumoDAO().buscarTodos(conexao);
	}
	
	/**
	 * Busca um Tipo de Consumo especifico no banco de dados.
	 * 
	 * @author Estev�o 74803
	 * @since 1.0
	 * @param codigo
	 *            O codigo do Tipo de Consumo que est� sendo buscado.
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @return tipoConsumo
	 * @throws Exception
	 * @see TipoConsumo, TipoConsumoDAO
	 */
	public static TipoConsumo buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		return new TipoConsumoDAO().buscarPorCodigo(codigo, conexao);
	}
	
}
