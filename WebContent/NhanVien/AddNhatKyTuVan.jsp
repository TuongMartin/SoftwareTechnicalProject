
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp"%>
<%@page import = "java.util.Date"%>
<%@page import = "java.text.DateFormat"%>
<%@page import = "java.text.SimpleDateFormat"%>
<%@include file="/templates/NhanVien/inc/LeftBar.jsp"%>
<%@page import="model.dao.TuVanDAO"%>
<%@page import="model.bean.TuVan"%>
<div class="main-panel">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar bar1"></span> <span class="icon-bar bar2"></span>
					<span class="icon-bar bar3"></span>
				</button>
				<a class="navbar-brand" href="/admin">Trang Cá Nhân</a>
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
							<h4 class="title">Thêm Nhật Ký Tư Vấn</h4>
							<% if(request.getAttribute("messageStr") != null){ %>
							<p class="category success">${messageStr}</p>
							<% } %>
						</div>
						
						<div class="content">
							<form action="${pageContext.request.contextPath}/addNK"
								method="post">
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Tên Khách Hàng</label> 
											<input type="text" name="username" class="form-control border-input" 
											placeholder="Nhập Tên Khách Hàng" value="">
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>SĐT Khách Hàng</label>
											<input type="text" name="sdt" class="form-control border-input"
											placeholder="Nhập Số Điện Thoại Của Khách Hàng" value="">
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Nội Dung</label>
											<div>
												<textarea class="form-control border-input" name = "noidung"
												rows="8" cols="80">
												</textarea>
											</div>
										</div>
									</div>
								</div>

								<div class="text-center">
									<input type="submit" class="btn btn-info btn-fill btn-wd" value="Thêm" />
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