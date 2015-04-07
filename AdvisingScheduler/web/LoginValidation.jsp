<%-- 
    Document   : LoginValidation
    Created on : Nov 22, 2014, 10:39:39 PM
    Author     : Melissa
--%>

<%@page import="uta.cse4361.databases.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <jsp:useBean id="login" class="uta.cse4361.beans.LogInBean"/> 
        <jsp:setProperty name="login" property="email" value="<%=request.getParameter("username")%>" />
        <jsp:setProperty name="login" property="password" value="<%=request.getParameter("password")%>" />
    </head>
    <body>
         <jsp:include page="navigationbar.jsp" />
        <div id="wrapper">
            <jsp:include page="header.jsp" />
            <div id="accordion">
                <h3>Login Validation</h3>
                <div>
                    
                <%
                    Login result = login.LogIn();
                    out.print("You have successfully logged in. <br> You will be redirected in 5 seconds.");
                    session.setAttribute("email", login.getEmail());
                    session.setAttribute("confirmation", login.getPassword());
                    session.setAttribute("id", result.getID());
                    session.setAttribute("rank", result.getRank());
                    session.setAttribute("firstlog", result.getLog());
                    response.sendRedirect("index.jsp");
                %>
                </div>
            </div>
        </div>
    </body>
    <jsp:include page="footer.jsp" />
    <script type="text/javascript" src="js/LoginValidation.js"></script>
</html>
