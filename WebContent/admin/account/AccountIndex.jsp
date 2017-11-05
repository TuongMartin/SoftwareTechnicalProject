<%@page import="model.bean.Account"%>
<%@page import="javax.xml.bind.ParseConversionEvent"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
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
							<h4 class="title">Quản lý tài khoản</h4>	
							<br/>				
							<a href="<%=request.getContextPath()%>/admin/addaccount" class="addtop">
							<img src="<%=request.getContextPath()%>/templates/admin/img/add.png" alt="" /> Thêm</a>
							<br/>
							<%
							if(request.getParameter("msg")!=null) {
								int msg = Integer.parseInt(request.getParameter("msg"));
								switch (msg) {
									case 1 : 
										out.print("<span style = 'color:red;font-weight:bold'>Xóa thành công</span>");
										break;
									case 2 : 
										out.print("<span style = 'color:red;font-weight:bold'>Xóa không thành công</span>");
										break;									
								}
							}
							%>
							<br/>
							<form action="" method="post">
								<input type="submit" name="Timkiem" value="Tìm kiếm" class="btn btn-primary"></input>
								<input type="text" name="keysearch">
							</form>
							
						</div>
						<div class="content table-responsive table-full-width">
							<table class="table table-striped">
								<thead>
									<th>STT</th>
									<th>Full name</th>
									<th>Username</th>
									<th>Role</th>
									<th>Chức năng</th>
								</thead>
								<tbody>
									<%
										ArrayList<Account> accounts = (ArrayList<Account>)request.getAttribute("Accounts");
										int numberpage= (Integer)request.getAttribute("numberpage");								
										if(accounts.size()!=0)
										for(Account currentAccount:accounts){
											
									%>
										<tr>
											<td><%=accounts.indexOf(currentAccount)+1 %></td>
											<td><%=currentAccount.getTenNhanVien() %></td>
											<td><%=currentAccount.getUsername() %></td>
											<td><%=currentAccount.getrole() %>
											<td><a href="<%=request.getContextPath()%>/admin/deleteaccount?id=<%=currentAccount.getId()%>">Xóa</a>|<a href="<%=request.getContextPath()%>/admin/updateaccount?id=<%=currentAccount.getId()%>">Sửa</a></td>
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
												<a href="<%=request.getContextPath()%>/admin/accounts?key=<%=str%>&&page=<%=i%>" class="linkpage"><%=i %></a>
											<% 		
										}
									}else{
									
										for(int i=1;i<numberpage+1;i++){
									%>
										<a href="<%=request.getContextPath()%>/admin/accounts?page=<%=i%>" class="linkpage"><%=i %></a>
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
	</div>
	<%@include file="/templates/admin/inc/footer.jsp"%>