<%@ page isELIgnored = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <style>
    .header-content
    {
      display: flex;
      justify-content: space-between;
      align-items: center;
      width: 100%;
    }
    .logo-img {
      width: 140px;
      height: 70px;
    }
    .header-buttons
    {
      display: flex;
      gap: 10px;
    }
    h1 {
      text-align: center;
      flex: 1;
      margin: 0;
    }
    .form-container
    {
      max-width: 600px;
      margin: 0 auto;
    }
    .error-message
    {
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

  <div class="container form-container">
    <form action="signupact" method="post" onsubmit="return validateForm()">
      <h3>Register with your Details</h3>

      <c:forEach var="i" items="${error}">
        <span style="color: red">${i.defaultMessage}</span>
      </c:forEach>

      <div class="mb-3">
        <label for="name" class="form-label">Name:</label>
        <input type="text" id="name" name="Name" class="form-control" placeholder="Enter your name" required onchange="onname()">
        <span id="displayName" class="error-message"></span>
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
        <input type="text" id="location" name="location" class="form-control" placeholder="Enter your location" required>
        <span id="displayLocation" class="error-message"></span>
      </div>

      <button type="submit" class="btn btn-primary w-100">Submit</button>
    </form>
  </div>

  <script>


var emailvalue = "";
var alternateemailvalue = "";
var phoneNumbervalue = "";
var alternatephonevalue = "";


function onname() {
  var name = document.getElementById('name');
  var namevalue = name.value;

  if (namevalue.trim().length < 4)
  {
    document.getElementById("displayName").innerHTML = "Name must be at least 4 characters long.";
    return;
  }

  var xhttp = new XMLHttpRequest();
  xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_Shashank/name/" + namevalue, true);
  xhttp.send();

  xhttp.onload = function()
   {
    document.getElementById("displayName").innerHTML = this.responseText;
  }
};


function onEmail()
{
  var email = document.getElementById('email');
  emailvalue = email.value;

  if (!emailvalue.includes('@gmail.com') && !emailvalue.includes('@yahoo.com') && !emailvalue.includes('@outlook.com') && !emailvalue.includes('@hotmail.com') && !emailvalue.includes('.edu')
      && !emailvalue.includes('.org') && !emailvalue.includes('.info') && !emailvalue.includes('.net'))
      {
    document.getElementById("displayemail").innerHTML = "Enter a valid email address.";
    return;
  }

  var xhttp = new XMLHttpRequest();
  xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_Shashank/email/" + emailvalue, true);
  xhttp.send();

  xhttp.onload = function()
  {
    document.getElementById("displayemail").innerHTML = this.responseText;
  }
};


function onPhoneNumber()
{
  var phoneNumber = document.getElementById('phoneNumber');
  phoneNumbervalue = phoneNumber.value;

  if (phoneNumbervalue.trim().length !== 10 || (!phoneNumbervalue.startsWith("6") && !phoneNumbervalue.startsWith("7")
  && !phoneNumbervalue.startsWith("8") && !phoneNumbervalue.startsWith("9")))
  {
    document.getElementById("displayphoneNumber").innerHTML = "Phone number must contain 10 digits and should be valid.";
    return;
  }

  var xhttp = new XMLHttpRequest();
  xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_Shashank/phoneNumber/" + phoneNumbervalue, true);
  xhttp.send();

  xhttp.onload = function()
  {
    document.getElementById("displayphoneNumber").innerHTML = this.responseText;
  }
};


function onAlternateemail()
{
  var alternateemail = document.getElementById('alternateemail');
  alternateemailvalue = alternateemail.value;

  if (!alternateemailvalue.includes('@gmail.com') && !alternateemailvalue.includes('@yahoo.com') && !alternateemailvalue.includes('@outlook.com')
    && !alternateemailvalue.includes('@hotmail.com') && !alternateemailvalue.includes('.edu') && !alternateemailvalue.includes('.org') && !alternateemailvalue.includes('.info') && !alternateemailvalue.includes('.net'))
    {
    document.getElementById("displayalternateemail").innerHTML = "Enter a valid email address.";
    return;
  }

  if (emailvalue === alternateemailvalue)
  {
    document.getElementById("displayalternateemail").innerHTML = "Email and Alternate Email should be different.";
    return;
  }

  var xhttp = new XMLHttpRequest();
  xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_Shashank/alternateemail/" + alternateemailvalue, true);
  xhttp.send();

  xhttp.onload = function()
   {
    document.getElementById("displayalternateemail").innerHTML = this.responseText;
  }
};


function onAlternatePhonenumber()
{
  var alternatephone = document.getElementById('alternatephone');
  alternatephonevalue = alternatephone.value;

  if (alternatephonevalue.trim().length !== 10 || (!alternatephonevalue.startsWith("6") && !alternatephonevalue.startsWith("7") && !alternatephonevalue.startsWith("8") && !alternatephonevalue.startsWith("9"))) {
    document.getElementById("displayalternatephone").innerHTML = "Phone number must contain 10 digits and should be valid.";
    return;
  }

  if (alternatephonevalue === phoneNumbervalue)
  {
    document.getElementById("displayalternatephone").innerHTML = "Phone number and Alternate Phone number should be different";
    return;
  }

  var xhttp = new XMLHttpRequest();
  xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_Shashank/alternatephone/" + alternatephonevalue, true);
  xhttp.send();

  xhttp.onload = function()
  {
    document.getElementById("displayalternatephone").innerHTML = this.responseText;
  }
};

 </script>

</body>
</html>
