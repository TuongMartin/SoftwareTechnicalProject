<%@page import="model.bean.ChucVu"%>
<%@page import="model.dao.ChucVuDAO"%>
<%@page import="model.bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.SalesDAO"%>
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
							<h4 class="title">Danh sách nhân viên</h4>
							<%
								if(request.getParameter("msg") != null){
									int msg = Integer.parseInt(request.getParameter("msg"));
									switch (msg){
										case 0 :%>
											<p class="category alert alert-danger">Thất bại</p>
											<%break;
										case 1 :%>
										<p class="category success">Sửa thành công</p>
										<%break;
										case 2 :%>
										<p class="category success">Thêm thành công</p>
										<%break;
										case 3:%>
										<p class="category alert alert-warning">Mã Nhân Viên đã tồn tại</p>
										<%break;
										case 4:%>
										<p class="category success">Xóa Thành Công</p>
										<%break;
										case 5:%>
										<p class="category alert alert-warning">Không tìm thấy</p>
										<%break;
										case 6:%>
										<p class="category alert alert-warning">Lỗi khi thêm mới Agenda</p>
										<%break;
										case 7:%>
										<p class="category alert alert-warning">Lỗi khi thêm mới ItemAgenda</p>
										<%break;
										
									}
									
								}
							
							%>
							<form action="<%=request.getContextPath() %>/admin/search" method="post">
								<div class="row">
									<div class="col-md-1">
										<div class="form-group">
											<input type="text" name="idSale"
												class="form-control border-input" value="" placeholder="ID Sales">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<input type="text" name="fullname"
												class="form-control border-input" placeholder="Họ tên"
												value="">
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<%
											ChucVuDAO chucVuDAO = new ChucVuDAO();
											String selected = "";
											if(chucVuDAO.getListChucVu() != null){
												ArrayList<ChucVu> list = (ArrayList<ChucVu>) chucVuDAO.getListChucVu();
												if(list.size() > 0){
										%>
											 <select name="chucvu"
												class="form-control border-input">
												<option value="0">---Chọn chức vụ----</option>
												<%
												for(ChucVu obj : list) { 
												%>
													<option value="<%=obj.getIdChucVu()%>"><%=obj.getTenChucVu()%></option>
												<%} 
												%>
											</select>
										<%}
											} %>	
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<input type="submit" name="search" value="Tìm kiếm"
												class="is" /> <input type="submit" name="reset"
												value="Hủy tìm kiếm" class="is" />
										</div>
									</div>
								</div>

							</form>

							<a href="<%=request.getContextPath()%>/admin/show-addSales"
								class="addtop"><img
								src="<%=request.getContextPath()%>/templates/admin/img/add.png" alt="" /> Thêm</a>
						</div>
						<div class="content table-responsive table-full-width">
							<table class="table table-striped">
								<thead>
									<th>ID</th>
									<th>Họ tên</th>
									<th>Hình ảnh</th>
									<th>Ngày sinh</th>
									<th>Chức vụ</th>
									<th>Chức năng</th>
								</thead>
								<tbody>
									<%	
										if(request.getAttribute("listSales") != null ){
											ArrayList<NhanVien> listSales = (ArrayList<NhanVien>) request.getAttribute("listSales");
											if( listSales.size() > 0 ){
												for(NhanVien objSales : listSales){
									%>
									<tr>
										<td><%=objSales.getIdNhanVien() %></td>
										<td><a href="<%=request.getContextPath()%>/admin/show-editSales?idSales=<%=objSales.getIdNhanVien() %>"><%=objSales.getTenNhanVien()%></a></td>
										<td><img
											src="<%=request.getContextPath()%>/files/<%=objSales.getAvatar()%>" alt=""
											width="100px" height="100px" /></td>
										<td><%=objSales.getNgaySinh()%></td>
										<td><%=objSales.getTenChucVu()%></td>
										<td><a
											href="<%=request.getContextPath()%>/admin/show-editSales?idSales=<%=objSales.getIdNhanVien() %>"><img
												src="<%=request.getContextPath()%>/templates/admin/img/edit.gif" alt="" />
												Sửa</a> &nbsp;||&nbsp; <a
											href="<%=request.getContextPath()%>/admin/delSales?idSale=<%=objSales.getIdNhanVien()%>" onClick="return confirm('Do you want to delete all device belong to this id?')"><img
												src="<%=request.getContextPath()%>/templates/admin/img/del.gif" alt="" />
												Xóa</a> &nbsp;||&nbsp; <a
											href="<%=request.getContextPath()%>/admin/showSetCalendar?idSale=<%=objSales.getIdNhanVien()%>" ><i class="fa fa-calendar" aria-hidden="true"></i>
												Lịch</a></td>
									</tr>

								<%				}
											}
										} %>
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
											<li><a <%=active%> href="<%=request.getContextPath() %>/admin/manageSales?p=<%=i%>" title=""><%=i%></a></li>
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