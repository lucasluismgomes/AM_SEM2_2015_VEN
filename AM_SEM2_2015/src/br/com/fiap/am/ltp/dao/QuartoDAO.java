package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.fiap.am.ltp.beans.Quarto;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Estevão 74803
 * @version 1.0
 * @since 1.0
 * @see Meu Beans
 */
public class QuartoDAO {
	
	private String sql = "";
	private PreparedStatement estrutura = null;
	//private ResultSet rs = null;

	/**
	 * Grava os dados de um quarto no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param quarto
	 *            O Quarto que será gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Quarto, QuartoBO
	 */
	public void gravar(Quarto quarto, Connection conexao) throws Exception {
		try {
			sql = "INSERT INTO T_AM_HBV_QUARTO VALUES(SQ_AM_QUARTO.NEXTVAL,?,?,?,?)";
			estrutura.setInt(1, quarto.getTipo().getCodigo());
			estrutura.setInt(2, quarto.getNrAndar());
			estrutura.setShort(3, quarto.getNrCapacidade());
			estrutura.setBoolean(4, quarto.getStatus());
			estrutura = conexao.prepareStatement(sql);

			estrutura.executeQuery();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

}