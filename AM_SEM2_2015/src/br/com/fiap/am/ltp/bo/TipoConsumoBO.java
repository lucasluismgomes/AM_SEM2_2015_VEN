package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.TipoConsumo;
import br.com.fiap.am.ltp.dao.TipoConsumoDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Estevão 74803
 * @version 1.0
 * @since 1.0
 */
public class TipoConsumoBO {

	/**
	 * Faz a gravação de um Tipo de Consumo no banco de dados. O nome do tipo deve possuir no
	 * minímo 3 caracteres.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param tipo de Consumo
	 *            O tipo de Consumo que está sendo gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see TipoConsumo, TipoConsumoDAO
	 */
	public static void gravar(TipoConsumo tipoConsumo, Connection conexao) throws Exception {
		if (tipoConsumo.getNome().length() < 3) {
			throw new Excecao("Caracteres insuficientes no nome do tipo de Consumo.");
		}
		if (tipoConsumo.getTipo() > 2 || tipoConsumo.getTipo() < 1) {
			throw new Excecao("Não existe o tipo de Consumo.");
		}
		
		new TipoConsumoDAO().gravar(tipoConsumo, conexao);
	}
	
	/**
	 * Edita os dados do tipo de Consumo no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param Consumo
	 *            O Tipo de Consumo que está sendo editado.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see TipoConsumo, TipoConsumoDAO
	 */
	public static void editar(TipoConsumo tipoConsumo, Connection conexao) throws Exception {
		if (tipoConsumo.getNome().length() < 3) {
			throw new Excecao("Caracteres insuficientes no nome do tipo de Consumo.");
		}
		if (tipoConsumo.getTipo() > 2 || tipoConsumo.getTipo() < 1) {
			throw new Excecao("Não existe o tipo de Consumo.");
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
	 * Excluí um Tipo de Consumo do banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param codigo
	 *            O código do Tipo de Consumo que será excluído do banco de dados.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @throws Exception
	 * @see TipoConsumo, TipoConsumoDAO
	 */
	public static void excluir(int codigo, Connection conexao) throws Exception {
		new TipoConsumoDAO().excluir(codigo, conexao);
	}
	
		
	/**
	 * Busca todos os tipos de Consumo cadastrados no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param conexao
	 *            As credenciais da conexão.
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
	 * @author Estevão 74803
	 * @since 1.0
	 * @param codigo
	 *            O codigo do Tipo de Consumo que está sendo buscado.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return tipoConsumo
	 * @throws Exception
	 * @see TipoConsumo, TipoConsumoDAO
	 */
	public static TipoConsumo buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		return new TipoConsumoDAO().buscarPorCodigo(codigo, conexao);
	}
	
}
