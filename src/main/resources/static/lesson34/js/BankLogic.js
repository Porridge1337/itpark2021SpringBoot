$(document).ready(function () {

    $('#creat').click(function () {
        $.ajax({
            url: '/addClient',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: 'POST',
            data: JSON.stringify({
                'id': $('#id').val(),
                'name': $('#client').val(),
                'balance': $('#balance').val()
            }),
            success: function () {
                alert('Создание успешно!');
                location.reload(true);
            },
            error: function (xhr, status, error) {
                alert(xhr.responseJSON.error.message);
            }
        });
    });

    $.ajax({
        url: '/allClients',
        type: 'GET',
        dataType: 'JSON',
        success: function (data) {
            $.each(data, function () {
                $('#emp').append('<tr><td>' + this.id + '</td><td>' + this.name + '</td><td>' + this.balance)
            });
        }
    });

});