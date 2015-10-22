package br.com.fiap.am.ltp.testes;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.Bairro;
import br.com.fiap.am.ltp.bo.BairroBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Teste do CRUD de Bairro.
 * 
 * @author Lucas 74795
 * @version 2.0
 * @since 1.0
 * @see Bairro, BairroDAO, BairroBO
 */
public class BairroTeste 
{

	public static void main(String[] args) throws Excecao 
	{
		Connection conexao = null;	
		try 
		{
			conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$74793", "150395");
			int funcionalidade = Integer.parseInt(JOptionPane.showInputDialog("Qual funcionalidade deseja testar?\n\n"
					+ "1 - Gravar\n" + "2 - Editar\n" + "3 - Buscar Todos\n" + "4 - Apagar\n" + "5 - Buscar por ID\n"));

			if (funcionalidade == 1) 
			{
				
			} 
			else if (funcionalidade == 2) 
			{
				
			} 
			else if (funcionalidade == 3) 
			{
				
			}
			else if (funcionalidade == 4) 
			{
				
			}
			else if (funcionalidade == 5) 
			{
				
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Essa funcionalidade não existe! Tente novamente");
			}
		} catch (Exception e) 
		{
			throw new Excecao(e);
		}
		finally 
		{
			try {
				conexao.close();
			} catch (Exception e) {
				throw new Excecao(e);
		}
	}
  }
}