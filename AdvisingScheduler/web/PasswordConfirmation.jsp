<%-- 
    Document   : PasswordConfirmation
    Created on : Apr 6, 2015, 11:51:38 PM
    Author     : Joseph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="newpass" class="uta.cse4361.beans.EditAdvisorBean"/> 
        <jsp:setProperty name="newpass" property="email" value="<%=request.getParameter("email")%>" />
        <jsp:setProperty name="newpass" property="tempPassword" value="<%=request.getParameter("password")%>" />
        <jsp:setProperty name="newpass" property="department" value="<%=request.getParameter("dept")%>" />
        <jsp:setProperty name="newpass" property="name" value="<%=request.getParameter("name")%>" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Password Confirmation</title>
    </head>
    <body>
        <jsp:include page="navigationbar.jsp" />
        <div id="wrapper">
            <jsp:include page="header.jsp" />
            <div id="accordion">
                <h3>Password Confirmation</h3>
                <div>
                <%
                    String result = newpass.Advisor();
                    if (result == "") {
                        out.print(newpass.getName() +"'s Account has been updated");
                    } 
                    else {
                        out.print("Account could not be changed.");
                    }
                %>
                </div>
            </div>
        </div>

    </body>
    <jsp:include page="footer.jsp" />
    <script type="text/javascript" src="js/AccountConfirmation.js"></script>
</html>
