package br.com.fiap.am.ltp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.am.ltp.beans.Quarto;
import br.com.fiap.am.ltp.beans.Reserva;
import br.com.fiap.am.ltp.beans.TipoQuarto;
import br.com.fiap.am.ltp.bo.QuartoBO;
import br.com.fiap.am.ltp.bo.TipoQuartoBO;
import br.com.fiap.am.ltp.excecoes.Excecao;

/**
 * M�todos de acesso ao banco de Reserva. Opera��es do CRUD e demais
 * funcionalidades
 * 
 * @author Victor 74820
 * @version 1.0
 * @since 1.0
 * @see Reserva, ReservaBO
 */
public class ReservaDAO {
	private String sql = "";
	private PreparedStatement estrutura = null;
	private ResultSet rs = null;

	/**
	 * Faz a grava��o de uma Reserva no banco de dados. Veja a classe BO para
	 * entender as regras de neg�cio.
	 * 
	 * @author Victor 74820, Lucas 74795
	 * @since 1.0
	 * @param Reserva
	 *            A Reserva que est� sendo gravada no banco.
	 * @param conexao
	 *            Credenciais da conex�o.
	 * @throws Exception
	 * @see FormaPagamento, FormaPagamentoBO
	 */
	public void gravar(Reserva reserva, Connection conexao) throws Exception {
		try {
			sql = "INSERT INTO T_AM_HBV_RESERVA "
					+ "(CD_CLIENTE, DT_SOLICITACAO, DT_INICIO_RESERVA,DT_FINAL_RESERVA, QT_ADULTO, QT_CRIANCA, ST_RESERVA, VL_RESERVA)"
					+ "VALUES (?,(SELECT SYSDATE FROM DUAL),?,?,?,?,?,?)";
			estrutura = conexao.prepareStatement(sql);
			estrutura.setInt(1, reserva.getCliente().getCodigo());
			estrutura.setDate(2, new Date(reserva.getDtEntrada().getTimeInMillis()));
			estrutura.setDate(3, new Date(reserva.getDtSaida().getTimeInMillis()));
			estrutura.setShort(4, reserva.getQtAdulto());
			estrutura.setShort(5, reserva.getQtCrianca());
			estrutura.setInt(6, reserva.getStatus().getCodigo());
			estrutura.setDouble(7, reserva.getVlReserva());

			estrutura.execute();
			estrutura.close();

			for (Quarto quarto : reserva.getQuarto()) {
				sql = "INSERT INTO T_AM_HBV_RESERVA_QUARTO VALUES(SQ_AM_RESERVA.CURRVAL, "
						+ "( SELECT Q.NR_QUARTO FROM T_AM_HBV_QUARTO Q "
						+ "WHERE Q.CD_TIPO_QUARTO = ? AND (  SELECT COUNT(*) "
						+ "FROM T_AM_HBV_RESERVA_QUARTO RQ INNER JOIN T_AM_HBV_RESERVA R "
						+ "ON RQ.CD_RESERVA = R.CD_RESERVA INNER JOIN T_AM_HBV_QUARTO Q "
						+ "ON Q.NR_QUARTO = RQ.NR_QUARTO "
						+ "WHERE R.DT_INICIO_RESERVA >= ? AND R.DT_FINAL_RESERVA <= ? AND Q.CD_TIPO_QUARTO = ? "
						+ ") < ( SELECT COUNT(*) FROM T_AM_HBV_QUARTO Q WHERE Q.CD_TIPO_QUARTO = ? ) "
						+ "AND Q.NR_QUARTO NOT IN ( SELECT Q.NR_QUARTO "
						+ "FROM T_AM_HBV_RESERVA_QUARTO RQ INNER JOIN T_AM_HBV_RESERVA R "
						+ "ON RQ.CD_RESERVA = R.CD_RESERVA INNER JOIN T_AM_HBV_QUARTO Q "
						+ "ON Q.NR_QUARTO = RQ.NR_QUARTO "
						+ "WHERE R.DT_INICIO_RESERVA >= ? AND R.DT_FINAL_RESERVA <= ? "
						+ "AND Q.CD_TIPO_QUARTO = ? ) AND ROWNUM = 1 ), ?, null )";
				// 11 ESTRUTURAS
				estrutura = conexao.prepareStatement(sql);
				estrutura.setInt(1, quarto.getTipo().getCodigo());
				estrutura.setDate(2, new Date(reserva.getDtEntrada().getTimeInMillis()));
				estrutura.setDate(3, new Date(reserva.getDtSaida().getTimeInMillis()));
				estrutura.setInt(4, quarto.getTipo().getCodigo());
				estrutura.setInt(5, quarto.getTipo().getCodigo());
				estrutura.setDate(6, new Date(reserva.getDtEntrada().getTimeInMillis()));
				estrutura.setDate(7, new Date(reserva.getDtSaida().getTimeInMillis()));
				estrutura.setInt(8, quarto.getTipo().getCodigo());
				estrutura.setInt(9, (quarto.getQtAdulto() + quarto.getQtCrianca()));
				// estrutura.setString(10, quarto.get);
				
				estrutura.executeQuery();
				estrutura.close();
			}

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	/**
	 * Faz o c�lculo do valor total da reserva.
	 * 
	 * @param reserva
	 *            Os dados da reserva que est� sendo c�lculada.
	 * @param conexao
	 *            As credenciais da conex�o.
	 * @return <code>valorReserva</code> O valor total da reserva.
	 * @throws Exception
	 * @see Reserva, ReservaBO
	 */
	public double calcularReserva(Reserva reserva, Connection conexao) throws Exception {
		double valorReserva = 0;
		final long diaEmMilisegundos = 1000 * 60 * 60 * 24;
		boolean naoTemCriancaSemCusto = true;
		try {
			for (Quarto quarto : reserva.getQuarto()) {
				for (int idadeCrianca : quarto.getIdadeCriancas()) {
					if (idadeCrianca >= 0 && idadeCrianca <= 2 && naoTemCriancaSemCusto) {
						naoTemCriancaSemCusto = false;
						quarto.setQtCrianca((short) (quarto.getQtCrianca() - 1));
					}

					if (idadeCrianca >= 6) {
						quarto.setQtCrianca((short) (quarto.getQtCrianca() - 1));
						quarto.setQtAdulto((short) (quarto.getQtAdulto() + 1));
					}
				}

				naoTemCriancaSemCusto = true;
				
				int dias = (int) ((new Date(reserva.getDtSaida().getTimeInMillis()).getTime()
						- new Date(reserva.getDtEntrada().getTimeInMillis()).getTime())
						/ diaEmMilisegundos);
				
				if(dias < 1) {
					dias = 1;
				}

				sql = "SELECT SUM(TQ.VL_QUARTO * ? * ?) \"VL_QUARTO\"" + "FROM T_AM_HBV_TIPO_QUARTO TQ "
						+ "WHERE TQ.CD_TIPO_QUARTO = ? ";
				estrutura = conexao.prepareStatement(sql);
				estrutura.setInt(1, quarto.getQtAdulto());
				estrutura
						.setInt(2, dias);
				estrutura.setInt(3, quarto.getTipo().getCodigo());

				rs = estrutura.executeQuery();

				if (rs.next()) {
					valorReserva += rs.getDouble("VL_QUARTO");
				}

				rs.close();
				estrutura.close();

				sql = "SELECT SUM(TQ.VL_QUARTO * ? * ? * 0.25) \"VL_QUARTO\"" + "FROM T_AM_HBV_TIPO_QUARTO TQ "
						+ "WHERE TQ.CD_TIPO_QUARTO = ? ";
				estrutura = conexao.prepareStatement(sql);
				estrutura.setInt(1, quarto.getQtCrianca());
				estrutura
						.setInt(2,
								(int) ((new Date(reserva.getDtSaida().getTimeInMillis()).getTime()
										- new Date(reserva.getDtEntrada().getTimeInMillis()).getTime())
										/ diaEmMilisegundos));
				estrutura.setInt(3, quarto.getTipo().getCodigo());

				System.out.println("ENTRADA: " + reserva.getDtEntrada().getTime());
				System.out.println(new Date(reserva.getDtEntrada().getTimeInMillis()).getTime());
				System.out.println("\nSAIDA: " + reserva.getDtSaida().getTime());
				System.out.println(new Date(reserva.getDtSaida().getTimeInMillis()).getTime());
				System.out.println("\nDIA EM MIL: " + diaEmMilisegundos);
				System.out.println("CONTA FINAL: " + (int) ((new Date(reserva.getDtSaida().getTimeInMillis()).getTime()
						- new Date(reserva.getDtEntrada().getTimeInMillis()).getTime()) / diaEmMilisegundos));

				rs = estrutura.executeQuery();

				if (rs.next()) {
					valorReserva += rs.getDouble("VL_QUARTO");
				}

				rs.close();
				estrutura.close();
			}

			return valorReserva;

		} catch (Exception e) {
			throw new Excecao(e);
		}
	}

	/**
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param reserva
	 * @param conexao
	 * @return
	 * @throws Exception
	 */
	public List<Boolean> verificarDisponibilidadeQuarto(Reserva reserva, Connection conexao) throws Exception {
		List<Boolean> disponibilidadeQuartos = new ArrayList<Boolean>();
		boolean standartDisponivel = true;
		boolean masterDisponivel = true;
		boolean luxoDisponivel = true;
		boolean masterLuxoDisponivel = true;
		
		int standartSolicitado = 0;
		int masterSolicitado = 0;
		int luxoSolicitado = 0;
		int masterLuxoSolicitado = 0;
		
		int quartosLivres = 0;

		try {
			for (Quarto quarto : reserva.getQuarto()) {
				if(quarto.getTipo().getCodigo() == 1) {
					standartSolicitado++;
				} else if(quarto.getTipo().getCodigo() == 2) {
					masterSolicitado++;
				} else if(quarto.getTipo().getCodigo() == 3) {
					luxoSolicitado++;
				} else {
					masterLuxoSolicitado++;
				}
				
				sql = "SELECT COUNT(Q.NR_QUARTO) \"QT_QUARTO_LIVRE\" FROM T_AM_HBV_QUARTO Q WHERE Q.CD_TIPO_QUARTO = ? AND ( "
						+ " SELECT COUNT(*) FROM T_AM_HBV_RESERVA_QUARTO RQ INNER JOIN "
						+ " T_AM_HBV_RESERVA R ON RQ.CD_RESERVA = R.CD_RESERVA INNER JOIN "
						+ "  T_AM_HBV_QUARTO Q ON Q.NR_QUARTO = RQ.NR_QUARTO WHERE R.DT_INICIO_RESERVA >= ? AND R.DT_FINAL_RESERVA <= ? AND "
						+ " Q.CD_TIPO_QUARTO = ?  ) < ( SELECT COUNT(*) FROM T_AM_HBV_QUARTO Q WHERE "
						+ "    Q.CD_TIPO_QUARTO = ?  ) AND Q.NR_QUARTO NOT IN (  "
						+ "                              SELECT Q.NR_QUARTO FROM "
						+ "    T_AM_HBV_RESERVA_QUARTO RQ INNER JOIN T_AM_HBV_RESERVA R ON RQ.CD_RESERVA "
						+ "  = R.CD_RESERVA INNER JOIN T_AM_HBV_QUARTO Q ON Q.NR_QUARTO = RQ.NR_QUARTO "
						+ "    WHERE R.DT_INICIO_RESERVA >= ? AND R.DT_FINAL_RESERVA <= ? AND Q.CD_TIPO_QUARTO = ? "
						+ "   )";
				estrutura = conexao.prepareStatement(sql);
				estrutura.setInt(1, quarto.getTipo().getCodigo());
				estrutura.setDate(2, new Date(reserva.getDtEntrada().getTimeInMillis()));
				estrutura.setDate(3, new Date(reserva.getDtSaida().getTimeInMillis()));
				estrutura.setInt(4, quarto.getTipo().getCodigo());
				estrutura.setInt(5, quarto.getTipo().getCodigo());
				estrutura.setDate(6, new Date(reserva.getDtEntrada().getTimeInMillis()));
				estrutura.setDate(7, new Date(reserva.getDtSaida().getTimeInMillis()));
				estrutura.setInt(8, quarto.getTipo().getCodigo());
				
				rs = estrutura.executeQuery();
				
				if(rs.next()) {
					quartosLivres = rs.getInt("QT_QUARTO_LIVRE");
				}
				
				if(standartSolicitado > quartosLivres) {
					standartDisponivel = false;
				} else if(masterSolicitado > quartosLivres) {
					masterDisponivel = false;
				} else if(luxoSolicitado > quartosLivres) {
					luxoDisponivel = false;
				} else if(masterLuxoSolicitado > quartosLivres) {
					masterLuxoDisponivel = false;
				}
				
				rs.close();
				estrutura.close();
			}
			
			disponibilidadeQuartos.add(standartDisponivel);
			disponibilidadeQuartos.add(masterDisponivel);
			disponibilidadeQuartos.add(luxoDisponivel);
			disponibilidadeQuartos.add(masterLuxoDisponivel);
			
			return disponibilidadeQuartos;
		} catch (Exception e) {
			throw new Excecao(e);
		}
		
	}
	
	/**
	 * 
	 * @author Lucas 74795
	 * @since 1.0
	 * @param reserva
	 * @param conexao
	 * @return
	 * @throws Exception
	 */
	public List<Integer> verificarQtQuartosDisponiveis(Reserva reserva, Connection conexao) throws Exception {
		List<Integer> quartosDisponiveis = new ArrayList<Integer>();
		
		int quartosLivres = 0;

		try {
			List<TipoQuarto> lstTipoQuarto = new ArrayList<TipoQuarto>();
			lstTipoQuarto = TipoQuartoBO.buscarTodos(conexao);
			
			for (TipoQuarto tipoQuarto : lstTipoQuarto) {
				sql = "SELECT COUNT(Q.NR_QUARTO) \"QT_QUARTO_LIVRE\" FROM T_AM_HBV_QUARTO Q WHERE Q.CD_TIPO_QUARTO = ? AND ( "
						+ " SELECT COUNT(*) FROM T_AM_HBV_RESERVA_QUARTO RQ INNER JOIN "
						+ " T_AM_HBV_RESERVA R ON RQ.CD_RESERVA = R.CD_RESERVA INNER JOIN "
						+ "  T_AM_HBV_QUARTO Q ON Q.NR_QUARTO = RQ.NR_QUARTO WHERE R.DT_INICIO_RESERVA >= ? AND R.DT_FINAL_RESERVA <= ? AND "
						+ " Q.CD_TIPO_QUARTO = ?  ) < ( SELECT COUNT(*) FROM T_AM_HBV_QUARTO Q WHERE "
						+ "    Q.CD_TIPO_QUARTO = ?  ) AND Q.NR_QUARTO NOT IN (  "
						+ "                              SELECT Q.NR_QUARTO FROM "
						+ "    T_AM_HBV_RESERVA_QUARTO RQ INNER JOIN T_AM_HBV_RESERVA R ON RQ.CD_RESERVA "
						+ "  = R.CD_RESERVA INNER JOIN T_AM_HBV_QUARTO Q ON Q.NR_QUARTO = RQ.NR_QUARTO "
						+ "    WHERE R.DT_INICIO_RESERVA >= ? AND R.DT_FINAL_RESERVA <= ? AND Q.CD_TIPO_QUARTO = ? "
						+ "   )";
				estrutura = conexao.prepareStatement(sql);
				estrutura.setInt(1, tipoQuarto.getCodigo());
				estrutura.setDate(2, new Date(reserva.getDtEntrada().getTimeInMillis()));
				estrutura.setDate(3, new Date(reserva.getDtSaida().getTimeInMillis()));
				estrutura.setInt(4, tipoQuarto.getCodigo());
				estrutura.setInt(5, tipoQuarto.getCodigo());
				estrutura.setDate(6, new Date(reserva.getDtEntrada().getTimeInMillis()));
				estrutura.setDate(7, new Date(reserva.getDtSaida().getTimeInMillis()));
				estrutura.setInt(8, tipoQuarto.getCodigo());
				
				rs = estrutura.executeQuery();
				
				if(rs.next()) {
					quartosLivres = rs.getInt("QT_QUARTO_LIVRE");
				}
				
				quartosDisponiveis.add(quartosLivres);
				
				rs.close();
				estrutura.close();
			}
			
			return quartosDisponiveis;
		} catch (Exception e) {
			throw new Excecao(e);
		}
		
	}

	/*
	 * 
	 * 
	 * INSERT INTO T_AM_HBV_RESERVA_QUARTO VALUES( ? , -- C�DGIO RESERVA (
	 * SELECT Q.NR_QUARTO FROM T_AM_HBV_QUARTO Q WHERE Q.CD_TIPO_QUARTO = ? AND
	 * ( SELECT COUNT(*) FROM T_AM_HBV_RESERVA_QUARTO RQ INNER JOIN
	 * T_AM_HBV_RESERVA R ON RQ.CD_RESERVA = R.CD_RESERVA INNER JOIN
	 * T_AM_HBV_QUARTO Q ON Q.NR_QUARTO = RQ.NR_QUARTO WHERE R.DT_INICIO_RESERVA
	 * >= ? AND R.DT_FINAL_RESERVA <= ? AND Q.CD_TIPO_QUARTO = ? ) < ( SELECT
	 * COUNT(*) FROM T_AM_HBV_QUARTO Q WHERE Q.CD_TIPO_QUARTO = ? ) AND
	 * Q.NR_QUARTO NOT IN ( SELECT Q.NR_QUARTO FROM T_AM_HBV_RESERVA_QUARTO RQ
	 * INNER JOIN T_AM_HBV_RESERVA R ON RQ.CD_RESERVA = R.CD_RESERVA INNER JOIN
	 * T_AM_HBV_QUARTO Q ON Q.NR_QUARTO = RQ.NR_QUARTO WHERE R.DT_INICIO_RESERVA
	 * >= ? AND R.DT_FINAL_RESERVA <= ? AND Q.CD_TIPO_QUARTO = ? ) AND ROWNUM =
	 * 1 ) , -- NUMERO DO QUARTO ? , -- QUANTIDADE DE PESSOAS ? -- OBSERVA��O );
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * INSERT INTO T_AM_HBV_RESERVA_QUARTO VALUES( 1 , -- C�DGIO RESERVA (
	 * SELECT Q.NR_QUARTO FROM T_AM_HBV_QUARTO Q WHERE Q.CD_TIPO_QUARTO = 1 AND
	 * ( SELECT COUNT(*) FROM T_AM_HBV_RESERVA_QUARTO RQ INNER JOIN
	 * T_AM_HBV_RESERVA R ON RQ.CD_RESERVA = R.CD_RESERVA INNER JOIN
	 * T_AM_HBV_QUARTO Q ON Q.NR_QUARTO = RQ.NR_QUARTO WHERE R.DT_INICIO_RESERVA
	 * >= '15/01/2015' AND R.DT_FINAL_RESERVA <= '20/01/2015' AND
	 * Q.CD_TIPO_QUARTO = 1 ) < ( SELECT COUNT(*) FROM T_AM_HBV_QUARTO Q WHERE
	 * Q.CD_TIPO_QUARTO = 1 ) AND Q.NR_QUARTO NOT IN ( SELECT Q.NR_QUARTO FROM
	 * T_AM_HBV_RESERVA_QUARTO RQ INNER JOIN T_AM_HBV_RESERVA R ON RQ.CD_RESERVA
	 * = R.CD_RESERVA INNER JOIN T_AM_HBV_QUARTO Q ON Q.NR_QUARTO = RQ.NR_QUARTO
	 * WHERE R.DT_INICIO_RESERVA >= '15/01/2015' AND R.DT_FINAL_RESERVA <=
	 * '20/01/2015' AND Q.CD_TIPO_QUARTO = 1 ) AND ROWNUM = 1 ) , -- NUMERO DO
	 * QUARTO 4 , -- QUANTIDADE DE PESSOAS NULL -- OBSERVA��O );
	 */
}
