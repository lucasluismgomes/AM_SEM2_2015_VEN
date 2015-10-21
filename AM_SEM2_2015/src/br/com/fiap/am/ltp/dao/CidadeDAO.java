package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.ltp.beans.Cidade;
import br.com.fiap.am.ltp.beans.Estado;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Mateus 74793, Lucas 74795
 * @version 2.0
 * @since 1.0
 * @see Cidade, CidadeBO
 */
public class CidadeDAO {
	/**
	 * Faz a gravação de uma cidade no banco de dados. Caso a gravação ocorra,
	 * retorna True.
	 * 
	 * @author Mateus 74793, Lucas 74795
	 * @since 1.0
	 * @param cidade
	 *            A cidade que será gravada no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return <code>estrutura.execute()</code> True caso a gravação ocorra, e
	 *         False caso não seja gravado.
	 * @throws Excecao
	 * @see Cidade, CidadeBO
	 */
	public boolean gravar(Cidade cidade, Connection conexao) throws Excecao {
		try {
			PreparedStatement estrutura = conexao
					.prepareStatement("Insert into T_AM_HBV_CIDADE(CD_ESTADO,NM_CIDADE) VALUES(?,?)");
			Estado estado = cidade.getEstado();
			estrutura.setInt(1, estado.getCodigo());
			estrutura.setString(2, cidade.getNome());

			return estrutura.execute();
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	/**
	 * Faz a edição de uma cidade no banco de dados.
	 * 
	 * @author Mateus 74793
	 * @since 1.0
	 * @param cidade
	 *            A cidade que será editada.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return <code>estrutura.execute()</code> True caso a edição ocorra, e
	 *         False caso não tenha alteração.
	 * @throws Excecao
	 * @see Cidade, CidadeBO
	 */
	public boolean editar(Cidade cidade, Connection conexao) throws Excecao {
		try {
			PreparedStatement estrutura = conexao
					.prepareStatement("Update T_AM_HBV_CIDADE set CD_ESTADO = ?,NM_CIDADE = ? WHERE CD_CIDADE = ?");
			Estado estado = cidade.getEstado();
			estrutura.setInt(1, estado.getCodigo());
			estrutura.setString(2, cidade.getNome());
			estrutura.setInt(3, cidade.getCodigo());

			return estrutura.execute();
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	/**
	 * Faz a busca de cidades com nome especifico.
	 * 
	 * @author Mateus 74793
	 * @since 1.0
	 * @param cidade
	 *            A cidade com o nome que será buscado.
	 * @param conexao
	 * @return <code>lstCidade</code> Lista com as cidades que contém o nome ou
	 *         parte dele.
	 * @throws Excecao
	 * @see Cidade, CidadeBO,Estado
	 */
	public List<Cidade> buscarPorNome(Cidade cidade, Connection conexao) throws Excecao 
	{		
		try {
			List<Cidade> lstCidade = new ArrayList<Cidade>();
			PreparedStatement estrutura = conexao.prepareStatement("SELECT C.CD_CIDADE,E.SG_ESTADO,E.NM_ESTADO, C.NM_CIDADE FROM T_AM_HBV_CIDADE C INNER JOIN T_AM_HBV_ESTADO E ON C.CD_ESTADO = E.CD_ESTADO WHERE UPPER(C.NM_CIDADE) LIKE UPPER(?)");
			estrutura.setString(1,"%"+ cidade.getNome()+"%");
			
			ResultSet resultado = estrutura.executeQuery();
			
			while (resultado.next()) {
				Cidade cid = new Cidade();
				Estado est = new Estado();
				cid.setCodigo(resultado.getInt("CD_CIDADE"));
				cid.setNome(resultado.getString("NM_CIDADE"));
				est.setSigla(resultado.getString("SG_ESTADO"));
				est.setNome(resultado.getString("NM_ESTADO"));
				cid.setEstado(est);
				lstCidade.add(cid);
			}
			
			return lstCidade;
		} catch (Exception e) {
			throw new Excecao(e);
		}	
	}

	/**
	 * Faz a busca de todas as cidades no banco de dados.
	 * 
	 * @author Mateus 74793
	 * @since 1.0
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @return <code>lstCidade</code> Lista com as cidades retornadas do banco de dados.
	 * @throws Excecao
	 * @see Cidade, CidadeBO,Estado
	 */
	public List<Cidade> buscarTodos(Connection conexao) throws Excecao {
		try {
			List<Cidade> lstCidade = new ArrayList<Cidade>();
			PreparedStatement estrutura = conexao
					.prepareStatement("SELECT C.CD_CIDADE,E.SG_ESTADO,E.NM_ESTADO, C.NM_CIDADE FROM T_AM_HBV_CIDADE C INNER JOIN T_AM_HBV_ESTADO E ON C.CD_ESTADO = E.CD_ESTADO");
			ResultSet resultado = estrutura.executeQuery();
			while (resultado.next()) {
				Cidade cid = new Cidade();
				Estado est = new Estado();
				cid.setCodigo(resultado.getInt("CD_CIDADE"));
				cid.setNome(resultado.getString("NM_CIDADE"));
				est.setSigla(resultado.getString("SG_ESTADO"));
				est.setNome(resultado.getString("NM_ESTADO"));
				cid.setEstado(est);
				lstCidade.add(cid);
			}
			return lstCidade;
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	/**
	 * Faz a exclusão de uma cidade no banco de dados.
	 * 
	 * @author Mateus 74793
	 * @since 1.0
	 * @param cidade
	 *            A cidade que será excluída.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @return <code>estrutura.execute()</code> True caso um registro sera apagado, e
	 *         False caso não deletado.
	 * @throws Excecao
	 * @see Cidade, CidadeBO
	 */
	public boolean excluir(Cidade cidade, Connection conexao) throws Excecao {
		try {
			PreparedStatement estrutura = conexao
					.prepareStatement("DELETE FROM T_AM_HBV_CIDADE WHERE CD_CIDADE = ?");
			estrutura.setInt(1, cidade.getCodigo());
			return estrutura.execute();
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
}
