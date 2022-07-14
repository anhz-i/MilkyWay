<%-- 
    Document   : addcomment
    Created on : Jul 14, 2022, 8:00:55 AM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <h3>Comment</h3>
        <div class="content">
            <c:forEach items="${requestScope.comment}" var="t">
                <div class="task">
                    <div style="">
                        <div>
                            <img id="profile-img" src="<c:url value="/assets/image/logo/1.png"/>" alt="" width="40px" style="border-radius: 50%">                                        
                            <h4>${t.name}</h4>
                            <p>${t.datetime}</p>
                        </div>
                        <div>
                            <p>${requestScope.comment.comment}</p>
                            <a href="deletecomment?id=${t.id}"><i class="fa-regular fa-trash-can"></i></a>
                            <a href="updatecomment?id=${t.id}"><i class="fa-regular fa-pen-to-square"></i></a>
                        </div>
                    </div>                   
                </div>                
            </c:forEach>   
        </div>
        <form action="addcomment?projectid=${requestScope.projectid}" method="post">
            <input type="text" name="comment">
            <input type="submit" value="Comment">
        </form>      
    </body>
</html>
