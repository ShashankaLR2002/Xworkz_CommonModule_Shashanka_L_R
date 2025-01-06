<%@ page isELIgnored = "false"%>
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

      <h1>Update Details</h1>

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
    <form action="updateUserProfile" method="post" onsubmit="return validateForm()">
      <h3>Update with your Details</h3>

      <c:forEach var="i" items="${error}">
        <span style="color: red">${i.defaultMessage}</span>
      </c:forEach>

      <div class="mb-3">
        <label for="name" class="form-label">Name:</label>
        <input type="text" id="name" name="Name" class="form-control" placeholder="Enter your name" value = "${loggedInUser.name}" required readonly onchange="onname()">
      </div>

      <div class="mb-3">
        <label for="email" class="form-label">Email:</label>
        <input type="text" id="email" name="email" class="form-control" placeholder="Enter your email" required onchange="onEmail()">
        <span id="displayemail" class="error-message"></span>
      </div>

      <div class="mb-3">
        <label for="phoneNumber" class="form-label">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" class="form-control" placeholder="Enter your phone number" required onchange="onPhoneNumber()">
        <span id="displayphoneNumber" class="error-message"></span>
      </div>

      <div class="mb-3">
        <label for="alternateemail" class="form-label">Alternate Email:</label>
        <input type="text" id="alternateemail" name="alternateemail" class="form-control" placeholder="Enter your alternate email" required onchange="onAlternateemail()">
        <span id="displayalternateemail" class="error-message"></span>
      </div>

      <div class="mb-3">
        <label for="alternatephone" class="form-label">Alternate Phone:</label>
        <input type="text" id="alternatephone" name="alternatephone" class="form-control" placeholder="Enter your alternate phone" required onchange="onAlternatePhonenumber()">
        <span id="displayalternatephone" class="error-message"></span>
      </div>

      <div class="mb-3">
        <label for="location" class="form-label">Location:</label>
        <select id="location" name="location" class="form-control">
          <option value="">Select the option</option>
          <c:forEach items="${listoflocation}" var="location">
            <option value="${location}">${location}</option>
          </c:forEach>
        </select>
        <span id="displayLocation" class="error-message"></span>
      </div>

      <button type="submit" id="submitBtn" class="btn btn-primary w-100" disabled>Submit</button>
    </form>
  </div>

  <script>

    let ajaxValidationStatus = {
      email: false,
      phoneNumber: false,
      alternateemail: false,
      alternatephone: false
    };

    function validateForm() {
      const errorMessages = document.querySelectorAll('.error-message');
      let hasError = false;

      for (let message of errorMessages) {
        if (message.innerHTML.trim() !== "") {
          hasError = true;
          break;
        }
      }

      for (let field in ajaxValidationStatus) {
        if (!ajaxValidationStatus[field]) {
          hasError = true;
          break;
        }
      }

      document.getElementById("submitBtn").disabled = hasError;

      return !hasError;
    }


    function onEmail() {
      var email = document.getElementById('email');
      emailvalue = email.value;

      if (!emailvalue.includes('@gmail.com') && !emailvalue.includes('@yahoo.com') && !emailvalue.includes('@outlook.com') && !emailvalue.includes('@hotmail.com') &&
          !emailvalue.includes('.edu') && !emailvalue.includes('.org') &&
          !emailvalue.includes('.info') && !emailvalue.includes('.net')) {
        document.getElementById("displayemail").innerHTML = "Enter a valid email address.";
        ajaxValidationStatus.email = false;
        validateForm();
        return;
      } else {
        document.getElementById("displayemail").innerHTML = "";
      }

      var xhttp = new XMLHttpRequest();
      xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_Shashank/email/" + emailvalue, true);
      xhttp.send();

      xhttp.onload = function() {
        if (this.status === 200) {
          document.getElementById("displayemail").innerHTML = this.responseText;
          ajaxValidationStatus.email = this.responseText.trim() === "";
        } else {
          ajaxValidationStatus.email = false;
        }
        validateForm();
      };

      xhttp.onerror = function() {
        ajaxValidationStatus.email = false;
        validateForm();
      };
    }

    function onPhoneNumber() {
      var phoneNumber = document.getElementById('phoneNumber');
      phoneNumbervalue = phoneNumber.value;

      if (phoneNumbervalue.trim().length !== 10 || (!phoneNumbervalue.startsWith("6") && !phoneNumbervalue.startsWith("7") &&
        !phoneNumbervalue.startsWith("8") && !phoneNumbervalue.startsWith("9"))) {
        document.getElementById("displayphoneNumber").innerHTML = "Phone number must contain 10 digits and should be valid.";
        ajaxValidationStatus.phoneNumber = false;
        validateForm();
        return;
      } else {
        document.getElementById("displayphoneNumber").innerHTML = "";
      }

      var xhttp = new XMLHttpRequest();
      xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_Shashank/phoneNumber/" + phoneNumbervalue, true);
      xhttp.send();

      xhttp.onload = function() {
        if (this.status === 200) {
          document.getElementById("displayphoneNumber").innerHTML = this.responseText;
          ajaxValidationStatus.phoneNumber = this.responseText.trim() === "";
        } else {
          ajaxValidationStatus.phoneNumber = false;
        }
        validateForm();
      };

      xhttp.onerror = function() {
        ajaxValidationStatus.phoneNumber = false;
        validateForm();
      };
    }

    function onAlternateemail() {
      var alternateemail = document.getElementById('alternateemail');
      alternateemailvalue = alternateemail.value;

      if (!alternateemailvalue.includes('@gmail.com') && !alternateemailvalue.includes('@yahoo.com') && !alternateemailvalue.includes('@outlook.com') && !alternateemailvalue.includes('@hotmail.com') &&
          !alternateemailvalue.includes('.edu') && !alternateemailvalue.includes('.org') && !alternateemailvalue.includes('.info') && !alternateemailvalue.includes('.net')) {
        document.getElementById("displayalternateemail").innerHTML = "Enter a valid email address.";
        ajaxValidationStatus.alternateemail = false;
        validateForm();
        return;
      } else {
        document.getElementById("displayalternateemail").innerHTML = "";
      }

      if (emailvalue === alternateemailvalue) {
        document.getElementById("displayalternateemail").innerHTML = "Email and Alternate Email should be different.";
        ajaxValidationStatus.alternateemail = false;
        validateForm();
        return;
      } else {
        document.getElementById("displayalternateemail").innerHTML = "";
      }

      var xhttp = new XMLHttpRequest();
      xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_Shashank/alternateemail/" + alternateemailvalue, true);
      xhttp.send();

      xhttp.onload = function() {
        if (this.status === 200) {
          document.getElementById("displayalternateemail").innerHTML = this.responseText;
          ajaxValidationStatus.alternateemail = this.responseText.trim() === "";
        } else {
          ajaxValidationStatus.alternateemail = false;
        }
        validateForm();
      };

      xhttp.onerror = function() {
        ajaxValidationStatus.alternateemail = false;
        validateForm();
      };
    }

    function onAlternatePhonenumber() {
      var alternatephone = document.getElementById('alternatephone');
      alternatephonevalue = alternatephone.value;

      if (alternatephonevalue.trim().length !== 10 || (!alternatephonevalue.startsWith("6") && !alternatephonevalue.startsWith("7") &&
          !alternatephonevalue.startsWith("8") && !alternatephonevalue.startsWith("9"))) {
        document.getElementById("displayalternatephone").innerHTML = "Phone number must contain 10 digits and should be valid.";
        ajaxValidationStatus.alternatephone = false;
        validateForm();
        return;
      } else {
        document.getElementById("displayalternatephone").innerHTML = "";
      }

      if (alternatephonevalue === phoneNumbervalue) {
        document.getElementById("displayalternatephone").innerHTML = "Phone number and Alternate Phone number should be different";
        ajaxValidationStatus.alternatephone = false;
        validateForm();
        return;
      } else {
        document.getElementById("displayalternatephone").innerHTML = "";
      }

      var xhttp = new XMLHttpRequest();
      xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_Shashank/alternatephone/" + alternatephonevalue, true);
      xhttp.send();

      xhttp.onload = function() {
        if (this.status === 200) {
          document.getElementById("displayalternatephone").innerHTML = this.responseText;
          ajaxValidationStatus.alternatephone = this.responseText.trim() === "";
        } else {
          ajaxValidationStatus.alternatephone = false;
        }
        validateForm();
      };

      xhttp.onerror = function() {
        ajaxValidationStatus.alternatephone = false;
        validateForm();
      };
    }
  </script>


  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
