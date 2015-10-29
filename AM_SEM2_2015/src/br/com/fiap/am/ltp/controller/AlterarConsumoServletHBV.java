package br.com.fiap.am.ltp.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.am.ltp.conexao.ConexaoFactory;

/**
 * Servlet implementation class AlterarConsumoServletHBV
 */
@WebServlet("/AlterarConsumoServletHBV")
public class AlterarConsumoServletHBV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conexao = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarConsumoServletHBV() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void alterarConsumo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");
    		
    		
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher("checkOut.jsp");
    		dispatcher.forward(request, response); 	
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			alterarConsumo(request,response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
