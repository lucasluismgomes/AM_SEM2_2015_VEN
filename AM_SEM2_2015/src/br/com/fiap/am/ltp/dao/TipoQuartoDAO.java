package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.am.ltp.beans.TipoQuarto;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Estevão 74803
 * @version 1.0
 * @since 1.0
 * @see Meu Beans
 */
public class TipoQuartoDAO {

	private String sql = "";
	private PreparedStatement estrutura = null;
	private ResultSet rs = null;

	/**
	 * Grava os dados do tipo de quarto no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param tipo quarto
	 *            O Tipo Quarto que será gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see TipoQuarto, TipoQuartoBO
	 */
	public void gravar(TipoQuarto tipoQuarto, Connection conexao) throws Exception {
		try {
			sql = "INSERT INTO T_AM_HBV_TIPO_QUARTO VALUES(SQ_AM_TIPO_QUARTO.NEXTVAL,?,?)";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, tipoQuarto.getNomeTipo());
			estrutura.setDouble(2, tipoQuarto.getValor());
			
			estrutura.executeQuery();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Faz a busca de um tipo de quarto no banco de dados que tenha o id especificado.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param codigo
	 *            O código do tipo de quarto que está sendo buscado no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return <code>tipoQuarto</code> Dados do tipo de quarto com o id especificado.
	 * @throws Exception
	 * @see TipoQuarto, TipoQuartoBO
	 */
	public TipoQuarto buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		TipoQuarto tipoQuarto = new TipoQuarto();

		try {
			sql = "SELECT CD_TIPO_QUARTO, " + "DS_TIPO_QUARTO, " + "VL_QUARTO "
					+ "FROM T_AM_HBV_TIPO_QUARTO "
					+ "WHERE CD_TIPO_QUARTO = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, codigo);

			rs = estrutura.executeQuery();

			if (rs.next()) {

				tipoQuarto.setCodigo(Integer.parseInt(rs.getString("CD_TIPO_QUARTO")));
				tipoQuarto.setNomeTipo(rs.getString("DS_TIPO_QUARTO"));
				tipoQuarto.setValor(rs.getDouble("VL_QUARTO"));
			}

			rs.close();
			estrutura.close();

			return tipoQuarto;

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
}
