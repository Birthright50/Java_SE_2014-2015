<%--
  Created by IntelliJ IDEA.
  User: Birthright
  Date: 09.10.2015
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<% if (request.getMethod().length() == 3) {
    HttpSession httpSession = request.getSession();
    String login = (String) httpSession.getAttribute("login");
    Cookie[] cookies = request.getCookies();
    Cookie username = null;
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login")) {
                username = cookie;
                break;
            }
        }
    }
    if (login != null || username != null) {
        if (login != null) {%>
<b>Hi, <%=" " + login%>
</b><br>

<% } else {%>
<b>Hi, <%=" " + username.getValue()%>
</b><br>


<% }%>
<a href="logout.jsp">Logout</a>

<% } else {
    response.sendRedirect("/login");
}
}%>
</body>
</html>
