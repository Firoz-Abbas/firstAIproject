<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

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

            <button type="submit" class="btn btn-primary w-100" onclick="userLogin()">Login</button>

            <p class="text-center mt-3 mb-0">
                <a href="#" class="text-decoration-none">Forgot Password?</a>
            </p>
        </form>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
                    $("#errorMsg").text("Invalid username or password");
                }
            },
            error: function (jqxhr, textStatus, errThrown) {
                showErrorMessage(jqxhr.responseJSON.errors);
            }
        });
    }
</script>

</body>
</html>
