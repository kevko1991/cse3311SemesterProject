<%-- 
    Document   : Calendar
    Created on : Sep 12, 2014, 9:59:13 PM
    Author     : Melissa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>    
        <jsp:useBean id="fdm" class="uta.cse4361.businessobjects.FlyweightDatabaseManager" scope="session"/>
        <%!
        public int getHour(String time){
            String[] hour = time.split(":");
            return Integer.parseInt(hour[0]);
        }
        public int getMin(String time){
            return Integer.parseInt(time.substring(time.length()-2));
        }
        %>
        
        <% 
            
            java.text.DateFormat format = new java.text.SimpleDateFormat("MM/dd/yyyy");
            java.util.Date newDate = format.parse(request.getParameter("date"));
            
            
            fdm = new uta.cse4361.businessobjects.FlyweightDatabaseManager();
            java.util.ArrayList<uta.cse4361.businessobjects.Flyweight> fw = fdm.getDaysFlyweights(newDate);
  
           int fwsize= fw.size();
           //Retrieve all the data into seperate parts
            StringBuilder sbDay = new StringBuilder();
            for(int i=0;i<fwsize;i++) 
                sbDay.append(fw.get(i).getDate().getDate()+",");

            StringBuilder sbHour = new StringBuilder();
            for(int i=0;i<fwsize;i++) 
                sbHour.append(fw.get(i).getTime()/60+",");

            StringBuilder sbMin = new StringBuilder();
            for(int i=0;i<fwsize;i++) 
                sbMin.append(fw.get(i).getTime()%60+",");

            StringBuilder sbMonth = new StringBuilder();
            for(int i=0;i<fwsize;i++) 
                sbMonth.append(fw.get(i).getDate().getMonth()+",");

            StringBuilder sbYear = new StringBuilder();
            for(int i=0;i<fwsize;i++) 
                sbYear.append((fw.get(i).getDate().getYear()+1900)+",");     
                  
           
           String desc = request.getParameter("description");
           
           boolean timeSubmitted =  !(request.getParameter("startTime")==null || request.getParameter("startTime")=="");
        %>
        
        
        
        <!--<script type="text/javascript" src="js/arrayProcess.js"></script>-->                
        <jsp:useBean id="newAppt" class="uta.cse4361.businessobjects.ScheduleAppointmentControllerBean"/> 
        <jsp:setProperty name="newAppt" property="studentID" param="sID" /> 
        <jsp:setProperty name="newAppt" property="studentName" param="sName" /> 
        <jsp:setProperty name="newAppt" property="date" value='<%= newDate%>' /> 
        <jsp:setProperty name="newAppt" property="description" param="description" /> 
        <% if(timeSubmitted){ %>
        <jsp:setProperty name="newAppt" property="startHour" value= '<%= getHour(request.getParameter("startTime")) %>'/>
        <jsp:setProperty name="newAppt" property="startMinute" value= '<%= getMin(request.getParameter("startTime")) %>'/>
        <jsp:setProperty name="newAppt" property="endHour" value= '<%= getHour(request.getParameter("endTime")) %>'/>
        <jsp:setProperty name="newAppt" property="endMinute" value= '<%= getMin(request.getParameter("endTime")) %>'/>
        <%}%>
        <title>Advising Calendar</title>
        <link rel='stylesheet' href='css/fullcalendar.css' />
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
        <jsp:include page="header.jsp" />

    <body>    
        <table id="table">
            <tr>
                    <div style="width:1090px" id="navigationAccordion">
                        <h3>Navigation</h3>
                        <div>
                            <a href="schedule.jsp">Schedule Appointment</a><br>
                            <a href="AdvisorCalendar.jsp">Advisor Calendar</a><br>                    
                        </div>
                    </div>
                
            </tr>          
            <tr>
                <td style="vertical-align: top; width:545px">
                    
                        <div style="width:545px" id="scheduleAccordion">
                            <h3>Appointment Summary</h3>
                                <div>                         
                                    <form name="appointmentSummary">
                                        <table>
                                            <tr>
                                                <td>
                                        Student ID:
                                                </td>
                                                <td>
                                        <input type="text" name="sID" id="sID" value="<jsp:getProperty name="newAppt" property="studentID"/>"  readonly="readonly"><br>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                        Student Name:
                                                </td>
                                                <td>
                                        <input type="text" name="sName" id="sName" value="<jsp:getProperty name="newAppt" property="studentName"/>" readonly="readonly"><br>
                                                </td>
                                            </tr>
<!--                                            <tr>
                                                <td>
                                        Advisor:
                                                </td>
                                                <td>
                                        <select name="aName" id="aName" readonly="readonly">
                                            <option value="Linda Barasch">Linda Barasch</option>
                                            <option value="Bob Weems">Bob Weems</option>
                                        </select><br>
                                                </td>
                                        </tr>-->
                                        <tr>
                                                <td>
                                        Date:
                                                </td>
                                                <td>
                                        <input type="text" name="date" id="date" size="52" value="<%= request.getParameter("date") %>" readonly="readonly"><br>
                                                </td>
                                        </tr>
                                        <tr>
                                                <td>
                                        Start Time:
                                                </td>
                                                <td>
                                        <input type="text" id="startTime" name="startTime" size="52" value="" readonly="readonly"><br>
                                                </td>
                                        </tr>
                                        <tr>
                                                <td>
                                        End Time:
                                                </td>
                                                <td>
                                        <input type="text" id="endTime" name="endTime" size="52" value="" readonly="readonly"><br>
                                                </td>
                                        </tr>
                                        <tr>
                                                <td>
                                        Description: 
                                                </td>
                                                <td>
                                        <textarea name="description" id="description" rows="6" cols="50" value="" readonly="readonly"></textarea><br>
                                                </td>
                                        </table>
                                        <input type="submit" value="Make Appointment" id="submitBtn">
                                    </form>
                                    <%if(timeSubmitted){
                                            String result = newAppt.scheduleAppointment(); 

                                            if(result==""){
                                                response.sendRedirect("AppointmentDetails.jsp");
                                            }
                                            else{
                                                out.println(result);
                                            }
                                        }%>
                                </div>                              
                        </div>

                <td style="vertical-align: top; float: right;">
                    <div style="vertical-align: top; float: right; width:545px" id="timeaccordion">
                        <h3>Calendar</h3>
                        <div id="calendar">                            
                        </div>                                           
                    </div>
                </td>
                </td>
                
                
            </tr>
            
        </table>

    </body>
    
        <jsp:include page="footer.jsp" />
                <script type="text/javascript">
                    
                window.size = '<%=fwsize%>';
                                    
                var temp="<%=sbDay.toString()%>";                               
                var day = new Array(); 
                window.day = temp.split(',',size);

                var temp="<%=sbHour.toString()%>";
                var hour = new Array();
                window.hour = temp.split(',',size);

                var temp="<%=sbMin.toString()%>";
                var min = new Array();
                window.min = temp.split(',',size);

                var temp="<%=sbMonth.toString()%>";
                var month = new Array();
                window.month = temp.split(',',size);

                var temp="<%=sbYear.toString()%>";
                var year = new Array();
                window.year = temp.split(',',size);

                
                
                //alert("array: "+array);
                
                var desc = "<%=desc%>";
        </script> 
        <script type="text/javascript" src="js/fullcalendar/moment.min.js"></script>
        <script type="text/javascript" src="js/fullcalendar/fullcalendar.js"></script>
        <script type="text/javascript" src="js/StudentCalendar.js"></script>
       
</html>
