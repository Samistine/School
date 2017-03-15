<%-- 
    Document   : Hello
    Created on : Mar 15, 2017, 4:36:08 PM
    Author     : Samuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loop Testing: Hello</title>
    </head>
    <body>

        <main>
            <%
                for (int i = 1; i <= 6; i++) {
                    String tag = "h" + i;

                    out.print("<" + tag + ">");
                    out.print("Hello World");
                    out.print("</" + tag + ">");

                    out.println();
                }
            %>
        </main>

    </body>
</html>
