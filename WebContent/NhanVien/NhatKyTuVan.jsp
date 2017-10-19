<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/templates/admin/inc/header.jsp"%>
<%@include file="/templates/NhanVien/inc/leftBar.jsp"%>
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
				<div class="col-md-12">
					<div class="card">
						<div class="header">
							<h4 class="title">Danh mục người dùng</h4>
							<p class="category success">Thêm thành công</p>
							<a href="<%=request.getContextPath()%>/admin/user/add"
								class="addtop"><img
								src="<%=request.getContextPath()%>/templates/admin/img/add.png" alt="" /> Thêm</a>
						</div>
						<div class="content table-responsive table-full-width">
							<table class="table table-striped">
								<thead>
									<th>ID</th>
									<th>Username</th>
									<th>Fullname</th>
									<th>Chức năng</th>
								</thead>
								<tbody>

									<tr>
										<td>1</td>
										<td><a
											href="<%=request.getContextPath()%>/admin/user/edit">Admin</a></td>
										<td>Trần Nguyễn Gia Huy</td>
										<td><a
											href="<%=request.getContextPath()%>/admin/user/edit"><img
												src="<%=request.getContextPath()%>/templates/admin/img/edit.gif" alt="" />
												Sửa</a> &nbsp;||&nbsp; <a
											href="<%=request.getContextPath()%>/admin/user/del"><img
												src="<%=request.getContextPath()%>/templates/admin/img/del.gif" alt="" />
												Xóa</a></td>
									</tr>

									<tr>
										<td>2</td>
										<td><a
											href="<%=request.getContextPath()%>/admin/user/edit">Mod</a></td>
										<td>Trần Nguyễn Gia Huy</td>
										<td><a
											href="${pageContext.request.contextPath}/admin/user/edit"><img
												src="<%=request.getContextPath()%>/templates/admin/img/edit.gif" alt="" />
												Sửa</a> &nbsp;||&nbsp; <a
											href="${pageContext.request.contextPath}/admin/user/del"><img
												src="<%=request.getContextPath()%>/templates/admin/img/del.gif" alt="" />
												Xóa</a></td>
									</tr>

								</tbody>
							</table>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
	<%@include file="/templates/admin/inc/footer.jsp"%>