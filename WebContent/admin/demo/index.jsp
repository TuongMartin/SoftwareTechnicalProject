<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>X-editable</title>
    <!-- bootstrap -->
    <link href="<%=request.getContextPath()%>/templates/admin/x-edittable/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/templates/admin/x-edittable/js/bootstrap.min.js"></script>  

	<!-- Jquery -->
    <script src="<%=request.getContextPath()%>/templates/admin/x-edittable/js/jquery-2.0.3.min.js"></script> 
    
	<!-- x-editable (bootstrap version) -->
    <link href="<%=request.getContextPath()%>/templates/admin/x-edittable/css/bootstrap-editable.css" rel="stylesheet"/>
    <script src="<%=request.getContextPath()%>/templates/admin/x-edittable/js/bootstrap-editable.min.js"></script>
    
    <!-- main.js -->
    <script src="<%=request.getContextPath()%>/templates/admin/x-edittable/main.js"></script>
  </head>

  <body>

    <div class="container">
      <h1>X-editable Demo</h1>
    </div>
<table class="table table-bordered">
  <tr>
  <th>ID</th>
  <th>Name</th>
  <th>Course</th>
  <th>Email</th>
  </tr>
  <tr>
  <td ><a href="#" id="stdid">1</a></td>
  <td ><a href="#" id="stdname">Rakesh</a></td>
  <td ><a href="#" id="stdcourse"></a></td>
  <td ><a href="#" id="stdemail">rakeshghasadiya@gmail.com</a></td>
  </tr>
</table>
  </body>
</html>