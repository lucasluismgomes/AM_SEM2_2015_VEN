package br.com.fiap.am.ltp.testes;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Teste do CRUD de Bairro
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 * @see Bairro, BairroDAO, BairroBO
 */
public class BairroTeste {

	public static void main(String[] args) throws Exception{
		try {
			int funcionalidade = Integer.parseInt(JOptionPane.showInputDialog("Qual funcionalidade deseja testar?\n\n"
					+ "1 - Cadastrar\n" + "2 - Editar\n" + "3 - Consultar\n" + "4 - Apagar\n"));

			if (funcionalidade == 1) {
				// C�digo de cadastro
			} else if (funcionalidade == 2) {
				// C�digo de edi��o
			} else if (funcionalidade == 3) {
				// C�digo de consulta
			} else if (funcionalidade == 4) {
				// C�digo de deletar
			} else {
				JOptionPane.showMessageDialog(null, "Essa funcionalidade n�o existe! Tente novamente");
			}
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

}
