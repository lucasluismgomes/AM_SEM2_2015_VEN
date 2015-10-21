package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.am.ltp.beans.Reserva;

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
	 * @author Victor 74820
	 * @since 1.0
	 * @param Reserva
	 *            A Reserva que está sendo gravada no banco.
	 * @param conexao
	 *            Credenciais da conexão.
	 * @throws Exception
	 * @see FormaPagamento, FormaPagamentoBO
	 */
	
	public void gravar(Reserva reserva, Connection conexao) throws Exception{
		sql = "INSERT INTO T_AM_HBV_RESERVA (CD_CLIENTE, DT_SOLICITACAO, DE_INICIO_RESERVA"
				+ ",DT_FINAL_RESERVA, QT_ADULTO, QT_CRIANCA, ST_RESERVA)" + "VALUES (?,(SELECT SYSDATE FROM DUAL),?,?,?,?,?)";
		
		estrutura.setInt(1, reserva.getCliente().getCodigo());
		estrutura.setDate(2, new Date(reserva.getDtEntrada().getTimeInMillis()));
		estrutura.setDate(3, new Date(reserva.getDtSaida().getTimeInMillis()));
		estrutura.setShort(4, reserva.getQtAdulto());
		estrutura.setShort(5, reserva.getQtCrianca());
		estrutura.setInt(6, reserva.getStatus().getCodigo());
		
		estrutura = conexao.prepareStatement(sql);
		estrutura.execute();
		
		
		
		
	}
	
	

}
