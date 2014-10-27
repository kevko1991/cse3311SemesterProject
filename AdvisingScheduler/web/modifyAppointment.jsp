<%-- 
    Document   : modifyAppointment
    Created on : Oct 26, 2014, 3:53:12 PM
    Author     : Melissa
--%>

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
                
                <td style="vertical-align: top; float: right;">
                    <div style="width:780px" id="appointmentAccordion">

                            <h3>Appointments</h3>
                            <div>
                            Appointments here
                            </div>

                    </div>                   
                </td>
                             
            </tr>            
        </table>
    </body>
    <jsp:include page="footer.jsp" />
    <script type="text/javascript" src="js/modifyAppointment.js"></script>
</html>
