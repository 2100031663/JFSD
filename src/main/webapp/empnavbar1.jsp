<!DOCTYPE html>
<html>
<head>

<link type="text/css" rel="stylesheet" href="css/style.css">

<title>Spring Boot MVC</title>

<style>

nav {
    background-color: #333;
    padding: 10px; /* Add some space around the navigation items */
    display: flex; /* Use flex display to center align content */
    align-items: center; /* Vertically center align content */
    margin-top: -6%;
    margin-left: 0%;
    padding-left: 0%;
    padding-right: 10%;
  }
  ul {
    list-style: none; /* Remove default list styles */
    padding: 0;
    margin: 0;
    display: flex; /* Use flex display for list items */
  }
  
  li {
    margin-right: 20px; /* Add spacing between items */
    position: relative; /* Set the position of the list item as relative */
  }
  
  a {
    text-decoration: none; /* Remove underline from links */
    color: #fff; /* Text color for links */
    display: flex; /* Use flex display to center align content */
    align-items: center; /* Vertically center align content */
  }
  
  a:hover {
    text-decoration: underline; /* Underline links on hover */
  }
  

header {
    background-color: #333;
    color: white;
    padding: 10px 0;
    transition: background-color 0.3s;
}

nav {
    max-width: 1200px;
    margin: 0 auto;
    display: flex;
    justify-content: center;
    align-items: center;
}

nav:hover {
    background-color: #555;
}

</style>
</head>
<body>

<nav>
            <div class="logo">
                <h1></h1>
            </div>
            <div class="menu">
                <body id="background-image"></body>
                <ul>
                    <li><a href="emphome1">Home</a></li>
                    <li><a href="viewproductsbycategory">Auctions</a></li>
                    <li><a href="bid.jsp">My Bids</a></li>
                    <li><a href="cart.jsp">Cart</a></li>
                    <li><a href="/">Logout</a></li>
                </ul>
            </div>
        </nav>

</body>
</html>