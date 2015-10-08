package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.fiap.am.ltp.beans.Status;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descri��o da classe/m�todo
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
	 * @param status O status que ser� gravado
	 * @throws Exception
	 */
	public void gravar(Status status, Connection conexao) throws Exception {
		try {
			System.out.println("Chegou na DAO");
			String sql = "INSERT INTO T_AM_HBV_STATUS VALUES(?,?)";
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, status.getNomeStatus());
			estrutura.setInt(2, status.getCodigo());

			estrutura.execute();
			estrutura.close();
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
}
