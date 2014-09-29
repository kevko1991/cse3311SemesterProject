<%-- 
    Document   : index
    Created on : Sep 12, 2014, 2:12:40 PM
    Author     : Melissa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>UTA Advising</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
   </head>
        <jsp:include page="header.jsp" />
        
        
    <body>
        <table id="table">
            <tr>
                <jsp:include page="sidebar.jsp" />
                
                <td style="vertical-align: top; float: right;">
                    <div style="width:780px" id="mainAccordion">

                            <h3>Welcome</h3>
                            <div>
                            Welcome to UTA Advising DEMO.
                            </div>

                    </div>                   
                </td>
                
                
            </tr>
            
        </table>
       
    </body>
    
        <jsp:include page="footer.jsp" />
        <script type="text/javascript" src="js/index.js"></script>
</html>
