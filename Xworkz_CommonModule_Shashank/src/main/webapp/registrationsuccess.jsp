<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
      padding: 10px 20px;
      position: absolute;
      top: 0;
      left: 0;
      right: 0;
    }

    .logo-img {
      width: 140px;
      height: 70px;
    }

    .header-buttons {
      display: flex;
      gap: 10px;
    }

    .main-content {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
  </style>
</head>
<body>
  <header>
    <div class="header-content">
      <div class="ms-3">
        <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Xworkz" class="logo-img">
      </div>

      <div class="header-buttons">
         <a href="SignupAct" style="display:inline;">
          <button type="submit" class="btn btn-primary">Sign up</button>
        </a>
        <a href="SigninAct" style="display:inline;">
          <button type="submit" class="btn btn-primary">Sign In</button>
        </a>
      </div>
    </div>
  </header>

  <div class="main-content">
    <h1 class="display-4 text-success">Registered Successfully</h1>
  </div>

</body>
</html>
