package br.com.fiap.am.ltp.testes;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.TipoQuarto;
import br.com.fiap.am.ltp.bo.TipoQuartoBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

public class TipoQuartoTeste {

public static void main(String[] args) throws Excecao {
		
		try {
			int funcionalidade = Integer.parseInt(JOptionPane.showInputDialog("Qual funcionalidade deseja testar?\n\n"
					+ "1 - Gravar\n" + "2 - Editar\n" + "3 - Buscar Todos\n" + "4 - Apagar\n" + "5 - Buscar por ID\n"));

			if (funcionalidade == 1) {
				Connection conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$74803", "071195");
				TipoQuarto tipoQuarto = new TipoQuarto();

				do {
					tipoQuarto = new TipoQuarto();

					tipoQuarto.setNomeTipo(JOptionPane.showInputDialog("Digite o nome do tipo de Quarto"));
					tipoQuarto.setValor(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do tipo de Quarto")));

					TipoQuartoBO.gravar(tipoQuarto, conexao);
				} while (JOptionPane.showConfirmDialog(null, "Deseja testar o cadastro novamente?") == 1);
			} else if (funcionalidade == 2) {
				// Código de edição
			} else if (funcionalidade == 3) {
				// Código de consulta
			} else if (funcionalidade == 4) {
				// Código de deletar
			} else if (funcionalidade == 5) {
				// Código de buscar por código
			} else {
				JOptionPane.showMessageDialog(null, "Essa funcionalidade não existe! Tente novamente");
			}
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
}