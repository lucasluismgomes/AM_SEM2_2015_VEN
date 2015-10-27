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

import br.com.fiap.am.ltp.beans.Consumo;
import br.com.fiap.am.ltp.beans.Hospedagem;
import br.com.fiap.am.ltp.bo.ConsumoBO;
import br.com.fiap.am.ltp.bo.HospedagemBO;

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
    
    public void checkOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
//    	Hospedagem hospedagem = new Hospedagem();
//		hospedagem = HospedagemBO.buscarPorCodigo(, conexao);
//		List<Consumo> lstConsumo = new ArrayList<Consumo>();
//		lstConsumo = ConsumoBO.buscarPorHospedagem(, conexao);
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
		// TODO Auto-generated method stub
	}

}
