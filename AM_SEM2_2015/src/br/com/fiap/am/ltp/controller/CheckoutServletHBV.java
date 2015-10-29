package br.com.fiap.am.ltp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.am.ltp.beans.Consumo;
import br.com.fiap.am.ltp.beans.FormaPagamento;
import br.com.fiap.am.ltp.beans.Hospedagem;
import br.com.fiap.am.ltp.beans.Pagamento;
import br.com.fiap.am.ltp.bo.ConsumoBO;
import br.com.fiap.am.ltp.bo.FormaPagamentoBO;
import br.com.fiap.am.ltp.bo.HospedagemBO;
import br.com.fiap.am.ltp.bo.PagamentoBO;
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
    
    public void alterarConsumo(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	try {
    		conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");
    		
    		int codigoHosp = Integer.parseInt(request.getParameter("codigoHospedagemConsumo"));
    		
    		List<Consumo> lstConsumo = new ArrayList<Consumo>();
    		lstConsumo = ConsumoBO.buscarPorHospedagem(codigoHosp, conexao);
    		
    		int index = 0;
			List<Consumo> lstConsumoAlterar = new ArrayList<Consumo>();
			for (Consumo consumo : lstConsumo) {
				consumo.setCodigo(Integer.parseInt(request.getParameter("consumo" + index)));
				consumo.setQuantidade(Integer.parseInt(request.getParameter("quantidade" + index)));
				lstConsumoAlterar.add(consumo);
			}
			
			new ConsumoBO().editarEmMassa(lstConsumoAlterar, conexao);
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher("checkOut.jsp");
    		dispatcher.forward(request, response); 	
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    
    public void checkOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");
    	
    	int codigoHosp = Integer.parseInt(request.getParameter("codigoHospedagem"));
    	
    	Hospedagem hospedagem = new Hospedagem();
		hospedagem = HospedagemBO.buscarPorCodigo(codigoHosp, conexao);
		List<Consumo> lstConsumo = new ArrayList<Consumo>();
		lstConsumo = ConsumoBO.buscarPorHospedagem(codigoHosp, conexao);
		double valorTotalConsumo = 0;
		NumberFormat nf = new DecimalFormat("#0.00"); 
		
		for (Consumo consumo : lstConsumo) {
			valorTotalConsumo += consumo.getValorTotal();
		}
		
		request.setAttribute("hospedagem", hospedagem);
		request.setAttribute("lstConsumo", lstConsumo);
		request.setAttribute("valorTotalConsumo", nf.format(valorTotalConsumo));
		
		
		
		HttpSession session = request.getSession();
    	session.setAttribute("dadosHospedagemPagamento", hospedagem);
    	
    	
    	
		RequestDispatcher dispatcher = request.getRequestDispatcher("checkOut.jsp");
		dispatcher.forward(request, response); 	
		
		String i = (String) request.getAttribute("index");
		System.out.println(i);
    }
    
    public void pagamento(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	HttpSession session = request.getSession();
    	try {
    		conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");
    		
    		Hospedagem hospedagem = new Hospedagem();
    		hospedagem = (Hospedagem) session.getAttribute("dadosHospedagemPagamento");
    		
    		Pagamento pagamento = new Pagamento();
    		pagamento.setHospedagem(hospedagem);
    		
    		FormaPagamento formaPagamento = new FormaPagamentoBO().buscarPorCodigo(1, conexao); 
    		
    		pagamento.setFormaPagamento(formaPagamento);
    		
    		Calendar c = Calendar.getInstance();
    		pagamento.setDtPagamento(c);
    		pagamento.setVlPagamento(Double.parseDouble(request.getParameter("totalPagamento")));
    		
    		new PagamentoBO().gravar(pagamento, conexao);
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher("PagamentoEfetuado.jsp");
    		dispatcher.forward(request, response);
    		
    	} catch (Exception e) {
    		e.printStackTrace();		
    	}
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
			try{
				pagamento(request,response);
				//checkOut(request,response);
			}catch(Exception e){
				e.printStackTrace();			
			}
	}

}
