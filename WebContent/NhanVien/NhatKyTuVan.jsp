<%@page import="model.dao.TuVanDAO"%>
<%@page import="model.bean.TuVan"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				<a class="navbar-brand" href="/nhanvien">Trang Cá Nhân</a>
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
							<h4 class="title">Nhật Ký Tư Vấn</h4>
							<a href="<%=request.getContextPath()%>/addNK"
								class="addtop"><img
								src="<%=request.getContextPath()%>/templates/admin/img/add.png" alt="" /> Thêm</a>
						</div>
						
						<div class="content table-responsive table-full-width">
						
							<table class="table table-striped">
								<thead>
									<th>STT</th>
									<th>Khách Hàng</th>
									<th>Số Điện Thoại Liên Hệ</th>
									<th>Nội Dung Tư Vấn</th>
									<th>Ngày Tư Vấn</th>
								</thead>
								
								<tbody>
								<%
								if(request.getAttribute("listNoiDung") != null)
								{
									ArrayList<TuVan> listTuVan = (ArrayList<TuVan>) request.getAttribute("listNoiDung");
									if(listTuVan != null)
									{
										if(listTuVan.size() > 0)
										{
											int index = 1;
											for(TuVan obj : listTuVan)
											{
								
								%>			
											<tr>
												<td><%= index %></td>
												<td><%= obj.getTenKhachHang() %></td>
												<td><%= obj.getSDT() %></td>
												<td><a href = "#<%= obj.getSDT() %>" class="login-window">Chi Tiết</a></td>
												
												<div id="<%= obj.getSDT() %>" class="login">
													<p class="login_title"> Nội Dung Tư Vấn</p>
													<div class = "noidung"><p><%= obj.getNoiDungTuVan() %></p></div>
												</div>
												
												<td><%= obj.getNgayTuVan() %></td>
											</tr>
								<% 	
											index++;
											}
										}
									}
								}	
								%>	
								</tbody>
										
							</table>
							
							<div class="text-center">
								<ul class="pagination">
								<%
								if(request.getAttribute("sumPage") != null)
								{
									String active = "";
									int sumPage = (Integer) request.getAttribute("sumPage");
									int currentPage = (Integer) request.getAttribute("currentPage");
									for(int i = 1 ; i <= sumPage ; i++)
									{
										if(currentPage == i)
										{
											active = "class = 'current'";
										}
										else
										{
											active = "";
										}%>
										<li><a <%=active%> href="<%=request.getContextPath() %>/NhanVien/NhatKyTuVan?page=<%=i%>" title=""><%=i%></a></li>
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