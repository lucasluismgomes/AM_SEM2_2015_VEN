package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.am.ltp.beans.Cliente;
import br.com.fiap.am.ltp.beans.Funcionario;
import br.com.fiap.am.ltp.beans.Hospedagem;
import br.com.fiap.am.ltp.beans.Quarto;
import br.com.fiap.am.ltp.beans.Reserva;
import br.com.fiap.am.ltp.bo.ClienteBO;
import br.com.fiap.am.ltp.bo.FuncionarioBO;
import br.com.fiap.am.ltp.bo.HospedagemBO;
import br.com.fiap.am.ltp.bo.ReservaBO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Métodos de acesso ao banco de hospedagens. Operações do CRUD e outras funcionalidades. 
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 * @see Meu Beans
 */
public class HospedagemDAO {
	private String sql = "";
	private PreparedStatement estrutura = null;
	private ResultSet rs = null;

	/**
	 * Faz a gravação de uma Hospedagem no banco de dados. Veja a classe BO para
	 * entender as regras de negócio.
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param Hospedagem
	 *            A Hospedagem que está sendo gravada no banco.
	 * @param conexao
	 *            Credenciais da conexão.
	 * @throws Exception
	 * @see Hospedagem, HospedagemBO
	 */
	public void gravar(Hospedagem hospedagem, Connection conexao) throws Exception {
		try {
			
			List<Quarto> lstQuarto = hospedagem.getReserva().getQuarto();
			
			for (Quarto quarto : lstQuarto) {
				sql = "INSERT INTO T_AM_HBV_HOSPEDAGEM (CD_HOSPEDAGEM, CD_CLIENTE, CD_FUNCIONARIO, DT_ENTRADA, DT_SAIDA, VL_PERC_DESCONTO)"  
						+ " VALUES(?,?,?,?,?,?)";
				estrutura = conexao.prepareStatement(sql);
				
				estrutura.setInt(1, hospedagem.getReserva().getCodigo());
				estrutura.setInt(2, hospedagem.getReserva().getCliente().getCodigo());
				estrutura.setInt(3, hospedagem.getFuncionario().getCodigo());
				estrutura.setDate(4, new Date(hospedagem.getDtCheckIn().getTimeInMillis()));
				estrutura.setDate(5, new Date(hospedagem.getDtCheckOut().getTimeInMillis()));
				estrutura.setInt(6, 0);
				
				estrutura.executeQuery();
				estrutura.close();
			}
			
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	/**
	 * Busca todas as Hospedagem gravadas no Banco de Dados
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param conexao
	 * 		As credenciais da conexão.
	 * @return <code>lstHospedagem</code> Lista com todas as Hospedagem 
	 * @throws Exception
	 * @see	Hospedagem, HospedagemBO
	 * 
	 */	
	public List<Hospedagem> buscarTodos(Connection conexao) throws Exception {
		List<Hospedagem> lstHospedagem= new ArrayList<Hospedagem>();
		
		try{
			
			sql = "SELECT CD_HOSPEDAGEM, CD_CLIENTE, CD_FUNCIONARIO, DT_ENTRADA, DT_SAIDA" +
					" FROM T_AM_HBV_HOSPEDAGEM";
			estrutura = conexao.prepareStatement(sql);
			
			rs = estrutura.executeQuery();
			
			while(rs.next()){
				Hospedagem hospedagem = new Hospedagem();
				Reserva reserva = new Reserva();
				Cliente cliente = new Cliente();
				Funcionario funcionario = new Funcionario();
				
				Calendar checkIn = Calendar.getInstance();
				checkIn.setTime(rs.getDate("DT_ENTRADA"));
				hospedagem.setDtCheckIn(checkIn);
				
				Calendar checkOut = Calendar.getInstance();
				checkOut.setTime(rs.getDate("DT_SAIDA"));
				hospedagem.setDtCheckOut(checkOut);
				
				reserva = ReservaBO.buscarPorCodigo(rs.getInt("CD_HOSPEDAGEM"), conexao);
				hospedagem.setReserva(reserva);
				cliente = ClienteBO.buscarPorCodigo(rs.getInt("CD_CLIENTE"), conexao);
				reserva.setCliente(cliente);
				funcionario = FuncionarioBO.buscarPorCodigo(rs.getInt("CD_FUNCIONARIO"), conexao);
				reserva.setFuncionario(funcionario);
				
				
				lstHospedagem.add(hospedagem);
			}
			
			rs.close();
			estrutura.close();
			
			return lstHospedagem;
			
		}catch (Exception e){
			throw new Excecao(e);
		}
	}
	
	/**
	 * Busca uma Hospedagem específica do Banco de Dados
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param conexao
	 * 		As credenciais da conexão.
	 * @return Uma Hospedagem 
	 * @throws Exception
	 * @see	Hospedagem, HospedagemBO
	 * 
	 */	
	public Hospedagem buscarPorCodigo(int codigo, Connection conexao) throws Exception {
		Hospedagem hosp = new Hospedagem();
		
		try{
			
			sql = "SELECT CD_HOSPEDAGEM, CD_CLIENTE, CD_FUNCIONARIO, DT_ENTRADA, DT_SAIDA" +
					" FROM T_AM_HBV_HOSPEDAGEM WHERE CD_HOSPEDAGEM = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, codigo);
			
			rs = estrutura.executeQuery();
			
			if (rs.next()) {
				Hospedagem hospedagem = new Hospedagem();
				Reserva reserva = new Reserva();
				Cliente cliente = new Cliente();
				Funcionario funcionario = new Funcionario();
				Calendar c = Calendar.getInstance();
				c.setTime(rs.getDate("DT_SAIDA"));
				Calendar checkIn = Calendar.getInstance();
				checkIn.setTime(rs.getDate("DT_ENTRADA"));
				
				reserva = ReservaBO.buscarPorCodigo(rs.getInt("CD_HOSPEDAGEM"), conexao);
				hospedagem.setReserva(reserva);
				cliente = ClienteBO.buscarPorCodigo(rs.getInt("CD_CLIENTE"), conexao);
				reserva.setCliente(cliente);
				funcionario = FuncionarioBO.buscarPorCodigo(rs.getInt("CD_FUNCIONARIO"), conexao);
				reserva.setFuncionario(funcionario);
				reserva.setDtSaida(c);
				hospedagem.setDtCheckIn(checkIn);
				hospedagem.setReserva(reserva);
				
				hospedagem.setReserva(reserva);
			}
			rs.close();
			estrutura.close();
			
			return hosp;
			
		}catch (Exception e){
			throw new Excecao(e);
		}
	}
	
	/**
	 * Edita as informações de uma Hospedagem no banco de dados.
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param Hospedagem
	 *            Os dados da Hospedagem que será editada.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Hospedagem, HospedagemBO
	 */	
	public void editar(Hospedagem hospedagem, Connection conexao) throws Exception{
		try{
			sql = "UPDATE T_AM_HBV_HOSPEDAGEM SET DT_SAIDA = ? WHERE CD_HOSPEDAGEM = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setDate(3, new Date(hospedagem.getDtCheckOut().getTimeInMillis()));
			estrutura.setInt(2, hospedagem.getReserva().getCodigo());

			estrutura.executeQuery();
			estrutura.close();
			
		}catch (Exception e){
			throw new Excecao(e);
		}
	}
	
	
	/**
	 * Excluí uma Hospedagem do banco de dados. 
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param codigo
	 *            O código da Hospedagem que será excluída.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Hospedagem, HospedagemBO
	 */
	public void excluir(int codigo, Connection conexao) throws Exception{
		try{
			
			sql = "DELETE FROM T_AM_HBV_TIPO_HOSPEDAGEM WHERE CD_HOSPEDAGEM = ?";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, codigo);
			
			estrutura.execute();
			estrutura.close();
						
			
		}catch (Exception e){
			throw new Excecao(e);
		}
	}
}