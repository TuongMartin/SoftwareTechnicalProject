<%@page import="model.bean.LoaiKhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.KhachHang" %>
<%@include file="/templates/admin/inc/header.jsp"%>
<%@include file="/templates/NhanVien/inc/LeftBar.jsp"%>
<%@page import="model.bean.Account"%>
<%@page import="javax.xml.bind.ParseConversionEvent"%>
<div class="main-panel">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar bar1"></span> <span class="icon-bar bar2"></span>
					<span class="icon-bar bar3"></span>
				</button>
				<a class="navbar-brand" href="/admin">Trang nhân viên</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="http://vinenter.edu.vn">
							<p>Wellcome</p>
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
						<br>
							<h4 class="title">Danh sách khách hàng</h4>
							<%
							if(request.getParameter("msg")!=null) {
								int msg = Integer.parseInt(request.getParameter("msg"));
								switch (msg) {
									case 1 : 
										out.print("<span style = 'color:red;font-weight:bold'>Đánh giá thành công</span>");
										break;
									case 2 : 
										out.print("<span style = 'color:red;font-weight:bold'>Đánh giá không thành công</span>");
										break;									
								}
							}
							
							%>					
							<form action="" method="post">
								<div class="row">									
									<div class="col-md-4">
										<div class="form-group">
											<input type="text" name="keysearch"
												class="form-control border-input" placeholder="Tên khách hàng">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<input type="submit" name="Timkiem" value="Tìm kiếm"
												class="is" /> 
										</div>
									</div>
								</div>

							</form>
						<div class="content table-responsive table-full-width">
							<table class="table table-striped">
								<thead>
									<th>STT</th>
									<th>Họ tên</th>
									<th>Địa chỉ</th>
									<th>SDT</th>
									<th>Email</th>
									<th>Đánh giá</th>
									<th>Căn hộ mua</th>
								</thead>
								<tbody>
									<%
										ArrayList<LoaiKhachHang> loaikhachhangs = (ArrayList<LoaiKhachHang>)request.getAttribute("loaikhachhangs");
										ArrayList<KhachHang> khachhangs = (ArrayList<KhachHang>)request.getAttribute("khachhangs");	
										
										int currentpage = (Integer)request.getAttribute("currentpage");
										int numberpage = (Integer)request.getAttribute("numberpage");
										
										if(khachhangs.size()!=0)
										for(KhachHang curentkhachhang:khachhangs){
									%>
										<tr>
											<td><%=khachhangs.indexOf(curentkhachhang)+1+(currentpage-1)*5 %></td>
											<td><%=curentkhachhang.getTenKhachHang() %></td>
											<td><%=curentkhachhang.getDiaChi() %></td>
											<td><%=curentkhachhang.getSoDienThoai() %></td>
											<td><%=curentkhachhang.getEmail() %></td>
											<td>
												<form action="<%=request.getContextPath()%>/thanhvien/Evaluatekhachhang?id=<%=curentkhachhang.getId()%>" method="post">
													<select name="danhgia">
														<%
															String selected="";
															
															for(int i=0;i<loaikhachhangs.size();i++){
																if(curentkhachhang.getIdLoaiKH()==loaikhachhangs.get(i).getIdLoaiKH()){
																	selected = "selected";
																}else{
																	selected="";
																}
														%>
															<option <%=selected %> value="<%=loaikhachhangs.get(i).getIdLoaiKH()%>"><%=loaikhachhangs.get(i).getTenLoaiKH() %></option>
														<% 														
															}
														%>
													</select>
													<input type="submit" name="submit" value="update">
												</form>
											</td>
											<td><a href="<%=request.getContextPath()%>/chitietcanho?canho=<%=curentkhachhang.getIdTinDang()%>">xem...</a></td>
										</tr>
									<% 		
										}
										
									%>
									
								</tbody>
							</table>
							<div class="text-center">
								<ul class="pagination">					
									<%
									String str="";	
									String active = "";
									if(request.getParameter("keysearch")!=null){
										str = request.getParameter("keysearch");
									}else{
										if(request.getParameter("key")!=null){
											str = request.getParameter("key");
										}
									}
									
									if(str!=""){									
										for(int i=1;i<numberpage+1;i++){
											if(currentpage==i) {
												active = "class = 'current'";
											}
											
											%>
												<li><a <%=active%> href="<%=request.getContextPath()%>/thanhvien/khachhang?key=<%=str%>&&page=<%=i%>" title=""><%=i %></a></li>							
											<% 		
										}
									}else{
									
										for(int i=1;i<numberpage+1;i++){	
											if(currentpage==i) {
												active = "class = 'current'";
											}
									%>
										<li><a <%=active%> href="<%=request.getContextPath()%>/thanhvien/khachhang?page=<%=i%>" title=""><%=i %></a></li>
									<% 		
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
	<%@include file="/templates/admin/inc/footer.jsp"%>