/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$( "#accordion" ).accordion({ heightStyle: "content" });
$(function() {
    $( "#datepicker" ).datepicker({ minDate: 0, maxDate: "+14D" });
});
$('#starttimepicker').timepicker({ 'step': 15 });
$('#endtimepicker').timepicker({ 'step': 15 });
