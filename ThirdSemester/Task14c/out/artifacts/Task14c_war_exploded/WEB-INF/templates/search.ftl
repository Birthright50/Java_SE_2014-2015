<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search</title>
</head>
<body>
<form action="
<#if search?length==5>
      http://www.bing.com/search" method="get">
    <input type="text" placeholder="bing.com" name="q">
<#elseif search?length==4>
    http://search.aol.com/aol/search?" method="get">
    <input type="text" placeholder="aol.com" name="q">
<#elseif search=="/yahoo">
    https://search.yahoo.com/search" method="get">
    <input type="text" placeholder="yahoo.com" name="q">
<#elseif search=="/baidu">
    http://www.baidu.com/s" method="get">
    <input type="text" placeholder="baidu.com" name="q">
<#else>
    <b>Incorrect PATH</b>

</#if>"
    <input type="submit" value="Search"> </form>

</body>
</html>