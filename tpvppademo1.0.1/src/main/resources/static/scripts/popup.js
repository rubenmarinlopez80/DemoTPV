$(function() {

	$(".btn-add").click(function(){
		$("body").toggleClass("opened");
		$(".popup-add").toggleClass("opened");
	});

	$(".btn-del").click(function(){
		$("body").toggleClass("opened");
		$(".popup-del").toggleClass("opened");
	});

	$(".btn-edit").click(function(){
		$("body").toggleClass("opened");
		$(".popup-edit").toggleClass("opened");
	});

	$(".btn-close").click(function(){
		$("body").removeClass("opened");
		$(".popup").removeClass("opened");
	});

});