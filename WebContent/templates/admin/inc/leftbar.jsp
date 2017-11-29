<%@page import="model.bean.NhanVien"%>
<%@page import="model.dao.SalesDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="sidebar" data-background-color="white" data-active-color="danger">
	<%
			NhanVien objNhanVien = null;
			if(request.getSession().getAttribute("userInfo") != null){ 
				objNhanVien = (NhanVien) request.getSession().getAttribute("userInfo");
	%>
    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="<%=request.getContextPath()%>/admin" class="simple-text">AdminCP</a>
 
			    <!-- normal -->
			    <div class="ih-item circle effect1"><a href="#">
			        <div class="spinner"></div>
			        <div class="img">
			        <%
			        		if(!"".equals(objNhanVien.getAvatar())) {
			        	%>
			        			<img src="<%=request.getContextPath()%>/files/<%=objNhanVien.getAvatar()%>" alt="img">
			        	<%		
			        		} else {
			        	%>
			        			<img src="<%=request.getContextPath()%>/templates/admin/img/avatar-default.jpg" alt="img">
			        	<%
			        		}
			        	%>
	
			        	<%}
			        %>
			       	</div>
			        <div class="info">
			          <div class="info-back">
			            <h3><%=objNhanVien.getTenChucVu()%></h3>
			            <p>Chức vụ</p>
			          </div>
			        </div></a></div>
			        <%}
			        %>
			    <!-- end normal -->
            </div>
            <%
				String active1 = "", active2 = "", active3 = "", active4 = "", active5 = "", active6 = "", active7 = "";
            	int actived = 0;
            	if(request.getParameter("actived") != null) {
            		actived = Integer.parseInt(request.getParameter("actived"));
            	}
            	if(actived == 1) {
            		active1 = "active";
            	}
            	else if(actived == 2) {
            		active2 = "active";
            	}
            	else if(actived == 3) {
            		active3 = "active";
            	}
            	else if(actived == 4) {
            		active4 = "active";
            	}
            	else if(actived == 5) {
            		active5 = "active";
            	}
            	else if(actived == 6) {
            		active6 = "active";
            	}
            	else if(actived == 7) {
            		active7 = "active";
            	}
            %>
            <ul class="nav">
            	<li class="<%=active1 %>">
                    <a href="<%=request.getContextPath()%>/admin/category-real-estate">
                        <i class="ti-view-list-alt"></i>
                        <p>Quản lý thể loại BĐS</p>
                    </a>
                </li>
                <li class="<%=active2 %>">
                    <a href="<%=request.getContextPath()%>/admin/area-real-estate">
                        <i class="ti-view-list-alt"></i>
                        <p>Quản lý khu vực BĐS</p>
                    </a>
                </li>
                <li class="<%=active6 %>">
                    <a href="<%=request.getContextPath()%>/admin/feature-apartment">
                        <i class="ti-view-list-alt"></i>
                        <p>Quản lý tính năng BĐS</p>
                    </a>
                </li>
                <li class="<%=active3 %>">
                    <a href="<%=request.getContextPath()%>/admin/manageApartments">
                        <i class="ti-panel"></i>
                        <p>Quản lý bất động sản</p>
                    </a>
                </li>
                <li class="<%=active4 %>">
                    <a href="<%=request.getContextPath()%>/admin/manageCustomers">
                        <i class="ti-user"></i>
                        <p>Danh sách khách hàng</p>
                    </a>
                </li>
                <li class="<%=active5 %>">
                    <a href="<%=request.getContextPath()%>/admin/manageSales">
                        <i class="ti-user"></i>
                        <p>Danh sách nhân viên</p>
                    </a>
                <li class="<%=active7 %>">
                    <a href="<%=request.getContextPath()%>/admin/accounts">
                        <i class="ti-user"></i>
                        <p>Quản lý tài khoản</p>
                    </a>
                </li>
            </ul>
    	</div>
    </div>