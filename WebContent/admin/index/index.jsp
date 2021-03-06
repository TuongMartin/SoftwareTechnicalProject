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
				<div class="col-md-12">
					<div class="card">
						<div class="header">
							<h4 class="title">Danh sách bạn bè</h4>
							<p class="category success">Thêm thành công</p>
							<form action="" method="post">
								<div class="row">
									<div class="col-md-1">
										<div class="form-group">
											<input type="text" name="id"
												class="form-control border-input" value="" placeholder="ID">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<input type="text" name="fullname"
												class="form-control border-input" placeholder="Họ tên"
												value="">
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<select name="friend_list" class="form-control border-input">
												<option value="0">-- Chọn danh mục --</option>
												<option value="1">Bạn quen thời phổ thông</option>
												<option>Bạn quen thời đại học</option>
												<option>Bạn tâm giao</option>
											</select>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<input type="submit" name="search" value="Tìm kiếm"
												class="is" /> <input type="submit" name="reset"
												value="Hủy tìm kiếm" class="is" />
										</div>
									</div>
								</div>

							</form>

							<a href="/admin/friend/add"
								class="addtop"><img
								src="<%=request.getContextPath()%>/templates/admin/img/add.png" alt="" /> Thêm</a>
						</div>
						<div class="content table-responsive table-full-width">
							<table class="table table-striped">
								<thead>
									<th>ID</th>
									<th>Họ tên</th>
									<th>Hình ảnh</th>
									<th>Ngày tạo</th>
									<th>Thuộc danh sách</th>
									<th>Chức năng</th>
								</thead>
								<tbody>

									<tr>
										<td>1</td>
										<td><a href="edit.html">Trần Văn Nam</a></td>
										<td><img
											src="<%=request.getContextPath()%>/templates/admin/img/tim_80x80.png" alt=""
											width="100px" /></td>
										<td>12/12/2015</td>
										<td>Bạn thời phổ thông</td>
										<td><a
											href="/admin/friend/edit"><img
												src="<%=request.getContextPath()%>/templates/admin/img/edit.gif" alt="" />
												Sửa</a> &nbsp;||&nbsp; <a
											href="/admin/friend/del"><img
												src="<%=request.getContextPath()%>/templates/admin/img/del.gif" alt="" />
												Xóa</a></td>
									</tr>

									<tr>
										<td>2</td>
										<td><a
											href="/admin/friend/edit">Trần
												Văn Nam</a></td>
										<td><img
											src="<%=request.getContextPath()%>/templates/admin/img/tim_80x80.png" alt=""
											width="100px" /></td>
										<td>12/12/2015</td>
										<td>Bạn thời phổ thông</td>
										<td><a
											href="/admin/friend/edit"><img
												src="<%=request.getContextPath()%>/templates/admin/img/edit.gif" alt="" />
												Sửa</a> &nbsp;||&nbsp; <a
											href="/admin/friend/del"><img
												src="<%=request.getContextPath()%>/templates/admin/img/del.gif" alt="" />
												Xóa</a></td>
									</tr>

								</tbody>

							</table>

							<div class="text-center">
								<ul class="pagination">
									<li><a href="?p=0" title="">1</a></li>
									<li><a href="?p=1" title="">2</a></li>
									<li><a href="?p=1" title="">3</a></li>
									<li><a href="?p=1" title="">4</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
	<%@include file="/templates/admin/inc/footer.jsp"%>