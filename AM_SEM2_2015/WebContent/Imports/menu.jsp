<nav class="navbar navbar-default navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">Hotel Boa Viagem</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="sobre.jsp">Sobre</a></li>
				<li><a href="contato.jsp">Contato</a></li>
				<li><a href="reservarQuarto.jsp">Reserva</a></li>
				<%--<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Hospedagem<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="reservarQuarto.jsp">Reserva</a></li>
					<li><a href="#">Calendário</a></li>
					<li role="separator" class="divider"></li>
					<li class="dropdown-header">Serviços</li>
					<li><a href="#">Transporte</a></li>
					<li><a href="#">Passagens</a></li>
				</ul>
				</li>--%>
			</ul>
			<div class="col-sm-6" hidden="true">
		        <div class="pull-right  hidden-xs">
		          <a class="dropdown-toggle" href="#" data-toggle="dropdown"><h4 style="padding-top: 6px;"><i class="glyphicon glyphicon-cog"></i></h4></a>
		          <ul class="dropdown-menu">
		              <li><a href="#"><i class="glyphicon glyphicon-user"></i> Perfil</a></li>
		              <li><a href="#"><i class="glyphicon glyphicon-calendar"></i> Minhas reservas</a></li>
		          </ul>
		        </div>
	      	</div>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown" id="loginCliente">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
					<ul id="login-dp" class="dropdown-menu">
						<li>
							<div class="row">
								<div class="col-md-12">
									<form onsubmit="return validarLogin()" class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
										<div class="form-group">
											<label class="sr-only" for="exampleInputEmail2">Usuário</label>
											<input type="text" class="form-control" id="usuario" name="usuario" placeholder="E-mail ou código" required="required">
										</div>
										<div class="form-group">
											<label class="sr-only" for="exampleInputPassword2">Senha</label>
											<input type="password" class="form-control" id="senha" name="senha" placeholder="Senha" required="required">
											<div class="help-block text-right"><a href="">Esqueci minha senha</a></div>
										</div>
										<div class="form-group">
											<button type="submit" class="btn btn-primary btn-block">Entrar</button>
										</div>
									</form>
								</div>
								<div class="bottom text-center">
									Primeiro acesso? <a href="#"><b>Cadastre-se</b></a>
								</div>
							</div>
						</li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"><b>Sair</b></span></a>
				</li>
			</ul>
		</div><%-- /.nav-collapse --%>
	</div>
</nav>