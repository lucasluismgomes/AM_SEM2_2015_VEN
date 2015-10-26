$(document).ready(function(){
   var string = document.location.pathname.replace('/AM_SEM2_2015/','');
   $('ul.nav > li > a[href="' + string + '"]').parent().addClass('active');   
});

// Validação de Login - apenas e-mails e números permitidos
function validarLogin() {
	if(isNaN($("#usuario").val())) {
		var email = /^[^@\s]+@[^@\s]+\.[^@\s]+$/;
		if(!email.test($("#usuario").val())) {
			alert("Não é um e-mail válido! Tente novamente");
			return false;
		}
	}
}