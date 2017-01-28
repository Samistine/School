<%-- 
    Document   : loginprocess
    Created on : Jan 27, 2017, 2:23:24 PM
    Author     : Samuel
--%>

<%@page import="com.samistine.school.java3.lab.auth.Result"%>
<%@page import="com.samistine.school.java3.lab.auth.Authenticate"%>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
        response.sendError(400, "No credentials were supplied");
    }

    Result result = Authenticate.login(username, password);
    if (result.failed()) {
        response.sendRedirect("./login.jsp?invalidCredentials");
    }

    if (result.succeeded()) {
        session.setAttribute("account", result.account());
        response.sendRedirect("./login.jsp?success");
    }

//    boolean status = LoginDao.validate(obj);
//    if (status) {
//        out.println("You r successfully logged in");
//        session.setAttribute("session", "TRUE");
//    } else {
//        out.print("Sorry, email or password error");
//    }
%>