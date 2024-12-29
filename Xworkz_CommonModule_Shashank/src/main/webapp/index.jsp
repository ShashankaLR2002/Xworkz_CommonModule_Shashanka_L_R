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
      position: absolute;
      top: 0;
      left: 0;
      right: 0;
      padding: 10px 20px;
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
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      text-align: center;
      font-size: 2rem;
    }

    .header-container {
      width: 100%;
    }
  </style>
</head>
<body>
  <header>
    <div class="header-content">
      <div class="ms-3">
        <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Xworkz" class="logo-img">
      </div>

      <div class="header-buttons ms-auto">
        <form action="signup.jsp" method="post" style="display:inline;">
          <button type="submit" class="btn btn-primary">Sign Up</button>
        </form>
        <form action="signin.jsp" method="post" style="display:inline;">
          <button type="submit" class="btn btn-primary">Sign In</button>
        </form>
      </div>
    </div>
  </header>

  <div class="main-content">
    <h1> X-workz Course Registration</h1>
  </div>
</body>
</html>
