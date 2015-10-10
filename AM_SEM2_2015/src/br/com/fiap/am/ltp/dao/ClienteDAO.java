package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

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
	private String sql = "";
	private PreparedStatement estrutura = null;
	private ResultSet rs = null;

	/**
	 * Faz a gravação de um Cliente no banco de dados. Veja a classe BO para
	 * entender as regras de negócio.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param cliente
	 *            O cliente que está sendo gravado no banco.
	 * @param conexao
	 *            Credenciais da conexão.
	 * @throws Exception
	 * @see Cliente, ClienteBO
	 */
	public void gravar(Cliente cliente, Connection conexao) throws Exception {
		try {
			sql = "INSERT INTO T_AM_HBV_PESSOA (NM_PESSOA) VALUES(?)";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, cliente.getNome());

			estrutura.executeQuery();
			estrutura.close();

			sql = "INSERT INTO T_AM_HBV_CLIENTE VALUES(SQ_AM_PESSOA.CURRVAL,?,?,?,?,?,?)";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setLong(1, cliente.getCpf());
			estrutura.setLong(2, cliente.getRg());
			estrutura.setDate(3, new Date(cliente.getDtNascimento().getTimeInMillis()));
			estrutura.setInt(4, cliente.getQuartoFavorito());
			estrutura.setString(5, cliente.getEmail());
			estrutura.setString(6, cliente.getSenha());

			estrutura.executeQuery();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	/**
	 * Busca todos os Clientes que estão no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param conexao
	 * @return <code>lstCliente</code> Lista com todos os clientes no banco de
	 *         dados.
	 * @throws Exception
	 * @see Cliente, ClienteBO
	 */
	public List<Cliente> buscarTodos(Connection conexao) throws Exception {
		List<Cliente> lstCliente = new ArrayList<Cliente>();

		try {
			sql = "SELECT 	P.CD_PESSOA, "
						 + "P.NM_PESSOA, "
						 + "C.NR_CPF, "
						 + "C.NR_RG, "
						 + "C.DT_NASCIMENTO, "
						 + "C.DS_EMAIL "
				+ "FROM T_AM_HBV_PESSOA P INNER JOIN T_AM_HBV_CLIENTE C "
				+ "ON P.CD_PESSOA = C.CD_CLIENTE";
			estrutura = conexao.prepareStatement(sql);

			rs = estrutura.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				Locale l = new Locale("pt", "BR");
				Calendar c = Calendar.getInstance(l);
				c.setTime(rs.getDate("DT_NASCIMENTO"));

				cliente.setCodigo(Integer.parseInt(rs.getString("CD_PESSOA")));
				cliente.setNome(rs.getString("NM_PESSOA"));
				cliente.setCpf(rs.getLong("NR_CPF"));
				cliente.setRg(rs.getLong("NR_RG"));
				cliente.setDtNascimento(c);
				cliente.setEmail(rs.getString("DS_EMAIL"));

				lstCliente.add(cliente);
			}

			rs.close();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}

		return lstCliente;
	}

	/**
	 * 
	 * @param id
	 * @param conexao
	 * @return
	 * @throws Exception
	 */
	public Cliente buscarPorCodigo(int id, Connection conexao) throws Exception {
		Cliente cliente = new Cliente();

		try {
			sql = "SELECT 	P.CD_PESSOA, "
					 + "P.NM_PESSOA, "
					 + "C.NR_CPF, "
					 + "C.NR_RG, "
					 + "C.DT_NASCIMENTO, "
					 + "C.DS_EMAIL "
			+ "FROM T_AM_HBV_PESSOA P INNER JOIN T_AM_HBV_CLIENTE C "
			+ "ON P.CD_PESSOA = C.CD_CLIENTE "
			+ "WHERE P.CD_PESSOA = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, id);

			rs = estrutura.executeQuery();

			if (rs.next()) {
				Locale l = new Locale("pt", "BR");
				Calendar c = Calendar.getInstance(l);
				c.setTime(rs.getDate("DT_NASCIMENTO"));

				cliente.setCodigo(Integer.parseInt(rs.getString("CD_PESSOA")));
				cliente.setNome(rs.getString("NM_PESSOA"));
				cliente.setCpf(rs.getLong("NR_CPF"));
				cliente.setRg(rs.getLong("NR_RG"));
				cliente.setDtNascimento(c);
				cliente.setEmail(rs.getString("DS_EMAIL"));
			}

			rs.close();
			estrutura.close();

			return cliente;

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	public void editar(Cliente cliente, Connection conexao) throws Exception {
		try {
			sql = "UPDATE T_AM_HBV_STATUS SET NM_STATUS = ? WHERE CD_STATUS = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, cliente.getNome());
			estrutura.setInt(2, cliente.getCodigo());

			estrutura.execute();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	public void excluir(int id, Connection conexao) throws Exception {
		try {
			sql = "DELETE FROM T_AM_HBV_PESSOA WHERE CD_PESSOA = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, id);

			estrutura.execute();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
}
