<%-- 
    Document   : UserInput
    Created on : Feb 3, 2017, 2:57:27 PM
    Author     : Samuel Seidel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="res/images/favicon.ico">

        <title>Bank | User Input - Age and Salary</title>
        <meta name="description" content="Age and salary demo">


        <link href="res/bootstrap.v2/css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="res/bootstrap.v2/css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
        <link href="res/style.css" rel="stylesheet" type="text/css">
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
                <h2 class="subtitle">User Input: Age and Salary</h2>
                <div class="pagination-centered" >
                    <form>
                        <div class="controls">
                            <div class="input-prepend">
                                <span class="add-on"><i class="icon-heart"></i></span>
                                <input type="number" class="input-medium" placeholder="Age" name="Age" 
                                       required="true" min="0" max="125">
                            </div>
                        </div>

                        <div class="controls">
                            <div class="input-prepend"> 
                                <span class="add-on"><i class="icon-heart"></i></span>
                                <input type="number" class="input-medium" placeholder="Salary" name="Salary" 
                                       required="true" min="0" max="199999">
                            </div>
                        </div>

                        <div class="controls btn-navbar">
                            <button type="submit" class="btn btn-primary">Send</button>
                            <button type="reset" class="btn btn-danger">Clear</button>
                        </div>
                    </form>
                    <div class="border"></div>

                </div>
            </div>
        </main>
    </body>
