<!DOCTYPE html>
<html>
<head>
    <meta content="text/html" charset="utf-8"/>
    <title>Форма входа</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body class="blurBg-false" style="background-color:#EBEBEB">

<link rel="stylesheet" href="/login_files/formoid1/formoid-solid-blue.css" type="text/css"/>
<script type="text/javascript" src="/login_files/formoid1/jquery.min.js"></script>
<form action="/login" class="formoid-solid-blue"
      style="background-color:#FFFFFF;font-size:14px;font-family:Georgia,serif;color:#34495E;max-width:480px;min-width:150px"
      method="post">
    <div class="title"><h2>Форма входа</h2></div>
    <div align="center"><font size="5" color="red">
    <#if error??>${error}</#if>
    </font></div>
    <div class="element-input"><label class="title"></label>

        <div class="item-cont"><input class="large" type="text" name="input" value="<#if name??>${name}</#if>"
                                      placeholder="Логин"/><span
                class="icon-place"></span></div>
    </div>
    <div class="element-password"><label class="title"></label>

        <div class="item-cont"><input class="large" type="password" name="password" value="" placeholder="Пароль"/><span
                class="icon-place"></span></div>
    </div>
    <div class="element-checkbox"><label class="title"></label>

        <div class="column column1"><label><input type="checkbox" name="checkbox[]" value="Запомнить меня"/ ><span>Запомнить меня</span></label>
        </div>
        <span class="clearfix"></span>
    </div>
    <div class="submit"><input type="submit" value="Войти"/></div>
</form>
<p class="frmd"><a href="http://formoid.com/v29.php">contact form html</a> Formoid.com 2.9</p>
<script type="text/javascript" src="/login_files/formoid1/formoid-solid-blue.js"></script>


</body>
</html>
