$(document).ready(function () {
    let urlString = "http://localhost:8080/converter";
    const map = new Map();
    let value;
    let amount;
    let charCode;
    let nominal;
    let checked;

    $.ajax({
        url: urlString,
        method: "GET",
        success: function (responseJSON) {
            let currencyDropDown = $("#currency");
            $.each(responseJSON, function (index, currency) {
                $("<option>").val(currency.Value).text(currency.CharCode).appendTo(currencyDropDown)
                map.set(currency.CharCode, currency.Nominal);
            });
        }
    });

    $('#convert').click(function () {
        checked = $('#convertSetting').is(':checked');
        if (checked) {
            amount = $('#amountTo').val() * nominal;
            $.ajax({
                url: '/reverseConvert?amount=' + amount + '&value=' + value,
                method: 'POST',
                success: function (result) {
                    $('#amountIn').val(result);
                }
            });
        } else {
            amount = $('#amountIn').val() / nominal;
            $.ajax({
                url: '/convert?amount=' + amount + '&value=' + value,
                method: 'POST',
                success: function (result) {
                    $('#amountTo').val(result)
                }
            });
        }

    });

    $('#currency').change(function () {
        value = $(this).val();
        charCode = $(this).find('option:selected').text();
        nominal = map.get(charCode)
        $('#info').text("Номинал " + nominal + " " + charCode + " к рублю равен: " + value);
        $('#convert').css("display", "block");
        $('#currencyTag1').text(charCode);
    });

    $('#amountIn').bind('keyup paste', function () {
        this.value = this.value.replace(/[^0-9\.]/g, '');
    });
    $('#amountTo').bind('keyup paste', function () {
        this.value = this.value.replace(/[^0-9\.]/g, '');
    });
});