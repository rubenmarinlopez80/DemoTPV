function asociarMostrarMensajeConfirmacion(){
    $('a[data-confirm]').click(function(ev) {
        var href = $(this).attr('href');
        
        if (!$('#dataConfirmModal').length) {
            $('body').append(
            	'<div id="dataConfirmModal" class="popup popup-close opened">'+
            		'<div class="popup-layout">'+
            			'<div class="popup-title">'+
            				'<h1>¿Estás seguro que quieres borrar el elemento?</h1>'+
            			'</div>'+
            			'<div class="divisor"></div>'+
	                	'<div class="popup-box">'+
	                		'<a data-bb-handler="confirm" type="button" class="popup-ok" style="color: white;" id="dataConfirmOK"><button>Aceptar</button></a>'+
		                	'<button data-bb-handler="cancel" type="button" id="cancelDelete" data-dismiss="modal" class="cancel popup-popup-cancel">Cancelar</button>'+
		                '</div>'+
               		'</div>'+
               	'</div>');
        }
        $('#dataConfirmModal').find('.popup-title>h1').text($(this).attr('data-confirm'));
        $('#dataConfirmOK').attr('href', href);
        $('#dataConfirmModal').modal({show:true});    
        return false;
    });
}


$(function() {
	asociarMostrarMensajeConfirmacion();
 });