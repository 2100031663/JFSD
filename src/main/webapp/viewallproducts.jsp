<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Online bidding Systems</title>
    <style>
        .navbar{
            background-color: black;
            border-radius: 30px;
            
        }
        .navbar ul{
            overflow: auto;
        }
        .navbar li{
            float:left;
            list-style: none; 
            margin: 13px 20px;
            
        }
        .navbar li a{
            padding: 3px 3px;
            text-decoration: none;
            color: white;
        }
        .navbar li a:hover{
            color: red
        }
        .search{
            float: right;
            color: white;
            padding: 12px 75px;
        }
        .navbar input{
            border: 2px solid black;
            border-radius: 14px;
            padding: 3px 17px;
            width: 129px;
        }
        * {
  box-sizing: border-box;
}

#myInput {
  background-image: url('/css/searchicon.png');
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 100%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}

#myTable {
  border-collapse: collapse;
  width: 100%;
  border: 1px solid #ddd;
  font-size: 18px;
}

#myTable th, #myTable td {
  text-align: left;
  padding: 12px;
}

#myTable tr {
  border-bottom: 1px solid #ddd;
}

#myTable tr.header, #myTable tr:hover {
  background-color: #f1f1f1;
}


 .button {
  display:block;
  border-radius: 14px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 15px;
  padding: 20px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
  justify-content: center;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}

    </style>
    
    
    <script>
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[2];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>
    
</head>

<body>

 <%@ include file="adminnavbar1.jsp" %>


<h3 align=center><u>View All Products</u></h3>

<br>

<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Enter Product Name">

<table align=center border=2 id="myTable">

<tr class="header">

<th>ID</th>
<th>Category</th>
<th>Name</th>
<th>Description</th>
<th>Cost</th>
<th>Link</th>
<th>Image</th>
</tr>

<c:forEach items="${productlist}" var="product">

<tr>

<td> <c:out value="${product.id}"></c:out>  </td>
<td> <c:out value="${product.category}"></c:out>   </td>
<td> <c:out value="${product.name}"></c:out>   </td>
<td> <c:out value="${product.description}"></c:out>   </td>
<td> <c:out value="${product.cost}"></c:out>   </td>
<td> 

<a href='<c:url value='${product.productlink}'></c:url>'>Click Here</a>&nbsp;&nbsp;

</td>

<td> 

<img src='displayprodimage?id=${product.id}' width="20%" height="20%"> 


</td>


</tr>

</c:forEach>

</table>


    <div class="btn-holder">
       <a href="addproduct.jsp">
        <button class="button" style="vertical-align:middle"><span>ADD PRODUCTS</span></button></a>
            
    
</body>

</html>
