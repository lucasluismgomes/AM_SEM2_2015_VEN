package br.com.fiap.am.ltp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.am.ltp.beans.Consumo;
import br.com.fiap.am.ltp.beans.Hospedagem;
import br.com.fiap.am.ltp.bo.ConsumoBO;
import br.com.fiap.am.ltp.bo.HospedagemBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;

/**
 * Servlet implementation class CheckoutServletHBV
 */
@WebServlet("/CheckoutServletHBV")
public class CheckoutServletHBV extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conexao = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServletHBV() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void checkOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");
    	
    	
    	
    	int codigoHosp = Integer.parseInt(request.getParameter("codigoHospedagem"));
    	
    	Hospedagem hospedagem = new Hospedagem();
		hospedagem = HospedagemBO.buscarPorCodigo(codigoHosp, conexao);
		List<Consumo> lstConsumo = new ArrayList<Consumo>();
		lstConsumo = ConsumoBO.buscarPorHospedagem(codigoHosp, conexao);
		double valorTotalConsumo = 0;
		
		for (Consumo consumo : lstConsumo) {
			valorTotalConsumo += consumo.getValorTotal();
		}
		
		request.setAttribute("hospedagem", hospedagem);
		request.setAttribute("lstConsumo", lstConsumo);
		request.setAttribute("valorTotalConsumo", valorTotalConsumo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("checkOut.jsp");
		dispatcher.forward(request, response); 	
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			checkOut(request,response);
			}catch(Exception e){
				e.printStackTrace();			
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
