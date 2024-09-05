<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>


<html lang="en">
<head>
  <meta charset="UTF-8">
  
  <link rel="stylesheet" href="css/customerlogin.css">
  <title>Document</title>
</head>
<body>
  <div class="login-box">
    <h2>Customer Register</h2>
    <form method="post" action="insertemp">
      <div class="user-box">
        <input type="text" name="name" required/>
        <label>Name</label>
      </div>
      <div class="user-box1" style="color: antiquewhite;">
        <label style="color: antiquewhite;">Gender</label><br><br>
        <input type="radio" name="gender" value="MALE" required />Male
        <input type="radio" name="gender" value="FEMALE" required/>Female
        <input type="radio" name="gender" value="OTHERS" required/>Others
        <br><br>
      </div>
      <div class="user-box">
        <input type="email" name="email" required/>
        <label>Email</label>
      </div>
      <div class="user-box">
        <input type="password" name="pwd" required/>  
        <label>Password</label>
      </div>
      <div class="user-box">
        <input type="text" name="location" required/>
        <label>location</label>
      </div>
      <div class="user-box">
        <input type="text" name="contact" pattern="[6789][0-9]{9}"   required/>
        <label>Contact</label>
      </div>
      <a >
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        clickto
        <input type="submit" class="button">
      </a>
    </form>
  </div>
</body>
</html>