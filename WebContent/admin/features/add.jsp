<%@page import="model.bean.TienIch"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp"%>
<%@include file="/templates/admin/inc/leftbar.jsp"%>
<div class="main-panel">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar bar1"></span> <span class="icon-bar bar2"></span>
					<span class="icon-bar bar3"></span>
				</button>
				<a class="navbar-brand" href="/admin">Trang quản lý</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="http://vinenter.edu.vn"> <i
							class="ti-settings"></i>
							<p>Settings</p>
					</a></li>
				</ul>

			</div>
		</div>
	</nav>

	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 col-md-12">
					<div class="card">
						<div class="header">
							<h4 class="title">Thêm thông tin</h4>
						</div>
						<%
							if(request.getParameter("msg") != null){
								int msg = Integer.parseInt(request.getParameter("msg"));
								switch (msg){
									case 2 :%>
										<p class="category success">Tên tính năng đã tồn tại!</p>
										<%break;
								}
								
							}
						
						%>
						<div class="content">
							<form action="" method="post" id="addFeature" enctype="multipart/form-data">
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Tên tính năng</label> <input type="text" name="tienich"
												class="form-control border-input" placeholder="Tên tính năng"
												value="">
										</div>
									</div>
								</div>
								<div class="text-center">
									<input type="submit" class="btn btn-info btn-fill btn-wd" name="submit" value="Thực hiện"/>
									<a href="<%=request.getContextPath() %>/admin/feature-apartment" class="btn btn-success btn-fill btn-wd">Quay lại</a>
								</div>
								<div class="clearfix"></div>
							</form>
						</div>
					</div>
				</div>
				
				<script type="text/javascript">
					$(document).ready(function() {
						$("#addFeature").validate({
							rules : {
								tienich : {
									required : true,
									maxlength : 50,
								},
							},
							messages : {
								tienich : {
									required : "<span style='color:red'>Tên tính năng không được để trống!</span>",
									maxlength : "<span style='color:red'>Tối đa 50 kí tự!</span>",
								}
							},

						});
					});
				</script>
			</div>
		</div>
	</div>
	<%@include file="/templates/admin/inc/footer.jsp"%>