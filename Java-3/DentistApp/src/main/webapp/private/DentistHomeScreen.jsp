<%-- 
    Document   : accountLookup
    Created on : Jan 26, 2017, 3:53:45 PM
    Author     : Samuel Seidel
--%>

<%@page import="java.util.Arrays"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map"%>
<%@page import="com.samistine.school.java3.dentistapp.data.users.Dentist"%>
<%@page import="com.samistine.school.java3.dentistapp.data.users.User"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.samistine.school.java3.dentistapp.db.SQLQueries"%>
<%@page import="com.samistine.school.java3.dentistapp.data.Appointments"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
//    Map<String, String[]> tt = request.getParameterMap();
//    for (Map.Entry<String, String[]> r : tt.entrySet()) {
//        out.println(r.getKey() + ": " + Arrays.toString(r.getValue()));
//    }

//    try {
//        User user = SQLQueries.getDentist("D202");
//        session.setAttribute("dentist", user);
//    } catch (SQLException ex) {
//        ex.printStackTrace();
//    }
    User user = (User) session.getAttribute("user");
    pageContext.setAttribute("dentist", user);

    if (request.getParameter("changeSettings") != null) {
        Dentist dentist = (Dentist) pageContext.getAttribute("dentist");

        String firstName = request.getParameter("firstName");
        if (firstName != null) dentist.setFirstName(firstName);

        String lastName = request.getParameter("lastName");
        if (lastName != null) dentist.setLastName(lastName);

        String email = request.getParameter("email");
        if (email != null) dentist.setEmail(email);

        String password = request.getParameter("password");
        if (password != null) dentist.setPassword(password);

        String office = request.getParameter("office");
        if (office != null) dentist.setOffice(office);
    }
%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="res/images/favicon.ico">

        <title>Dentist App | Home</title>
        <meta name="description" content="The Sam o' Bank Login">


        <link href="res/bootstrap.v2/css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="res/bootstrap.v2/css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
        <link href="res/style.css" rel="stylesheet" type="text/css">

        <style>
            .site {
                margin-bottom: 20px;
            }

            #Appointments, #AccountManagement {
                border-radius: 5px;
                margin: auto;
                min-width: 280px;
                max-width: 800px;
                padding: 0.4em 1em;

                background: #4CA1AF; /* fallback for old browsers */
                background: -webkit-linear-gradient(to left, #4CA1AF , #C4E0E5); /* Chrome 10-25, Safari 5.1-6 */
                background: linear-gradient(to left, #4CA1AF , #C4E0E5); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            }

            #Appointments {
                border-bottom-left-radius: 0;
                border-bottom-right-radius: 0;
            }

            #AccountManagement {
                border-top-left-radius: 0;
                border-top-right-radius: 0;
            }

            #AccountManagement .subtitle {
                border-bottom: 1px solid #004d73;
            }

            legend + .control-group {
                margin-top: auto;
            }

            legend {
                font-size: medium;
                line-height: 150%;
                color: #1d6f98;
                width: 35%;
                border-bottom: 1px solid ;
                right: 100px;
            }

            .control-label {
                min-width: 70px;
            }

            @media (max-width: 550px) {
                body {
                    padding-right: 0;
                    padding-left: 0;
                }
            }
        </style>
    </head>
    <body>

        <header>
            <div class="logo">
                <h1>
                    <a href="./"><img src="res/images/logo.svg" height="130" width="130" alt="Safe (Logo)"></a>
                </h1>
                <div class="border"></div>
            </div>
        </header>

        <main>
            <div class="site">
                <h2 class="subtitle">Appointments for ${dentist.firstName} ${dentist.lastName}</h2>
                <div class="pagination-centered" >

                    <div id="Appointments" class="pagination-centered text-center">
                        <table class="table table-striped table-condensed" data-toggle="table">
                            <thead>
                                <tr>
                                    <th>Date</th>
                                    <th>Patient</th>
                                    <th>Procedure</th>
                                    <th>Cost</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="appointment" items="${dentist.appointments()}">
                                    <tr>
                                        <td><fmt:formatDate value="${appointment.date}" type="both" dateStyle="LONG" timeStyle="SHORT"></fmt:formatDate></td>
                                        <td><c:out value="${appointment.patient.firstName} ${appointment.patient.lastName}"></c:out></td>
                                        <td><c:out value="${appointment.procedure.description}"></c:out></td>
                                        <td><fmt:formatNumber value="${appointment.procedure.cost}" type="currency"/></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>

                <div id="AccountManagement">
                    <h2 class="subtitle">Account Management</h2>
                    <div class="pagination-centered" >
                        <form class="form-inline" method="POST" action="">
                            <div class="flex-container">
                                <fieldset class="flex-item">
                                    <legend>Details</legend>

                                    <div class="control-group">
                                        <label class="control-label" for="firstName">First Name </label>
                                        <input class="span3" name="firstName" id="firstName" value="${fn:escapeXml(dentist.firstName)}">
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="lastName">Last Name </label>
                                        <input class="span3" name="lastName" id="lastName" value="${fn:escapeXml(dentist.lastName)}">
                                    </div>
                                </fieldset>

                                <fieldset class="flex-item">
                                    <legend>Account</legend>

                                    <div class="control-group">
                                        <label class="control-label" for="email">Email </label>
                                        <input class="span3" name="email" id="email" value="${fn:escapeXml(dentist.email)}">
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="password">Password </label>
                                        <input class="span3" name="password" id="password" value="${fn:escapeXml(dentist.password)}">
                                    </div>
                                </fieldset>

                                <fieldset class="flex-item">
                                    <legend>Administration</legend>
                                    <div class="control-group">
                                        <label class="control-label" for="id">Id </label>
                                        <input class="span3" name="id" id="id" disabled="true" value="${fn:escapeXml(dentist.id)}">
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="office">Office </label>
                                        <input class="span3" name="office" id="office" disabled="true" value="${fn:escapeXml(dentist.office)}">
                                    </div>
                                </fieldset>
                            </div>

                            <div class="form-actions">
                                <button type="submit" class="btn btn-primary">Save changes</button>
                                <button type="button" class="btn">Cancel</button>
                            </div>

                            <input type="hidden" value="true" name="changeSettings" />
                        </form>
                    </div>
                </div>

                <a class="btn btn-danger btn-logout" href="Logout">Logout</a>
            </div>
        </main>
    </body>
</html>