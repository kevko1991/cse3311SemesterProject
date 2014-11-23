<%-- 
    Document   : CreateAccount
    Created on : Nov 22, 2014, 5:50:01 PM
    Author     : Melissa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <body>
        <jsp:include page="navigationbar.jsp" />
        <div id="wrapper">
            <jsp:include page="header.jsp" />
            <div id="accordion">
                <h3>Create Advisor Account</h3>
            <form role="form">
                <div class="form-group">
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input class="form-control" type="text" name="email" id="email" value="">
                    </div>
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input class="form-control" type="text" name="name" id="email" value="">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input class="form-control" type="text" name="password" id="password" value="">
                    </div>
                </div>

            </form>
            </div>
        </div>
    </body>
    <jsp:include page="footer.jsp" />
    <script type="text/javascript" src="js/CreateAccount.js"></script>
</html>
