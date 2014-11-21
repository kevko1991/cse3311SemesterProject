<%-- 
    Document   : Calendar
    Created on : Sep 12, 2014, 9:59:13 PM
    Author     : Melissa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uta.cse4361.databases.DatabaseManager"%>
<html>
    <head>    
        <%--<jsp:useBean id="dm" class="DatabaseManager" scope="session"/>--%>
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
            
            
            DatabaseManager dm = new DatabaseManager();
            java.util.ArrayList<uta.cse4361.businessobjects.Slot> fw = dm.getTypeSlots();
  
           int fwsize= fw.size();
          
           
           StringBuilder sbAppt = new StringBuilder();
            for(int i=0;i<fwsize;i++) 
                    sbAppt.append(fw.get(i).isAppointment()+",");        
                   
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
        <jsp:useBean id="newAppt" class="uta.cse4361.beans.ScheduleAppointmentBean"/> 
        <jsp:setProperty name="newAppt" property="studentID" param="sID" /> 
        <jsp:setProperty name="newAppt" property="studentName" param="sName" /> 
        <jsp:setProperty name="newAppt" property="advisorName" param="aName" /> 
        <jsp:setProperty name="newAppt" property="type" param="type" /> 
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

    <body>    
        <jsp:include page="navigationbar.jsp" />
        
        <div id="wrapper">
        <jsp:include page="header.jsp" />
        <table id="table" style="margin:0 auto;">       
            <tr>
                <td style="vertical-align: top;">
                    
                        <div id="scheduleAccordion" style="vertical-align: top;">
                            <h3>Appointment Summary</h3>
                                <div>                         
                                    <form name="appointmentSummary">
                                        <table>
                                            <tr>
                                                <td>
                                        Student ID
                                                </td>
                                                <td>
                                        <input type="text" name="sID" id="sID" size="30" value="<jsp:getProperty name="newAppt" property="studentID"/>"  readonly="readonly"><br>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                        Student Name
                                                </td>
                                                <td>
                                        <input type="text" name="sName" id="sName" size="30" value="<jsp:getProperty name="newAppt" property="studentName"/>" readonly="readonly"><br>
                                                </td>
                                            </tr>
                                          <tr>
                                                <td>
                                        Advisor
                                                </td>
                                                <td>
                                        <input type="text" name="aName" id="aName" size="30" value="<jsp:getProperty name="newAppt" property="advisorName"/>" readonly="readonly"><br>
                                                </td>
                                        </tr>
                                        <tr>
                                                <td>
                                        Advising Type
                                                </td>
                                                <td>
                                        <input type="text" name="type" id="type" size="30" value="<jsp:getProperty name="newAppt" property="type"/>" readonly="readonly"><br>
                                                </td>
                                        </tr>
                                        <tr>
                                                <td>
                                        Date
                                                </td>
                                                <td>
                                        <input type="text" name="date" id="date" size="30" value="<%= request.getParameter("date") %>" readonly="readonly"><br>
                                                </td>
                                        </tr>
                                        <tr>
                                                <td>
                                        Start Time
                                                </td>
                                                <td>
                                        <input type="text" id="startTime" name="startTime" size="30" value="" readonly="readonly"><br>
                                                </td>
                                        </tr>
                                        <tr>
                                                <td>
                                        End Time
                                                </td>
                                                <td>
                                        <input type="text" id="endTime" name="endTime" size="30" value="" readonly="readonly"><br>
                                                </td>
                                        </tr>
                                        <tr>
                                                <td>
                                        Description 
                                                </td>
                                                <td>
                                        <textarea name="description" id="description" rows="6" cols="30" value="" readonly="readonly"></textarea><br>
                                                </td>
                                        </table>
                                                <br>
                                                <div class="centerthis">
                                        <input type="submit" value="Make Appointment" id="submitBtn">
                                                </div><br><br>
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
                    <div style="vertical-align: top; float: right" id="timeaccordion">
                        <h3>Calendar</h3>
                        <div id="calendar">                            
                        </div>                                           
                    </div>
                </td>
                </td>
                
                
            </tr>
            
        </table>
        </div>

    </body>
    
        <jsp:include page="footer.jsp" />
                <script type="text/javascript">
                    
                window.size = '<%=fwsize%>';
                
                var temp="<%=sbAppt.toString()%>";                               
                var isAppt = new Array(); 
                window.isAppt = temp.split(',',size);   
    
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
