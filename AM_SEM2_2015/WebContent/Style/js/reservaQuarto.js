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
		$("#dtEntrada").mask('00/00/0000');
		$("#dtSaida").mask('00/00/0000');
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
	$("#btnCalcularValor").click(function(){
		$('#mydiv').load(document.URL +  ' #mydiv');		
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


/*
	$("#qtdCriancas2").unbind().change( function() {
		var numeroQuarto  = $(this).parent().parent().parent().parent().parent().find("input:hidden.numeroQuarto").val();
		console.log('disparou! Quantidade Crianças:' + $(this).val() + " Quarto: " + numeroQuarto);
		$(this).parent().siblings(".idadeCriancas").html(tagIdadeCriancas($(this).val(),numeroQuarto));
	});
	$("#qtdCriancas3").unbind().change( function() {
		var numeroQuarto  = $(this).parent().parent().parent().parent().parent().find("input:hidden.numeroQuarto").val();
		console.log('disparou! Quantidade Crianças:' + $(this).val() + " Quarto: " + numeroQuarto);
		$(this).parent().siblings(".idadeCriancas").html(tagIdadeCriancas($(this).val(),numeroQuarto));
	});
	$("#qtdCriancas4").unbind().change(function() {
		var numeroQuarto  = $(this).parent().parent().parent().parent().parent().find("input:hidden.numeroQuarto").val();
		console.log('disparou! Quantidade Crianças:' + $(this).val() + " Quarto: " + numeroQuarto);
		$(this).parent().siblings(".idadeCriancas").html(tagIdadeCriancas($(this).val(),numeroQuarto));});
}	
	/*$(".qtdPessoas").change(function(){
		var numeroQuarto  = $(this).parent().parent().parent().parent().find(".numeroQuarto").val();
		$(this).parent().siblings(".criancas-section").html(tagSelectCriancas($(this).val(),numeroQuarto));
		$(".qtdCriancas").change(function(){
			if($(this).val() != 0){
			$(this).parent().siblings(".idadeCriancas").html(tagIdadeCriancas($(this).val(),numeroQuarto));}
		});
	});
	$(".caption .btn").click(function(){
		atualizaQuartos($(this));			
	});*/
	
	
