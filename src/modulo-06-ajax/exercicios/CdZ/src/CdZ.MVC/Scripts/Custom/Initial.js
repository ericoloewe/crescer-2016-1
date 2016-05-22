"use strict";

$(document)
    .ajaxSend(function() {
        $("#spinner").addClass("active");
    })
    .ajaxComplete(function() {
        $("#spinner").removeClass("active");
    })
    .ajaxError(function() {
        console.log("Tratador de erros genérico.", arguments);
    });

$.ajaxSetup({
    timeout: 2000
});

// créditos: http://stackoverflow.com/a/4673436
if (!String.format) {
    String.format = function (format) {
        var args = Array.prototype.slice.call(arguments, 1);
        return format.replace(/{(\d+)}/g, function (match, number) {
            return typeof args[number] != "undefined"
              ? args[number]
              : match
            ;
        });
    };
}