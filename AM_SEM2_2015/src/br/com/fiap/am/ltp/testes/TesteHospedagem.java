package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.text.DateFormat;
import java.util.Calendar;
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

	
	/**
	 * Classe para teste dos metodos criados na classes HospedagemDAO e HospedagemBO.
	 * @author Victor RM74820
	 * @throws Excecao
	 * @since 1.0
	 * @see Hospedagem,HospedagemBO
	 */
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
				
				Calendar checkIn = Calendar.getInstance();

				String data = JOptionPane
						.showInputDialog("Qual a data de ENTRADA do cliente? Formato: DD/MM/AAAA");

				while (data.length() < 10) {
					data = JOptionPane.showInputDialog("DATA ERRADA! Use o Formato: DD/MM/AAAA ex: 25/12/1995)");
				}

				int dia = Integer.parseInt(data.substring(0, 2));
				int mes = Integer.parseInt(data.substring(3, 5));
				int ano = Integer.parseInt(data.substring(6, 10));

				checkIn.set(ano, (mes - 1), dia);
				
				Calendar checkOut = Calendar.getInstance();

				String data2 = JOptionPane
						.showInputDialog("Qual a data de SAÍDA do cliente? Formato: DD/MM/AAAA");

				int dia2 = Integer.parseInt(data2.substring(0, 2));
				int mes2 = Integer.parseInt(data2.substring(3, 5));
				int ano2 = Integer.parseInt(data2.substring(6, 10));

				checkOut.set(ano2, (mes2 - 1), dia2);
				
				
				reserva.setCliente(cliente);
				
				hospedagem.setReserva(reserva);
				hospedagem.setFuncionario(funcionario);
				hospedagem.setDtCheckIn(checkIn);
				hospedagem.setDtCheckOut(checkOut);
								
				HospedagemBO.gravar(hospedagem, conexao);
							
				conexao.commit();
				conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja cadastrar mais? Digite 1").equals("1"));
			}
			
			
			else if(funcionalidade == 2){
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74820", "160196");
				conexao.setAutoCommit(false);
				
				Reserva reserva = new Reserva();
								
				Hospedagem hospedagem = new Hospedagem();
				
				do{
					
					reserva.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o Código da Hospedagem a"
							+ " ser alterada:")));
					
					Calendar checkOut = Calendar.getInstance();

					String data2 = JOptionPane
							.showInputDialog("Qual a data de SAÍDA do cliente? Formato: DD/MM/AAAA");

					while (data2.length() < 10) {
						data2 = JOptionPane.showInputDialog("DATA ERRADA! Use o Formato: DD/MM/AAAA ex: 25/12/1995)");
					}

					int dia2 = Integer.parseInt(data2.substring(0, 2));
					int mes2 = Integer.parseInt(data2.substring(3, 5));
					int ano2 = Integer.parseInt(data2.substring(6, 10));

					checkOut.set(ano2, (mes2 - 1), dia2);
				
					hospedagem.setReserva(reserva);
					hospedagem.setDtCheckOut(checkOut);
					
					HospedagemBO.editar(hospedagem, conexao);
					
					conexao.commit();
					conexao.setAutoCommit(true);
					
					int codigo = reserva.getCodigo();
					
					Hospedagem hospedagem2 = HospedagemBO.buscarPorCodigo(codigo, conexao);
					
					System.out.println("\n" + "Código: " + hospedagem2.getReserva().getCodigo() 
							+ "\nCliente: " + hospedagem2.getReserva().getCliente().getNome()
							+ "\nFuncionário: " + hospedagem2.getFuncionario().getNome()
							+ "\nData Check In: " + dataFormatada(hospedagem2.getDtCheckIn())
							+ "\nData Saída: " + dataFormatada(hospedagem2.getDtCheckOut()));
				} while (JOptionPane.showInputDialog("Deseja editar mais? Digite 1").equals("1"));
			}
			
			else if(funcionalidade == 3){
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74820", "160196");
								
				List<Hospedagem> lstHospedagem = HospedagemBO.buscarTodos(conexao);
								
				System.out.println("Hospedagens \n");
				
				for (Hospedagem hospedagem : lstHospedagem) {
									
					System.out.println("\n" + "Código: " + hospedagem.getReserva().getCodigo() 
							+ "\nCliente: " + hospedagem.getReserva().getCliente().getNome()
							+ "\nFuncionário: " + hospedagem.getFuncionario().getNome()
							+ "\nData Check In: " + dataFormatada(hospedagem.getDtCheckIn())
							+ "\nData Saída: " + dataFormatada(hospedagem.getDtCheckOut()));
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
				
				System.out.println("\n" + "Código: " + hospedagem.getReserva().getCodigo() 
						+ "\nCliente: " + hospedagem.getReserva().getCliente().getNome()
						+ "\nFuncionário: " + hospedagem.getFuncionario().getNome()
						+ "\nData Check In: " + dataFormatada(hospedagem.getDtCheckIn())
						+ "\nData Saída: " + dataFormatada(hospedagem.getDtCheckOut()));
				
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
	
	static String dataFormatada(Calendar c)
	{
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return df.format(c.getTime());
	}
}

