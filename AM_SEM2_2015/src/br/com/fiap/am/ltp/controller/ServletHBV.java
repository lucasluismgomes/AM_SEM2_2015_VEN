package br.com.fiap.am.ltp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.am.ltp.beans.Quarto;
import br.com.fiap.am.ltp.beans.TipoQuarto;
import br.com.fiap.am.ltp.bo.TipoQuartoBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;

/**
 * Servlet implementation class ServletHBV
 * 
 * @author Lucas 74795
 * @version 1.0
 * @since 1.0
 */
@WebServlet("/ServletHBV")
public class ServletHBV extends HttpServlet {
	Connection conexao = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHBV() {
        super();
    }

    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		List<Quarto> lstQuartos = new ArrayList<Quarto>();
		
		int qtdQuartos = Integer.parseInt(request.getParameter("qtdQuartos"));
		
		
		for (int i = 1; i <= qtdQuartos; i++) {
			try {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");
			 
			TipoQuarto tpQuarto = TipoQuartoBO.buscarPorCodigo(Integer.parseInt(request.getParameter("tipoQuarto"+i)),conexao);
			int qtdCriancas = Integer.parseInt(request.getParameter("tipoQuarto"+i));
			
			}		
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			Quarto quarto = new Quarto();
		}
		
		
		
		
		
		
		
		
		
	}

}
