<%@page import="library.CheckRankLibrary"%>
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
							<h4 class="title">Sửa thông tin</h4>
						</div>
						<div class="content">
							<form action="/admin/user/edit"
								method="post">
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Username</label> <input type="text" name="username"
												class="form-control border-input" placeholder="Họ tên"
												value="">
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Username</label> <input type="password"
												name="password" class="form-control border-input"
												placeholder="Nhập password" value="">
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Fullname</label> <input type="text" name="fullname"
												class="form-control border-input" placeholder="Họ tên"
												value="">
										</div>
									</div>
								</div>

								<div class="text-center">
									<input type="submit" class="btn btn-info btn-fill btn-wd"
										value="Thực hiện" />
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