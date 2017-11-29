<%@page import="library.CheckRankLibrary"%>
<%@page import="model.bean.Account"%>
<%@page import="javax.xml.bind.ParseConversionEvent"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/templates/admin/inc/header.jsp"%>
<%
	if(session.getAttribute("objUser") != null){
		if(CheckRankLibrary.isAdmin(request, response)) { %>
			<%@include file="/templates/admin/inc/leftbar.jsp"%>
		<% }else{ %>
			<%@include file="/templates/NhanVien/inc/LeftBar.jsp"%>
		<%}
	}%>
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
									case 4 : 
										out.print("<span style = 'color:red;font-weight:bold'>Username đã tồn tại</span>");
										break;
									case 5 : 
										out.print("<span style = 'color:red;font-weight:bold'>Thêm thành công</span>");
										break;
									case 6 : 
										out.print("<span style = 'color:red;font-weight:bold'>Thêm không thành công</span>");
										break;
									case 7 : 
										out.print("<span style = 'color:red;font-weight:bold'>Sửa thành công</span>");
										break;
									case 8 : 
										out.print("<span style = 'color:red;font-weight:bold'>Sửa không thành công</span>");
										break;	
								}
							}
							%>
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
										if(accounts.size()!=0)
										for(Account currentAccount:accounts){
											
									%>
										<tr>
											<td><%=accounts.indexOf(currentAccount)+1 %></td>
											<td><%=currentAccount.getTenNhanVien() %></td>
											<td><%=currentAccount.getUsername() %></td>
											<td><%=currentAccount.getrole() %>
											<td>
												<a
												href="<%=request.getContextPath()%>/admin/updateaccount?id=<%=currentAccount.getId()%>"><img
													src="<%=request.getContextPath()%>/templates/admin/img/edit.gif" alt="" />
													Sửa</a> &nbsp;||&nbsp; <a
												href="<%=request.getContextPath()%>/admin/deleteaccount?id=<%=currentAccount.getId()%>" onClick="return confirm('Do you want to delete all device belong to this id?')"><img
													src="<%=request.getContextPath()%>/templates/admin/img/del.gif" alt="" />
													Xóa</a></td>
											</td>
										</tr>
									<% 		
										}
										
									%>
									
								</tbody>
							</table>
							<div class="text-center">
								<ul class="pagination">
								<%
									if(request.getAttribute("sum_page") != null){
										String active = "";
										int sum_page = (Integer) request.getAttribute("sum_page");
										int page_current = (Integer) request.getAttribute("page_current");
										for(int i = 1 ; i <= sum_page ; i++){
											if(page_current == i){
												active = "class = 'current'";
											}else{
												active = "";
											}%>
											<li><a <%=active%> href="<%=request.getContextPath() %>/admin/accounts?p=<%=i%>" title=""><%=i%></a></li>
										<%}
									}
								%>
								</ul>
							</div>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
	<%@include file="/templates/admin/inc/footer.jsp"%>