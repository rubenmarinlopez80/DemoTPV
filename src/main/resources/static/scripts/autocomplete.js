function initAutocompleteTable(id, action, loadData){
	var timer;
	$('#'+id).keyup(function () {
	clearTimeout(timer);
	timer = setTimeout(function (event) {
		var text = $('#'+id).val();
		autocompleteTableRefresh(id, text);
	}, 1000);
	});
	$('#'+id).data('header',null);
	$('#'+id).data('bodyData',null);
	$('#'+id).data('action', action);
	$('#'+id).data('loadData', loadData);
};

function autocompleteTableSelect(id, i){
	var bodyData = $('#'+id).data('bodyData');
	var action = $('#'+id).data('action');
	action(bodyData[i]);
	$('#'+id+'Table').hide();
};

function autocompleteTableRefresh(id, text){
	if(text == '')
		$('#'+id+'Table').hide();
	else {
		var loadData = $('#'+id).data('loadData');
		loadData(text);
	}
};

function autocompleteTableRefreshWhenLoaded(id){
	autocompleteTableRecreate(id);
	$('#'+id+'Table').show();
};

function autocompleteTableRecreate(id){
	var container = "<div class='table-float'>";
	var final = "</div>";
	var content = container + '<table id="'+id+'Table" class="table-layout" style="display:none">';
	var header = $('#'+id).data('header');
	var bodyData = $('#'+id).data('bodyData');
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
			content += '<td>' + item[keys[i]] + '</td>';
		}
		content += '</tr>';
	}
	content += "</tbody>"
	content += "</table>"
	content += final

	if($('#'+id+'Table').length){
		$('#'+id+'Table').remove();
	}
	$('#'+id).after(content);
};