<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="Imports/bibliotecas.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="Style/js/reservaQuarto.js"></script>
<title>HBV - Reserva</title>
</head>
<body>
	<div id="wrap">
		<c:import url="Imports/menu.jsp"></c:import>

		<section id="container-reservar-quarto">
		<h2>RESERVAR QUARTO</h2>

		<form class="form-horizontal">

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
					<select id="qtdQuartos" name="qtdQuartos" class="form-control">
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
								src="https://xicneeg.files.wordpress.com/2009/10/quarto-hotel-st-eu.jpg"
								alt="">
							<div class="caption">
								<h3>Thumbnail label</h3>
								<div class="form-group">
									<div class="btn-group btn-group-justified" role="group"
										aria-label="...">
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-default active">Standard</button>
										</div>
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-default">Master</button>
										</div>
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-default">Luxo</button>
										</div>
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-default">Master Luxo</button>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="input-group">
										<span class="input-group-addon" id="basic-addon1"><i
											class='fa fa-users'></i></span> <select id="qtdQuartos"
											name="qtdQuartos" class="form-control">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
										</select>
									</div>
								</div>

							</div>
						</div>

					</div>
				</div>


			</div>

			<!-- Button -->
			<div class="form-group row">
				<button id="btnCalcularValor" name="btnReservarQuarto"
					class="btn btn-info col-md-4 col-md-offset-2 ">Calcular
					Valor</button>
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