$( "#navigationAccordion" ).accordion({ heightStyle: "content" });
$( "#subjectselectmenu" ).selectmenu();
$( "#serviceselectmenu" ).selectmenu();
$( "#timeaccordion" ).accordion({ heightStyle: "content" });
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
//        alert(a.toString());
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
     //alert(event.title + ' has been deleted');
        //calendar.fullCalendar( 'removeEvents', event._id );
        //alert('Description: ' + event.description);        
        //event.title = "CLICKED!";
        //calendar.fullCalendar('updateEvent', event);
//        alert(eHour +':'+ eMin);
        },
        
        
        //load events
        events: formattedEventData
        
        
                //When you click a day, create a new object
//        dayClick: function(date, jsEvent, view) {
//            $(this).css('background-color', 'red');             
//            var eventObject = {
//			id:    				111,
//			title: 				''+date.format(), 
//			start: 				new Date(date.get('year'), date.get('month'), date.get('date')).toISOString(),
//			end: 				new Date(date.get('year'), date.get('month'), date.get('date')).toISOString(),
//			backgroundColor: 	$(ui.item).css('background-color'),
//                        borderColor: 		$(ui.item).css('background-color'),
//                        textColor: 			$(ui.item).css('color'),
//                        allDay: true 
//                        }; //eventobject end
//             calendar.fullCalendar('renderEvent', eventObject ,true);
            //window.location.href = "Calendar.jsp"; //redirect once click on day
//        },
                      
    })//fullcalendar end
  
});//ready end
