$( "#timeaccordion" ).accordion({
heightStyle: "content",
collapsible: true
});
$( "#navigationAccordion" ).accordion({ heightStyle: "content", collapsible: true});
//$( "#timeaccordion" ).accordion({ heightStyle: "content" });
$("#submitBtn").button().click(function(){});

$(document).ready(function() {
// page is now ready, initialize the calendar...       
    var formattedEventData = new Array();
    var k; 
    
    for (var k = 0; k < size; k++) {
        formattedEventData.push({            
            start: new Date(year[k], month[k], day[k], hour[k], min[k], 0, 0), 
            sHour: hour[k], 
            sMin: min[k],  
            title: "Timeslot"
             });
        };
//    }
 
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
            if(event.sMin === '0'){
                $('input[name="startTime"]').val(event.sHour+":00"); //24 hour format
            }
            else{
                $('input[name="startTime"]').val(event.sHour+":" + event.sMin); //24 hour format
            }
            //fix this later
            if(event.sMin === '45')
            {
                $('input[name="endTime"]').val((event.sHour+1)+":00");
            }
            if(event.sMin === '0')
            {
                $('input[name="endTime"]').val((event.sHour)+":15");
            }
            if(event.sMin === '15')
            {
                $('input[name="endTime"]').val((event.sHour)+":30");
            }
            if(event.sMin === '30')
            {
                $('input[name="endTime"]').val((event.sHour)+":45");
            }
        },
        
        //load events
        events: formattedEventData
                          
    })//fullcalendar end
  
});//ready end
