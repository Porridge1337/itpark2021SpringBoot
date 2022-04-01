$(document).ready(function () {

    let id;

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
                id = this.id;
                $('#emp').append('<tr><td>' + id + '</td><td>' + this.name + '</td><td>' + this.balance + '</td><td>' +
                    '<input type="button" class="deleteAccount" value="delete"/>' + '</td><td>' +
                    '<input type="button" class="picAccountDeposit" value="deposit"/>' + '</td><td>' +
                    '<input type="button" class="picAccountWitdraw" value="witdraw"/>' + '</td></tr>'
                );
            });
        }
    });

    $(document).on('click', '.picAccountDeposit', function () {
        let currentRow = $(this).closest("tr");
        id = currentRow.find("td:eq(0)").html();
        $.ajax({
            url: '/client/' + id,
            type: 'GET',
            success: function (data) {
                $('#infoDeposit').text(" Баланс клиента: " + data.name + " равен " + data.balance);
                $('#deposit').css("display", "block");
                $('#withdraw').css("display", "none");
            }
        })
    });

    $(document).on('click', '.picAccountWitdraw', function () {
        let currentRow = $(this).closest("tr");
        id = currentRow.find("td:eq(0)").html();
        $.ajax({
            url: '/client/' + id,
            type: 'GET',
            success: function (data) {
                $('#infoWithdraw').text(" Баланс клиента: " + data.name + " равен " + data.balance);
                $('#withdraw').css("display", "block");
                $('#deposit').css("display", "none");
            }
        })
    });


    $(document).on('click', '#submitDeposit', function () {
        let depo = $('#depo').val();
        $.ajax({
            url: '/client/' + id + '/deposit?depo=' + depo,
            type: 'PATCH',
            success: function (data) {
                alert("Успешное пополнение аккаунта")
                location.reload();
            }
        })
    });

    $(document).on('click', '#submitWithdraw', function () {
        let withdr = $('#withdr').val();
        $.ajax({
            url: '/client/' + id + '/withdraw?withdr=' + withdr,
            type: 'PATCH',
            success: function (data) {
                alert("Успешное пополнение аккаунта")
                //location.reload();
            }
        })
    });

    $(document).on('click', '.deleteAccount', function () {
        let currentRow = $(this).closest("tr");
        let col1 = currentRow.find("td:eq(0)").html();

        $.ajax({
            url: '/client/' + col1 + '/deleteClient',
            type: 'DELETE',
            success: function () {
                alert('Удаление клиента c id = ' + col1 + ' прошло успешно');
                currentRow.fadeOut("fast");
            }
        })
    });

});
