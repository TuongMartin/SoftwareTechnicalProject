<%@page import="model.bean.Role"%>
<%@page import="model.dao.RoleDAO"%>
<%@page import="model.bean.ChucVu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.ChucVuDAO"%>
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
						<div class="content">
							<form action="<%=request.getContextPath()%>/admin/addSales"
								method="post" enctype="multipart/form-data" id="addSales">
								<div class="row">
									<div class="col-md-2">
										<div class="form-group">
											<label>Mã Nhân Viên</label> <input type="text" name="id"
												class="form-control border-input" value="">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label>Họ tên</label> <input type="text" name="hoten"
												class="form-control border-input" placeholder="Họ tên"
												value="">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="date">Ngày Sinh</label> <input type="date"
												id="myDate" name="ngaysinh" value=""
												class="form-control border-input" placeholder="Ngày tạo">
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-2">
										<div class="form-group">
											<label>CMND</label> <input type="text" name="CMND"
												class="form-control border-input" value="">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label>Quê quán</label> <input type="text" name="quequan"
												class="form-control border-input" placeholder="Họ tên"
												value="">
										</div>
									</div>

									<div class="col-md-4">
										<div class="form-group">
											<label for="date">Số Điện Thoại</label> <input type="text"
												name="sdt" value="" onmouseleave = "" class="form-control border-input"
												placeholder="Ngày tạo">
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label>Địa Chỉ</label> <input type="text" name="diachi"
												class="form-control border-input" placeholder="Họ tên"
												value="">
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<%/*
												ChucVuDAO chucVuDAO = new ChucVuDAO();
												if (chucVuDAO.getListChucVu() != null) {
													ArrayList<ChucVu> list = (ArrayList<ChucVu>) chucVuDAO.getListChucVu();
													if (list.size() > 0) {
											%>
											<label>Chức vụ</label> <select name="chucvu"
												class="form-control border-input">
												<%
													for (ChucVu obj : list) {
												%>
												<option value="<%=obj.getIdChucVu()%>"><%=obj.getTenChucVu()%></option>
												<%
													}
												%>
											</select>
											<%
												}
												}*/
											%>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label>Tên Đăng Nhập</label> <input type="text"
												name="username" class="form-control border-input"
												placeholder="username" value="" maxlength="100"
												minlength="8" required>
										</div>
									</div>
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
											<label>Cấp bậc:</label> 
											<select name="idrole">
												<%
													RoleDAO roleDAO = new RoleDAO();
													ArrayList<Role> listRole = roleDAO.roles();
													if(listRole.size()!=0)
													for(Role item : listRole){														
												%>
													<option value="<%=item.item()%>"><%=item.getRole() %></option>
												<%
													}
												%>	
											</select>
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
								</div>
								<div class="text-center">
									<input type="submit" class="btn btn-info btn-fill btn-wd" onClick = "return phonenumber();"
										value="Thực hiện"/>
								</div>
								<div class="clearfix"></div>
							</form>
						</div>
					</div>
				</div>
				
				<script type="text/javascript">
					$(document).ready(function() {
						$("#addSales").validate({
							rules : {
								id : {
									required : true,
									number: true,
								},
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
					
					
					function phonenumber() {
						  var numberPhone = document.getElementsByName('sdt')[0].value;			
						  var phoneno = "(\\+84|0)\\d{9,10}";
						  if(numberPhone.match(phoneno)) {
						    return true;
						  }
						  else {
						    alert("Vui lòng kiểm tra lại số điện thoại");
						    return false;
						  }
						}
				</script>

			</div>
		</div>
	</div>
	<%@include file="/templates/admin/inc/footer.jsp"%>