$(function() {

    $('#comboboxes-right').click(function (e) {
        var selectedOpts = $('#lstBox1 option:selected');
        if (selectedOpts.length == 0) {
            alert("Seleccione al menos un elemento para mover.");
            e.preventDefault();
        }
        $('#lstBox2').append($(selectedOpts).clone());
        $(selectedOpts).remove();
        e.preventDefault();
    });

    $('#comboboxes-all-right').click(function (e) {
        var selectedOpts = $('#lstBox1 option');
        if (selectedOpts.length == 0) {
            alert("Seleccione al menos un elemento para mover.");
            e.preventDefault();
        }
        $('#lstBox2').append($(selectedOpts).clone());
        $(selectedOpts).remove();
        e.preventDefault();
    });

    $('#comboboxes-left').click(function (e) {
        var selectedOpts = $('#lstBox2 option:selected');
        if (selectedOpts.length == 0) {
            alert("Seleccione al menos un elemento para mover.");
            e.preventDefault();
        }
        $('#lstBox1').append($(selectedOpts).clone());
        $(selectedOpts).remove();
        e.preventDefault();
    });

    $('#comboboxes-all-left').click(function (e) {
        var selectedOpts = $('#lstBox2 option');
        if (selectedOpts.length == 0) {
            alert("Seleccione al menos un elemento para mover.");
            e.preventDefault();
        }
        $('#lstBox1').append($(selectedOpts).clone());
        $(selectedOpts).remove();
        e.preventDefault();
    });

});