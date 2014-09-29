<%-- 
    Document   : AppointmentDetails
    Created on : Sep 29, 2014, 12:01:50 PM
    Author     : Melissa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="header.jsp" />
        <title>JSP Page</title>
    </head>
    <body>
        <table id="table">
            <tr>
                <jsp:include page="sidebar.jsp" />


                <td style="vertical-align: top; float: right;">
                    <div style="width:780px" id="accordion">
                        <h3>Success</h3>
                        <div>
                            Appointment has been created.
                            <%
//                                            String result = newAppt.scheduleAppointment(); 
//
//                                            if(result==""){
//                                                out.println("Appointment has been created.");
//                                            }
//                                            else{
//                                                out.println(result);
//                                            }
                                        %>
                            
                        </div>
                    </div>                   
                </td>
                
                
            </tr>
            
        </table>
    </body>
    <jsp:include page="footer.jsp" />
        <script type="text/javascript" src="js/AppointmentDetails.js"></script>
</html>
