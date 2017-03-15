<%-- 
    Document   : Loops
    Created on : Mar 15, 2017, 4:15:22 PM
    Author     : Samuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loop Testing</title>
    </head>
    <body>

        <main>
            <%
                for (int i = 0; i < 10; i++) {
                    out.print("Go Braves <br/>");
                }
            %>
        </main>

    </body>
</html>
