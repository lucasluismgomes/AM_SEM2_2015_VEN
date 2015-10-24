package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.Calendar;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.Consumo;
import br.com.fiap.am.ltp.beans.Funcionario;
import br.com.fiap.am.ltp.beans.TipoConsumo;
import br.com.fiap.am.ltp.bo.ConsumoBO;
import br.com.fiap.am.ltp.bo.FuncionarioBO;
import br.com.fiap.am.ltp.bo.TipoConsumoBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

public class ConsumoTeste {

	public static void main(String[] args) throws Excecao {
		Connection conexao = null;
		try {
			int funcionalidade = Integer.parseInt(JOptionPane.showInputDialog("Qual funcionalidade deseja testar?\n\n"
					+ "1 - Gravar\n" + "2 - Editar\n" + "3 - Buscar Todos\n" + "4 - Apagar\n" + "5 - Buscar por ID\n"));

			if (funcionalidade == 1) {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");
				conexao.setAutoCommit(false);
				Consumo consumo = new Consumo();
				TipoConsumo tc = new TipoConsumo();
				Funcionario f = new Funcionario();

				do {
					consumo = new Consumo();

					Calendar c = Calendar.getInstance();

					consumo.getHospedagem().getReserva().setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o código da hospedagem")));
					int codigoTipo = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo do consumo"));
					tc = TipoConsumoBO.buscarPorCodigo(codigoTipo, conexao);
					consumo.setTipoConsumo(tc);
					int codigoFunc = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do funcionario"));
					f = FuncionarioBO.buscarPorCodigo(codigoFunc, conexao);
					consumo.setFuncionario(f);
					

					String data = JOptionPane
							.showInputDialog("Qual a data da solicitação do consumo? Formato: DD/MM/AAAA");

					while (data.length() < 10) {
						data = JOptionPane.showInputDialog("DATA ERRADA! Use o Formato: DD/MM/AAAA ex: 12/12/2012)");
					}

					int dia = Integer.parseInt(data.substring(0, 2));
					int mes = Integer.parseInt(data.substring(3, 5));
					int ano = Integer.parseInt(data.substring(6, 10));

					c.set(ano, (mes - 1), dia);

					consumo.setDtSolicitacao(c);
					consumo.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Qual a quantidade do consumo?")));
					
					ConsumoBO.gravar(consumo, conexao);

					conexao.commit();
					conexao.setAutoCommit(true);
				} while (JOptionPane.showInputDialog("Deseja cadastrar mais? Digite 1").equals("1"));
			}
		}
			catch (Exception e) {
				try {
					conexao.rollback();
				} catch (Exception ex) {
					throw new Excecao(e);
					
				}
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
