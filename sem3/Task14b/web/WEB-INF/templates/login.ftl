<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<font size="5" color="red">
<#if error??>${error}</#if>
</font>

<form action="/login" method="post">
    Login: <input type="text" name="login" value="<#if name??>${name}</#if>">
    <br>
    Password: <input type="password" name="pwd">
    <br>
    <input id="remember_me" type="checkbox" checked name="checkbox">
    <label for="remember_me">Remember me</label><br>
    <input type="submit" value="Login">
</form>
</body>
</html>