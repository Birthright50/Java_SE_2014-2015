<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Калькулятор транспортного налога</title>
    <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/login_style.css">
    <script src="/js/modernizr.js"></script>
    <script src="/js/jquery-2.1.4.js"></script>
    <script src="/js/main.js"></script>
    <script src="/js/hp_script.js"></script>
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
            <li class=""><a style=" font-size: small; align-items: center" href="/custom_calculator">Таможенный
                калькулятор</a></li>
            <li class=""><a style=" color: red; font-size: small;" href="/calculator_hp">Транспортный налог</a></li>
        </ul>
    </nav>
</div>
<div  style="width: 50%; margin-left: 25%" id="page-wrapper">

    <form method="post" class="form parent" role="form" id="nalog_form">
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
                                <option value="">Выберите регион регистрации ТС</option>
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
                            <label>Год выпуска</label>
                            <select class="form-control input" name="year">
                                <option value="no">Выберите год выпуска ТС...</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label>Мощность ЛС</label>
                            <input type="text" class="form-control" name="hp" id="hp">
                        </div>
                    </div>
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label>Мощность Квт</label>
                            <input type="text" class="form-control" name="kvt" id="kvt">
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
                    <div class="col-xs-6" id="itogo" style="display:none">
                        <div class="form-group">
                            <label>Итого</label>
                            <h4 style="font-size: 26px; margin-top: 0px;"><span class="label label-primary"
                                                                                id="price"></span></h4>
                        </div>
                    </div>

                </div>
            </div>
        </div>

    </form>
</div>
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