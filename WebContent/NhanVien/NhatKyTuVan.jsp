<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/templates/admin/inc/header.jsp"%>
<%@include file="/templates/NhanVien/inc/LeftBar.jsp"%>
<div class="main-panel">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar bar1"></span> <span class="icon-bar bar2"></span>
					<span class="icon-bar bar3"></span>
				</button>
				<a class="navbar-brand" href="/nhanvien">Trang Cá Nhân</a>
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
							<h4 class="title">Nhật Ký Tư Vấn</h4>
							<p class="category success">Thêm thành công</p>
							<a href="<%=request.getContextPath()%>/admin/user/add"
								class="addtop"><img
								src="<%=request.getContextPath()%>/templates/admin/img/add.png" alt="" /> Thêm</a>
						</div>
						
						<div class="content table-responsive table-full-width">
						
							<table class="table table-striped">
								<thead>
									<th>STT</th>
									<th>Khách Hàng</th>
									<th>Nội Dung Tư Vấn</th>
									<th>Ngày Tư Vấn</th>
								</thead>
								
								<tbody>
									<tr>
										<td>1</td>
										<td><a
											href="<%=request.getContextPath()%>/admin/user/edit">Nguyễn Văn A</a></td>
										<td>Tư vấn cho khách hàng về sự tiện dụng của các tiện nghi trong phòng khách</td>
										<td>15/10/2017</td>
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