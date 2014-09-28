<%-- 
    Document   : Appointment
    Created on : Sep 19, 2014, 12:43:15 PM
    Author     : Han
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp" />
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
        <div id="accordion">
            <h3>Schedule Appointment</h3>
            <div>
 
                <form name="schedule" action="StudentCalendar.jsp" onSubmit="return validate();">
                    <table>
                        <tr>
                            <td>
                    Student ID:
                            </td>
                            <td>
                    <input type="text" onkeypress="return event.charCode >= 48 && event.charCode <= 57" name="sID" id="sID" value=""><br>
                            </td>
                        </tr>
                        <tr>
                            <td>
                    Student Name:
                            </td>
                            <td>
                    <input type="text" name="sName" id="sName" value=""><br>
                            </td>
                        </tr>
                    <tr>
                            <td>
                    Advisor:
                            </td>
                            <td>
                    <select name="aName" id="aName">
                        <option value="Linda Barasch">Linda Barasch</option>
                        <option value="Bob Weems">Bob Weems</option>
                    </select><br>
                            </td>
                    </tr>
                    <tr>
                            <td>
                    Date:
                            </td>
                            <td>
                    <input type="text" name="date" id="date" readonly="true"><br>
                            </td>
                    </tr>
                    <tr>
                            <td>
                    Description: 
                            </td>
                            <td>
                    <textarea name="description" id="description" rows="6" cols="50" value=""></textarea><br>
                            </td>
                    <tr>
                    </table>
                    <input type="submit" value="Submit" id="submitBtn">
                    <input type="reset" value="Reset" id="resetBtn">
                </form>
            </div>
        </div>
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
    <jsp:include page="footer.jsp" />
    <script type="text/javascript" src="js/schedule.js"></script>    
</html>
