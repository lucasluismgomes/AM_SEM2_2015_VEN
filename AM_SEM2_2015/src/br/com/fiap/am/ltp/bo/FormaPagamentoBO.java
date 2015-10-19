package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.FormaPagamento;
import br.com.fiap.am.ltp.dao.FormaPagamentoDAO;

/**
 * Regras de negócio da classe FormaPagamento.
 * 
 * @author Victor 74820
 * @version 1.0
 * @since 1.0
 * @see FormaPagamento, FormaPagamentoDAO
 */

public class FormaPagamentoBO {
	
		/**
		 * Faz a gravação de uma Forma de Pagamento no banco de dados. 
		 * 
		 * @author Victor 74820
		 * @since 1.0
		 * @param FormaPagamento
		 *            A Forma de Pagamento que está sendo gravada no banco de dados.
		 * @param conexao
		 *            As credenciais da conexão.
		 * @throws Exception
		 * @see FormaPagamento, FormaPagamentoDAO
		 */
		public static void gravar(FormaPagamento FormaPagamento, Connection conexao) throws Exception {
			new FormaPagamentoDAO().gravar(FormaPagamento, conexao);
		}

		/**
		 * Busca todos as Forma de Pagamento cadastradas no banco de dados.
		 * 
		 * @author Victor 74820
		 * @since 1.0
		 * @param conexao
		 *            As credenciais da conexão.
		 * @return lstFormaPagamento
		 * @throws Exception
		 * @see FormaPagamento, FormaPagamentoDAO
		 */
		public static List<FormaPagamento> buscarTodos(Connection conexao) throws Exception {
			return new FormaPagamentoDAO().buscarTodos(conexao);
		}

		/**
		 * Busca uma Forma de Pagamento especifico no banco de dados.
		 * 
		 * @author Victor 74820
		 * @since 1.0
		 * @param codigo
		 *            O codigo da Forma de Pagamento que está sendo buscada.
		 * @param conexao
		 *            As credenciais da conexão.
		 * @return FormaPagamento
		 * @throws Exception
		 * @see FormaPagamento, FormaPagamentoDAO
		 */
		public static FormaPagamento buscarPorCodigo(int codigo, Connection conexao) throws Exception {
			return new FormaPagamentoDAO().buscarPorCodigo(codigo, conexao);
		}

		/**
		 * Edita os dados de uma Forma de Pagamento no banco de dados.
		 * 
		 * @author Victor 74820
		 * @since 1.0
		 * @param FormaPagamento
		 *            A Forma de Pagamento que está sendo editada.
		 * @param conexao
		 *            As credenciais da conexão.
		 * @throws Exception
		 * @see FormaPagamento, FormaPagamentoDAO
		 */
		public static void editar(FormaPagamento FormaPagamento, Connection conexao) throws Exception {
			new FormaPagamentoDAO().editar(FormaPagamento, conexao);
		}

		/**
		 * Excluí uma Forma de Pagamento do banco de dados. 
		 * 
		 * @author Victor 74820
		 * @since 1.0
		 * @param codigo
		 *            O código da Forma de Pagamento que será excluída do banco de dados.
		 * @param conexao
		 * 			As credenciais da conexão.
		 * @throws Exception
		 * @see FormaPagamento, FormaPagamentoDAO
		 */
		public static void excluir(int codigo, Connection conexao) throws Exception {
			new FormaPagamentoDAO().excluir(codigo, conexao);
		}
	}