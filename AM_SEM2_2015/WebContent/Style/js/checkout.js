/**
 * 
 */
$(document).ready(function(){
	$("#credito").click(function() {
	    if($(this).is(":checked")) // "this" refers to the element that fired the event
	    {
	    	var campos = "<input type='text' name='qtdParcelas'/>";
	    	$("#camposPagamento").html("Quantidade de parcelas:  "+ campos);
	    }
	});
	$("#debito").click(function() {
	    if($(this).is(":checked")) // "this" refers to the element that fired the event
	    {
	    	var campos = "<input type='text' name='qtdParcelas'/>";
	    	$("#camposPagamento").html("Quantidade de parcelas:  "+campos);
	    }
	});
	$("#cqVista").click(function() {
	    if($(this).is(":checked")) // "this" refers to the element that fired the event
	    {
	    	var campos = "<input type='text' name='nrBanco'/>";
	    	$("#camposPagamento").html("Numero do banco:  " + campos);
	    }
	});
	$("#cqParcelado").click(function() {
	    if($(this).is(":checked")) // "this" refers to the element that fired the event
	    {
	    	var campos = "Numero do banco:  <input type='text' name='nrBanco'/>\
	    			<br>Numero do cheque: <input type='text' name='nrCheque'/>\
	    			<br>Valor da parcela: <input type='text' name='vlrParcela'/>";
	    	
	    	$("#camposPagamento").html(campos);
	    }
	});
	$("#dinheiro").click(function() {
	    if($(this).is(":checked")) // "this" refers to the element that fired the event
	    {
	    		    	
	    	$("#camposPagamento").html('');
	    }
	});
});