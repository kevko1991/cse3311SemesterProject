<%--
    Document   : Appointment
    Created on : Sep 19, 2014, 12:43:15 PM
    Author     : Han
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="uta.cse4361.databases.DatabaseManager"%>
<%@page import="uta.cse4361.businessobjects.Slot"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>


        <%
            DatabaseManager dm = new DatabaseManager();
//            ArrayList<Date> availableDates = dm.getDatesForAvailability();
            ArrayList<Slot> availableDates = dm.getAvailableSlots();
            ArrayList<String> availables = new ArrayList<String>();
            for (Slot s : availableDates) {
                int dd = s.getDate().getDate();
                int mm = s.getDate().getMonth() + 1;
                int yy = s.getDate().getYear() + 1900;
                String newRecord = "" + dd + "-" + mm + "-" + yy;
                availables.add(newRecord);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < availables.size(); i++) {
                sb.append(availables.get(i) + ",");
            }
        %>

        <script type="text/javascript">
            temp = "<%=sb.toString()%>";
            var availableDates = new Array();
            availableDates = temp.split(',', '<%=availables.size()%>');

            //alert("array: " + availableDates);
            function available(date) {
                dmy = date.getDate() + "-" + (date.getMonth() + 1) + "-" + date.getFullYear();
                if ($.inArray(dmy, availableDates) !== -1) {
                    return [true, "", "Available"];
                } else {
                    return [false, "", "unAvailable"];
                }
            }
            $(function () {
                $('#date').datepicker({beforeShowDay: available});
            })
        </script>


        <script type="text/javascript">

            function isNumberKey(evt)
            {
                var e = evt || window.event; //window.event is safer, thanks @ThiefMaster
                var charCode = e.which || e.keyCode;
                if (charCode > 31 && (charCode < 47 || charCode > 57))
                    return false;
                if (e.shiftKey)
                    return false;
                return true;
            }
            function validate() {
                var sID = document.forms["schedule"]["sID"].value;
                var sName = document.forms["schedule"]["sName"].value;
                var dp = document.forms["schedule"]["description"].value;
                if (sID === null || sID === "") {
                    alert("Please fill out student ID");
                    document.forms["schedule"]["sID"].focus();
                    return false;
                }
                if (isNaN(sID)) {
                    alert("Student ID must be number");
                    document.forms["schedule"]["sID"].focus();
                    return false;
                }
                if (sID.length !== 10) {
                    alert("Student ID must be a 10-digit number");
                    document.forms["schedule"]["sID"].focus();
                    return false;
                }
                if (sID.indexOf("1000") === -1 && sID.indexOf("6000") === -1) {
                    alert("Student ID should start with 1000 or 6000");
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
    <p id="demo"></p>

    <body>
    <tr>
        <jsp:include page="navigationbar.jsp" />
    <div id="wrapper">
        <jsp:include page="header.jsp" />
        <div id="accordion" class="centerthis">
            <h3>Schedule Appointment</h3>
            <div class="centerthis">
                <form name="schedule" action="StudentCalendar.jsp" onSubmit="return validate();">
                                Student ID<br>
                                <input type="text" onkeypress="return isNumberKey(event)" name="sID" id="sID"  size="50" value=""><br>
                                <br><br>
                                Student Name<br>
                                <input type="text" name="sName" id="sName" size="50" value="">
                                <br><br>
                                Advisor<br>
                                <select name="aName" id="aName" style="min-width:36%;">
                                    <option value="Linda Barasch">Linda Barasch</option>
                                    <option value="Bob Weems">Bob Weems</option>
                                    <option value="Ramez Elmasri">Ramez Elmasri</option>
                                    <option value="Bahram Khalili">Bahram Khalili</option>
                                </select>
                                <br><br>
                                Advising Type<br>
                                <select name="type" id="type" style="min-width:36%;">
                                    <option value="New Student">New Student</option>
                                    <option value="Returning Student">Returning Student</option>
                                    <option value="Drop Course">Drop Course</option>
                                    <option value="Enroll">Enroll</option>
                                    <option value="Others">Others</option>
                                </select>
                                <br><br>
                                Date<br>
                                <input type="text" name="date" size="50" id="date" readonly="true">
                                <br><br>
                                Description<br>
                                <textarea name="description" id="description" rows="6" cols="50" value=""></textarea>
                                <br><br>
                    <input type="submit" value="Submit" id="submitBtn">
                    <input type="reset" value="Reset" id="resetBtn">
                </form>
            </div>
        </div>
    </div>
    <br>
</body>
<jsp:include page="footer.jsp" />
<script type="text/javascript" src="js/schedule.js"></script>
</html>
