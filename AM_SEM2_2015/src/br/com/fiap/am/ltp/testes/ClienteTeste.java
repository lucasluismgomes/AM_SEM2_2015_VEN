package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
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
			int funcionalidade = Integer.parseInt(JOptionPane
					.showInputDialog("Qual funcionalidade deseja testar?\n\n"
							+ "1 - Gravar\n" + "2 - Editar\n"
							+ "3 - Buscar Todos\n" + "4 - Apagar\n"
							+ "5 - Buscar por ID\n"));

			if (funcionalidade == 1) {
				conexao = ConexaoFactory.controlarInstancia().getConnection(
						"OPS$RM74795", "251295");
				conexao.setAutoCommit(false);
				Cliente cliente = new Cliente();

				do {
					cliente = new Cliente();

					Calendar c = Calendar.getInstance();
					
					String data = JOptionPane.showInputDialog("Qual a data de nascimento do cliente? Formato: DD/MM/AAAA");
					
					while(data.length() < 10){
						data = JOptionPane.showInputDialog("DATA ERRADA! Use o Formato: DD/MM/AAAA ex: 25/12/1995)");
					}
					
					int dia = Integer.parseInt(data.substring(0, 2));
					int mes = Integer.parseInt(data.substring(3, 5));
					int ano = Integer.parseInt(data.substring(6, 10));
					
					c.set(ano, (mes-1), dia);

					cliente.setNome(JOptionPane.showInputDialog("Digite o nome do Cliente"));
					cliente.setCpf(Long.parseLong(JOptionPane.showInputDialog("Digite o CPF do Cliente")));
					cliente.setRg(Long.parseLong(JOptionPane.showInputDialog("Digite o RG do Cliente")));
					cliente.setDtNascimento(c);
					cliente.setEmail(JOptionPane.showInputDialog("Qual o email do cliente?"));
					cliente.setSenha(JOptionPane.showInputDialog("Qual a senha do cliente?"));
					cliente.setQuartoFavorito(Integer.parseInt(JOptionPane.showInputDialog("Qual o quarto favorito do cliente?")));

					ClienteBO.gravar(cliente, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog(
						"Deseja cadastrar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 2) {
				conexao = ConexaoFactory.controlarInstancia().getConnection(
						"OPS$RM74795", "251295");
				conexao.setAutoCommit(false);
				Cliente cliente = new Cliente();

				do {
					cliente = new Cliente();

					cliente.setCodigo(Integer.parseInt(JOptionPane
							.showInputDialog("Digite o código do que será atualizado Cliente")));
					cliente.setNome(JOptionPane
							.showInputDialog("Digite o novo nome do Cliente"));

					ClienteBO.editar(cliente, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog(
						"Deseja cadastrar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 3) {
				conexao = ConexaoFactory.controlarInstancia().getConnection(
						"OPS$RM74795", "251295");

				List<Cliente> lstCliente = new ArrayList<Cliente>();

				lstCliente = ClienteBO.buscarTodos(conexao);

				for (Cliente cliente : lstCliente) {
					System.out.println("Código: " + cliente.getCodigo()
							+ " Nome: " + cliente.getNome());
				}
			} else if (funcionalidade == 4) {
				conexao = ConexaoFactory.controlarInstancia().getConnection(
						"OPS$RM74795", "251295");
				conexao.setAutoCommit(false);
				Cliente Cliente = new Cliente();

				do {
					Cliente = new Cliente();

					Cliente.setCodigo(Integer.parseInt(JOptionPane
							.showInputDialog("Digite o código do Cliente que será excluído?")));

					int id = Cliente.getCodigo();

					ClienteBO.excluir(id, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog(
						"Deseja cadastrar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 5) {
				conexao = ConexaoFactory.controlarInstancia().getConnection(
						"OPS$RM74795", "251295");

				Cliente cliente = new Cliente();

				int id = Integer.parseInt(JOptionPane
						.showInputDialog("Qual código deseja buscar?"));

				cliente = ClienteBO.buscarPorCodigo(id, conexao);

				System.out.println("Código: " + cliente.getCodigo() + " Nome: "
						+ cliente.getNome());
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
