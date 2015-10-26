package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.Bairro;
import br.com.fiap.am.ltp.beans.Logradouro;
import br.com.fiap.am.ltp.beans.TipoLogradouro;
import br.com.fiap.am.ltp.bo.BairroBO;
import br.com.fiap.am.ltp.bo.LogradouroBO;
import br.com.fiap.am.ltp.bo.TipoLogradouroBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

public class LogradouroTeste {

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
				Logradouro logradouro = new Logradouro();
				TipoLogradouro tipoLogradouro = new TipoLogradouro();
				Bairro bairro = new Bairro();
				logradouro.setCep(Integer.parseInt(JOptionPane.showInputDialog("Informe o CEP")));
				List<TipoLogradouro> lstTipoLogradouro = TipoLogradouroBO.buscarTodos(conexao);
				for (TipoLogradouro tp : lstTipoLogradouro) 
				{
					System.out.println("Cód. Tipo de Logradouro: "+tp.getCodigo()+" Descrição: "+tp.getDescricao());
				}
				tipoLogradouro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Cód. do Tipo de Logradouro")));
				List<Bairro> lstBairro = BairroBO.buscarTodos(conexao);
				for (Bairro b : lstBairro) 
				{
					System.out.println("Cód. Bairro: "+b.getCodigo()+" Nome: "+b.getNome());
				}
				bairro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Cód. do Bairro")));
				logradouro.setTipo(tipoLogradouro);
				logradouro.setBairro(bairro);
				logradouro.setDescricao(JOptionPane.showInputDialog("Nome do Logradouro"));
				boolean retorno = LogradouroBO.gravar(logradouro, conexao);
				if(!retorno)
				{
					System.out.println("Gravou");
				}
				else
				{
					System.out.println("Não gravou");
				}
			} 
			else if (funcionalidade == 2) 
			{
				Logradouro logradouro = new Logradouro();
				TipoLogradouro tipoLogradouro = new TipoLogradouro();
				Bairro bairro = new Bairro();
				List<Logradouro> lstLogradouro = LogradouroBO.buscaTodos(conexao);
				for (Logradouro l : lstLogradouro)
				{
					System.out.println("CEP: "+l.getCep()+" Logradouro: "+l.getDescricao()+" Tipo Logradouro: "+l.getTipo().getDescricao()+" Bairro:" + l.getBairro().getNome());
				}
				logradouro.setCep(Integer.parseInt(JOptionPane.showInputDialog("Informe o CEP a ser alterado")));
				List<TipoLogradouro> lstTipoLogradouro = TipoLogradouroBO.buscarTodos(conexao);
				for (TipoLogradouro tp : lstTipoLogradouro) 
				{
					System.out.println("Cód. Tipo de Logradouro: "+tp.getCodigo()+" Descrição: "+tp.getDescricao());
				}
				tipoLogradouro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Cód. do Tipo de Logradouro")));
				List<Bairro> lstBairro = BairroBO.buscarTodos(conexao);
				for (Bairro b : lstBairro) 
				{
					System.out.println("Cód. Bairro: "+b.getCodigo()+" Nome: "+b.getNome());
				}
				bairro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Cód. do Bairro")));
				logradouro.setTipo(tipoLogradouro);
				logradouro.setBairro(bairro);
				logradouro.setDescricao(JOptionPane.showInputDialog("Nome do Logradouro"));
				boolean retorno = LogradouroBO.editar(logradouro, conexao);
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
				List<Logradouro> lstLogradouro = LogradouroBO.buscaTodos(conexao);
				for (Logradouro l : lstLogradouro)
				{
					System.out.println("CEP: "+l.getCep()+" Logradouro: "+l.getDescricao()+" Tipo Logradouro: "+l.getTipo().getDescricao()+" Bairro:" + l.getBairro().getNome());
				}
				
			}
			else if (funcionalidade == 4) 
			{
				List<Logradouro> lstLogradouro = LogradouroBO.buscaTodos(conexao);
				for (Logradouro l : lstLogradouro)
				{
					System.out.println("CEP: "+l.getCep()+" Logradouro: "+l.getDescricao()+" Tipo Logradouro: "+l.getTipo().getDescricao()+" Bairro:" + l.getBairro().getNome());
				}
				int codigo = Integer.parseInt(JOptionPane.showInputDialog("Cód. do logadouro par exclusão"));
				boolean retorno = LogradouroBO.excluir(codigo, conexao);
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
				String pesquisaLogradouro = JOptionPane.showInputDialog("Pesquisa de logradouro");
				List<Logradouro> lstLogradouro = LogradouroBO.buscaPorNome(pesquisaLogradouro, conexao);
				for (Logradouro l : lstLogradouro)
				{
					System.out.println("CEP: "+l.getCep()+" Logradouro: "+l.getDescricao()+" Tipo Logradouro: "+l.getTipo().getDescricao()+" Bairro:" + l.getBairro().getNome());
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
