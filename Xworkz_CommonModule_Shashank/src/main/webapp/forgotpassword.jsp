<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <style>
    .header-content {
      display: flex;
      justify-content: space-between;
      align-items: center;
      width: 100%;
    }
    .logo-img {
      width: 140px;
      height: 70px;
    }
    .header-buttons {
      display: flex;
      gap: 10px;
    }
    h1 {
      text-align: center;
      flex: 1;
      margin: 0;
    }
    .form-container {
      max-width: 600px;
      margin: 0 auto;
    }
    .reset-link {
      text-align: center;
      margin-top: 10px;
    }
  </style>
</head>
<body>

  <header class="d-flex flex-wrap justify-content-between align-items-center py-3 mb-4 border-bottom">
    <div class="header-content w-100">
      <div class="ms-3">
        <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Xworkz" class="logo-img">
      </div>

      <h1>Course Registration</h1>

      <div class="header-buttons">
         <a href ="SignupAct" style="display:inline;">
          <button type="submit" class="btn btn-primary">Sign up</button>
        </a>
        <a href ="SigninAct" style="display:inline;">
          <button type="submit" class="btn btn-primary">Sign In</button>
        </a>
      </div>
    </div>
  </header>

  <div class="container form-container">

    <form action="forgotPwd" method="get">
      <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" id="email" name="email"  placeholder="Enter your email" required class="form-control">


      </div>

      <button type="submit" class="btn btn-primary w-100">Request Password Reset</button>
    </form>


 </div>
</body>
</html>
