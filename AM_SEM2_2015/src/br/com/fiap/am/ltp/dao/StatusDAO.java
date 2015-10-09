package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.ltp.beans.Status;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Conexões e funcionalidades da classe Status.
 * 
 * @author Lucas 74795
 * @version 3.0
 * @since 1.0
 * @see Status
 */
public class StatusDAO {
	/**
	 * Grava os dados de um status no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param status
	 *            O status que será gravado.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Status, StatusBO
	 */
	public void gravar(Status status, Connection conexao) throws Exception {
		try {
			String sql = "INSERT INTO T_AM_HBV_STATUS VALUES(?,?)";
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, status.getCodigo());
			estrutura.setString(2, status.getNome());

			estrutura.execute();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	/**
	 * Busca todos os Status do banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 2.0
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return <code>lstStatus</code> Uma lista com todos os status disponiveis
	 *         no banco de dados.
	 * @throws Exception
	 * @see Status, StatusBO
	 */
	public List<Status> buscarTodos(Connection conexao) throws Exception {
		List<Status> lstStatus = new ArrayList<Status>();

		try {
			String sql = "SELECT CD_STATUS, NM_STATUS FROM T_AM_HBV_STATUS";
			PreparedStatement estrutura = conexao.prepareStatement(sql);

			ResultSet resultadoDados = estrutura.executeQuery();

			while (resultadoDados.next()) {
				Status status = new Status();

				status.setCodigo(Integer.parseInt(resultadoDados.getString("CD_STATUS")));
				status.setNome(resultadoDados.getString("NM_STATUS"));

				lstStatus.add(status);
			}

			resultadoDados.close();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}

		return lstStatus;
	}

	/**
	 * Busca apenas o status com o código fornecido.
	 * 
	 * @author Lucas 74795
	 * @since 2.0
	 * @param id
	 *            O código do Status que está sendo pesquisado.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return <code>status</code> O status de acordo com o id passado como
	 *         parâmetro.
	 * @throws Exception
	 */
	public Status buscarPorCodigo(int id, Connection conexao) throws Exception {
		Status status = new Status();

		try {
			String sql = "SELECT CD_STATUS, NM_STATUS FROM T_AM_HBV_STATUS WHERE CD_STATUS = ?";
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, id);

			ResultSet resultadoDados = estrutura.executeQuery();

			if (resultadoDados.next()) {
				status.setCodigo(resultadoDados.getInt("CD_STATUS"));
				status.setNome(resultadoDados.getString("NM_STATUS"));
			}

			resultadoDados.close();
			estrutura.close();

			return status;

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	/**
	 * Atualiza o nome de um Status no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 3.0
	 * @param status
	 * 			Status que está sendo editado no banco de dados.
	 * @param conexao
	 * 			Credenciais da conexão.
	 * @throws Exception
	 * @see Status
	 */
	public void editar(Status status, Connection conexao) throws Exception {
		try {
			String sql = "UPDATE T_AM_HBV_STATUS SET NM_STATUS = ? WHERE CD_STATUS = ?";
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, status.getNome());
			estrutura.setInt(2, status.getCodigo());

			estrutura.execute();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Exclui o status do banco de dado com o código passado.
	 * 
	 * @author Lucas 74795
	 * @since 3.0
	 * @param id
	 * 			Código do status que será excluído.
	 * @param conexao
	 * 			Credenciais da conexão.
	 * @throws Exception
	 * @see Status
	 */
	public void excluir(int id, Connection conexao) throws Exception {
		try{
			String sql = "DELETE FROM T_AM_HBV_STATUS WHERE CD_STATUS = ?";
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, id);
			
			estrutura.execute();
			estrutura.close();
			
		} catch(Exception e){
			throw new Excecao(e);
		}
	}
}
