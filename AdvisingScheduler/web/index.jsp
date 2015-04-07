<%-- 
    Document   : index
    Created on : Sep 12, 2014, 2:12:40 PM
    Author     : Melissa
--%>

<%@page contentType='text/html' pageEncoding='UTF-8'%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>UTA Advising</title>
        <meta charset='UTF-8'>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    </head>

    <body>

        <jsp:include page='navigationbar.jsp' />
        
            <jsp:include page='header.jsp' />
             <% 
                            int rank = -1;
                            int sessionid = -1;
                            int firstlog = 0;
                            if(!(session.getAttribute("id") == null)){
                            sessionid = ((Integer)session.getAttribute("id"));
                        }
                            if(!(session.getAttribute("rank") == null)){
                            rank = ((Integer)session.getAttribute("rank"));
                        }
                            if(!(session.getAttribute("FirstLog") == null)){
                                firstlog = ((Integer)session.getAttribute("FirstLog"));
                            }
             %>
             
             <div class="container panel panel-default">
                 
                 <div class="row centerthis">
                     
                     <div class="col-md-6">
                         <h3>Faculty</h3>
                         
                         <div>
                             <%
                            if (rank == -1){
                                out.print("Would you like to check on your current schedule?<br><br>"
                                        + " <input type='submit' value='Login to your account' id='loginBtn' class='btn btn-default'>"
                                        );
                            }
                            if (rank == 1){
                                out.print("Welcome administrator.");
                            }
                            if (rank == 0){
                                out.print("Welcome faculty member.");
                                
                                //trying to create a call to the dialog box when it detects a first login
                                if(firstlog == 1){
                                    response.sendRedirect("EditAccount.jsp");
                                }
                            }
                            %>
                         </div>
                     </div>
                     
                     <div class="col-md-6">
                         
                            <%
                            if(rank == -1){
                                out.print("<h3>Student</h3>"
                                        + "<div>"
                                        + "Would you like to schedule an appointment with an advisor?<br><br>"
                                        + "<form action='schedule.jsp'>"
                                        + "<input type='submit' value='Make an appointment' id='scheduleBtn' class='btn btn-default'>"
                                        + "</form>"
                                        + "</div>");
                            }
                            %>
                         
                     </div>
                     
                 </div>
                 
             </div>
             
            


        

    </body>
    <jsp:include page='footer.jsp' />

    <script type='text/javascript' src='js/index.js'></script>
</html>
