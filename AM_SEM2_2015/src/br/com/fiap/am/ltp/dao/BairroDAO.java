package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.ltp.beans.Bairro;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Classe de acesso a dados de Bairro.
 * 
 * @author Lucas 74795
 * @version 2.0
 * @since 1.0
 * @see Bairro
 */
public class BairroDAO {
	/**
	 * Grava os dados de um bairro no banco de dados.
	 * 
	 * @param bairro O bairro que será gravado
	 * @throws Exception
	 */
	public void gravar(Bairro bairro, Connection conexao) throws Exception {
		try {
			String sql = "INSERT";
			PreparedStatement estrutura = conexao.prepareStatement(sql);

			// Código

			estrutura.execute();
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	/**
	 * Grava as alterações de um bairro no banco de dados.
	 * 
	 * @param bairro O bairro que está sendo alterado
	 * @throws Exception
	 */
	public void editar(Bairro bairro, Connection conexao) throws Exception {
		try{
			String sql = "UPDATE";
			PreparedStatement estrutura = conexao.prepareStatement(sql);
	
			// Código
	
			estrutura.execute();
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	/**
	 * Busca todos os bairros cadastrados no banco de dados.
	 * 
	 * @return lstBairro Uma lista com todos os bairros cadastrados
	 * @throws Exception
	 */
	public List<Bairro> buscarTodos(Bairro bairro, Connection conexao) throws Exception {
		try{
			List<Bairro> lstBairro = new ArrayList<Bairro>();
			
			String sql = "SELECT";
			PreparedStatement estrutura = conexao.prepareStatement(sql);
	
			// Código
	
			ResultSet resultadoDados = estrutura.executeQuery();
	
			if (resultadoDados.next()) {
				// Código
			}
	
	
			return lstBairro;
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	/**
	 * Apaga um bairro do banco de dados com base em seu id.
	 * 
	 * @param id O id do bairro que está sendo excluído
	 * @throws Exception
	 */
	public void excluir(int id, Connection conexao) throws Exception {
		try{
			String sql = "DELETE";
			PreparedStatement estrutura = conexao.prepareStatement(sql);
	
			// Código
	
			estrutura.execute();
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
}