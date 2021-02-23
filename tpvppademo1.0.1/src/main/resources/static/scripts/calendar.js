$(function () {
    $('#datepicker').datetimepicker({
        locale: 'es'
    });

    //campos fecha
    $('.date').datetimepicker({
        locale: 'es'
    });
    $('.date').datetimepicker({
        locale: 'es'
    });

     $("#datefrom").on("dp.change", function (e) {
         $('#dateto').data("DateTimePicker").minDate(e.date);
     });
    
     $("#dateto").on("dp.change", function (e) {
         $('#datefrom').data("DateTimePicker").maxDate(e.date);
     });
    
    
     //campos horas
     $('#datetimefrom').datetimepicker({
    	 locale: 'es'
	 });
    
     $('#datetimeto').datetimepicker({
         locale: 'es'
     });
    
     $("#datetimefrom").on("dp.change", function (e) {
         //$('#datetimefrom').data("DateTimePicker").minDate(e.date);
         //format: 'HH:mm'
     });
     $("#datetimeto").on("dp.change", function (e) {
         //$('#datetimefrom').data("DateTimePicker").maxDate(e.date);
         //format: 'HH:mm'
     });

});


