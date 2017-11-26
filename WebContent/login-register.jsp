<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp"%>
<!-- Titlebar
================================================== -->
<div id="titlebar">
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<h2>Log In & Register</h2>
				
				<!-- Breadcrumbs -->
				<nav id="breadcrumbs">
					<ul>
						<li><a href="#">Home</a></li>
						<li>Log In & Register</li>
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
								<p class="category alert alert-danger" style="color: blue;">Có lỗi trong quá trình!</p>
								<%break;
							case 1 :%>
								<p class="category success" style="color: blue;">Bạn đã đăng ký tài khoản thành công, làm ơn xác nhận email!</p>
								<%break;
							case 2 :%>
								<p class="category success" style="color: blue;">Email tài khoản đã tồn tại!</p>
								<%break;
							case 3:%>
								<p class="category alert alert-warning" style="color: blue;">Xác nhận tài khoản thành công, bạn có thể đăng nhập!</p>
								<%break;
							case 4:%>
								<p class="category success" style="color: blue;">Token chưa được xác nhận hoặc đã hết hạn!</p>
								<%break;
							case 5:%>
								<p class="category success" style="color: blue;">Tài khoản của bạn đã tạm thời bị khóa!</p>
								<%break;
							case 6:%>
								<p class="category success" style="color: blue;">Email hoặc mật khẩu không chính xác!</p>
								<%break;
							case 7:%>
								<p class="category success" style="color: blue;">Reset password thành công, mời bạn đăng nhập!</p>
								<%break;
							
						}
						
					}
				
				%>
				<ul class="tabs-nav">
					<li class=""><a href="#tab1">Log In</a></li>
					<li><a href="#tab2">Register</a></li>
				</ul>
		
				<div class="tabs-container alt">
		
					<!-- Login -->
					<div class="tab-content" id="tab1" style="display: none;">
						<form method="post" class="login" action="<%=request.getContextPath() %>/public/login">
		
							<p class="form-row form-row-wide">
								<label for="username">Email:
									<i class="im im-icon-Mail"></i>
									<input type="text" class="input-text" name="email" id="email" value="" />
								</label>
							</p>
		
							<p class="form-row form-row-wide">
								<label for="password">Password:
									<i class="im im-icon-Lock-2"></i>
									<input class="input-text" type="password" name="password" id="password"/>
								</label>
							</p>
		
							<p class="form-row">
								<input type="submit" class="button border margin-top-10" name="submit" value="Login" />
								<label for="rememberme" class="rememberme">
								<input name="rememberme" type="checkbox" id="rememberme" value="forever" /> Remember Me</label>
							</p>
		
							<p class="lost_password">
								<a href="<%=request.getContextPath() %>/public/reset-password" >Lost Your Password?</a>
							</p>
							
						</form>
					</div>
		
					<!-- Register -->
					<div class="tab-content" id="tab2" style="display: none;">
		
						<form action="<%=request.getContextPath() %>/public/register" enctype="multipart/form-data" method="post" class="register" id="registerCustomer">
							<p class="form-row form-row-wide">
								<label for="email2">Email Address:
									<i class="im im-icon-Mail"></i>
									<input type="text" class="input-text" name="email" id="email2" value=""/>
								</label>
							</p>
			
							<p class="form-row form-row-wide">
								<label for="password2">Password:
									<i class="im im-icon-Lock-2"></i>
									<input class="input-text" type="password" name="password" id="password2"/>
								</label>
							</p>
			
							<p class="form-row form-row-wide">
								<label for="repeat_password2">Repeat Password:
									<i class="im im-icon-Lock-2"></i>
									<input class="input-text" type="password" name="repeat_password" id="repeat_password2"/>
								</label>
							</p>
							
							<p class="form-row form-row-wide">
								<label for="full_name2">Full name:
									<i class="im im-icon-Male"></i>
									<input type="text" class="input-text" name="full_name" id="full_name2" value="" />
								</label>
							</p>
							
							<p class="form-row form-row-wide">
								<label for="address2">Address:
									<i class="im im-icon-Home"></i>
									<input type="text" class="input-text" name="address" id="address2" value="" />
								</label>
							</p>
							
							<p class="form-row form-row-wide">
								<label for="home_town2">Home town:
									<i class="im im-icon-Danemark"></i>
									<input type="text" class="input-text" name="home_town" id="home_town2" value="" />
								</label>
							</p>
							
							<p class="form-row form-row-wide">
								<label for="identity_card2">Identity card:
									<i class="im im-icon-Fingerprint-2"></i>
									<input type="text" class="input-text" name="identity_card" id="identity_card2" value="" />
								</label>
							</p>
							
							<p class="form-row form-row-wide">
								<label for="birthday2">Birthday:
									<i class="im im-icon-Calendar-4"></i>
									<input type="date" class="input-text" name="birthday" id="birthday2" value="" />
								</label>
							</p>
							
							<p class="form-row form-row-wide">
								<label for="phone2">Phone:
									<i class="im im-icon-Old-Telephone"></i>
									<input type="text" class="input-text" name="phone" id="phone2" value="" />
								</label>
							</p>
							
							<p class="form-row form-row-wide">
								<label for="avatar2">Avatar:
									<i class="im im-icon-Male"></i>
									<input type="file" class="input-text" name="avatar" id="avatar2" value="" />
								</label>
							</p>
			
							<p class="form-row">
								<input type="submit" class="button border fw margin-top-10" name="register" value="Register" />
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
