function arrumarCol(qtd){
	switch(qtd){
	case "1":
		return 4;
	break;
	case "2":
		return 1;
	break;
	case "3":
		return 0;
	break;
	case "4":
		return 1;
	break;
	}
	
}

function tagQuarto(qtdQuartos, numeroQuarto){

	//console.log("tipoQuarto"+numeroQuarto);
	//console.log("qtdAdultosQuarto"+numeroQuarto);
	
	
	
	return "<div class='col-sm-6 col-md-4 col-md-offset-"+arrumarCol(qtdQuartos)+"'>\
			<div class='thumbnail'>\
			<img\
				src='./Style/img/quartos/FuradouroBoutiqueHotel_quarto.jpg'\
				alt=''>\
				<input type='hidden' name='numeroQuarto' class='numeroQuarto' value='"+numeroQuarto+"'/>\
				<input type='hidden' name='tipoQuarto"+numeroQuarto+"' class='tipoQuarto' value='1' />\
			<div class='caption'>\
				<h3>Standard</h3>\
				<div class='form-group'>\
					<div class='btn-group-xs' data-toggle='buttons'>\
						<label class='btn btn-primary active'> <input\
							type='radio' name='options' value='S' autocomplete='off'\
							checked> Standard\
						</label> <label class='btn btn-primary'> <input type='radio'\
							name='options' value='M' autocomplete='off'> Master \
						</label> <label class='btn btn-primary'> <input type='radio'\
							name='options' value='L' autocomplete='off'> Luxo\
						</label> <label class='btn btn-primary'> <input type='radio'\
							name='options' value='ML' autocomplete='off'> Master\
							Luxo\
						</label>\
					</div>\
				</div>\
				<div class='form-group'>\
					<div class='input-group'>\
						<span class='input-group-addon'><i\
							class='fa fa-user'></i></span> <select\
							name='qtdAdultosQuarto"+numeroQuarto+"' class='form-control qtdPessoas' required>\
							<option value=''>Quantidade de adultos</option>\
							<option value='1'>1</option>\
							<option value='2'>2</option>\
							<option value='3'>3</option>\
							<option value='4'>4</option>\
						</select>\
					</div>\
					<div class='criancas-section'>\
					</div>\
				</div>\
			</div>\
		</div>\
	</div>";
}

function atualizaQuartos(element){
	var imgHoteis = ['./Style/img/quartos/FuradouroBoutiqueHotel_quarto.jpg',
	                 './Style/img/quartos/HTSP_SuitePresidencial1.jpg',
	                 './Style/img/quartos/Quarto-de-hotel-de-luxo-768x1366.jpg',
	                 './Style/img/quartos/Suite_Presidencial-casacor.jpg']
	
	$input = element.children("input");
	
	switch($input.val()){
	case "S":
		element.parent().parent().parent().parent().find(".tipoQuarto").val(1);
		element.parent().parent().parent().find("h3").html("Standard");
		element.parent().parent().parent().parent().find("img").attr("src",imgHoteis[0]);
		break;
	case "M":
		element.parent().parent().parent().parent().find(".tipoQuarto").val(2);
		element.parent().parent().parent().find("h3").html("Master");
		element.parent().parent().parent().parent().find("img").attr("src",imgHoteis[1]);
		break;
	case "L":
		element.parent().parent().parent().parent().find(".tipoQuarto").val(3);
		element.parent().parent().parent().find("h3").html("Luxo");
		element.parent().parent().parent().parent().find("img").attr("src",imgHoteis[2]);
		break;
	case "ML":
		element.parent().parent().parent().parent().find(".tipoQuarto").val(4);
		element.parent().parent().parent().find("h3").html("Master Luxo");
		element.parent().parent().parent().parent().find("img").attr("src",imgHoteis[3]);
		break;
	}	
}

