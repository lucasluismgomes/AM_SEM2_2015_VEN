package br.com.fiap.am.ltp.testes;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.Bairro;
import br.com.fiap.am.ltp.bo.BairroBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Teste do CRUD de Bairro
 * 
 * @author Lucas 74795
 * @version 2.0
 * @since 1.0
 * @see Bairro, BairroDAO, BairroBO
 */
public class BairroTeste {

	public static void main(String[] args) throws Excecao{
		try {
			int funcionalidade = Integer.parseInt(JOptionPane.showInputDialog("Qual funcionalidade deseja testar?\n\n"
					+ "1 - Cadastrar\n" + "2 - Editar\n" + "3 - Consultar\n" + "4 - Apagar\n"));

			if (funcionalidade == 1) {
				Connection conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$74795", "251295");
				Bairro bairro = new Bairro();
				
				do{
					bairro = new Bairro();
					
					bairro.setNome(JOptionPane.showInputDialog("Digite o nome do bairro"));
					
					BairroBO.novoBairro(bairro, conexao);
				} while(JOptionPane.showConfirmDialog(null, "Deseja testar o cadastro novamente?") == 1);
			} else if (funcionalidade == 2) {
				// Código de edição
			} else if (funcionalidade == 3) {
				// Código de consulta
			} else if (funcionalidade == 4) {
				// Código de deletar
			} else {
				JOptionPane.showMessageDialog(null, "Essa funcionalidade não existe! Tente novamente");
			}
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

}
