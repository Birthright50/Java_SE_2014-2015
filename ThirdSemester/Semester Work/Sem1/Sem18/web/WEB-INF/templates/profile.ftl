<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Профиль</title>
    <script type="text/javascript" src="/js/jquery-2.1.4.js"></script>
    <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/css/login_style.css">
</head>
<body>
<div id="header"></div>
<div class="border-menu">
    <nav class="menu"
            >
        <ul style="padding-left: 15px; margin-left: 10%;">
            <li class=""><a href="/news">Новости</a></li>
            <li class=""><a href="/buy">Купля-продажа</a></li>
            <li class=""><a href="/articles">Статьи</a></li>
            <li class=""><a href="/catalog">Каталог</a></li>
            <li class=""><a href="/videos">Видео</a></li>

            <li class=""><a href="/custom_calculator">Калькулятор</a></li>

        </ul>
    </nav>
</div>
<br/>
<nav class="main-nav" style="margin-right: 20%">
    <ul>

        <li><a class="cd-login" href="/profile">Профиль</a></li>
        <li><a class="cd-logout" href="/logout">Выход</a></li>
    </ul>
</nav>
<section class="row">
    <div class="col-lg-12 col-xs-12">
        <h3 class="text-center b__u-settings">Параметры аккаунта</h3>
    </div>

</section>
<br/>

<div class="container">
    <div class="row">

        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">


            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title"><#if login??>${login}</#if></h3>
                </div>
                <div class="panel-body">
                    <div class="row">

                        <div class=" col-md-9 col-lg-9 ">
                            <form action="/profile" method="post">
                                <table class="table table-user-information">
                                    <tbody>
                                    <tr>
                                        <td>Логин:</td>
                                        <td><#if login??>${login}</#if></td>
                                    </tr>
                                    <tr>
                                        <td>Дата рождения:</td>
                                        <td><#if date??>${date}</#if></td>
                                    </tr>
                                    <tr>
                                        <td>Имя фамилия</td>
                                        <td><#if first_last_name??>${first_last_name}</#if></td>
                                    </tr>

                                    <tr>
                                    <tr>
                                        <td>Пол</td>
                                        <td><#if gender??>${gender}</#if></td>
                                    </tr>
                                    <tr>
                                        <td>Регион</td>
                                        <td><input name="region" id="region" type="text"
                                                   value="<#if region??>${region}</#if>"></td>

                                    </tr>
                                    <tr>
                                        <td>Email</td>
                                        <td><input name="email" id="email" type="email"
                                                   value="<#if email??>${email}</#if>"></td>
                                    </tr>
                                    <tr>
                                        <td>Стаж вождения</td>
                                        <td><input name="number" id="number" type="number" max="99"
                                                   value="<#if year??>${year}</#if>"></td>
                                    </tr>
                                    <tr>
                                        <td>Марка авто</td>
                                        <td><input name="car_mark" id="car_mark" type="text"
                                                   value="<#if car_mark??>${car_mark}</#if>"></td>
                                    </tr>
                                    <tr>
                                        <td>Новый пароль</td>
                                        <td><input name="pwd" id="pwd" type="password"></td>
                                    </tr>
                                    </tbody>
                                </table>
                                <input class="btn btn-primary" onclick="return edit()" type="submit"
                                       value="Редактировать">
                            </form>
                            <script type="text/javascript">
                                function edit() {
                                    var region = $('#region');
                                    var email = $('#email');
                                    var number = $('#number');
                                    var car_mark = $('#car_mark');
                                    var pwd = $('#pwd');
                                    if (region.val().length > 0 && email.val().length > 0 && number.val().length && car_mark.val().length > 0 && pwd.val().length > 0) {
                                        return true;
                                    }
                                    alert("Введите все данные!");
                                    return false;
                                }
                            </script>

                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>
</body>
</html>