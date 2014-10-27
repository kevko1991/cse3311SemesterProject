<%-- 
    Document   : ModifyTimeSlots
    Created on : Oct 22, 2014, 6:49:06 PM
    Author     : Nabin
--%>
<%@page import="uta.cse4361.databases.AppointmentDatabaseManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="uta.cse4361.beans.ModifyTimeSlotsBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>

        <jsp:include page="header.jsp" />
        <% 
            AppointmentDatabaseManager adm = new AppointmentDatabaseManager();
            ArrayList<Date> availableDates = adm.getDatesForAvailability(); // change to adm.gettimeslots 
            ArrayList<String> availables = new ArrayList<String>();
            // get array list of slots
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < availables.size(); i++) {
                sb.append(availables.get(i) + ",");
            }
        %>  
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Time Slots</title>
    </head>
    <body>
       <table id="table">
            <tr>
                <jsp:include page="sidebar.jsp" />
                <td style="vertical-align: top; float: right;">
                        <div id="accordion" style="width:780px">
                            <h3>Modify Time Slots</h3>
                            <div>

                                <form name="slot" action="StudentCalendar.jsp" onSubmit="return validate();">
                                    <table>
                                        <tr>
                                            <td>
                                                Date:
                                            </td>
                                            <td>
                                                <input type="text" id="datepicker" name="date" readonly="true"><br>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                Start Hour:
                                            </td>
                                            <td>
                                                <input type="datetime" id = "starttimepicker" name="StartHr" readonly="true"><br>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                End Hour:
                                            </td>
                                            <td>
                                                <input type="datetime" id = "starttimepicker" name="EndHr" readonly="true"><br>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                Start Minute:
                                            </td>
                                            <td>
                                                <input type="datetime" id = "starttimepicker" name="StartMin" readonly="true"><br>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                End Minute:
                                            </td>
                                            <td>
                                                <input type="datetime" id = "starttimepicker" name="EndMin" readonly="true"><br>
                                            </td>
                                        </tr>
                                    </table>
                                    <input type="submit" value="Submit" id="submitBtn">
                                    <input type="reset" value="Reset" id="resetBtn">
                                </form>
                            </div>
                        </div>
                </td>
            </tr>
        </table>
        <br>
    </body>
    <jsp:include page="footer.jsp" />
    <script type="text/javascript" src="js/ModifyTimeSlots.js"></script>  
</html>
