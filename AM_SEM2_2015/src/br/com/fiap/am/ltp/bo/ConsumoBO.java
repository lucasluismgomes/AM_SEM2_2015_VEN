package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

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
	 * Faz a grava��o de um Consumo no banco de dados. A quantidade deve ser maior que zero.
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
	 * Edita os dados do consumo no banco de dados. A quantidade deve ser maior que zero.
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
	 * Exclu� um Consumo do banco de dados. isso ir� excluir o hist�rico do consumo.
	 * 
	 * @author Estev�o 74803
	 * @since 1.0
	 * @param codigo
	 *            O c�digo do Consumo que ser� exclu�do do banco de dados.
	 * @param conexao
	 * 			As credenciais da conex�o.
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
	}
