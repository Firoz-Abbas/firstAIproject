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

        <form action="/login" method="post">
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

<script>

    function userLogin(){
    console.log("i am user .........")
    }

    function login() {
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
            success: function (data, textStatus, jqXHR) {
                var userRoleId = jqXHR.responseJSON.userRoleId;
                let homePage = jqXHR.responseJSON.homePage ;

                if (parseInt(userRoleId) == 5) {
                    showErrorMessageDivElementFromBackend("username", "Candidate can't login from here!");
                } else {
                    if (parseInt(userRoleId) == 3) {
                        successLogin(jqXHR.responseJSON.message, "/student/MyAccount");
                    } else {
                        successLogin(jqXHR.responseJSON.message,homePage);
                    }
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
