package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.Cliente;
import br.com.fiap.am.ltp.beans.Funcionario;
import br.com.fiap.am.ltp.beans.Quarto;
import br.com.fiap.am.ltp.beans.Reserva;
import br.com.fiap.am.ltp.beans.TipoQuarto;
import br.com.fiap.am.ltp.bo.ReservaBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

public class ReservaTeste {

	public static void main(String[] args) throws Excecao {
		Connection conexao = null;
		try {
			int funcionalidade = Integer.parseInt(JOptionPane.showInputDialog("Qual funcionalidade deseja testar?\n\n"
					+ "1 - Calcular Valor da Reserva\n" + "2 - Editar\n" + "3 - Buscar Todos\n" + "4 - Apagar\n" + "5 - Buscar por ID\n"));

			if (funcionalidade == 1) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");
				
				Reserva reserva = new Reserva();
				Cliente cliente = new Cliente();
				Funcionario funcionario = new Funcionario();
				List<Quarto> lstQuarto = new ArrayList<Quarto>();
				double valorReserva = 0;

				Calendar c = Calendar.getInstance();

				String data = JOptionPane
						.showInputDialog("Qual a data de ENTRADA do cliente? Formato: DD/MM/AAAA");

				while (data.length() < 10) {
					data = JOptionPane.showInputDialog("DATA ERRADA! Use o Formato: DD/MM/AAAA ex: 25/12/1995)");
				}

				int dia = Integer.parseInt(data.substring(0, 2));
				int mes = Integer.parseInt(data.substring(3, 5));
				int ano = Integer.parseInt(data.substring(6, 10));

				c.set(ano, (mes - 1), dia);
				
				Calendar c2 = Calendar.getInstance();

				String data2 = JOptionPane
						.showInputDialog("Qual a data de SAÍDA do cliente? Formato: DD/MM/AAAA");

				while (data2.length() < 10) {
					data2 = JOptionPane.showInputDialog("DATA ERRADA! Use o Formato: DD/MM/AAAA ex: 25/12/1995)");
				}

				int dia2 = Integer.parseInt(data2.substring(0, 2));
				int mes2 = Integer.parseInt(data2.substring(3, 5));
				int ano2 = Integer.parseInt(data2.substring(6, 10));

				c2.set(ano2, (mes2 - 1), dia2);
				
				reserva.setCliente(cliente);
				reserva.setFuncionario(funcionario);
				reserva.setDtEntrada(c);
				reserva.setDtSaida(c2);
				
				Quarto quarto1 = new Quarto();
				TipoQuarto tipoQuarto1 = new TipoQuarto();
				
				tipoQuarto1.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Qual o código do tipo do quarto?")));
				
				quarto1.setTipo(tipoQuarto1);
				quarto1.setQtAdulto(Integer.parseInt(JOptionPane.showInputDialog("Quantos adultos?")));
				quarto1.setQtCrianca(Integer.parseInt(JOptionPane.showInputDialog("Quantas crianças?")));
				
				List<Integer> idades = new ArrayList<Integer>();
				int idadeCrianca;
				
				for (int i = 0; i < quarto1.getQtCrianca(); i++) {
					idadeCrianca = Integer.parseInt(JOptionPane.showInputDialog("Qual a idade da " + (i+1) + " criança?"));
					idades.add(idadeCrianca);
				}
				
				quarto1.setIdadeCriancas(idades);
				
				Quarto quarto2 = new Quarto();
				TipoQuarto tipoQuarto2 = new TipoQuarto();
				
				tipoQuarto2.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Qual o código do tipo do quarto?")));
				
				quarto2.setTipo(tipoQuarto2);
				quarto2.setQtAdulto(Integer.parseInt(JOptionPane.showInputDialog("Quantos adultos?")));
				quarto2.setQtCrianca(Integer.parseInt(JOptionPane.showInputDialog("Quantas crianças?")));
				
				List<Integer> idades2 = new ArrayList<Integer>();
				int idadeCrianca2;
				
				for (int i = 0; i < quarto2.getQtCrianca(); i++) {
					idadeCrianca2 = Integer.parseInt(JOptionPane.showInputDialog("Qual a idade da " + (i+1) + " criança?"));
					idades2.add(idadeCrianca2);
				}
				
				quarto2.setIdadeCriancas(idades2);
				
				lstQuarto.add(quarto1);
				lstQuarto.add(quarto2);
				
				reserva.setQuarto(lstQuarto);					
				
				new ReservaBO();
				valorReserva = ReservaBO.calcularReserva(reserva, conexao);
				
				System.out.println("O valor da reserva ficou: R$ " + valorReserva);
				
			} else if (funcionalidade == 2) {
				// Código de edição
			} else if (funcionalidade == 3) {
				// Código de consulta
			} else if (funcionalidade == 4) {
				// Código de deletar
			} else if (funcionalidade == 5) {
				// Código de buscar por código
			} else {
				JOptionPane.showMessageDialog(null, "Essa funcionalidade não existe! Tente novamente");
			}
		} catch (Exception e) {
			throw new Excecao(e);
		} finally {
			try {
				conexao.close();
			} catch (Exception e) {
				throw new Excecao(e);
			}
		}
	}

}
