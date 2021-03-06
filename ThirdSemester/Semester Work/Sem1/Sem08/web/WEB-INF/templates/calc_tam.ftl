<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Таможенный калькулятор</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
</head>
<body>

<div id="header"></div>
<div class="border-menu">
    <nav class="menu"
    >
        <ul style="padding-left: 15px; margin-left: -10px;">
            <li class=""><a href="/news">Новости</a></li>
            <li class=""><a href="/news">Купля-продажа</a></li>
            <li class=""><a href="/article">Статьи</a></li>
            <li class=""><a href="/catalog">Каталог</a></li>
            <li class=""><a href="/video">Видео</a></li>
            <li class=""><a href="/year_auto">Авто года</a></li>
            <li class=""><a style="color: red" href="/calc">Калькулятор</a></li>

        </ul>
    </nav>
</div>
<table style="margin-left: 68%">

    <tr>
        <td></td>
        <td>
            <button type="button" class="btn btn-default navbar-btn">Войти</button>
        </td>
        <td>
            <button type="button" class="btn btn-default navbar-btn">Регистрация</button>
        </td>
    </tr>
</table>
<div class="parent">
    <nav class="menu"
    >
        <ul style="padding-left: 15px; margin-left: 25%;">
            <li class=""><a style="color: red; font-size: small; align-items: center" href="/news">Таможенный
                калькулятор</a></li>
            <li class=""><a style=" font-size: small;" href="/news">Транспортный налог</a></li>
        </ul>
    </nav>
</div>
<div id="page-wrapper">

    <form method="get"   class="form parent" role="form" id="nalog_form">
        <div  class="panel panel-primary">
            <div class="panel-heading" >
                <h4 class="panel-title">
                    Ввод данных
                </h4>
            </div>
            <div class="panel-body">
                <div class="row">

                    <div class="col-xs-6">
                        <div class="form-group">
                            <label>Год выпуска</label>
                            <select class="form-control input" name="year">
                                <option value="no">Возраст машины...</option>
                                <option value="1">До 3-х лет</option>
                                <option value="2">3-5 лет</option>
                                <option value="3">Более 5 лет</option>

                            </select>
                        </div>
                    </div>
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label>Объем двигателя, в см<sup>3</sup></label>
                            <input type="number" maxlength="4" class="form-control" name="cm" id="cm">
                        </div>
                    </div>
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label>Стоимость ввозимого авто (В евро)</label>
                            <input type="number"  class="form-control" name="autoprice" id="autoprice">
                            <div align="center" style="parent"></div>
                        </div>
                    </div>


                </div>

                <div id="itogo">
                    <div align="center" class="form-group">
                        <button type="submit" class="btn btn-default navbar-btn ">Расчитать</button><br>
                        <label>Итого
                        <#if sum??><b>${ sum } RUB </b></#if></label>
                        <h4 style="font-size: 26px; margin-top: 0;"><span class="label label-primary"
                                                                          id="price"></span>
                        </h4>
                    </div>
                </div>

            </div>
        </div>
    </form>
</div>

<br/>


</body>
</html>