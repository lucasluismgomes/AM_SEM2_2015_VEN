package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.Cliente;
import br.com.fiap.am.ltp.bo.ClienteBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Teste do CRUD de Cliente
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 * @see Cliente, ClienteDAO, ClienteBO
 */
public class ClienteTeste {

	public static void main(String[] args) throws Excecao {
		Connection conexao = null;
		try {
			int funcionalidade = Integer.parseInt(JOptionPane.showInputDialog("Qual funcionalidade deseja testar?\n\n"
					+ "1 - Gravar\n" + "2 - Editar\n" + "3 - Buscar Todos\n" + "4 - Apagar\n" + "5 - Buscar por ID\n"));

			if (funcionalidade == 1) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");
				conexao.setAutoCommit(false);
				Cliente cliente = new Cliente();

				do {
					cliente = new Cliente();

					cliente.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o c�digo do cliente")));
					cliente.setNome(JOptionPane.showInputDialog("Digite o nome do Cliente"));

					ClienteBO.gravar(cliente, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja cadastrar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 2) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");
				conexao.setAutoCommit(false);
				Cliente cliente = new Cliente();

				do {
					cliente = new Cliente();

					cliente.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o c�digo do que ser� atualizado Cliente")));
					cliente.setNome(JOptionPane.showInputDialog("Digite o novo nome do Cliente"));

					ClienteBO.editar(cliente, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja cadastrar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 3) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");

				List<Cliente> lstCliente = new ArrayList<Cliente>();

				lstCliente = ClienteBO.buscarTodos(conexao);

				for (Cliente cliente : lstCliente) {
					System.out.println("C�digo: " + cliente.getCodigo() + " Nome: " + cliente.getNome());
				}
			} else if (funcionalidade == 4) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");
				conexao.setAutoCommit(false);
				Cliente Cliente = new Cliente();

				do {
					Cliente = new Cliente();

					Cliente.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o c�digo do Cliente que ser� exclu�do?")));

					int id = Cliente.getCodigo();
					
					ClienteBO.excluir(id, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja cadastrar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 5) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");
				
				Cliente cliente = new Cliente();
				
				int id = Integer.parseInt(JOptionPane.showInputDialog("Qual c�digo deseja buscar?"));
				
				cliente = ClienteBO.buscarPorCodigo(id, conexao);
				
				System.out.println("C�digo: " + cliente.getCodigo() + " Nome: " + cliente.getNome());
			} else {
				JOptionPane.showMessageDialog(null, "Essa funcionalidade n�o existe! Tente novamente");
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
