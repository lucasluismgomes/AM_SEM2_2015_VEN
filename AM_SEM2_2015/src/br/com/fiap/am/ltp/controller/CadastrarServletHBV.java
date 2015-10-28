package br.com.fiap.am.ltp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.am.ltp.beans.Cliente;
import br.com.fiap.am.ltp.beans.Reserva;
import br.com.fiap.am.ltp.bo.ClienteBO;
import br.com.fiap.am.ltp.bo.ReservaBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;

/**
 * Servlet implementation class CadastrarServletHBV
 */
@WebServlet("/CadastrarServletHBV")
public class CadastrarServletHBV extends HttpServlet {
	Connection conexao = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarServletHBV() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void cadastrarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	response.setContentType("text/html;charset=UTF-8");
		try {
			
	    	conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");
	    	/*
	    	senhaCliente
	    	emailCliente
	    	dtNascimentoCliente
	    	rgCliente
	    	cpfCliente
	    	nmCliente
	    	*/
	    	Cliente cliente = new Cliente();
	    	
	    	cliente.setNome(request.getParameter("nmCliente"));
	    	cliente.setCpf(Long.parseLong(request.getParameter("cpfCliente")));
	    	cliente.setRg(Long.parseLong(request.getParameter("rgCliente")));
	    	
	    	String isChrome = (String)request.getParameter("navegador");
	    	
	    	DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,new Locale("pt", "BR"));
			if(isChrome == "TRUE"){
				df = new SimpleDateFormat("yyyy-MM-dd");
			}
	    	
	    	Calendar dtNascimento = Calendar.getInstance();
			
			try {
				dtNascimento.setTime(df.parse(request.getParameter("dtNascimentoCliente")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
	    	
	    	cliente.setDtNascimento(dtNascimento);
	    	cliente.setEmail(request.getParameter("emailCliente"));
	    	cliente.setSenha(request.getParameter("senhaCliente"));	    
	    	
	    	ClienteBO.gravar(cliente, conexao);
	    	
	    	cliente = ClienteBO.login(cliente.getEmail(), cliente.getSenha(), conexao);
	    	
	    	HttpSession session = request.getSession();
        	session.setAttribute("usuarioAtual", cliente);
            response.sendRedirect("/AM_SEM2_2015/index.jsp");
    	} catch (Exception e) {
    		e.printStackTrace();
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
		// TODO Auto-generated method stub
		try{
			cadastrarCliente(request,response);
		} catch(Exception e){
			e.printStackTrace();			
		}
	}

}
