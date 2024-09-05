<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
 
  <link rel="stylesheet" href="css/customerlogin.css">
  <title>CUSTOMER LOGIN</title>
</head>
<body>
  <div class="login-box">
    <h2>Customer Login</h2>
    <form method="post" action="checkemplogin">
      <div class="user-box">
        <input type="email" name="email" required>
        <label>Email</label>
      </div>
      <div class="user-box">
        <input type="password" name="pwd" required>
        <label>Password</label>
      </div>
      <a  type="Submit" >
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        clickto
         <button type="submit" class="login-button">Login</button>
      </a>
    </form>
    <h3 style="align-items: center;">
      New Registration ? <a href="empreg1">Click Here</a>
    </h3>
  </div>
</body>
</html>