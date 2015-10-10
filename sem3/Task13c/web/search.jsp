<%--
  Created by IntelliJ IDEA.
  User: Birthright
  Date: 10.10.2015
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Searcj</title>
</head>
<body>
<%   String path = request.getPathInfo();%>
<form action="

   <% if (path.length() == 5) {%>
   http://www.bing.com/search" method="get">
      <input type="text" placeholder="bing.com" name="q">

    <%} else {
        if (path.length() == 4) {%>
    http://search.aol.com/aol/search?" method="get">
    <input type="text" placeholder="aol.com" name="q">


       <% } else {
            if (path.equals("/yahoo")) {%>
    https://search.yahoo.com/search" method="get">
    <input type="text" placeholder="yahoo.com" name="q">

            <%} else {
                if (path.equals("/baidu")) {%>
    http://www.baidu.com/s" method="get">
    <input type="text" placeholder="baidu.com" name="q">

                <%} else {%>
    <b>Incorrect PATH</b>


                  <%
                }
            }
        }
    }
    %>
    <input type="submit" value="Search"> </form>

</body>
</html>
