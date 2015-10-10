<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
</head>
<body>
<#if login??>Hi, ${" "+ login}</#if><br>
<a href="/logout">Logout</a>
</body>
</html>