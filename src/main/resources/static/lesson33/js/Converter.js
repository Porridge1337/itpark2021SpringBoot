$(document).ready(function () {
    getCurrency();
    changeValue();
});

function getCurrency() {
    let urlString = "http://localhost:8080/converter";
    $.ajax({
        url: urlString,
        method: "GET",
        success: function (responseJSON) {
            let currencyDropDown = $("#currency");
            $.each(responseJSON, function (index, currency) {
                $("<option>").val(currency.Value).text(currency.CharCode).appendTo(currencyDropDown)
            });
        }
    });
}

function changeValue() {
    $('#currency').change(function () {
        let selected = $(this).val();
        $('#info').text("Номинал к рублю равен: " + selected);
    });
}

