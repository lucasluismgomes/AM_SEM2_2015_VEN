package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.Bairro;
import br.com.fiap.am.ltp.beans.Cidade;
import br.com.fiap.am.ltp.bo.BairroBO;
import br.com.fiap.am.ltp.bo.CidadeBO;
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
				Cidade cidade = new Cidade();
				Bairro bairro = new Bairro();
				List<Cidade> lstCidade = new CidadeBO().buscarTodos(conexao);
				System.out.println("/tCidades Cadastradas");
				for (Cidade c : lstCidade) 
				{
					System.out.println("Cód. Cidade:"+c.getCodigo()+" Nome:"+c.getNome()+" Estado:"+c.getEstado().getNome()+" Sigla:"+c.getEstado().getSigla());
				}
				bairro.setNome(JOptionPane.showInputDialog("Nome do Bairro"));
				cidade.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Código do estado:")));
				bairro.setCidade(cidade);
				boolean retorno = BairroBO.gravar(bairro, conexao);
				if(!retorno)
				{
					System.out.println("Gravou!");
				}
				else
				{
					System.out.println("Não Gravou!");
				}
				
			} 
			else if (funcionalidade == 2) 
			{
				Bairro bairro = new Bairro();
				Cidade cidade = new Cidade();
				List<Bairro> lstBairro = BairroBO.buscarTodos(conexao);
				System.out.println("/tLista de Bairros Cadastrados");
				for (Bairro b : lstBairro) 
				{
					System.out.println("Cód. Bairro: "+b.getCodigo()+" Nome:"+b.getNome()+" Cód. Cidade:"+b.getCidade().getCodigo());
				}
				List<Cidade> lstCidade = new CidadeBO().buscarTodos(conexao);
				System.out.println("/n/tCidades Cadastradas");
				for (Cidade c : lstCidade) 
				{
					System.out.println("Cód. Cidade:"+c.getCodigo()+" Nome:"+c.getNome()+" Estado:"+c.getEstado().getNome()+" Sigla:"+c.getEstado().getSigla());
				}
				JOptionPane.showMessageDialog(null, "Editar Informações do Bairro");
				bairro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Código do bairro a ser editado")));
				bairro.setNome(JOptionPane.showInputDialog("Novo nome do Bairro"));
				cidade.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o novo codigo da cidade ")));
				bairro.setCidade(cidade);
				boolean retorno = BairroBO.editar(bairro, conexao);
				if(!retorno)
				{
					System.out.println("Editou!");
				}
				else
				{
					System.out.println("Não Editou!");
				}
			} 
			else if (funcionalidade == 3) 
			{
				List<Bairro> lstBairro = BairroBO.buscarTodos(conexao);
				System.out.println("/tLista de Bairros Cadastrados");
				for (Bairro b : lstBairro) 
				{
					System.out.println("Cód. Bairro: "+b.getCodigo()+" Nome:"+b.getNome()+" Cód. Cidade:"+b.getCidade().getCodigo());
				}
			}
			else if (funcionalidade == 4) 
			{
				Bairro bairro = new Bairro();
				List<Bairro> lstBairro = BairroBO.buscarTodos(conexao);
				System.out.println("/tLista de Bairros Cadastrados");
				for (Bairro b : lstBairro) 
				{
					System.out.println("Cód. Bairro: "+b.getCodigo()+" Nome:"+b.getNome()+" Cód. Cidade:"+b.getCidade().getCodigo());
				}
				bairro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Cód. do bairro a ser deletado")));
				boolean retorno = BairroBO.apagar(bairro, conexao);
				if(!retorno)
				{
					System.out.println("Deletou");
				}
				else
				{
					System.out.println("Não deletou");
				}
			}
			else if (funcionalidade == 5) 
			{
				Bairro bairro = new Bairro();
				bairro.setNome(JOptionPane.showInputDialog("Nome do bairro a ser pesquisado"));
				List<Bairro> lstBairro = BairroBO.buscarPorNome(bairro, conexao);
				System.out.println("/tLista de Bairros Cadastrados");
				for (Bairro b : lstBairro) 
				{
					System.out.println("Cód. Bairro: "+b.getCodigo()+" Nome:"+b.getNome()+" Cód. Cidade:"+b.getCidade().getCodigo());
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
			try {
				conexao.close();
			} catch (Exception e) {
				throw new Excecao(e);
		}
	}
  }
}