<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Glowing Inputs Login Form UI</title>
      <link rel="stylesheet" href="css/admin.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
   </head>
   <body>
      <div class="login-form">
         <div class="text">
            ADMIN LOGIN
         </div>
         <form  method="post" action="checkadminlogin" >
            <div class="field">
               <div class="fas fa-envelope"></div>
               <input type="text" id="username" name="uname" placeholder="Enter Your Email" required>
            </div>
            <div class="field">
               <div class="fas fa-lock"></div>
               <input type="password" id="password" name="pwd" placeholder="Enter Your Password" required>
            </div>
            <button type="submit" class="login-button">Login</button>
         </form>
      </div>
   </body>
</html>
</html>