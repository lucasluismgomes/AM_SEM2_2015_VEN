package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.am.ltp.beans.Quarto;
import br.com.fiap.am.ltp.beans.Reserva;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Métodos de acesso ao banco de Reserva. Operações do CRUD e demais funcionalidades
 * 
 * @author Victor 74820
 * @version 1.0
 * @since 1.0
 * @see Reserva, ReservaBO
 */
public class ReservaDAO {
	private String sql = "";
	private PreparedStatement estrutura = null;
	private ResultSet rs = null;

	/**
	 * Faz a gravação de uma Reserva no banco de dados. Veja a classe BO para
	 * entender as regras de negócio.
	 * 
	 * @author Victor 74820, Lucas 74795
	 * @since 1.0
	 * @param Reserva
	 *            A Reserva que está sendo gravada no banco.
	 * @param conexao
	 *            Credenciais da conexão.
	 * @throws Exception
	 * @see FormaPagamento, FormaPagamentoBO
	 */
	public void gravar(Reserva reserva, Connection conexao) throws Exception{
		try {
			sql = "INSERT INTO T_AM_HBV_RESERVA "
					+ "(CD_CLIENTE, CD_FUNCIONARIO, DT_SOLICITACAO, DE_INICIO_RESERVA,DT_FINAL_RESERVA, QT_ADULTO, QT_CRIANCA, ST_RESERVA, VL_RESERVA)" 
					+ "VALUES (?,?,(SELECT SYSDATE FROM DUAL),?,?,?,?,?,?)";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, reserva.getCliente().getCodigo());
			estrutura.setInt(2, reserva.getFuncionario().getCodigo());
			estrutura.setDate(3, new Date(reserva.getDtEntrada().getTimeInMillis()));
			estrutura.setDate(4, new Date(reserva.getDtSaida().getTimeInMillis()));
			estrutura.setShort(5, reserva.getQtAdulto());
			estrutura.setShort(6, reserva.getQtCrianca());
			estrutura.setInt(7, reserva.getStatus().getCodigo());
			estrutura.setDouble(8, reserva.getVlReserva());
			
			estrutura.execute();
			estrutura.close();
			
		} catch(Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Faz o cálculo do valor total da reserva.
	 * 
	 * @param reserva
	 * @param conexao
	 * @return
	 * @throws Exception
	 */
	public double calcularReserva(Reserva reserva, Connection conexao) throws Exception {
		double valorReserva = 0;
		final long diaEmMilisegundos = 1000 * 60 * 60 * 24;
		boolean naoTemCriancaSemCusto = true;
		try {
			for (Quarto quarto : reserva.getQuarto()) {				
				for (int idadeCrianca : quarto.getIdadeCriancas()) {
					if(idadeCrianca >= 0 && idadeCrianca <= 2 && naoTemCriancaSemCusto){
						naoTemCriancaSemCusto = false;
						quarto.setQtCrianca((short) (quarto.getQtCrianca() - 1));
					}
					
					if(idadeCrianca >= 6){
						quarto.setQtCrianca((short) (quarto.getQtCrianca() - 1));
						quarto.setQtAdulto((short) (quarto.getQtAdulto() + 1));
					}
				}
				
				naoTemCriancaSemCusto = true;
				
				sql = "SELECT SUM(TQ.VL_QUARTO * ? * ?) \"VL_QUARTO\""
						+ "FROM T_AM_HBV_TIPO_QUARTO TQ "
						+ "WHERE TQ.CD_TIPO_QUARTO = ? ";
				estrutura = conexao.prepareStatement(sql);
				estrutura.setInt(1, quarto.getQtAdulto());
				estrutura.setInt(2, (int) ((new Date(reserva.getDtSaida().getTimeInMillis()).getTime() - new Date(reserva.getDtEntrada().getTimeInMillis()).getTime())/diaEmMilisegundos));
				estrutura.setInt(3, quarto.getTipo().getCodigo());
				
				rs = estrutura.executeQuery();
				
				if(rs.next()){
					valorReserva += rs.getDouble("VL_QUARTO");
				}
				
				rs.close();
				estrutura.close();
				
				sql = "SELECT SUM(TQ.VL_QUARTO * ? * ? * 0.25) \"VL_QUARTO\""
						+ "FROM T_AM_HBV_TIPO_QUARTO TQ"
						+ "WHERE TQ.CD_TIPO_QUARTO = ?";
				estrutura = conexao.prepareStatement(sql);
				estrutura.setInt(1, quarto.getQtCrianca());
				estrutura.setInt(2, (int) ((new Date(reserva.getDtSaida().getTimeInMillis()).getTime() - new Date(reserva.getDtEntrada().getTimeInMillis()).getTime())/diaEmMilisegundos));
				estrutura.setInt(3, quarto.getTipo().getCodigo());
				
				System.out.println("ENTRADA: " + reserva.getDtEntrada().getTime());
				System.out.println(new Date(reserva.getDtEntrada().getTimeInMillis()).getTime());
				System.out.println("\nSAIDA: " + reserva.getDtSaida().getTime());
				System.out.println(new Date(reserva.getDtSaida().getTimeInMillis()).getTime());
				System.out.println("\nDIA EM MIL: " + diaEmMilisegundos);
				System.out.println("CONTA FINAL: " + (int) ((new Date(reserva.getDtSaida().getTimeInMillis()).getTime() - new Date(reserva.getDtEntrada().getTimeInMillis()).getTime())/diaEmMilisegundos));
				
				rs = estrutura.executeQuery();
				
				if(rs.next()){
					valorReserva += rs.getDouble("VL_QUARTO");
				}
				
				rs.close();
				estrutura.close();
			}			
			
			return valorReserva;
			
		} catch(Exception e) {
			throw new Excecao(e);
		}
	}
}
