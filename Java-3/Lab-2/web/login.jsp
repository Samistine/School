<%-- 
    Document   : login
    Created on : Jan 26, 2017, 3:53:45 PM
    Author     : Samuel Seidel
--%>

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
        </style>
    </head>
    <body>

        <header>
            <div class="logo">
                <h1>
                    <a href="./"><img src="res/images/safe.svg" height="130" width="130" alt="Safe (Logo)"></a>
                </h1>
                <div class="border"></div>
            </div>
        </header>

        <div class="site">
            <h2 class="subtitle">Log in to Sam o' Bank</h2>

            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span4 offset4 login-inputs">
                        <br>
                        <form class="pagination-centered" action="accountLookup.jsp" method="POST" >
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