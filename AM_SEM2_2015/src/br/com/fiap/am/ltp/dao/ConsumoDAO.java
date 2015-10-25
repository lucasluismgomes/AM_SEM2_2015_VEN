package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.am.ltp.beans.Consumo;
import br.com.fiap.am.ltp.beans.Funcionario;
import br.com.fiap.am.ltp.beans.Hospedagem;
import br.com.fiap.am.ltp.beans.TipoConsumo;
import br.com.fiap.am.ltp.bo.FuncionarioBO;
import br.com.fiap.am.ltp.bo.HospedagemBO;
import br.com.fiap.am.ltp.bo.TipoConsumoBO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Estevão 74803
 * @version 1.0
 * @since 1.0
 * @see Meu Beans
 */
public class ConsumoDAO {

	private String sql = "";
	private PreparedStatement estrutura = null;
	private ResultSet rs = null;

	/**
	 * Grava os dados de um Consumo no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param consumo
	 *            O Consumo que será gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Consumo, ConsumoBO
	 */
	public void gravar(Consumo consumo, Connection conexao) throws Exception {
		try {
			sql = "INSERT INTO T_AM_HBV_CONSUMO (CD_HOSPEDAGEM, CD_TIPO_CONSUMO, CD_FUNCIONARIO, DT_CONSUMO, QT_CONSUMO) VALUES(?,?,?,?,?)";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, consumo.getHospedagem().getReserva().getCodigo());
			estrutura.setInt(2, consumo.getTipoConsumo().getCodigo());
			estrutura.setInt(3, consumo.getFuncionario().getCodigo());
			estrutura.setDate(4, new Date(consumo.getDtSolicitacao().getTimeInMillis()));
			estrutura.setInt(5, consumo.getQuantidade());
			

			estrutura.executeQuery();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Edita as informações de um Consumo no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param consumo
	 *            Os dados do consumo que está sendo editado.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Consumo, ConsumoBO
	 */
	public void editar(Consumo consumo, Connection conexao) throws Exception {
		try {

			sql = "UPDATE T_AM_HBV_CONSUMO SET CD_HOSPEDAGEM = ?, CD_TIPO_CONSUMO = ?, "
			+ "CD_FUNCIONARIO = ?, DT_CONSUMO = ?, QT_CONSUMO = ? WHERE CD_CONSUMO = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, consumo.getHospedagem().getReserva().getCodigo());
			estrutura.setInt(2, consumo.getTipoConsumo().getCodigo());
			estrutura.setInt(3, consumo.getFuncionario().getCodigo());
			estrutura.setDate(4, new Date(consumo.getDtSolicitacao().getTimeInMillis()));
			estrutura.setInt(5, consumo.getQuantidade());
			estrutura.setInt(6, consumo.getCodigo());

			estrutura.executeQuery();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Excluí um consumo do banco de dados. Isso irá apagar todos os seus dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param codigo
	 *            O código do consumo que está sendo excluído.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Consumo, ConsumoBO
	 */
	public void excluir(int codigo, Connection conexao) throws Exception {
		try {
			sql = "DELETE FROM T_AM_HBV_CONSUMO WHERE CD_CONSUMO = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, codigo);

			estrutura.execute();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Busca todos os Consumos que estão no banco de dados.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param conexao
	 * @return <code>lstConsumo</code> Lista com todos os consumos no banco de
	 *         dados.
	 * @throws Exception
	 * @see Consumo, ConsumoBO
	 */
	public List<Consumo> buscarTodos(Connection conexao) throws Exception {
		List<Consumo> lstConsumo = new ArrayList<Consumo>();

		try {
			sql = "SELECT CD_CONSUMO, CD_HOSPEDAGEM, CD_TIPO_CONSUMO, CD_FUNCIONARIO, DT_CONSUMO, QT_CONSUMO "
					+ "FROM T_AM_HBV_CONSUMO";
			estrutura = conexao.prepareStatement(sql);

			rs = estrutura.executeQuery();

			while (rs.next()) {
				Consumo consumo = new Consumo();

				consumo.setCodigo(Integer.parseInt(rs.getString("CD_CONSUMO")));
				Hospedagem hpd = new Hospedagem();
				hpd = HospedagemBO.buscarPorCodigo(rs.getInt("CD_HOSPEDAGEM"), conexao);
				consumo.setHospedagem(hpd);
				TipoConsumo tc = new TipoConsumo();
				tc = TipoConsumoBO.buscarPorCodigo(rs.getInt("CD_TIPO_CONSUMO"), conexao);
				Funcionario f = new Funcionario();
				f = FuncionarioBO.buscarPorCodigo(rs.getInt("CD_FUNCIONARIO"), conexao);
				consumo.setFuncionario(f);
				Calendar c = Calendar.getInstance();
				c.setTime(rs.getDate("DT_CONSUMO"));
				consumo.setDtSolicitacao(c);
				consumo.setQuantidade(rs.getInt("QT_CONSUMO"));

				lstConsumo.add(consumo);
			}

			rs.close();
			estrutura.close();

			return lstConsumo;
			
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Faz a busca de um consumo no banco de dados pelo número do consumo.
	 * 
	 * @author Estevão 74803
	 * @since 1.0
	 * @param codigo
	 *            O código do tipo de consumo que está sendo buscado no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return <code>consumo</code> Dados do consumo com o número especificado.
	 * @throws Exception
	 * @see Consumo, ConsumoBO
	 */
	public Consumo buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		Consumo consumo = new Consumo();

		try {
			sql = "SELECT CD_CONSUMO, CD_HOSPEDAGEM, CD_TIPO_CONSUMO, CD_FUNCIONARIO, DT_CONSUMO, QT_CONSUMO "
					+ "FROM T_AM_HBV_CONSUMO"
					+ " WHERE CD_CONSUMO = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, codigo);

			rs = estrutura.executeQuery();

			if (rs.next()) {

				consumo.setCodigo(Integer.parseInt(rs.getString("CD_CONSUMO")));
				Hospedagem hpd = new Hospedagem();
				hpd = HospedagemBO.buscarPorCodigo(rs.getInt("CD_HOSPEDAGEM"), conexao);
				consumo.setHospedagem(hpd);
				TipoConsumo tc = new TipoConsumo();
				tc = TipoConsumoBO.buscarPorCodigo(rs.getInt("CD_TIPO_CONSUMO"), conexao);
				Funcionario f = new Funcionario();
				f = FuncionarioBO.buscarPorCodigo(rs.getInt("CD_FUNCIONARIO"), conexao);
				consumo.setFuncionario(f);
				Calendar c = Calendar.getInstance();
				c.setTime(rs.getDate("DT_CONSUMO"));
				consumo.setDtSolicitacao(c);
				consumo.setQuantidade(rs.getInt("QT_CONSUMO"));


			}

			rs.close();
			estrutura.close();

			return consumo;

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
}
