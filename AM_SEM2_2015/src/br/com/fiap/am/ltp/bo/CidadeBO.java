package br.com.fiap.am.ltp.bo;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.am.ltp.beans.Cidade;
import br.com.fiap.am.ltp.dao.CidadeDAO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Descrição da classe/método
 * 
 * @author Mateus 74793
 * @version 1.0
 * @since 1.0
 */
public class CidadeBO {
	public boolean gravar(Cidade cidade, Connection conexao) throws Excecao {
		try {
			return new CidadeDAO().gravar(cidade, conexao);
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	public boolean editar(Cidade cidade, Connection conexao) throws Excecao {
		try {
			return new CidadeDAO().editar(cidade, conexao);
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	public List<Cidade> buscarTodos(Connection conexao) throws Excecao {
		try {
			return new CidadeDAO().buscarTodos(conexao);
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	public boolean excluir(Cidade cidade, Connection conexao) throws Excecao {
		try {
			return new CidadeDAO().excluir(cidade, conexao);
		} catch (Exception e) {
			throw new Excecao(e);
		}
	}
}
