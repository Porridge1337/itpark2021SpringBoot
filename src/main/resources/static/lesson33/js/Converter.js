$(document).ready(function () {
    getCurrency();
});

function getCurrency() {
    let urlString = "http://localhost:8080/converter";
    $.ajax({
        url: urlString,
        method: "GET",
        success: function (responseJSON) {
            let currencyDropDown = $("#currency");
            const map = new Map();
            $.each(responseJSON, function (index, currency) {
                $("<option>").val(currency.Value).text(currency.CharCode).appendTo(currencyDropDown)
                console.log(currency.CharCode + " " + currency.Nominal);
                map.set(currency.CharCode, currency.Nominal);
            });
            changeValue(map);
        }
    });
}

function changeValue(arr) {
    $('#currency').change(function () {
        let selected = $(this).val();
        let text = $(this).find('option:selected').text();
        let nominal = arr.get(text)
        $('#info').text("Номинал " + nominal + " " + text + " к рублю равен: " + selected);

    });

}

