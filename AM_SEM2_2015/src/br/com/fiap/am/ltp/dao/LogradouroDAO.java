package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.ltp.beans.Bairro;
import br.com.fiap.am.ltp.beans.Logradouro;
import br.com.fiap.am.ltp.beans.TipoLogradouro;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Mateus 74793
 * @version 1.0
 * @since 1.0
 * @see Meu Beans
 */
public class LogradouroDAO 
{
	String sql = "";
	PreparedStatement estrutura = null;
	ResultSet resultado = null;
	
	/**
	 * Método responsavel pela gravação de um logradouro no banco de dados
	 * @param logradouro Leva os atributos para a gravação no banco
	 * @param conexao Leva a Credencial de conexão
	 * @return <code> estrutura.execute(); </code> Retorna um true ou false.
	 * @throws Exception
	 * @see Logradouro, LogradouroBO
	 */
	public boolean gravar(Logradouro logradouro,Connection conexao) throws Exception
	{
		try 
		{
			sql = "INSERT INTO T_AM_HBV_LOGRADOURO(NR_CEP,CD_TIPO_LOGRADOURO,CD_BAIRRO,DS_DESCRICAO) VALUES(?,?,?,?)";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1,logradouro.getCep());
			estrutura.setInt(2, logradouro.getTipo().getCodigo());
			estrutura.setInt(3, logradouro.getBairro().getCodigo());
			estrutura.setString(4, logradouro.getDescricao());
			return estrutura.execute();
		}
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}
	/**
	 * Método responsavel pela edição de um registro no banco de daos
	 * @param logradouro Leva os atributos para a edição no banco
	 * @param conexao Leva a Credencial de conexão
	 * @return <code> estrutura.execute(); </code> Retorna um true ou false.
	 * @throws Exception
	 * @see Logradouro, LogradouroBO
	 */
	public boolean editar(Logradouro logradouro,Connection conexao) throws Exception
	{
		try 
		{
			sql = "UPDATE T_AM_HBV_LOGRADOURO SET CD_TIPO_LOGRADOURO = ?,CD_BAIRRO = ?,DS_DESCRICAO = ? WHERE NR_CEP = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1,logradouro.getCep());
			estrutura.setInt(2, logradouro.getTipo().getCodigo());
			estrutura.setInt(3, logradouro.getTipo().getCodigo());
			estrutura.setString(4, logradouro.getDescricao());
			estrutura.setInt(5, logradouro.getCep());
			return estrutura.execute();
		}
		catch (Exception e) 
		{
			throw new Excecao(e);
		}		
	}
	/**
	 * Método responsavel pela Exclusão de um logradouro no banco de dados
	 * @param logradouro Leva os atributos para a exclusão no banco
	 * @param conexao Leva a Credencial de conexão
	 * @return <code> estrutura.execute(); </code> Retorna um true ou false.
	 * @throws Exception
	 * @see Logradouro, LogradouroBO
	 */
	public boolean excluir(Logradouro logradouro,Connection conexao) throws Exception
	{
		try 
		{
			sql = "DELETE T_AM_HBV_LOGRADOURO WHERE NR_CEP = ?";
			estrutura = conexao.prepareStatement(sql);	
			estrutura.setInt(1, logradouro.getCep());
			return estrutura.execute();
		}
		catch (Exception e) 
		{
			throw new Excecao(e);
		}		
	}
	/**
	 * Método que retorna todos os logradouros cadastrados no banco de dados.
	 * @param conexao Leva a credencias de conexão
	 * @return <code> lstLogradouro </code> Lista com todos os logradouros 
	 * cadastrados no banco de dados.
	 * @throws Exception
	 * @see Logradouro, LogradouroBO
	 */
	public List<Logradouro> buscasTodos(Connection conexao) throws Exception
	{
		try 
		{
			sql = "SELECT L.NR_CEP,TP.DS_TIPO_LOGRADOURO,L.DS_DESCRICAO,B.NM_BAIRRO FROM T_AM_HBV_LOGRADOURO L INNER JOIN T_AM_HBV_TIPO_LOGRADOURO TP ON L.CD_TIPO_LOGRADOURO = TP.CD_TIPO_LOGRADOURO INNER JOIN T_AM_HBV_BAIRRO B ON L.CD_BAIRRO = B.CD_BAIRRO";
			List<Logradouro> lstLogradouro = new ArrayList<Logradouro>();
			estrutura = conexao.prepareStatement(sql);
			resultado = estrutura.executeQuery();
			while(resultado.next())
			{
				Logradouro lgd = new Logradouro();
				Bairro bairro = new Bairro();
				TipoLogradouro tipoLogradouro = new TipoLogradouro();
				lgd.setCep(resultado.getInt("NR_CEP"));
				lgd.setDescricao(resultado.getString("DS_DESCRICAO"));
				tipoLogradouro.setDescricao("DS_TIPO_LOGRADOURO");
				bairro.setNome(resultado.getString("NM_BAIRRO"));
				lgd.setBairro(bairro);
				lgd.setTipo(tipoLogradouro);
				lstLogradouro.add(lgd);
			}
			return lstLogradouro;
		}
		catch (Exception e) 
		{
			throw new Excecao(e);
		}		
	}
	/**
	 * Método qure retorna uma pesquisa
	 * @param logradouro Leva o objeto Logradouro com um atributo preenchido para pesquisa.
	 * @param conexao Leva a credencias de conexão
	 * @return <code> lstLogradouro </code> Lista com o resultado da busca 
	 * @throws Exception
	 * @see Logradouro, LogradouroBO
	 * */
	public List<Logradouro> buscasPorNome(Logradouro logradouro,Connection conexao) throws Exception
	{
		try 
		{
			sql = "SELECT L.NR_CEP,TP.DS_TIPO_LOGRADOURO,L.DS_DESCRICAO,B.NM_BAIRRO FROM T_AM_HBV_LOGRADOURO L INNER JOIN T_AM_HBV_TIPO_LOGRADOURO TP ON L.CD_TIPO_LOGRADOURO = TP.CD_TIPO_LOGRADOURO INNER JOIN T_AM_HBV_BAIRRO B ON L.CD_BAIRRO = B.CD_BAIRRO WHERE UPPER(L.DS_DESCRICAO) LIKE UPPER(?)";
			List<Logradouro> lstLogradouro = new ArrayList<Logradouro>();
			estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, "%" + logradouro.getDescricao() + "%");
			resultado = estrutura.executeQuery();
			while(resultado.next())
			{
				Logradouro lgd = new Logradouro();
				Bairro bairro = new Bairro();
				TipoLogradouro tipoLogradouro = new TipoLogradouro();
				lgd.setCep(resultado.getInt("NR_CEP"));
				lgd.setDescricao(resultado.getString("DS_DESCRICAO"));
				tipoLogradouro.setDescricao("DS_TIPO_LOGRADOURO");
				bairro.setNome(resultado.getString("NM_BAIRRO"));
				lgd.setBairro(bairro);
				lgd.setTipo(tipoLogradouro);
				lstLogradouro.add(lgd);
			}
			return lstLogradouro;
		}
		catch (Exception e) 
		{
			throw new Excecao(e);
		}		
	}
}
