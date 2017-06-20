/**
 * Created by dougllas.sousa on 20/06/2017.
 */

function maskQuantidade(selector) {
    $(selector).mask('000.000.000.000.000,000', {reverse: true});
}

function maskInteger(selector) {
    $(selector).mask('000000000', {reverse: true});
}

function maskMoney(selector) {
    $(selector).mask('000.000.000.000.000,00', {reverse: true});
}

function maskDate(selector) {
    $(selector).mask('00/00/0000');
}

function createDatePicker(selector) {
    $(selector).datepicker({
        calendarWeeks: true,
        todayHighlight: true,
        format: 'dd/mm/yyyy',
        autoclose: true,
        todayHighlight: true,
        toggleActive: true,
        language: 'pt-BR',
        weekStart : 0
    });
}

function createDialog(selector) {
    $(selector).dialog({
        modal : true,
        autoOpen: false
    });
}