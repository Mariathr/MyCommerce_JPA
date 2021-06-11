<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login1</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</head>
<body>

<div class="container">
    <div  style="height:20%;">
    </div>
    <div class="row">
        <div class="col-md-6">

            <div class="card">
                <div class="card-header">
                    Login
                </div>
                <div class="card-body">
                    <form action="login" method="post">
                        <div class="form-group">
                            <label class="form-label" for='name'> Name Utilisateur: </label>
                            <input type='text' class="form-control" name='username' id='name'>
                        </div>
                        <div class='form-group'>
                            <label class="form-label" for="password"> Password: </label>
                            <input type='text' class="form-control" name='password' id='password'>
                        </div>
                        </br>
                        <div class="form-group">
                            <input type='submit' class="btn btn-primary" value='entrée'>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>