<%@page import="library.CheckRankLibrary"%>
<%@page import="model.bean.TheLoaiBDS"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp"%>
<%
	if(session.getAttribute("objUser") != null){
		if(CheckRankLibrary.isAdmin(request, response)) { %>
			<%@include file="/templates/admin/inc/leftbar.jsp"%>
		<% }else{ %>
			<%@include file="/templates/NhanVien/inc/LeftBar.jsp"%>
		<%}
	}%>
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
					<li><a href="<%=request.getContextPath()%>/admin/logout"><i
							class="ti-settings"></i>
							<p>Log out</p>
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
										<p class="category success">Tên thể loại đã tồn tại!</p>
										<%break;
								}
								
							}
						
						%>
						<div class="content">
						<%
							TheLoaiBDS objTheLoaiUpdate = (TheLoaiBDS)request.getAttribute("objTheLoaiUpdate");
						%>
							<form action="" method="post" id="addRealEstate" enctype="multipart/form-data">
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Tên thể loại</label> <input type="text" name="realestate"
												class="form-control border-input" placeholder="Tên thể loại"
												value="<%=objTheLoaiUpdate.getTen() %>">
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Hình ảnh</label> <input type="file" name="image"
												class="form-control" placeholder="Chọn ảnh" />
										</div>
									</div>
								</div>
								<div class="text-center">
									<input type="submit" class="btn btn-info btn-fill btn-wd" name="submit" value="Thực hiện"/>
									<a href="<%=request.getContextPath() %>/admin/category-real-estate" class="btn btn-success btn-fill btn-wd">Quay lại</a>
								</div>
								<div class="clearfix"></div>
							</form>
						</div>
					</div>
				</div>
				
				<script type="text/javascript">
					$(document).ready(function() {
						$("#addRealEstate").validate({
							rules : {
								realestate : {
									required : true,
									maxlength : 50,
								},
							},
							messages : {
								realestate : {
									required : "<span style='color:red'>Tên thể loại không được để trống!</span>",
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