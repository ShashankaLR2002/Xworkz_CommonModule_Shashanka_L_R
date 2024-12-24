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
  </style>
</head>
<body>

  <header class="d-flex flex-wrap justify-content-between align-items-center py-3 mb-4 border-bottom">
    <div class="header-content w-100">
      <!-- Logo on the left -->
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
    <form action="signupact" method="post" >
      <h3>Register with your Details</h3>

      <div class="mb-3">
        <label for="name" class="form-label">Name:</label>
        <input type="text" id="name" name="Name" class="form-control" placeholder="Enter your name" required onchange="onname()">
     <span id = "displayName" style = "color: red"></span>
      </div>

      <div class="mb-3">
        <label for="email" class="form-label">Email:</label>
        <input type="text" id="email" name="email" class="form-control" placeholder="Enter your email" required onchange ="onEmail()">
           <span id = "displayemail" style = "color: red"></span>

      </div>

      <div class="mb-3">
        <label for="phoneNumber" class="form-label">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" class="form-control" placeholder="Enter your phone number" required onchange ="onPhoneNumber()">
           <span id = "displayphoneNumber" style = "color: red"></span>

      </div>

      <div class="mb-3">
        <label for="alternateemail" class="form-label">Alternate Email:</label>
        <input type="text" id="alternateemail" name="alternateemail" class="form-control" placeholder="Enter your alternate email" required onchange = "onAlternateemail()">
           <span id = "displayalternateemail" style = "color: red"></span>

      </div>

      <div class="mb-3">
        <label for="alternatephone" class="form-label">Alternate Phone:</label>
        <input type="text" id="alternatephone" name="alternatephone" class="form-control" placeholder="Enter your alternate phone" required onchange = "onAlternatePhonenumber()">
          <span id = "displayalternatephone" style = "color: red"></span>

      </div>

      <div class="mb-3">
        <label for="location" class="form-label">Location:</label>
        <input type="text" id="location" name="location" class="form-control" placeholder="Enter your location" required>

      </div>

      <button type="submit" class="btn btn-primary w-100">Submit</button>
    </form>


   </div>

     <script>
         function onname()
         {
             console.log("The onname Function");

             var name = document.getElementById('name');
             var namevalue = name.value;
             console.log("Name entered: " + namevalue);

             var xhttp = new XMLHttpRequest();
             xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_Shashank/name/" + namevalue, true);
               xhttp.send();

               xhttp.onload = function()
               {
               document.getElementById("displayName").innerHTML = this.responseText;
               }
               };

                function onEmail() {
                console.log("The onEmail Function");

                var email = document.getElementById('email');
                var emailvalue = email.value;
                console.log("Email entered: " + emailvalue);

                var xhttp = new XMLHttpRequest();
                xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_Shashank/email/" + emailvalue, true);
                xhttp.send();
                xhttp.onload = function()
                 {
                 document.getElementById("displayemail").innerHTML = this.responseText;
                 }
                 };

            function onPhoneNumber() {
                console.log("The onPhoneNumber Function");

                var phoneNumber = document.getElementById('phoneNumber');
                var phoneNumbervalue = phoneNumber.value;
                console.log("Phonenumber entered: " + phoneNumbervalue);

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
            console.log("The Alternateemail Function");

             var alternateemail = document.getElementById('alternateemail');
              var alternateemailvalue = alternateemail.value;
             console.log("alternateemail entered: " +alternateemailvalue);

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
          console.log("The AlternatePhonenumber Function");

          var AlternatePhonenUmber = document.getElementById('alternatephone');
          var alternatephonevalue = AlternatePhonenUmber.value;
          console.log("alternatephone entered: " +alternatephonevalue);

          var xhttp = new XMLHttpRequest();
          xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_Shashank/alternatephone/" + alternatephonevalue, true);
          xhttp.send();
          xhttp.onload = function()
           {
          document.getElementById("displayalternatephone").innerHTML = this.responseText;
           }

           };


           function onemailvalid()
                                   {
                     console.log("onemailvalid Function");

                     var AlternatePhonenUmber = document.getElementById('alternatephone');
                     var alternatephonevalue = AlternatePhonenUmber.value;
                     console.log("alternatephone entered: " +alternatephonevalue);

                     var xhttp = new XMLHttpRequest();
                     xhttp.open("GET", "http://localhost:8080/Xworkz_CommonModule_Shashank/alternatephone/" + alternatephonevalue, true);
                     xhttp.send();
                     xhttp.onload = function()
                      {
                     document.getElementById("displayalternatephone").innerHTML = this.responseText;
                      }

                      };






</script>
</div>

</body>
</html>
