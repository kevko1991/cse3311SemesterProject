<%-- 
    Document   : modifyTimeslot
    Created on : Oct 26, 2014, 3:53:32 PM
    Author     : Melissa
--%>

<%@page import="uta.cse4361.businessobjects.Slot"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Timeslot</title>
    </head>
    <jsp:include page="header.jsp" />
    <body>
        <table id="table">
            <tr>
                <jsp:include page="sidebar.jsp" />
                <jsp:useBean id="dm" class="uta.cse4361.databases.DatabaseManager" scope="session"/>
                <td style="vertical-align: top; float: right;">
                    <div style="width:780px" id="timeslotAccordion">

                            <h3>Timeslots</h3>
                            <div>
                                <form  name="appointmentForm" action="" onsubmit="">
                                <table border="1" id="appointmentList" cellpadding= "3" cellspacing= "0" style="border: 1pt solid #000000; border-Collapse: collapse">
                                    <tr>
                                        <td>
                                            Date
                                        </td>
                                        
                                        <td>
                                            Time
                                        </td>
                                        <td>
                                            Student Name
                                        </td>
                                    </tr>
                                <%
                                    dm = new uta.cse4361.databases.DatabaseManager(); 
                                    java.util.ArrayList<Slot> slots = dm.getSlots(); 
                                    for(Slot s: slots) {
                                        out.print("<tr>");
                                        out.print("<td>");
                                        out.print(s.getDate().getMonth()+1+"/"+s.getDate().getDate()+"/"+(s.getDate().getYear()+1900));
                                        out.print("</td>");
                                        out.print("<td>");
                                        out.print(s.getHour() + ":");
                                        if(s.getMinute() == 0)
                                        {
                                            out.print("00");
                                        }
                                        else
                                        {
                                            out.print(s.getMinute());
                                        }
                                        out.print("</td>");
                                        out.print("<td>");
                                        if (s.isAppointment())
                                        {
                                            out.print(dm.getAppointment(s.getAppointmentId()).getStudentName() + "at " +
                                                    dm.getAppointment(s.getAppointmentId()).getStartHour() + ":" 
                                                    + dm.getAppointment(s.getAppointmentId()).getStartMinute() + "to " + 
                                                    + dm.getAppointment(s.getAppointmentId()).getEndHour() + ":" +
                                                    dm.getAppointment(s.getAppointmentId()).getEndMinute());
                                        }
                                        else
                                        {
                                            out.print("No Appointment");
                                        }
                                        out.print("</td>");
                                        out.print("</tr>");
                                        out.print("</script>");
                                    }
                                    %>
                                </table>

                                    <input type="hidden" name="slotID" id="slotID" size="50" value="">
                                    <input type="submit" value="Modify Timeslots" id="submitBtn">
                                </form>
                            </div>


                    </div>                   
                </td>
                
                
            </tr>
            
        </table>
    </body>
    <jsp:include page="footer.jsp" />
    <script type="text/javascript" src="js/modifyTimeslot.js"></script>
</html>
