package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.am.ltp.conexao.ConexaoFactory;

/**
 * Possui os objetos e métodos necessários para a conexão com o banco.
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public abstract class DAO {
	protected Connection conexao;
	protected PreparedStatement estrutura;
	protected ResultSet resultadoDados;

	/**
	 * Abre a conexão com o banco de dados
	 * 
	 * @throws Exception, SQLException, ClassNotFoundException
	 */
	protected void abrirConexao() throws Exception, SQLException, ClassNotFoundException {
		conexao = new ConexaoFactory().getConnection();
	}

	/**
	 * Fecha a conexão com o banco de dados
	 * 
	 * @throws SQLException
	 */
	protected void fecharConexao() throws SQLException {
		if (conexao != null && !conexao.isClosed()) {
			resultadoDados.close();
			estrutura.close();
			conexao.close();
		}
	}
}
