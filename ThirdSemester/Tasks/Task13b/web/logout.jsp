<%--
  Created by IntelliJ IDEA.
  User: Birthright
  Date: 09.10.2015
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
<% if (request.getMethod().length() == 3) {
    Cookie[] cookies = request.getCookies();
    Cookie logCookie = null;
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login")) {
                logCookie = cookie;
                break;
            }
        }
    }
    if (logCookie != null) {
        logCookie.setMaxAge(0);
        response.addCookie(logCookie);
    }
    request.getSession().invalidate();
    response.sendRedirect("/login");
}%>
</body>
</html>
