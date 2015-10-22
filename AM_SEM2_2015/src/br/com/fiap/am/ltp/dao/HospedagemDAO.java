package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.am.ltp.beans.Cliente;
import br.com.fiap.am.ltp.beans.Hospedagem;
import br.com.fiap.am.ltp.beans.Hospedagem;
import br.com.fiap.am.ltp.beans.Funcionario;
import br.com.fiap.am.ltp.beans.Hospedagem;
import br.com.fiap.am.ltp.beans.Quarto;
import br.com.fiap.am.ltp.beans.Reserva;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
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
				estrutura.setDate(5, new Date(hospedagem.getReserva().getDtSaida().getTimeInMillis()));
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
					" FROM T_AM_HBV_HOSPEDAGEM ORDER BY CD_HOSPEDAGEM";
			estrutura = conexao.prepareStatement(sql);
			
			rs = estrutura.executeQuery();
			
			while(rs.next()){
				Hospedagem hospedagem = new Hospedagem();
				Reserva reserva = new Reserva();
				Cliente cliente = new Cliente();
				Funcionario funcionario = new Funcionario();
				Calendar c = Calendar.getInstance();
				c.setTime(rs.getDate("DT_SAIDA"));
				Calendar checkIn = Calendar.getInstance();
				checkIn.setTime(rs.getDate("DT_ENTRADA"));
				
				reserva.setCodigo(Integer.parseInt("CD_HOSPEDAGEM"));
				cliente.setCodigo(Integer.parseInt("CD_CLIENTE"));
				funcionario.setCodigo(Integer.parseInt("CD_CLIENTE"));
				reserva.setCliente(cliente);
				reserva.setFuncionario(funcionario);
				reserva.setDtSaida(c);
				hospedagem.setDtCheckIn(checkIn);
				
				hospedagem.setReserva(reserva);
				
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
				
				reserva.setCodigo(Integer.parseInt("CD_HOSPEDAGEM"));
				cliente.setCodigo(Integer.parseInt("CD_CLIENTE"));
				funcionario.setCodigo(Integer.parseInt("CD_CLIENTE"));
				reserva.setCliente(cliente);
				reserva.setFuncionario(funcionario);
				reserva.setDtSaida(c);
				hospedagem.setDtCheckIn(checkIn);
				
				hospedagem.setReserva(reserva);
			}
			rs.close();
			estrutura.close();
			
			return hosp;
			
		}catch (Exception e){
			throw new Excecao(e);
		}
	}
	
	
	
	
	}
