<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Page</title>
    </head>
    <body>
        <span>We already send a verification  code to your email.</span>
        <p style="color: red;">${requestScope.mes}</p>
        <form action="verifyaccount" method="post">
            <input type="text" name="authcode" >
            <input type="submit" value="verify">
        </form>
        <p style="color: red;">${requestScope.error}</p>
        <span>
            <a href="codeagain">Send Code again</a>
        </span>

    </body>
</html>

