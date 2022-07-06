<%-- 
    Document   : login
    Created on : Jun 20, 2022, 10:56:39 PM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="model.Section" %>
<%@page import="model.Task" %>
<%@page import="DAL.TaskDAO" %>
<%@page import="java.util.List" %>

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
                        <h3>${requestScope.project.name}</h3>
                    </div>
                    <div>
                        <a href="" title="comment"><i class="fa-solid fa-comment"></i></a>
                        <a href="" title="views"><i class="fa-solid fa-bars-staggered"></i></a>
                    </div>

                </div>
                <div>
                    <a href="" title="Add Task"><i class="fa-solid fa-plus"></i>Ask Task</a>                    
                </div>
                <hr>
                <div class="content">
                    <%
                    List<Section> section = (List<Section>) request.getAttribute("section");
                    TaskDAO t = new TaskDAO();
                    for (Section item : section) {
                    %>
                    <h3><%=item.getName()%></h3>
                    <%
                        try {
                            List<Task> task = t.getTaskbySectionID(item.getId());
                            for (Task itask : task) {
                    %>
                    <div class="task">
                        <input type="checkbox" name="" id=""> 
                        <p><%=itask.getName()%></p>
                        ${(t.dueDate!=null?'<a href="" class="calendar"><i class="fa-solid fa-calendar-days"></i><fmt:formatDate type="date" value="${t.dueDate}" /> </a>':'')}                    
                    </div>
                    <hr>
                    <%
                            }
                        } catch (Exception ex) {                            
                        }
                    }
                    %>                    
                    <div>
                        <a href="" title="Add Task"><i class="fa-solid fa-plus"></i>Ask Task</a>                    
                    </div>
                </div>              
            </section>
            <div class="clear"></div>
        </main>        

    </body>
</html>