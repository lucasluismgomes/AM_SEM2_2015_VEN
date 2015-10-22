package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.TipoQuarto;
import br.com.fiap.am.ltp.bo.TipoQuartoBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

public class TipoQuartoTeste {

public static void main(String[] args) throws Excecao {
		Connection conexao = null;
		try {
			int funcionalidade = Integer.parseInt(JOptionPane.showInputDialog("Qual funcionalidade deseja testar?\n\n"
					+ "1 - Gravar\n" + "2 - Editar\n" + "3 - Buscar Todos\n" + "4 - Apagar\n" + "5 - Buscar por ID\n"));

			if (funcionalidade == 1) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");
				conexao.setAutoCommit(false);
				TipoQuarto tipoQuarto = new TipoQuarto();

				do {
					tipoQuarto = new TipoQuarto();

					tipoQuarto.setNomeTipo(JOptionPane.showInputDialog("Digite o nome do tipo de Quarto"));
					tipoQuarto.setDescricao(JOptionPane.showInputDialog("Digite as observações/descrições do tipo de Quarto"));
					tipoQuarto.setValor(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do tipo de Quarto")));

					TipoQuartoBO.gravar(tipoQuarto, conexao);
					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showConfirmDialog(null, "Deseja testar o cadastro novamente?") == 1);
			} else if (funcionalidade == 2) {
				
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");
				conexao.setAutoCommit(false);
				TipoQuarto tipoQuarto = new TipoQuarto();

				do {
					tipoQuarto = new TipoQuarto();

					tipoQuarto.setCodigo(Integer
							.parseInt(JOptionPane.showInputDialog("Digite o código do Tipo de Quarto que será atualizado")));
					tipoQuarto.setNomeTipo(JOptionPane.showInputDialog("Digite o novo nome do tipo de quarto"));
					tipoQuarto.setDescricao(JOptionPane.showInputDialog("Digite a nova descrição do tipo de quarto"));
					tipoQuarto.setValor(Double.parseDouble(JOptionPane.showInputDialog("Digite o novo valor do tipo de quarto")));
					

					TipoQuartoBO.editar(tipoQuarto, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
					
					TipoQuartoBO.buscarPorCodigo(tipoQuarto.getCodigo(), conexao);

					System.out.println("\n\nCódigo: " + tipoQuarto.getCodigo() + "\nNomeTipo: " + tipoQuarto.getNomeTipo() 
							+ "\nValor: "	+ tipoQuarto.getValor());
					
				} while (JOptionPane.showInputDialog("Deseja atualizar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 3) {
				
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");

				List<TipoQuarto> lstTipoQuarto = new ArrayList<TipoQuarto>();

				lstTipoQuarto = TipoQuartoBO.buscarTodos(conexao);

				for (TipoQuarto tipoQuarto : lstTipoQuarto) {
					System.out.println("\n\nCódigo: " + tipoQuarto.getCodigo() + "\nNomeTipo: " + tipoQuarto.getNomeTipo() 
							+ "\nValor: "	+ tipoQuarto.getValor());
				}
				
			} else if (funcionalidade == 4) {
				
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");
				conexao.setAutoCommit(false);
				TipoQuarto tipoQuarto = new TipoQuarto();

				do {
					tipoQuarto = new TipoQuarto();

					tipoQuarto.setCodigo(Integer
							.parseInt(JOptionPane.showInputDialog("Digite o código do Tipo de Quarto que será excluído?")));

					int codigo = tipoQuarto.getCodigo();

					TipoQuartoBO.excluir(codigo, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja excluir mais? Digite 1").equals("1"));
			} else if (funcionalidade == 5) {
				
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");

				TipoQuarto tipoQuarto = new TipoQuarto();

				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Qual código deseja buscar?"));

				tipoQuarto = TipoQuartoBO.buscarPorCodigo(codigo, conexao);

				System.out.println("Código: " + tipoQuarto.getCodigo() + "\nNomeTipo: " + tipoQuarto.getNomeTipo() 
						+ "\nValor: "	+ tipoQuarto.getValor());
				
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