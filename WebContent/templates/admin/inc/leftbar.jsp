<%@page import="model.bean.NhanVien"%>
<%@page import="model.dao.SalesDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="sidebar" data-background-color="white" data-active-color="danger">
    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="<%=request.getContextPath()%>/admin" class="simple-text">AdminCP</a>
 
			    <!-- normal -->
			    <div class="ih-item circle effect1"><a href="#">
			        <div class="spinner"></div>
			        <div class="img">
			        <%
			        	if(request.getSession().getAttribute("userInfo") != null){ 
			        		NhanVien objNhanVien = (NhanVien) request.getSession().getAttribute("userInfo");
			        	%>
			        		<img src="<%=request.getContextPath()%>/files/<%=objNhanVien.getAvatar()%>" alt="img">
			        	<%}
			        %>
			       	</div>
			        <div class="info">
			          <div class="info-back">
			            <h3>AdminCP</h3>
			            <p>Description goes here</p>
			          </div>
			        </div></a></div>
			    <!-- end normal -->
            </div>
			
            <ul class="nav">
            	<li>
                    <a href="<%=request.getContextPath()%>/admin/category-real-estate">
                        <i class="ti-view-list-alt"></i>
                        <p>Quản lý thể loại BĐS</p>
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/admin/area-real-estate">
                        <i class="ti-view-list-alt"></i>
                        <p>Quản lý khu vực BĐS</p>
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/admin/manageApartments">
                        <i class="ti-view-list-alt"></i>
                        <p>Quản lý bất động sản</p>
                    </a>
                </li>
            	<li>
                    <a href="<%=request.getContextPath()%>/admin/cat">
                        <i class="ti-map"></i>
                        <p>Danh mục bạn bè</p>
                    </a>
                </li>
            	 <li class="active">
                    <a href="<%=request.getContextPath()%>/admin/manageSales">
                        <i class="ti-view-list-alt"></i>
                        <p>Danh sách nhân viên</p>
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/admin/accounts">
                        <i class="ti-panel"></i>
                        <p>Quản lý tài khoản</p>
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/admin/user">
                        <i class="ti-user"></i>
                        <p>Danh sách người dùng</p>
                    </a>
                </li>
            </ul>
    	</div>
    </div>