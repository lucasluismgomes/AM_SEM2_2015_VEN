package br.com.fiap.am.ltp.conexao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Descri��o da classe/m�todo
 *
 * @author Lucas 74795
 * @version 2.0
 * @since 1.0
 */
public class ConexaoFactory {
	private static ConexaoFactory conexao = null;

	/**
	 * Verifica a existencia de uma conex�o. Caso n�o haja, ser� instanciada uma
	 * nova, se n�o, apenas devolve a j� instanciada.S
	 * 
	 * @author Lucas 74795
	 * @since 2.0
	 * @return conexao
	 */
	public static ConexaoFactory controlarInstancia() {
		if (conexao == null) {
			conexao = new ConexaoFactory();
		}

		return conexao;
	}

	/**
	 * Faz a conex�o com o banco, pegando informa��es de um arquivo no servidor
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @return DriverManager.getConnection(url, usuario, senha);
	 * @throws Exception
	 */
	public Connection getConnection(String usuario, String senha)
			throws Exception {
		FileReader file = new FileReader(System.getProperty("user.dir")
				+ "/conexao/banco.txt");
		BufferedReader dados = new BufferedReader(file);

		String url = dados.readLine();

		if (url.indexOf("oracle") > 0) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} else if (url.indexOf("mysql") > 0) {
			Class.forName("com.mysql.jdbc.Driver");
		}

		dados.close();
		System.out.println(url + " " + usuario + " " + (url.indexOf("oracle") > 0));

		return DriverManager.getConnection(url, usuario, senha);
	}
}