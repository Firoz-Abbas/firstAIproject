<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body class="bg-light">
<div id="errorMsg" name="errorMsg"></div>
<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg p-4" style="width: 350px; border-radius: 15px;">
        <h3 class="text-center mb-4">Login</h3>

        <form id="loginFrm" name="loginFrm" action="#">
            <div class="mb-3">
                <label class="form-label">Username</label>
                <input type="text" name="username" class="form-control" placeholder="Enter username" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Password</label>
                <input type="password" name="password" class="form-control" placeholder="Enter password" required>
            </div>

            <button type="button" class="btn btn-primary w-100" onclick="userLogin()">Login</button>

            <p class="text-center mt-3 mb-0">
                <a href="#" class="text-decoration-none">Forgot Password?</a>
            </p>
        </form>
    </div>
</div>

<script>

    function userLogin() {
        var form = $('#loginFrm')[0];
        var data = new FormData(form);
        $.ajax({
            type: "POST",
            url: "/userLogin",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 1000000,
            success: function (data) {
                if (data.page === "home") {
                    window.location.href = "/home"; // controller mapping for home.jsp
                } else {
                    // alert("Invalid username or password")
                    $("#errorMsg").text("Invalid username or password");
                    showErrorMessageDivElementFromBackend("username", "Candidate can't login from here!");
                }
            },
            error: function (jqxhr, textStatus, errThrown) {
                showErrorMessage(jqxhr.responseJSON.errors);
            }
        });
    }

    function showErrorMessageDivElementFromBackend(error_element, message) {
        if (message.trim().length > 0) {

            if ($("#" + error_element).length) {
                if(message=="Invalid username or password."){
                    $("#" + "username")[0].style.setProperty("border-color", "#F36711", "important");
                    $("#" + "password")[0].style.setProperty("border-color", "#F36711", "important");}
                else{
                    $("#" + error_element).css("border-color", "#F36711");
                }
                if (document.getElementById("span_error_" + error_element) == undefined) {
                    var span = $('<span />').attr('id', "span_error_" + error_element).attr('class', 'error-view').html(message);
                    {
                        if(message=="Invalid username or password."){
                            error_element="password";
                            $("#" + error_element).after(span);
                        }else {
                            $("#" + error_element).after(span);
                        }
                    }
                } else {
                    document.getElementById("span_error_" + error_element).innerHTML = message;
                }
            } else {
                validation_error_message(message);
            }
        }
    }

    function validation_error_message(error_msg) {
        toastr.options = {
            'closeButton': true,
            'debug': false,
            'newestOnTop': false,
            'progressBar': false,
            'positionClass': 'toast-top-right',
            'preventDuplicates': false,
            'showDuration': '1000',
            'hideDuration': '1000',
            'timeOut': '5000',
            'extendedTimeOut': '1000',
            'showEasing': 'swing',
            'hideEasing': 'linear',
            'showMethod': 'fadeIn',
            'hideMethod': 'fadeOut',
        }
        toastr.error(error_msg);
        return false;
    }
</script>

</body>
</html>
