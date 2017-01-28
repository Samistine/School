<%-- 
    Document   : login
    Created on : Jan 26, 2017, 3:53:45 PM
    Author     : Samuel
--%>

<%@page import="com.samistine.school.java3.lab.auth.Authenticate"%>
<%@page import="com.samistine.school.java3.lab.auth.Result"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="res/images/favicon.ico">

        <title>Bank | Login</title>
        <meta name="description" content="The Sam o' Bank Login">


        <link href="res/bootstrap.v2/css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="res/bootstrap.v2/css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
        <link href="res/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <style>
            body {
                background: #FFEEEE; /* fallback for old browsers */
                background: -webkit-linear-gradient(to left, #FFEEEE , #DDEFBB); /* Chrome 10-25, Safari 5.1-6 */
                background: linear-gradient(to left, #FFEEEE , #DDEFBB); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            }
            .logo a{
                position: relative;
                animation: vaultSlideIn 1s 1;
            }
            @keyframes vaultSlideIn {
                0%   {left: -50vw; top: 0px;}
                25%  {left:  10vw; top: 0px;}
                50%  {left: -1vw;  top: 0px;}
                100% {left:  0vw;  top: 0px;}
            }

            .login-inputs {
                background: white;
                -webkit-border-radius: 4px;
                -moz-border-radius: 4px;
                border-radius: 4px;
            }
            .login-inputs a {
                color: #15406b;
                font-size: 10pt;
            }
            .login-inputs {
                background-color: #f4f5f3;
                border: 1px solid #e9ebe7;
            }
            .login-inputs .btn {
                width: 190px;
                height: 55px;
                background: #59d2ef;
                font-weight: 600;
                color: #000;
                border: 0;
                text-shadow: none;
            }
            .control-group .controls input {
                height: 40px; width: 220px
            }


        </style>
        <div class="logo">
            <h1>
                <a href="./">
                    <img src="res/images/safe.svg" height="130" width="130" alt="Safe (Logo)">
                </a>
            </h1>
            <div class="border"></div>
        </div>

        <div class="site">
            <h2 class="subtitle">Log in to Sam o' Bank</h2>



            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span4 offset4 login-inputs">
                        <br>
                        <form class="pagination-centered" action="loginprocess.jsp"  method="POST" >
                            <%
                                if (request.getParameter("invalidCredentials") != null) {
                                    out.println(""
                                            + "<div class=\" alert alert-danger\">"
                                            + "    <strong > Invalid Credentials! </strong >"
                                            + "</div >");
                                }

                                if (request.getParameter("success") != null) {
                                    out.println("<div class=\"alert alert-success\"><strong>Success!</strong> Indicates a successful or positive action.</div>");
                                }
                            %>

                            <div class="control-group">
                                <div class="controls">
                                    <input name="username" type="text" placeholder="Account ID or email address" required="required" autofocus="true">
                                </div>
                            </div>

                            <div class="control-group">
                                <div class="controls">
                                    <input name="password" type="password" placeholder="Password" required="required">
                                </div>
                            </div>

                            <div class="control-group" >
                                <div class="controls">
                                    <button type="submit" class="btn">Login</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>