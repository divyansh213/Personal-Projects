<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@ include file="./base.jsp" %> 
<html>
<body>

<div class="container mt-3">
	
	<div class="row">

	<div class="col-md-6 offset-md-3">
	
	<h1 class="text-center mb-3"> Product App</h1>

<p class="text-success"> ${msg }</p>
<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">S. No.</th>
      <th scope="col">Product Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="p" items="${products }">
   <tr>
      <th scope="row">${p.pid }</th>
      <td>${p.name }</td>
      <td>${p.description }</td>
      <td> ${p.price }</td>
      <td>
      <a href="deleteProduct/${p.pid }" class="text-danger"><span class="material-icons">delete</span></a>
      <a href="updateProduct/${p.pid }" class="text-warning"><span class="material-icons">edit</span></a>
      </td>
    </tr>
  
  </c:forEach>
   
    
  </tbody>
</table>

    <div class="container text-center">
    <a href="addProduct" class="btn btn-outline-success">Add Products</a>
    </div>
    
	</div>
	</div>
	</div>
</body>
</html>
