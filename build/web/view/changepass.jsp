<%-- 
    Document   : changepass
    Created on : Jul 6, 2022, 9:55:16 AM
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
        <span>Change your password</span>
        <p style="color: red;">${requestScope.mes}</p>
        <form action="changepassword">
            <div>
                <label for="pass-login">Password</label>
                <input class="grey-border" id="pass-login" type="password" placeholder="Enter your password" name="pass" required>
            </div>
            <div>
                <label for="pass-login2">Confirm Password</label>
                <input class="grey-border" id="pass-login2" type="password" placeholder="Re-enter your password" name="cfpass" required>
            </div>
            <div class="bton-login">
                <input class="theme-background" type="submit" value="Send">
            </div>
        </form>
        <p style="color: red;">${requestScope.error}</p>    
    </body>
</html>
