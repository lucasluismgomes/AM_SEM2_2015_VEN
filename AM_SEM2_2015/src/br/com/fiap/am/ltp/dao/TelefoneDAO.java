package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.ltp.beans.Telefone;
import br.com.fiap.am.ltp.beans.TipoTelefone;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 * @see Meu Beans
 */
public class TelefoneDAO {
	private String sql = "";
	private PreparedStatement estrutura = null;
	private ResultSet rs = null;

	/**
	 * Faz a gravação de um telefone no banco de dados. Olhe a classe TelefoneBO
	 * para entender as regras de negócio.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param telefone
	 * 			O telefone que será gravado no banco de dados.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @throws Exception
	 * @see Telefone, TelefoneBO
	 */
	public void gravar(Telefone telefone, Connection conexao) throws Exception {
		try {
			sql = "INSERT INTO T_AM_HBV_TELEFONE (CD_TIPO_TELEFONE,NR_DDD,NR_TELEFONE) VALUES(?,?,?)";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, telefone.getTipo().getCodigo());
			estrutura.setShort(2, telefone.getDdd());
			estrutura.setLong(3, telefone.getNumero());

			estrutura.execute();
			estrutura.close();

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Faz a busca de todos os telefones gravados no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @return <code>lstTelefone</code> Uma lista com todos os telefones do banco de dados.
	 * @throws Exception
	 * @see Telefone, TelefoneBO
	 */
	public List<Telefone> buscarTodos(Connection conexao) throws Exception {
		List<Telefone> lstTelefone = new ArrayList<Telefone>();
		try {
			sql = "SELECT T.CD_TELEFONE,T.NR_DDD,T.NR_TELEFONE,T.CD_TIPO_TELEFONE,TT.DS_TIPO_TELEFONE "
					+ "FROM T_AM_HBV_TELEFONE T INNER JOIN T_AM_HBV_TIPO_TELEFONE TT "
					+ "ON T.CD_TIPO_TELEFONE = TT.CD_TIPO_TELEFONE";
			estrutura = conexao.prepareStatement(sql);

			rs = estrutura.executeQuery();
			
			while(rs.next()){
				Telefone telefone = new Telefone();
				
				telefone.setCodigo(rs.getInt("CD_TELEFONE"));
				telefone.setDdd(rs.getShort("NR_DDD"));
				telefone.setNumero(rs.getLong("NR_TELEFONE"));
				
				TipoTelefone tipo = new TipoTelefone();
				
				tipo.setCodigo(rs.getInt("CD_TIPO_TELEFONE"));
				tipo.setNome(rs.getString("DS_TIPO_TELEFONE"));
				
				telefone.setTipo(tipo);
				
				lstTelefone.add(telefone);
			}
			
			rs.close();
			estrutura.close();
			return lstTelefone;
			
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Faz a busca de todos os telefones de uma pessoa especifica gravados no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param codigoPessoa
	 * 			O código da pessoa pelo qual os telefones serão buscados.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @return <code>lstTelefone</code> Uma lista com todos os telefones do banco de dados.
	 * @throws Exception
	 * @see Telefone, TelefoneBO
	 */
	public List<Telefone> buscarPorCodigoPessoa(int codigoPessoa, Connection conexao) throws Exception {
		List<Telefone> lstTelefone = new ArrayList<Telefone>();
		try {
			sql = "SELECT  T.CD_TELEFONE,T.NR_DDD,T.NR_TELEFONE,T.CD_TIPO_TELEFONE,TT.DS_TIPO_TELEFONE "
					+	"FROM T_AM_HBV_TELEFONE T INNER JOIN T_AM_HBV_TIPO_TELEFONE TT "
					+	"ON T.CD_TIPO_TELEFONE = TT.CD_TIPO_TELEFONE "
					+	"INNER JOIN T_AM_HBV_PESSOA_TELEFONE TP "
					+	"ON T.CD_TELEFONE = TP.CD_TELEFONE "
					+	"WHERE TP.CD_PESSOA = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, codigoPessoa);

			rs = estrutura.executeQuery();
			
			while(rs.next()){
				Telefone telefone = new Telefone();
				
				telefone.setCodigo(rs.getInt("CD_TELEFONE"));
				telefone.setDdd(rs.getShort("NR_DDD"));
				telefone.setNumero(rs.getLong("NR_TELEFONE"));
				
				TipoTelefone tipo = new TipoTelefone();
				
				tipo.setCodigo(rs.getInt("CD_TIPO_TELEFONE"));
				tipo.setNome(rs.getString("DS_TIPO_TELEFONE"));
				
				telefone.setTipo(tipo);
				
				lstTelefone.add(telefone);
			}
			
			rs.close();
			estrutura.close();
			return lstTelefone;
			
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Faz a edição de um telefone no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param telefone
	 * 			O telefone que está sendo editado no banco de dados.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @throws Exception
	 * @see Telefone, TelefoneBO
	 */
	public void editar(Telefone telefone, Connection conexao) throws Exception {
		try {
			sql = "UPDATE T_AM_HBV_TELEFONE SET NR_DDD = ?, NR_TELEFONE = ?, CD_TIPO_TELEFONE = ? WHERE CD_TELEFONE = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setShort(1, telefone.getDdd());
			estrutura.setLong(2, telefone.getNumero());
			estrutura.setInt(3, telefone.getTipo().getCodigo());
			estrutura.setInt(4, telefone.getCodigo());
			
			estrutura.execute();
			estrutura.close();
			
		} catch(Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Faz a exclusão de um telefone do banco dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param codigo
	 * 			O código do telefone que será excluído.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @throws Exception
	 * @see Telefone, TelefoneBO
	 */
	public void excluir(int codigo, Connection conexao) throws Exception {
		try {
			sql = "DELETE FROM T_AM_HBV_TELEFONE WHERE CD_TELEFONE = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, codigo);
			
			estrutura.execute();
			estrutura.close();
			
		} catch(Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Verifica se os dados de um telefone já existem no banco de dados.
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param telefone
	 * 			O telefone que está sendo verificado.
	 * @param conexao
	 * 			As credenciais da conexão.
	 * @return <code>existe</code> Retorna <code>True</code> se já existir, e <code>False</code> caso não exista.
	 * @throws Exception
	 * @see Telefone, TelefoneBO
	 */
	public boolean verificarExistencia(Telefone telefone, Connection conexao) throws Exception {
		try {
			sql = "SELECT  T.NR_DDD,T.NR_TELEFONE "
					+	"FROM T_AM_HBV_TELEFONE T "
					+	"WHERE T.NR_DDD = ? AND T.NR_TELEFONE = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setShort(1, telefone.getDdd());
			estrutura.setLong(2, telefone.getNumero());

			rs = estrutura.executeQuery();
			
			boolean existe;
			
			if(rs.next()) {
				existe = true;
			} else {
				existe = false;
			}
			
			estrutura.close();
			
			return existe;
			
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
}
