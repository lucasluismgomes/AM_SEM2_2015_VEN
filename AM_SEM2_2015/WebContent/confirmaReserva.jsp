<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<%@ include file="Imports/bibliotecas.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="UTF-8">
	<meta name="author" content="Lucas 74795">
	<meta name="description" content="Melhores ofertas de hospedagm no Hotel Boa Viagem. Mais de 50 anos oferecendo serviços de qualidade">
	<meta name="keywords" content="Hotel, Hotel Boa Viagem, Hospedagem, Reserva, Quartos, Hotel 5 Estrelas, HBV">
	<title>HBV</title>
</head>
<body>
	<div id="wrap">
		<c:import url="Imports/menu.jsp"></c:import>
		<h2>Confirmar reserva</h2>
		<div class="list-group">
			<a href="#" class="list-group-item">
				<h4 class="list-group-item-text">Data de Entrada: ${requestScope.reserva.dtEntrada.getTime()}</h4>
				<h4 class="list-group-item-text">Data de Saida:  ${requestScope.reserva.dtSaida.getTime()}</h4>
			</a>
		<c:forEach items="${requestScope.reserva.quarto}" var="Quarto">
		<c:set var="qtCriancasCortesia" value="0" scope="page"></c:set>
		<c:set var="totalQuarto" value="0" scope="page"></c:set>
			<a href="#" class="list-group-item">
				<h4 class="list-group-item-text">${Quarto.tipo.nomeTipo}</h4>
				<p class="list-group-item-text"><small>Valor da diária do quarto: R$ ${Quarto.tipo.valor} por dia e por pessoa</small></p>
				<p class="list-group-item-text">
					<small>
						Somatória do valor da hospedagem neste quarto: R$ ${Quarto.tipo.valor * (Quarto.qtAdulto + Quarto.qtCrianca) * reserva.qtDias}
						<c:set var="totalQuarto" value="${totalQuarto + (Quarto.tipo.valor * (Quarto.qtAdulto + Quarto.qtCrianca) * reserva.qtDias)}" scope="page"></c:set>
						<c:forEach items="${Quarto.idadeCriancas}" var="Integer">
							<c:if test="${(Integer >= 3 && Integer <= 5) || (qtCriancasCortesia > 0 && Integer >= 0 && Integer <= 2)}">
								- <span style="color: red;">${(Quarto.tipo.valor - (Quarto.tipo.valor * 0.25)) * reserva.qtDias}**</span>
								<c:set var="totalQuarto" value="${totalQuarto - (Quarto.tipo.valor - (Quarto.tipo.valor * 0.25)) * reserva.qtDias}" scope="page"></c:set>
							</c:if>
							<c:if test="${Integer >= 0  && Integer <= 2 && qtCriancasCortesia == 0}">
								- <span style="color: red;">${Quarto.tipo.valor * reserva.qtDias}*</span>
								<c:set var="qtCriancasCortesia" value="${qtCriancasCortesia + 1}" scope="page"></c:set>
								<c:set var="totalQuarto" value="${totalQuarto - Quarto.tipo.valor * reserva.qtDias}" scope="page"></c:set>
							</c:if>
						</c:forEach>
					</small>
				</p>
				<p class="list-group-item-text"><small>${Quarto.qtAdulto} Adulto(s) e ${Quarto.qtCrianca} criança(s)</small></p>
				<p class="list-group-item-text"><small>Total deste quarto: R$ ${totalQuarto}</small></p>				
				<p class="list-group-item-text"><small><span style="color: red; font-size: 9px;">* Crianças com 2 anos ou menos não pagam. Limite de 1 por quarto, após atingir o limite entra na faixa de crianças entre 3 e 5 anos.</span></small></p>
				<p class="list-group-item-text"><small><span style="color: red; font-size: 9px;">** Crianças entre 3 e 5 anos pagam apenas 25% do valor do adulto (75% de desconto).</span></small></p>
			</a>		
		</c:forEach>
		<a href="#" class="list-group-item">
			<h4 class="list-group-item-text">Total da Reserva</h4>
			<p class="list-group-item-text">R$ ${reserva.vlReserva}</p>
		</a>
		
		</div>
		<div id="push"></div>
	</div>
	<c:import url="Imports/footer.jsp"></c:import>
</body>
</html>