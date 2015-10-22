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
	
	return "<div class='col-sm-6 col-md-4 col-md-offset-"+arrumarCol(qtdQuartos)+"'>\
			<div class='thumbnail'>\
			<img\
				src='http://waldorfastoria3.hilton.com/resources/media/wa/BERWAWA/en_US/img/hotel/roomtypeimages/large/WA_presidentialsuite04_2.jpg'\
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
							name='qtdAdultosQuarto"+numeroQuarto+"' class='form-control qtdPessoas'>\
							<option value='0'>Quantidade de adultos</option>\
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
	name='qtdcriancasQuarto"+numeroQuarto+"' class='form-control qtdCriancas'>\
	<option value=''>Quantidade de crianças</option>";
	
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
	var tag = "<label class='control-label'>Idade das crianças</label><br><div class='input-group idadeCrianca'>";
	
	for(i=1;i<=qtdCriancas;i++){
		tag = tag + "<select\
		name='idadeCrianca"+i+"Quarto"+numeroQuarto+"' class='form-control '>\
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

	$("#qtdQuartos").change(function(){
		$("#secaoQuartos").html('');
		var qtdQuartos = $("#qtdQuartos option:selected").val();

		for(i = 1; i <= qtdQuartos; i++){
			$("#secaoQuartos").append(tagQuarto(qtdQuartos,i));					
		}
		
		$(".caption .btn").click(function(){
			atualizaQuartos($(this));			
		});
		$(".qtdPessoas").change(function(){
			var numeroQuarto  = $(this).parent().parent().parent().parent().find(".numeroQuarto").val();
			
			$(this).parent().siblings(".criancas-section").html(tagSelectCriancas($(this).val(),numeroQuarto));
			$(".qtdCriancas").change(function(){
				$(this).parent().siblings(".idadeCriancas").html(tagIdadeCriancas($(this).val(),numeroQuarto));
			});
		});
	});
	$(".qtdPessoas").change(function(){
		var numeroQuarto  = $(this).parent().parent().parent().parent().find(".numeroQuarto").val();
		$(this).parent().siblings(".criancas-section").html(tagSelectCriancas($(this).val(),numeroQuarto));
		$(".qtdCriancas").change(function(){
			$(this).parent().siblings(".idadeCriancas").html(tagIdadeCriancas($(this).val(),numeroQuarto));
		});
	});
	$(".caption .btn").click(function(){
		atualizaQuartos($(this));			
	});
	
	
	
	
	
});