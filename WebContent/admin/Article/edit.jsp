<%@page import="model.bean.TinTuc"%>
<%@page import="model.bean.TheLoaiTinTuc"%>
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
				<div class="col-lg-12 col-md-12">
					<div class="card">
						<div class="header">
							<h4 class="title">Thêm Tin Tức</h4>
						</div>
						<div class="content">
							<form action="${pageContext.request.contextPath}/EditTT" method="post">
							<%
							TinTuc objTinTuc = (TinTuc)request.getAttribute("objTinTuc");
							if(objTinTuc != null)
							{
							%>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Tiêu Đề</label> <input type="text" name="TieuDe"
												class="form-control border-input"
												value="<%= objTinTuc.getTieuDe() %>">	
										</div>
									</div>
								</div>
								
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Thể Loại</label> 
											<select name = "idLoaiTinTuc" value = "<%= objTinTuc.getLoaiTinTuc() %></select>">
											<%
											ArrayList<TheLoaiTinTuc> listTheLoai = (ArrayList<TheLoaiTinTuc>)request.getAttribute("listLoaiTinTuc");
											if(listTheLoai != null && listTheLoai.size() > 0)
											{
												for(TheLoaiTinTuc obj : listTheLoai)
												{
											%>
													<%
													if(obj.getIdPhanLoaiTinTuc() == (int)request.getAttribute("idLoaiTinTuc"))
													{
													%>
														<option value = "<%= obj.getIdPhanLoaiTinTuc() %>" selected="selected"><%= obj.getLoaiTinTuc() %></option>
													<%		
													}
													else
													{
													%>
														<option value = "<%= obj.getIdPhanLoaiTinTuc() %>"><%= obj.getLoaiTinTuc() %></option>
													<%	
													}
													%>
											<%
												}
											}
											%>
											</select>	
										</div>
									</div>
								</div>
								
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>URL Hình Ảnh</label> <input type="text" name="UrlHinhAnh"
												class="form-control border-input"
												value="<%= objTinTuc.getHinhAnh() %>">	
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Trích Dẫn</label> 
												<textarea name="quote" class="form-control border-input" cols="80", rows="5">
													<%= objTinTuc.getQuote() %>
												</textarea>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Nội Dung</label>
											 <textarea name="noidungtintuc" class="form-control border-input" cols="80", rows="15">
											 	<%= objTinTuc.getNoiDung() %>
											</textarea>
										</div>
									</div>
								</div>	
							<%	
							}
							%>

								<div class="text-center">
									<input type="submit" class="btn btn-info btn-fill btn-wd" value="Thực hiện" />
								</div>
								<div class="clearfix"></div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%@include file="/templates/admin/inc/footer.jsp"%>