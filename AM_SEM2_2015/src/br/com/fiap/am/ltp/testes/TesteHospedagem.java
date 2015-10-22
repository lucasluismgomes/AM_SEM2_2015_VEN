package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.FormaPagamento;
import br.com.fiap.am.ltp.beans.Hospedagem;
import br.com.fiap.am.ltp.bo.FormaPagamentoBO;
import br.com.fiap.am.ltp.bo.HospedagemBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

public class TesteHospedagem {

	public static void main(String[] args) throws Exception{
		Connection conexao = null;
		try {
			int funcionalidade = Integer.parseInt(JOptionPane.showInputDialog("Qual funcionalidade deseja testar?\n\n"
					+ "1 - Gravar\n" + "2 - Editar\n" + "3 - Buscar Todos\n" + "4 - Apagar\n" + "5 - Buscar por ID\n"));

			if(funcionalidade ==1){
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74820", "160196");
				conexao.setAutoCommit(false);
				FormaPagamento formaPag = new FormaPagamento();
				
				do{
				
				formaPag.setDescricao(JOptionPane.showInputDialog("Informe a Descri��o da Forma de Pagamento: "));
				
				FormaPagamentoBO.gravar(formaPag, conexao);
							
				conexao.commit();
				conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja cadastrar mais? Digite 1").equals("1"));
			}
			
			
			else if(funcionalidade == 2){
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74820", "160196");
				conexao.setAutoCommit(false);
				Hospedagem hospedagem = new Hospedagem();
				
				do{
					
											
					conexao.commit();
					conexao.setAutoCommit(true);
					} while (JOptionPane.showInputDialog("Deseja editar mais? Digite 1").equals("1"));
			}
			
			else if(funcionalidade == 3){
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74820", "160196");
								
				List<Hospedagem> lstHospedagem = HospedagemBO.buscarTodos(conexao);
				
				for (Hospedagem hospedagem : lstHospedagem) {
					System.out.println("C�digo: " + hospedagem.getReserva().getCodigo() 
							+ "\nCliente: " + hospedagem.getReserva().getCliente()
							+ "\nFuncion�rio: " + hospedagem.getReserva().getFuncionario()
							+ "\nData Check In: " + hospedagem.getDtCheckIn()
							+ "\nData Sa�da: " + hospedagem.getReserva().getDtSaida());
				}
			}
			
			else if(funcionalidade == 4){
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74820", "160196");
				conexao.setAutoCommit(false);
				FormaPagamento formaPag = new FormaPagamento();
				
				formaPag.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o c�digo da Forma de Pagamento "
						+ "a ser exclu�da")));
				
				int codigo = formaPag.getCodigo();
				
				FormaPagamentoBO.excluir(codigo, conexao);
				
				conexao.commit();
				conexao.setAutoCommit(true);
			}

			else if(funcionalidade == 5){
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74820", "160196");
								
				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o c�digo da Hospedagem "
						+ "a ser pesquisada"));
				
				Hospedagem hospedagem = HospedagemBO.buscarPorCodigo(codigo, conexao);
				
				System.out.println("C�digo: " + hospedagem.getReserva().getCodigo() 
						+ "\nCliente: " + hospedagem.getReserva().getCliente()
						+ "\nFuncion�rio: " + hospedagem.getReserva().getFuncionario()
						+ "\nData Check In: " + hospedagem.getDtCheckIn()
						+ "\nData Sa�da: " + hospedagem.getReserva().getDtSaida());

				
			}else {
				JOptionPane.showMessageDialog(null, "Essa funcionalidade n�o existe! Tente novamente");
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

