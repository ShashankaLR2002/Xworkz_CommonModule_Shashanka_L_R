<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
  <style>
    .form-container {
      max-width: 500px;
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
</head>
<body class="d-flex justify-content-center align-items-center" style="min-height: 100vh; background-color: #f0f0f0;">

  <div class="form-container p-4 border rounded shadow-sm bg-white">
    <h3 class="text-center mb-4">Reset Your Password</h3>

    <c:if test="${not empty error}">
      <div class="alert alert-danger">${error}</div>
    </c:if>

    <c:if test="${not empty message}">
      <div class="alert alert-success">${message}</div>
    </c:if>

    <form action="resetPassword" method="post">
      <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" id="email" name="email" placeholder="Enter your email" class="form-control" required>
      </div>

      <div class="mb-3">
        <label for="oldPassword" class="form-label">Old Password</label>
        <input type="password" id="oldPassword" name="oldPassword" placeholder="Enter old password" class="form-control" required>
      </div>

      <div class="mb-3">
        <label for="newPassword" class="form-label">New Password</label>
        <input type="password" id="newPassword" name="newPassword" placeholder="Enter new password" class="form-control" required>
      </div>

      <div class="mb-3">
        <label for="confirmPassword" class="form-label">Confirm Password</label>
        <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm new password" class="form-control" required>
      </div>
      <button type="submit" class="btn btn-primary">Reset Password</button>
    </form>
  </div>
</body>
</html>
