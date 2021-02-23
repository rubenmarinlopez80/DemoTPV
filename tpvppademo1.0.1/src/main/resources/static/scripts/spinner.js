$(function() {

	$("#loading").click(function(){

		$(".loading").toggleClass("opened");
		$("body").toggleClass("opened");

	});

	$('#loading-select').on('change', function() {
		var loadtype = $( "#loading-select option:checked").val();
		$("#loading").addClass("enabled");

		if (loadtype=="wheel") {
			$(".loading").addClass("wheel");
			$(".loading").removeClass("wind");
			$(".loading").removeClass("line");
		}

		if (loadtype=="wind") {
			$(".loading").addClass("wind");
			$(".loading").removeClass("wheel");
			$(".loading").removeClass("line");
		}

		if (loadtype=="line") {
			$(".loading").addClass("line");
			$(".loading").removeClass("wheel");
			$(".loading").removeClass("wind");
		}
		console.log(texto);
	})

	$( "#myselect option:selected" ).text();

});