package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.TipoTelefone;
import br.com.fiap.am.ltp.dao.TipoTelefoneDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class TipoTelefoneBO {
	/**
	 * Grava um Tipo de Telefone no banco de dados. O nome precisa ter no mínimo 3 caracteres para ser gravado.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param tipoTelefone
	 * 			O tipo de telefone que está sendo gravado no banco de dados.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @throws Exception
	 * @see TipoTelefone, TipoTelefoneDAO
	 */
	public static void gravar(TipoTelefone tipoTelefone, Connection conexao)
			throws Exception {
		if (tipoTelefone.getNome().length() < 2) {
			throw new Excecao("Caracteres insuficientes no nome do tipo de telefone");
		}

		new TipoTelefoneDAO().gravar(tipoTelefone, conexao);
	}
	
	/**
	 * Busca todos os tipos de telefone do banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 2.0
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @return <code>lstTipotelefone</code>
	 * 			Uma lista com todos os tipos de telefone disponiveis no banco de dados.
	 * @throws Exception
	 * @see TipoTelefone, TipoTelefoneDAO
	 */
	public static List<TipoTelefone> buscarTodos(Connection conexao) throws Exception {
		return new TipoTelefoneDAO().buscarTodos(conexao);
	}
	
	/**
	 * Busca apenas o tipo de telefone com o código fornecido.
	 * 
	 * @author Lucas 74795
	 * @since 3.0
	 * @param codigo
	 * 			Código do tipo de telefone que está sendo buscado.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @return <code>tipoTelefone</code>
	 * 			O tipo de telefone que foi buscado, caso o código passado esteja correto.
	 * @throws Exception
	 * @see TipoTelefone, TipoTelefoneDAO
	 */
	public static TipoTelefone buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		return new TipoTelefoneDAO().buscarPorCodigo(codigo, conexao);
	}
	
	/**
	 * Edita um tipo de telefone de acordo com seu código. O novo nome deve ser único no
	 * banco de dados e deve possuir 3 ou mais caracteres
	 * 
	 * @author Lucas 74795
	 * @since 3.0
	 * @param tipoTelefone
	 * 			O tipo de telefone que está sendo editado, contendo seu código e novo nome
	 * @param conexao
	 * 			Credenciais da conexão.
	 * @throws Exception
	 * @see TipoTelefone, TipoTelefoneDAO
	 */
	public static void editar(TipoTelefone tipoTelefone, Connection conexao) throws Exception {
		if (tipoTelefone.getNome().length() < 2) {
			throw new Excecao("Caracteres insuficientes no nome do tipo de telefone");
		}
		
		new TipoTelefoneDAO().editar(tipoTelefone, conexao);
	}
	
	/**
	 * Excluí um tipo de telefone do banco que tenha o código correspondente ao código passado.
	 * 
	 * @author Lucas 74795
	 * @since 3.0
	 * @param codigo
	 * 			Código do tipo de telefone que será excluído.
	 * @param conexao
	 * 			Credenciais da conexão.
	 * @throws Exception
	 * @see TipoTelefone, TipoTelefoneDAO
	 */
	public static void excluir(int codigo, Connection conexao) throws Exception {
		new TipoTelefoneDAO().excluir(codigo, conexao);
	}
}
