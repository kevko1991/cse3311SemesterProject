$( "#timeaccordion" ).accordion({
heightStyle: "content",
collapsible: true
});
$( "#navigationAccordion" ).accordion({ heightStyle: "content", collapsible: true});
$( "#subjectselectmenu" ).selectmenu();
$( "#serviceselectmenu" ).selectmenu();
//$( "#timeaccordion" ).accordion({ heightStyle: "content" });
$("#submitBtn").button().click(function(){});


$(document).ready(function() {
// page is now ready, initialize the calendar...       
        var k;       
        for (var k = 0; k < day.length; k++) {
        formattedEventData.push({            
            title: 'Available',
            start: new Date(year[k], month[k], day[k], hour[k], min[k], 0, 0),       
             });
        };
 
//force description into textarea...
$('#description').val(desc);

    //customize calendar settings
var calendar = $('#calendar').fullCalendar({
        defaultView: 'agendaDay',
        defaultDate: $('#date').val(),
        header: {
            left: '',
            center: 'title',
            right: ''
	}, 
       
             
        //when you click a event delete it
        eventClick: function(event, element) {  
            //get the date string and parse it to convert to a Date
            var eDate = Date.parse(event.start.toString());
            var cDate = new Date(eDate);
            eHour = cDate.getHours();
            eMin = cDate.getMinutes();
            $('input[name="date"]').val(event.start.toString());
        },
        
        
        //load events
        events: formattedEventData
                          
    })//fullcalendar end
  
});//ready end
