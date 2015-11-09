<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Таможенный калькулятор</title>
    <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/css/login_style.css">
    <script src="/js/modernizr.js"></script>
    <script src="/js/jquery-2.1.4.js"></script>
    <script src="/js/main.js"></script>
    <script src="/js/custom_script.js"></script>
    <script src="/js/jquery.form.js"></script>
</head>
<body>

<div id="header"></div>
<div class="border-menu">
    <nav class="menu"
    >
        <ul style="padding-left: 15px; margin-left: 10%;">
            <li class=""><a href="/news">Новости</a></li>
            <li class=""><a href="/news">Купля-продажа</a></li>
            <li class=""><a href="/articles">Статьи</a></li>
            <li class=""><a href="/catalog">Каталог</a></li>
            <li class=""><a href="/videos">Видео</a></li>

            <li class=""><a style="color: red" href="/custom_calculator">Калькулятор</a></li>

        </ul>
    </nav>
</div>
<#if login??>
<nav class="main-nav" style="margin-right: 20%">
    <ul>

        <li><a class="cd-login" href="/profile">Профиль</a></li>
        <li><a class="cd-logout" href="/logout">Выход</a></li>
    </ul>
</nav>
<#else>

<nav id="main-nav" class="main-nav" style="margin-right: 20%">
    <ul>
        <li><a class="cd-signin" href="#0">Войти</a></li>
        <li><a class="cd-signup" href="#0">Зарегистрироваться</a></li>
    </ul>
</nav>
</#if>
<div class="parent">
    <nav class="menu"
    >
        <ul style="padding-left: 15px; margin-left: 25%;">
            <li class=""><a style="color: red; font-size: small; align-items: center" href="/custom_calculator">Таможенный
                калькулятор</a></li>
            <li class=""><a style=" font-size: small;" href="/calculator_hp">Транспортный налог</a></li>
        </ul>
    </nav>
</div>
<div  style="width: 50%; margin-left: 25%" id="page-wrapper">

    <form method="post" class="form parent" role="form" id="custom_form">
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
                            <input type="number" maxlength="5" class="form-control" name="cm" id="cm">
                        </div>
                    </div>
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label>Стоимость ввозимого авто (В евро)</label>
                            <input type="text"  class="form-control" name="autoprice_euro" id="autoprice_euro">
                            <div align="center" style="parent"></div>
                        </div>
                    </div>
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label>Стоимость ввозимого авто (В долларах)</label>
                            <input type="text"  class="form-control" name="autoprice_dollar" id="autoprice_dollar">
                            <div align="center" style="parent"></div>
                        </div>
                    </div>



                </div>

            </div>
            <div align="center" class="col-xs-6 parent" id="itogo" style="display:none; margin-left: 25%">
                <div class="form-group">
                    <label>Итого</label>
                    <h4 style="font-size: 26px; margin-top: 0px;"><span class="label label-primary"
                                                                        id="price"></span></h4>
                </div>
            </div>
        </div>
    </form>
</div>


<br/>

