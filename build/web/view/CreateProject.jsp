<%-- 
    Document   : CreateProject
    Created on : Jun 24, 2022, 5:08:57 PM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List" %>
<%@page import="model.Value" %>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">  
        <title>Milky Way</title>
        <link rel="icon" type="image/x-icon" href="<c:url value="assets/image/favicon_io/favicon.ico"/>">                                
        <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css"/>">        
        <link rel="stylesheet" href="<c:url value="/assets/css/CreateProject/style.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/inbox/responsive.css"/>">
        <script src="https://kit.fontawesome.com/4d809b9711.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
            <h3>Add Project</h3>
        </header>
        <hr>
        <main>
            <h3>${requestScope.error}</h3>
            <form action="createproject" method="post">
                <div>
                    <label for="name">Name</label>
                    <input type="text" name="name" id="name" required>
                </div>
                <div>
                    <label for="color">Color</label>
                    <select name="color">
                        <%
                        Value x = new Value();
                        List<String> list = x.getColor();                         
                        for (String item : list) {
                        %>
                        <option value="<%=item%>" style="background-color: <%=item%>;"><%=item%></option>
                        <%
                        }
                        %>
                    </select>                    
                </div>
                <div>
                    <svg width="24" height="20" class="cxDz6S">
                    <path d="M19.469 1.262c-5.284-1.53-7.47 4.142-7.47 4.142S9.815-.269 4.532 1.262C-1.937 3.138.44 13.832 12 19.333c11.559-5.501 13.938-16.195 7.469-18.07z" stroke="#FF424F" stroke-width="1.5" fill="none" fill-rule="evenodd" stroke-linejoin="round"></path>
                    </svg>
                    Add to favorites
                </div>
                <div>
                    <label>View</label>
                    <div>
                        <div>
                            <img src="<c:url value="/assets/image/View/list.png"/>" alt="list"/>
                            <input type="radio" name="view" value="list" checked="checked">List
                        </div>
                        <div>
                            <img src="<c:url value="/assets/image/View/board.png"/>" alt="board"/>
                            <input type="radio" name="view" value="board">Board
                        </div>
                    </div>
                </div>
                <input type="submit" value="Save" />
            </form>
        </main>
        <hr>

        <footer>            
        </footer>
    </body>
</html>
