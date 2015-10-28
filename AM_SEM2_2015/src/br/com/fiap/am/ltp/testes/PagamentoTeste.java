package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.Calendar;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.FormaPagamento;
import br.com.fiap.am.ltp.beans.Hospedagem;
import br.com.fiap.am.ltp.beans.Pagamento;
import br.com.fiap.am.ltp.beans.Reserva;
import br.com.fiap.am.ltp.bo.PagamentoBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

public class PagamentoTeste {

	/**
	 * Classe para teste dos metodos criados na classes PagamentoDAO e PagamentoBO.
	 * @author Victor RM74820
	 * @throws Excecao
	 * @since 1.0
	 * @see Pagamento,PagamentoBO
	 */
	public static void main(String[] args) throws Exception{
		Connection conexao = null;
		try {
			int funcionalidade = Integer.parseInt(JOptionPane.showInputDialog("Qual funcionalidade deseja testar?\n\n"
					+ "1 - Gravar\n" + "2 - Editar\n" + "3 - Buscar Todos\n" + "4 - Apagar\n" + "5 - Buscar por ID\n"));

			if(funcionalidade ==1){
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74820", "160196");
				conexao.setAutoCommit(false);
				
				Pagamento pagamento = new Pagamento();
				Hospedagem hospedagem = new Hospedagem();
				Reserva reserva = new Reserva();
				FormaPagamento formaPag = new FormaPagamento();
				
				do{
				
				reserva.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o Código da Reserva:")));
				formaPag.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o Código da Forma de Pagamento:"
						+ "\n1 - DINHEIRO" + "\n2 - CHEQUE A VISTA" + "\n3 - CHEQUE PARCELADO" + "\n4 - CARTAO DÉBITO" 
						+ "\n5 - CRÉDITO PARCELADO")));
						if (formaPag.getCodigo() == 2){
							pagamento.setNrBanco(Integer.parseInt(JOptionPane.showInputDialog("Informe o Número do banco")));
						} else if(formaPag.getCodigo() == 3){
							pagamento.setNrBanco(Integer.parseInt(JOptionPane.showInputDialog("Informe o Número do Banco")));
							pagamento.setNrCheque(Integer.parseInt(JOptionPane.showInputDialog("Informe o Número do Cheque")));
							pagamento.setVlParcelas(Double.parseDouble(JOptionPane.showInputDialog("Informe o Valor das Parcelas")));
						} else if(formaPag.getCodigo() == 4){
							pagamento.setQtParcelas(1);
						} else if(formaPag.getCodigo() == 5){
							pagamento.setQtParcelas(Integer.parseInt(JOptionPane.showInputDialog("Informe o Número de Parcelas")));
						}
				
								
				Calendar dtPagamento = Calendar.getInstance();

				String data = JOptionPane
						.showInputDialog("Qual a data do PAGAMENTO? Formato: DD/MM/AAAA");

				while (data.length() < 10) {
					data = JOptionPane.showInputDialog("DATA ERRADA! Use o Formato: DD/MM/AAAA ex: 25/12/1995)");
				}

				int dia = Integer.parseInt(data.substring(0, 2));
				int mes = Integer.parseInt(data.substring(3, 5));
				int ano = Integer.parseInt(data.substring(6, 10));

				dtPagamento.set(ano, (mes - 1), dia);
				
				hospedagem.setReserva(reserva);
				
				pagamento.setHospedagem(hospedagem);
				
				double valor = PagamentoBO.calcularTotal(pagamento, conexao);
				
				System.out.println(valor);
				
				pagamento.setFormaPagamento(formaPag);
				pagamento.setDtPagamento(dtPagamento);
				pagamento.setVlPagamento(valor);
				
				PagamentoBO.gravar(pagamento, conexao);
							
				conexao.commit();
				conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja cadastrar mais? Digite 1").equals("1"));
			}

		}catch (Exception e){
			throw new Excecao(e);
		}finally {
			try {
				conexao.close();
			} catch (Exception e) {
				throw new Excecao(e);
			}
		}	
	}
}
