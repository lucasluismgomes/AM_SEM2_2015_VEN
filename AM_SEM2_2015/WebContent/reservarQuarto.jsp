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

			<form class="form-horizontal" action="ServletHBV" method="post">

				<!-- Prepended text-->
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

					<div class="row">
						<div class="col-sm-6 col-md-4 col-md-offset-4">
							<div class="thumbnail">
								<img
									src="./Style/img/quartos/FuradouroBoutiqueHotel_quarto.jpg"
									alt="">
								<input type="hidden" name="numeroQuarto" class="numeroQuarto" value="1"/>
								<input type="hidden" name="tipoQuarto1" class="tipoQuarto" value="1"/>
								<div class="caption">
									<h3>Standard</h3>
									<div class="form-group">
										<div class="btn-group-xs" data-toggle="buttons">
											<label class="btn btn-primary active"> <input
												type="radio" name="options" value="S" autocomplete="off"
												checked> Standard
											</label> <label class="btn btn-primary"> <input type="radio"
												name="options" value="M" autocomplete="off"> Master 
											</label> <label class="btn btn-primary"> <input type="radio"
												name="options" value="L" autocomplete="off"> Luxo
											</label> <label class="btn btn-primary"> <input type="radio"
												name="options" value="ML" autocomplete="off"> Master
												Luxo
											</label>
										</div>
									</div>
									<div class="form-group">
										<div class="input-group">
											<span class="input-group-addon" id="basic-addon1"><i
												class='fa fa-user'></i></span> <select
												name="qtdAdultosQuarto1" class="form-control qtdPessoas" required>
												<option value="">Quantidade de adultos</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
											</select>
										</div>
										<div class="criancas-section">
										</div>
									</div>

								</div>
							</div>

						</div>
					</div>


				</div>

				<!-- Button -->
				<div id="mydiv"></div>
				<div class="form-group row">
					<input id="btnCalcularValor" name=""
						class="btn btn-info col-md-4 col-md-offset-2 " type="button" value="Calcular reserva"/>
					<button id="btnReservarQuarto" name="btnReservarQuarto"
						class="btn btn-success col-md-4 col-md-offset-right-2 ">Reservar
						Quarto</button>
				</div>

			</form>

		</section>






		<div id="push"></div>
	</div>
	<c:import url="Imports/footer.jsp"></c:import>
</body>
</html>