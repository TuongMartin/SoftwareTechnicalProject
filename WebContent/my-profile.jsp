<%@page import="model.bean.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp"%>
<!-- Titlebar
================================================== -->
<div id="titlebar">
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<h2>My Profile</h2>

				<!-- Breadcrumbs -->
				<nav id="breadcrumbs">
					<ul>
						<li><a href="#">Home</a></li>
						<li>My Profile</li>
					</ul>
				</nav>

			</div>
		</div>
	</div>
</div>


<!-- Content
================================================== -->
<div class="container">
	<div class="row">


		<!-- Widget -->
		<div class="col-md-4">
			<div class="sidebar left">

				<div class="my-account-nav-container">
					
					<ul class="my-account-nav">
						<li class="sub-nav-title">Manage Account</li>
						<li><a href="my-profile.html" class="current"><i class="sl sl-icon-user"></i> My Profile</a></li>
						<li><a href="my-bookmarks.html"><i class="sl sl-icon-star"></i> Bookmarked Listings</a></li>
					</ul>
					
					<ul class="my-account-nav">
						<li class="sub-nav-title">Manage Listings</li>
						<li><a href="my-properties.html"><i class="sl sl-icon-docs"></i> My Properties</a></li>
						<li><a href="submit-property.html"><i class="sl sl-icon-action-redo"></i> Submit New Property</a></li>
					</ul>

					<ul class="my-account-nav">
						<li><a href="change-password.html"><i class="sl sl-icon-lock"></i> Change Password</a></li>
						<li><a href="#"><i class="sl sl-icon-power"></i> Log Out</a></li>
					</ul>

				</div>

			</div>
		</div>

		<div class="col-md-8">
			<div class="row">
				<%
					if(request.getParameter("msg") != null){
						int msg = Integer.parseInt(request.getParameter("msg"));
						switch (msg){
							case 0 :%>
								<p class="category alert alert-danger" style="color: blue;">Có lỗi trong quá trình!</p>
								<%break;
							case 1 :%>
								<p class="category success" style="color: blue;">Cập nhật thông tin cá nhân thành công!</p>
								<%break;
						}
						
					}
				
				%>
				<div class="col-md-8 my-profile">
					<h4 class="margin-top-0 margin-bottom-30">My Account</h4>
					<form action="" method="post" enctype="multipart/form-data" id="editCustomer" class="editCustomer">
						<%
							KhachHang objCustomerUpdate = (KhachHang)request.getAttribute("objCustomerUpdate");
						%>
						<label>Your Email</label>
						<input value="<%=objCustomerUpdate.getEmail()%>" type="text" disabled="true">
						
						<label>Your Password</label>
						<input value="" type="password" name="password">
						
						<label>Confirm Your Password</label>
						<input value="" type="password" name="confirm_password">
						
						<label>Your Name</label>
						<input value="<%=objCustomerUpdate.getTenKhachHang() %>" type="text" name="full_name">
	
						<label>Your Address</label>
						<input value="<%=objCustomerUpdate.getDiaChi() %>" type="text" name="address">
	
						<label>Your Home Town</label>
						<input value="<%=objCustomerUpdate.getQueQuan() %>" type="text" name="home_town">	
						
						<label>Your Birthday</label>
						<input value="<%=objCustomerUpdate.getNgaySinh() %>" type="date" name="birthday">
						
						<label>Phone</label>
						<input value="<%=objCustomerUpdate.getSoDienThoai() %>" type="text" name="phone">
						
						<button type="submit" name="editCustomer" class="button margin-top-20 margin-bottom-20">Save Changes</button>
					</div>
	
					<div class="col-md-4">
						<!-- Avatar -->
						<div class="edit-profile-photo">
							<img src="<%=request.getContextPath() %>/files/<%=objCustomerUpdate.getAvatar() %>" alt="">
							<div class="change-photo-btn">
								<div class="photoUpload">
								    <span><i class="fa fa-upload"></i> Upload Photo</span>
								    <input type="file" class="upload" name="avatar"/>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="/templates/public/inc/footer.jsp"%>