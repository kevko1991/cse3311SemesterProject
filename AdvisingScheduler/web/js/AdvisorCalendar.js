$( "#navigationAccordion" ).accordion({ heightStyle: "content" });
$( "#subjectselectmenu" ).selectmenu();
$( "#serviceselectmenu" ).selectmenu();
$( "#timeaccordion" ).accordion({ heightStyle: "content", collapsible: "true" });
$( "#button").button(); 

//Andrews code
$(function() {
    $( "#datepicker" ).datepicker({ minDate: 0, maxDate: "+14D" });
});

options = {'step': 15, 
    'minTime': '7:00am',
    'maxTime': '7:00pm',
     'timeFormat': 'h:i A'};

$('#starttimepicker').timepicker(options);
$('#endtimepicker').timepicker(options);
    var formattedEventData = new Array();

$(document).ready(function() {

    var k; 
//    
//        formattedEventData.push({            
//            start: new Date(2014, 8, 3, 1, 30, 0, 0), 
//            title: "Timeslot"
//             });
//             alert(size);
if(size>0)
{
        for (var k = 0; k < size; k++) {
        formattedEventData.push({            
            start: new Date(year[k], month[k], day[k], hour[k], min[k], 0, 0), 
            title: "Timeslot"
             });
        };
        }
//        alert("p3: " + size);
var calendar = $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek'
	},       
        
        //load events
        events: formattedEventData
                      
    })//fullcalendar end
  
});//ready end
