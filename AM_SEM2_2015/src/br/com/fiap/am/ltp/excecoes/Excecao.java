package br.com.fiap.am.ltp.excecoes;

/**
 * Descrição da classe/método
 * 
 * @since 1.0
 * @version 1.0
 * @author Lucas 74795
 */
public class Excecao extends Exception {
	private static final long serialVersionUID = 1L;

	public Excecao(Exception e) {
		super(e);

		if (e.getClass().toString().equals("class java.lang")) {
			System.out.println("Erro conhecido");
		} else {
			System.out.println("Erro desconhecido");
		}
	}
}