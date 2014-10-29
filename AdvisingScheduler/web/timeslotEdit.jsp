<%-- 
    Document   : appointmentEdit
    Created on : Oct 27, 2014, 11:02:21 PM
    Author     : Melissa
--%>

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
                                            ArrayList<Slot> slots = dm.getSlots();//(Integer.parseInt(request.getParameter("slotID"))); 
                                            Slot slot = null;
                                            int i = 0;
                                            while (slots.get(i).getAppointmentId() != (id))
                                            {
                                                if (slots.get(i).getAppointmentId() == (id))
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
                                        }
                                        else
                                        {
                                            Appointment appt = dm.getAppointment(id); 
                                        }
                                    }
                                %>
                            
                                <form name="cancel" action="" type="submit">
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
