package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.ArrayList;
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
					

					int codigoTipo = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo do Quarto"));
					tipoQuarto = TipoQuartoBO.buscarPorCodigo(codigoTipo, conexao);
					quarto.setTipo(tipoQuarto);
					quarto.setNrAndar(Integer.parseInt(JOptionPane.showInputDialog("Digite o n�mero do Andar")));
					quarto.setNrCapacidade(Short.parseShort(JOptionPane.showInputDialog("Digite o n�mero da Capacidade")));
					quarto.setStatus(Boolean.parseBoolean(JOptionPane.showInputDialog("Digite o status do quarto")));

					QuartoBO.gravar(quarto, conexao);
					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showConfirmDialog(null, "Deseja testar o cadastro novamente?") == 1);
			} else if (funcionalidade == 2) {
				// C�digo de edi��o
			} else if (funcionalidade == 3) {
				
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");

				List<Quarto> lstQuarto = new ArrayList<Quarto>();

				lstQuarto = QuartoBO.buscarTodos(conexao);

				for (Quarto quarto : lstQuarto) {
					System.out.println("N�mero do quarto: " + quarto.getCodigo() + "\nNome do Tipo de Quarto: " + quarto.getTipo().getNomeTipo() 
							+ "\nAndar: "	+ quarto.getNrAndar() + "\nCapacidade: "	+ quarto.getNrCapacidade()
							+ "\nCapacidade: " + (quarto.getStatus() == false ? "Ocupado" : "Dispon�vel"));
				}

			} else if (funcionalidade == 4) {
				// C�digo de deletar
			} else if (funcionalidade == 5) {
				// C�digo de buscar por c�digo
			} else {
				JOptionPane.showMessageDialog(null, "Essa funcionalidade n�o existe! Tente novamente");
			}
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

}
