<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card p-4">
                    <h2 class="text-center mb-4">Login</h2>
                    <form action="getNameByEmailAndPassword" method="post">
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <div class="d-grid gap-2">
                            <input type="submit" class="btn btn-primary" value="Login">
                        </div>
                    </form>

                    <p class="mt-3 text-center">${message}</p>

                    <c:if test="${not empty user}">
                        <!-- Display the "Name" button -->
                        <button id="showDetailsButton" class="btn btn-secondary mt-3">${user.name}</button>

                        <div id="userDetails" style="display:none;" class="mt-3">
                            <table class="table mt-3">
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Age</th>
                                        <th>Email</th>
                                        <th>Phone Number</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>${user.name}</td>
                                        <td>${user.age}</td>
                                        <td>${user.email}</td>
                                        <td>${user.phonenumber}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        document.getElementById('showDetailsButton').onclick = function() {
            var userDetailsDiv = document.getElementById('userDetails');
            if (userDetailsDiv.style.display === "none") {
                userDetailsDiv.style.display = "block";
            } else {
                userDetailsDiv.style.display = "none";
            }
        };
    </script>
</body>
</html>
