<%-- 
    Document   : appointmentEdit
    Created on : Oct 27, 2014, 11:02:21 PM
    Author     : Melissa
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="uta.cse4361.businessobjects.Slot"%>
<%@page import="uta.cse4361.databases.DatabaseManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
            <jsp:include page="header.jsp" />
    <body>
        <table id="table">
            <tr>
                <jsp:include page="sidebar.jsp" />
                <jsp:useBean id="dm" class="uta.cse4361.databases.DatabaseManager" scope="session"/>
                
                <td style="vertical-align: top; float: right;">
                    <div style="width:780px" id="mainAccordion">

                            <h3>Timeslot Edit</h3>
                            <div>
                                
                                <%
                                dm = new DatabaseManager(); 
                                    ArrayList<Slot> slots = dm.getSlots();//(Integer.parseInt(request.getParameter("slotID"))); 
                                    Slot slot = null;
                                    int i = 0;
                                    while (slots.get(i).getAppointmentId() != (Integer.parseInt(request.getParameter("slotID"))))
                                    {
                                        if (slots.get(i).getAppointmentId() == (Integer.parseInt(request.getParameter("slotID"))))
                                        {
                                            slot = slots.get(i);
                                        }
                                        i++;
                                    }
                                    
                                    if(slot == null)
                                    {
                                        
                                    }
                                    else
                                    {
                                        out.print("hi");
                                        out.print(slot.getDate().getMonth()+1+"/"+slot.getDate().getDate()+"/"+(slot.getDate().getYear()+1900));
                                        out.print(slot.getHour() + ":");
                                         if(slot.getMinute() == 0)
                                        {
                                            out.print("00");
                                        }
                                        else
                                        {
                                            out.print(slot.getMinute());
                                        }
                                        
                                    }
//                                    out.print(appt.getDate() + " " + appt.getAdvisorName());
//                                    String advisorName = appt.getAdvisorName();
//                                    String description= appt.getDescription();
//                                    String date = "" + (appt.getDate().getMonth()+1) + "/" + appt.getDate().getDate() + "/" + (appt.getDate().getYear()+1900);
//                                    String startTime = "" + appt.getStartHour() + ":" + appt.getStartMinute();
//                                    String endTime = "" + appt.getEndHour() + ":" + appt.getEndMinute();
                                %>
                            
                                <form name="cancel" action="" onSubmit="">
                                            <input type="submit" value="Cancel Timeslot" id="cancelBtn">
                                </form>
                            </div>

                    </div>                   
                </td>
                
                
            </tr>
            
        </table>
    </body>
    <jsp:include page="footer.jsp" />
        <script type="text/javascript" src="js/timeslotEdit.js"></script>
</html>
