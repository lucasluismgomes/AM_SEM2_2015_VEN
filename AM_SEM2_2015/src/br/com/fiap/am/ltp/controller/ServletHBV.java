package br.com.fiap.am.ltp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.am.ltp.beans.Quarto;
import br.com.fiap.am.ltp.beans.Reserva;
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
		
		short qtdQuartos = Short.parseShort(request.getParameter("qtdQuartos"));
		
		
		for (int i = 1; i <= qtdQuartos; i++) {
			try {
				conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");
			 
				short qtdCriancas = 0;
				int[] idades = null;
				TipoQuarto tpQuarto = TipoQuartoBO.buscarPorCodigo(Integer.parseInt(request.getParameter("tipoQuarto"+i)),conexao);
				short qtdAdultos = Short.parseShort(request.getParameter("qtdAdultosQuarto"+i));
				
				if(qtdAdultos < 4){
					qtdCriancas = Short.parseShort(request.getParameter("qtdcriancasQuarto"+i));
					for(int j = 0; j < qtdCriancas; j++){
						idades = new int[qtdCriancas];
						idades[j] = Integer.parseInt(request.getParameter("idadeCrianca"+(j+1)+"Quarto"+i));
					}
					
				}
				Quarto quarto = new Quarto();
				quarto.setQtAdulto(qtdAdultos);
				quarto.setQtCrianca(qtdCriancas);
				quarto.setTipo(tpQuarto);
				//quarto.setIdadeCriancas(idades);
				
				lstQuartos.add(quarto);
			}		
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		Reserva reserva = new Reserva();
		
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		
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
		
		
		
	}

}
