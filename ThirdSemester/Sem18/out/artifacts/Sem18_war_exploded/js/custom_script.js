/**
 * Created by Birthright on 08.11.2015.
 */
$(document).ready(function () {
    var options = {
        url: "/custom_calculator",
        dataType: "json",
        timeout: 3000,
        success: show_answer
    };

    function show_answer(res) {
        $('#itogo').slideDown();
        $('#price').text(res.price);
    }

    $("#custom_form").submit(function () {
        $(this).ajaxSubmit(options);
        return false;
    });
    $("input[name='autoprice_euro']").on("keyup", function () {
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
        var val = $('#autoprice_euro').val() * 1.0742;
        var res = val.toFixed(2);
        $('#autoprice_dollar').val(res);
        go_calc();
    });
    $("input[name='autoprice_dollar']").on("keyup", function () {
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
        var val = $('#autoprice_dollar').val() * 0.93092534;
        var res = val.toFixed(0);
        $('#autoprice_euro').val(res);
        go_calc();
    });
    $("input[name='cm']").on("keyup", function () {
        this.value = this.value.replace(/[^\d]/g, "");
        if(this.value.length>5){
            this.value = this.value.slice(0, -1);
        }
        go_calc();
    });
    //на каждое изменение селекта вызов расчета
    $("select").on("change", go_calc);
    function go_calc() {
        if ($("select[name='year'] :selected").val() != 'no' && $("input[name='autoprice_euro']").val() != '' && $("input[name='cm']").val() != '') {
            $("#custom_form").submit();
        }

    }

});
