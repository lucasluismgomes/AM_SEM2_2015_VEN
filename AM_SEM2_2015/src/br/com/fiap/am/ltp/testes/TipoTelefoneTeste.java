package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.TipoTelefone;
import br.com.fiap.am.ltp.bo.TipoTelefoneBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Teste do CRUD de TipoTelefone.
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 * @see TipoTelefone, TipoTelefoneDAO, TipoTelefoneBO
 */
public class TipoTelefoneTeste {

	public static void main(String[] args) throws Excecao {
		Connection conexao = null;
		try {
			int funcionalidade = Integer.parseInt(JOptionPane.showInputDialog("Qual funcionalidade deseja testar?\n\n"
					+ "1 - Gravar\n" + "2 - Editar\n" + "3 - Buscar Todos\n" + "4 - Apagar\n" + "5 - Buscar por ID\n"));

			if (funcionalidade == 1) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");
				conexao.setAutoCommit(false);
				TipoTelefone tipoTelefone = new TipoTelefone();

				do {
					tipoTelefone = new TipoTelefone();

					tipoTelefone
							.setNome(JOptionPane.showInputDialog("Digite o nome do tipo de telefone que será gravado"));

					TipoTelefoneBO.gravar(tipoTelefone, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja cadastrar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 2) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");
				conexao.setAutoCommit(false);
				TipoTelefone tipoTelefone = new TipoTelefone();

				do {
					tipoTelefone = new TipoTelefone();

					tipoTelefone.setCodigo(Integer.parseInt(
							JOptionPane.showInputDialog("Digite o código do tipo de telefone que será atualizado")));
					tipoTelefone.setNome(JOptionPane.showInputDialog("Digite o novo nome do tipo de telefone"));

					TipoTelefoneBO.editar(tipoTelefone, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja cadastrar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 3) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");

				List<TipoTelefone> lstTipoTelefone = new ArrayList<TipoTelefone>();

				lstTipoTelefone = TipoTelefoneBO.buscarTodos(conexao);

				for (TipoTelefone tipoTelefone : lstTipoTelefone) {
					System.out.println("Código: " + tipoTelefone.getCodigo() + " Nome: " + tipoTelefone.getNome());
				}
			} else if (funcionalidade == 4) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");
				conexao.setAutoCommit(false);
				TipoTelefone tipoTelefone = new TipoTelefone();

				do {
					tipoTelefone = new TipoTelefone();

					tipoTelefone.setCodigo(Integer
							.parseInt(JOptionPane.showInputDialog("Digite o código do tipo de telefone que será excluído?")));

					int codigo = tipoTelefone.getCodigo();

					TipoTelefoneBO.excluir(codigo, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja editar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 5) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");

				TipoTelefone tipoTelefone = new TipoTelefone();

				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Qual código deseja buscar?"));

				tipoTelefone = TipoTelefoneBO.buscarPorCodigo(codigo, conexao);

				System.out.println("Código: " + tipoTelefone.getCodigo() + " Nome: " + tipoTelefone.getNome());
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
