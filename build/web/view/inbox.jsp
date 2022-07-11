<%-- 
    Document   : login
    Created on : Jun 20, 2022, 10:56:39 PM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">  
        <title>Milky Way</title>
        <link rel="icon" type="image/x-icon" href="<c:url value="/assets/image/favicon_io/favicon.ico"/>">                                
        <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css"/>">        
        <link rel="stylesheet" href="<c:url value="/assets/css/inbox/style.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/inbox/responsive.css"/>">
        <script src="https://kit.fontawesome.com/4d809b9711.js" crossorigin="anonymous"></script>
        <script type="text/javascript">
            function onDelete(id) {
                if (confirm("Are you sure to delete?")) {
                    window.location = "deleteproject?id=" + id;
                }
            }
        </script>
    </head>
    <body>

        <%@include file="LeftAside.jsp" %>


        <main>
            <section>
                <div class="title-row">
                    <div class="title">
                        <h3>Inbox</h3>
                    </div>
                    <div>
                        <a href="" title="comment"><i class="fa-solid fa-comment"></i></a>
                        <a href="" title="views"><i class="fa-solid fa-bars-staggered"></i></a>
                    </div>

                </div>
                <hr>
                <div class="content">                    
                    <c:forEach items="${requestScope.task}" var="t">
                        <div class="task">
                            <input type="checkbox" name="" id=""> 
                            <p>${t.name}</p>
                            <a href="deletetask?id=${t.id}"><i class="fa-regular fa-trash-can"></i></a>
                            <a href="updatetask?id=${t.id}"><i class="fa-regular fa-pen-to-square"></i></a>
                            <a href=""><i class="fa-regular fa-comment"></i></a>
                            <c:if test="${(t.dueDate!=null)}">
                                <a href="" class="calendar"><i class="fa-solid fa-calendar-days"></i>${t.dueDate}</a>
                            </c:if>

                        </div>
                        <hr>
                    </c:forEach>                    
                    <div>
                        <a href="addtask?projectid=&&sectionid=" title="Add Task"><i class="fa-solid fa-plus"></i>Ask Task</a>                    
                    </div>
                </div>                
            </section>
            <div class="clear"></div>
        </main>        

    </body>
</html>