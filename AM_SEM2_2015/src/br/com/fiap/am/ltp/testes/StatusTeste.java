package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.Status;
import br.com.fiap.am.ltp.bo.StatusBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Classe de teste do CRUD de Status.
 * 
 * @author Lucas 74795
 * @version 3.0
 * @since 1.0
 */
public class StatusTeste {

	public static void main(String[] args) throws Excecao {
		Connection conexao = null;
		try {
			int funcionalidade = Integer.parseInt(JOptionPane.showInputDialog("Qual funcionalidade deseja testar?\n\n"
					+ "1 - Gravar\n" + "2 - Editar\n" + "3 - Buscar Todos\n" + "4 - Apagar\n" + "5 - Buscar por ID\n"));

			if (funcionalidade == 1) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");
				conexao.setAutoCommit(false);
				Status status = new Status();

				do {
					status = new Status();

					status.setNome(JOptionPane.showInputDialog("Digite o nome do status"));
					status.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o c�digo do status")));

					StatusBO.gravar(status, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja cadastrar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 2) {
				// C�digo de edi��o
			} else if (funcionalidade == 3) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");

				List<Status> lstStatus = new ArrayList<Status>();

				lstStatus = StatusBO.buscarTodos(conexao);

				for (Status status : lstStatus) {
					System.out.println("C�digo: " + status.getCodigo() + " Nome: " + status.getNome());
				}
			} else if (funcionalidade == 4) {
				// C�digo de deletar
			} else if (funcionalidade == 5) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");
				
				Status status = new Status();
				
				int id = Integer.parseInt(JOptionPane.showInputDialog("Qual c�digo deseja buscar?"));
				
				status = StatusBO.buscar(id, conexao);
				
				System.out.println("C�digo: " + status.getCodigo() + " Nome: " + status.getNome());
			} else {
				JOptionPane.showMessageDialog(null, "Essa funcionalidade n�o existe! Tente novamente");
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
