<%@page import="model.bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.SalesDAO"%>
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
				<div class="col-md-12">
					<div class="card">
						<div class="header">
							<h4 class="title">Danh sách nhân viên</h4>
							<%
								if(request.getParameter("msg") != null){
									int msg = Integer.parseInt(request.getParameter("msg"));
									switch (msg){
										case 0 :%>
											<p class="category alert alert-danger">Thất bại</p>
											<%break;
										case 1 :%>
										<p class="category success">Sửa thành công</p>
										<%break;
										case 2 :%>
										<p class="category success">Thêm thành công</p>
										<%break;
										case 3:%>
										<p class="category alert alert-warning">Mã Nhân Viên đã tồn tại</p>
										<%break;
										
									}
									
								}
							
							%>
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

							<a href="<%=request.getContextPath()%>/admin/show-addSales"
								class="addtop"><img
								src="<%=request.getContextPath()%>/templates/admin/img/add.png" alt="" /> Thêm</a>
						</div>
						<div class="content table-responsive table-full-width">
							<table class="table table-striped">
								<thead>
									<th>ID</th>
									<th>Họ tên</th>
									<th>Hình ảnh</th>
									<th>Ngày sinh</th>
									<th>Chức vụ</th>
									<th>Chức năng</th>
								</thead>
								<tbody>
									<%	
										SalesDAO salesDAO = new SalesDAO();
										if(salesDAO.getListUser() != null){
											ArrayList<NhanVien> listSales = (ArrayList<NhanVien>) salesDAO.getListUser();
											if( listSales.size() > 0 ){
												for(NhanVien objSales : listSales){
									%>
									<tr>
										<td><%=objSales.getIdNhanVien() %></td>
										<td><a href="edit.html"><%=objSales.getTenNhanVien()%></a></td>
										<td><img
											src="<%=request.getContextPath()%>/files/<%=objSales.getAvatar()%>" alt=""
											width="100px" height="100px" /></td>
										<td><%=objSales.getNgaySinh()%></td>
										<td><%=objSales.getTenChucVu()%></td>
										<td><a
											href="<%=request.getContextPath()%>/admin/show-editSales?idSales=<%=objSales.getIdNhanVien() %>"><img
												src="<%=request.getContextPath()%>/templates/admin/img/edit.gif" alt="" />
												Sửa</a> &nbsp;||&nbsp; <a
											href="/admin/friend/del"><img
												src="<%=request.getContextPath()%>/templates/admin/img/del.gif" alt="" />
												Xóa</a></td>
									</tr>

								<%				}
											}
										} %>
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