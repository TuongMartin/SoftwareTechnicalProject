<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp"%>
<!-- Titlebar
================================================== -->
<div id="titlebar">
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<h2>Reset password</h2>
				
				<!-- Breadcrumbs -->
				<nav id="breadcrumbs">
					<ul>
						<li><a href="#">Home</a></li>
						<li>Reset password</li>
					</ul>
				</nav>

			</div>
		</div>
	</div>
</div>

<!-- Contact
================================================== -->

<!-- Container -->
<div class="container">

	<div class="row">
		<div class="col-md-4 col-md-offset-4">
	
		<!--Tab -->
			<div class="my-account style-1 margin-top-5 margin-bottom-40">
			<%
					if(request.getParameter("msg") != null){
						int msg = Integer.parseInt(request.getParameter("msg"));
						switch (msg){
							case 0 :%>
								<p class="category alert alert-danger" style="color: blue;">Email khách hàng không tồn tại trong CSDL!</p>
								<%break;
							case 1 :%>
								<p class="category success" style="color: blue;">Bạn đã yêu cầu reset pasword thành công, vui lòng check mail xác nhận!</p>
								<%break;
						}
						
					}
				
				%>
				<ul class="tabs-nav">
					<li class=""><a href="#tab1">Reset password</a></li>
				</ul>
		
				<div class="tabs-container alt">
					<!-- Reset password -->
					<div class="tab-content" id="tab1" style="display: none;">
						<form method="post" class="login">
							<p class="form-row form-row-wide">
								<label for="username">Email:
									<i class="im im-icon-Mail"></i>
									<input type="text" class="input-text" name="email" id="email" value="" />
								</label>
							</p>
		
							<p class="form-row">
								<input type="submit" class="button border margin-top-10" name="submit" value="Reset password" />
							</p>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Container / End -->
<%@include file="/templates/public/inc/footer.jsp"%>
