$(document).ready(function(){
   var string = document.location.pathname.replace('/AM_SEM2_2015/','');
   $('ul.nav > li > a[href="' + string + '"]').parent().addClass('active');
});