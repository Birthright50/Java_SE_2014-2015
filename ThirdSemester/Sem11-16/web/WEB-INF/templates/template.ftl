<!DOCTYPE html>
<html>
<head>
    <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" type="text/css" href="/css/login_style.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <script src="/js/modernizr.js"></script>
    <script src="/js/jquery-2.1.4.js"></script>
    <script src="/js/main.js"></script>
    <meta charset="UTF-8">
    <title>Новости</title>
</head>
<body>

<div id="header"></div>
<div class="border-menu">
    <nav class="menu"
    >
        <ul style="padding-left: 15px; margin-left: 10%;">
            <li class=""><a <#if type==1>
                    style="color: red"
            </#if> href="/news">Новости</a></li>
            <li class=""><a href="/news">Купля-продажа</a></li>
            <li class=""><a <#if type==2>
                    style="color: red"
            </#if> href="/articles">Статьи</a></li>
            <li class=""><a href="/catalog">Каталог</a></li>
            <li class=""><a <#if type==3>
                    style="color: red"
            </#if> href="/videos">Видео</a></li>

            <li class=""><a href="/custom_calculator">Калькулятор</a></li>

        </ul>
    </nav>
</div>
<br/>

<#if type == 1>
    <#assign x = "news">
    <#assign y = "Новости">
<#elseif type == 2>
    <#assign x = "articles">
    <#assign y = "Статьи">
<#else>
    <#assign x = "videos">
    <#assign y = "Видео">
</#if>



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
<#if page??>
${page}
<div style="margin-left: 20%; width: 30%; margin-bottom: 10%" id="HCB_comment_box"><a
        href="http://www.htmlcommentbox.com">Comment Box</a>
    is loading comments...
</div>
<link rel="stylesheet" type="text/css"
      href="//www.htmlcommentbox.com/static/skins/bootstrap/twitter-bootstrap.css?v=0" property=""/>
<script type="text/javascript" id="hcb">
    if (!window.hcb_user) {
        hcb_user = {};
    }
    (function () {
        var s = document.createElement("script"), l = hcb_user.PAGE || ("" + window.location).replace(/'/g, "%27"), h = "//www.htmlcommentbox.com";
        s.setAttribute("type", "text/javascript");
        s.setAttribute("src", h + "/jread?page=" + encodeURIComponent(l).replace("+", "%2B") + "&opts=16862&num=10&ts=1446753268998");
        if (typeof s != "undefined") document.getElementsByTagName("head")[0].appendChild(s);
    })();
</script>

<#else>

<div class="row  block-sales nosubmenu">
    <div class="col-lg-12 col-xs-12 text-center">
        <div class="outline-header fix__b-outlune" style="padding-bottom:10px; padding-top:10px">
            <h1>${y}</h1>
            <div>
            </div>
        </div>
    </div>
</div>
    <#if login??>
    <a style="margin-left: 46.5%" id="btn" class="button" href="/add_template">Добавить</a>
    <br/><br/>
    </#if>
<table class="col-lg-12 col-xs-12 text-center parent" style="   margin-left:18%;  width: 65%">
    <#if list??>
        <#list list as templates>

            <#if templates?counter%3==1>
            <tr>
                <td>
                    <div>
                        <a style="text-decoration: none;"
                           href="/${x}/?id_${x}=${templates.getId()}">
                            <div>
                                <div>
                                    <img width="292" height="207" class="img-rounded"
                                         src="${templates.getUrl_image()}"
                                         alt="${templates.getName()}"></div>
                            </div>
                            <ol class="breadcrumb g-size-red">

                                <h2 class="post-title grid-title" style="text-decoration: none;">
                                ${templates.getName()}</h2>

                                <div class="comments grid-i">
                                    <i class="fa fa-eye"><span>${templates.getViews()}</span></i>

                                    <i style="float:right; margin-top: 4px;" class="fa fa-calendar"><span
                                            style="font-size: 9px; font-family: Arial, Helvetica, sans-serif;">${templates.getDate()}</span></i>
                                </div>
                            </ol>
                        </a>
                    </div>
                </td>
            </#if>
            <#if templates?counter%3==2>
                <td>
                    <div>
                        <a style="text-decoration: none;"
                           href="/${x}/?id_${x}=${templates.getId()}">
                            <div>
                                <div>
                                    <img width="292" height="207" class="img-rounded"
                                         src="${templates.getUrl_image()}"
                                         alt="${templates.getName()}"></div>
                            </div>
                            <ol class="breadcrumb g-size-red">

                                <h2 class="post-title grid-title" style="text-decoration: none;">
                                ${templates.getName()}</h2>

                                <div class="comments grid-i">
                                    <i class="fa fa-eye"><span>${templates.getViews()}</span></i>

                                    <i style="float:right; margin-top: 4px;" class="fa fa-calendar"><span
                                            style="font-size: 9px; font-family: Arial, Helvetica, sans-serif;">${templates.getDate()}</span></i>
                                </div>
                            </ol>
                        </a>
                    </div>
                </td>
            </#if>
            <#if templates?counter%3==0>
                <td>
                    <div>
                        <a style="text-decoration: none;"
                           href="/${x}/?id_${x}=${templates.getId()}">
                            <div>
                                <div>
                                    <img width="292" height="207" class="img-rounded"
                                         src="${templates.getUrl_image()}"
                                         alt="${templates.getName()}"></div>
                            </div>
                            <ol class="breadcrumb g-size-red">

                                <h2 class="post-title grid-title" style="text-decoration: none;">
                                ${templates.getName()}</h2>

                                <div class="comments grid-i">
                                    <i class="fa fa-eye"><span>${templates.getViews()}</span></i>

                                    <i style="float:right; margin-top: 4px;" class="fa fa-calendar"><span
                                            style="font-size: 9px; font-family: Arial, Helvetica, sans-serif;">${templates.getDate(  )}</span></i>
                                </div>
                            </ol>
                        </a>
                    </div>
                </td>
            </tr></#if>
        </#list>
    </#if>

</table>
<ul class="pagination parent">
    <#list 1..pages as i>
        <li><a href="/${x}/page/${i}">${i}<span class="sr-only">(current)</span></a></li>
    </#list>
</ul>
<ul class="pager">
    <li><a href="#">Предыдущая</a></li>
    <li><a href="#">Следующая</a></li>
</ul>
</#if>
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