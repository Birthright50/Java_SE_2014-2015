<!DOCTYPE html>
<html>
<head>
    <meta content="text/html" charset="UTF-8"/>
    <title>Регистрация</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body class="blurBg-false" style="background-color:#ebebeb">



<link rel="stylesheet" href="/registration_files/formoid1/formoid-solid-blue.css" type="text/css"/>
<script type="text/javascript" src="/registration_files/formoid1/jquery.min.js"></script>
<form action="/registration" class="formoid-solid-blue"
      style="background-color:#ffffff;font-size:14px;font-family:'Roboto',Arial,Helvetica,sans-serif;color:#34495E;max-width:480px;min-width:150px"
      method="post">
    <div class="title"><h2>Регистрация</h2></div>
    <div class="element-input"><label class="title"></label>
        <div align="center"><font size="5" color="red">
        <#if error??>${error}</#if>
        </font></div>
        <div class="item-cont"><input class="large" type="text" value="<#if name??>${name}</#if>" name="input" placeholder="Логин"/><span
                class="icon-place"></span></div>
    </div>
    <div class="element-password"><label class="title"></label>

        <div class="item-cont"><input class="large" type="password" name="password" value="" placeholder="Пароль"/><span
                class="icon-place"></span></div>
    </div>
    <div class="element-email"><label class="title"></label>

        <div class="item-cont"><input class="large" type="email" name="email" value="<#if email??>${email}</#if>" placeholder="Email"/><span
                class="icon-place"></span></div>
    </div>
    <div class="element-input"><label class="title"></label>

        <div class="item-cont"><input class="large" type="text" value="<#if region??>${region}</#if>" name="input1" placeholder="Регион проживания"/><span
                class="icon-place"></span></div>
    </div>
    <div class="element-input"><label class="title"></label>

        <div class="item-cont"><input class="large" type="text" value="<#if car_mark??>${car_mark}</#if>" name="input2" placeholder="Марка Авто"/><span
                class="icon-place"></span></div>
    </div>
    <div class="element-name"><label class="title"></label><span class="nameFirst"><input placeholder="Name First" value="<#if first_name??>${first_name}</#if>"
                                                                                          type="text" size="8"
                                                                                          name="name[first]"/><span
            class="icon-place"></span></span><span class="nameLast"><input placeholder="Name Last" value="<#if last_name??>${last_name}</#if>" type="text" size="14"
                                                                           name="name[last]"/><span
            class="icon-place"></span></span></div>
    <div class="element-date"><label class="title"></label>

        <div class="item-cont"><input class="large" value="<#if date??>${date}</#if>" data-format="yyyy-mm-dd" type="date" name="date"
                                      placeholder="Date"/><span class="icon-place"></span></div>
    </div>
    <div class="element-number"><label class="title"></label>

        <div class="item-cont"><input class="large" type="text" min="0" max="100" name="number"
                                      placeholder="Стад вождения (год)" value="<#if year_st??>${year_st}</#if>"/><span class="icon-place"></span></div>
    </div>
    <div class="element-select"><label class="title"></label>

        <div class="item-cont">
            <div class="large"><span><select name="select">
                <option value="М">М</option>
                <option value="Ж">Ж</option>
            </select><i></i><span class="icon-place"></span></span></div>
        </div>
    </div>
    <div class="submit"><input type="submit" value="Регистрация"/></div>
</form>
<p class="frmd"><a href="http://formoid.com/v29.php">contact form html</a> Formoid.com 2.9</p>
<script type="text/javascript" src="/registration_files/formoid1/formoid-solid-blue.js"></script>
<


</body>
</html>
