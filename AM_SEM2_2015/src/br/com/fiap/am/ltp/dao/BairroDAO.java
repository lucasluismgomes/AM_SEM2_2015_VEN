package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.ltp.beans.Bairro;
import br.com.fiap.am.ltp.beans.Cidade;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Classe de acesso a dados de Bairro.
 * 
 * @author Lucas 74795, Mateus 74793
 * @version 2.0
 * @since 1.0
 */
public class BairroDAO 
{
	private String sql = "";
	private PreparedStatement estrutura = null;
	private ResultSet resultadoDados = null;
	/**
	 * Grava os dados de um bairro no banco de dados.
	 * 
	 * @param bairro O bairro que será gravado
	 * @param conexao Leva as credencias
	 * @throws Exception
	 * @see Bairro, BairroBO
	 */
	public boolean gravar(Bairro bairro, Connection conexao) throws Exception {
		try 
		{
			sql = "INSERT INTO T_AM_HBV_BAIRRO(CD_CIDADE,NM_BAIRRO) VALUES(?,?)";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, bairro.getCidade().getCodigo());
			estrutura.setString(2, bairro.getNome());
			return estrutura.execute();
		}
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}

	/**
	 * Grava as alterações de um bairro no banco de dados.
	 * 
	 * @param bairro O bairro que será alterado.
	 * @param conexao Leva as credencias
	 * @throws Exception
	 * @see Bairro, BairroBO
	 */
	public boolean editar(Bairro bairro, Connection conexao) throws Exception 
	{
		try
		{
			sql = "UPDATE T_AM_HBV_BAIRRO SET CD_CIDADE = ?, NM_BAIRRO = ? WHERE CD_BAIRRO = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, bairro.getCidade().getCodigo());
			estrutura.setString(2, bairro.getNome());
			estrutura.setInt(3, bairro.getCodigo());
			return estrutura.execute();
		}
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}

	/**
	 * Busca todos os bairros cadastrados no banco de dados.
	 * 
	 * @param conexao Leva as credencias
	 * @return lstBairro Uma lista com todos os bairros cadastrados
	 * @throws Exception
	 * @see Bairro, BairroBO,Cidade
	 */
	public List<Bairro> buscarTodos(Connection conexao) throws Exception {
		try{
			List<Bairro> lstBairro = new ArrayList<Bairro>();
			sql = "SELECT CD_BAIRRO,CD_CIDADE,NM_BAIRRO FROM T_AM_HBV_BAIRRO";
			estrutura = conexao.prepareStatement(sql);	
			resultadoDados = estrutura.executeQuery();
			while(resultadoDados.next()) 
			{
				Bairro bairro= new Bairro();
				Cidade cidade = new Cidade();
				bairro.setCodigo(resultadoDados.getInt("CD_BAIRRO"));
				cidade.setCodigo(resultadoDados.getInt("CD_CIDADE"));
				bairro.setCidade(cidade);
				bairro.setNome(resultadoDados.getString("NM_BAIRRO"));
				lstBairro.add(bairro);				
			}
			return lstBairro;
		} 
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}
	/**
	 * Busca todos os bairros cadastrados no banco de dados a partir de um pesquisa.
	 * 
	 * @param bairro Leva as informações do bairro para a pesquisa.
	 * @param conexao Leva as credencias
	 * @return lstBairro Uma lista com todos os bairros cadastrados
	 * @throws Exception
	 * @see Bairro, BairroBO,Cidade
	 */
	public List<Bairro> buscarPorNome(Bairro bairro, Connection conexao) throws Exception {
		try{
			List<Bairro> lstBairro = new ArrayList<Bairro>();
			sql = "SELECT CD_TIPO_LOGRADOURO,DS_TIPO_LOGRADOURO FROM T_AM_HBV_TIPO_LOGRADOURO WHERE UPPER(DS_TIPO_LOGRADOURO) LIKE UPPER(?)";
			estrutura = conexao.prepareStatement(sql);	
			estrutura.setString(1, "%"+bairro.getNome()+"%");
			resultadoDados = estrutura.executeQuery();
			while(resultadoDados.next()) 
			{
				Bairro b = new Bairro();
				Cidade c = new Cidade();
				b.setCodigo(resultadoDados.getInt("CD_BAIRRO"));
				c.setCodigo(resultadoDados.getInt("CD_CIDADE"));
				b.setCidade(c);
				b.setNome(resultadoDados.getString("NM_BAIRRO"));
				lstBairro.add(b);				
			}
			return lstBairro;
		} 
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}

	/**
	 * Apaga um bairro do banco de dados com base em seu id.
	 * 
	 * @param id O id do bairro que está sendo excluído
	 * @param conexao Leva as credencias
	 * @throws Exception
	 * @see Bairro, BairroBO
	 */
	public boolean excluir(Bairro bairro, Connection conexao) throws Exception 
	{
		try
		{
			sql = "DELETE FROM T_AM_HBV_BAIRRO WHERE CD_BAIRRO = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, bairro.getCodigo());				
			return estrutura.execute();
		}
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}
}