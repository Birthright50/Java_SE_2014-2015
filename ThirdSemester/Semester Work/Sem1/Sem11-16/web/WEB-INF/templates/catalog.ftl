<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Каталог авто</title>
    <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="/css/dopstyle.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" type="text/css" href="/css/login_style.css">
    <script src="/js/modernizr.js"></script>
    <script src="/js/jquery-2.1.4.js"></script>
    <script src="/js/main.js"></script>
    <script src="/js/login_registration.js"></script>

    <!-- Add mousewheel plugin (this is optional) -->
    <script type="text/javascript" src="/fancybox/lib/jquery.mousewheel-3.0.6.pack.js"></script>

    <!-- Add fancyBox -->
    <link rel="stylesheet" href="/fancybox/source/jquery.fancybox.css?v=2.1.5" type="text/css" media="screen" />
    <script type="text/javascript" src="/fancybox/source/jquery.fancybox.pack.js?v=2.1.5"></script>

    <!-- Optionally add helpers - button, thumbnail and/or media -->
    <link rel="stylesheet" href="/fancybox/source/helpers/jquery.fancybox-buttons.css?v=1.0.5" type="text/css" media="screen" />
    <script type="text/javascript" src="/fancybox/source/helpers/jquery.fancybox-buttons.js?v=1.0.5"></script>
    <script type="text/javascript" src="/fancybox/source/helpers/jquery.fancybox-media.js?v=1.0.6"></script>

    <link rel="stylesheet" href="/fancybox/source/helpers/jquery.fancybox-thumbs.css?v=1.0.7" type="text/css" media="screen" />
    <script type="text/javascript" src="/fancybox/source/helpers/jquery.fancybox-thumbs.js?v=1.0.7"></script>


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
            <li class=""><a style="color: red" href="/catalog">Каталог</a></li>
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
<br><br><br><br><br><br>

<#if type==1>
    <#if brands??>
    <div id="border">
        <h2 align="center" class="modern"><font color="#ff6600">Выберите марку автомобиля:</font></h2><br><br>
        <table style="margin-left: 22%" width="65%" align="center">
            <tbody>
            <tr valign="top">
                <td width="20%">
                    <ul class="cNav">
                        <#list brands as brand>
                            <#if brand?counter<42>
                                <li><a class="cat_link" href="${brand.getUrl()}">${brand.getName()}</a></li>
                            </#if>
                        </#list>
                    </ul>
                </td>
                <td width="10%">&nbsp;</td>
                <td width="20%">
                    <ul class="cNav">
                        <#list brands as brand>
                            <#if brand?counter<42>
                            <#elseif brand?counter<84>
                                <li><a class="cat_link" href="${brand.getUrl()}">${brand.getName()}</a></li>
                            </#if>
                        </#list>
                    </ul>
                </td>
                <td width="10%">&nbsp;</td>
                <td width="20%">
                    <ul class="cNav">
                        <#list brands as brand>
                            <#if brand?counter<84>
                            <#else>
                                <li><a class="cat_link" href="${brand.getUrl()}">${brand.getName()}</a></li>
                            </#if>

                        </#list>
                    </ul>
                </td>
                <td width="2%">&nbsp;</td>
            </tr>
            </tbody>
        </table>
    </div>
    </#if>
<#elseif type==2>
<table style="margin-left: 40%" class="cat_table" align="center">
    <thead>
    <tr>
        <th scope="col">Модель</th>
        <th scope="col">Год выпуска</th>
        <th scope="col">Кузов</th>
    </tr>
    </thead>
    <tbody valign="middle" align="center">
        <#if models??>
            <#list models as model>
                <#if model?counter%2==1>
                <tr style="background-color:#FFFFFF">
                    <td width="35%" style="font-size:11px;"><strong><a href="${model.getUrl()}" class="my_link"
                                                                       title="${model.getName_brand()} ${model.getName()}">${model.getName_brand()} ${model.getName()}</a></strong>
                    </td>
                    <td width="35%">${model.getYear()}</td>
                    <td width="30%">${model.getBody()}</td>
                </tr>
                <#else>
                <tr style="background-color:#F5F5F5">
                    <td width="35%" style="font-size:11px;"><strong><a href="${model.getUrl()}" class="my_link"
                                                                       title="${model.getName_brand()} ${model.getName()}">${model.getName_brand()} ${model.getName()}</a></strong>
                    </td>
                    <td width="35%">${model.getYear()}</td>
                    <td width="30%">${model.getBody()}</td>
                </tr>
                </#if>
            </#list>
        </#if>

    </tbody>
</table>
<#elseif type==3>
<h2 align="center">Модификации ${model.getName_brand()} ${model.getName()}</h2>
<a style="margin-left: 15%" class="fancybox" rel="gallery1" href="${model.getImage_url_1()}.jpg" >
    <img src="${model.getImage_url_1()}.png" alt="" />
