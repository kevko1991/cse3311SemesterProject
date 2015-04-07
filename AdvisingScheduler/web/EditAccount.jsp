<%-- 
    Document   : EditAccount
    Created on : Apr 6, 2015, 9:56:21 PM
    Author     : Joseph
--%>

<%@page import="uta.cse4361.businessobjects.AdvisorAccount"%>
<%@page import="uta.cse4361.databases.DatabaseManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            function validate() {
                var password = document.forms["edit"]["password"].value;
                var passwordConfirm = document.forms["edit"]["passwordConfirm"].value;

                if (password === null || password === "") {
                    $("#password").notify("Please enter your password", "error",
                            {elementPosition: 'bottom center',
                                globalPosition: 'bottom center'})
                    return false;
                }
                if (passwordConfirm === null || passwordConfirm === "") {
                    $("#passwordConfirm").notify("Please confirm your password", "error",
                            {elementPosition: 'bottom center',
                                globalPosition: 'bottom center'})
                    return false;
                }
                if (passwordConfirm !== password) {
                    $("#passwordConfirm").notify("Your password does not match", "error",
                            {elementPosition: 'bottom center',
                                globalPosition: 'bottom center'})
                    return false;
                }
                return true;
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Account</title>
    </head>
    <body>
        <jsp:include page="navigationbar.jsp" />
        <div id="wrapper">
            <jsp:include page="header.jsp" />
            <div id="accordion">
                <%
                        DatabaseManager dm = new DatabaseManager();
                        AdvisorAccount aa = dm.getAccount((String)session.getAttribute("email"));
                        int ID = aa.getID();
                        String email = aa.getEmail();
                        String name = aa.getName();
                        String dept = aa.getDepartment();
                        int rank = aa.getRank();
                        int log = 0;
                %>
                <h3>Enter New Password</h3>
                <form role="form" id="edit"  onSubmit="return validate();" action="PasswordConfirmation.jsp" method="POST">
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input readonly class="form-control" type="text" name="email" size="50" id="email" value = "<%=email%>">
                    </div>
                    <div class="form-group">
                        <label for="password">New Password</label>
                        <input class="form-control" type="password" name="password" id="password" value="">
                    </div>
                    <div class="form-group">
                        <label for="passwordConfirm">Confirm Password</label>
                        <input class="form-control" type="password" name="passwordConfirm" id="passwordConfirm" value="">
                    </div>
                        <div class="form-group">
                        <label for="name">Name</label>
                        <input readonly class="form-control" type="text" name="name" size="50" id="name" value = "<%=name%>">
                    </div>
                    <div class="form-group">
                        <label for="dept">Department</label>
                        <input readonly class="form-control" type="text" name="department" size="50" id="department" value = "<%=dept%>">
                    </div>
                    <div class="centerthis">
                        <input type="submit" value="Submit" id="submitBtn" class="btn btn-default">
                        <input type="reset" value="Reset" id="resetBtn" class="btn btn-default">
                    </div>
                </form>
                <jsp:useBean id="editadvisor" class="uta.cse4361.beans.EditAdvisorBean"/> 
                <jsp:setProperty name="editadvisor" property="*"/>
                <div style="position:relative;visibility:hidden"> 
                ID: ${editadvisor.ID}<br>
                name: ${editadvisor.name}<br>
                email: ${editadvisor.email}<br>
                password: ${editadvisor.tempPassword}<br>
                department: ${editadvisor.department}<br>
                rank: ${editadvisor.rank}<br>
                log: ${editadvisor.log}<br>
                </div>
                
                <%--<jsp:setProperty name="editadvisor" property="name" value= 'name'/>
                <jsp:setProperty name="editadvisor" property="email" value= 'email'/>
                <jsp:setProperty name="editadvisor" property="tempPassword" value= 'password'/>
                <jsp:setProperty name="editadvisor" property="department" value= 'department'/>
                <jsp:setProperty name="editadvisor" property="log" value='<%=log%>'/>--%>
            </div>
        </div>
    </body>
    <jsp:include page="footer.jsp" /> 
    <script type="text/javascript" src="js/EditAccount.js"></script>
</html>
