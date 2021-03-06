package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Consumo;
import br.com.fiap.am.ltp.dao.ConsumoDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * M�todos com as regras de neg�cio da aplica��o referente a Consumo.
 * 
 * @author Estev�o 74803, Lucas 74795
 * @version 1.0
 * @since 1.0
 * @see Consumo, ConsumoDAO
 */
public class ConsumoBO {

	/**
	 * Faz a edi��o em massa de consumos no banco de dads referente a uma hospedagem.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param lstConsumo
	 * 			A lista com os consumos que ser�o editados.
	 * @param conexao
	 * 			As creenciais da conex�o.
	 * @throws Exception
	 * @see Consumo, ConsumoDAO
	 */
	public void editarEmMassa(List<Consumo> lstConsumo, Connection conexao) throws Exception {
		new ConsumoDAO().editarEmMassa(lstConsumo, conexao);
	}
	
	/**
	 * Faz a grava��o de um Consumo no banco de dados. A quantidade deve ser
	 * maior que zero.
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

	/**
	 * Edita os dados do consumo no banco de dados. A quantidade deve ser maior
	 * que zero.
	 * 
	 * @author Estev�o 74803
	 * @since 1.0
	 * @param consumo
	 *            O Consumo que est� sendo editado.
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @throws Exception
	 * @see Consumo, ConsumoDAO
	 */
	public static void editar(Consumo consumo, Connection conexao) throws Exception {
		if (consumo.getQuantidade() <= 0) {
			throw new Excecao("A quantidade n�o confere.");
		}

		new ConsumoDAO().editar(consumo, conexao);
	}

	/**
	 * Exclu� um Consumo do banco de dados. isso ir� excluir o hist�rico do
	 * consumo.
	 * 
	 * @author Estev�o 74803
	 * @since 1.0
	 * @param codigo
	 *            O c�digo do Consumo que ser� exclu�do do banco de dados.
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @throws Exception
	 * @see Consumo, ConsumoDAO
	 */
	public static void excluir(int codigo, Connection conexao) throws Exception {
		new ConsumoDAO().excluir(codigo, conexao);
	}

	/**
	 * Busca todos os consumos cadastrados no banco de dados.
	 * 
	 * @author Estev�o 74803
	 * @since 1.0
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @return lstConsumo
	 * @throws Exception
	 * @see Consumo, ConsumoDAO
	 */
	public static List<Consumo> buscarTodos(Connection conexao) throws Exception {
		return new ConsumoDAO().buscarTodos(conexao);
	}

	/**
	 * Busca um Consumo especifico no banco de dados.
	 * 
	 * @author Estev�o 74803
	 * @since 1.0
	 * @param codigo
	 *            O codigo do Consumo que est� sendo buscado.
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @return consumo
	 * @throws Exception
	 * @see Consumo, ConsumoDAO
	 */
	public static Consumo buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		return new ConsumoDAO().buscarPorCodigo(codigo, conexao);
	}

	/**
	 * Busca todos os consumos cadastrados no banco de dados para uma Hospedagem
	 * espec�fica.
	 * 
	 * @author Estev�o 74803
	 * @since 1.0
	 * @param codigo
	 *            C�digo da Hospedagem em que ser�o buscados os Consumos
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @return lstConsumo
	 * @throws Exception
	 * @see Consumo, ConsumoDAO
	 */
	public static List<Consumo> buscarPorHospedagem(int codigo, Connection conexao) throws Exception {
		return new ConsumoDAO().buscarPorHospedagem(codigo, conexao);
	}
	
	/**
	 * Descri��o
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param codigo
	 * 			C�digo da Hospedagem em que ser�o calculados os Consumos.
	 * @param conexao
	 * 			As credenciais da conex�o.
	 * @return
	 * @throws Exception
	 */
	public static double valorTotalConsumo(int codigo, Connection conexao) throws Exception {
		return new ConsumoDAO().valorTotalConsumo(codigo, conexao);
	}
}
