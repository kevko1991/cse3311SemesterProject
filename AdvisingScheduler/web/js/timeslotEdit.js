$( "#mainAccordion" ).accordion({ heightStyle: "content" });
$("#submitBtn").button().click(function(){});
$("#cancelBtn").button().click(function(){});
$(document).ready( function () {
    $('#info').DataTable({
        "paging":   true,
        "ordering": true,
        "info":     true
    });
    $('#info2').DataTable({
        "paging":   true,
        "ordering": true,
        "info":     true
    });
} );
