<%-- 
    Document   : modifyAppointment
    Created on : Oct 26, 2014, 3:53:12 PM
    Author     : Melissa
--%>

<%@page import="uta.cse4361.businessobjects.Appointment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Appointment</title>
    </head>
    <jsp:include page="header.jsp" />
    <body>
        <table id="table">
            <tr>
                <jsp:include page="sidebar.jsp" />
                <jsp:useBean id="dm" class="uta.cse4361.databases.DatabaseManager" scope="session"/>
                
                
                
                
                <td style="vertical-align: top; float: right;">
                    <div style="width:780px" id="appointmentAccordion">

                            <h3>Appointments</h3>
                            <div>
                                <table border="1" id="appointmentList">
                                    <tr>
                                        <td>
                                            Date
                                        </td>
                                        
                                        <td>
                                            Start
                                        </td>
                                        <td>
                                            End
                                        </td>
                                        <td>
                                            Advisor Name
                                        </td>
                                        <td>
                                            Advising Type
                                        </td>
                                    </tr>
                                <%
                                    dm = new uta.cse4361.databases.DatabaseManager(); 
                                    java.util.ArrayList<uta.cse4361.businessobjects.Appointment> appts = dm.getAppointments(); 
                                    for(Appointment a: appts) {
                                        out.print("<tr>");
                                        out.print("<td>");
                                        out.print(a.getDate());
                                        out.print("</td>");
                                        out.print("<td>");
                                        out.print(a.getStartHour() +":" + a.getStartHour());
                                        out.print("</td>");
                                        out.print("<td>");
                                        out.print(a.getEndHour() + ":" + a.getEndMinute());
                                        out.print("</td>");
                                        out.print("<td>");
                                        out.print(a.getAdvisorName());
                                        out.print("</td>");
                                        out.print("<td>");
                                        out.print(a.getType());
                                        out.print("</td>");
                                        out.print("</tr>");
                                    }
                                    %>
                                </table>
                            </div>

                    </div>                   
                </td>
                             
            </tr>            
        </table>
    </body>
    <jsp:include page="footer.jsp" />
    <script type="text/javascript" src="js/modifyAppointment.js"></script>
</html>
