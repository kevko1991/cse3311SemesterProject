<%-- 
    Document   : appointmentEdit
    Created on : Oct 27, 2014, 11:02:21 PM
    Author     : Melissa
--%>

<%@page import="uta.cse4361.businessobjects.Appointment"%>
<%@page import="uta.cse4361.databases.DatabaseManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
            <jsp:include page="header.jsp" />
    <body>
        <table id="table">
            <tr>
                <jsp:include page="sidebar.jsp" />
                <jsp:useBean id="dm" class="DatabaseManager" scope="session"/>
                
                <td style="vertical-align: top; float: right;">
                    <div style="width:780px" id="appointmentAccordion">

                            <h3>Appointment Edit</h3>
                            <div>
                                <%
                                dm = new DatabaseManager(); 
                                    Appointment appt = dm.getAppointment(Integer.parseInt(request.getParameter("apptID"))); 
//                                    out.print(appt.getDate() + " " + appt.getAdvisorName());
                                    String advisorName = appt.getAdvisorName();
                                    String description= appt.getDescription();
                                    String date = "" + (appt.getDate().getMonth()+1) + "/" + appt.getDate().getDate() + "/" + (appt.getDate().getYear()+1900);
                                    String startTime = "" + appt.getStartHour() + ":" + appt.getStartMinute();
                                    String endTime = "" + appt.getEndHour() + ":" + appt.getEndMinute();
                                %>
                                
                                <form name="edit" action="" onSubmit="">
                                <table>
                                    <tr>
                                        <td>
                                            Advisor:
                                        </td>
                                        <td>
                                            <input type="text" name="advisorName" size="50" id="advisorName" value = "<%=advisorName%>" readonly="true">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Date:
                                        </td>
                                        <td>
                                            <input type="text" name="date" size="50" id="date" value = "<%=date%>" readonly="true"><br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            Description: 
                                        </td>
                                        <td>
                                            <textarea name="description" id="description" rows="6" cols="50"><%=description%></textarea><br>
                                        </td>
                                    <tr>
                                </table>
                                        <input type="submit" value="Edit Appointment" id="submitBtn">
                                </form>
                                        
                                        <form name="edit" action="" onSubmit="">
                                            <input type="submit" value="Cancel Appointment" id="cancelBtn">
                                        </form>
                                            
                            </div>

                    </div>                   
                </td>
                
                
            </tr>
            
        </table>
    </body>
    <jsp:include page="footer.jsp" />
        <script type="text/javascript" src="js/appointmentEdit.js"></script>
</html>
