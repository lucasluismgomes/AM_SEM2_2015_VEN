package br.com.fiap.am.ltp.testes;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.Status;
import br.com.fiap.am.ltp.bo.StatusBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

public class StatusTeste {

	public static void main(String[] args) throws Excecao {
		Connection conexao = null;
		try {
			int funcionalidade = Integer.parseInt(JOptionPane
					.showInputDialog("Qual funcionalidade deseja testar?\n\n"
							+ "1 - Cadastrar\n" + "2 - Editar\n"
							+ "3 - Consultar\n" + "4 - Apagar\n"));

			if (funcionalidade == 1) {
				conexao = ConexaoFactory.controlarInstancia().getConnection(
						"OPS$RM74795", "251295");
				conexao.setAutoCommit(false);
				Status status = new Status();

				do {
					status = new Status();

					status.setNomeStatus(JOptionPane
							.showInputDialog("Digite o nome do status"));
					status.setCodigo(Integer.parseInt(JOptionPane
							.showInputDialog("Digite o código do status")));

					StatusBO.novoStatus(status, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja cadastrar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 2) {
				// Código de edição
			} else if (funcionalidade == 3) {
				// Código de consulta
			} else if (funcionalidade == 4) {
				// Código de deletar
			} else {
				JOptionPane.showMessageDialog(null,
						"Essa funcionalidade não existe! Tente novamente");
			}
		} catch (Exception e) {
			try {
				conexao.rollback();
			} catch (Exception ex) {
				throw new Excecao(e);
			}
			System.out.println(e);
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
