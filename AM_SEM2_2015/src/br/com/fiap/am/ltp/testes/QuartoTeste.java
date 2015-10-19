package br.com.fiap.am.ltp.testes;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.Quarto;
import br.com.fiap.am.ltp.beans.TipoQuarto;
import br.com.fiap.am.ltp.bo.QuartoBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

public class QuartoTeste {

	public static void main(String[] args) throws Excecao {
		
		try {
			int funcionalidade = Integer.parseInt(JOptionPane.showInputDialog("Qual funcionalidade deseja testar?\n\n"
					+ "1 - Gravar\n" + "2 - Editar\n" + "3 - Buscar Todos\n" + "4 - Apagar\n" + "5 - Buscar por ID\n"));

			if (funcionalidade == 1) {
				Connection conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$74803", "071195");
				Quarto quarto = new Quarto();
				TipoQuarto tipoQuarto = new TipoQuarto();

				do {
					quarto = new Quarto();
					tipoQuarto = new TipoQuarto();

					//Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo do Quarto")));
					
					quarto.setDescricaoQuarto(JOptionPane.showInputDialog("Digite a descrição do Quarto"));
					quarto.setNrAndar(Integer.parseInt(JOptionPane.showInputDialog("Digite o número do Andar")));
					quarto.setStatus(Boolean.parseBoolean(JOptionPane.showInputDialog("Digite o número do Andar")));

					QuartoBO.gravar(quarto, conexao);
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
