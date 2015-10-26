package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.Cliente;
import br.com.fiap.am.ltp.beans.Funcionario;
import br.com.fiap.am.ltp.beans.Hospedagem;
import br.com.fiap.am.ltp.beans.Reserva;
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
				Reserva reserva = new Reserva();
				Cliente cliente = new Cliente();
				Funcionario funcionario = new Funcionario();
				
				Hospedagem hospedagem = new Hospedagem();
				
				do{
				
				reserva.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o Código da Reserva:")));
				cliente.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o Código do Cliente:")));
				funcionario.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o Código do Funcionário:")));
				
				
				reserva.setCliente(cliente);
				
				hospedagem.setReserva(reserva);
				hospedagem.setFuncionario(funcionario);
				
				
				HospedagemBO.gravar(hospedagem, conexao);
							
				conexao.commit();
				conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja cadastrar mais? Digite 1").equals("1"));
			}
			
			
			else if(funcionalidade == 2){
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74820", "160196");
				conexao.setAutoCommit(false);
				
				do{
					
											
					conexao.commit();
					conexao.setAutoCommit(true);
					} while (JOptionPane.showInputDialog("Deseja editar mais? Digite 1").equals("1"));
			}
			
			else if(funcionalidade == 3){
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74820", "160196");
								
				List<Hospedagem> lstHospedagem = HospedagemBO.buscarTodos(conexao);
				
				System.out.println("Hospedagens \n");
				
				for (Hospedagem hospedagem : lstHospedagem) {
					System.out.println("Código: " + hospedagem.getReserva().getCodigo() 
							+ "\nCliente: " + hospedagem.getReserva().getCliente()
							+ "\nFuncionário: " + hospedagem.getReserva().getFuncionario()
							+ "\nData Check In: " + hospedagem.getDtCheckIn()
							+ "\nData Saída: " + hospedagem.getReserva().getDtSaida());
				}
			}
			
			else if(funcionalidade == 4){
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74820", "160196");
				conexao.setAutoCommit(false);
				Reserva reserva = new Reserva();
				
				reserva.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o código da Hospedagem "
						+ "a ser excluída")));
				
				int codigo = reserva.getCodigo();
				
				HospedagemBO.excluir(codigo, conexao);
				
				conexao.commit();
				conexao.setAutoCommit(true);
			}

			else if(funcionalidade == 5){
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74820", "160196");
								
				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código da Hospedagem "
						+ "a ser pesquisada"));
				
				Hospedagem hospedagem = HospedagemBO.buscarPorCodigo(codigo, conexao);
				
				System.out.println("Código: " + hospedagem.getReserva().getCodigo() 
						+ "\nCliente: " + hospedagem.getReserva().getCliente()
						+ "\nFuncionário: " + hospedagem.getReserva().getFuncionario()
						+ "\nData Check In: " + hospedagem.getDtCheckIn()
						+ "\nData Saída: " + hospedagem.getReserva().getDtSaida());

				
			}else {
				JOptionPane.showMessageDialog(null, "Essa funcionalidade não existe! Tente novamente");
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

