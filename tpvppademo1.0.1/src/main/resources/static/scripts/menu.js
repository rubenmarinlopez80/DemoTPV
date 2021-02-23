$(function() {

// Función de despliegue de submenú al clic en los items <li> del menú nav:

	$("#nav-menu .menu-items .menu-layout ul li").click(function(){
		$(this).find(".submenu-items").css("display","block");
		$(this).find(".submenu-items").css("visibility","visible");
		$(this).find(".submenu-items").css("opacity","1");
		$(this).find(".submenu-items").css("transition", "0.2s all linear");
		
		
	});

// Función que recoge el submenú mediante over del ratón:
		//cuando se va del desplegable:
	$("#nav-menu .menu-items .menu-layout ul li .submenu-items").mouseleave(function(){		
		$(this).css("display", "none");
		$(this).css("visibility","hidden");
		$(this).css("opacity","0");
		$(this).css("transition", "0.2s all linear");
		
	});
		//cuando se va del <li> del nav:
	$("#nav-menu .menu-items .menu-layout ul li").mouseleave(function(){		
		$(this).find(".submenu-items").css("display", "none");
		$(this).find(".submenu-items").css("visibility","hidden");
		$(this).find(".submenu-items").css("opacity","0");
		$(this).find(".submenu-items").css("transition", "0.3s all linear");
		
	});

// Función de despliegue de sidemenú al clic en los items <li> del submenú .submenu-items:

	$("#nav-menu .menu-items .menu-layout ul li .submenu-items .submenu-layout ul li ").click(function(){
		$(this).find(".sidemenu-items").css("display","block");
		$(this).find(".sidemenu-items").css("visibility","visible");
		$(this).find(".sidemenu-items").css("opacity","1");
		$(this).find(".sidemenu-items").css("transition", "0.2s all linear");
		
	});

// Función que recoge el sidemenú al clic en los items <li> del menú lateral .sidemenu-items:

	$("#nav-menu .menu-items .menu-layout ul li .submenu-items .submenu-layout ul li .sidemenu-items").mouseleave(function(){
		$(this).css("display", "none");
		$(this).css("visibility","hidden");
		$(this).css("opacity","0");
		$(this).css("transition", "0.3s all linear");
		
	});
	
	$("#nav-menu .menu-items .menu-layout ul li .submenu-items").mouseleave(function(){
		$("#nav-menu .menu-items .menu-layout ul li .submenu-items .submenu-layout ul li .sidemenu-items").css("visibility","hidden");
		$("#nav-menu .menu-items .menu-layout ul li .submenu-items .submenu-layout ul li .sidemenu-items").css("opacity","0");

	});

///***  FUNCIONES PARA MENÚ MOVIL:
///***  Modificados de la original con clases nuevas:
		
		$("#mobile-menu").click(function(){
			$("#nav-menu .menu-items .menu-layout").find("li").removeClass("showed");
			$("#nav-menu .menu-items .menu-layout").find(".submenu-items").removeClass("showed");
			$("#nav-menu .menu-items .menu-layout").find("li").removeClass("opened");
			$("#nav-menu .menu-items .menu-layout").find(".submenu-items").removeClass("opened");
			$("#nav-menu").toggleClass("mobile-menu");
		});

		$("#mobile-close").click(function(){
			$("#nav-menu .menu-items .menu-layout").find("li").removeClass("showed");
			$("#nav-menu .menu-items .menu-layout").find(".menu-items").removeClass("showed");
			$("#nav-menu .menu-items .menu-layout").find("li").removeClass("opened");
			$("#nav-menu .menu-items .menu-layout").find(".menu-items").removeClass("opened");
			$("#nav-menu").toggleClass("mobile-menu");
		});

});



	

