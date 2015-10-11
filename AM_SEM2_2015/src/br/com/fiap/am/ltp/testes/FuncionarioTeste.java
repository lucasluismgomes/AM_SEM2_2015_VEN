package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.Cargo;
import br.com.fiap.am.ltp.beans.Funcionario;
import br.com.fiap.am.ltp.bo.FuncionarioBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Teste do CRUD de Funcionario.
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 * @see Funcionario, FuncionarioDAO, FuncionarioBO
 */
public class FuncionarioTeste {

	public static void main(String[] args) throws Exception {
		Connection conexao = null;
		try {
			int funcionalidade = Integer.parseInt(JOptionPane.showInputDialog("Qual funcionalidade deseja testar?\n\n"
					+ "1 - Gravar\n" + "2 - Editar\n" + "3 - Buscar Todos\n" + "4 - Apagar\n" + "5 - Buscar por ID\n"));

			if (funcionalidade == 1) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");
				conexao.setAutoCommit(false);
				Funcionario funcionario = new Funcionario();

				do {
					funcionario = new Funcionario();

					Calendar c = Calendar.getInstance();

					funcionario.setNome(JOptionPane.showInputDialog("Digite o nome do Funcionário"));

					String data = JOptionPane
							.showInputDialog("Qual a data de nascimento do Funcionário? Formato: DD/MM/AAAA");

					while (data.length() < 10) {
						data = JOptionPane.showInputDialog("DATA ERRADA! Use o Formato: DD/MM/AAAA ex: 25/12/1995)");
					}

					int dia = Integer.parseInt(data.substring(0, 2));
					int mes = Integer.parseInt(data.substring(3, 5));
					int ano = Integer.parseInt(data.substring(6, 10));

					c.set(ano, (mes - 1), dia);

					funcionario.setDtAdmissao(c);

					Cargo cargo = new Cargo();

					cargo.setCodigo(Integer.parseInt(
							JOptionPane.showInputDialog("Qual o código do cargo do Funcionário? Valor entre 1 e 6")));

					funcionario.setCargo(cargo);

					FuncionarioBO.gravar(funcionario, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja cadastrar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 2) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");
				conexao.setAutoCommit(false);
				Funcionario funcionario = new Funcionario();

				do {
					funcionario = new Funcionario();

					Calendar c = Calendar.getInstance();

					funcionario.setCodigo(Integer
							.parseInt(JOptionPane.showInputDialog("Qual o código do funcionário que será editado?")));
					funcionario.setNome(JOptionPane.showInputDialog("Digite o novo nome do Funcionário"));

					String data = JOptionPane
							.showInputDialog("Qual a nova data de nascimento do Funcionário? Formato: DD/MM/AAAA");

					while (data.length() < 10) {
						data = JOptionPane.showInputDialog("DATA ERRADA! Use o Formato: DD/MM/AAAA ex: 25/12/1995)");
					}

					int dia = Integer.parseInt(data.substring(0, 2));
					int mes = Integer.parseInt(data.substring(3, 5));
					int ano = Integer.parseInt(data.substring(6, 10));

					c.set(ano, (mes - 1), dia);

					funcionario.setDtAdmissao(c);

					Cargo cargo = new Cargo();

					cargo.setCodigo(Integer.parseInt(JOptionPane
							.showInputDialog("Qual o código do novo cargo do Funcionário? Valor entre 1 e 6")));

					funcionario.setCargo(cargo);

					FuncionarioBO.editar(funcionario, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja editar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 3) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");

				List<Funcionario> lstFuncionario = new ArrayList<Funcionario>();

				lstFuncionario = FuncionarioBO.buscarTodos(conexao);

				for (Funcionario funcionario : lstFuncionario) {
					System.out.println("Código: " + funcionario.getCodigo() + "\nNome: " + funcionario.getNome()
							+ "\nCódigo do cargo: " + funcionario.getCargo().getCodigo() + "\nCargo: "
							+ funcionario.getCargo().getNome() + "\nSalário base: "
							+ funcionario.getCargo().getSalarioBase() + "\nData de admissão: "
							+ funcionario.getDtAdmissao().getTime() + "\n");
				}
			} else if (funcionalidade == 4) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");
				conexao.setAutoCommit(false);
				Funcionario funcionario = new Funcionario();

				do {
					funcionario = new Funcionario();

					funcionario.setCodigo(Integer
							.parseInt(JOptionPane.showInputDialog("Digite o código do Cliente que será excluído?")));

					int codigo = funcionario.getCodigo();

					FuncionarioBO.excluir(codigo, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja cadastrar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 5) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");

				Funcionario funcionario = new Funcionario();

				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Qual código deseja buscar?"));

				funcionario = FuncionarioBO.buscarPorCodigo(codigo, conexao);

				System.out.println("Código: " + funcionario.getCodigo() + "\nNome: " + funcionario.getNome()
						+ "\nCódigo do cargo: " + funcionario.getCargo().getCodigo() + "\nCargo: "
						+ funcionario.getCargo().getNome() + "\nSalário base: "
						+ funcionario.getCargo().getSalarioBase() + "\nData de admissão: "
						+ funcionario.getDtAdmissao().getTime() + "\n");
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
