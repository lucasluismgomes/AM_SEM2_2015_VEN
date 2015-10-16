$(document).ready(function(){

	$("#qtdQuartos").change(function(){
		$("#secaoQuartos").html('');
		var qtdQuartos = $("#qtdQuartos option:selected").val();
		var count;
		var h = 400;
		switch(qtdQuartos){
		case "1":
			count = 4;
			h = 400;
		break;
		case "2":
			count = 1;
		break;
		case "3":
			count = 0;
		break;
		case "4":
			count = 1;
			h = 800;
		break;
		}
		$("#secaoQuartos").height(h);
		for(i = 0; i < qtdQuartos; i++){
			$("#secaoQuartos").append("<div class='col-sm-4 col-md-4 col-md-offset-"+count+"'>\
							<div class='thumbnail'>\
								<img\
									src='http://waldorfastoria3.hilton.com/resources/media/wa/BERWAWA/en_US/img/hotel/roomtypeimages/large/WA_presidentialsuite04_2.jpg'\
									alt=''>\
								<div class='caption'>\
									<h3>Thumbnail label</h3>\
									<div class='form-group'>\
										<div class='btn-group' data-toggle='buttons'>\
											<label class='btn btn-primary active' > <input\
												type='radio' name='options' value='S' autocomplete='off'\
												checked> Standard\
											</label> <label class='btn btn-primary' > <input type='radio'\
												name='options' value='M' autocomplete='off'>\
												Master\
											</label> <label class='btn btn-primary'> <input type='radio'\
												name='options' value='L' autocomplete='off'>\
												Luxo\
											</label>\
											<label class='btn btn-primary'> <input type='radio'\
												name='options' value='ML' autocomplete='off'>\
												Master Luxo\
											</label>\
										</div>\
									</div>\
									<div class='form-group'>\
										<div class='input-group'>\
											<span class='input-group-addon' id='basic-addon1'><i\
												class='fa fa-users'></i></span> <select id='qtdPessoa'\
												name='qtdPessoa' class='form-control'>\
												<option value='1'>1</option>\
												<option value='2'>2</option>\
												<option value='3'>3</option>\
												<option value='4'>4</option>\
											</select>\
										</div>\
									</div>\
								</div>\
							</div>\
						</div>");					
		}
		
		$(".caption .btn").click(function(){
			var imgHoteis = ['./Style/img/quartos/FuradouroBoutiqueHotel_quarto.jpg',
			                 './Style/img/quartos/HTSP_SuitePresidencial1.jpg',
			                 './Style/img/quartos/Quarto-de-hotel-de-luxo-768x1366.jpg',
			                 './Style/img/quartos/Suite_Presidencial-casacor.jpg']
			
			$input = $(this).children("input");
			
			switch($input.val()){
			case "S":
				$(this).parent().parent().parent().find("h3").html("Standard");
				$(this).parent().parent().parent().parent().find("img").attr("src",imgHoteis[0]);
				break;
			case "M":	
				$(this).parent().parent().parent().find("h3").html("Master");
				$(this).parent().parent().parent().parent().find("img").attr("src",imgHoteis[1]);
				break;
			case "L":	
				$(this).parent().parent().parent().find("h3").html("Luxo");
				$(this).parent().parent().parent().parent().find("img").attr("src",imgHoteis[2]);
				break;
			case "ML":		
				$(this).parent().parent().parent().find("h3").html("Master Luxo");
				$(this).parent().parent().parent().parent().find("img").attr("src",imgHoteis[3]);
				break;
			}
			
		});
	});

	
	
	
	
	
});