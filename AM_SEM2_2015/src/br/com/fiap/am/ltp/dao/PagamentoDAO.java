package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import br.com.fiap.am.ltp.beans.Pagamento;
import br.com.fiap.am.ltp.bo.ConsumoBO;
import br.com.fiap.am.ltp.bo.ReservaBO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * M�todos e funcionalidades de Acesso ao banco de Dados referentes a classe Pagamento
 * 
 * @author Lucas 74795, Victor 74820
 * @version 1.0
 * @since 1.0
 * @see Pagamento, PagamentoBO
 */
public class PagamentoDAO {
	
	private String sql = "";
	private PreparedStatement estrutura = null;

	/**
	 * Faz a grava��o de um Pagamento no banco de dados. Veja a classe BO para
	 * entender as regras de neg�cio.
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param Pagamento
	 *            O Pagamento que est� sendo gravado no banco.
	 * @param conexao
	 *            Credenciais da conex�o.
	 * @throws Exception
	 * @see Pagamento, PagamentoBO
	 */
	public void gravarDinheiro(Pagamento pagamento, Connection conexao) throws Exception {
		try {

			sql = "INSERT INTO T_AM_HBV_PAGAMENTO (CD_HOSPEDAGEM, CD_TIPO_FORMAPAG, DT_PAGAMENTO, VL_PAGAMENTO)"
					+ " VALUES(?,?,?,?)";
			estrutura = conexao.prepareStatement(sql);

			estrutura.setInt(1, pagamento.getHospedagem().getReserva().getCodigo());
			estrutura.setInt(2, pagamento.getFormaPagamento().getCodigo());
			estrutura.setDate(3, new Date(pagamento.getDtPagamento().getTimeInMillis()));
			estrutura.setDouble(4, pagamento.getVlPagamento());
			
			estrutura.executeQuery();
			estrutura.close();
			
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
	
	/**
	 * Faz a grava��o de um Pagamento efetuado com cart�o no banco de dados. Veja a classe BO para
	 * entender as regras de neg�cio.
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param Pagamento
	 *            O Pagamento que est� sendo gravado no banco.
	 * @param conexao
	 *            Credenciais da conex�o.
	 * @throws Exception
	 * @see Pagamento, PagamentoBO
	 */
	public void gravarCartao(Pagamento pagamento, Connection conexao) throws Exception {
		try {	
			sql = "INSERT INTO T_AM_HBV_PAGAMENTO (CD_HOSPEDAGEM, CD_TIPO_FORMAPAG, DT_PAGAMENTO, VL_PAGAMENTO)"
					+ " VALUES(?,?,?,?)";
			estrutura = conexao.prepareStatement(sql);

			estrutura.setInt(1, pagamento.getHospedagem().getReserva().getCodigo());
			estrutura.setInt(2, pagamento.getFormaPagamento().getCodigo());
			estrutura.setDate(3, new Date(pagamento.getDtPagamento().getTimeInMillis()));
			estrutura.setDouble(4, pagamento.getVlPagamento());
			
			estrutura.executeQuery();
			estrutura.close();
			
			sql = "INSERT INTO T_AM_HBV_PAG_CARTAO (CD_HOSPEDAGEM, QT_PARCELAS)"
					+ "VALUES (?,?)";
			
			estrutura = conexao.prepareStatement(sql);

			estrutura.setInt(1, pagamento.getHospedagem().getReserva().getCodigo());
			estrutura.setInt(2, pagamento.getQtParcelas());

			estrutura.executeQuery();
			estrutura.close();
		} 
		
		catch (Exception e) {
			throw new Excecao(e);
	}
}
	
	/**
	 * Faz a grava��o de um Pagamento efetuado com Cheque a Vista no banco de dados. Veja a classe BO para
	 * entender as regras de neg�cio.
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param Pagamento
	 *            O Pagamento que est� sendo gravado no banco.
	 * @param conexao
	 *            Credenciais da conex�o.
	 * @throws Exception
	 * @see Pagamento, PagamentoBO
	 */
	public void gravarChequeAVista(Pagamento pagamento, Connection conexao) throws Exception {
		try {	
			sql = "INSERT INTO T_AM_HBV_PAGAMENTO (CD_HOSPEDAGEM, CD_TIPO_FORMAPAG, DT_PAGAMENTO, VL_PAGAMENTO)"
					+ " VALUES(?,?,?,?)";
			estrutura = conexao.prepareStatement(sql);

			estrutura.setInt(1, pagamento.getHospedagem().getReserva().getCodigo());
			estrutura.setInt(2, pagamento.getFormaPagamento().getCodigo());
			estrutura.setDate(3, new Date(pagamento.getDtPagamento().getTimeInMillis()));
			estrutura.setDouble(4, pagamento.getVlPagamento());
			
			estrutura.executeQuery();
			estrutura.close();
			
			sql = "INSERT INTO T_AM_HBV_PAG_CHEQUE (CD_HOSPEDAGEM, NR_BANCO)"
					+ "VALUES (?,?)";
			
			estrutura = conexao.prepareStatement(sql);

			estrutura.setInt(1, pagamento.getHospedagem().getReserva().getCodigo());
			estrutura.setInt(2, pagamento.getNrBanco());

			estrutura.executeQuery();
			estrutura.close();
		} 
		
		catch (Exception e) {
			throw new Excecao(e);
	}
}	
	
	
	/**
	 * Faz a grava��o de um Pagamento efetuado com Cheque Parcelado no banco de dados. Veja a classe BO para
	 * entender as regras de neg�cio.
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param Pagamento
	 *            O Pagamento que est� sendo gravado no banco.
	 * @param conexao
	 *            Credenciais da conex�o.
	 * @throws Exception
	 * @see Pagamento, PagamentoBO
	 */
	public void gravarChequeParcelado(Pagamento pagamento, Connection conexao) throws Exception {
		try {	
			sql = "INSERT INTO T_AM_HBV_PAGAMENTO (CD_HOSPEDAGEM, CD_TIPO_FORMAPAG, DT_PAGAMENTO, VL_PAGAMENTO)"
					+ " VALUES(?,?,?,?)";
			estrutura = conexao.prepareStatement(sql);

			estrutura.setInt(1, pagamento.getHospedagem().getReserva().getCodigo());
			estrutura.setInt(2, pagamento.getFormaPagamento().getCodigo());
			estrutura.setDate(3, new Date(pagamento.getDtPagamento().getTimeInMillis()));
			estrutura.setDouble(4, pagamento.getVlPagamento());
			
			estrutura.executeQuery();
			estrutura.close();
			
			sql = "INSERT INTO T_AM_HBV_REL_CHEQUE (CD_HOSPEDAGEM, NR_CHEQUE, VL_PARCELA)"
					+ "VALUES (?,?,?)";
			
			estrutura = conexao.prepareStatement(sql);

			estrutura.setInt(1, pagamento.getHospedagem().getReserva().getCodigo());
			estrutura.setInt(2, pagamento.getNrCheque());
			estrutura.setDouble(3, pagamento.getVlParcelas());

			estrutura.executeQuery();
			estrutura.close();
		} 
		
		catch (Exception e) {
			throw new Excecao(e);
	}
}	
	
	
	
	/**
	 * Calcula o valor total a ser pago pelo cliente somando o valor da Reserva com os Consumos.
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param Hospedagem
	 *            O c�digo de hospedagem que ser� utilizado para calcular o valor total do Pagamento .
	 * @param conexao
	 *            Credenciais da conex�o.
	 * @throws Exception
	 * @see Pagamento, PagamentoBO
	 */
	public double calcularTotal(Pagamento pagamento, Connection conexao) throws Exception{
		try{
			
			double valorTotal = (ReservaBO.buscarPorCodigo(pagamento.getHospedagem().getReserva().getCodigo(), conexao).getVlReserva() + ConsumoBO.valorTotalConsumo(pagamento.getHospedagem().getReserva().getCodigo(), conexao));
			
			return valorTotal;
		}catch (Exception e) {
			throw new Excecao(e);
		}
	}
}
