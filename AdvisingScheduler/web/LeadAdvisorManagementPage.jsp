<%-- 
    Document   : LeadAdvisorManagementPage
    Created on : Apr 6, 2015, 9:23:15 PM
    Author     : Ross
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="uta.cse4361.businessobjects.AdvisorAccount"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Department Advisors</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <jsp:include page="navigationbar.jsp"/>
        <jsp:include page="header.jsp"/>
        <jsp:useBean id="dm" class="uta.cse4361.databases.DatabaseManager" scope="page"/>
        <jsp:useBean id="bean" class="uta.cse4361.beans.AssignStudentAdvisorBean" scope="request"/>
        
        <%
            dm = new uta.cse4361.databases.DatabaseManager();             
            AdvisorAccount leadAdvisor;
            java.util.ArrayList<AdvisorAccount> departmentAdvisors;
            String message = "";
            
            leadAdvisor = dm.getAccount((Integer)session.getAttribute("id")); 
            departmentAdvisors = dm.getAdvisorsFromDepartment(leadAdvisor.getDepartment());
            bean = new uta.cse4361.beans.AssignStudentAdvisorBean(departmentAdvisors);
            
            if(!request.getParameterMap().isEmpty()){
                for(AdvisorAccount aa: departmentAdvisors){
                    if(!(request.getParameter("start" + Integer.toString(aa.getID())) == null)){
                        aa.setAssignment(request.getParameter("start" + Integer.toString(aa.getID()))
                                        + "-"
                                        + request.getParameter("end" + Integer.toString(aa.getID())));                                
                    }
                            }
                message = bean.execute();
            }   
        %>
        
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h1 class="panel-title">Advisor Details - <%out.print(leadAdvisor.getDepartment());%></h1>
                        </div>
                        <div class="panel-body">                    
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Assignment</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        for(AdvisorAccount aa: departmentAdvisors){
                                            out.print(  "<tr>"
                                                            + "<td>" + aa.getName() + "</td>"
                                                            + "<td>" + aa.getAssignment() + "</td>" +
                                                        "</tr>");
                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>                
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h1 class="panel-title">Edit Advisor Assignments Form</h1>
                        </div>
                        <div class="panel-body">
                            <form action="#" method="POST" id="assignmentform" role="form" class="form-inline">
                                <%
                                    for(AdvisorAccount aa: departmentAdvisors){
                                        out.print("<fieldset>"
                                                + "<legend>"+aa.getName()+"</legend>"
                                                + "<div class=\"form-group\">"
                                                    + "<label class=\"control-label col-sm-2\" for=\"start" + Integer.toString(aa.getID()) +"\">Start:</label>"
                                                    + "<div class=\"col-sm-10\">"
                                                        + "<select name=\"start" + Integer.toString(aa.getID()) + "\" id=\"start" + Integer.toString(aa.getID()) + "\" class=\"form-control\">"                                                                                                            
                                                            + "<option value=\"A\">A</option>"
                                                            + "<option value=\"B\">B</option>"
                                                            + "<option value=\"C\">C</option>"
                                                            + "<option value=\"D\">D</option>"
                                                            + "<option value=\"E\">E</option>"
                                                            + "<option value=\"F\">F</option>"
                                                            + "<option value=\"G\">G</option>"
                                                            + "<option value=\"H\">H</option>"
                                                            + "<option value=\"I\">I</option>"
                                                            + "<option value=\"J\">J</option>"
                                                            + "<option value=\"K\">K</option>"
                                                            + "<option value=\"L\">L</option>"
                                                            + "<option value=\"M\">M</option>"
                                                            + "<option value=\"N\">N</option>"
                                                            + "<option value=\"O\">O</option>"
                                                            + "<option value=\"P\">P</option>"
                                                            + "<option value=\"Q\">Q</option>"
                                                            + "<option value=\"R\">R</option>"
                                                            + "<option value=\"S\">S</option>"
                                                            + "<option value=\"T\">T</option>"
                                                            + "<option value=\"U\">U</option>"
                                                            + "<option value=\"V\">V</option>"
                                                            + "<option value=\"W\">W</option>"
                                                            + "<option value=\"X\">X</option>"
                                                            + "<option value=\"Y\">Y</option>"
                                                            + "<option value=\"Z\">Z</option>"
                                                        + "</select>"
                                                    + "</div>"
                                                + "</div>"
                                                + "<div class=\"form-group\">"
                                                    + "<label class=\"control-label col-sm-2\" for=\"end" + Integer.toString(aa.getID()) + "\">End:</label>"
                                                    + "<div class=\"col-sm-10\">"
                                                        + "<select name=\"end" + Integer.toString(aa.getID()) + "\" id=\"end" + Integer.toString(aa.getID()) + "\" class=\"form-control\">"
                                                            + "<option value=\"A\">A</option>"
                                                            + "<option value=\"B\">B</option>"
                                                            + "<option value=\"C\">C</option>"
                                                            + "<option value=\"D\">D</option>"
                                                            + "<option value=\"E\">E</option>"
                                                            + "<option value=\"F\">F</option>"
                                                            + "<option value=\"G\">G</option>"
                                                            + "<option value=\"H\">H</option>"
                                                            + "<option value=\"I\">I</option>"
                                                            + "<option value=\"J\">J</option>"
                                                            + "<option value=\"K\">K</option>"
                                                            + "<option value=\"L\">L</option>"
                                                            + "<option value=\"M\">M</option>"
                                                            + "<option value=\"N\">N</option>"
                                                            + "<option value=\"O\">O</option>"
                                                            + "<option value=\"P\">P</option>"
                                                            + "<option value=\"Q\">Q</option>"
                                                            + "<option value=\"R\">R</option>"
                                                            + "<option value=\"S\">S</option>"
                                                            + "<option value=\"T\">T</option>"
                                                            + "<option value=\"U\">U</option>"
                                                            + "<option value=\"V\">V</option>"
                                                            + "<option value=\"W\">W</option>"
                                                            + "<option value=\"X\">X</option>"
                                                            + "<option value=\"Y\">Y</option>"
                                                            + "<option value=\"Z\">Z</option>"
                                                        + "</select>"
                                                    + "</div>"
                                                + "</div>"
                                                + "</fieldset>"
                                                + "<hr>");
                                    }
                                %>
                                <div class="pull-right">
                                    <input type="submit" value="Apply" id="submitBtn" class="btn btn-primary">                                    
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8"></div>
                <div class="col-md-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Form Response
                        </div>
                        <div class="panel-body">
                            <%                      
                                out.print(message);
                            %>
                            
                        </div>
                    </div>                   
                </div>
            </div>
        </div>
        
        
    </body>
    <jsp:include page="footer.jsp"/>
</html>