<div class="cd-user-modal"> <!-- this is the entire modal form, including the background -->
    <div class="cd-user-modal-container"> <!-- this is the container wrapper -->
        <ul class="cd-switcher">
            <li><a href="#0">Вход</a></li>
            <li><a href="#0">Новый аккаунт</a></li>
        </ul>

        <div id="cd-login"> <!-- log in form -->
            <form name="cd_form" action="/login" method="post" class="cd-form">
                <p class="fieldset">

                    <input name="input" class="full-width has-padding has-border" id="signin-email" type="text"
                           placeholder="Логин">
                </p>

                <p class="fieldset">

                    <input name="password" class="full-width has-padding has-border" id="signin-password" type="text"
                           placeholder="Пароль">
                    <a href="#0" class="hide-password">Hide</a>
                </p>

                <p class="fieldset">
                    <input name="checkbox[]" type="checkbox" id="remember-me" checked>
                    <label for="remember-me">Запоминть меня</label>
                </p>

                <p class="fieldset">
                    <input class="full-width" onclick="return login()" type="submit" value="Login">
                </p>
            </form>
            <script type="text/javascript">
                login = function (request, response) {
                    var input = $('#signin-email');
                    var password = $('#signin-password');
                    if (input.val().length > 0 && password.val().length > 0) {
                        $.ajax(
                                {
                                    url: "/login",
                                    data: {"input": input.val(), "password": password.val()},
                                    dataType: "json",
                                    success: function (resp) {
                                        switch (resp.results) {
                                            case "bad_pwd":
                                                alert("Incorrect password");
                                                return false;
                                                break;
                                            case "bad_login":
                                                alert("Incorrect login");
                                                return false;
                                                break;
                                            case "OK":
                                                return true;
                                        }

                                    }
                                }
                        )
                    }
                    else {
                        return false;
                    }

                }
            </script>


        </div> <!-- cd-login -->

        <div id="cd-signup"> <!-- sign up form -->
            <form action="/registration" method="post" class="cd-form">
                <p class="fieldset">
                    <label class="image-replace cd-username" for="signup-username">Логин</label>
                    <input name="input" class="full-width has-padding has-border" id="signup-username" type="text"
                           placeholder="Username">
                </p>

                <p class="fieldset">
                    <label class="image-replace cd-password" for="signup-password">Password</label>
                    <input name="password" class="full-width has-padding has-border" id="signup-password" type="text"
                           placeholder="Password">
                    <a href="#0" class="hide-password">Hide</a>

                </p>

                <p class="fieldset">
                    <label class="image-replace cd-email" for="signup-email">E-mail</label>
                    <input class="full-width has-padding has-border" id="signup-email" name="email" type="email"
                           placeholder="E-mail">

                </p>

                <p class="fieldset">
                    <label class="image-replace cd-username" for="region">Регион</label>
                    <input class="full-width has-padding has-border" name="region" id="region" type="text"
                           placeholder="Регион">
                </p>

                <p class="fieldset">
                    <label class="image-replace cd-username" for="car_mark">Марка авто</label>
                    <input class="full-width has-padding has-border" name="car_mark" id="car_mark" type="text"
                           placeholder="Марка авто">
                </p>

                <p class="fieldset">
                    <input placeholder="Имя" id="name[first]" class="full-width has-padding has-border"
                           type="text" size="8"
                           name="name[first]"/><span
                        class="icon-place"></span>
                    <input placeholder="Фамилия" class="full-width has-padding has-border"
                           id="name[last]"
                           type="text" size="14"
                           name="name[last]"/><span
                        class="icon-place"></span>

                </p>


                <p class="fieldset">
                    <label class="image-replace cd-username" for="name">Дата рождения</label>
                    <input class="full-width has-padding has-border" id="name"
                           data-format="yyyy-mm-dd"
                           type="date" name="date"
                           placeholder="Дата рождения"/>
                </p>

                <p class="fieldset">
                    <label class="image-replace cd-username" for="number">Стаж вождения</label>
                    <input class="full-width has-padding has-border" name="number" id="number" type="number" min="0"
                           max="100"
                           placeholder="Стад вождения (год)">
                </p>

                <p class="fieldset">

                    <select id="gender" class="full-width has-padding has-border" name="gender">
                        <option value="М">М</option>
                        <option value="Ж">Ж</option>
                    </select>
                </p>

                <p class="fieldset">
                    <input class="full-width has-padding" type="submit" onclick="return registration()"
                           value="Create account">
                </p>
            </form>

            <script type="text/javascript">
                registration = function (request, response) {
                    var input = $('#input');
                    var password = $('#password');
                    var email = $('#email');
                    var region = $('#region');
                    var car_mark = $('#car_mark');
                    var first_name = $('#name[first]');
                    var last_name = $('#name[last]');
                    var date = $('#date');
                    var number = $('#number');
                    var gender = $('gender');
                    if (input.val().length > 0 && password.val().length > 0 && email.val().length > 0 &&
                            region.val().length > 0 && car_mark.val().length > 0 && first_name.val().length > 0 &&
                            last_name.val().length > 0 && number.val().length > 0) {
                        $.ajax({
                                    url: "/registration",
                                    data: {"input": input.val()},
                                    dataType: "json",
                                    success: function (resp) {
                                        if (resp.results) {
                                            alert("Пользователь с таким логином уже зарегистрирован");
                                            return false;
                                        }
                                        return true;
                                    }
                                }
                        )
                    }
                    return false;

                }
            </script>
            <!-- <a href="#0" class="cd-close-form">Close</a> -->
        </div> <!-- cd-signup -->


    </div> <!-- cd-user-modal-container -->
</div>
</body>
</html>