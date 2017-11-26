<%@page import="model.bean.Role"%>
<%@page import="java.util.ArrayList"%>
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
							<%
							if(request.getParameter("msg")!=null) {
								int msg = Integer.parseInt(request.getParameter("msg"));
								switch (msg) {
									case 1 : 
										out.print("<span style = 'color:red;font-weight:bold'>Username đã tồn tại</span>");
										break;
									case 2 : 
										out.print("<span style = 'color:red;font-weight:bold'>Thêm thành công</span>");
										break;
									case 3 : 
										out.print("<span style = 'color:red;font-weight:bold'>Thêm không thành công</span>");
										break;
								}
							}
							
							%>
						</div>
						<div class="content">
							<form action="" method="post" id="accountform">
								<%
									ArrayList<Role> roles = (ArrayList<Role>)request.getAttribute("roles");
								%>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Username</label> <input type="text" name="username"
												class="form-control border-input" placeholder="Nhập tên đăng nhập"
												value="">
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Password</label> <input type="password"
												name="password" id="password" class="form-control border-input"
												placeholder="Nhập mật khẩu" value="">
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Xác nhận Password</label> <input type="password" name="repassword" id="repassword"
												class="form-control border-input" placeholder="Xác nhận mật khẩu"
												value="">
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label>Quyền hạn</label> 
											<select name="idroler">
												<%
													if(roles.size()!=0)
													for(int i=0;i<roles.size();i++){														
												%>
													<option value="<%=roles.get(i).item()%>"><%=roles.get(i).getRole() %></option>
												<%
													}
												%>	
											</select>
										</div>
									</div>
								</div>
								<p id="checkpassword"></p>
								<div class="text-center">
									<input type="submit" name="submit" class="btn btn-info btn-fill btn-wd"
										value="Thêm tài khoản" />
								</div>
								<div class="clearfix"></div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>		
	</div>
	<script src="<%=request.getContextPath()%>/templates/admin/js/account-validate.js" type="text/javascript"></script>
	<%@include file="/templates/admin/inc/footer.jsp"%>