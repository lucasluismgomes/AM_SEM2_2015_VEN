package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.ltp.beans.Bairro;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Classe de acesso a dados de Bairro.
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 * @see Bairro
 */
public class BairroDAO extends DAO {
	private Connection conexao;

	/**
	 * Construtor que realiza a abertura do banco.
	 * 
	 * @throws Exception
	 */
	public BairroDAO() throws Exception {
		abrirConexao();
	}
	
	/**
	 * Grava os dados de um bairro no banco de dados.
	 * 
	 * @param bairro O bairro que será gravado
	 * @throws Exception
	 */
	public void gravar(Bairro bairro) throws Exception {
		try {
			estrutura = conexao.prepareStatement("INSERT");

			// Código

			estrutura.execute();
		} catch (Exception e) {
			throw new Excecao(e);
		} finally {
			fecharConexao();
		}
	}

	/**
	 * Grava as alterações de um bairro no banco de dados.
	 * 
	 * @param bairro O bairro que está sendo alterado
	 * @throws Exception
	 */
	public void editar(Bairro bairro) throws Exception {
		try{
			estrutura = conexao.prepareStatement("UPDATE");
	
			// Código
	
			estrutura.execute();
		} catch (Exception e) {
			throw new Excecao(e);
		} finally {
			fecharConexao();
		}
	}

	/**
	 * Busca todos os bairros cadastrados no banco de dados.
	 * 
	 * @return Uma lista com todos os bairros cadastrados
	 * @throws Exception
	 */
	public List<Bairro> buscarTodos() throws Exception {
		try{
			List<Bairro> lstBairro = new ArrayList<Bairro>();
			
			estrutura = conexao.prepareStatement("SELECT");
	
			// Código
	
			resultadoDados = estrutura.executeQuery();
	
			if (resultadoDados.next()) {
				// Código
			}
	
	
			return lstBairro;
		} catch (Exception e) {
			throw new Excecao(e);
		} finally {
			fecharConexao();
		}
	}

	/**
	 * Apaga um bairro do banco de dados com base em seu id.
	 * 
	 * @param id O id do bairro que está sendo excluído
	 * @throws Exception
	 */
	public void excluir(int id) throws Exception {
		try{
			estrutura = conexao.prepareStatement("DELETE");
	
			// Código
	
			estrutura.execute();
		} catch (Exception e) {
			throw new Excecao(e);
		} finally {
			fecharConexao();
		}
	}
}