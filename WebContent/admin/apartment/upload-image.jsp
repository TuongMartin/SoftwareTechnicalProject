
<%@page import="library.CheckRankLibrary"%>
<%@page import="model.bean.TienIch"%>
<%@page import="model.bean.KhuVucBDS"%>
<%@page import="model.bean.NhanVien"%>
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
					<li><a href="<%=request.getContextPath()%>/admin/logout"> <i
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
							<h4 class="title">Thêm hình ảnh</h4>
						</div>
						<div class="content">
							<%
								if(request.getParameter("msg") != null){
									int msg = Integer.parseInt(request.getParameter("msg"));
									switch (msg){
										case 0 :%>
											<p class="category alert alert-danger">Có lỗi trong quá trình thực hiện!</p>
											<%break;
										case 1 :%>
											<p class="category success">Upload hình ảnh thành công!</p>
											<%break;
										case 2 :%>
											<p class="category success">Bạn chưa chọn ảnh để upload!</p>
											<%break;
									}
									
								}
							
							%>
							<form action="" method="post" enctype="multipart/form-data">
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label>Hình ảnh</label> <input name="file" type="file" id="file"
												class="form-control" placeholder="Chọn ảnh"/>
										</div>
									</div>
								</div>
								<div class="text-center">
									<input type="submit" name="submit" class="btn btn-info btn-fill btn-wd" value="Thực hiện"/>
									<a href="<%=request.getContextPath() %>/admin/manageApartments" class="btn btn-success btn-fill btn-wd">Quay lại</a>
								</div>
								<div class="clearfix"></div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/templates/admin/inc/footer.jsp"%>