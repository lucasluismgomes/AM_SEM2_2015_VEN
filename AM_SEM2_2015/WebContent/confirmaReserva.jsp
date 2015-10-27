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
				<h4 class="list-group-item-text">Data de Saida:  ${requestScope.reserva.dtSaida}</h4>
			</a>
		<c:forEach items="${requestScope.reserva.quarto}" var="Quarto">
			<a href="#" class="list-group-item">
				<h4 class="list-group-item-text">${Quarto.tipo.nomeTipo}</h4>
				<p class="list-group-item-text"><small>${Quarto.qtAdulto} Adultos e ${Quarto.qtCrianca} crianças</small></p>
			</a>		
		</c:forEach>

		
		</div>
		<div id="push"></div>
	</div>
	<c:import url="Imports/footer.jsp"></c:import>
</body>
</html>