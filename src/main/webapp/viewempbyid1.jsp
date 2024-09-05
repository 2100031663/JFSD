<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %>
 
<html> 
<head> 
 
<link type="text/css" rel="stylesheet" href="css/style.css"> 
 
<style> 
 <style>
.main
{
  display: flex;
    justify-content: center;
    align-items: center;
    height: 90px;
     width: 100%; /* Adjusted container width to 90% */
     margin: 40px auto;
     padding: 20px;
     text-align: center;
}
 .statistics-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin-top: 50px;
            animation: fallIn 1.5s ease-in-out;
        }
        @keyframes fallIn {
            0% {
                transform: translateY(-200px);
            }
            100% {
                transform: translateY(0);
            }
        }
        .statistics-box:hover {
            transform: scale(1.1); /* Zoom out the card */
            background-color: #e7c798; /* Change the background color */
        }
        .statistics-box p {
            font-size: 48px;
            margin: 0;
            color: #008000; /* Green color for the number values */
        }
  
 

        .statistics-box {
            flex: 1;
            width: 1000px;
            background-color: #cad9db;
            padding: 20px;
            margin: 150px 450px;
            box-shadow: 0 5px 10px rgba(163, 157, 157, 0.2);
            text-align: center;
            color: #0a0808;
            border-radius: 100px;
        }

        .statistics-box h2 {
            font-size: 36px;
            margin-bottom: 20px;
        }

        .statistics-box p {
            font-size: 48px;
            margin: 0;
        }

</style>
 
 
</style> 
</head> 
<body> 


<%@ include file="adminnavbar1.jsp" %>












<div class="main">
<div class="statistics-box">
        <h3> Employee details</h3>
        <p id="anotherStatCount">ID : ${emp.id}<br></p>
        <p>Name : ${emp.name}<br></p>
        <p>Gender : ${emp.gender}<br></p>    
        <p>Email : ${emp.email}<br></p>
        <p>Location : ${emp.location}<br></p>
        <p>Contact No : ${emp.contact}<br></p>
        <p>Status : ${emp.active}</p>
    </div>
    </div>

</body>
</html>