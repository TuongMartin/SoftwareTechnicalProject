<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.KhachHang" %>
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
						<br>
							<h4 class="title">Danh sách khách hàng</h4>
							<form action="" method="post">
								<input type="submit" name="Timkiem" value="Tìm kiếm" class="btn btn-primary"></input>
								<input type="text" name="keysearch">
							</form>
						</div>
						<div class="content table-responsive table-full-width">
							<table class="table table-striped">
								<thead>
									<th>STT</th>
									<th>Họ tên</th>
									<th>Địa chỉ</th>
									<th>SDT</th>
									<th>Email</th>
									<th>Căn hộ mua</th>
								</thead>
								<tbody>
									<%
										ArrayList<KhachHang> khachhangs = (ArrayList<KhachHang>)request.getAttribute("khachhangs");									
										int numberpage = (Integer)request.getAttribute("numberpage");	
										if(khachhangs.size()!=0)
										for(KhachHang curentkhachhang:khachhangs){
									%>
										<tr>
											<td><%=khachhangs.indexOf(curentkhachhang)+1 %></td>
											<td><%=curentkhachhang.getTenKhachHang() %></td>
											<td><%=curentkhachhang.getDiaChi() %></td>
											<td><%=curentkhachhang.getSoDienThoai() %></td>
											<td><%=curentkhachhang.getEmail() %></td>
											<td><a href="<%=curentkhachhang.getIdTinDang()%>">xem...</a></td>
										</tr>
									<% 		
										}
										
									%>
									
								</tbody>
							</table>
							<div class="numofpage">
								Trang
								<%
									String str="";									
									if(request.getParameter("keysearch")!=null){
										str = request.getParameter("keysearch");
									}else{
										if(request.getParameter("key")!=null){
											str = request.getParameter("key");
										}
									}
									
									if(str!=""){									
										for(int i=1;i<numberpage+1;i++){
											%>
												<a href="<%=request.getContextPath()%>/thanhvien/khachhang?key=<%=str%>&&page=<%=i%>" class="linkpage"><%=i %></a>
											<% 		
										}
									}else{
									
										for(int i=1;i<numberpage+1;i++){
									%>
										<a href="<%=request.getContextPath()%>/thanhvien/khachhang?page=<%=i%>" class="linkpage"><%=i %></a>
									<% 		
										}
									}	
								%>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
	<%@include file="/templates/admin/inc/footer.jsp"%>