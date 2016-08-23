<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="/js/jquery-2.1.4.js"></script>
    <title>Купля-продажа</title>
    <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/css/dopstyle.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" type="text/css" href="/css/login_style.css">
    <script src="/js/modernizr.js"></script>

    <script src="/js/main.js"></script>


    <!-- Add mousewheel plugin (this is optional) -->
    <script type="text/javascript" src="/fancybox/lib/jquery.mousewheel-3.0.6.pack.js"></script>

    <!-- Add fancyBox -->
    <link rel="stylesheet" href="/fancybox/source/jquery.fancybox.css?v=2.1.5" type="text/css" media="screen"/>
    <script type="text/javascript" src="/fancybox/source/jquery.fancybox.pack.js?v=2.1.5"></script>

    <!-- Optionally add helpers - button, thumbnail and/or media -->
    <link rel="stylesheet" href="/fancybox/source/helpers/jquery.fancybox-buttons.css?v=1.0.5" type="text/css"
          media="screen"/>
    <script type="text/javascript" src="/fancybox/source/helpers/jquery.fancybox-buttons.js?v=1.0.5"></script>
    <script type="text/javascript" src="/fancybox/source/helpers/jquery.fancybox-media.js?v=1.0.6"></script>

    <link rel="stylesheet" href="/fancybox/source/helpers/jquery.fancybox-thumbs.css?v=1.0.7" type="text/css"
          media="screen"/>
    <script type="text/javascript" src="/fancybox/source/helpers/jquery.fancybox-thumbs.js?v=1.0.7"></script>

</head>
<body>

<div id="header"></div>
<div class="border-menu">
    <nav class="menu"
            >
        <ul style="padding-left: 15px; margin-left: 10%;">
            <li class=""><a href="/news">Новости</a></li>
            <li class=""><a style="color: red" href="/buy">Купля-продажа</a></li>
            <li class=""><a href="/articles">Статьи</a></li>
            <li class=""><a href="/catalog">Каталог</a></li>
            <li class=""><a href="/videos">Видео</a></li>
            <li class=""><a href="/custom_calculator">Калькулятор</a></li>

        </ul>
    </nav>
</div>
<br/>
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
<br><br><br><br><br><br><br><br><br><br>

<#if ad??>
<h2 align="center">${ad.getName()}, ${ad.getPrice()} руб.,  ${ad.getYear()}, ${ad.getProbeg()} км</h2>
<br>
<a style="margin-left: 15%" class="fancybox" rel="gallery1" href="${ad.getUrl_image_1()}.jpg">
    <img src="${ad.getUrl_image_1()}.png" alt=""/>
</a>
<a class="fancybox" rel="gallery1" href="${ad.getUrl_image_2()}.jpg">
    <img src="${ad.getUrl_image_2()}.png" alt=""/>
</a>
<a class="fancybox" rel="gallery1" href="${ad.getUrl_image_3()}.jpg">
    <img src="${ad.getUrl_image_3()}.png" alt=""/>
</a>
<a class="fancybox" rel="gallery1" href="${ad.getUrl_image_4()}.jpg">
    <img src="${ad.getUrl_image_4()}.png" alt=""/>
</a>
<a class="fancybox" rel="gallery1" href="${ad.getUrl_image_5()}.jpg">
    <img src="${ad.getUrl_image_5()}.png" alt=""/>
</a>
<br><br><br>
<script type="text/javascript">
    $(document).ready(function () {
        $(".fancybox").fancybox();
    });
</script>
<script type="text/javascript">
    $(document).ready(function () {
        $(".fancybox").fancybox({
            openEffect: 'none',
            closeEffect: 'none'
        });
    });
</script>
<h2 align="center">Описание автомобиля</h2>
<center>
    <div style="width:575px;">
        <p align="justify">
        ${ad.getText()}
        </p></div>
</center>

<#else>

<div class="row  block-sales nosubmenu">
    <div class="col-lg-12 col-xs-12 text-center">
        <div class="outline-header fix__b-outlune" style="padding-bottom:10px; padding-top:10px">
            <h1>Купля-продажа</h1>

            <div>
            </div>
        </div>
    </div>
</div>
    <#if login??>
    <a style="margin-left: 46.5%" id="btn" class="button" href="/add_ad">Добавить</a>
    <br/><br/>
    </#if>


