/**
 * Created by Birthright on 08.11.2015.
 */
var dt = new Date();
var now_year = dt.getFullYear(); //получаем текущий год

$(document).ready(function () {

    var options = {
        url: "/calculator_hp",
        dataType: "json",
        timeout: 3000,
        success: show_answer
    };

    function show_answer(res) {
        $('#itogo').slideDown();
        $('#price').text(res.price);
    }

    $("#nalog_form").submit(function () {
        $(this).ajaxSubmit(options);
        return false;
    });
    //заполняем год выпуска авто
    var opt = '';
    for (var i = now_year; i >= 1970; i--) {
        opt += "<option value='" + i + "'>" + i + " г.в.</option>";
    }
    $("select[name='year']").append(opt);
    //проверка для мощности
    $("input[name='hp']").on("keyup", function () {
        this.value = this.value.replace(",", "."); // меняем запятую на точку
        this.value = this.value.replace(/[^\d\.]/g, ""); // запрет на ввод всего кроме цифр и запятой
        var pos = this.value.indexOf('.'); //проверяем, есть ли точка
        if (pos != -1) { //если точка есть
            if (this.value.match(/\./g).length > 1) { //проверяем, есть ли вторая точка
                this.value = this.value.substr(0, this.value.lastIndexOf(".")); //если есть, удаляем ее
            }
            if ((this.value.length - pos) > 3) { // проверяем, сколько знаков после запятой, если больше 2 то
                this.value = this.value.slice(0, -1); // удаляем лишнее
            }
        }
        var val = $('#hp').val() * 0.7355;
        var res = val.toFixed(2);
        $('#kvt').val(res);

        go_calc();
    });

    $("input[name='kvt']").on("keyup", function () {
        this.value = this.value.replace(",", "."); // меняем запятую на точку
        this.value = this.value.replace(/[^\d\.]/g, ""); // запрет на ввод всего кроме цифр и запятой
        var pos = this.value.indexOf('.'); //проверяем, есть ли точка
        if (pos != -1) { //если точка есть
            if (this.value.match(/\./g).length > 1) { //проверяем, есть ли втрая точка
                this.value = this.value.substr(0, this.value.lastIndexOf(".")); //если есть, удаляем ее
            }
            if ((this.value.length - pos) > 3) { // проверяем, сколько знаков после запятой, если больше 2 то
                this.value = this.value.slice(0, -1); // удаляем лишнее
            }
        }
        var val = $('#kvt').val() * 1.36;
        var res = val.toFixed(0);
        $('#hp').val(res);
        go_calc();
    });
    //на каждое изменение селекта вызов расчета
    $("select").on("change", go_calc);

    function go_calc() {
        if ($("select[name='period'] :selected").val() != 0 && $("select[name='region'] :selected").val() != 0 && $("select[name='year'] :selected").val() != 'no' && $("input[name='hp']").val() != '') {
            $("#nalog_form").submit();
        }

    }
});