function tagSelectCriancas(qtdPessoas,numeroQuarto){
	if(qtdPessoas == 0){
		return "";		
	}else{	
	var tag = "<div class='input-group'>\
	<span class='input-group-addon' id='basic-addon1'><i\
	class='fa fa-users'></i> </i></span> <select\
	id='qtdCriancas"+numeroQuarto+"' name='qtdCriancasQuarto"+numeroQuarto+"' class='form-control qtdCriancas' required>\
	<option value='0'>Quantidade de crianças</option>";
	
	var qtdCriancas = 4 - qtdPessoas;
	if(qtdCriancas == 0){
		return "";	
	}else{
		for (i=1; i <= qtdCriancas; i++){
			tag = tag + "<option value='"+i+"'>"+i+"</option>";
		}	
	}
	tag = tag + "</select>\
				</div>\
				<div class='idadeCriancas'>\
				</div>";
	
	return tag;
	}
}


function tagIdadeCriancas(qtdCriancas,numeroQuarto){
	if(qtdCriancas == 0){
		return "";		
	}else{	
		
	var tag = "<label class='control-label'>Idade das crianças</label><br><div class='input-group'>";
	
	for(c=1;c<=qtdCriancas;c++){
		//console.log("idadeCrianca"+c+"Quarto"+numeroQuarto);
		
		tag = tag + "<select\
		name='idadeCrianca"+c+"Quarto"+numeroQuarto+"' class='form-control ' required>\
				<option value='0'>0</option>\
				<option value='1'>1</option>\
				<option value='2'>2</option>\
				<option value='3'>3</option>\
				<option value='4'>4</option>\
				<option value='5'>5</option>\
				</select>"
	}
	return tag + "<span class='input-group-addon' id='basic-addon1'><i class='fa fa-child'></i></span></div>";
	}
}
$(document).ready(function(){
	var isOpera = !!window.opera || navigator.userAgent.indexOf(' OPR/') >= 0;
	    // Opera 8.0+ (UA detection to detect Blink/v8-powered Opera)
	var isFirefox = typeof InstallTrigger !== 'undefined';   // Firefox 1.0+
	var isSafari = Object.prototype.toString.call(window.HTMLElement).indexOf('Constructor') > 0;
	    // At least Safari 3+: "[object HTMLElementConstructor]"
	var isChrome = !!window.chrome && !isOpera; 
	
	if(!isChrome){
		$("#navegador").val(false);
		$("#dtEntrada").mask('00/00/0000');
		$("#dtSaida").mask('00/00/0000');
		
		$("#dtEntrada").focusout(function() {
			var today = new Date();
			
			var alerta = "<div class='alert alert-danger' role='alert'>\
				  <span class='glyphicon glyphicon-exclamation-sign' aria-hidden='true'></span>\
				  <span class='sr-only'>Error:</span>\
				  Data invalida!\
				</div>";
			
			var dataSplit = $(this).val().split("/");
			var data = new Date(dataSplit[2],dataSplit[1] - 1, dataSplit[0],23, 59, 59, 59);
			if(data >= today){
				$(this).removeClass("inputAlert");
				$("#avisos").html('');
			}else{
				$(this).addClass("inputAlert");
				$("#avisos").html('');
				$("#avisos").append(alerta);
			}		

		});	
		
		$("#dtSaida").focusout(function() {
			
			var dataEntradaSplit = $("#dtEntrada").val().split("/");
			var dataEntrada = new Date(dataEntradaSplit[2],dataEntradaSplit[1] - 1, dataEntradaSplit[0],23, 59, 59, 59);
			
			var alerta = "<div class='alert alert-danger' role='alert'>\
				  <span class='glyphicon glyphicon-exclamation-sign' aria-hidden='true'></span>\
				  <span class='sr-only'>Error:</span>\
				  Data invalida!\
				</div>";
			
			var dataSplit = $(this).val().split("/");
			var data = new Date(dataSplit[2],dataSplit[1] - 1, dataSplit[0],23, 59, 59, 59);
			
			if(data >= dataEntrada && dataEntrada >= new Date()){
				$(this).removeClass("inputAlert");
				$("#avisos").html('');
			}else{
				$(this).addClass("inputAlert");
				$("#avisos").html('');
				$("#avisos").append(alerta);
			}
			
			if(data >= today){
				$(this).removeClass("inputAlert");
				$("#avisos").html('');
			}else{
				$(this).addClass("inputAlert");
				$("#avisos").html('');
				$("#avisos").append(alerta);
			}	

		});	
		
		
		$("#btnCalcularValor").click(function(){
			var today = new Date();

			var dataEntradaSplit = $("#dtEntrada").val().split("/");
			var dataEntrada = new Date(dataEntradaSplit[2],dataEntradaSplit[1] - 1, dataEntradaSplit[0],23, 59, 59, 59);
			
			var alerta = "<div class='alert alert-danger' role='alert'>\
				  <span class='glyphicon glyphicon-exclamation-sign' aria-hidden='true'></span>\
				  <span class='sr-only'>Error:</span>\
				  Data invalida!\
				</div>";
			
			var dataSplit = $("#dtSaida").val().split("/");
			var dataSaida = new Date(dataSplit[2],dataSplit[1] - 1, dataSplit[0],23, 59, 59, 59);
			
			if(dataSaida >= dataEntrada){
				$("#dtSaida").removeClass("inputAlert");
				$("#avisos").html('');
			}else{
				$("#dtSaida").addClass("inputAlert");
				$("#avisos").html('');
				$("#avisos").append(alerta);
			}
			
			if(dataEntrada >= today){
				$("#dtEntrada").removeClass("inputAlert");
				$("#avisos").html('');
			}else{
				$("#dtEntrada").addClass("inputAlert");
				$("#avisos").html('');
				$("#avisos").append(alerta);
			}	
				
		});
	}

	
	
	
	$("#dtEntrada").attr("min", function() {
		var d = new Date();
	    return d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
	  });
	
	$("#dtEntrada").change(function(a) {
		$("#dtSaida").attr("min", function() {
		    return $("#dtEntrada").val();
		  });
	});	
	

	
	$("#qtdQuartos").change(function(){
		$("#secaoQuartos").html('');
		var qtdQuartos = $("#qtdQuartos option:selected").val();
		for(i = 1; i <= qtdQuartos; i++){
			$("#secaoQuartos").append(tagQuarto(qtdQuartos,i));					
		}
		
		$(".caption .btn").click(function(){
			atualizaQuartos($(this));			
		});
		
		$(".qtdPessoas").change(function() {
			console.log('add click event');
			var numeroQuarto  = $(this).parent().parent().parent().parent().find("input:hidden.numeroQuarto").val();
			
			$(this).parent().siblings(".criancas-section").html(tagSelectCriancas($(this).val(),numeroQuarto));
			carregaChangeSelects(numeroQuarto);
			});
		});

	
	$(".caption .btn").click(function(){
		atualizaQuartos($(this));			
	});
	
	$(".qtdPessoas").change(function() {
		console.log('add click event');
		var numeroQuarto  = $(this).parent().parent().parent().parent().find("input:hidden.numeroQuarto").val();
		
		$(this).parent().siblings(".criancas-section").html(tagSelectCriancas($(this).val(),numeroQuarto));
		carregaChangeSelects(numeroQuarto);
		});
});
	
