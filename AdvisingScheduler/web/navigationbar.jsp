<nav class="navbar navbar-inverse" >
    <% 
        int rank = -1;
        int sessionid = -1;
        if(!(session.getAttribute("id") == null)){
        sessionid = Integer.parseInt((String)session.getAttribute("id"));
    }
        if(!(session.getAttribute("rank") == null)){
        rank = Integer.parseInt((String)session.getAttribute("rank"));
    }
    %>
    
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
      </button>
      <a class="navbar-brand" href="index.jsp">UTA Advising</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active home"><a href="index.jsp">Home</a></li>
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
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
