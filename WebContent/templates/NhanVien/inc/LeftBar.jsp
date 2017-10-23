<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="sidebar" data-background-color="white" data-active-color="danger">
    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="<%=request.getContextPath()%>/nhanvien" class="simple-text">Nhân Viên</a>
 
			    <!-- normal -->
			    <div class="ih-item circle effect1"><a href="#">
			        <div class="spinner"></div>
			        <div class="img"><img src="<%=request.getContextPath()%>/templates/admin/img/Taylor-Swift.jpg" alt="img"></div>
			        <div class="info">
			          <div class="info-back">
			            <h3>Nhân Viên</h3>
			            <p>Description goes here</p>
			          </div>
			        </div></a></div>
			    <!-- end normal -->
            </div>
			
            <ul class="nav">
            	<li>
                    <a href="<%=request.getContextPath()%>/NhanVien/DanhSachCanHo.jsp">
                        <i class="ti-map"></i>
                        <p>Danh Sách Căn Hộ</p>
                    </a>
                </li>
            	 <li class="active">
                    <a href="<%=request.getContextPath()%>/admin">
                        <i class="ti-view-list-alt"></i>
                        <p>Danh Sách Khách Hàng</p>
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/ShowNKTV">
                        <i class="ti-panel"></i>
                        <p>Nhật Ký Tư Vấn</p>
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/admin/user">
                        <i class="ti-user"></i>
                        <p>Lịch Làm Việc</p>
                    </a>
                </li>
            </ul>
    	</div>
    </div>