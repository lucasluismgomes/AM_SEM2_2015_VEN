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
 * @author Lucas 74795,Mateus 74793
 * @version 1.0
 * @since 1.0
 * @see Meu Beans
 */
public class CidadeDAO 
{
	public int gravarCidade(Cidade cidade,Connection conexao) throws Excecao
	{
		try
		{
			PreparedStatement estrutura = conexao.prepareStatement("Insert into T_AM_HBV_CIDADE(CD_ESTADO,NM_CIDADE) VALUES(?,?)");
			Estado estado = cidade.getEstado();
			estrutura.setInt(1, estado.getCodigo());
			estrutura.setString(2, cidade.getNome());
			return estrutura.executeUpdate();
		}
		catch(Exception e)
		{
			throw new Excecao(e);
		}
	}
	public int atualizarCidade(Cidade cidade,Connection conexao) throws Excecao
	{
		try
		{
			PreparedStatement estrutura = conexao.prepareStatement("Update T_AM_HBV_CIDADE set CD_ESTADO = ?,NM_CIDADE = ? WHERE CD_CIDADE = ?");
			Estado estado = cidade.getEstado();
			estrutura.setInt(1, estado.getCodigo());
			estrutura.setString(2, cidade.getNome());
			estrutura.setInt(3, cidade.getCodigo());
			
			return estrutura.executeUpdate();
		}
		catch(Exception e)
		{
			throw new Excecao(e);
		}
	}
	public List<Cidade> buscaCidade(Cidade cidade,Connection conexao) throws Excecao
	{
		try
		{
			List<Cidade> cidades = new ArrayList<Cidade>();
			PreparedStatement estrutura = conexao.prepareStatement("SELECT E.SG_ESTADO,E.NM_ESTADO, C.NM_CIDADE FROM T_AM_HBV_CIDADE C INNER JOIN T_AM_HBV_ESTADO E ON C.CD_ESTADO = E.CD_ESTADO WHERE UPPER(C.NM_CIDADE) LIKE UPPER('%?%')");
			estrutura.setString(1, cidade.getNome());
			ResultSet resultado = estrutura.executeQuery();
			while(resultado.next())
			{
				Cidade cid = new Cidade();
				Estado est = new Estado();
				cid.setNome(resultado.getString("NM_CIDADE"));
				est.setSigla(resultado.getString("SG_ESTADO"));
				est.setNome(resultado.getString("NM_ESTADO"));
				cid.setEstado(est);
				cidades.add(cid);
			}	
			return cidades;
		} 
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}
	public List<Cidade> todasCidades(Connection conexao) throws Excecao
	{
		try 
		{
			List<Cidade> cidades = new ArrayList<Cidade>();
			PreparedStatement estrutura = conexao.prepareStatement("SELECT C.CD_CIDADE,E.SG_ESTADO,E.NM_ESTADO, C.NM_CIDADE FROM T_AM_HBV_CIDADE C INNER JOIN T_AM_HBV_ESTADO E ON C.CD_ESTADO = E.CD_ESTADO");
			ResultSet resultado = estrutura.executeQuery();
			while(resultado.next())
			{
				Cidade cid = new Cidade();
				Estado est = new Estado();
				cid.setCodigo(resultado.getInt("CD_CIDADE"));
				cid.setNome(resultado.getString("NM_CIDADE"));
				est.setSigla(resultado.getString("SG_ESTADO"));
				est.setNome(resultado.getString("NM_ESTADO"));
				cid.setEstado(est);
				cidades.add(cid);
			}	
			return cidades;
		}
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}
	public int deletar(Cidade cidade,Connection conexao) throws Excecao
	{
		try
		{
			PreparedStatement estrutura = conexao.prepareStatement("DELETE FROM T_AM_HBV_CIDADE WHERE CD_CIDADE = ?");
			estrutura.setInt(1, cidade.getCodigo());
			return estrutura.executeUpdate();
		} 
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}
}
