<%@ page isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
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
      gap: 20px;
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

    .upload-form {
      max-width: 600px;
      height: 20px;
    }
  </style>
</head>

<body>

  <header class="d-flex flex-wrap justify-content-between align-items-center py-3 mb-4 border-bottom">
    <div class="header-content w-100">
      <div class="ms-3">
        <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Xworkz" class="logo-img">
      </div>

      <h1>Update Details</h1>

      <div class="header-buttons">
        <a href="SignupAct" style="display:inline;">
          <button type="button" class="btn btn-primary">Sign up</button>
        </a>
        <a href="SigninAct" style="display:inline;">
          <button type="button" class="btn btn-primary">Sign In</button>
        </a>
      </div>
    </div>
  </header>

  <div class="container form-container">
    <form action="updateUserProfile" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
      <h3>Update with your Details</h3>

      <c:forEach var="i" items="${error}">
        <span style="color: red">${i.defaultMessage}</span>
      </c:forEach>

      <div class="mb-3">
        <label for="name" class="form-label">Name:</label>
        <input type="text" id="name" name="Name" class="form-control" placeholder="Enter your name" value="${loggedInUser.name}" required readonly>
      </div>

      <div class="mb-3">
        <label for="email" class="form-label">Email:</label>
        <input type="text" id="email" name="email" class="form-control" placeholder="Enter your email" value="${loggedInUser.email}" required onchange="onEmail()">
        <span id="displayemail" class="error-message"></span>
      </div>

      <div class="mb-3">
        <label for="phoneNumber" class="form-label">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" class="form-control" placeholder="Enter your phone number" value="${loggedInUser.phoneNumber}" required onchange="onPhoneNumber()">
        <span id="displayphoneNumber" class="error-message"></span>
      </div>

      <div class="mb-3">
        <label for="alternateemail" class="form-label">Alternate Email:</label>
        <input type="text" id="alternateemail" name="alternateemail" class="form-control" placeholder="Enter your alternate email"  value="${loggedInUser.alternateemail}" required onchange="onAlternateemail()">
        <span id="displayalternateemail" class="error-message"></span>
      </div>

      <div class="mb-3">
        <label for="alternatephone" class="form-label">Alternate Phone:</label>
        <input type="text" id="alternatephone" name="alternatephone" class="form-control" placeholder="Enter your alternate phone" value="${loggedInUser.alternatephone}" required onchange="onAlternatePhonenumber()">
        <span id="displayalternatephone" class="error-message"></span>
      </div>

      <div class="mb-3">
        <label for="location" class="form-label">Location:</label>
        <select id="location" name="location" class="form-control" required>
          <option value="">Select the option</option>
          <c:forEach items="${listoflocation}" var="location">
            <option value="${location}">${location}</option>
          </c:forEach>
        </select>
        <span id="displayLocation" class="error-message"></span>
      </div>

      <div class="mb-3 upload-form">
        <label for="file-upload" class="btn btn-secondary">
          Choose file
        </label>
        <input id="file-upload" type="file" name="Img" class="d-none" onchange="this.nextElementSibling.innerHTML = this.files[0].name"/>
          <span id="file-name" class="file-name"></span>

        <span id="displayfile" class="error-message"></span>
      </div>

      <button type="submit" id="submitBtn" class="btn btn-primary w-100">Submit</button>
    </form>
  </div>



  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>
