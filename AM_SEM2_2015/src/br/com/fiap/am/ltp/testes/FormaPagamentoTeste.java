package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.FormaPagamento;
import br.com.fiap.am.ltp.bo.FormaPagamentoBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

public class FormaPagamentoTeste {

	public static void main(String[] args) throws Excecao {
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
				FormaPagamento formaPag = new FormaPagamento();
				
				do{
					
					formaPag.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o C�digo da Forma de Pagamento a ser alterada: ")));
					formaPag.setDescricao(JOptionPane.showInputDialog("Informe a Descri��o da Forma de Pagamento: "));
					
					FormaPagamentoBO.editar(formaPag, conexao);
								
					conexao.commit();
					conexao.setAutoCommit(true);
					} while (JOptionPane.showInputDialog("Deseja editar mais? Digite 1").equals("1"));
			}
			
			else if(funcionalidade == 3){
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74820", "160196");
								
				List<FormaPagamento> lstFormaPag = FormaPagamentoBO.buscarTodos(conexao);
				
				for (FormaPagamento formaPag: lstFormaPag) {
					System.out.println("C�digo: " + formaPag.getCodigo() + "\nDescri��o: " + formaPag.getDescricao());
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
								
				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o c�digo da Forma de Pagamento "
						+ "a ser pesquisada"));
				
				FormaPagamento formaPag = FormaPagamentoBO.buscarPorCodigo(codigo, conexao);
				
				System.out.println("C�digo: " + formaPag.getCodigo() + "\nDescri��o: " + formaPag.getDescricao());

				
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
