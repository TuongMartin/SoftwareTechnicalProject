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
							<h4 class="title">Thêm thông tin</h4>
						</div>
						<div class="content">
							<form
								action="/admin/friend/edit"
								method="post">
								<div class="row">
									<div class="col-md-2">
										<div class="form-group">
											<label>ID</label> <input type="text" name="id"
												class="form-control border-input" disabled value="1">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label>Họ tên</label> <input type="text" name="fullname"
												class="form-control border-input" placeholder="Họ tên"
												value="Trần Nguyễn Gia Huy">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="date">Ngày tạo</label> <input type="text"
												name="date" value="20/12/2016"
												class="form-control border-input" placeholder="Ngày tạo">
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Danh mục bạn bè</label> <select name="friend_list"
												class="form-control border-input">
												<option value="">Bạn quen thời phổ thông</option>
												<option>Bạn quen thời đại học</option>
												<option>Bạn tâm giao</option>
											</select>
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label>Hình ảnh</label> <input type="file" name="picture"
												class="form-control" placeholder="Chọn ảnh" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label>Ảnh cũ</label> <img src="assets/img/tim_80x80.png"
												width="120px" alt="" /> Xóa <input type="checkbox"
												name="delete_picture" value="1" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Mô tả</label>
											<textarea rows="4" class="form-control border-input"
												placeholder="Mô tả tóm tắt về bạn của bạn"></textarea>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Chi tiết</label>
											<textarea rows="6" class="form-control border-input"
												placeholder="Mô tả chi tiết về bạn của bạn"></textarea>
										</div>
									</div>
								</div>

								<div class="text-center">
									<input type="submit" class="btn btn-info btn-fill btn-wd"
										value="Thực hiện" />
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