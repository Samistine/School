<%-- 
    Document   : accountLookup
    Created on : Jan 26, 2017, 3:53:45 PM
    Author     : Samuel Seidel
--%>

<%@page import="com.samistine.school.java3.dentistapp.data.users.User"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.samistine.school.java3.dentistapp.db.SQLQueries"%>
<%@page import="com.samistine.school.java3.dentistapp.data.Appointments"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="res/images/favicon.ico">

        <title>Dentist App | Home</title>
        <meta name="description" content="The Sam o' Bank Login">


        <link href="../res/bootstrap.v2/css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="../res/bootstrap.v2/css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
        <link href="../res/style.css" rel="stylesheet" type="text/css">
        <meta name="viewport" content="initial-scale=1">

        <style>
            .site {
                margin-bottom: 20px;
            }

            #Table, #AccountManagement {
                border-radius: 5px;
                margin: auto;
                min-width: 280px;
                max-width: 800px;
                padding: 0.4em 1em;

                background: #4CA1AF; /* fallback for old browsers */
                background: -webkit-linear-gradient(to left, #4CA1AF , #C4E0E5); /* Chrome 10-25, Safari 5.1-6 */
                background: linear-gradient(to left, #4CA1AF , #C4E0E5); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            }

            #Table {
                border-bottom-left-radius: 0;
                border-bottom-right-radius: 0;
            }

            #AccountManagement {
                max-width: 800px;
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
        <%
            try {
                User user = SQLQueries.getPatient("A908");
                application.setAttribute("patient", user);
            } catch (SQLException ex) {
                out.print(ex);
                ex.printStackTrace();
            }
        %>

        <header>
            <div class="logo">
                <h1>
                    <a href="./"><img src="../res/images/safe.svg" height="130" width="130" alt="Safe (Logo)"></a>
                </h1>
                <div class="border"></div>
            </div>
        </header>

        <main>
            <div class="site">

                <div>
                    <h2 class="subtitle">Appointment for ${patient.firstName} ${patient.lastName}</h2>
                    <div class="pagination-centered" >

                        <div id="Table" class="pagination-centered text-center">
                            <table class="table table-striped table-condensed" data-toggle="table">
                                <thead>
                                    <tr>
                                        <th>Date</th>
                                        <th>Dentist</th>
                                        <th>Procedure</th>
                                        <th>Cost</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:set var="appointment" value="${patient.appointment}"/>
                                    <tr>
                                        <td><fmt:formatDate value="${appointment.date}" type="both" dateStyle="LONG" timeStyle="SHORT"></fmt:formatDate></td>
                                        <td><c:out value="${appointment.dentist.firstName} ${appointment.dentist.lastName}"></c:out></td>
                                        <td><c:out value="${appointment.procedure.description}"></c:out></td>
                                        <td><fmt:formatNumber value="${appointment.procedure.cost}" type="currency"/></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                    </div>

                    <div id="AccountManagement" style="text-align: center">
                        <h2 class="subtitle">Account Management</h2>
                        <div class="pagination-centered" >
                            <form class="form-inline flex-container">


                                <fieldset class="flex-item">
                                    <legend>Details</legend>

                                    <div class="control-group">
                                        <label class="control-label" for="firstName">First Name </label>
                                        <input class="span3" id="firstName" value="${patient.firstName}">
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="lastName">Last Name </label>
                                        <input class="span3" id="lastName" value="${patient.lastName}">
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="address">Address </label>
                                        <input class="span3" id="address" value="${patient.address}">
                                    </div>
                                </fieldset>

                                <fieldset class="flex-item">
                                    <legend>Account</legend>

                                    <div class="control-group">
                                        <label class="control-label" for="email">Email </label>
                                        <input class="span3" id="email" value="${patient.email}">
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="password">Password </label>
                                        <input class="span3" id="password" value="${patient.password}">
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="id">Id </label>
                                        <input class="span3" id="id" disabled="true" value="${patient.id}">
                                    </div>
                                </fieldset>

                                <fieldset class="flex-item">
                                    <legend>Insurance</legend>
                                    <div class="control-group">
                                        <label class="control-label" for="insurance">Insurance </label>
                                        <input class="span3" id="insurance" value="${patient.insurance}">
                                    </div>
                                </fieldset>

                            </form>
                        </div>
                    </div>


                </div>
            </div>
        </main>
    </body>
</html>