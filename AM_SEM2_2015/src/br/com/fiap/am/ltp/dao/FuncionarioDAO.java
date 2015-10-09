package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	 * 
	 * @param funcionario
	 * @param conexao
	 * @throws Exception
	 */
	public void gravar(Funcionario funcionario, Connection conexao) throws Exception {
		try {
			sql = "INSERT INTO T_AM_HBV_PESSOA NM_PESSOA VALUES(?)";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, funcionario.getNome());
			
			estrutura.executeQuery();
			estrutura.close();
			
			sql = "INSERT INTO T_AM_HBV_CLIENTE VALUES(SQ_AM_PESSOA.CURRVAL,?,?)";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, funcionario.getCargo().getCodigo());
			estrutura.setDate(2, new Date(funcionario.getDtAdmissao().getTimeInMillis()));
			
			estrutura.executeQuery();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
}
