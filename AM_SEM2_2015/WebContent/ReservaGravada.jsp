<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<%@ include file="Imports/bibliotecas.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<meta name="author" content="Lucas 74795">
	<meta name="description" content="Melhores ofertas de hospedagm no Hotel Boa Viagem. Mais de 50 anos oferecendo serviços de qualidade">
	<meta name="keywords" content="Hotel, Hotel Boa Viagem, Hospedagem, Reserva, Quartos, Hotel 5 Estrelas, HBV">
	<title>HBV - Reserva Registrada</title>
</head>
<body>
<div id="wrap">
	<c:import url="Imports/menu.jsp"></c:import>
	
	<div class="container">
	    <div class="jumbotron">
		    <h1>Reserva Registrada com Sucesso!!!</h1>
		   	${requestScope.reserva.getDtEntradaFormatted()}
	    </div>
    </div>
    
	<div id="push"></div>
</div>
<c:import url="Imports/footer.jsp"></c:import>
</body>
</html>