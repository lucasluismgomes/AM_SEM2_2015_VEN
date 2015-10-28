<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<%@ include file="Imports/bibliotecas.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="author" content="Gustavo 74816">
<meta name="description"
	content="Reserva de quartos no Hotel Boa Viagem">
<meta name="keywords"
	content="Hotel, Hotel Boa Viagem, Hospedagem, Reserva, Quartos, Hotel 5 Estrelas, HBV">
<script type="text/javascript" src="Style/js/reservaQuarto.js"></script>
<title>HBV</title>
</head>
<body>

	<div id="wrap">
		<c:import url="Imports/menu.jsp"></c:import>
		<section id="container-reservar-quarto">
			<h2>RESERVAR QUARTO</h2> 
			<form class="form-horizontal" action="ServletHBV" method="post" onsubmit="return (validarDataEntrada() & validarDataSaida())">
			<input type="hidden" id="navegador" name="navegador" value="TRUE"/>
				<!-- Prepended text-->
				<div id="avisos"></div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="dtEntrada"></label>
					<div class="col-md-4">
						<div class="input-group">
							<span class="input-group-addon">Data entrada</span> <input
								id="dtEntrada" name="dtEntrada" class="form-control"
								placeholder="__/__/__" type="date" required="">
						</div>

					</div>
				</div>

				<!-- Appended Input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="dtSaida"></label>
					<div class="col-md-4">
						<div class="input-group">
							<input id="dtSaida" name="dtSaida" class="form-control"
								placeholder="__/__/__" type="date" required=""> <span
								class="input-group-addon">Data saída</span>
						</div>
					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="qtdQuartos">Quantidade
						de quartos</label>
					<div class="col-md-4">
						<select id="qtdQuartos" name="qtdQuartos" class="form-control" required>
							<option value="">Selecione a quantidade de quartos</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</div>
				</div>
				<div id="secaoQuartos" class="row">
				
				</div>
				<!-- Button -->
				<div id="mydiv"></div>
				<div class="form-group row">
					<input id="btnCalcularValor" name=""
						class="btn btn-info col-md-4 col-md-offset-4 " type="submit" value="Calcular reserva"/>
				</div>

			</form>

		</section>






		<div id="push"></div>
	</div>
	<c:import url="Imports/footer.jsp"></c:import>
</body>
</html>