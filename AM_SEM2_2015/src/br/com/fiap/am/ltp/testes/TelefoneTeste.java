package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.Telefone;
import br.com.fiap.am.ltp.beans.TipoTelefone;
import br.com.fiap.am.ltp.bo.TelefoneBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Classe de teste do CRUD de Telefone.
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 * @see Telefone, TelefoneDAO, TelefoneBO
 */
public class TelefoneTeste {

	public static void main(String[] args) throws Excecao {
		Connection conexao = null;
		try {
			int funcionalidade = Integer.parseInt(JOptionPane.showInputDialog("Qual funcionalidade deseja testar?\n\n"
					+ "1 - Gravar\n" + "2 - Editar\n" + "3 - Buscar Todos\n" + "4 - Apagar\n" + "5 - Buscar por ID\n"));

			if (funcionalidade == 1) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");
				conexao.setAutoCommit(false);
				Telefone telefone = new Telefone();

				do {
					telefone = new Telefone();

					telefone.setDdd(Short.parseShort(JOptionPane.showInputDialog("Digite o DDD do telefone")));
					telefone.setNumero(Long.parseLong(JOptionPane.showInputDialog("Digite o número do telefone")));
					
					TipoTelefone tipoTelefone = new TipoTelefone();
					
					tipoTelefone.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o código do tipo de telefone")));
					
					telefone.setTipo(tipoTelefone);

					TelefoneBO.gravar(telefone, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja cadastrar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 2) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");
				conexao.setAutoCommit(false);
				Telefone telefone = new Telefone();

				do {
					telefone = new Telefone();

					telefone.setCodigo(Integer
							.parseInt(JOptionPane.showInputDialog("Digite o código do telefone que será atualizado")));
					telefone.setDdd(Short.parseShort(JOptionPane.showInputDialog("Digite o novo DDD do telefone")));
					telefone.setNumero(Long.parseLong(JOptionPane.showInputDialog("Digite o novo número do telefone")));
					
					TipoTelefone tipoTelefone = new TipoTelefone();
					
					tipoTelefone.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o novo código do tipo de telefone")));
					
					telefone.setTipo(tipoTelefone);

					TelefoneBO.editar(telefone, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja editar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 3) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");

				List<Telefone> lstTelefone = new ArrayList<Telefone>();

				lstTelefone = TelefoneBO.buscarTodos(conexao);

				for (Telefone telefone : lstTelefone) {
					System.out.println("Código: " + telefone.getCodigo() 
							+ " DDD: " + telefone.getDdd() 
							+ " Número: " + telefone.getNumero() 
							+ " Tipo Telefone: " + telefone.getTipo().getNome());
				}
			} else if (funcionalidade == 4) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");
				conexao.setAutoCommit(false);
				Telefone telefone = new Telefone();

				do {
					telefone = new Telefone();

					telefone.setCodigo(Integer
							.parseInt(JOptionPane.showInputDialog("Digite o código do Telefone que será excluído?")));

					int codigo = telefone.getCodigo();

					TelefoneBO.excluir(codigo, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja apagar mais? Digite 1").equals("1"));
			} else if (funcionalidade == 5) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");

				int codigoPessoa = Integer.parseInt(JOptionPane.showInputDialog("Qual o código do cliente que deseja trazer os telefones?"));
				
				List<Telefone> lstTelefone = new ArrayList<Telefone>();
				
				new TelefoneBO();
				
				lstTelefone = TelefoneBO.buscarPorCodigoPessoa(codigoPessoa, conexao);
				
				for (Telefone telefone : lstTelefone) {
					System.out.println("Código: " + telefone.getCodigo() 
							+ " DDD: " + telefone.getDdd() 
							+ " Número: " + telefone.getNumero() 
							+ " Tipo Telefone: " + telefone.getTipo().getNome());
				}
				
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
