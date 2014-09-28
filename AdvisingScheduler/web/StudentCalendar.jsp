<%-- 
    Document   : Calendar
    Created on : Sep 12, 2014, 9:59:13 PM
    Author     : Melissa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    
    <head>    
        
        
        <%
            java.text.DateFormat format = new java.text.SimpleDateFormat("MM/dd/yyyy");
            java.util.Date newDate = format.parse(request.getParameter("date"));
  
          //new java.util.Date(year, month, date, hrs, min)
           uta.cse4361.businessobjects.FlyweightDatabaseManager fdm = new uta.cse4361.businessobjects.FlyweightDatabaseManager();
           uta.cse4361.businessobjects.AvailableFlyweight fwa[] = new uta.cse4361.businessobjects.AvailableFlyweight[4];
           
           uta.cse4361.businessobjects.AvailableFlyweight fw = new uta.cse4361.businessobjects.AvailableFlyweight(new java.util.Date(2014, 8, 22, 5, 30), 6, 15);
           fwa[0] = fw;
           fw = new uta.cse4361.businessobjects.AvailableFlyweight(new java.util.Date(2014, 8, 2, 4, 10), 6, 15);
           fwa[1] = fw;
           fw = new uta.cse4361.businessobjects.AvailableFlyweight(new java.util.Date(2014, 8, 5, 6, 20), 6, 15);
           fwa[2] = fw;
           fw = new uta.cse4361.businessobjects.AvailableFlyweight(new java.util.Date(2014, 8, 22, 7, 30), 6, 15);
           fwa[3] = fw;
           
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
                  
           
           String desc = request.getParameter("description");
        %>
        
        <!--<script type="text/javascript" src="js/arrayProcess.js"></script>-->                
        <jsp:useBean id="newAppt" class="uta.cse4361.businessobjects.ScheduleAppointmentControllerBean"/> 
        <jsp:setProperty name="newAppt" property="studentID" param="sID" /> 
        <jsp:setProperty name="newAppt" property="studentName" param="sName" /> 
        <jsp:setProperty name="newAppt" property="date" value='<%= newDate%>' /> 
        <jsp:setProperty name="newAppt" property="description" param="description" /> 
        
        
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
       
        <table id="table">
            <tr>
                <jsp:include page="sidebar.jsp" />
        
                <td style="vertical-align: top; float: right;">
                    <div style="width:780px" id="timeaccordion">
                        <h3>Calendar</h3>
                        <div id="calendar">                            
                        </div>                        
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
                                            <input type="text" name="date" id="date" size="52" value="<jsp:getProperty name="newAppt" property="date"/>" readonly="readonly"><br>
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
                        </div>                            
                    </div>
                </td>
                
                
            </tr>
            
        </table>

    </body>
    
        <jsp:include page="footer.jsp" />
                <script type="text/javascript">
                    
                window.eHour = 0;
                window.eMin = 0;
                var temp="<%=sbDay.toString()%>";
                var day = new Array();
                window.day = temp.split(',','<%=fwa.length%>');
                
                var temp="<%=sbHour.toString()%>";
                var hour = new Array();
                window.hour = temp.split(',','<%=fwa.length%>');
                
                var temp="<%=sbMin.toString()%>";
                var min = new Array();
                window.min = temp.split(',','<%=fwa.length%>');
                
                var temp="<%=sbMonth.toString()%>";
                var month = new Array();
                window.month = temp.split(',','<%=fwa.length%>');
                
                var temp="<%=sbYear.toString()%>";
                var year = new Array();
                window.year = temp.split(',','<%=fwa.length%>');
                
                
                
                //alert("array: "+array);
                
                window.formattedEventData = []; 
                var desc = "<%=desc%>";
        </script> 
        <script type="text/javascript" src="js/fullcalendar/moment.min.js"></script>
        <script type="text/javascript" src="js/fullcalendar/fullcalendar.js"></script>
        <script type="text/javascript" src="js/StudentCalendar.js"></script>
       
</html>
