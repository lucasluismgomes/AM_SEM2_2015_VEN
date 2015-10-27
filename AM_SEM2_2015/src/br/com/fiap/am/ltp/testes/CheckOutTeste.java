package br.com.fiap.am.ltp.testes;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.am.ltp.beans.Consumo;
import br.com.fiap.am.ltp.beans.Hospedagem;
import br.com.fiap.am.ltp.bo.ConsumoBO;
import br.com.fiap.am.ltp.bo.HospedagemBO;
import br.com.fiap.am.ltp.conexao.ConexaoFactory;

public class CheckOutTeste {

	public static void main(String[] args) throws Exception {
		Connection conexao = null;
		conexao = ConexaoFactory.controlarInstancia().getConnection("OPS$RM74803", "071195");
		int codHosp = Integer.parseInt(JOptionPane.showInputDialog("Qual o c�digo de hospedagem voc� deseja buscar para realizar o CheckOut?"));
	
		Hospedagem hospedagem = new Hospedagem();
		hospedagem = HospedagemBO.buscarPorCodigo(codHosp, conexao);
		List<Consumo> lstConsumo = new ArrayList<Consumo>();
		lstConsumo = ConsumoBO.buscarPorHospedagem(codHosp, conexao);
		
		JOptionPane.showMessageDialog(null, "\nC�digo Hospedagem: " + hospedagem.getReserva().getCodigo()
											+"\nCliente: " + hospedagem.getReserva().getCliente().getNome()
											+"\nData de CheckIn: " + hospedagem.getDtEntradaFormatted());
		for (Consumo consumo : lstConsumo) {
			System.out.println("\n\nC�digo do Consumo: " + consumo.getCodigo() 
					+ "\nCd. Hosp.: " + consumo.getHospedagem().getReserva().getCodigo() 
					+ "\nTipo de Consumo: "	+ consumo.getTipoConsumo().getNome() 
					+ "\nFuncion�rio: " + consumo.getFuncionario().getNome() 
					+ "\nData da solicita��o: " + consumo.getDtSolicitacao().getTime() 
					+ "\nQuantidade: " + consumo.getQuantidade() 
					+ "\nValor Total: " + consumo.getValorTotal() + "\n");
		}
	}

}
