<%-- 
    Document   : login
    Created on : Jun 20, 2022, 10:56:39 PM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                    window.location = "deleteproject?id="+id;
                }
            }
        </script>
    </head>
    <body>
        <header>
            <div class="header-left">
                <a href=""><i class="fa-solid fa-bars"></i></a>
                <a href="" title="Home"><i class="fa-solid fa-house"></i></a>
                <a href=""><i class="fa-solid fa-magnifying-glass"></i></a>
            </div>  
            <div>
                <a href="" title="Add Task"><i class="fa-solid fa-plus"></i></a>
                <a href="">
                    <img src="<c:url value="/assets/image/logo/1.png"/>" alt="" width="40px">                    
                </a>
            </div>
        </header>


        <main>
            <aside style="overflow: scroll;">
                <div class="main-aside">
                    <div>
                        <a href=""><i class="fa-solid fa-inbox"></i>Inbox </a>
                    </div>
                    <div>
                        <a href=""><i class="fa-solid fa-calendar"></i>Today</a>
                    </div>
                    <div>
                        <a href=""><i class="fa-solid fa-calendar-days"></i>Upcoming</a>
                    </div>
                    <div>
                        <a href=""><i class="fa-solid fa-filter"></i>Filters</a>
                    </div>
                </div>
                <div class="project">
                    <div class="header-project" style="display: flex; justify-content: space-between; justify-items: center;">
                        <h3>Project</h3>       
                        <a style="margin: 15px 12px 10px 0;" href="createproject" title="Add Project"><i class="fa-solid fa-plus"></i></a>
                    </div>
                    <div class="extra-function">
                        <c:forEach items="${requestScope.data}" var="c">
                            <a href="#" style="margin-left: 20px;">${c.name}</a>
                            <a href="" class="funtion-btn"><i class="fa-solid fa-ellipsis"></i></a>
                            <div class="sub-function">
                                <a href="updateproject?id=${c.id}">Edit Project</a>
                                <a href="" onclick="onDelete('${c.id}')">Delete Project</a>
                            </div>
                        </c:forEach>     
                    </div>          
                </div>
            </aside>
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
                    <h3>Priority 1</h3>
                    <hr>
                    <div class="task">
                        <input type="checkbox" name="" id=""> 
                        <p>Learn something</p>
                        <a href="" class="calendar"><i class="fa-solid fa-calendar-days"></i>6 June</a>                    
                    </div>
                    <hr>
                    <div>
                        <a href="" title="Add Task"><i class="fa-solid fa-plus"></i>Ask Task</a>                    
                    </div>
                </div>
                <div class="content">
                    <h3>Priority 2</h3>
                    <hr>
                    <input type="checkbox" name="" id="">
                    <p>Learn something</p>
                    <a href="" class="calendar"><i class="fa-solid fa-calendar-days"></i>6 June</a>                    
                    <hr>
                    <input type="checkbox" name="" id="">
                    <p>Learn something</p>
                    <a href="" class="calendar"><i class="fa-solid fa-calendar-days"></i>6 June</a>                    
                    <hr>
                    <div>
                        <a href="" title="Add Task"><i class="fa-solid fa-plus"></i>Ask Task</a>                    
                    </div>
                </div>
            </section>
            <div class="clear"></div>
        </main>        
        
    </body>
</html>