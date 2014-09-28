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


$(document).ready(function() {
    var formattedEventData = new Array();
    var k; 
    alert(size);
        if (size == null) //If formatted EventData will not exist
        { //Create a fake event data          
            formattedEventData.push({
                start: new Date(0, 0, 0, 0, 0, 0, 0)
            });
        }
        else
        {      
        for (var k = 0; k < size; k++) {
        formattedEventData.push({            
            start: new Date(year[k], month[k], day[k], hour[k], min[k], 0, 0), 
            title: "Timeslot"
             });
        };
    }
    
    //customize calendar settings
var calendar = $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek'
	},       
        
        
        //when you click a event delete it
        eventClick: function(event, element) { 
        //alert(event.title + ' has been deleted');
           // calendar.fullCalendar( 'removeEvents', event._id );
        },
        
        
        //load events
        events: formattedEventData,
                      
    })//fullcalendar end
  
});//ready end
