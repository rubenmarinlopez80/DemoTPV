$(function() {

	var viewpass = false;

	$(".view-pass").click(function() {
		if(viewpass == false) {
			$(this).toggleClass("not-view-pass");
			$(this).siblings('input').removeAttr("type", "password");
			$(this).siblings('input').prop("type", "text");
			viewpass = true;
		}
		else {
			$(this).toggleClass("not-view-pass");
			$(this).siblings('input').removeAttr("type", "text");
			$(this).siblings('input').prop("type", "password");
			viewpass = false;
		}
	});

});