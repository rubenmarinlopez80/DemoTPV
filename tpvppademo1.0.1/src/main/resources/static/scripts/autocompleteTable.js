function autocompleteTableInit(id, action, loadData){
	var timer;
	$('input[id="'+id+'"]').keyup(function () {
	clearTimeout(timer);
	timer = setTimeout(function (event) {
		var text = $('input[id="'+id+'"]').val();
		autocompleteTableRefresh(id, text);
	}, 1000);
	});
	$('input[id="'+id+'"]').data('header',null);
	$('input[id="'+id+'"]').data('bodyData',null);
	$('input[id="'+id+'"]').data('action', action);
	$('input[id="'+id+'"]').data('loadData', loadData);
};
function autocompleteTableSelect(id, i){
	var bodyData = $('input[id="'+id+'"]').data('bodyData');
	var action = $('input[id="'+id+'"]').data('action');
	action(bodyData[i], id);
};

function autocompleteTableSelectWhenLoaded(id){
	$('table[id="'+id+'Table"]').hide();
};

function autocompleteTableRefresh(id, text){
	if(text == '')
		$('table[id="'+id+'Table"]').hide();
	else {
		var loadData = $('input[id="'+id+'"]').data('loadData');
		loadData(text, id);
	}
};

function autocompleteTableRefreshWhenLoaded(id){
	autocompleteTableRecreate(id);
	if($('input[id="'+id+'"]').data('bodyData').length > 0){
		$('table[id="'+id+'Table"]').show();
	}
};
function autocompleteTableRecreate(id){
	var container = "<div class='table-float'>";
	var final = "</div>";
	var content = container + '<table id="'+id+'Table" class="table-layout" style="display:none">';
	var header = $('input[id="'+id+'"]').data('header');
	var bodyData = $('input[id="'+id+'"]').data('bodyData');
	content += '<thead><tr>';
	for(var i = 0; i < header.length; i ++) {
		content+= "<th>"+header[i]+"</th>";
	};
	content += '</tr></thead>';
	content += '<tbody>';
	for(var i = 0; i < bodyData.length; i++){
		var item = bodyData[i];
		var keys = Object.keys(item);
		content += '<tr onclick=autocompleteTableSelect("'+id+'",'+i+')>';
		for(j=0; j < keys.length; j++){
			content += '<td>' + item[keys[j]] + '</td>';
		}
		content += '</tr>';
	}
	content += "</tbody>";
	content += "</table>";
	content += final;

	if($('table[id="'+id+'Table"]').length){
		$('table[id="'+id+'Table"]').parent().remove();
	}
	$('input[id="'+id+'"]').after(content);
};

function autocompleteTableSetHeader(id, header) {
	$('input[id="'+id+'"]').data('header', header);
};

function autocompleteTableSetBody(id, body) {
	$('input[id="'+id+'"]').data('bodyData', body);
};
