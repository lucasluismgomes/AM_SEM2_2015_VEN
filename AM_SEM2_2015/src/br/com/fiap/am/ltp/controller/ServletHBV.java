package br.com.fiap.am.ltp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.am.ltp.beans.Quarto;
import br.com.fiap.am.ltp.beans.Reserva;
import br.com.fiap.am.ltp.beans.TipoQuarto;
import br.com.fiap.am.ltp.bo.ReservaBO;
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

    private void calcularReserva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	List<Quarto> lstQuartos = new ArrayList<Quarto>();
		
		short qtdQuartos = Short.parseShort(request.getParameter("qtdQuartos"));
		short qtdCriancas = 0;
		short qtdAdultos = 0;
		
		for (int i = 1; i <= qtdQuartos; i++) {
			try {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");
			 
				
				List<Integer> idades = new ArrayList<Integer>();
				TipoQuarto tpQuarto = TipoQuartoBO.buscarPorCodigo(Integer.parseInt(request.getParameter("tipoQuarto"+i)),conexao);
				qtdAdultos = Short.parseShort(request.getParameter("qtdAdultosQuarto"+i));
				
				if(qtdAdultos < 4){
					qtdCriancas = Short.parseShort(request.getParameter("qtdCriancasQuarto"+i));
					for(int j = 1; j <= qtdCriancas; j++){
						idades.add(Integer.parseInt(request.getParameter("idadeCrianca"+j+"Quarto"+i)));
					}
					
				}
				Quarto quarto = new Quarto();
				quarto.setQtAdulto(qtdAdultos);
				quarto.setQtCrianca(qtdCriancas);
				quarto.setTipo(tpQuarto);
				quarto.setIdadeCriancas(idades);
				
				lstQuartos.add(quarto);
			}		
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		Reserva reserva = new Reserva();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar dtEntrada = Calendar.getInstance();
		Calendar dtSaida = Calendar.getInstance();

		try {
		
		dtEntrada.setTime(df.parse(request.getParameter("dtEntrada")));
		dtSaida.setTime(df.parse(request.getParameter("dtSaida")));
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		reserva.setDtEntrada(dtEntrada);
		reserva.setDtSaida(dtSaida);
		reserva.setQtCrianca(qtdCriancas);
		reserva.setQtAdulto(qtdAdultos);
		reserva.setQuarto(lstQuartos);
		
		System.out.println("-----------------------------------------------------");
		System.out.println("Data de entrada: " + reserva.getDtEntrada().getTime());
		System.out.println("Data de saida: " + reserva.getDtSaida().getTime());
		System.out.println("Qtd Criancas: " + reserva.getQtCrianca());
		System.out.println("Qtd Adultos: " + reserva.getQtAdulto());
		int count =1;
		for (Quarto quarto : reserva.getQuarto()) {
			System.out.println("Quarto["+count+"]");
			System.out.println("Tipo quarto: " + quarto.getTipo().getNomeTipo());
			System.out.println("Quantidade Adultos quarto: " + quarto.getQtAdulto());
			System.out.println("Quantidade criancas quarto: " + quarto.getQtCrianca());
			System.out.println("Idade das criancas: ");
			for (Integer idade : quarto.getIdadeCriancas()) {
				System.out.print(idade + " ");
			}
			count++;
			System.out.println();
		}
		try {
			reserva.setVlReserva(ReservaBO.calcularReserva(reserva, conexao));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		final long diaEmMilisegundos = 1000 * 60 * 60 * 24;
		
		int dias = (int) ((new Date(reserva.getDtSaida().getTimeInMillis()).getTime()
				- new Date(reserva.getDtEntrada().getTimeInMillis()).getTime())
				/ diaEmMilisegundos);
		
		if(dias < 1) {
			dias = 1;
		}
		
		reserva.setQtDias(dias);
		
		request.setAttribute("reserva", reserva);
		
		try {
			System.out.println("Valor reserva: " + ReservaBO.calcularReserva(reserva, conexao));
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("confirmaReserva.jsp");
		dispatcher.forward(request, response); 	
    	
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
		//doGet(request, response);
		try{
		calcularReserva(request,response);
		}catch(Exception e){
			e.printStackTrace();			
		}
	}

}
