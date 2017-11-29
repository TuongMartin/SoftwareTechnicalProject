<%@page import="library.CheckRankLibrary"%>
<%@page import="model.bean.TheLoaiBDS"%>
<%@page import="model.bean.KhachHang"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
							<h4 class="title">Danh sách thể loại</h4>
							<%
								if(request.getParameter("msg") != null){
									int msg = Integer.parseInt(request.getParameter("msg"));
									switch (msg){
										case 0 :%>
											<p class="category alert alert-danger">Có lỗi trong quá trình thực hiện!</p>
											<%break;
										case 1 :%>
											<p class="category success">Thêm thể loại thành công!</p>
											<%break;
										case 2 :%>
											<p class="category success">Sửa thể loại thành công!</p>
											<%break;
										case 3 :%>
											<p class="category success">Xóa thể loại thành công!</p>
											<%break;
									}
									
								}
							
							%>
							<a href="<%=request.getContextPath()%>/admin/addRealEstate"
								class="addtop"><img
								src="<%=request.getContextPath()%>/templates/admin/img/add.png" alt="" /> Thêm</a>
						</div>
						<div class="content table-responsive table-full-width">
							<table class="table table-striped">
								<thead>
									<th>ID</th>
									<th>Thể loại</th>
									<th>Hình ảnh</th>
									<th>Chức năng</th>
								</thead>
								<tbody>
								<%
									ArrayList<TheLoaiBDS> listTheLoai = (ArrayList<TheLoaiBDS>)request.getAttribute("listTheLoai");
									for(TheLoaiBDS objTheLoai : listTheLoai) {
								%>
										<tr>
											<td><%=objTheLoai.getId() %></td>
											<td><a href="<%=request.getContextPath() %>/admin/editRealEstate?id=<%=objTheLoai.getId()%>"><%=objTheLoai.getTen() %></a></td>
											<td>
												<img style="width:100px;height:100px;" src="<%=request.getContextPath() %>/files/<%=objTheLoai.getImage()%>" >
											</td>
											<td><a
												href="<%=request.getContextPath()%>/admin/editRealEstate?id=<%=objTheLoai.getId() %>"><img
													src="<%=request.getContextPath()%>/templates/admin/img/edit.gif" alt="" />
													Sửa</a> &nbsp;||&nbsp; <a
												href="<%=request.getContextPath() %>/admin/delRealEstate?id=<%=objTheLoai.getId() %>" onClick="return confirm('Do you want to delete all device belong to this id?')"><img
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
											<li><a <%=active%> href="<%=request.getContextPath() %>/admin/category-real-estate?p=<%=i%>" title=""><%=i%></a></li>
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