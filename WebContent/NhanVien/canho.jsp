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
							<br>
							<form action="" method="post">
								<input type="submit" name="Timkiem" value="Tìm kiếm" class="btn btn-primary"></input>
								<input type="text" name="keysearch">
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
										int numberpage= (Integer)request.getAttribute("numberpage");								
										if(canhos.size()!=0)
										for(CanHo currentcanho:canhos){
											
									%>
										<tr>
											<td><%=canhos.indexOf(currentcanho)+1 %></td>
											<td><%=currentcanho.getTen() %></td>
											<td><%=currentcanho.getTentheloai() %></td>
											<td><%=(currentcanho.getTrangthai()==1?"Chưa bán":"Đã bán") %></td>
											<td><a>xem...</a></td>
										</tr>
									<% 		
										}
										
									%>
									
								</tbody>
							</table>
							<div class="numofpage">
								Trang
								<%
									String str="";
									if(request.getParameter("keysearch")!=null){
										str = request.getParameter("keysearch");
									}else{
										if(request.getParameter("key")!=null){
											str = request.getParameter("key");
										}
									}
									
									if(str!=""){									
										for(int i=1;i<numberpage+1;i++){
											%>
												<a href="<%=request.getContextPath()%>/thanhvien/canhos?key=<%=str%>&&page=<%=i%>" class="linkpage"><%=i %></a>
											<% 		
										}
									}else{
									
										for(int i=1;i<numberpage+1;i++){
									%>
										<a href="<%=request.getContextPath()%>/thanhvien/canhos?page=<%=i%>" class="linkpage"><%=i %></a>
									<% 		
										}
									}	
								%>
							</div>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
	<%@include file="/templates/admin/inc/footer.jsp"%>