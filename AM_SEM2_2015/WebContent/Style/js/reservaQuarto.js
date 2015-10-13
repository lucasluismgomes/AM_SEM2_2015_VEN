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
			$("#secaoQuartos").append("<div class='col-sm-6 col-md-4 col-md-offset-"+count+"'>\
						<div class='thumbnail'>\
							<img\
								src='https://xicneeg.files.wordpress.com/2009/10/quarto-hotel-st-eu.jpg'\
								alt=''>\
							<div class='caption'>\
								<h3>Thumbnail label</h3>\
								<ul class='nav nav-pills'>\
									<li><a href='#'>Standard</a></li>\
									<li><a href='#'>Master</a></li>\
									<li><a href='#'>Luxo</a></li>\
									<li><a href='#'>Master Luxo</a></li>\
								</ul>\
								<div class='form-group'>\
									<label class='col-md-2' control-label' for='qtdQuartos'>\
										<i class='fa fa-users'></i></label>\
									<div class='col-md-6'>\
										<select name='qtdPessoas' class='form-control'>\
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
		
	});
	
	$(".caption .btn").click(function(){

		$(this).toggleClass("active");
	});
	
	
	
	
	
});