<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First</title>
</head>
<body>
<table border="1">
    <tr>
        <td><b><h4>Student name</h4></b></td>
        <td><b><h4>Subject name</h4></b></td>
    </tr>
    <#if query??>
<#list query as objects>
    <tr>
        <#list objects as object>
        <td>${object}</td>
            </#list>
    </tr>
</#list>
    </#if>

</table>
</body>
</html>