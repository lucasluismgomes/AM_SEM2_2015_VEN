package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Cidade;
import br.com.fiap.am.ltp.dao.CidadeDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class CidadeBO 
{
	public int gravar(Cidade cidade,Connection conexao) throws Excecao
	{
		try
		{
			return new CidadeDAO().gravarCidade(cidade, conexao);
		}
		catch(Exception e)
		{
			throw new Excecao(e);
		}
	}
	public int atualizar(Cidade cidade,Connection conexao) throws Excecao
	{
		try 
		{
			return new CidadeDAO().atualizarCidade(cidade, conexao);
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
			return new CidadeDAO().todasCidades(conexao);
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
			return new CidadeDAO().deletar(cidade, conexao);
		} 
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}
}
