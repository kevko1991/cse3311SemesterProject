<%-- 
    Document   : index
    Created on : Sep 12, 2014, 2:12:40 PM
    Author     : Melissa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>UTA Advising</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
        <jsp:include page="header.jsp" />
        
        
    <body>
        <div class="ui-widget-header">UTA Advising</div>
        
        <a class="ui-widget-header" href="Calendar.jsp">See Event Calendar</a>

       
        <table id="table">
            <tr>
                <jsp:include page="sidebar.jsp" />
                
                <td style="vertical-align: top; float: right;">
                    <div style="width:780px" id="tabs">
                        <div id="tabs-1">
                            <ul>
                                <li><a href="#tabs-1">Links</a></li>
                            </ul>                              
                            <a href="schedule.jsp">Schedule Appointment</a><br>
                            <a href="StudentCalendar.jsp">Student Calendar</a><br>
                            <a href="AdvisorCalendar.jsp">Advisor Calendar</a><br>
                            <a href="AllocateTime.jsp">Allocate Time</a><br>
                            <a href="saveAppointment.jsp">Save Appointment</a><br>
                        </div>
                    </div>                   
                </td>
                
                
            </tr>
            
        </table>
       
    </body>
    
        <jsp:include page="footer.jsp" />
        <script type="text/javascript" src="js/index.js"></script>
</html>
