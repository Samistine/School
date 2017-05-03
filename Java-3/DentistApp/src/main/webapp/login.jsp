<%-- 
    Document   : login
    Created on : Jan 26, 2017, 3:53:45 PM
    Author     : Samuel Seidel
--%>

<%@page import="com.samistine.school.java3.dentistapp.db.SQLQueries"%>
<%@page import="com.samistine.school.java3.dentistapp.data.users.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    login:
    {
        if (request.getParameter("login") != null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
                pageContext.setAttribute("status", "error");
                pageContext.setAttribute("errorMessage", "Username or Password was missing from your request");
                break login;
            }

            char userType = username.charAt(0);
            User user;

            if (userType == 'A') { //Patient
                user = SQLQueries.getPatient(username);
            } else { //Dentist
                if (userType != 'D') break login;
                user = SQLQueries.getDentist(username);
            }

            if (password.equals(user.getPassword())) {
                //Good Login
                session.setAttribute("user", user);
                response.sendRedirect("Home");
            }

        }
    }

%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="res/images/favicon.ico">

        <title>Dentist App | Login</title>
        <meta name="description" content="Dentist application login">


        <link href="res/bootstrap.v2/css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="res/bootstrap.v2/css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
        <link href="res/style.css" rel="stylesheet" type="text/css">

        <style>
            body {
                background: #DDEFBB; /* fallback for old browsers */
                background: linear-gradient(to left, #FFEEEE , #DDEFBB); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            }
            .logo {
                margin: 60px;
                margin-bottom: 0;
                position: relative;
                animation: SlideIn 1s 1;
            }

            .login-inputs {
                background: white;
                border-radius: 4px;
                background-color: #f4f5f3;
                border: 1px solid #e9ebe7;
            }
            .login-inputs input {
                height: 40px; width: 220px
            }
            .login-inputs .btn {
                width: 190px;
                height: 55px;
                background: #59d2ef;
                font-weight: 600;
                color: black;
                border: 0;
                text-shadow: none;
            }
            .status {
                margin: 0 auto 12px;
                width: 200px;
                text-align: center;
            }
        </style>
    </head>
    <body>

        <header>
            <div class="logo">
                <h1>
                    <a href="./"><img src="res/images/logo.svg" height="130" width="130" alt="Tooth (Logo)"></a>
                </h1>
                <div class="border"></div>
            </div>
        </header>

        <div class="site">
            <h2 class="subtitle">Log in to Dentist App</h2>

            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span4 offset4 login-inputs">
                        <br>

                        <c:choose>
                            <c:when test="${status eq 'error'}">
                                <div class="status alert alert-danger">
                                    <strong> <c:out value="${errorMessage}"/> </strong>
                                </div>
                            </c:when>
                            <c:when test="${status eq 'success'}">
                                <div class="status alert alert-success">
                                    <strong>Success!</strong> Correct Login!.
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="status alert alert-info">
                                    Enter your credentials
                                </div>
                            </c:otherwise>
                        </c:choose>

                        <form class="pagination-centered" method="POST" >
                            <div class="control-group">
                                <div class="controls">
                                    <input name="username" type="text" placeholder="Account ID" required="required" autofocus="true" title="Starts with a P for patients, D for dentists">
                                </div>
                            </div>

                            <div class="control-group">
                                <div class="controls">
                                    <input name="password" type="password" placeholder="Password" required="required">
                                </div>
                            </div>

                            <div class="control-group" >
                                <div class="controls">
                                    <button type="submit" name="login" class="btn">Login</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>