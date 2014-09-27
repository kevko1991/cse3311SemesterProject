$( "#accordion" ).accordion({ heightStyle: "content" });
$( "#subjectselectmenu" ).selectmenu();
$( "#serviceselectmenu" ).selectmenu();
$( "#timeaccordion" ).accordion({ heightStyle: "content" });


$(document).ready(function() {
    // page is now ready, initialize the calendar...
//        var date = new Date();
//        var d = date.getDate();
//        var m = date.getMonth();
//        var y = date.getFullYear();
//        var temp = new Date();
        
        //Create  array with data
//        var myArray = [];
//        for(var i = 1; i < 20; i+=2){
//            temp = new Date(2014, 8, i);
//            myArray.push(['Test'+i, temp]);
//        }
        //alert(window.value);

        //Format the data according to eventObject specifications
//        var formattedEventData = [], k;       
//        for (var k = 0; k < myArray.length; k++) {
//        formattedEventData.push({
//            title: myArray[k][0],
//            start: myArray[k][1],
//            allDay: true
//             });
//        };
        
        var k;       
        for (var k = 0; k < day.length; k++) {
        formattedEventData.push({            
            start: new Date(year[k], month[k], day[k], hour[k], min[k], 0, 0)             
             });
        };
        
        //Creating test data for showing occupied time slots
//        var sDate = new Date(2014, 8, 25, 5, 30, 20, 0); 
//        var eDate = new Date(2014, 8, 25, 7, 30, 20, 0);
                  //new Date(year, month, day, hours, minutes, seconds, milliseconds);        
//        formattedEventData.push({
//            title: 'Why do you torture me so!',
//            start: sDate,
//            end: eDate,
//            color: 'yellow',
//            textColor: 'black'
//        });
//        


//
//        formattedEventData.push({
//                title: 'this is important',
//                start: new Date(2014, 8, window.array[0], 7, 30, 20, 0), 
//                end: new Date(2014, 8, window.array[0], 7, 30, 20, 0),
//                color: 'yellow',
//                textColor: 'black'
//                });
                
                
                
                
//        alert(window.array[0]);
//        $('#targetElement').fullCalendar({
//            events: formattedEventData,
//            color: 'yellow',
//            textColor: 'black'
//        });

//        var value = "<%=d2%>";
//                var formattedEventData = []; 
//                formattedEventData.push({
//                title: 'this is important',
//                start: value,
//                end: value,
//                color: 'yellow',
//                textColor: 'black'
//                });
//                alert(value);


    
    //customize calendar settings
var calendar = $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
	},       
        
        //When you click a day, create a new object
        dayClick: function(date, jsEvent, view) {
//            $(this).css('background-color', 'red');             
            var eventObject = {
//			id:    				111,
			title: 				''+date.format(), 
			start: 				new Date(date.get('year'), date.get('month'), date.get('date')).toISOString(),
			end: 				new Date(date.get('year'), date.get('month'), date.get('date')).toISOString(),
//			backgroundColor: 	$(ui.item).css('background-color'),
//                        borderColor: 		$(ui.item).css('background-color'),
//                        textColor: 			$(ui.item).css('color'),
                        allDay: true 
                        }; //eventobject end
             calendar.fullCalendar('renderEvent', eventObject ,true);
            //window.location.href = "Calendar.jsp"; //redirect once click on day
        },
        
        //when you click a event delete it
        eventClick: function(event, element) { 
        alert(event.title + ' has been deleted');
            calendar.fullCalendar( 'removeEvents', event._id );
        //alert('Description: ' + event.description);        
        //event.title = "CLICKED!";
        //calendar.fullCalendar('updateEvent', event);
        },
        
        
        //load events
        events: formattedEventData,
        
//        events: [
//                {
//                    title: 'All Day Event',
//                    start: new Date(y, m, 1),
//                    description: 'An all day event just for you!',
//                    allDay: true
//                },
//                {
//                    title: 'Long Event',
//                    start: new Date(y, m, d-5),
//                    description: 'This is a seriously long event *yawn*',
//                    end: new Date(y, m, d-2)
//                },
//                {
//                    id: 999,
//                    title: 'Repeating Event',
//                    start: new Date(y, m, d-3, 16, 0),
//                    description: 'OMG it repeats!',
//                    allDay: false
//                },
//                {
//                    id: 999,
//                    title: 'Repeating Event',
//                    start: new Date(y, m, d+4, 16, 0),
//                    description: 'Where have we seen this before?',
//                    allDay: false
//                },
//                {
//                    title: 'Meeting',
//                    start: new Date(y, m, d, 10, 30),
//                    description: 'Oh noooo meetings!',
//                    allDay: false
//                },
//                {
//                    title: 'Lunch',
//                    start: new Date(y, m, d, 12, 0),
//                    end: new Date(y, m, d, 14, 0),
//                    description: "There's no such thing as a free lunch.",
//                    allDay: false
//                },
//                {
//                    title: 'Birthday Party',
//                    start: new Date(y, m, d+1, 19, 0),
//                    end: new Date(y, m, d+1, 22, 30),
//                    description: 'Have a crappy birthday!',
//                    allDay: false
//                },
//                {
//                    title: 'Click for Google',
//                    start: new Date(y, m, 28),
//                    end: new Date(y, m, 29),
//                    description: 'Duck duck go!',
//                    url: 'http://google.com/'
//                }
//            ],//event end

                      
    })//fullcalendar end
  
});//ready end
