<%-- 
    Document   : index
    Created on : May 13, 2014, 11:45:18 PM
    Author     : Family
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%
        System.out.println("Adding attribute");
        session.setAttribute("name", "Rahul");
        %>
        <a href="default.xhtml">Click Here</a>
    </body>
</html>
