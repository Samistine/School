<%-- 
    Document   : accountLookup
    Created on : Jan 26, 2017, 3:53:45 PM
    Author     : Samuel Seidel
--%>

<%@page import="com.samistine.school.java3.dentistapp.data.users.Dentist"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.samistine.school.java3.dentistapp.data.Procedure"%>
<%@page import="java.util.List"%>
<%@page import="com.samistine.school.java3.dentistapp.data.users.Patient"%>
<%@page import="com.samistine.school.java3.dentistapp.data.users.User"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.samistine.school.java3.dentistapp.db.SQLQueries"%>
<%@page import="com.samistine.school.java3.dentistapp.data.Appointments"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
%>

<%
    User user = (User) session.getAttribute("user");
    pageContext.setAttribute("patient", user);

    try {
        pageContext.setAttribute("dentists", SQLQueries.getDentists());
        pageContext.setAttribute("procedures", SQLQueries.getProcedures());
    } catch (SQLException ex) {
        out.print(ex);
        ex.printStackTrace();
    }

    if (request.getParameter("changeSettings") != null) {
        Patient patient = (Patient) pageContext.getAttribute("patient");

        String firstName = request.getParameter("firstName");
        if (firstName != null) patient.setFirstName(firstName);

        String lastName = request.getParameter("lastName");
        if (lastName != null) patient.setLastName(lastName);

        String email = request.getParameter("email");
        if (email != null) patient.setEmail(email);

        String password = request.getParameter("password");
        if (password != null) patient.setPassword(password);

        String address = request.getParameter("address");
        if (address != null) patient.setAddress(address);

        String insurance = request.getParameter("insurance");
        if (insurance != null) patient.setInsurance(insurance);
    }

    if (request.getParameter("editAppointment") != null) {
        Patient patient = (Patient) pageContext.getAttribute("patient");

        String _date = request.getParameter("date");
        String _dentist = request.getParameter("dentist");
        String _procedure = request.getParameter("procedure");
        log("editAppointment: " + _date + " " + _dentist + " " + _procedure);

        Date date = sdf.parse(_date);
        Dentist dentist = SQLQueries.getDentist(_dentist);
        Procedure procedure = SQLQueries.getProcedure(_procedure);

        patient.setAppointment(dentist, procedure, date);
    }

    if (request.getParameter("deleteAppointment") != null) {
        Patient patient = (Patient) pageContext.getAttribute("patient");
        patient.deleteAppointment();
    }

//    Map<String, String[]> tt = request.getParameterMap();
//    for (Map.Entry<String, String[]> r : tt.entrySet()) {
//        out.println(r.getKey() + ": " + Arrays.toString(r.getValue()));
//    }

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
        <meta name="viewport" content="initial-scale=1">

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

                <h2 class="subtitle">Appointment for ${patient.firstName} ${patient.lastName}</h2>
                <div class="pagination-centered" >

                    <div id="Appointments" class="pagination-centered text-center">
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
                                    <td><fmt:formatDate value="${appointment.date}" type="both" dateStyle="LONG" timeStyle="SHORT" /></td>
                                    <td><c:out value="${appointment.dentist.firstName} ${appointment.dentist.lastName}" /></td>
                                    <td><c:out value="${appointment.procedure.description}" /></td>
                                    <td><fmt:formatNumber value="${appointment.procedure.cost}" type="currency"/></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                </div>

                <div id="AccountManagement" style="text-align: center">
                    <h2 class="subtitle">Account Management</h2>
                    <div class="pagination-centered" >
                        <form class="form-inline" method="POST">

                            <div class="flex-container">
                                <fieldset class="flex-item">
                                    <legend>Details</legend>

                                    <div class="control-group">
                                        <label class="control-label" for="firstName">First Name </label>
                                        <input class="span3" name="firstName" id="firstName" value="${fn:escapeXml(patient.firstName)}">
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="lastName">Last Name </label>
                                        <input class="span3" name="lastName" id="lastName" value="${fn:escapeXml(patient.lastName)}">
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="address">Address </label>
                                        <input class="span3" name="address" id="address" value="${fn:escapeXml(patient.address)}">
                                    </div>
                                </fieldset>

                                <fieldset class="flex-item">
                                    <legend>Account</legend>

                                    <div class="control-group">
                                        <label class="control-label" for="email">Email </label>
                                        <input class="span3" name="email" id="email" value="${fn:escapeXml(patient.email)}">
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="password">Password </label>
                                        <input class="span3" name="password" id="password" value="${fn:escapeXml(patient.password)}">
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="id">Id </label>
                                        <input class="span3" name="id" id="id" disabled="true" value="${fn:escapeXml(patient.id)}">
                                    </div>
                                </fieldset>

                                <fieldset class="flex-item">
                                    <legend>Insurance</legend>
                                    <div class="control-group">
                                        <label class="control-label" for="insurance">Insurance </label>
                                        <input class="span3" name="insurance" id="insurance" value="${fn:escapeXml(patient.insurance)}">
                                    </div>
                                </fieldset>
                            </div>

                            <div class="form-actions">
                                <button type="submit" name="changeSettings" class="btn btn-warning">Save changes</button>
                                <!--<button type="button" class="btn">Cancel</button>-->
                            </div>
                        </form>
                    </div>
                </div>

                <div id="Appointment" style="text-align: center">
                    <h2 class="subtitle">Manage Appointment</h2>
                    <div class="pagination-centered" >
                        <form class="form-inline" method="POST">
                            <fieldset>
                                <legend>Appointment</legend>

                                <div class="control-group">
                                    <label class="control-label" for="date">Date </label>
                                    <input class="span4" type="datetime-local" name="date" id="date" value="<fmt:formatDate value="${patient.appointment.date}" pattern="yyyy-MM-dd'T'HH:mm" />">
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="dentist">Dentist </label>
                                    <select class="span4" name="dentist" id="dentist">
                                        <c:forEach var="dentist" items="${dentists}">
                                            <c:choose>
                                                <c:when test="${dentist eq patient.appointment.dentist}">
                                                    <option selected="true" value="${fn:escapeXml(dentist.id)}">${fn:escapeXml(dentist.firstName)} ${fn:escapeXml(dentist.lastName)}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${fn:escapeXml(dentist.id)}">${fn:escapeXml(dentist.firstName)} ${fn:escapeXml(dentist.lastName)}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="procedure">Procedure </label>
                                    <select class="span4" name="procedure" id="procedure">
                                        <c:forEach var="procedure" items="${procedures}">
                                            <c:choose>
                                                <c:when test="${procedure eq patient.appointment.procedure}">
                                                    <option selected="true" value="${fn:escapeXml(procedure.code)}">${fn:escapeXml(procedure.description)}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${fn:escapeXml(procedure.code)}">${fn:escapeXml(procedure.description)}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </div>
                            </fieldset>
                            <div class="form-actions">
                                <button type="submit" name="editAppointment" class="btn btn-warning">Update Appointment</button>
                                <button type="submit" name="deleteAppointment" class="btn btn-danger">Delete Appointment</button>
                            </div>
                        </form>
                    </div>
                </div>

                <a class="btn btn-danger btn-logout" href="Logout">Logout</a>
            </div>
        </main>
    </body>
</html>