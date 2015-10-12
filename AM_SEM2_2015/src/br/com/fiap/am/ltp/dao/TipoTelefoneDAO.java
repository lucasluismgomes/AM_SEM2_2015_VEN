package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.ltp.beans.TipoTelefone;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 * @see TipoTelefone, TipoTelefoneBO
 */
public class TipoTelefoneDAO {
	/**
	 * Grava os dados de um tipo telefone no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param tipoTelefone
	 *            O tipo de telefone que será gravado.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see TipoTelefone, TipoTelefoneBO
	 */
	public void gravar(TipoTelefone tipoTelefone, Connection conexao) throws Exception {
		try {
			String sql = "INSERT INTO T_AM_HBV_TIPO_TELEFONE (DS_TIPO_TELEFONE) VALUES(?)";
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, tipoTelefone.getNome());

			estrutura.execute();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	/**
	 * Busca todos os tipos de telefone do banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 2.0
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return <code>lstTipoTelefone</code> Uma lista com todos os tipos de telefone disponiveis
	 *         no banco de dados.
	 * @throws Exception
	 * @see TipoTelefone, TipoTelefoneBO
	 */
	public List<TipoTelefone> buscarTodos(Connection conexao) throws Exception {
		List<TipoTelefone> lstTipoTelefone = new ArrayList<TipoTelefone>();

		try {
			String sql = "SELECT CD_TIPO_TELEFONE, DS_TIPO_TELEFONE FROM T_AM_HBV_TIPO_TELEFONE";
			PreparedStatement estrutura = conexao.prepareStatement(sql);

			ResultSet resultadoDados = estrutura.executeQuery();

			while (resultadoDados.next()) {
				TipoTelefone tipoTelefone = new TipoTelefone();

				tipoTelefone.setCodigo(Integer.parseInt(resultadoDados.getString("CD_TIPO_TELEFONE")));
				tipoTelefone.setNome(resultadoDados.getString("DS_TIPO_TELEFONE"));

				lstTipoTelefone.add(tipoTelefone);
			}

			resultadoDados.close();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}

		return lstTipoTelefone;
	}

	/**
	 * Busca apenas o tipo telefone com o código fornecido.
	 * 
	 * @author Lucas 74795
	 * @since 2.0
	 * @param codigo
	 *            O código do tipo telefone que está sendo pesquisado.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return <code>tipoTelefone</code> O tipo telefone de acordo com o código passado como
	 *         parâmetro.
	 * @throws Exception
	 * @see TipoTelefone, TipoTelefoneBO
	 */
	public TipoTelefone buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		TipoTelefone tipoTelefone = new TipoTelefone();

		try {
			String sql = "SELECT CD_TIPO_TELEFONE, DS_TIPO_TELEFONE FROM T_AM_HBV_TIPO_TELEFONE WHERE CD_TIPO_TELEFONE = ?";
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, codigo);

			ResultSet resultadoDados = estrutura.executeQuery();

			if (resultadoDados.next()) {
				tipoTelefone.setCodigo(resultadoDados.getInt("CD_TIPO_TELEFONE"));
				tipoTelefone.setNome(resultadoDados.getString("DS_TIPO_TELEFONE"));
			}

			resultadoDados.close();
			estrutura.close();

			return tipoTelefone;

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	/**
	 * Atualiza o nome de um tipo de telefone no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 3.0
	 * @param tipoTelefone
	 * 			O tipo de telefone que está sendo editado no banco de dados.
	 * @param conexao
	 * 			Credenciais da conexão.
	 * @throws Exception
	 * @see TipoTelefone, TipoTelefoneBO
	 */
	public void editar(TipoTelefone tipoTelefone, Connection conexao) throws Exception {
		try {
			String sql = "UPDATE T_AM_HBV_TIPO_TELEFONE SET DS_TIPO_TELEFONE = ? WHERE CD_TIPO_TELEFONE = ?";
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, tipoTelefone.getNome());
			estrutura.setInt(2, tipoTelefone.getCodigo());

			estrutura.execute();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Exclui o tipo fr telefone do banco de dado com o código passado.
	 * 
	 * @author Lucas 74795
	 * @since 3.0
	 * @param codigo
	 * 			Código do tipo de telefone que será excluído.
	 * @param conexao
	 * 			Credenciais da conexão.
	 * @throws Exception
	 * @see TipoTelefone, TipoTelefoneBO
	 */
	public void excluir(int codigo, Connection conexao) throws Exception {
		try{
			String sql = "DELETE FROM T_AM_HBV_TIPO_TELEFONE WHERE CD_TIPO_TELEFONE = ?";
			PreparedStatement estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, codigo);
			
			estrutura.execute();
			estrutura.close();
			
		} catch(Exception e){
			throw new Excecao(e);
		}
	}
}
