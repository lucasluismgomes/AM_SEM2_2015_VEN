package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.am.ltp.beans.Estado;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795, Mateus 74793
 * @version 1.0
 * @since 1.0
 * @see Meu Beans
 */
public class EstadoDAO 
{
	/**
	 * Método responsavel pela gravação de um estado no banco de dados.
	 * @param estado
	 * 			Objeto Estado que faz a gravação no banco de dados do Nome e Sigla.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @return <code>estrutura.execute();</code> retorna um boolean, se for verdadeiro
	 * 			ele realizou a gravação no banco, caso seja false, nao.
	 * @throws Excecao
	 * @see Estado, EstadoBO
	 */
	public boolean gravar(Estado estado,Connection conexao) throws Excecao
	{
		try
		{
			PreparedStatement estrutura = conexao.prepareStatement("INSERT INTO T_AM_HBV_ESTADO(NM_ESTADO,SG_ESTADO) VALUES(?,?)");
			estrutura.setString(1, estado.getNome());
			estrutura.setString(2, estado.getSigla());
			return estrutura.execute();
		}
		catch(Exception e)
		{
			throw new Excecao(e);
		}
	}
	/**
	 * Método responsavel pela atualização das informações do estado no banco de dados
	 * @param estado
	 * 			Objeto Estado que faz a edição no banco de dados do Nome e Sigla. 
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @return<code>estrutura.execute();</code> retorna um boolean, se for verdadeiro
	 * 			ele realizou a edição no banco, caso seja false, nao.
	 * @throws Excecao
	 * @see Estado,EstadoBO
	 */
	public boolean editar(Estado estado,Connection conexao) throws Excecao
	{
		try 
		{
			PreparedStatement estrutura = conexao.prepareStatement("UPDATE T_AM_HBV_ESTADO SET NM_ESTADO = ?, SG_ESTADO = ? WHERE CD_ESTADO = ?");
			estrutura.setString(1, estado.getNome());
			estrutura.setString(2, estado.getSigla());
			estrutura.setInt(3, estado.getCodigo());
			return estrutura.execute();
		}
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}
	/**
	 * Método responsavel pela exclusão de um registro no banco de dados.
	 * @param estado
	 *			Objeto Estado que faz a exclusão no banco de dados do Nome e Sigla. 
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @return<code>estrutura.execute();</code> retorna um boolean, se for verdadeiro
	 * 			ele realizou a exclusão no banco, caso seja false, nao.
	 * @throws Excecao
	 * @see Estado,EstadoBO
	 */
	public boolean excluir(Estado estado, Connection conexao) throws Excecao
	{
		try 
		{
			PreparedStatement estrutura = conexao.prepareStatement("DELETE FROM T_AM_HBV_ESTADO WHERE CD_ESTADO = ?");
			estrutura.setInt(1, estado.getCodigo());
			return estrutura.execute();
		}
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}
	/**
	 * Método responsavel por trazer todos os registros dos estados cadastrados
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @return<code>lstEstado</code> Retorna um lista de estados.
	 * @throws Excecao
	 * @see Estado,EstadoBO
	 */
	public List<Estado> buscarTodos(Connection conexao) throws Excecao
	{
		try 
		{
			PreparedStatement estrutura = conexao.prepareStatement("SELECT CD_ESTADO,NM_ESTADO,SG_ESTADO FROM T_AM_HBV_ESTADO");
			ResultSet resultado = estrutura.executeQuery();
			List<Estado> lstEstado = new ArrayList<Estado>();
			while(resultado.next())
			{
				Estado estado = new Estado();
				estado.setCodigo(resultado.getInt("CD_ESTADO"));
				estado.setNome(resultado.getString("NM_ESTADO"));
				estado.setSigla(resultado.getString("SG_ESTADO"));
				lstEstado.add(estado);
			}
			return lstEstado;
		}
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}
	/**
	 * Método que realiza uma pesquisa no banco de dados a partir de um parametro informado pelo usuario.
	 * @param estado
	 * 			Objeto Estado utiliza o atributo nome para realizar uma pesquisa no banco de dados.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @return <code>lstEstado</code> Retorna um lista de estados a partir do parametro que o usuario informou
	 * @throws Excecao
	 * @see Estado,EstadoBO
	 */
	public List<Estado> buscarPorNome(Estado estado,Connection conexao) throws Excecao
	{
		try 
		{
			PreparedStatement estrutura = conexao.prepareStatement("SELECT CD_ESTADO,NM_ESTADO,SG_ESTADO FROM T_AM_HBV_ESTADO WHERE UPPER(NM_ESTADO) LIKE UPPER(?)");
			estrutura.setString(1, "%"+estado.getNome()+"%");
			ResultSet resultado = estrutura.executeQuery();
			List<Estado> lstEstado = new ArrayList<Estado>();
			while(resultado.next())
			{
				Estado e = new Estado();
				e.setCodigo(resultado.getInt("CD_ESTADO"));
				e.setNome(resultado.getString("NM_ESTADO"));
				e.setSigla(resultado.getString("SG_ESTADO"));
				lstEstado.add(e);
			}
			return lstEstado;
		}
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}	
}
