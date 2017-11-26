<%@page import="model.bean.Image"%>
<%@page import="model.dao.ImageDAO"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.bean.CanHo"%>
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
							<h4 class="title">Danh sách căn hộ</h4>
							<%
								if(request.getParameter("msg") != null){
									int msg = Integer.parseInt(request.getParameter("msg"));
									switch (msg){
										case 0 :%>
											<p class="category alert alert-danger">Có lỗi trong quá trình thực hiện!</p>
											<%break;
										case 1 :%>
											<p class="category success">Thêm căn hộ thành công!</p>
											<%break;
										case 2 :%>
											<p class="category success">Sửa căn hộ thành công!</p>
											<%break;
										case 3 :%>
											<p class="category success">Xóa căn hộ thành công!</p>
											<%break;
										case 5:%>
											<p class="category alert alert-warning">Không tìm thấy</p>
											<%break;
									}
									
								}
							
							%>
							<form action="<%=request.getContextPath() %>/admin/searchApartment" method="post">
								<div class="row">
									<div class="col-md-1">
										<div class="form-group">
											<input type="text" name="idCanHo"
												class="form-control border-input" value="" placeholder="ID căn hộ">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<input type="text" name="tenCanHo"
												class="form-control border-input" placeholder="Tên căn hộ"
												value="">
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

							<a href="<%=request.getContextPath()%>/admin/addApartment"
								class="addtop"><img
								src="<%=request.getContextPath()%>/templates/admin/img/add.png" alt="" /> Thêm</a>
						</div>
						<div class="content table-responsive table-full-width">
							<table class="table table-striped">
								<thead>
									<th>ID</th>
									<th>Tên căn hộ</th>
									<th>Hình ảnh</th>
									<th>Địa chỉ</th>
									<th>Nhân viên</th>
									<th>Thể loại</th>
									<th>Khu vực</th>
									<th>Trạng thái</th>
									<th>Kích hoạt</th>
									<th>Ngày đăng</th>
									<th>Chức năng</th>
								</thead>
								<tbody>
								<%	
									ImageDAO imageDAO = new ImageDAO();
									ArrayList<CanHo> listApartments = (ArrayList<CanHo>)request.getAttribute("listApartments");
									if(listApartments.size() > 0 ){
										for(CanHo objApartment : listApartments){
											Image objImage = imageDAO.getItemImage(objApartment.getId());
								%>
											<tr>
												<td><%=objApartment.getId() %></td>
												<td><a href=""><%=objApartment.getTen() %></a></td>
												<td>
												<%
													if(objImage != null) {
												%>
														<img style="width: 100px;height: 100px" src="<%=request.getContextPath() %>/files/<%=objImage.getHinhAnh()%>">
												<%
													}else {
												%>
														<img style="width: 100px;height: 100px" src="<%=request.getContextPath() %>/templates/admin/img/default.png">	
												<%
													}
												%>
													
												</td>
												<td><%=objApartment.getDiachi() %></td>
												<td><%=objApartment.getTennhanvien() %></td>
												<td><%=objApartment.getTentheloai() %></td>
												<td><%=objApartment.getTenkhuvuc() %></td>
												<%
													if(objApartment.getTrangthai() == 0) {
												%>
														<td style="text-align:center;">Chưa bán</td>
												<%
													}
													else {
												%>
														<td style="text-align:center;">Đã bán</td>
												<%
													}
												%>
												
												<%
													if(objApartment.getKichHoat() == 1) {
												%>
													<td style="text-align:center;" id="setactive-<%=objApartment.getId()%>">
														<a onclick="return setActive(<%=objApartment.getId() %>, <%=objApartment.getKichHoat() %>)" href="javascript:void(0)" title="Ngừng kích hoạt">
															<img width="30" height="30" src="<%=request.getContextPath()%>/templates/admin/img/tick-circle.gif" alt="" />
														</a>
													</td>
												<%
													}
													else {
												%>
													<td style="text-align:center;" id="setactive-<%=objApartment.getId()%>">
														<a onclick="return setActive(<%=objApartment.getId()%>, <%=objApartment.getKichHoat() %>)" href="javascript:void(0)" title="Kích hoạt">
															<img width="30" height="30" src="<%=request.getContextPath()%>/templates/admin/img/minus-circle.gif" alt="" />
														</a>
													</td>
												<%
													}
												%>
												<td><%=objApartment.getNgaydang() %></td>
												<td><a
													href="<%=request.getContextPath()%>/admin/editApartment?id=<%=objApartment.getId() %>"><img
														src="<%=request.getContextPath()%>/templates/admin/img/edit.gif" alt="" />
														Sửa</a> &nbsp;||&nbsp; <a
													href="<%=request.getContextPath() %>/admin/delApartment?id=<%=objApartment.getId() %>" onClick="return confirm('Do you want to delete all device belong to this id?')"><img
														src="<%=request.getContextPath()%>/templates/admin/img/del.gif" alt="" />
														Xóa</a>&nbsp;||&nbsp; <a
													href="<%=request.getContextPath() %>/admin/uploadImageApartment?id=<%=objApartment.getId() %>"><img style="width: 15px;height: 15px"
														src="<%=request.getContextPath()%>/templates/admin/img/upload.png" alt="" />
														Upload</a></td></td>
											</tr>
								<%		
										}
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
											<li><a <%=active%> href="<%=request.getContextPath() %>/admin/manageApartments?p=<%=i%>" title=""><%=i%></a></li>
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
	function setActive(aid, status){
		$.ajax({
			url: '<%=request.getContextPath()%>/apartment/active',
			type: 'POST',
			cache: false,
			data: {
				aaid: aid, astatus: status
			},
			success: function(data){
				$('#setactive-' + aid).html(data);
			},
			error: function (){
				alert('Có lỗi xảy ra');
			}
		});
		return false;
	}
	</script>
	<%@include file="/templates/admin/inc/footer.jsp"%>