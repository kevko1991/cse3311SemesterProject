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
                                <form  name="appointmentForm" action="appointmentEdit.jsp">
                                <table border="1" id="appointmentList" cellpadding= "3" cellspacing= "0" style="border: 1pt solid #000000; border-Collapse: collapse">
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
                                        <td>
                                            
                                        </td>
                                    </tr>
                                <%
                                    dm = new uta.cse4361.databases.DatabaseManager(); 
                                    java.util.ArrayList<uta.cse4361.businessobjects.Appointment> appts = dm.getAppointments(); 
                                    for(Appointment a: appts) {
                                        out.print("<tr>");
                                        out.print("<td>");
                                        out.print(a.getDate().getMonth()+1+"/"+a.getDate().getDate()+"/"+(a.getDate().getYear()+1900));
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
                                        out.print("<td>");
                                        out.print("<input type='radio' name='apptID' value='" +a.getApptID()+"'>");
                                        out.print("</td>");
                                        out.print("</tr>");
                                        out.print("</script>");
                                    }
                                    %>
                                </table>
                                   <input type="submit" value="Modify Appointment" id="submitBtn">
                                </form>
                            </div>

                    </div>                   
                </td>
                             
            </tr>            
        </table>
    </body>
    <jsp:include page="footer.jsp" />
    <script type="text/javascript" src="js/modifyAppointment.js"></script>
</html>
