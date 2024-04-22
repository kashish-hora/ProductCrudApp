<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%@include file="./Base.jsp" %>
</head>
<body>
<div class="row">
<div class="col-md-6 offset-md-3">
<h1 class="text-center mb-3">Fill the Product Details</h1>
<form action="handle-product" method="post">
  <div class="form-group">
    <label for="name">Product Name</label>
    <input type="name" class="form-control"name="name" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter the product name here">
    
  </div>
  <div class="form-group">
    <label for="description">Product Description</label>
    <textarea type="text" class="form-control" name="description" id="description" rows="5" placeholder="Enter the product Description"></textarea>
  </div>
  <div class="form-group">
   <label for="price">Product Price</label>
    <input type="text" class="form-control" name="price" id="price" placeholder="Enter the product Price">
  </div>
   
  <div class="container text-center">
  <a href="${pageContext.request.contextPath }/"
  class="btn btn-outline-danger">Back</a>
  <button type="submit" class="btn btn-primary">Add</button>
</form>
</div>

</body>
</html>