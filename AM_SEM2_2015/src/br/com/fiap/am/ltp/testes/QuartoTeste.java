package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.Cliente;
import br.com.fiap.am.ltp.beans.Quarto;
import br.com.fiap.am.ltp.beans.TipoQuarto;
import br.com.fiap.am.ltp.bo.ClienteBO;
import br.com.fiap.am.ltp.bo.QuartoBO;
import br.com.fiap.am.ltp.bo.TipoQuartoBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

public class QuartoTeste {

	public static void main(String[] args) throws Excecao {
		Connection conexao = null;
		try {
			int funcionalidade = Integer.parseInt(JOptionPane.showInputDialog("Qual funcionalidade deseja testar?\n\n"
					+ "1 - Gravar\n" + "2 - Editar\n" + "3 - Buscar Todos\n" + "4 - Apagar\n" + "5 - Buscar por ID\n"));

			if (funcionalidade == 1) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");
				Quarto quarto = new Quarto();
				conexao.setAutoCommit(false);
				TipoQuarto tipoQuarto = new TipoQuarto();

				do {
					quarto = new Quarto();
					
					quarto.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o número do Quarto")));
					int codigoTipo = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo do Quarto"));
					tipoQuarto = TipoQuartoBO.buscarPorCodigo(codigoTipo, conexao);
					quarto.setTipo(tipoQuarto);
					quarto.setNrAndar(Integer.parseInt(JOptionPane.showInputDialog("Digite o número do Andar")));
					quarto.setNrCapacidade(Short.parseShort(JOptionPane.showInputDialog("Digite o número da Capacidade")));
					quarto.setStatus(Boolean.parseBoolean(JOptionPane.showInputDialog("Digite o status do quarto")));

					QuartoBO.gravar(quarto, conexao);
					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showConfirmDialog(null, "Deseja testar o cadastro novamente?") == 1);
			} else if (funcionalidade == 2) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");
				conexao.setAutoCommit(false);
				Quarto quarto = new Quarto();
				TipoQuarto tipoQuarto = new TipoQuarto();

				do {
					quarto = new Quarto();

					quarto.setCodigo(Integer
							.parseInt(JOptionPane.showInputDialog("Digite o código do Quarto que será atualizado")));
					int codigoTipo = Integer.parseInt(JOptionPane.showInputDialog("Digite novo o tipo do Quarto"));
					tipoQuarto = TipoQuartoBO.buscarPorCodigo(codigoTipo, conexao);
					quarto.setTipo(tipoQuarto);
					quarto.setNrAndar(Integer.parseInt(JOptionPane.showInputDialog("Digite o novo número do Andar")));
					quarto.setNrCapacidade(Short.parseShort(JOptionPane.showInputDialog("Digite o novo número da Capacidade")));
					quarto.setStatus(Boolean.parseBoolean(JOptionPane.showInputDialog("Digite o novo status do quarto")));
					

					QuartoBO.editar(quarto, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
					
					QuartoBO.buscarPorCodigo(quarto.getCodigo(), conexao);

					System.out.println("\n\nNúmero do quarto: " + quarto.getCodigo() + "\nNome do Tipo de Quarto: " + quarto.getTipo().getNomeTipo() 
							+ "\nAndar: "	+ quarto.getNrAndar() + "\nCapacidade: "	+ quarto.getNrCapacidade()
							+ "\nStatus: " + (quarto.getStatus() == false ? "Ocupado" : "Disponível"));
					
				} while (JOptionPane.showInputDialog("Deseja atualizar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 3) {
				
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");

				List<Quarto> lstQuarto = new ArrayList<Quarto>();

				lstQuarto = QuartoBO.buscarTodos(conexao);

				for (Quarto quarto : lstQuarto) {
					System.out.println("\n\nNúmero do quarto: " + quarto.getCodigo() + "\nNome do Tipo de Quarto: " + quarto.getTipo().getNomeTipo() 
							+ "\nAndar: "	+ quarto.getNrAndar() + "\nCapacidade: "	+ quarto.getNrCapacidade()
							+ "\nStatus: " + (quarto.getStatus() == false ? "Ocupado" : "Disponível"));
				}

			} else if (funcionalidade == 4) {

				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");
				conexao.setAutoCommit(false);
				Quarto quarto = new Quarto();

				do {
					quarto = new Quarto();

					quarto.setCodigo(Integer
							.parseInt(JOptionPane.showInputDialog("Digite o código do Quarto que será excluído?")));

					int codigo = quarto.getCodigo();

					QuartoBO.excluir(codigo, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja excluir mais? Digite 1").equals("1"));
				
			} else if (funcionalidade == 5) {

				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");

				Quarto quarto = new Quarto();

				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Qual quarto deseja buscar?"));

				quarto = QuartoBO.buscarPorCodigo(codigo, conexao);

				System.out.println("\n\nNúmero do quarto: " + quarto.getCodigo() + "\nNome do Tipo de Quarto: " + quarto.getTipo().getNomeTipo() 
						+ "\nAndar: "	+ quarto.getNrAndar() + "\nCapacidade: "	+ quarto.getNrCapacidade()
						+ "\nStatus: " + (quarto.getStatus() == false ? "Ocupado" : "Disponível"));
			} else {
				JOptionPane.showMessageDialog(null, "Essa funcionalidade não existe! Tente novamente");
			}
		} catch (Exception e) {
			try {
				conexao.rollback();
			} catch (Exception ex) {
				throw new Excecao(e);
			}
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
