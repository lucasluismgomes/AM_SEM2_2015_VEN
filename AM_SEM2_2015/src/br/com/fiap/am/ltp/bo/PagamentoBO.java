package br.com.fiap.am.ltp.bo;

import java.sql.Connection;

import br.com.fiap.am.ltp.beans.Pagamento;
import br.com.fiap.am.ltp.dao.PagamentoDAO;

/**
 * Descrição da classe/método
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class PagamentoBO {

	/**
	 * Faz a gravação de um Pagamento no banco de dados. 
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param Pagamento
	 *            O Pagamento que está sendo gravado no banco de dados.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Pagamento, PagamentoDAO
	 */
	public static void gravar(Pagamento pagamento, Connection conexao) throws Exception {
		int formaPag = pagamento.getFormaPagamento().getCodigo();
		
		if(formaPag == 1){
			new PagamentoDAO().gravarDinheiro(pagamento, conexao);
		}else if(formaPag == 2){
			new PagamentoDAO().gravarChequeAVista(pagamento, conexao);
		}else if(formaPag == 3){
			new PagamentoDAO().gravarChequeParcelado(pagamento, conexao);
		}else if(formaPag == 4 || formaPag == 5){
			new PagamentoDAO().gravarCartao(pagamento, conexao);
		}
	}
	
	/**
	 * Faz a calculo do total a ser pago pelo Cliente. 
	 * 
	 * @author Victor 74820
	 * @since 1.0
	 * @param Hospedagem
	 *            O código de Hospedagem que será utilizado para calculo do total a ser pago.
	 * @param conexao
	 *            As credenciais da conexão.
	 * @throws Exception
	 * @see Pagamento, PagamentoDAO
	 */
	public static double calcularTotal (Pagamento pagamento, Connection conexao) throws Exception {
		return new PagamentoDAO().calcularTotal(pagamento, conexao);
	}
	
	
}