</a>
<a class="fancybox" rel="gallery1" href="${model.getImage_url_2()}.jpg">
    <img src="${model.getImage_url_2()}.png" alt="" />
</a>
<a class="fancybox" rel="gallery1" href="${model.getImage_url_3()}.jpg" >
    <img src="${model.getImage_url_3()}.png" alt="" />
</a>
<a class="fancybox" rel="gallery1" href="${model.getImage_url_4()}.jpg" >
    <img src="${model.getImage_url_4()}.png" alt="" />
</a>
<a class="fancybox" rel="gallery1" href="${model.getImage_url_5()}.jpg" >
    <img src="${model.getImage_url_5()}.png" alt="" />
</a>
<br><br><br>
<script type="text/javascript">
    $(document).ready(function() {
        $(".fancybox").fancybox();
    });
</script>
<script type="text/javascript">
    $(document).ready(function() {
        $(".fancybox").fancybox({
            openEffect	: 'none',
            closeEffect	: 'none'
        });
    });
</script>
<table class="cat_table2" align="center" style="width: 90%;">
    <thead>
    <tr>
        <th scope="col">Модификация</th>
        <th scope="col">Цена</th>
        <th scope="col">Скорость</th>
        <th scope="col">Разгон</th>
        <th scope="col">Объем</th>
        <th scope="col">Мощность</th>
        <th scope="col">Расход</th>
    </tr>
    </thead>
    <tbody valign="middle" align="center">
        <#list submodels as submodel>
            <#if submodel?counter%2==1>
            <tr style="background-color:#FFFFFF">
                <td align="left" width="35%"><a href="${submodel.getUrl()}" class="my_link" title="${submodel.getName_brand()} ${submodel.getName()}">${submodel.getName_brand()} ${submodel.getName()}</a></td>
                <td align="left"  width="15%"><b>${submodel.getPrice()}</b></td>
                <td align="left" width="10%"><b>${submodel.getSpeed()}</b></td>
                <td align="left" width="10%"><b>${submodel.getAcceleration()}</b></td>
                <td align="left" width="10%"><b>${submodel.getYear()}</b></td>
                <td align="left" width="10%"><b>${submodel.getPower()}</b></td>
                <td align="left" width="10%"><b>${submodel.getFlowrate()}</b></td>
            </tr>
            <#else>
            <tr style="background-color:#F5F5F5">
                <td align="left" width="35%"><a href="${submodel.getUrl()}" class="my_link" title="${submodel.getName_brand()} ${submodel.getName()}">${submodel.getName_brand()} ${submodel.getName()}</a></td>
                <td align="left"  width="15%"><b>${submodel.getPrice()}</b></td>
                <td align="left" width="10%"><b>${submodel.getSpeed()}</b></td>
                <td align="left" width="10%"><b>${submodel.getAcceleration()}</b></td>
                <td align="left" width="10%"><b>${submodel.getYear()}</b></td>
                <td align="left" width="10%"><b>${submodel.getPower()}</b></td>
                <td align="left" width="10%"><b>${submodel.getFlowrate()}</b></td>
            </tr>
            </#if>

        </#list>


    </tbody>
</table>
<table cellpadding="1" cellspacing="2" width="575" align="center" border="0">
    <tbody>
    <tr>
        <td width="50%">
            <div style="font-size: 10px; padding-left: 5px;">
                * <b>Цена</b> - минимальная цена автомобиля в рублях<br>
                * <b>Скорость</b> - максимальная скорость в км/час<br>
                * <b>Разгон</b> - время разгона до 100 км/час в секундах<br></div>
        </td>
        <td width="50%">
            <div style="font-size: 10px; padding-left: 5px;">
                * <b>Объем</b> - рабочий объём двигателя в см³<br>
                * <b>Мощность</b> - в л.c. / при оборотах в минуту<br>
                * <b>Расход</b> - средний расход топлива в л на 100 км
            </div>
        </td>
    </tr>
    </tbody>
</table>
<br>

<h2 align="center">Обзор автомобиля ${model.getName_brand()} ${model.getName()}</h2>
<center>
    <div style="width:575px;">
        <p align="justify"><b>${model.getName_brand()} ${model.getName()}</b></p>

        <p align="justify">
            ${model.getText()}
        </p></div>
</center>
</#if>
<div class="cd-user-modal"> <!-- this is the entire modal form, including the background -->
    <div class="cd-user-modal-container"> <!-- this is the container wrapper -->
        <ul class="cd-switcher">
            <li><a href="#0">Вход</a></li>
            <li><a href="#0">Новый аккаунт</a></li>
        </ul>


        <div id="cd-login"> <!-- log in form -->
            <form onsubmit="return login()" name="cd_form" action="/login" method="post" class="cd-form">
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
                    <input class="full-width" type="submit" value="Login">
                </p>
            </form>


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


            <!-- <a href="#0" class="cd-close-form">Close</a> -->
        </div> <!-- cd-signup -->


    </div> <!-- cd-user-modal-container -->
</div>

</body>
</html>