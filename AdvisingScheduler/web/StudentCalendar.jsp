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
                 <%
           java.util.Date date[][] = new java.util.Date[1][2];
           java.util.Date d = new java.util.Date();
           java.util.Date d2 = new java.util.Date();
           d.setDate(22);
           d.setHours(5);
           d.setMinutes(30);
           d.setYear(2014);
           d.setMonth(8);
           date[0][1] = d;
           
           uta.cse4361.businessobjects.FlyweightDatabaseManager fdm = new uta.cse4361.businessobjects.FlyweightDatabaseManager();
           uta.cse4361.businessobjects.AppointmentFlyweight fwa[] = new uta.cse4361.businessobjects.AppointmentFlyweight[4];
           uta.cse4361.businessobjects.AppointmentFlyweight fw = new uta.cse4361.businessobjects.AppointmentFlyweight(1, d, 6, 15);
           fwa[0] = fw;
           fw = new uta.cse4361.businessobjects.AppointmentFlyweight(1, new java.util.Date(2014, 8, 2, 4, 10), 6, 15);
           fwa[1] = fw;
           fw = new uta.cse4361.businessobjects.AppointmentFlyweight(1, new java.util.Date(2014, 8, 5, 6, 20), 6, 15);
           fwa[2] = fw;
           fw = new uta.cse4361.businessobjects.AppointmentFlyweight(1, new java.util.Date(2014, 8, 8, 7, 30), 6, 15);
           fwa[3] = fw;
           
           d2 = fwa[0].getDate();
           
           int test[] =  new int[20];
           test[0] = 1;
           test[1] = 2;
           test[3] = 3;
           int day = 1;//d2.getDate();
           int hour = d2.getHours();
           int min = d2.getMinutes();
           int month = d2.getMonth();
           int year = d2.getYear();
           
           
           //Retrieve all the data into seperate parts
           StringBuilder sbDay = new StringBuilder();
           for(int i=0;i<fwa.length;i++) 
               sbDay.append(fwa[i].getDate().getDate()+",");
           
           StringBuilder sbHour = new StringBuilder();
           for(int i=0;i<fwa.length;i++) 
               sbHour.append(fwa[i].getDate().getHours()+",");
           
           StringBuilder sbMin = new StringBuilder();
           for(int i=0;i<fwa.length;i++) 
               sbMin.append(fwa[i].getDate().getMinutes()+",");
           
           StringBuilder sbMonth = new StringBuilder();
           for(int i=0;i<fwa.length;i++) 
               sbMonth.append(fwa[i].getDate().getMonth()+",");
           
           StringBuilder sbYear = new StringBuilder();
           for(int i=0;i<fwa.length;i++) 
               sbYear.append(fwa[i].getDate().getYear()+",");
                  

        %>
            <script type="text/javascript">  
                //Convert all Java arrays to Javascript arrays
                var temp="<%=sbDay.toString()%>";
                var day = new Array();
                window.day = temp.split(',','<%=test.length%>');
                
                var temp="<%=sbHour.toString()%>";
                var hour = new Array();
                window.hour = temp.split(',','<%=test.length%>');
                
                var temp="<%=sbMin.toString()%>";
                var min = new Array();
                window.min = temp.split(',','<%=test.length%>');
                
                var temp="<%=sbMonth.toString()%>";
                var month = new Array();
                window.month = temp.split(',','<%=test.length%>');
                
                var temp="<%=sbYear.toString()%>";
                var year = new Array();
                window.year = temp.split(',','<%=test.length%>');

                //alert("array: "+array);
                
                window.formattedEventData = []; 
                
                //alert(value);  
                         </script>
        <title>UTA Advising</title>
        <link rel='stylesheet' href='css/fullcalendar.css' />
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
        <jsp:include page="header.jsp" />

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
        <script type="text/javascript" src="js/StudentCalendar.js"></script>
       
</html>
