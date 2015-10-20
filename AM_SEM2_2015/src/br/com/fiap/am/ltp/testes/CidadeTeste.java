package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.Cidade;
import br.com.fiap.am.ltp.beans.Estado;
import br.com.fiap.am.ltp.bo.CidadeBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

public class CidadeTeste 
{
	public static void main(String[] args) throws Excecao 
	{
		try {
			int funcionalidade = Integer.parseInt(JOptionPane.showInputDialog("Qual funcionalidade deseja testar?\n\n"
					+ "1 - Gravar\n" + "2 - Editar\n" + "3 - Buscar Todos\n" + "4 - Apagar\n" + "5 - Buscar por ID\n"));

			if (funcionalidade == 1) 
			{
				Connection conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74793", "150395");

				do 
				{
					Cidade cidade = new Cidade();
					CidadeBO cidadeBO = new CidadeBO();
					Estado estado = new Estado();
					cidade.setNome(JOptionPane.showInputDialog("Nome da Cidade"));
					estado.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("CODIGO do estado")));
					cidade.setEstado(estado);
					int retorno = cidadeBO.gravar(cidade, conexao);
					if(retorno==1)
					{
						System.out.println("Gravou!");
					}
					else
					{
						System.out.println("Não Gravo!");
					}
					
				} 
				while (JOptionPane.showConfirmDialog(null, "Deseja testar o cadastro novamente?") == 1);
			}
			else if (funcionalidade == 2) 
			{
				Connection conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74793", "150395");
				CidadeBO cidadeBO = new CidadeBO();
				List<Cidade> lstCidade = cidadeBO.todasCidades(conexao);
				for (Cidade cidade : lstCidade) 
				{
					System.out.println("Codigo: "+cidade.getCodigo()+" Cidade: "+ cidade.getNome()+" Estado: "+cidade.getEstado().getNome()+" SIGLA: "+cidade.getEstado().getSigla());
				}
				Cidade cidade = new Cidade();
				Estado estado = new Estado();
				cidade.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Qual é o codigo da cidade?")));
				cidade.setNome(JOptionPane.showInputDialog("Qual o novo nome da cidade"));
				estado.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Qual é o novo codigo do estado?")));
				cidade.setEstado(estado);
				int resultado = cidadeBO.atualizar(cidade, conexao);
				if(resultado==1)
				{
					System.out.println("Atualizou!");
				}
				else
				{
					System.out.println("Não Atualizou!");
				}
				 
			}
			else if (funcionalidade == 3) 
			{
				CidadeBO cidadeBO = new CidadeBO();
				Connection conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74793", "150395");
				List<Cidade> lstCidade = cidadeBO.todasCidades(conexao);
				for (Cidade cidade : lstCidade) 
				{
					System.out.println("Cidade: "+ cidade.getNome()+" Estado: "+cidade.getEstado().getNome()+" SIGLA: "+cidade.getEstado().getSigla());
				}
			}
			else if (funcionalidade == 4) 
			{
				Connection conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74793", "150395");
				CidadeBO cidadeBO = new CidadeBO();
				List<Cidade> lstCidade = cidadeBO.todasCidades(conexao);
				for (Cidade cidade : lstCidade) 
				{
					System.out.println("Codigo: "+cidade.getCodigo()+" Cidade: "+ cidade.getNome()+" Estado: "+cidade.getEstado().getNome()+" SIGLA: "+cidade.getEstado().getSigla());
				}
				Cidade cidade = new Cidade();
				cidade.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Qual é o codigo da cidade?")));
				int resultado = cidadeBO.deletar(cidade, conexao);
				if(resultado==1)
				{
					System.out.println("Deletou!");
				}
				else
				{
					System.out.println("Não Deletou!");
				}
			}
			else if (funcionalidade == 5) 
			{
				// Código de buscar por código
			} 
			else 
			{
				JOptionPane.showMessageDialog(null, "Essa funcionalidade não existe! Tente novamente");
			}
		} 
		catch (Exception e) 
		{
			throw new Excecao(e);
		}
	}
}
