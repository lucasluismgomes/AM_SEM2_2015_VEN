package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fiap.am.ltp.beans.TipoConsumo;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Estevão 74803
 * @version 1.0
 * @since 1.0
 * @see Meu Beans
 */
public class TipoConsumoDAO {

	private String sql = "";
	private PreparedStatement estrutura = null;
	private ResultSet rs = null;

	/**
	 * Grava os dados do tipo de consumo no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param tipoConsumo
	 *            O Tipo Consumo que será gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see TipoConsumo, TipoConsumoBO
	 */
	public void gravar(TipoConsumo tipoConsumo, Connection conexao) throws Exception {
		try {
			sql = "INSERT INTO T_AM_HBV_TIPO_CONSUMO (DS_TIPO_CONSUMO, NR_TIPO, VL_UNIT)"
				  + " VALUES(?,?,?)";
			
			estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, tipoConsumo.getNome());
			estrutura.setShort(2, tipoConsumo.getTipo());
			estrutura.setDouble(3, tipoConsumo.getValor());
			
			estrutura.executeQuery();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Edita as informações de um Tipo de Consumo no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param tipoConsumo
	 *            Os dados do Tipo de Consumo que está sendo editado.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see TipoConsumo, TipoConsumoBO
	 */
	public void editar(TipoConsumo tipoConsumo, Connection conexao) throws Exception {
		try {

			sql = "UPDATE T_AM_HBV_TIPO_CONSUMO SET DS_TIPO_CONSUMO = ?, NR_TIPO = ?, VL_UNIT = ? WHERE CD_TIPO_CONSUMO = ?";
			estrutura = conexao.prepareStatement(sql);
			
			estrutura.setString(1, tipoConsumo.getNome());
			estrutura.setShort(2, tipoConsumo.getTipo());
			estrutura.setDouble(3, tipoConsumo.getValor());
			estrutura.setInt(4, tipoConsumo.getCodigo());

			estrutura.executeQuery();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Grava os dados do histórico de valor do tipo de Consumo no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param tipoConsumo
	 *            O Tipo Consumo que será gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see TipoConsumo, TipoConsumoBO
	 */
	public void gravarHistoricoValor(TipoConsumo tipoConsumo, Connection conexao) throws Exception {
		try {
			sql = "INSERT INTO T_AM_HBV_HIST_PRECO (CD_TIPO_CONSUMO, DT_VALIDADE, VL_PRECO)"
				  + " VALUES(?,?,?)";

			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, tipoConsumo.getCodigo());
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); Date date = new Date(); 
			estrutura.setString(2, dateFormat.format(date));
			estrutura.setDouble(3, tipoConsumo.getValor());
			
			estrutura.executeQuery();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	
	/**
	 * Excluí um Tipo de Consumo do banco de dados. Isso irá apagar todos os seus dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param codigo
	 *            O código do tipo de consumo que está sendo excluído.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see TipoConsumo, TipoConsumoBO
	 */
	public void excluir(int codigo, Connection conexao) throws Exception {
		try {
			sql = "DELETE FROM T_AM_HBV_TIPO_CONSUMO WHERE CD_TIPO_CONSUMO = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, codigo);

			estrutura.execute();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Busca todos os Tipos de Consumo que estão no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param conexao
	 * @return <code>lstTipoConsumo</code> Lista com todos os tipos de consumo no banco de
	 *         dados.
	 * @throws Exception
	 * @see TipoConsumo, TipoConsumoBO
	 */
	public List<TipoConsumo> buscarTodos(Connection conexao) throws Exception {
		List<TipoConsumo> lstTipoConsumo = new ArrayList<TipoConsumo>();

		try {
			sql = "SELECT CD_TIPO_CONSUMO, DS_TIPO_CONSUMO, NR_TIPO, VL_UNIT"
					+ " FROM T_AM_HBV_TIPO_CONSUMO";
			estrutura = conexao.prepareStatement(sql);

			rs = estrutura.executeQuery();

			while (rs.next()) {
				TipoConsumo tipoConsumo = new TipoConsumo();

				tipoConsumo.setCodigo(Integer.parseInt(rs.getString("CD_TIPO_CONSUMO")));
				tipoConsumo.setNome(rs.getString("DS_TIPO_CONSUMO"));
				tipoConsumo.setTipo(Short.parseShort(rs.getString("NR_TIPO")));
				tipoConsumo.setValor(Double.parseDouble(rs.getString("VL_UNIT")));
				

				lstTipoConsumo.add(tipoConsumo);
			}

			rs.close();
			estrutura.close();

			return lstTipoConsumo;
			
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Faz a busca de um tipo de consumo no banco de dados que tenha o id especificado.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param codigo
	 *            O código do tipo de consumo que está sendo buscado no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return <code>tipoConsumo</code> Dados do tipo de consumo com o id especificado.
	 * @throws Exception
	 * @see TipoConsumo, TipoConsumoBO
	 */
	public TipoConsumo buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		TipoConsumo tipoConsumo = new TipoConsumo();

		try {
			sql = "SELECT CD_TIPO_CONSUMO, DS_TIPO_CONSUMO, NR_TIPO, VL_UNIT"
					+ " FROM T_AM_HBV_TIPO_CONSUMO"
					+ " WHERE CD_TIPO_CONSUMO = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, codigo);

			rs = estrutura.executeQuery();

			if (rs.next()) {

				tipoConsumo.setCodigo(Integer.parseInt(rs.getString("CD_TIPO_CONSUMO")));
				tipoConsumo.setNome(rs.getString("DS_TIPO_CONSUMO"));
				tipoConsumo.setTipo(Short.parseShort(rs.getString("NR_TIPO")));
				tipoConsumo.setValor(Double.parseDouble(rs.getString("VL_UNIT")));
				
			}

			rs.close();
			estrutura.close();

			return tipoConsumo;

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
}
