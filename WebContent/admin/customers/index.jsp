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
							<h4 class="title">Danh sách khách hàng</h4>
							<%
								if(request.getParameter("msg") != null){
									int msg = Integer.parseInt(request.getParameter("msg"));
									switch (msg){
										case 0 :%>
											<p class="category alert alert-danger">Có lỗi trong quá trình thực hiện!</p>
											<%break;
										case 1 :%>
											<p class="category success">Xóa khách hàng thành công!</p>
											<%break;
										case 5:%>
											<p class="category alert alert-warning">Không tìm thấy</p>
											<%break;
									}
									
								}
							
							%>
							<form action="<%=request.getContextPath() %>/admin/searchCustomer" method="post">
								<div class="row">
									<div class="col-md-1">
										<div class="form-group">
											<input type="text" name="idCustomer"
												class="form-control border-input" value="" placeholder="ID khách hàng">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<input type="text" name="full_name"
												class="form-control border-input" placeholder="Họ tên"
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
						</div>
						<div class="content table-responsive table-full-width">
							<table class="table table-striped">
								<thead>
									<th>ID</th>
									<th>Họ tên</th>
									<th>Địa chỉ</th>
									<th>Email</th>
									<th>Hình ảnh</th>
									<th>Trạng thái</th>
									<th>Confirm at</th>
									<th>Chức năng</th>
								</thead>
								<tbody>
								<%	
									ArrayList<KhachHang> listCustomers = (ArrayList<KhachHang>)request.getAttribute("listCustomers");
									if(listCustomers.size() > 0 ){
										for(KhachHang objCustomer : listCustomers){
								%>
											<tr>
												<td><%=objCustomer.getId() %></td>
												<td><a href="edit.html"><%=objCustomer.getTenKhachHang() %></a></td>
												<td><%=objCustomer.getDiaChi() %></td>
												<td><%=objCustomer.getEmail() %></td>
												
												<td><img
													src="<%=request.getContextPath()%>/files/<%=objCustomer.getAvatar()%>" alt=""
													width="100px" height="100px" /></td>
												<%
													if(objCustomer.getStatus() == 1) {
												%>
													<td id="setactive-<%=objCustomer.getId()%>">
														<a onclick="return setActive(<%=objCustomer.getId() %>, <%=objCustomer.getStatus() %>)" href="javascript:void(0)" title="Ngừng kích hoạt">
															<img width="30" height="30" src="<%=request.getContextPath()%>/templates/admin/img/tick-circle.gif" alt="" />
														</a>
													</td>
												<%
													}
													else {
												%>
													<td id="setactive-<%=objCustomer.getId()%>">
														<a onclick="return setActive(<%=objCustomer.getId()%>, <%=objCustomer.getStatus() %>)" href="javascript:void(0)" title="Kích hoạt">
															<img width="30" height="30" src="<%=request.getContextPath()%>/templates/admin/img/minus-circle.gif" alt="" />
														</a>
													</td>
												<%
													}
												%>
												<%
													if(objCustomer.getComfirm_at() == null) {
												%>
													<td>Chưa xác nhận</td>
												<%
													}
													else {
												%>
														<td><%=objCustomer.getComfirm_at() %></td>		
												<%
													}
												%>
												<td><a
													href="<%=request.getContextPath() %>/admin/delCustomer?id=<%=objCustomer.getId() %>" onClick="return confirm('Do you want to delete all device belong to this id?')"><img
														src="<%=request.getContextPath()%>/templates/admin/img/del.gif" alt="" />
														Xóa</a></td>
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
											<li><a <%=active%> href="<%=request.getContextPath() %>/admin/manageCustomers?p=<%=i%>" title=""><%=i%></a></li>
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