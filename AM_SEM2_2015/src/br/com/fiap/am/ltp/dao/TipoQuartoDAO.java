package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.ltp.beans.Quarto;
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
			sql = "INSERT INTO T_AM_HBV_TIPO_QUARTO (DS_TIPO_QUARTO, DS_OBSERVACAO, VL_QUARTO)"
				  + " VALUES(?,?,?)";
			
			estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, tipoQuarto.getNomeTipo());
			estrutura.setString(2, tipoQuarto.getDescricao());
			estrutura.setDouble(3, tipoQuarto.getValor());
			
			estrutura.executeQuery();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Edita as informações de um Tipo de Quarto no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param quarto
	 *            Os dados do Tipo de Quarto que está sendo editado.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see TipoQuarto, TipoQuartoBO
	 */
	public void editar(TipoQuarto tipoQuarto, Connection conexao) throws Exception {
		try {

			sql = "UPDATE T_AM_HBV_TIPO_QUARTO SET DS_TIPO_QUARTO = ?, DS_OBSERVACAO = ?, VL_QUARTO = ? WHERE NR_QUARTO = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, tipoQuarto.getNomeTipo());
			estrutura.setString(1, tipoQuarto.getDescricao());
			estrutura.setDouble(1, tipoQuarto.getValor());

			estrutura.executeQuery();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Excluí um tipo de quarto do banco de dados. Isso irá apagar todos os seus dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param codigo
	 *            O código do tipo de quarto que está sendo excluído.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see TipoQuarto, TipoQuartoBO
	 */
	public void excluir(int codigo, Connection conexao) throws Exception {
		try {
			sql = "DELETE FROM T_AM_HBV_TIPO_QUARTO WHERE CD_TIPO_QUARTO = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, codigo);

			estrutura.execute();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Busca todos os Tipos de quartos que estão no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param conexao
	 * @return <code>lstTipoQuarto</code> Lista com todos os tipos de quartos no banco de
	 *         dados.
	 * @throws Exception
	 * @see TipoQuarto, TipoQuartoBO
	 */
	public List<TipoQuarto> buscarTodos(Connection conexao) throws Exception {
		List<TipoQuarto> lstTipoQuarto = new ArrayList<TipoQuarto>();

		try {
			sql = "SELECT CD_TIPO_QUARTO, " + "DS_TIPO_QUARTO, " + "VL_QUARTO "
					+ "FROM T_AM_HBV_TIPO_QUARTO ";
			estrutura = conexao.prepareStatement(sql);

			rs = estrutura.executeQuery();

			while (rs.next()) {
				TipoQuarto tipoQuarto = new TipoQuarto();

				tipoQuarto.setCodigo(Integer.parseInt(rs.getString("CD_TIPO_QUARTO")));
				tipoQuarto.setNomeTipo(rs.getString("DS_TIPO_QUARTO"));
				tipoQuarto.setValor(rs.getDouble("VL_QUARTO"));

				lstTipoQuarto.add(tipoQuarto);
			}

			rs.close();
			estrutura.close();

			return lstTipoQuarto;
			
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
