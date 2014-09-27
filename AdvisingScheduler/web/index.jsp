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

       
        <table id="leftnavigation">
            <tr>
                <td style="vertical-align: top">
                    <div style="width:310px" id="accordion">
                        <h3>Subject</h3>
                        <div>
                            <select id="subjectselectmenu">
                                    <option selected="selected">Computer Science</option>
                                    <option>Software Engineering</option>
                                    <option>Computer Engineering</option>
                            </select>                            
                        </div>
                        <h3>Service</h3>
                        <div>
                            <select id="serviceselectmenu">
                                    <option>Registration</option>
                                    <option>General Questions</option>
                                    <option>Major Change</option>
                                    <option selected="selected">Add/Drop/Withdrawal</option>
                                    <option>Probation/Dismissal</option>
                                    <option>Academic Resource Referral</option>
                                    <option>Re-admission</option>
                                    <option>TSI</option>
                                    <option>Grade Exclusion</option>
                                    <option>Major Exploration</option>
                                    <option>45 Hour Hold</option>
                                    <option>Schedule Changes</option>
                            </select>                                
                        </div>
                        <h3>Date</h3>
                        <div id="datepicker">
                        </div>
                    </div>
                    
                </td>
                <td>
                    
                </td>
                
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
