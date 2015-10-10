<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Birthright
  Date: 09.10.2015
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%! public static HashMap<String, String> map; %>
<%!
    public void jspInit() {
        map = new HashMap<>();
        map.put("Alex", "12345");
        map.put("Peter", "qwerty");
    }
%>
<% if (request.getMethod().length() == 4) {
    String login = request.getParameter("login");
    String password = request.getParameter("pwd");
    String checkbox = request.getParameter("checkbox");
    HttpSession httpSession = request.getSession();
    boolean containsKey = map.containsKey(login);
    if (containsKey && map.get(login).equals(password)) {
        if (checkbox != null) {
            Cookie loginCookie = new Cookie("login", login);
            loginCookie.setMaxAge(30 * 60);
            response.addCookie(loginCookie);
        }
        httpSession.setAttribute("login", login);
        response.sendRedirect("/profile");
    } else {
        if (containsKey && !map.get(login).equals(password)) {
            httpSession.setAttribute("error_msg", "Incorrect password");
        } else {
            httpSession.setAttribute("error_msg", "Incorrect login");
        }
        httpSession.setAttribute("name", login);
        response.sendRedirect("/login");
    }
} else {
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
    HttpSession httpSession = request.getSession();
    String login = (String) httpSession.getAttribute("login");
    String error = (String) httpSession.getAttribute("error_msg");
    String name = (String) httpSession.getAttribute("name");
    if (login != null || username != null) {
        response.sendRedirect("/profile");
    } else {%>
<font size="5" color="red"><% if (error != null) {%>
    <%=error%><%}%>
</font>

<form action="login.jsp" method="post">
    Login: <input type="text" name="login" value="<% if(name!=null) {%><%=name%><%}%>">
    <br>
    Password: <input type="password" name="pwd">
    <br>
    <input id="remember_me" type="checkbox" checked name="checkbox">
    <label for="remember_me">Remember me</label>
    <br>
    <input type="submit" value="Login">
</form>
<%

    }%>
<% }%>
</body>
</html>
