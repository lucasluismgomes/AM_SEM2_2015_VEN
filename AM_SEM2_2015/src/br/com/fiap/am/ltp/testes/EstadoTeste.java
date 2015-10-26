package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.Estado;
import br.com.fiap.am.ltp.bo.EstadoBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

public class EstadoTeste 
{
	/**
	 * Classe para teste dos metodos criados na classes CidadeDAO e CidadeBO.
	 * @author Mateus rm74793
	 * @throws Excecao
	 * @since 1.0
	 * @see Cidade,CidadeBO,Estado
	 */
	public static void main(String[] args) throws Excecao 
	{
		Connection conexao =  null;
		try 
		{
			int funcionalidade = Integer.parseInt(JOptionPane
					.showInputDialog("Qual funcionalidade deseja testar?\n\n"
							+ "1 - Gravar\n" + "2 - Editar\n"
							+ "3 - Buscar Todos\n" + "4 - Apagar\n"
							+ "5 - Buscar por ID\n"));
			conexao = ConexaoFactory.controlarInstancia()
					.getConnection("OPS$RM74793", "150395");
			
			if (funcionalidade == 1) 
			{
				Estado estado = new Estado();
				EstadoBO estadoBO = new EstadoBO();
				estado.setNome(JOptionPane.showInputDialog("Informe o nome do estado"));
				estado.setSigla(JOptionPane.showInputDialog("Informe a sigla do estado"));
				boolean resultado = estadoBO.gravar(estado, conexao);
				if(!resultado)
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
				Estado estado = new Estado();
				EstadoBO estadoBO = new EstadoBO();
				List<Estado> lstEstado = estadoBO.buscarTodos(conexao);
				for (Estado estado2 : lstEstado) 
				{
					System.out.println("Código: "+estado2.getCodigo()+" Nome: "+estado2.getNome()+" Sigla: "+estado2.getSigla());
				}
				estado.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo a ser editado")));
				estado.setNome(JOptionPane.showInputDialog("Informe o nome do estado"));
				estado.setSigla(JOptionPane.showInputDialog("Informe a sigla do estado"));
				boolean resultado = estadoBO.gravar(estado, conexao);
				if(!resultado)
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
				EstadoBO estadoBO = new EstadoBO();
				List<Estado> lstEstado = estadoBO.buscarTodos(conexao);
				for (Estado estado : lstEstado) 
				{
					System.out.println("Código: "+estado.getCodigo()+" Nome: "+estado.getNome()+" Sigla: "+estado.getSigla());
				}
			}
			else if (funcionalidade == 4) 
			{
				EstadoBO estadoBO = new EstadoBO();
				List<Estado> lstEstado = estadoBO.buscarTodos(conexao);
				for (Estado estado : lstEstado) 
				{
					System.out.println("Código: "+estado.getCodigo()+" Nome: "+estado.getNome()+" Sigla: "+estado.getSigla());
				}
				int codigo = Integer.parseInt("Cód. do Estado para exclusão no banco de dados");
				boolean resultado = estadoBO.excluir(codigo, conexao);
				if(!resultado)
				{
					System.out.println("Apagou!");
				}
				else
				{
					System.out.println("Não Apagou");
				}
			}
			else if (funcionalidade == 5) 
			{
				EstadoBO estadoBO = new EstadoBO();
				String pesquisaEstado = JOptionPane.showInputDialog("Pesquisa de Estado");
				List<Estado> lstEstado = estadoBO.buscarPorNome(pesquisaEstado, conexao);
				for (Estado estado2 : lstEstado) 
				{
					System.out.println("Código: "+estado2.getCodigo()+" Nome: "+estado2.getNome()+" Sigla: "+estado2.getSigla());
				}
			} 
			else 
			{
				JOptionPane.showMessageDialog(null,
						"Essa funcionalidade não existe! Tente novamente");
			}
			
		}
		catch (Exception e) 
		{
			throw new Excecao(e);
		} finally {
			try {
				conexao.close();
			} catch (Exception e) {
				throw new Excecao(e);
			}
		}
	}
}

