package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.am.ltp.beans.Consumo;
import br.com.fiap.am.ltp.beans.Hospedagem;
import br.com.fiap.am.ltp.beans.Pagamento;
import br.com.fiap.am.ltp.bo.ConsumoBO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Métodos e funcionalidades de Acesso ao banco de Dados referentes a classe Pagamento
 * 
 * @author Lucas 74795, Victor 74820
 * @version 1.0
 * @since 1.0
 * @see Pagamento, PagamentoBO
 */
public class PagamentoDAO {
	
	private String sql = "";
	private PreparedStatement estrutura = null;
	private ResultSet rs = null;

	/**
	 * Faz a gravação de um Pagamento no banco de dados. Veja a classe BO para
	 * entender as regras de negócio.
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param Pagamento
	 *            O Pagamento que está sendo gravado no banco.
	 * @param conexao
	 *            Credenciais da conexão.
	 * @throws Exception
	 * @see Pagamento, PagamentoBO
	 */
	public void gravar(Pagamento pagamento, Connection conexao) throws Exception {
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
	 * Calcula o valor total a ser pago pelo cliente somando o valor da Reserva com os Consumos.
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param Hospedagem
	 *            O código de hospedagem que será utilizado para calcular o valor total do Pagamento .
	 * @param conexao
	 *            Credenciais da conexão.
	 * @throws Exception
	 * @see Pagamento, PagamentoBO
	 */
	public double calcularTotal(Pagamento pagamento, Connection conexao) throws Exception{
		try{
			
			double valorTotal = (pagamento.getHospedagem().getReserva().getVlReserva() + ConsumoBO.valorTotalConsumo(pagamento.getHospedagem().getReserva().getCodigo(), conexao));
			
			return valorTotal;
		}catch (Exception e) {
			throw new Excecao(e);
		}
		
		
	}

}
