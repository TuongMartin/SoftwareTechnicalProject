<%@page import="model.bean.TinTuc"%>
<%@page import="model.bean.TuVan"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				<div class="col-md-12">
					<div class="card">
						<div class="header">
							<h4 class="title">Danh Sách Tin Tức</h4>
							
							<form action="${pageContext.request.contextPath}/AdminSearchTinTuc">
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<input type="text" name="search" class="form-control border-input" placeholder="Tìm Theo Tiêu Đề Bài Viết">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<input type="submit" value="Tìm kiếm" class="is" /> 
										</div>
									</div>
								</div>
							</form>
							
							<% if(request.getAttribute("messageStr") != null){ %>
							<p class="category success">${messageStr}</p>
							<% } %>
							
							<a href="<%=request.getContextPath()%>/admin/addTinTuc"
								class="addtop"><img
								src="<%=request.getContextPath()%>/templates/admin/img/add.png" alt="" /> Thêm</a>
						</div>
						<div class="content table-responsive table-full-width">
							<table class="table table-striped">
								<thead>
									<th>ID</th>
									<th>Tiêu Đề</th>
									<th>Thể Loại</th>
									<th>Ngày Đăng Tin</th>
									<th>Chức Năng</th>
								</thead>
								<tbody>
								
								<%
								ArrayList <TinTuc> listTinTuc = (ArrayList<TinTuc>)request.getAttribute("listArticle");
								if(listTinTuc != null && listTinTuc.size() > 0)
								{
									int index = 1;
									
									for(TinTuc obj : listTinTuc)
									{
								%>
										<tr>
										<td><%= index %></td>
										<td><a
											href="<%=request.getContextPath()%>/ShowEditTT?id=<%= obj.getIdTinTuc() %>"><%= obj.getTieuDe() %></a></td>
										<td><%= obj.getLoaiTinTuc() %></td>
										<td><%= obj.getNgayDangTin() %></td>
										<td><a
											href="<%=request.getContextPath()%>/ShowEditTT?id=<%= obj.getIdTinTuc() %>"><img
												src="<%=request.getContextPath()%>/templates/admin/img/edit.gif" alt="" />
												Sửa</a> &nbsp;||&nbsp; <a
											href="<%=request.getContextPath()%>/DelTT?id=<%= obj.getIdTinTuc() %>" onClick="return confirm('Do you want to delete this item')">
											<img
												src="<%=request.getContextPath()%>/templates/admin/img/del.gif" alt="" />
												Xóa</a></td>
										</tr>
								<%
										index++;
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
										}
										
										if(request.getAttribute("search") == null)
										{
											
										
								%>
										<li><a <%=active%> href="<%=request.getContextPath() %>/admin/Article/articles?page=<%=i%>" title=""><%=i%></a></li>
										<%
										}
										else
										{
											
										%>
										<li><a <%=active%> href="<%=request.getContextPath() %>/AdminSearchTinTuc?search=<%=request.getAttribute("search") %>&page=<%=i%>" title=""><%=i%></a></li>
										<%	
										}
									}
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