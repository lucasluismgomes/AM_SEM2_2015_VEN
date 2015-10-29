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
<script type="text/javascript" src="Style/js/checkout.js"></script>
<title>HBV</title>
</head>
<body>

	<div id="wrap">
		<c:import url="Imports/menu.jsp"></c:import>
		<section id="container-checkout">
			<h2>CHECKOUT - HOSPEDAGEM</h2>
			<br /> <br />
			<form action="CheckoutServletHBV" method="get" id="buscaCodigoForm">
				<h4>Insira o Código da Hospedagem</h4>
				<input type="text" name="codigoHospedagem"> <input
					type="submit" value="BUSCAR">
			</form>

			<c:if test="${param.codigoHospedagem > 0}">
				<script>
					$("#buscaCodigoForm").css("display", "none");
				</script>
				<a href="checkOut.jsp" class="btn btn-default">NOVA BUSCA</a>
			</c:if>

			<form action="CheckoutServletHBV" method="get">
				<div class="list-group" id="list-estrutura">
					<a href="#" class="list-group-item">
						<h4 class="list-group-item-text">Código Hospedagem:
							${requestScope.hospedagem.reserva.codigo}</h4>
					</a> <a href="#" class="list-group-item">
						<h4 class="list-group-item-text">Cliente:
							${requestScope.hospedagem.reserva.cliente.getNome()}</h4>
					</a> <a href="#" class="list-group-item">
						<h4 class="list-group-item-text">Data de Entrada:
							${requestScope.hospedagem.getDtEntradaFormatted()}</h4>
					</a> <a href="#" class="list-group-item">
						<h4 class="list-group-item-text">
							Data de Saida: <input type="text" name="dtSaida">
						</h4>
					</a> <a class="list-group-item" role="button" data-toggle="collapse"
						href="#collapseExample" aria-expanded="false"
						aria-controls="collapseExample"> Consumo |
						R$${valorTotalConsumo} </a>
					<div class="collapse" id="collapseExample">
						<div class="well">
							<table class="table table-hover">
								<tr>
									<th>Tipo de Consumo</th>
									<th>Quantidade</th>
									<th>Valor Total</th>
								</tr>
								<c:set var="codigoHospedagemConsumo"
									value="${requestScope.hospedagem.reserva.codigo}"
									scope="request"></c:set>
								<c:set var="index" value="0" scope="request" />
								<c:set var="alterar" value="alterar" scope="request" />


							</table>

						</div>
					</div>
				</div>
			</form>
			<form action="#">
				<table class="table table-hover">
					<c:forEach items="${lstConsumo}" var="Consumo">
						<tr>
							<input type="hidden" value="${Consumo.codigo}"
								name="consumo${index}" />
							<td><h5 class="list-group-item-text">${Consumo.tipoConsumo.nome}</h5></td>
							<td><input class="list-group-item-text" type="text" size="3"
								maxlength="3" name="quantidade${index}"
								value=${Consumo.quantidade}></td>
							<td><h5 class="list-group-item-text">R$${Consumo.valorTotal}</h5></td>
						</tr>
						<c:set var="index" value="${index+1 }" />
					</c:forEach>
					<tr>
						<td>VALOR TOTAL DOS CONSUMOS: R$${valorTotalConsumo}</td>
						<td>
						<td><input type="button" class="btn btn-default"
							name="salvar Alterações" value="Salvar" disabled="disabled"></td>
						</td>
					</tr>
				</table>
			</form>


			<form action="CheckoutServletHBV" method="post">
				<input type="hidden" value="10" name="totalPagamento" />
				<div class="list-group" id="list-estrutura">
					<a href="#" class="list-group-item">
						<table>
							<tr>
								<th><h4 class="list-group-item-text">Forma de
										Pagamento</h4></th>
							</tr>
							<tr>
								<td><h6 class="list-group-item-text">
										Cartão de Crédito <input type="radio" value="5" id="credito"
											name="pagamento">
									</h6></td>
								<td><h6 class="list-group-item-text">
										Cartão de Débito <input type="radio" value="4" id="debito"
											name="pagamento">
									</h6></td>
							</tr>
							<tr>
								<td><h6 class="list-group-item-text">
										Cheque a vista <input type="radio" value="3" id="cqVista"
											name="pagamento">
									</h6></td>
								<td><h6 class="list-group-item-text">
										Cheque Parcelado <input type="radio" value="2"
											id="cqParcelado" name="pagamento">
									</h6></td>
							</tr>
							<tr>
								<td><h6 class="list-group-item-text">
										Dinheiro <input type="radio" value="1" id="dinheiro"
											name="pagamento">
									</h6></td>
							</tr>
							<tr>
								<td>
								<input type="submit" class="btn btn-default"
									name="efetuarPagamento" value="Efetuar pagamento"></td>
								</td>
							</tr>
						</table>
						<div id="camposPagamento"></div>
					</a>
				</div>
			</form>

		</section>
		<div id="push"></div>
	</div>
	<c:import url="Imports/footer.jsp"></c:import>

</body>
</html>