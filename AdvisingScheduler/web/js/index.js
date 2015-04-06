//$("#scheduleBtn").button();
//$("#loginBtn").button().click(function(){});
$("#loginBtn").on('click', function () {
    bootbox.dialog({
        title: "Login",
        message: "<form role='form' id='loginform' method='POST' action='LoginValidation.jsp' onsubmit='return validate()'>"
                + "<div class='form-group'>"
                + "<label for='username'>Email</label>"
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

//Added this dialog to change the password. Never got to test it. - Joe K
$("#FirstLog").on('show', function () {
    bootbox.dialog({
        title: "Change Your password",
        message: "<form role='form' id='firstlog' method='POST' action='index.jsp' onsubmit='return update()'>"
                + "<div class='form-group'>"
                + "<label for='enter'>Enter your new password</label>"
                + "<input class='form-control' type='password' name='password' id='password' value=''>"
                + "</div>"
                + "<div class='form-group'>"
                + "<label for='confirm'>Confirm your new password</label>"
                + "<input class='form-control' type='password' name='confirm' id='confirm' value=''>"
                + "</div>"
                + "</form>"
//                + "<input type='submit' value='Login' id='loginBtn2' class='btn btn-default'>"
        ,
        buttons: {
            success: {
                label: "Confirm",
                className: "btn-primary",
                callback: function (){
                    document.getElementById("firstlog").submit();
                }
            }
        }

    });
//    bootbox.alert("noooooo", function(){});
});
$("#leftAccordion").accordion({heightStyle: content});
$("#rightAccordion").accordion({heightStyle: content});
//$("#scheduleBtn").button().click(function(){});

// I'm not convinced that the functions below do anything. - Joe K

function validate() {
    var username = document.forms["loginform"]["username"].value;
    var password = document.forms["loginform"]["password"].value;
    
    if (username === null || username === "") {
        $("#username").notify("Please enter your username", "error",
                {elementPosition: 'bottom center',
                    globalPosition: 'bottom center'});
        return false;
    }

    if (password === null || password === "") {
        $("#password").notify("Please enter your password", "error",
                {elementPosition: 'bottom center',
                    globalPosition: 'bottom center'});
        return false;
    }

    
}

function update() {
    var password = document.forms["firstlog"]["password"].value;
    var confirm = document.forms["firstlog"]["confirm"].value;
    
    if (password === null || password === "") {
        $("#password").notify("Please enter a password", "error",
                {elementPosition: 'bottom center',
                    globalPosition: 'bottom center'});
        return false;
    }

    if (confirm === null || confirm === "") {
        $("#confirm").notify("Please confirm your password", "error",
                {elementPosition: 'bottom center',
                    globalPosition: 'bottom center'});
        return false;
    }
    
    if(confirm !== password){
        $("#password").notify("Both passwords entered do not match", "error",
                {elementPosition: 'bottom center',
                    globalPosition: 'bottom center'});
        return false;
    }
}