<%--
  Created by IntelliJ IDEA.
  User: Birthright
  Date: 10.10.2015
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Math</title>
</head>
<body>
<% String path = request.getPathInfo();
    String[] array = path.split("/");
    if (array.length == 3) {
        try {%>
<b>
    <%
        Integer number1 = Integer.parseInt(array[1]);
        Integer number2 = Integer.parseInt(array[2]);
        if (request.getRequestURL().toString().contains("add")) {%>
    <%=number1 + " + " + number2 + " = " + (number1 + number2)%>

    <% } else {%>
    <%=number1 + " * " + number2 + " = " + (number1 * number2)%>


    <%}%>
</b>

<% } catch (NumberFormatException e) {%>
</b>
<b>Incorrect numbers</b>
<% }
}
%>
</body>
</html>
