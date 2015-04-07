
<div class="container">
    <nav class="navbar navbar-inverse navbar-static-top" role="navigation">
        <% 
            int rank = -1;
            int sessionid = -1;
            if(!(session.getAttribute("id") == null)){
            sessionid = ((Integer)session.getAttribute("id"));
        }
            if(!(session.getAttribute("rank") == null)){
            rank = ((Integer)session.getAttribute("rank"));
        }
        %>
        <div class="container-fluid" id="utalogo-banner">
            <img src="css/images/utalogo.png" alt="UTA Logo">
        </div>
      <div class="container-fluid">
        <div class="navbar-header">
          <button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span> 
          </button>
          <a class="navbar-brand" href="index.jsp">UTA Advising</a>
        </div>
        <div class="collapse navbar-collapse navHeaderCollapse">
          <ul class="nav navbar-nav">  
              <li> <!--For demo purpose only.  Add code to hide from non Lead Advisors. Add code to determine who is a Lead advisor-->
                  <a href="LeadAdvisorManagementPage.jsp">Manage</a>
              </li>   
            <%
            if(session.getAttribute("rank") == null)
            {

            }
            else{
                if (rank == 1){
                    out.print("<li class='account'>"
                            + "<a href='CreateAccount.jsp' >Create Account</a>"
                            + "</li>");
                }
                if (rank == 0){
                    out.print("<li class='calendar'>"
                            + "<a href='AdvisorCalendar.jsp' >Calendar</a>"
                            + "</li>");
                    out.print("<li class='timeslot'>"
                            + "<a href='modifyTimeslot.jsp' >Time slot</a>"
                            + "</li>");
                    out.print("<li class='appointment'>"
                            + "<a href='modifyAppointment.jsp' >Appointment</a>"
                            + "</li>");
                }
                if (rank == 1 || rank == 0){
                    out.print("<li class='logout'>"
                            + "<a href='logout.jsp' >Log Out</a>"
                            + "</li>");
                }
            }
            if ((session.getAttribute("id") == null) || (session.getAttribute("rank") == null)){
                out.print("<li class='schedule'>"
                        + "<a href='schedule.jsp' >Schedule Appointment</a>"
                        + "</li>");
            }
            %> 
          </ul>          
        </div>
      </div>
    </nav>
</div>          
<script type='text/javascript' src='js/index.js'></script>

