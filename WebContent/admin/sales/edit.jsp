<%@page import="model.bean.ChucVu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.ChucVuDAO"%>
<%@page import="model.bean.NhanVien"%>
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
							<h4 class="title">Cập nhật thông tin</h4>
						</div>
						<div class="content">
						<%
							if(request.getAttribute("objSale") != null){
								NhanVien objSale = (NhanVien) request.getAttribute("objSale");
						%>
							<form
								action="<%=request.getContextPath()%>/admin/Sales/edit?idSale=<%=objSale.getIdNhanVien()%>"
								method="post" enctype="multipart/form-data" id = "editSales">
								<div class="row">
									<div class="col-md-2">
										<div class="form-group">
											<label>Mã Nhân Viên</label> <input type="text" name="id"
												class="form-control border-input" disabled value="<%=objSale.getIdNhanVien()%>">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label>Họ tên</label> <input type="text" name="hoten"
												class="form-control border-input" placeholder="Họ tên"
												value="<%=objSale.getTenNhanVien()%>">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="date">Ngày Sinh</label>
											<input type="date" id="myDate" name="ngaysinh" value="<%=objSale.getNgaySinh()%>"
												class="form-control border-input" placeholder="Ngày tạo">
										</div>
									</div>
								</div>
								
								<div class="row">
									<div class="col-md-2">
										<div class="form-group">
											<label>CMND</label> <input type="text" name="CMND"
												class="form-control border-input" value = "<%=objSale.getCMND()%>">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label>Quê quán</label> <input type="text" name="quequan"
												class="form-control border-input" placeholder="Họ tên"
												value="<%=objSale.getQueQuan()%>">
										</div>
									</div>
									
									<div class="col-md-4">
										<div class="form-group">
											<label for="date">Số Điện Thoại</label> <input type="text"
												name="sdt" value="<%=objSale.getSDT()%>"
												class="form-control border-input" placeholder="Ngày tạo">
										</div>
									</div>
								</div>
								
								<div class="row">
									<div class="col-md-6">
											<div class="form-group">
												<label>Địa Chỉ</label> <input type="text" name="diachi"
													class="form-control border-input" placeholder="Họ tên"
													value="<%=objSale.getDiaChi()%>">
											</div>
									</div>
								</div>
				
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
										<%
											ChucVuDAO chucVuDAO = new ChucVuDAO();
											String selected = "";
											if(chucVuDAO.getListChucVu() != null){
												ArrayList<ChucVu> list = (ArrayList<ChucVu>) chucVuDAO.getListChucVu();
												if(list.size() > 0){
										%>
											<label>Chức vụ</label> <select name="chucvu"
												class="form-control border-input">
												<%
												for(ChucVu obj : list) { 
													if(objSale.getIdChucVu() == obj.getIdChucVu()) {
														selected = "selected";
													} else {
														selected = "";
													}
												%>
													<option <%=selected%> value="<%=obj.getIdChucVu()%>"><%=obj.getTenChucVu()%></option>
												<%} 
												%>
											</select>
										<%}
											} %>	
										</div>
									</div>
								</div>
								
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label>Mật Khẩu</label> <input type="password"
												name="password" id = "password" class="form-control border-input"
												placeholder="password" value="" maxlength="100"
												minlength="8" required>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label>Xác nhận mật Khẩu</label> <input type="password"
												name="repassword" class="form-control border-input"
												placeholder="password" value="" maxlength="100"
												minlength="8" required>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label>Hình ảnh</label> <input type="file" name="hinhanh"
												class="form-control" placeholder="Chọn ảnh" />
										</div>
									</div>
									<%
										if(objSale.getAvatar() != "" || objSale.getAvatar() != null){
									%>
									<div class="col-md-6">
										<div class="form-group">
										<%
											if(!"".equals(objSale.getAvatar())) {
										%>
												<label>Ảnh cũ</label> <img width = "100px" height = "100px" src="<%=request.getContextPath() %>/files/<%=objSale.getAvatar() %>"
												width="120px" alt="" /> Xóa <input type="checkbox"
												name="delete_picture" value="1" />
										<%
											} else {
										%>
												<label>Ảnh cũ</label> <img width = "100px" height = "100px" src="<%=request.getContextPath() %>/templates/admin/img/avatar-default.jpg"
												width="120px" alt="" /> Xóa <input type="checkbox"
												name="delete_picture" value="1" />
										<%
											}
										%>
											
										</div>
									</div>
									<%} %>
								</div>

								<div class="text-center">
									<input type="submit" class="btn btn-info btn-fill btn-wd"
										value="Thực hiện" />
								</div>
								<div class="clearfix"></div>
							</form>
							<%} %>
						</div>
					</div>
				</div>
			
			<script type="text/javascript">
					$(document).ready(function() {
						$("#addSales").validate({
							rules : {
								hoten : {
									required : true,
								},
								ngaysinh : {
									required : true,
									date : true,
								},
								CMND : {
									required : true,
								},
								quequan : {
									required : true,
								},
								sdt : {
									required : true,
								},
								diachi : {
									required : true,
								},
								username : {
									required : true,
								},
								password : {
									required : true,
								},
								repassword : {
									required : true,
									equalTo: "#password",
								},
							},
							messages : {},

						});
					});
				</script>
			</div>
		</div>
	</div>
	<%@include file="/templates/admin/inc/footer.jsp"%>