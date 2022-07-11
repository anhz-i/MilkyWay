<%-- 
    Document   : EditAccount
    Created on : Jul 11, 2022, 5:01:50 PM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Account</title>
    </head>
    <body>
        <h1>Account</h1>
        <form action="updateaccount" method="post">
            <div>
                <label for="name">Name</label>
                <input type="text" id="name" name="name" placeholder="${sessionScope.user.name}">
            </div>
            <div>
                <label for="">Email</label>
                <p>${sessionScope.user.email}</p>
                <a href="">Change email</a>
            </div>
            <div>
                <label for="">Password</label>                
                <a href="">Change password</a>
            </div>
                <input type="submit" value="Save">
        </form>
    </body>
</html>
