<%-- 
    Document   : AddTask
    Created on : Jul 6, 2022, 8:48:54 PM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Date" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="addsection?projectid=${requestScope.proid}" method="post">
            <div>
                <input type="text" name="name" id="name" placeholder="SectionName" required>
            </div>            
            <input type="submit" value="Add section">
        </form>
    </body>
</html>
