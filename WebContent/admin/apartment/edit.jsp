<%@page import="com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array"%>
<%@page import="model.bean.TienIch"%>
<%@page import="model.bean.CanHo"%>
<%@page import="model.bean.KhuVucBDS"%>
<%@page import="model.bean.NhanVien"%>
<%@page import="model.bean.TheLoaiBDS"%>
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
				<div class="col-lg-12 col-md-12">
					<div class="card">
						<div class="header">
							<h4 class="title">Sửa thông tin</h4>
						</div>
						<div class="content">
							<form action=""
								method="post" enctype="multipart/form-data" id="editApartment">
								<%
									CanHo objCanHoUpdate = (CanHo)request.getAttribute("objCanHoUpdate");
								%>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label>Tên căn hộ</label> <input type="text" name="name"
												class="form-control border-input" value="<%=objCanHoUpdate.getTen() %>" placeholder="Tên căn hộ">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label>Địa chỉ</label> <input type="text" name="address"
												class="form-control border-input" placeholder="Địa chỉ"
												value="<%=objCanHoUpdate.getDiachi() %>">
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<label>Diện tích</label> <input type="text"
												id="area" name="area" value="<%=objCanHoUpdate.getDientich() %>"
												class="form-control border-input" placeholder="Diện tích">
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<label>Giá tiền</label> <input type="text"
												id="price" name="price" value="<%=objCanHoUpdate.getGiatien() %>"
												class="form-control border-input" placeholder="Giá tiền">
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-2">
										<div class="form-group">
											<label>Số phòng</label> <input type="number" name="totalRoom"
												class="form-control border-input" min="1" value="<%=objCanHoUpdate.getSophong() %>">
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<label>Số phòng ngủ</label> <input type="number" name="bedRoom"
												class="form-control border-input" min="1"
												value="<%=objCanHoUpdate.getSophongngu() %>">
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<label>Số phòng tắm</label> <input type="number"
												name="bathRoom" onmouseleave = "" class="form-control border-input"
												min="1" value="<%=objCanHoUpdate.getSophongtam() %>">
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<label>Số năm tuổi</label> <input type="number"
												name="buildingAge" onmouseleave = "" class="form-control border-input"
												min="1" value="<%=objCanHoUpdate.getTuoi() %>">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label>Parking</label> <input type="text" placeholder="Parking"
												name="parking" onmouseleave = "" class="form-control border-input"
												value="<%=objCanHoUpdate.getParking() %>">
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label>Cooling</label> <input type="text" name="cooling"
												class="form-control border-input" placeholder="Cooling"
												value="<%=objCanHoUpdate.getCooling() %>">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label>Heating</label> <input type="text" name="heating"
												class="form-control border-input" placeholder="Heating"
												value="<%=objCanHoUpdate.getHeating() %>">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label>Sewer</label> <input type="text" name="sewer"
												class="form-control border-input" placeholder="Sewer"
												value="<%=objCanHoUpdate.getSewer() %>">
										</div>
									</div>
								</div>
								
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label>Water</label> <input type="text" name="water"
												class="form-control border-input" placeholder="Water"
												value="<%=objCanHoUpdate.getWater() %>">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label>Exercise room</label> <select name="exerciseRoom"
											class="form-control border-input">
											<%
												String selected3 = "";
												String selected4 = "";
												if(objCanHoUpdate.getPhongtap() == 0) {
													selected3 = "selected='selected'";
												}
												else{
													selected4 = "selected='selected'";
												}
											%>
												<option <%=selected3 %> value="0">No</option>
												<option <%=selected4 %> value="1">Yes</option>
											</select> 
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label>Storage room</label> <select name="storageRoom"
											class="form-control border-input">
											<%
												String selected5 = "";
												String selected6 = "";
												if(objCanHoUpdate.getNhakho() == 0) {
													selected5 = "selected='selected'";
												}
												else{
													selected6 = "selected='selected'";
												}
											%>
												<option <%=selected5 %> value="0">No</option>
												<option <%=selected6 %> value="1">Yes</option>
											</select>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-3">
										<div class="form-group">
											<label>Thể loại</label> <select name="theloai"
												class="form-control border-input">
												<%
													ArrayList<TheLoaiBDS> listTheLoai = (ArrayList<TheLoaiBDS>)request.getAttribute("listTheLoai");
													String selected = "";
													for(TheLoaiBDS objTheLoai : listTheLoai) {
														if(objCanHoUpdate.getIdtheloai() == objTheLoai.getId()){
															selected = "selected='selected'";
														}
														else{
															selected = "";
														}
												%>
														<option <%=selected %> value="<%=objTheLoai.getId() %>"><%=objTheLoai.getTen() %></option>
												<%
													}
												%>
											</select>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label>Khu vực</label> <select name="khuvuc"
												class="form-control border-input">
												<%
													ArrayList<KhuVucBDS> listKhuVuc = (ArrayList<KhuVucBDS>)request.getAttribute("listKhuVuc");
													String selected1 = "";
													for(KhuVucBDS objKhuVuc : listKhuVuc) {
														if(objCanHoUpdate.getIdkhuvuc() == objKhuVuc.getId()){
															selected1 = "selected='selected'";
														}
														else{
															selected1 = "";
														}
												%>
														<option <%=selected1 %> value="<%=objKhuVuc.getId() %>"><%=objKhuVuc.getTen() %></option>
												<%
													}
												%>
											</select>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label>Nhân viên phụ trách</label> <select name="nhanvien"
												class="form-control border-input">
												<%
													ArrayList<NhanVien> listNhanVien = (ArrayList<NhanVien>)request.getAttribute("listNhanVien");
													String selected2 = "";
													for(NhanVien objNhanVien : listNhanVien) {
														if(objCanHoUpdate.getIdnhanvien() == objNhanVien.getIdNhanVien()){
															selected2 = "selected='selected'";
														}
														else{
															selected2 = "";
														}
												%>
														<option <%=selected2 %> value="<%=objNhanVien.getIdNhanVien() %>"><%=objNhanVien.getTenNhanVien() %></option>
												<%
													}
												%>
											</select>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Tiện ích</label>
										</div>
									</div>
								</div>
								<%
								ArrayList<TienIch> listTienIchCanHo = (ArrayList<TienIch>)request.getAttribute("listTienIchCanHo");
									ArrayList<TienIch> listTienIch = (ArrayList<TienIch>)request.getAttribute("listTienIch");
									int row = (int)Math.ceil((float)listTienIch.size() / 4);
									int k = 0;
									for(int i = 0; i < row; i++) {
								%>
										<div class="row">
										<%
											for(int j = k; j < listTienIch.size(); j++) {
												String checked = "";
												for(TienIch objTienIchCanHo : listTienIchCanHo) {
													if(listTienIch.get(j).getIdTienIch() == objTienIchCanHo.getIdTienIch()) {
														checked = "checked";
														break;
													}
												}
										%>
												<div class="col-md-3">
													<div class="form-group form-control">
														<label class="checkbox-inline"><input <%=checked %> name="tienich" type="checkbox" value="<%=listTienIch.get(j).getIdTienIch() %>"><%=listTienIch.get(j).getTenTienIch() %></label>
													</div>
												</div>
										<%
												k++;
												if(k % 4 == 0) break;
											}
										%>
										</div>
								<%
										
									}
								%>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Mô tả</label> <textarea name="mota"
												class="form-control border-input ckeditor">
												<%=objCanHoUpdate.getMota() %>
											</textarea>
										</div>
									</div>
								</div>
								

								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label>Hình ảnh</label> <input type="file" name="file"
												class="form-control" placeholder="Chọn ảnh" />
										</div>
									</div>
								</div>
								<div class="text-center">
									<input type="submit" name="submit" class="btn btn-info btn-fill btn-wd" value="Thực hiện"/>
									<a href="<%=request.getContextPath() %>/admin/manageApartments" class="btn btn-success btn-fill btn-wd">Quay lại</a>
								</div>
								<div class="clearfix"></div>
							</form>
						</div>
					</div>
				</div>
				
				<script type="text/javascript">
					$(document).ready(function() {
						$("#editApartment").validate({
							rules : {
								name : {
									required : true,
								},
								address : {
									required : true,
								},
								area : {
									required : true,
									number : true,
								},
								price : {
									required : true,
									number : true,
								},
							},
							messages : {
								name : {
									required : "<span style='color:red'>Tên căn hộ không được để trống!</span>",
								},
								address : {
									required : "<span style='color:red'>Địa chỉ không được để trống!</span>",
								},
								area : {
									required : "<span style='color:red'>Diện tích không được để trống!</span>",
									number : "<span style='color:red'>Nhập đúng định dạng số!</span>",
								},
								price : {
									required : "<span style='color:red'>Giá tiền không được để trống!</span>",
									number : "<span style='color:red'>Nhập đúng định dạng số!</span>",
								},
							},

						});
					});
				</script>
			</div>
		</div>
	</div>
	<%@include file="/templates/admin/inc/footer.jsp"%>