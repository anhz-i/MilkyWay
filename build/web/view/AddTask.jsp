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
        <form action="addtask?projectid=${requestScope.proid}&&sectionid=${requestScope.secid}" method="post">
            <div>
                <input type="text" name="name" id="name" placeholder="TaskName" required>
            </div>
            <div>
                <input type="text" name="description" id="description" placeholder="Description">
            </div>
            <div>
                <%                
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String date = simpleDateFormat.format(new Date());
                %>
                <input type="date" name="duedate" id="duedate" min="<%=date%>">
            </div>
            <select name="priority">                
                <option value="1">Priority 1</option>
                <option value="2">Priority 2</option>
                <option value="3">Priority 3</option>
                <option value="4" selected>Priority 4</option>
            </select>
            <div>
                <input type="checkbox" name="tag" value="Read">Read
                <div>
                    <input type="text" name="tag">
                    <a href="">Create</a>
                </div>
            </div>
            <input type="submit" value="Add">
        </form>
    </body>
</html>
