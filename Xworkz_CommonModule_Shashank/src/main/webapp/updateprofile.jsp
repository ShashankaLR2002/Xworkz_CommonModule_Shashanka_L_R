<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
  <style>
    .form-container {
      max-width: 600px;
      width: 100%;
    }
    .form-container h3 {
      margin-bottom: 20px;
    }
    .btn-primary {
      width: 100%;
    }
    input.form-control {
      height: calc(2.25rem + 2px);
    }
  </style>
  <title>Update Profile</title>
</head>
<body class="d-flex justify-content-center align-items-center" style="min-height: 100vh; background-color: #f0f0f0;">

  <div class="form-container p-4 border rounded shadow-sm bg-white">
    <h3 class="text-center mb-4">Update Your Profile</h3>



    <form action="updateUserProfile" method="post">
           <div class="mb-3">
             <label for="name" class="form-label">Name</label>
             <input type="name" id="name" name="name"  placeholder="Enter your Name "class="form-control" required>
           </div>

      <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" id="email" name="email"  placeholder="Enter your Email"class="form-control" required>
      </div>

      <div class="mb-3">
        <label for="phoneNumber" class="form-label">Phone Number</label>
        <input type="text" id="phoneNumber" name="phoneNumber" placeholder="Enter your phone number" class="form-control" required>
      </div>

      <div class="mb-3">
        <label for="alternateEmail" class="form-label">Alternate Email</label>
        <input type="email" id="alternateEmail" name="alternateemail" placeholder="Enter an alternate email" class="form-control">
      </div>

      <div class="mb-3">
        <label for="alternatePhone" class="form-label">Alternate Phone</label>
        <input type="text" id="alternatePhone" name="alternatephone" placeholder="Enter an alternate phone number" class="form-control">
      </div>

      <div class="mb-3">
        <label for="location" class="form-label">Location</label>
        <input type="text" id="location" name="location" placeholder="Enter your location" class="form-control">
      </div>

      <button type="submit" class="btn btn-primary">Update Profile</button>
    </form>
  </div>

</body>
</html>
