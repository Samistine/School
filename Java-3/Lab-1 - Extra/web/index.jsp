<%-- 
    Document   : index
    Created on : Jan 26, 2017, 3:53:45 PM
    Author     : Samuel
--%>
<!--
    http://stackoverflow.com/questions/31888566/bootstrap-how-to-sort-table-columns
-->

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
                background: white; /* fallback for old browsers */
                animation: example 4s infinite;
            }
            @keyframes example {
                0%   {background: #43C6AC;}
                33%  {background: #67B26F;}
                66%  {background: #44A08D;}
                100% {background: #43C6AC;}
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

        <main>
            <div class="site">
                <h2 class="subtitle">Welcome To Sam O' Bank</h2>
                <div class="pagination-centered" >
                    <div class="controls"><a href="login.jsp" style="width:80px" class="btn btn-danger">Enter</a></div>
                    <br/>
                    <div class="border"></div>
                </div>
            </div>
        </main>

    </body>
</html>