$(document).ready(function(){
	var isChrome = !!window.chrome && !isOpera;
	
	if(!isChrome){
		$("#navegador").val(false);
		$("#dtNascimentoCliente").mask('00/00/0000');
	}
});

function validarCadastro(){
	if($("#senhaCliente").val() != $("#confirmaCliente").val()){
		$("#alertaSenha").removeAttr("hidden");
		alert("Senhas não conferem! Os campos senha e confirmação de senha devem ser iguais!");
		return false;
	}
	
	return true
}
