<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Профиль</title>
    <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
</head>
<body>
<div id="header"></div>
<div class="border-menu"  >
    <nav class="menu"
    >
        <ul style="padding-left: 15px; margin-left: 10%;">
            <li class=""><a href="/news" >Новости</a></li>
            <li class=""><a href="/news">Купля-продажа</a></li>
            <li class=""><a href="/articles">Статьи</a></li>
            <li class=""><a href="/catalog">Каталог</a></li>
            <li class=""><a href="/videos">Видео</a></li>

            <li class=""><a href="/custom_calculator" >Калькулятор</a></li>

        </ul>
    </nav>
</div>
<br/>
<table style="margin-left: 75%">

    <tr>
        <td><button  type="button" class="btn btn-default navbar-btn">Выйти</button>
        </td>

    </tr>
</table>
<section class="row">
    <div class="col-lg-12 col-xs-12">
        <h3 class="text-center b__u-settings">Параметры аккаунта</h3>
    </div>

</section>
<br/>
<div class="container">
    <div class="row">

        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >


            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title"><#if login??>${login}</#if></h3>
                </div>
                <div class="panel-body">
                    <div class="row">

                        <div class=" col-md-9 col-lg-9 ">
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
                                    <td><#if region??>${region}</#if></td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td><a href="mailto:<#if email??>${email}</#if>"><#if email??>${email}</#if></a></td>
                                </tr>
                                <td>Марка авто</td>
                                <td><#if car_mark??>${car_mark}</#if><br>
                                </td>

                                </tr>

                                </tbody>
                            </table>

                            <a href="#" class="btn btn-primary">Редактировать</a>

                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>
</body>
</html>