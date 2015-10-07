package br.com.fiap.am.ltp.conexao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Descrição da classe/método
 *
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
public class ConexaoFactory {
	
	/**
	 * Faz a conexão com o banco, pegando informações de um arquivo no servidor
	 * 
	 * @return DriverManager.getConnection(url, usuario, senha);
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {
		FileReader file = new FileReader("e:\\temp\\conexao.txt");
		BufferedReader dados = new BufferedReader(file);

		String url = dados.readLine();
		String usuario = dados.readLine();
		String senha = dados.readLine();

		if (url.indexOf("oracle") > 0) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} else if (url.indexOf("mysql") > 0) {
			Class.forName("com.mysql.jdbc.Driver");
		}

		dados.close();

		return DriverManager.getConnection(url, usuario, senha);
	}
}