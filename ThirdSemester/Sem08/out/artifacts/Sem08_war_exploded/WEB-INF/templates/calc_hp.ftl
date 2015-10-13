<!DOCTYPE html>
Content-Type: text/html;charset=utf-8
<html lang="en">
<head>

    <meta charset="UTF-8">
    <title>Калькулятор транспортного налога</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
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
            <li class=""><a style=" font-size: small; align-items: center" href="/news">Таможенный
                калькулятор</a></li>
            <li class=""><a style=" color: red; font-size: small;" href="/news">Транспортный налог</a></li>
        </ul>
    </nav>
</div>
<div id="page-wrapper">

    <form method="get" class="form parent" role="form" id="nalog_form">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h4 class="panel-title">
                    Ввод данных
                </h4>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label>Регион</label>
                            <select class="form-control input" name="region">
                                <option value="no">Выберите регион регистрации ТС</option>
                                <option value="1">Алтайский край</option>
                                <option value="2">Амурская область</option>
                                <option value="3">Архангельская область</option>
                                <option value="4">Астраханская область</option>
                                <option value="5">Белгородская область</option>
                                <option value="6">Брянская область</option>
                                <option value="7">Владимирская область</option>
                                <option value="8">Волгоградская область</option>
                                <option value="9">Вологодская область</option>
                                <option value="10">Воронежская область</option>
                                <option value="11">Еврейская АО</option>
                                <option value="12">Забайкальский край</option>
                                <option value="13">Ивановская область</option>
                                <option value="14">Иркутская область</option>
                                <option value="15">Кабардино-Балкария</option>
                                <option value="16">Калининградская область</option>
                                <option value="17">Калужская область</option>
                                <option value="18">Камчатский край</option>
                                <option value="19">Карачаево-Черкессия</option>
                                <option value="20">Кемеровская область</option>
                                <option value="21">Кировская область</option>
                                <option value="22">Костромская область</option>
                                <option value="23">Краснодарский край</option>
                                <option value="24">Красноярский край</option>
                                <option value="25">Курганская область</option>
                                <option value="26">Курская область</option>
                                <option value="27">Ленинградская область</option>
                                <option value="28">Липецкая область</option>
                                <option value="29">Магаданская область</option>
                                <option value="30">Москва</option>
                                <option value="31">Московская область</option>
                                <option value="32">Мурманская область</option>
                                <option value="33">Ненецкий АО</option>
                                <option value="34">Нижегородская область</option>
                                <option value="35">Новгородская область</option>
                                <option value="36">Новосибирская область</option>
                                <option value="37">Омская область</option>
                                <option value="38">Оренбургская область</option>
                                <option value="39">Орловская область</option>
                                <option value="40">Пензенская область</option>
                                <option value="41">Пермский край</option>
                                <option value="42">Приморский край</option>
                                <option value="43">Псковская область</option>
                                <option value="44">Республика Адыгея</option>
                                <option value="45">Республика Алтай</option>
                                <option value="46">Республика Башкортостан</option>
                                <option value="47">Республика Бурятия</option>
                                <option value="48">Республика Дагестан</option>
                                <option value="49">Республика Ингушетия</option>
                                <option value="50">Республика Калмыкия</option>
                                <option value="51">Республика Карелия</option>
                                <option value="52">Республика Коми</option>
                                <option value="53">Республика Крым</option>
                                <option value="54">Республика Марий Эл</option>
                                <option value="55">Республика Мордовия</option>
                                <option value="56">Республика Мордовия</option>
                                <option value="57">Республика Саха (Якутия)</option>
                                <option value="58">Республика Северная Осетия</option>
                                <option value="59">Республика Татарстан</option>
                                <option value="60">Республика Тыва</option>
                                <option value="61">Республика Хакасия</option>
                                <option value="62">Ростовская область</option>
                                <option value="63">Ростовская область</option>
                                <option value="64">Рязанская область</option>
                                <option value="65">Самарская область</option>
                                <option value="66">Санкт-Петербург</option>
                                <option value="67">Саратовская область</option>
                                <option value="68">Сахалинская область</option>
                                <option value="69">Сахалинская область</option>
                                <option value="70">Свердловская область</option>
                                <option value="71">Севастополь</option>
                                <option value="72">Смоленская область</option>
                                <option value="73">Ставропольский край</option>
                                <option value="74">Тамбовская область</option>
                                <option value="75">Тверская область</option>
                                <option value="76">Томская область</option>
                                <option value="77">Тульская область</option>
                                <option value="78">Тюменская область</option>
                                <option value="79">Ульяновская область</option>
                                <option value="80">Хабаровский край</option>
                                <option value="81">Ханты-Мансийский АО</option>
                                <option value="82">Челябинская область</option>
                                <option value="83">Чеченская Республика</option>
                                <option value="84">Чувашская Республика</option>
                                <option value="85">Чукотский АО</option>
                                <option value="86">Ямало-Ненецкий АО</option>
                                <option value="87">Ярославская область</option>
                            </select>
                        </div>
                    </div>

                    <div class="col-xs-6">
                        <div class="form-group">
                            <label>Мощность ЛС</label>
                            <input type="number" class="form-control" name="hp" id="hp">
                        </div>
                    </div>

                    <div class="col-xs-6">
                        <div class="form-group">
                            <label>Рассчитать за период</label>
                            <select class="form-control input" name="period">
                                <option value="0">Выберите...</option>
                                <option value="12">1 год</option>
                                <option value="11">11 мес.</option>
                                <option value="10">10 мес.</option>
                                <option value="9">9 мес.</option>
                                <option value="8">8 мес.</option>
                                <option value="7">7 мес.</option>
                                <option value="6">6 мес.</option>
                                <option value="5">5 мес.</option>
                                <option value="4">4 мес.</option>
                                <option value="3">3 мес.</option>
                                <option value="2">2 мес.</option>
                                <option value="1">1 мес.</option>
                            </select>
                        </div>
                    </div>



                </div>
                <div id="itogo">
                    <div align="center" class="form-group">
                        <button type="submit" class="btn btn-default navbar-btn ">Расчитать</button>
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
</body>
</html>