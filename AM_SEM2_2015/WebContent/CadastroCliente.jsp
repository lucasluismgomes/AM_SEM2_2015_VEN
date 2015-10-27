<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<%@ include file="Imports/bibliotecas.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<meta name="author" content="Lucas 74795">
	<meta name="description" content="Página de cadastro de clientes HBV. Torne-se hoje mesmo um membro da maior e mlehor rede de Hoteís do mundo!">
	<meta name="keywords" content="Cadastro, Cliente HBV, afiliar, cadastrar">
	<title>HBV - Cadastro</title>
</head>
<body>
<div id="wrap">
	<c:import url="Imports/menu.jsp"></c:import>
	
        <div class="container" style="padding-top: 0px;">
		    <h1 class="well">Cadastro</h1>
			<div class="col-lg-12 well">
			<div class="row">
						<form>
							<div class="col-sm-12">
								<div class="row">
									<div class="col-sm-6 form-group">
										<label>Nome completo</label>
										<input type="text" placeholder="Nome completo" class="form-control" required="required">
									</div>
									<div class="col-sm-6 form-group">
										<label>CPF</label>
										<input type="number" placeholder="Digite seu CPF aqui" class="form-control" required="required">
									</div>
								</div>
								<div class="row">
									<div class="col-sm-6 form-group">
										<label>RG</label>
										<input type="text" placeholder="Digite seu RG aqui" class="form-control" required="required">
									</div>		
									<div class="col-sm-6 form-group">
										<label>Data de nascimento</label>
										<input type="date" placeholder="dd/mm/aaaa" class="form-control" required="required">
									</div>	
								</div>					
								<div class="row">
									<div class="col-sm-4 form-group">
										<label>Cidade</label>
										<input type="text" placeholder="Cidade" class="form-control" required="required">
									</div>	
									<div class="col-sm-4 form-group">
										<label>Estado</label>
										<input type="text" placeholder="Estado" class="form-control" required="required">
									</div>	
									<div class="col-sm-4 form-group">
										<label>CEP</label>
										<input type="number" placeholder="Cep" class="form-control" required="required">
									</div>		
								</div>			
							<div class="form-group">
								<label>Telefone principal</label>
								<input type="text" placeholder="(11) 99999999" class="form-control" required="required">
							</div>		
							<div class="form-group">
								<label>E-mail</label>
								<input type="email" placeholder="exemplo@email.com.br" class="form-control" required="required">
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-sm-6 form-group">
										<label>Senha</label>
										<input type="text" placeholder="***********" class="form-control" required="required">
									</div>
									<div class="col-sm-6 form-group">
										<label>Confirmar senha</label>
										<input type="text" placeholder="***********" class="form-control" required="required">
									</div>
								</div>
							</div>
							<button type="submit" class="btn btn-lg btn-info">Finalizar cadastro</button>					
							</div>
						</form> 
						</div>
				</div>
			</div>

    
	<div id="push"></div>
</div>
<c:import url="Imports/footer.jsp"></c:import>
</body>
</html>