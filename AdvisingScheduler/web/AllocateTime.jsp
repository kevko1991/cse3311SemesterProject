<%-- 
    Document   : AllocateTime
    Created on : Sep 23, 2014, 8:02:28 PM
    Author     : Andrew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Allocate Time</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <jsp:include page="header.jsp" />
    <body>
        
        <div id="accordion">
            <h3>Allocate Time</h3>
            <div>
            <p>Date: <input type="text" id="datepicker"></p>
            <p>Start Time: <input type="text" id = "starttimepicker"></p>
            <p>End Time: <input type="text" id ="endtimepicker"></p>
            </div>
        </div>
        <!-- <form>
        <input type="text" name="date" id="date">
        </form>
       -->
    </body>
    <jsp:include page="footer.jsp" />
    <script type="text/javascript" src="js/AllocateTime.js"></script>
    <script type="text/css" src="css/jquery.timepicker.css"></script>
</html>
