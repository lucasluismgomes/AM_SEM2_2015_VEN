package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.am.ltp.beans.Cargo;
import br.com.fiap.am.ltp.beans.Funcionario;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 * @see Meu Beans
 */
public class FuncionarioDAO {
	private String sql = "";
	private PreparedStatement estrutura = null;
	private ResultSet rs = null;

	/**
	 * Grava os dados de um funcionário no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param funcionario
	 *            O Funcionario que será gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Funcionario, FuncionarioBO
	 */
	public void gravar(Funcionario funcionario, Connection conexao) throws Exception {
		try {
			sql = "INSERT INTO T_AM_HBV_PESSOA (NM_PESSOA) VALUES(?)";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, funcionario.getNome());

			estrutura.executeQuery();
			estrutura.close();

			sql = "INSERT INTO T_AM_HBV_FUNCIONARIO VALUES(SQ_AM_PESSOA.CURRVAL,?,?)";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, funcionario.getCargo().getCodigo());
			estrutura.setDate(2, new Date(funcionario.getDtAdmissao().getTimeInMillis()));

			estrutura.executeQuery();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	/**
	 * Retorna todos os funcionários cadastrados no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param conexao
	 *            Credenciais da conexão.
	 * @return <code>lstFuncionario</code> Lista com todos os funcionários do
	 *         banco de dados.
	 * @throws Exception
	 * @see Funcionario, FuncionarioBO
	 */
	public List<Funcionario> buscarTodos(Connection conexao) throws Exception {
		List<Funcionario> lstFuncionario = new ArrayList<Funcionario>();
		Cargo cargo = new Cargo();

		try {
			sql = "SELECT  P.CD_PESSOA, " + "P.NM_PESSOA, " + "F.DT_ADMISSAO, " + "C.CD_CARGO, " + "C.DS_CARGO, "
					+ "C.VL_SALARIO_BASE " + "FROM T_AM_HBV_FUNCIONARIO F INNER JOIN T_AM_HBV_PESSOA P "
					+ "ON F.CD_FUNCIONARIO = P.CD_PESSOA " + "INNER JOIN T_AM_HBV_CARGO C "
					+ "ON F.CD_CARGO = C.CD_CARGO";
			estrutura = conexao.prepareStatement(sql);

			rs = estrutura.executeQuery();

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				cargo = new Cargo();
				Calendar c = Calendar.getInstance();

				cargo.setCodigo(rs.getInt("CD_CARGO"));
				cargo.setNome(rs.getString("DS_CARGO"));
				cargo.setSalarioBase(rs.getDouble("VL_SALARIO_BASE"));

				c.setTime(rs.getDate("DT_ADMISSAO"));

				funcionario.setCodigo(rs.getInt("CD_PESSOA"));
				funcionario.setNome(rs.getString("NM_PESSOA"));
				funcionario.setDtAdmissao(c);
				funcionario.setCargo(cargo);

				lstFuncionario.add(funcionario);
			}

			rs.close();
			estrutura.close();

			return lstFuncionario;
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	/**
	 * Faz a busca de um funcionário pelo código no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param codigo
	 *            O código do funcionário que está sendo buscado no banco de
	 *            dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return <code>funcionario</code> O funcionário que foi buscado pelo
	 *         código.
	 * @throws Exception
	 * @see Funcionario, FuncionarioBO
	 */
	public Funcionario buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		Funcionario funcionario = new Funcionario();
		try {
			sql = "SELECT  P.CD_PESSOA, " + "P.NM_PESSOA, " + "F.DT_ADMISSAO, " + "C.CD_CARGO, " + "C.DS_CARGO, "
					+ "C.VL_SALARIO_BASE " + "FROM T_AM_HBV_FUNCIONARIO F INNER JOIN T_AM_HBV_PESSOA P "
					+ "ON F.CD_FUNCIONARIO = P.CD_PESSOA " + "INNER JOIN T_AM_HBV_CARGO C "
					+ "ON F.CD_CARGO = C.CD_CARGO WHERE CD_PESSOA = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, codigo);

			rs = estrutura.executeQuery();

			if (rs.next()) {
				Cargo cargo = new Cargo();
				Calendar c = Calendar.getInstance();

				cargo.setCodigo(rs.getInt("CD_CARGO"));
				cargo.setNome(rs.getString("DS_CARGO"));
				cargo.setSalarioBase(rs.getDouble("VL_SALARIO_BASE"));

				c.setTime(rs.getDate("DT_ADMISSAO"));

				funcionario.setCodigo(rs.getInt("CD_PESSOA"));
				funcionario.setNome(rs.getString("NM_PESSOA"));
				funcionario.setDtAdmissao(c);
				funcionario.setCargo(cargo);
			}

			return funcionario;

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	/**
	 * Edita as informações de um funcionário no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param funcionario
	 *            O funcionário que terá seus dados editados no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Funcionario, FuncionarioBO
	 */
	public void editar(Funcionario funcionario, Connection conexao) throws Exception {
		try {
			sql = "UPDATE T_AM_HBV_PESSOA SET NM_PESSOA = ? WHERE CD_PESSOA = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, funcionario.getNome());
			estrutura.setInt(2, funcionario.getCodigo());

			estrutura.executeQuery();
			estrutura.close();

			sql = "UPDATE T_AM_HBV_FUNCIONARIO SET CD_CARGO = ?, DT_ADMISSAO = ? WHERE CD_FUNCIONARIO = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, funcionario.getCargo().getCodigo());
			estrutura.setDate(2, new Date(funcionario.getDtAdmissao().getTimeInMillis()));
			estrutura.setInt(3, funcionario.getCodigo());

			estrutura.executeQuery();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	/**
	 * Apaga um funcionário do banco de dados. Essa ação irá apgar todas as
	 * informações dele, bem como hospedagens e consumos que registrou.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param codigo
	 *            Código do funcionário que será excluído do banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Funcionario, FuncionarioBO
	 */
	public void excluir(int codigo, Connection conexao) throws Exception {
		try {
			sql = "DELETE FROM T_AM_HBV_PESSOA WHERE CD_PESSOA = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, codigo);

			estrutura.executeQuery();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
}
