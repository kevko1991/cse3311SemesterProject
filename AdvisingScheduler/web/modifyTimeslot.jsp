<%-- 
    Document   : modifyTimeslot
    Created on : Oct 26, 2014, 3:53:32 PM
    Author     : Melissa
--%>

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
                
                <td style="vertical-align: top; float: right;">
                    <div style="width:780px" id="timeslotAccordion">

                            <h3>Timeslots</h3>
                            <div>
                            Time slots here
                            </div>

                    </div>                   
                </td>
                
                
            </tr>
            
        </table>
    </body>
    <jsp:include page="footer.jsp" />
    <script type="text/javascript" src="js/modifyTimeslot.js"></script>
</html>
