<%-- 
    Document   : appointmentEdit
    Created on : Oct 27, 2014, 11:02:21 PM
    Author     : Melissa
--%>

<%@page import="java.util.Date"%>
<%@page import="uta.cse4361.businessobjects.Appointment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uta.cse4361.businessobjects.Slot"%>
<%@page import="uta.cse4361.databases.DatabaseManager"%>
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
                    <div style="width:780px" id="mainAccordion">

                            <h3>Timeslot Edit</h3>
                            <div>
                                
                                <%
                                    
                                   
                                    boolean dSubmit = false;
                                    boolean startHourSubmit = false;
                                    boolean endHourSubmit = false;
                                    boolean startMinSubmit = false;
                                    boolean endMinSubmit = false;
                                    boolean readyToDelete = false;
                                                                       
                                    
                                    Date d = null; 
                                    int startHour = 0; 
                                    int endHour = 0; 
                                    int startMin = 0; 
                                    int endMin = 0;

                                    if(request.getParameter("slotID") == null || request.getParameter("slotID").equals(""))
                                    {
                                        response.sendRedirect("modifyTimeslot.jsp");
                                    }
                                    else
                                    {
                                        
                                        DatabaseManager dm = new DatabaseManager(); 
                                        int id = Integer.parseInt(request.getParameter("slotID").substring(1));
                                        
                                        
                                        

                                        if(request.getParameter("slotID").substring(0, 1).equals("s"))
                                        {
                                            ArrayList<Slot> slots = dm.getAvailableSlots();
                                            Slot slot = null;
                                            int i = 0;
                                            for(Slot s : slots)
                                            {
                                                if (s.getAppointmentId() == (id))
                                                {
                                                    slot = slots.get(i);
                                                    
                                                }
                                            }
                                            if(slot == null)
                                            {

                                            }
                                            else
                                            {
                                                d = slot.getDate(); 
                                                startHour = slot.getHour(); 
                                                endHour = startHour; 
                                                startMin = slot.getMinute();
                                                if(startMin ==45)
                                                {
                                                    endHour = endHour+1;
                                                    endMin = 0;
                                                }
                                                else
                                                {
                                                    endMin = startMin + 15;
                                                }
                                                out.print("<table border='1' cellpadding= '3' cellspacing= '0' style='border: 1pt solid #000000; border-Collapse: collapse'>");
                                                out.print("<tr>");                                          
                                                out.print("<td>");
                                                out.print("Date: ");
                                                out.print("</td>");                                            
                                                out.print("<td>");
                                                out.print(slot.getDate().getMonth()+1+"/"+slot.getDate().getDate()+"/"+(slot.getDate().getYear()+1900));
                                                out.print("</td>");
                                                out.print("</tr>");


                                                out.print("<tr>");
                                                out.print("<td>");
                                                out.print("Start Time: ");
                                                out.print("</td>");                                            
                                                out.print("<td>");
                                                out.print(slot.getHour()+ ":");
                                                if(slot.getMinute()== 0)
                                                {
                                                    out.print("00");
                                                }
                                                else
                                                {
                                                    out.print(slot.getMinute());
                                                }
                                                out.print("</td>");
                                                out.print("</tr>");
                                                out.print("</table>");

                                            }
                                        }
                                        else
                                        {
                                            Appointment appt = dm.getAppointment(id); 
                                            d = appt.getDate(); 
                                            startHour = appt.getStartHour(); 
                                            endHour = appt.getEndHour(); 
                                            startMin = appt.getStartMinute(); 
                                            endMin = appt.getEndMinute();

                                            out.print("<table border='1' cellpadding= '3' cellspacing= '0' style='border: 1pt solid #000000; border-Collapse: collapse'>");
                                            out.print("<tr>");                                          
                                            out.print("<td>");
                                            out.print("Date: ");
                                            out.print("</td>");                                            
                                            out.print("<td>");
                                            out.print(appt.getDate().getMonth()+1+"/"+appt.getDate().getDate()+"/"+(appt.getDate().getYear()+1900));
                                            out.print("</td>");
                                            out.print("</tr>");
                                            
                                            
                                            out.print("<tr>");
                                            out.print("<td>");
                                            out.print("Start Time: ");
                                            out.print("</td>");                                            
                                            out.print("<td>");
                                            out.print(appt.getStartHour()+ ":");
                                            if(appt.getStartMinute()== 0)
                                            {
                                                out.print("00");
                                            }
                                            else
                                            {
                                                out.print(appt.getStartMinute());
                                            }
                                            out.print("</td>");
                                            out.print("</tr>");
                                            
                                            
                                            
                                            out.print("<tr>");
                                            out.print("<td>");
                                            out.print("End Time: ");
                                            out.print("</td>");                                            
                                            out.print("<td>");
                                            out.print(appt.getEndHour()+ ":");
                                            if(appt.getEndMinute()== 0)
                                            {
                                                out.print("00");
                                            }
                                            else
                                            {
                                                out.print(appt.getEndMinute());
                                            }
                                            out.print("</td>");
                                            out.print("</tr>");
                                            
                                            
                                            out.print("<tr>");
                                            out.print("<td>");
                                            out.print("Advisor: ");
                                            out.print("</td>");                                            
                                            out.print("<td>");
                                            out.print(appt.getAdvisorName());
                                            out.print("</td>");
                                            out.print("</tr>");
                                            
                                            
                                            out.print("<tr>");
                                            out.print("<td>");
                                            out.print("Advising Type: ");
                                            out.print("</td>");                                            
                                            out.print("<td>");
                                            out.print(appt.getType());
                                            out.print("</td>");
                                            out.print("</tr>");
                                            
                                            
                                            out.print("<tr>");
                                            out.print("<td>");
                                            out.print("Student: ");
                                            out.print("</td>");                                            
                                            out.print("<td>");
                                            out.print(appt.getStudentName());
                                            out.print("</td>");
                                            out.print("</tr>");
                                            
                                            
                                            out.print("<tr>");
                                            out.print("<td>");
                                            out.print("Description: ");
                                            out.print("</td>");                                            
                                            out.print("<td>");
                                            out.print(appt.getDescription());
                                            out.print("</td>");
                                            out.print("</tr>");
                                            
                                            out.print("</table>");
                                                    
                                        }
                                    }
                                    
                                    if(request.getParameter("first").equals("false"))
                                    {
                                        dSubmit = !(request.getParameter("d") == null)||(request.getParameter("d").equals(""));
                                        startHourSubmit = !(request.getParameter("startHour") == null)||(request.getParameter("startHour").equals(""));
                                        endHourSubmit = !(request.getParameter("endHour") == null)||(request.getParameter("endHour").equals(""));
                                        startMinSubmit = !(request.getParameter("startMin") == null)||(request.getParameter("startMin").equals(""));
                                        endMinSubmit = !(request.getParameter("endMin") == null)||(request.getParameter("endMin").equals(""));
                                        readyToDelete = dSubmit && startHourSubmit && endHourSubmit && startMinSubmit && endMinSubmit;
                                    }
                                        
                                %>
                            
                                <form name="cancel" action="timeslotEdit.jsp" type="submit">
                                    <input type="hidden" value="<%= request.getParameter("slotID") %>" name="slotID">
                                    <input type="hidden" value="false" name="first">
                                    <input type="hidden" value="<%= d %>" name="d">
                                    <input type="hidden" value="<%= startHour %>" name="startHour">
                                    <input type="hidden" value="<%= endHour %>" name="endHour">
                                    <input type="hidden" value="<%= startMin%>" name="startMin">
                                    <input type="hidden" value="<%= endMin%>" name="endMin">
                                <input type="submit" value="Cancel Timeslot" id="cancelBtn">
                                </form>
 <%
                                    if(readyToDelete)
                                    {
                                    %>
                                    <jsp:useBean id="mtb" class="uta.cse4361.beans.ModifyTimeSlotsBean" scope="session"/> 
                                    <jsp:setProperty name="mtb" property="date" value= "<%= d %>"/>
                                    <jsp:setProperty name="mtb" property="startHr" value= "<%= startHour %>"/>
                                    <jsp:setProperty name="mtb" property="endHr" value= "<%= endHour %>"/>
                                    <jsp:setProperty name="mtb" property="startMin" value= "<%= startMin %>"/>
                                    <jsp:setProperty name="mtb" property="endMin" value= "<%= endMin %>"/>
                                    <%
                                    mtb.modifySlot();
                                    response.sendRedirect("modifyTimeslot.jsp");
                                    }
                                    %>
                                
                            </div>

                    </div>                   
                </td>
                
                
            </tr>
            
        </table>
    </body>
    <jsp:include page="footer.jsp" />
        <script type="text/javascript" src="js/timeslotEdit.js"></script>
</html>
