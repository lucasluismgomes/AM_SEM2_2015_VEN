package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.ltp.beans.Quarto;
import br.com.fiap.am.ltp.beans.TipoQuarto;
import br.com.fiap.am.ltp.bo.TipoQuartoBO;
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
	private ResultSet rs = null;

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
			sql = "INSERT INTO T_AM_HBV_QUARTO (CD_TIPO_QUARTO,NR_ANDAR,NR_CAPACIDADE, STATUS) VALUES(?,?,?,?)";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, quarto.getTipo().getCodigo());
			estrutura.setInt(2, quarto.getNrAndar());
			estrutura.setShort(3, quarto.getNrCapacidade());
			estrutura.setBoolean(4, quarto.getStatus());
			

			estrutura.executeQuery();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Busca todos os Quartos que estão no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param conexao
	 * @return <code>lstQuarto</code> Lista com todos os quartos no banco de
	 *         dados.
	 * @throws Exception
	 * @see Quarto, QuartoBO
	 */
	public List<Quarto> buscarTodos(Connection conexao) throws Exception {
		List<Quarto> lstQuarto = new ArrayList<Quarto>();

		try {
			sql = "SELECT 	NR_QUARTO, " + "CD_TIPO_QUARTO, " + "NR_ANDAR, " + "NR_CAPACIDADE, " + "STATUS "
					+ "FROM T_AM_HBV_QUARTO";
			estrutura = conexao.prepareStatement(sql);

			rs = estrutura.executeQuery();

			while (rs.next()) {
				Quarto quarto = new Quarto();

				quarto.setCodigo(Integer.parseInt(rs.getString("NR_QUARTO")));
				TipoQuarto tq = new TipoQuarto();
				tq = TipoQuartoBO.buscarPorCodigo(rs.getInt("CD_TIPO_QUARTO"), conexao);
				quarto.setTipo(tq);
				quarto.setNrAndar(rs.getInt("NR_ANDAR"));
				quarto.setNrCapacidade(rs.getShort("NR_CAPACIDADE"));
				quarto.setStatus(rs.getBoolean("STATUS"));

				lstQuarto.add(quarto);
			}

			rs.close();
			estrutura.close();

			return lstQuarto;
			
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Faz a busca de um quarto no banco de dados pelo número do quarto.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param codigo
	 *            O código do tipo de quarto que está sendo buscado no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return <code>quarto</code> Dados do quarto com o número especificado.
	 * @throws Exception
	 * @see Quarto, QuartoBO
	 */
	public Quarto buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		Quarto quarto = new Quarto();

		try {
			sql = "SELECT 	NR_QUARTO, " + "CD_TIPO_QUARTO, " + "NR_ANDAR, " + "NR_CAPACIDADE, " + "STATUS "
					+ "FROM T_AM_HBV_QUARTO"
					+ "WHERE NR_QUARTO = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, codigo);

			rs = estrutura.executeQuery();

			if (rs.next()) {

				quarto.setCodigo(Integer.parseInt(rs.getString("NR_QUARTO")));
				TipoQuarto tq = new TipoQuarto();
				tq = TipoQuartoBO.buscarPorCodigo(rs.getInt("CD_TIPO_QUARTO"), conexao);
				quarto.setTipo(tq);
				quarto.setNrAndar(rs.getInt("NR_ANDAR"));
				quarto.setNrCapacidade(rs.getShort("NR_CAPACIDADE"));
				quarto.setStatus(rs.getBoolean("STATUS"));
			}

			rs.close();
			estrutura.close();

			return quarto;

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

}