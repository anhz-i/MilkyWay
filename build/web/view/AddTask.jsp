<%-- 
    Document   : AddTask
    Created on : Jul 6, 2022, 8:48:54 PM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="addtask">
            <div>
                <input type="text" name="name" id="name" value="TaskName" required>
            </div>
            <div>
                <input type="text" name="description" id="description" value="Description" required>
            </div>
            <div>
                <input type="date" name="duedate" id="duedate" required>
            </div>
            <select name="priority">                
                <option value="1">Priority 1</option>
                <option value="2">Priority 2</option>
                <option value="3">Priority 3</option>
                <option value="4">Priority 4</option>
            </select>
        </form>
    </body>
</html>
