<%-- 
    Document   : accountLookup
    Created on : Jan 26, 2017, 3:53:45 PM
    Author     : Samuel Seidel
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="res/images/favicon.ico">

        <title>Bank | Account Lookup</title>
        <meta name="description" content="The Sam o' Bank Login">


        <link href="res/bootstrap.v2/css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="res/bootstrap.v2/css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
        <link href="res/style.css" rel="stylesheet" type="text/css">

        <style>
            #Table {
                border-radius: 5px;
                margin: auto;
                min-width: 500px;
                max-width: 800px;
                padding: 0.4em 1em;

                background: #4CA1AF; /* fallback for old browsers */
                background: -webkit-linear-gradient(to left, #4CA1AF , #C4E0E5); /* Chrome 10-25, Safari 5.1-6 */
                background: linear-gradient(to left, #4CA1AF , #C4E0E5); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
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
                <h2 class="subtitle">Account Lookup</h2>
                <div class="pagination-centered" >
                    <form class="form-inline" action="AccountLookupServlet">
                        <div class="controls btn-navbar">
                            <button type="submit" class="btn btn-primary">Search</button>
                            <button type="reset" class="btn btn-danger">Clear</button>
                        </div>
                        <br/>
                        <div class="controls">
                            <div class="input-prepend">
                                <span class="add-on">#</span>
                                <input type="text" class="input-small" placeholder="AcctNo" name="AcctNo">
                            </div>
                            <div class="input-prepend">
                                <span class="add-on"><i class="icon-filter"></i></span>
                                <input type="text" class="input-small" placeholder="Acct Type" name="AcctType">
                            </div>
                            <div class="input-prepend">
                                <span class="add-on"><i class="icon-user"></i></span>
                                <input type="text" class="input-small" placeholder="CustomerID" name="CustomerID">
                            </div>
                            <div class="input-prepend">
                                <span class="add-on">$</span>
                                <input type="text" class="input-small" placeholder="Balance" name="Balance"
                                       pattern="\d+(\.\d{1,2})?"
                                       title="Enter a Monetary Value"
                                       >
                            </div>
                        </div>
                    </form>
                    <div class="border"></div>

                    <div id="Table" class="pagination-centered text-center">
                        <table class="table table-striped table-condensed" data-toggle="table">
                            <thead>
                                <tr>
                                    <th>Account ID</th>
                                    <th>Account Type</th>
                                    <th>Customer ID</th>
                                    <th>Balance</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="account" items="${accounts}">
                                    <tr>
                                        <td><c:out value="${account.number}"></c:out></td>
                                        <td><c:out value="${account.type}"></c:out></td>
                                        <td><c:out value="${account.customerID}"></c:out></td>
                                        <td><fmt:formatNumber value="${account.balance}" type="currency"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>



                </div>
            </div>
        </main>
    </body>
</html>