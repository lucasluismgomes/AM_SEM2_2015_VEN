package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.ltp.beans.FormaPagamento;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Métodos de acesso ao banco de Forma de Pagamento. Operações do CRUD 
 * 
 * @author Victor 74820
 * @version 1.0
 * @since 1.0
 * @see FormaPagamento, FormaPagamentoBO
 */
public class FormaPagamentoDAO {
	private String sql = "";
	private PreparedStatement estrutura = null;
	private ResultSet rs = null;

	/**
	 * Faz a gravação de uma Forma de Pagamento no banco de dados. Veja a classe BO para
	 * entender as regras de negócio.
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param FormaPagamento
	 *            A Forma de Pagamento que está sendo gravado no banco.
	 * @param conexao
	 *            Credenciais da conexão.
	 * @throws Exception
	 * @see FormaPagamento, FormaPagamentoBO
	 */
	public void gravar(FormaPagamento formaPagamento, Connection conexao) throws Exception {
		try {
			sql = "INSERT INTO T_AM_HBV_TIPO_FORMAPAG (DS_FORMAPAG) VALUES(?)";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1, formaPagamento.getDescricao());

			estrutura.executeQuery();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Busca todas as Formas de Pagamento gravadas no Banco de Dados
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param conexao
	 * 		As credenciais da conexão.
	 * @return <code>lstFormaPag</code> Lista com todas as Formas de Pagamento 
	 * @throws Exception
	 * @see	FormaPagamento, FormaPagamentoBO
	 * 
	 */
	
	public List<FormaPagamento> buscarTodos(Connection conexao) throws Exception {
		List<FormaPagamento> lstFormaPag = new ArrayList<FormaPagamento>();
		
		try{
			
			sql = "SELECT CD_TIPO_FORMAPAG," + "DS_FORMAPAG" + " FROM T_AM_HBV_TIPO_FORMAPAG ORDER BY CD_TIPO_FORMAPAG";
			estrutura = conexao.prepareStatement(sql);
			
			rs = estrutura.executeQuery();
			
			while(rs.next()){
				FormaPagamento formaPag = new FormaPagamento();
				formaPag.setCodigo(Integer.parseInt(rs.getString("CD_TIPO_FORMAPAG")));
				formaPag.setDescricao(rs.getString("DS_FORMAPAG"));
				
				lstFormaPag.add(formaPag);
			}
			
			rs.close();
			estrutura.close();
			
			return lstFormaPag;
			
		}catch (Exception e){
			throw new Excecao(e);
		}
	}
	
	/**
	 * Busca uma Formas de Pagamento específica do Banco de Dados
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param conexao
	 * 		As credenciais da conexão.
	 * @return Uma Forma de Pagamento 
	 * @throws Exception
	 * @see	FormaPagamento, FormaPagamentoBO
	 * 
	 */
	
	public FormaPagamento buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		FormaPagamento formaPag = new FormaPagamento();
		
		try{
			
			sql = "SELECT CD_TIPO_FORMAPAG," + "DS_FORMAPAG" + " FROM T_AM_HBV_TIPO_FORMAPAG WHERE CD_TIPO_FORMAPAG = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, codigo);
			
			rs = estrutura.executeQuery();
			
			if (rs.next()) {
				formaPag.setCodigo(Integer.parseInt(rs.getString("CD_TIPO_FORMAPAG")));
				formaPag.setDescricao(rs.getString("DS_FORMAPAG"));
			}
			rs.close();
			estrutura.close();
			
			return formaPag;
			
		}catch (Exception e){
			throw new Excecao(e);
		}
	}
	
	
	/**
	 * Edita as informações de uma Forma de Pagamento no banco de dados.
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param FormaPagamento
	 *            Os dados da Forma de Pagamento que será editada.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see FormaPagamento, FormaPagamentoBO
	 */
	
	public void editar(FormaPagamento formaPag, Connection conexao) throws Exception{
		try{
			sql = "UPDATE T_AM_HBV_TIPO_FORMAPAG SET DS_FORMAPAG = ?" + " WHERE CD_TIPO_FORMAPAG = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setString(1,formaPag.getDescricao());
			estrutura.setInt(2, formaPag.getCodigo());
			
			estrutura.executeQuery();
			estrutura.close();
			
		}catch (Exception e){
			throw new Excecao(e);
		}
	}
	
	
	/**
	 * Excluí uma Forma de Pagamento do banco de dados. 
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param codigo
	 *            O código da Forma de Pagamento que será excluída.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see FormaPagamento, FormaPagamentoBO
	 */
	
	public void excluir(int codigo, Connection conexao) throws Exception{
		try{
			
			sql = "DELETE FROM T_AM_HBV_TIPO_FORMAPAG WHERE CD_TIPO_FORMAPAG = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, codigo);
			
			estrutura.execute();
			estrutura.close();
						
			
		}catch (Exception e){
			throw new Excecao(e);
		}
	}
	
}