function carregaChangeSelects(){
	$(".qtdCriancas").unbind().change(function() {
		var numeroQuarto  = $(this).parent().parent().parent().parent().parent().find("input:hidden.numeroQuarto").val();
		console.log('disparou! Quantidade Crianças:' + $(this).val() + " Quarto: " + numeroQuarto);
		$(this).parent().siblings(".idadeCriancas").html(tagIdadeCriancas($(this).val(),numeroQuarto));
	});
}

	
function validarDataEntrada(){
	var today = new Date();
	
	var dataSplit = $("#dtEntrada").val().split("/");
	var dataEntrada = new Date(dataSplit[2],dataSplit[1] - 1, dataSplit[0],23, 59, 59, 59);
	if(dataEntrada >= today){
		return true;
	}else{
	return false;
	}
}

function validarDataSaida(){
	var dataEntradaSplit = $("#dtEntrada").val().split("/");
	var dataEntrada = new Date(dataEntradaSplit[2],dataEntradaSplit[1] - 1, dataEntradaSplit[0],23, 59, 59, 59);
	var dataSaidaSplit = $("#dtSaida").val().split("/");
	var dataSaida = new Date(dataSaidaSplit[2],dataSaidaSplit[1] - 1, dataSaidaSplit[0],23, 59, 59, 59);
	
	if(dataSaida >= dataEntrada){
		return true;
	}else{
	return false;
	}
}

