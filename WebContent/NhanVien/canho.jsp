<%@page import="javax.xml.bind.ParseConversionEvent"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.CanHo" %>
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
				<a class="navbar-brand" href="/admin">Trang nhân viên</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="http://vinenter.edu.vn"> 
							<p>Wellcome</p><p>thoát</p>
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
							<form action="" method="post">
								<div class="row">									
									<div class="col-md-4">
										<div class="form-group">
											<input type="text" name="keysearch"
												class="form-control border-input" placeholder="Tên căn hộ">
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
						</div>
						<div class="content table-responsive table-full-width">
							<table class="table table-striped">
								<thead>
									<th>STT</th>
									<th>Tên căn hộ</th>
									<th>Phân loại</th>
									<th>Trạng thái</th>
									<th>Chi tiết</th>
								</thead>
								<tbody>
									<%
										ArrayList<CanHo> canhos = (ArrayList<CanHo>)request.getAttribute("canhos");
									
										int currentpage = (Integer)request.getAttribute("currentpage");
										int numberpage= (Integer)request.getAttribute("numberpage");
										
										if(canhos.size()!=0)
										for(CanHo currentcanho:canhos){
											
									%>
										<tr>
											<td><%=canhos.indexOf(currentcanho)+1+(currentpage-1)*5 %></td>
											<td><%=currentcanho.getTen() %></td>
											<td><%=currentcanho.getTentheloai() %></td>
											<td><%=(currentcanho.getTrangthai()==0?"Chưa bán":"Đã bán") %></td>
											<td><a href="<%=request.getContextPath()%>/chitietcanho?canho=<%=currentcanho.getId()%>">xem...</a></td>
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
												<li><a <%=active%> href="<%=request.getContextPath()%>/thanhvien/canhos?key=<%=str%>&&page=<%=i%>" title=""><%=i %></a></li>							
											<% 		
										}
									}else{
									
										for(int i=1;i<numberpage+1;i++){	
											if(currentpage==i) {
												active = "class = 'current'";
											}
									%>
										<li><a <%=active%> href="<%=request.getContextPath()%>/thanhvien/canhos?page=<%=i%>" title=""><%=i %></a></li>
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
	</div>
	<%@include file="/templates/admin/inc/footer.jsp"%>