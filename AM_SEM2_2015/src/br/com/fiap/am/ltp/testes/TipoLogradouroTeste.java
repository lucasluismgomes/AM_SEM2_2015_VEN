package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.TipoLogradouro;
import br.com.fiap.am.ltp.bo.TipoLogradouroBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

public class TipoLogradouroTeste 
{
	public static void main(String[] args) throws Exception 
	{
		Connection conexao = null;	
		try 
		{
			conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74793", "150395");
			int funcionalidade = Integer.parseInt(JOptionPane.showInputDialog("Qual funcionalidade deseja testar?\n\n"
					+ "1 - Gravar\n" + "2 - Editar\n" + "3 - Buscar Todos\n" + "4 - Apagar\n" + "5 - Buscar por ID\n"));

			if (funcionalidade == 1) 
			{
				TipoLogradouro tipoLogradouro = new TipoLogradouro();
				List<TipoLogradouro> lstTipoLogradouro = TipoLogradouroBO.buscarTodos(conexao);
				for (TipoLogradouro tp : lstTipoLogradouro) 
				{
					System.out.println("Cód. Tipo de logradouro: " + tp.getCodigo()+" Descrição: "+tp.getDescricao());
				}
				tipoLogradouro.setDescricao(JOptionPane.showInputDialog("Descrição do tipo de logradouro"));
				boolean retorno = TipoLogradouroBO.gravar(tipoLogradouro, conexao);
				if(!retorno)
				{
					System.out.println("Gravou");
				}
				else
				{
					System.out.println("Não Gravou");
				}
			} 
			else if (funcionalidade == 2) 
			{
				TipoLogradouro tipoLogradouro = new TipoLogradouro();
				List<TipoLogradouro> lstTipoLogradouro = TipoLogradouroBO.buscarTodos(conexao);
				for (TipoLogradouro tp : lstTipoLogradouro) 
				{
					System.out.println("Cód. Tipo de logradouro: " + tp.getCodigo()+" Descrição: "+tp.getDescricao());
				}
				tipoLogradouro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Cód. do Tipo de Logradouro a ser editado")));
				tipoLogradouro.setDescricao(JOptionPane.showInputDialog("Descrição novo tipo de logradouro"));
				boolean retorno = TipoLogradouroBO.editar(tipoLogradouro, conexao);
				if(!retorno)
				{
					System.out.println("Editou");
				}
				else
				{
					System.out.println("Não editou");
				}
			} 
			else if (funcionalidade == 3) 
			{
				List<TipoLogradouro> lstTipoLogradouro = TipoLogradouroBO.buscarTodos(conexao);
				for (TipoLogradouro tp : lstTipoLogradouro) 
				{
					System.out.println("Cód. Tipo de logradouro: " + tp.getCodigo()+" Descrição: "+tp.getDescricao());
				}
			}
			else if (funcionalidade == 4) 
			{
				TipoLogradouro tipoLogradouro = new TipoLogradouro();
				List<TipoLogradouro> lstTipoLogradouro = TipoLogradouroBO.buscarTodos(conexao);
				for (TipoLogradouro tp : lstTipoLogradouro) 
				{
					System.out.println("Cód. Tipo de logradouro: " + tp.getCodigo()+" Descrição: "+tp.getDescricao());
				}
				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Cód. do Tipo de Logradouro a ser deletado"));
				boolean retorno = TipoLogradouroBO.excluir(codigo, conexao);
				if(!retorno)
				{
					System.out.println("Apagou");
				}
				else
				{
					System.out.println("Não apagou");
				}
			}
			else if (funcionalidade == 5) 
			{
				String pesquisaTipoLogradouro = JOptionPane.showInputDialog("Pesquide de Tipo de Logradouro");
				List<TipoLogradouro> lstTipoLogradouro = TipoLogradouroBO.buscarPorNome(pesquisaTipoLogradouro,conexao);
				for (TipoLogradouro tp : lstTipoLogradouro) 
				{
					System.out.println("Cód. Tipo de logradouro: " + tp.getCodigo()+" Descrição: "+tp.getDescricao());
				}
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
			try 
			{
				conexao.close();
			}
			catch (Exception e)
			{
				throw new Excecao(e);
			}
		}
	}
}
