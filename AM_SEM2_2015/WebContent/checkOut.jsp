<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<%@ include file="Imports/bibliotecas.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="author" content="Estevão 74803">
<meta name="description"
	content="CheckOut de Hospedagens no Hotel Boa Viagem">
<meta name="keywords"
	content="Hotel, Hotel Boa Viagem, Hospedagem, Reserva, Quartos, Hotel 5 Estrelas, HBV">
<script type="text/javascript" src="Style/js/reservaQuarto.js"></script>
<title>HBV</title>
</head>
<body>

	<div id="wrap">
		<c:import url="Imports/menu.jsp"></c:import>
		<section id="container-checkout">
			<h2>CHECKOUT - HOSPEDAGEM</h2>
			<br/><br/>
			<form action="CheckoutServletHBV" method="get" id="buscaCodigoForm">
				<h4>Insira o Código da Hospedagem</h4><input type="text" name="codigoHospedagem">
				<input type="submit" value="BUSCAR">
			</form>
			
		<c:if test="${param.codigoHospedagem > 0}">
			<script>
				$("#buscaCodigoForm").css("display", "none");
				$("#checkList").css("display", "block");
			</script>
			<a href="checkOut.jsp" class="btn btn-default">NOVA BUSCA</a>
		</c:if>
		
			<form id="checkList" action="CheckoutServletHBV" method="get">
			<div class="list-group" id="list-estrutura">
				<a href="#" class="list-group-item">
					<h4 class="list-group-item-text">Código Hospedagem: ${requestScope.hospedagem.reserva.codigo}</h4>
				</a>
				<a href="#" class="list-group-item">
					<h4 class="list-group-item-text">Cliente: ${requestScope.hospedagem.reserva.cliente.getNome()}</h4>
				</a>
				<a href="#" class="list-group-item">
					<h4 class="list-group-item-text">Data de Entrada: ${requestScope.hospedagem.getDtEntradaFormatted()}</h4>
				</a>
				<a href="#" class="list-group-item">
					<h4 class="list-group-item-text">Data de Saida: <input type="text" name="dtSaida"> </h4>
				</a>
  				<a class="list-group-item" role="button" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
  					Consumo | R$${valorTotalConsumo}
				</a>
				<div class="collapse" id="collapseExample">
  					<div class="well">
						<table class="table table-hover">
 							<tr>
 								<th>Tipo de Consumo</th>
 								<th>Quantidade</th>
 								<th>Valor Total</th>
 								<th>Editar</th>
 							</tr>
   								<c:forEach items="${lstConsumo}" var="Consumo">
									<tr>
										<td><h5 class="list-group-item-text">${Consumo.tipoConsumo.nome}</h5></td>
										<td><h5 class="list-group-item-text">${Consumo.quantidade}</h5></td>
										<td><h5 class="list-group-item-text">R$${Consumo.valorTotal}</h5></td>
										<td><input type="submit" class="btn btn-default" name="editar" value="Editar"></td>
									</tr>
								</c:forEach>
								<tr>
									<td>VALOR TOTAL DOS CONSUMOS: R$${valorTotalConsumo}</td>
								</tr>
						</table>
					</div>
				</div>
			</div>
			</form>
		</section>	
		<div id="push"></div>
	</div>
	<c:import url="Imports/footer.jsp"></c:import>

</body>
</html>