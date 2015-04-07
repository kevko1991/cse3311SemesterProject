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
        <jsp:setProperty name="newpass" property="email" param="email" />
        <jsp:setProperty name="newpass" property="name" param="name" />
        <jsp:setProperty name="newpass" property="department" param="department" />
        <jsp:setProperty name="newpass" property="tempPassword" param="password" />
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
                    out.print(result);
                    if (result == "") {
                        out.print(newpass.getName() +"'s Account has been updated");
                    } 
                    else {
                        out.print("Account could not be changed.");
                        //out.print(result);
                        out.print(newpass.getEmail());
                        out.print(newpass.getDepartment());
                        out.print(newpass.getName());
                        out.print(newpass.getTempPassword());
                        out.print(newpass.getRank());
                    }
                %>
                </div>
            </div>
        </div>

    </body>
    <jsp:include page="footer.jsp" />
    <script type="text/javascript" src="js/AccountConfirmation.js"></script>
</html>
