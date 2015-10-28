package br.com.fiap.am.ltp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.am.ltp.beans.Cliente;
import br.com.fiap.am.ltp.beans.Funcionario;
import br.com.fiap.am.ltp.bo.ClienteBO;
import br.com.fiap.am.ltp.bo.FuncionarioBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * Servlet implementation class LoginServletHBV
 */
@WebServlet(
        description = "Login Servlet", 
        urlPatterns = { "/LoginServletHBV" }, 
        initParams = { 
                @WebInitParam(name = "usuario", value = "lucas@email.com"), // teste de login
                @WebInitParam(name = "senha", value = "senha") // teste de login
        })
public class LoginServletHBV extends HttpServlet {
	Connection conexao = null;
	private static final long serialVersionUID = 1L;
    
	public void init() throws ServletException {
        //we can create DB connection resource here and set it to Servlet context
        if(getServletContext().getInitParameter("urlBD").equals("jdbc:oracle:thin:/:@oracle.fiap.com.br:1521:ORCL") &&
                getServletContext().getInitParameter("usuarioBD").equals("OPS$RM74795") &&
                getServletContext().getInitParameter("senhaUsuarioBD").equals("251295"))
        getServletContext().setAttribute("BD_Sucesso", "True");
        else throw new ServletException("Erro de conexão com o Banco de Dados");
    }
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServletHBV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect("/AM_SEM2_2015/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74795", "251295");
			
			//request.getSession().invalidate(); <-- Logout
			
			//Pega os valores da página
	        String usuario = request.getParameter("usuario");
	        String senha = request.getParameter("senha");
	        String tipoUsuario = request.getParameter("tipoUsuario");
	        
	        // Istancia os usuários
	        Cliente cliente = new Cliente();
	        Funcionario funcionario = new Funcionario();
	        
	        //get servlet config init params
	        if(tipoUsuario.equalsIgnoreCase("cliente")) {
	        	new ClienteBO();
				cliente = ClienteBO.login(usuario, senha, conexao);
	        } else {
	        	new FuncionarioBO();
				funcionario = FuncionarioBO.login(Integer.parseInt(usuario), senha, conexao);
	        }
	        
	        if(cliente.getEmail() != null){
	        	HttpSession session = request.getSession();
	        	session.setAttribute("usuarioAtual", cliente);
	            response.sendRedirect("/AM_SEM2_2015/index.jsp");
	        } else if(funcionario.getCodigo() > 0) {
	        	HttpSession session = request.getSession();
	        	session.setAttribute("usuarioAtual", funcionario);
	            response.sendRedirect("/AM_SEM2_2015/index.jsp");
	        } else {
	            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
	            PrintWriter out= response.getWriter();
	            out.println("<p style='color: red;'>Usuário ou senha incorretos. Tente novamente</p>");
	            rd.include(request, response);
	        }
		} catch (Exception e) {
			System.out.println(e);;
		}
	}

}
