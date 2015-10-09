package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.ltp.beans.Cliente;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 * @see Meu Beans
 */
public class ClienteDAO {

	public void gravar(Cliente cliente, Connection conexao) throws Exception {
		try {
			String sql = "INSERT INTO T_AM_HBV_PESSOA NM_PESSOA VALUES(?)";
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, cliente.getNome());
			
			estrutura.executeQuery();
			
			sql = "INSERT INTO T_AM_HBV_CLIENTE VALUES((SELECT SQ_AM_PESSOA.CURRVAL FROM DUAL),?,?,?,?,?,?)";
			PreparedStatement estrutura2 = conexao.prepareStatement(sql);
			estrutura2.setLong(1, cliente.getCpf());
			estrutura2.setLong(2, cliente.getRg());
			//estrutura2.setDate(3, cliente.getDtNascimento());
			estrutura2.setInt(4, cliente.getQuartoFavorito());
			estrutura2.setString(5, cliente.getEmail());
			estrutura2.setString(6, cliente.getSenha());
			
			estrutura2.executeQuery();
			
			estrutura.close();
			estrutura2.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}


	public List<Cliente> buscarTodos(Connection conexao) throws Exception {
		List<Cliente> lstCliente = new ArrayList<Cliente>();

		try {
			String sql = "SELECT CD_CLIENTE, NM_CLIENTE FROM T_AM_HBV_CLIENTE";
			PreparedStatement estrutura = conexao.prepareStatement(sql);

			ResultSet resultadoDados = estrutura.executeQuery();

			while (resultadoDados.next()) {
				Cliente cliente = new Cliente();

				cliente.setCodigo(Integer.parseInt(resultadoDados.getString("CD_CLIENTE")));
				cliente.setNome(resultadoDados.getString("NM_CLIENTE"));

				lstCliente.add(cliente);
			}

			resultadoDados.close();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}

		return lstCliente;
	}


	public Cliente buscarPorCodigo(int id, Connection conexao) throws Exception {
		Cliente cliente = new Cliente();

		try {
			String sql = "SELECT CD_STATUS, NM_STATUS FROM T_AM_HBV_STATUS WHERE CD_STATUS = ?";
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, id);

			ResultSet resultadoDados = estrutura.executeQuery();

			if (resultadoDados.next()) {
				cliente.setCodigo(resultadoDados.getInt("CD_STATUS"));
				cliente.setNome(resultadoDados.getString("NM_STATUS"));
			}

			resultadoDados.close();
			estrutura.close();

			return cliente;

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	public void editar(Cliente cliente, Connection conexao) throws Exception {
		try {
			String sql = "UPDATE T_AM_HBV_STATUS SET NM_STATUS = ? WHERE CD_STATUS = ?";
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, cliente.getNome());
			estrutura.setInt(2, cliente.getCodigo());

			estrutura.execute();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	public void excluir(int id, Connection conexao) throws Exception {
		try{
			String sql = "DELETE FROM T_AM_HBV_PESSOA WHERE CD_PESSOA = ?";
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, id);
			
			estrutura.execute();
			estrutura.close();
			
		} catch(Exception e){
			throw new Excecao(e);
		}
	}
}
