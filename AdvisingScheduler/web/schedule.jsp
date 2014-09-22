<%-- 
    Document   : Appointment
    Created on : Sep 19, 2014, 12:43:15 PM
    Author     : Han
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script>
            $(function () {
                $("#date").datepicker();
            });
        </script>

        <script type="text/javascript">
            function validate() {
                var sID = document.forms["schedule"]["sID"].value;
                var sName = document.forms["schedule"]["sName"].value;
                var dp = document.forms["schedule"]["description"].value;
                if (sID === null || sID === "") {
                    alert("Please fill out student ID");
                    document.forms["schedule"]["sID"].focus();
                    return false;
                }
                if (sName === null || sName === "") {
                    alert("Please fill out student name");
                    document.forms["schedule"]["sName"].focus();
                    return false;
                }
                if (dp === null || dp === "") {
                    alert("Please fill out advising description");
                    document.forms["schedule"]["description"].focus();
                    return false;
                }
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Schedule Appointment</title>
    </head>
    <body>
        <form name="schedule" action="saveAppointment.jsp" onSubmit="return validate();">
            Student ID:
            <input type="text" onkeypress="return event.charCode >= 48 && event.charCode <= 57" name="sID" id="sID" value=""><br>
            Student Name:
            <input type="text" name="sName" id="sName" value=""><br>
            Advisor:
            <select name="aName" id="aName">
                <option value="Linda Barasch">Linda Barasch</option>
                <option value="Bob Weems">Bob Weems</option>
            </select><br>
            Date:
            <input type="text" name="date" id="date" readonly="true"><br>
            Description: 
            <textarea name="description" id="description" rows="6" cols="50" value=""></textarea><br>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </form>
        <br>
        <%
            String date = request.getParameter("date");
            if (date == null) {
                // myText is null when the page is first requested, 
                // so do nothing
            } else {
                if (date.length() == 0) {

        %>
        <b>The date is empty</b>
        <% } else {%>
        <b>Our date is <%= date%></b>
        <%
                }
            }
        %>
    </body>
</html>
