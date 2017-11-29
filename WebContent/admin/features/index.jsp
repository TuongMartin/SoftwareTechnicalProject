<%@page import="model.bean.TienIch"%>
<%@page import="model.bean.TheLoaiBDS"%>
<%@page import="model.bean.KhachHang"%>
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
				<div class="col-md-12">
					<div class="card">
						<div class="header">
							<h4 class="title">Danh sách tính năng</h4>
							<%
								if(request.getParameter("msg") != null){
									int msg = Integer.parseInt(request.getParameter("msg"));
									switch (msg){
										case 0 :%>
											<p class="category alert alert-danger">Có lỗi trong quá trình thực hiện!</p>
											<%break;
										case 1 :%>
											<p class="category success">Thêm tính nắng thành công!</p>
											<%break;
										case 2 :%>
											<p class="category success">Sửa tính năng thành công!</p>
											<%break;
										case 3 :%>
											<p class="category success">Xóa tính năng thành công!</p>
											<%break;
									}
									
								}
							
							%>
							<a href="<%=request.getContextPath()%>/admin/addFeature"
								class="addtop"><img
								src="<%=request.getContextPath()%>/templates/admin/img/add.png" alt="" /> Thêm</a>
						</div>
						<div class="content table-responsive table-full-width">
							<table class="table table-striped">
								<thead>
									<th>ID</th>
									<th>Tính năng</th>
									<th>Chức năng</th>
								</thead>
								<tbody>
								<%
									ArrayList<TienIch> listTienIch = (ArrayList<TienIch>)request.getAttribute("listTienIch");
									for(TienIch objTienIch : listTienIch) {
								%>
										<tr>
											<td><%=objTienIch.getIdTienIch() %></td>
											<td><a href="<%=request.getContextPath() %>/admin/editFeature?id=<%=objTienIch.getIdTienIch()%>"><%=objTienIch.getTenTienIch() %></a></td>
											<td><a
												href="<%=request.getContextPath()%>/admin/editFeature?id=<%=objTienIch.getIdTienIch() %>"><img
													src="<%=request.getContextPath()%>/templates/admin/img/edit.gif" alt="" />
													Sửa</a> &nbsp;||&nbsp; <a
												href="<%=request.getContextPath() %>/admin/delFeature?id=<%=objTienIch.getIdTienIch() %>" onClick="return confirm('Do you want to delete all device belong to this id?')"><img
													src="<%=request.getContextPath()%>/templates/admin/img/del.gif" alt="" />
													Xóa</a></td>
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
											<li><a <%=active%> href="<%=request.getContextPath() %>/admin/feature-apartment?p=<%=i%>" title=""><%=i%></a></li>
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
	<script type="text/javascript">
	function setActive(cid, status){
		$.ajax({
			url: '<%=request.getContextPath()%>/customer/active',
			type: 'POST',
			cache: false,
			data: {
				acid: cid, astatus: status
			},
			success: function(data){
				$('#setactive-' + cid).html(data);
			},
			error: function (){
				alert('Có lỗi xảy ra');
			}
		});
		return false;
	}
	</script>
	<%@include file="/templates/admin/inc/footer.jsp"%>