<table class="col-lg-12 col-xs-12 text-center parent" style="   margin-left:18%;  width: 65%">
    <#if ads??>
        <#list ads as templates>

            <#if templates?counter%3==1>
            <tr>
                <td>
                    <div style="margin: 3%">
                        <a style="text-decoration: none;"
                           href="?id=${templates.getId()}">
                            <div>
                                <div>
                                    <img width="292" height="207" class="img-rounded"
                                         src="${templates.getUrl_image_1()}.jpg"
                                         alt="${templates.getName()}"></div>
                            </div>
                            <ol class="breadcrumb g-size-red">
                                <p class="post-title grid-title" style="text-decoration: none;">
                                ${templates.getYear()} год , ${templates.getProbeg()} км, ${templates.getPrice()} руб.
                                    , ${templates.getCity()}</p>
                            </ol>

                        </a>
                    </div>
                </td>
            </#if>
            <#if templates?counter%3==2>
                <td>
                    <div style="margin: 3%">
                        <a style="text-decoration: none;"
                           href="?id=${templates.getId()}">
                            <div>
                                <div>
                                    <img width="292" height="207" class="img-rounded"
                                         src="${templates.getUrl_image_1()}.jpg"
                                         alt="${templates.getName()}"></div>
                            </div>
                            <ol class="breadcrumb g-size-red">

                                <h2 class="post-title grid-title" style="text-decoration: none;">
                                ${templates.getName()}</h2>

                                <p class="post-title grid-title" style="text-decoration: none;">
                                ${templates.getYear()} , ${templates.getProbeg()} км, ${templates.getPrice()} руб.
                                    , ${templates.getCity()}</p>
                            </ol>
                        </a>
                    </div>
                </td>
            </#if>
            <#if templates?counter%3==0>
                <td>
                    <div style="margin: 3%">
                        <a style="text-decoration: none;"
                           href="?id=${templates.getId()}">
                            <div>
                                <div>
                                    <img width="292" height="207" class="img-rounded"
                                         src="${templates.getUrl_image_1()}.jpg"
                                         alt="${templates.getName()}"></div>
                            </div>
                            <ol class="breadcrumb g-size-red">

                                <h2 class="post-title grid-title" style="text-decoration: none;">
                                ${templates.getName()}</h2>

                                <p class="post-title grid-title" style="text-decoration: none;">
                                ${templates.getYear()} , ${templates.getProbeg()} км, ${templates.getPrice()} руб.
                                    , ${templates.getCity()}</p>
                            </ol>
                        </a>
                    </div>
                </td>
            </tr></#if>
        </#list>
    </#if>
</table>
</#if>


<div class="cd-user-modal"> <!-- this is the entire modal form, including the background -->
    <div class="cd-user-modal-container"> <!-- this is the container wrapper -->
        <ul class="cd-switcher">
            <li><a href="#0">Вход</a></li>
            <li><a href="#0">Новый аккаунт</a></li>
        </ul>


        <div id="cd-login"> <!-- log in form -->
            <form
                    name="cd_form" action="/login" method="post" class="cd-form">
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


        </div>
        <!-- cd-login -->

        <div id="cd-signup"> <!-- sign up form -->
            <form action="/registration" method="post" class="cd-form">
                <p class="fieldset">
                    <label class="image-replace cd-username" for="signup-username">Логин</label>
                    <input name="input" class="full-width has-padding has-border" id="signup-username" type="text"
                           placeholder="Username">
                </p>

                <p class="fieldset">
                    <label class="image-replace cd-password" for="signup-password">Пароль</label>
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
                    <input placeholder="Имя" id="name_first" class="full-width has-padding has-border"
                           type="text" size="8"
                           name="name[first]"/><span
                        class="icon-place"></span>
                    <input placeholder="Фамилия" class="full-width has-padding has-border"
                           id="name_last"
                           type="text" size="14"
                           name="name[last]"/><span
                        class="icon-place"></span>

                </p>


                <p class="fieldset">
                    <label class="image-replace cd-username" for="date">Дата рождения</label>
                    <input class="full-width has-padding has-border" id="date"
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
                    <label for="gender">Выберите пол </label><select id="gender"
                                                                     class="full-width has-padding has-border"
                                                                     name="gender">
                    <option value="М">М</option>
                    <option value="Ж">Ж</option>
                </select>
                </p>

                <p class="fieldset">
                    <input class="full-width has-padding" onclick="return registration()" type="submit"
                           value="Create account">
                </p>
            </form>

            <!-- <a href="#0" class="cd-close-form">Close</a> -->
        </div>
        <!-- cd-signup -->

    </div>
    <!-- cd-user-modal-container -->
</div>
<script type="text/javascript">

    function login() {
        var check_login = false;
        var input = $('#signin-email');
        var password = $('#signin-password');
        if (input.val().length > 0 && password.val().length > 0) {
            $.ajax(
                    {
                        url: "/login",
                        data: {"input": input.val(), "password": password.val()},
                        async: false,
                        dataType: "json",
                        success: function (resp) {
                            var results = resp.results;
                            switch (results) {
                                case "OK":
                                    check_login = true;
                                    break;
                                case "bad_pwd":
                                    alert("Incorrect password");
                                    check_login = false;
                                    break;
                                case "bad_login":
                                    alert("Incorrect login");
                                    check_login = false;
                                    break;
                            }
                        }

                    }
            );


            return check_login;
        }
        alert("Не введены данные");
        return check_login;
    }

    function registration() {
        var input = $('#signup-username');
        var password = $('#signup-password');
        var email = $('#signup-email');
        var region = $('#region');
        var car_mark = $('#car_mark');
        var first_name = $('#name_first');
        var last_name = $('#name_last');
        var date = $('#date');
        var number = $('#number');
        var gender = $('gender');
        var check_reg = false;
        if (input.val().length > 0 && password.val().length > 0 && email.val().length > 0 &&
                region.val().length > 0 && car_mark.val().length > 0 && first_name.val().length > 0 &&
                last_name.val().length > 0 && number.val().length > 0) {
            $.ajax({
                        url: "/registration",
                        timeout: 3000,
                        async: false,
                        data: {"input": input.val()},
                        dataType: "json",
                        success: function (resp) {
                            if (resp.results) {
                                alert("Пользователь с таким логином уже зарегистрирован");
                                check_reg = false;
                            }
                            else {
                                check_reg = true;
                            }
                        }
                    }
            );
            return check_reg;
        }
        alert("Введите все данные!")
        return check_reg;

    }
</script>

</body>
</html>