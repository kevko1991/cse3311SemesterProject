<%-- 
    Document   : LoginValidation
    Created on : Nov 22, 2014, 10:39:39 PM
    Author     : Melissa
--%>

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
                    String result = login.LogIn();
                    if (result == "") {
                        out.print("You have successfully logged in.");
                        session.setAttribute("id", login.getEmail());
                        session.setAttribute("confirmation", login.getPassword());
                    } 
                    else {
                        out.print("Wrong username or password.");
                    }
                    
                    
                %>
                </div>
            </div>
        </div>
    </body>
    <jsp:include page="footer.jsp" />
    <script type="text/javascript" src="js/LoginValidation.js"></script>
</html>
