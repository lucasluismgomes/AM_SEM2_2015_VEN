package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

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
	 * Faz a gravação de um Consumo no banco de dados. A quantidade deve ser maior que zero.
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
	
	/**
	 * Edita os dados do consumo no banco de dados. A quantidade deve ser maior que zero.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param consumo
	 *            O Consumo que está sendo editado.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Consumo, ConsumoDAO
	 */
	public static void editar(Consumo consumo, Connection conexao) throws Exception {
		if (consumo.getQuantidade() <= 0) {
			throw new Excecao("A quantidade não confere.");
		}

		new ConsumoDAO().editar(consumo, conexao);
	}

	/**
	 * Excluí um Consumo do banco de dados. isso irá excluir o histórico do consumo.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param codigo
	 *            O código do Consumo que será excluído do banco de dados.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @throws Exception
	 * @see Consumo, ConsumoDAO
	 */
	public static void excluir(int codigo, Connection conexao) throws Exception {
		new ConsumoDAO().excluir(codigo, conexao);
	}

	
	/**
	 * Busca todos os consumos cadastrados no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param conexao
	 *            As credenciais da conexão.
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
	 * @author Estevão 74803
	 * @since 1.0
	 * @param codigo
	 *            O codigo do Consumo que está sendo buscado.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return consumo
	 * @throws Exception
	 * @see Consumo, ConsumoDAO
	 */
	public static Consumo buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		return new ConsumoDAO().buscarPorCodigo(codigo, conexao);
		}
	}
