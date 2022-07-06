<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Page</title>
    </head>
    <body>
        <span>Enter your email</span>
        <p style="color: red;">${requestScope.mes}</p>
        <form action="forgetpass" method="post">
            <input type="email" name="email" >
            <input type="submit" value="Send">
        </form>
        <p style="color: red;">${requestScope.error}</p>        

    </body>
</html>

