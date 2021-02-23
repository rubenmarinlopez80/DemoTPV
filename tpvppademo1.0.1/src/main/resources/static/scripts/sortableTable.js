var entradaId = [];
var entradaTexto = [];
var salidaId = [];
var salidaTexto = [];

function dragStart(event) {
	event.dataTransfer.setData("Text", event.target.id);

	var a = event.target.id;
	var b = document.getElementById(a).childNodes;
	
	for (i=0; i<b.length; i++) {
		if (i%2 != 0) {
			b[i].setAttribute("id", "entrada-" + i);
		}
	}
	
	for (i=0; i<b.length; i++) {
		if (b[i].id != null) {
			entradaId.push(b[i].id);
		}
	}
	for (i=0; i<b.length; i++) {
		if (b[i].id != null) {
			entradaTexto.push(b[i].textContent);
		}
	}
	
	for (i=0; i<b.length; i++) {
		if (i%2 != 0) {
			b[i].classList.add("highlight");
		}
	}
}

function allowDrop(event) {
	event.preventDefault();
}

function drop(event) {
	event.preventDefault();
	
	var data = event.dataTransfer.getData("Text");
	var c = event.srcElement.parentNode.id;
	var d = document.getElementById(c).childNodes;
	
	for (i=0; i<d.length; i++) {
		if (i%2 != 0) {
			d[i].setAttribute("id", "salida-" + i);
		}
	}
	
	for (i=0; i<d.length; i++) {
		if (d[i].id != null) {
			salidaId.push(d[i].id);
		}
	}
	for (i=0; i<d.length; i++) {
		if (d[i].id != null) {
			salidaTexto.push(d[i].textContent);
		}
	}
	
	for (i=0; i<entradaId.length; i++) {
		if (!document.getElementById(entradaId[i])) {
			document.getElementById(salidaId[i]).classList.remove("highlight");
		} else {
			document.getElementById(entradaId[i]).classList.remove("highlight");
		}
	}
	
	if (entradaId.length == entradaId.length) {
		for (i=0; i<entradaId.length; i++) {
			if (document.getElementById(entradaId[i]) != null && document.getElementById(salidaId[i]) != null) {
				document.getElementById(salidaId[i]).innerHTML = entradaTexto[i];
				document.getElementById(entradaId[i]).innerHTML = salidaTexto[i];
			}
		}
	}
	
	for (i=0; i<d.length; i++) {
		if (document.getElementById(entradaId[i]) != null && document.getElementById(salidaId[i]) != null) {
			document.getElementById(entradaId[i]).removeAttribute("id");
			document.getElementById(salidaId[i]).removeAttribute("id");
		}
	}
}