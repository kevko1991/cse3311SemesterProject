$( "#appointmentAccordion" ).accordion({ heightStyle: "content" });
$("#submitBtn").button().click(function(){});
$("#cancelBtn").button().click(function(){});
$(document).ready( function () {
    $('#tableform').DataTable({
        "paging":   true,
        "ordering": true,
        "info":     true
    });
} );
