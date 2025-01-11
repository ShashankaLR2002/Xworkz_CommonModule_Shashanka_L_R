<%@ page isELIgnored="false" %>

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
    .error-message {
      color: red;
      font-size: 0.875rem;
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

  <div class="text-center">
    <h1 class="display-4 text-success">Update Details Successfully</h1>
        <p class="lead">Your Details has been updated</p>

    <div class="mt-3">


</body>
</html>
