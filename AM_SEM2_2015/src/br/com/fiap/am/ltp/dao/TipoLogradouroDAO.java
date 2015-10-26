package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.ltp.beans.TipoLogradouro;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 * @see Meu Beans
 */
public class TipoLogradouroDAO 
{
	String sql = "";
	PreparedStatement estrutura = null;
	ResultSet resultado = null;
	
	/**
	 * Faz a gravação do tipo de logradouro no banco de dados exemplo: Avenida,Rua etc.. 
	 * @param tipoLogradouro Leva as informações para a gravação no banco dados
	 * @param conexao Credenciais da conexão.
	 * @return <code> estrutura.execute() </code> Retorna um boolean.. Caso a gravação
	 * aconteça retorna um true, caso ao contrario false.
	 * @throws Exception
	 * @see TipoLogradouro,TipoLogradouroBO
	 */
	public boolean gravar(TipoLogradouro tipoLogradouro,Connection conexao) throws Exception
	{
		try 
		{
			sql = "INSERT INTO T_AM_HBV_TIPO_LOGRADOURO(DS_TIPO_LOGRADOURO) VALUES(?)";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, tipoLogradouro.getDescricao());
			return estrutura.execute();
		} 
		catch (Exception e)
		{
			throw new Excecao(e);
		}
	}
	/**
	 * Método responsavel pela edição do tipo de logradouro no banco de dados.
	 * @param tipoLogradouro Leva as informações para edição no banco de dados.
	 * @param conexao Leva as credenciais de conexao
	 * @return <code> estrutura.execute() </code> retorna um boolean, se for realizado a edição retorna
	 * um true, caso ao contrario um false.
	 * @throws Exception
	 * @see TipoLogradouro,TipoLogradouroBO
	 */
	public boolean editar(TipoLogradouro tipoLogradouro,Connection conexao) throws Exception
	{
		try 
		{
			sql = "UPDATE T_AM_HBV_TIPO_LOGRADOURO SET DS_TIPO_LOGRADOURO = ? WHERE CD_TIPO_LOGRADOURO = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, tipoLogradouro.getDescricao());
			estrutura.setInt(2, tipoLogradouro.getCodigo());
			return estrutura.execute();
		} 
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}
	/**
	 * Método responsavel por excluir um tipo de logradouro no banco dados.
	 * @param tipoLogradouro Leva as informações para exclusão no banco de dados.
	 * @param conexao Leva as credenciais de conexao
	 * @return <code> estrutura.execute() </code> retorna um boolean, se for realizado a exclusão retorna
	 * um true, caso ao contrario um false.
	 * @throws Exception
	 * @see TipoLogradouro,TipoLogradouroBO
	 */
	public boolean excluir(int codigo,Connection conexao) throws Exception
	{
		try 
		{
			sql = "DELETE FROM T_AM_HBV_TIPO_LOGRADOURO WHERE CD_TIPO_LOGRADOURO = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, codigo);	
			return estrutura.execute();
		}
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}
	/**
	 * Método que retorna todos os registros de Tipo de Logradouro do banco de dados.
	 * @param conexao Leva as credenciais de conexao.
	 * @return <code> lstTipoLogradouro </code> Retorna uma lista de Tipo de Logradouro.
	 * @throws Exception
	 * @see TipoLogradouro,TipoLogradouroBO
	 */
	public List<TipoLogradouro> buscarTodos(Connection conexao) throws Exception
	{
		try 
		{
			sql = "SELECT CD_TIPO_LOGRADOURO,DS_TIPO_LOGRADOURO FROM T_AM_HBV_TIPO_LOGRADOURO";
			estrutura = conexao.prepareStatement(sql);
			resultado = estrutura.executeQuery();
			List<TipoLogradouro> lstTipoLogradouro = new ArrayList<TipoLogradouro>();
			while(resultado.next())
			{
				TipoLogradouro tp = new TipoLogradouro();
				tp.setCodigo(resultado.getInt("CD_TIPO_LOGRADOURO"));
				tp.setDescricao(resultado.getString("DS_TIPO_LOGRADOURO"));
				lstTipoLogradouro.add(tp);
			}
			return lstTipoLogradouro;
		}
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}
	/**
	 * Método que retorna uma pesquisa de tipos de Logradouros.
	 * @param tipoLogradouro Leva o parametro de pesquisa.
	 * @param conexao Leva a Credenciais de pesquisa
	 * @return <code> lstTipoLogradouro </code> Retorna uma pesquisa.
	 * @throws Exception
	 * @see TipoLogradouro,TipoLogradouroBO
	 */
	public List<TipoLogradouro> buscarPorNome(String pesquisaTipoLogradouro,Connection conexao) throws Exception
	{
		try 
		{
			sql = "SELECT CD_TIPO_LOGRADOURO,DS_TIPO_LOGRADOURO FROM T_AM_HBV_TIPO_LOGRADOURO WHERE UPPER(DS_TIPO_LOGRADOURO) LIKE UPPER(?)";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1,"%" + pesquisaTipoLogradouro + "%");
			resultado = estrutura.executeQuery();
			List<TipoLogradouro> lstTipoLogradouro = new ArrayList<TipoLogradouro>();
			while(resultado.next())
			{
				TipoLogradouro tp = new TipoLogradouro();
				tp.setCodigo(resultado.getInt("CD_TIPO_LOGRADOURO"));
				tp.setDescricao(resultado.getString("DS_TIPO_LOGRADOURO"));
				lstTipoLogradouro.add(tp);
			}
			return lstTipoLogradouro;
		}
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}
}
