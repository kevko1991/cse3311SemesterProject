<%-- 
    Document   : Calendar
    Created on : Sep 12, 2014, 9:59:13 PM
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
        <link rel='stylesheet' href='css/fullcalendar.css' />
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
        <jsp:include page="header.jsp" />
        <%
           
           java.util.Date date[][] = new java.util.Date[1][2];
           java.util.Date d = new java.util.Date();
           d.setDate(22);
           d.setHours(5);
           d.setMinutes(30);
           d.setYear(2014);
           d.setMonth(8);
           date[0][1] = d;
           
//            int[][] test = new int[1][2];
//            test[0][0] = 1;
//            test[0][1] = 2;
//            out.print(test[0][0]);
//        %>
            <script type="text/javascript">
            foo();
            function foo() {
                var value = "<%=date[0][1]%>";
                alert(value);
            }
            </script>

        
    <body>
        <div class="ui-widget-header">UTA Advising</div>
        
        <div class="ui-widget">
            
        </div>
       
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
                    </div>
                    
                </td>
                <td>
                    
                </td>
                
                <td style="vertical-align: top; float: right;">
                    <div style="width:780px" id="timeaccordion">
                        <h3>Calendar</h3>
                        <div id="calendar">
                            
                        </div>
                    </div>
                </td>
                
                
            </tr>
            
        </table>

    </body>
    
        <jsp:include page="footer.jsp" />
        <script type="text/javascript" src="js/fullcalendar/moment.min.js"></script>
        <script type="text/javascript" src="js/fullcalendar/fullcalendar.js"></script>
        <script type="text/javascript" src="js/AdvisorCalendar.js"></script>
</html>
