package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.Cidade;
import br.com.fiap.am.ltp.beans.Estado;
import br.com.fiap.am.ltp.bo.CidadeBO;
import br.com.fiap.am.ltp.bo.EstadoBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

public class CidadeTeste 
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
		Connection conexao = null;
		try {
			int funcionalidade = Integer.parseInt(JOptionPane
					.showInputDialog("Qual funcionalidade deseja testar?\n\n"
							+ "1 - Gravar\n" + "2 - Editar\n"
							+ "3 - Buscar Todos\n" + "4 - Apagar\n"
							+ "5 - Buscar por ID\n"));

			if (funcionalidade == 1) {
				conexao = ConexaoFactory.controlarInstancia()
						.getConnection("OPS$RM74793", "150395");

				do {
					Cidade cidade = new Cidade();
					Estado estado = new Estado();
					List<Estado> lstEstado = EstadoBO.buscarTodos(conexao);
					for (Estado e : lstEstado) {
						System.out.println("Código: "+e.getCodigo()+" Nome: "+e.getNome()+" Sigla: "+e.getSigla());
					}
					cidade.setNome(JOptionPane
							.showInputDialog("Nome da Cidade"));
					estado.setCodigo(Integer.parseInt(JOptionPane
							.showInputDialog("CODIGO do estado")));
					cidade.setEstado(estado);
					boolean retorno = CidadeBO.gravar(cidade, conexao);
					if (!retorno) {
						System.out.println("Gravou!");
					} else {
						System.out.println("Não Gravo!");
					}

				} while (JOptionPane.showConfirmDialog(null,
						"Deseja testar o cadastro novamente?") == 1);
			} else if (funcionalidade == 2) {
				conexao = ConexaoFactory.controlarInstancia()
						.getConnection("OPS$RM74793", "150395");
				List<Cidade> lstCidade = CidadeBO.buscarTodos(conexao);
				for (Cidade cidade : lstCidade) {
					System.out.println("Codigo: " + cidade.getCodigo()
							+ " Cidade: " + cidade.getNome() + " Estado: "
							+ cidade.getEstado().getNome() + " SIGLA: "
							+ cidade.getEstado().getSigla());
				}
				Cidade cidade = new Cidade();
				Estado estado = new Estado();
				cidade.setCodigo(Integer.parseInt(JOptionPane
						.showInputDialog("Qual é o codigo da cidade?")));
				cidade.setNome(JOptionPane
						.showInputDialog("Qual o novo nome da cidade"));
				estado.setCodigo(Integer.parseInt(JOptionPane
						.showInputDialog("Qual é o novo codigo do estado?")));
				cidade.setEstado(estado);
				boolean resultado = CidadeBO.editar(cidade, conexao);
				if (!resultado) {
					System.out.println("Atualizou!");
				} else {
					System.out.println("Não Atualizou!");
				}

			} else if (funcionalidade == 3) {
				conexao = ConexaoFactory.controlarInstancia()
						.getConnection("OPS$RM74793", "150395");
				List<Cidade> lstCidade = CidadeBO.buscarTodos(conexao);
				for (Cidade cidade : lstCidade) {
					System.out.println("Cidade: " + cidade.getNome()
							+ " Estado: " + cidade.getEstado().getNome()
							+ " SIGLA: " + cidade.getEstado().getSigla());
				}
			} else if (funcionalidade == 4) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74793", "150395");
				List<Cidade> lstCidade = CidadeBO.buscarTodos(conexao);
				
				for (Cidade cidade : lstCidade) {
					System.out.println("Codigo: " + cidade.getCodigo()
							+ " Cidade: " + cidade.getNome() + " Estado: "
							+ cidade.getEstado().getNome() + " SIGLA: "
							+ cidade.getEstado().getSigla());
				}
				int codigoCidade = Integer.parseInt(JOptionPane.showInputDialog("Cód. da cidade a ser deletado"));
				boolean resultado = CidadeBO.excluir(codigoCidade, conexao);
				if (!resultado) {
					System.out.println("Deletou!");
				} else {
					System.out.println("Não Deletou!");
				}
			} else if (funcionalidade == 5) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74793", "150395");
				String pesquisaCidade = JOptionPane.showInputDialog("Pesquisa de cidades");
				List<Cidade> lstCidade = CidadeBO.buscarPorNome(pesquisaCidade, conexao);
				
				for (Cidade cidade : lstCidade) {
					System.out.println("Codigo: " + cidade.getCodigo()
							+ " Cidade: " + cidade.getNome() + " Estado: "
							+ cidade.getEstado().getNome() + " SIGLA: "
							+ cidade.getEstado().getSigla());
				}
				
			} else {
				JOptionPane.showMessageDialog(null,
						"Essa funcionalidade não existe! Tente novamente");
			}
		} catch (Exception e) {
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
