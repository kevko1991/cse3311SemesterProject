//$("#scheduleBtn").button();
//$("#loginBtn").button().click(function(){});
$("#loginBtn").on('click', function () {
    bootbox.dialog({
        title: "Login",
        message: "<form role='form' id='loginform'>"
                + "<div class='form-group'>"
                + "<label for='username'>Username</label>"
                + "<input class='form-control' type='text' name='username' id='username' value=''>"
                + "</div>"
                + "<div class='form-group'>"
                + "<label for='password'>Password</label>"
                + "<input class='form-control' type='password' name='password' id='password' value=''>"
                + "</div>"
                + "</form>"
//                + "<input type='submit' value='Login' id='loginBtn2' class='btn btn-default'>"
                    ,
        buttons: {
            success: {
                label: "Login",
                className: "btn-primary",
                callback: function () {
                    document.getElementById("loginform").submit();
                }
            }
        }

    });
//    bootbox.alert("noooooo", function(){});
});
$("#leftAccordion").accordion({heightStyle: content});
$("#rightAccordion").accordion({heightStyle: content});
//$("#scheduleBtn").button().click(function(){});
