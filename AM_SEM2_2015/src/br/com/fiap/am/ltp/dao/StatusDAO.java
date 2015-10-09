package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.fiap.am.ltp.beans.Status;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 * @see Meu Beans
 */
public class StatusDAO {
	/**
	 * Grava os dados de um status no banco de dados.
	 * 
	 * @param status O status que será gravado
	 * @throws Exception
	 */
	public void gravar(Status status, Connection conexao) throws Exception {
		try {
			String sql = "INSERT INTO T_AM_HBV_STATUS VALUES(?,?)";
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, status.getCodigo());
			estrutura.setString(2, status.getNomeStatus());

			estrutura.execute();
			estrutura.close();
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
}
