<%@page import="model.bean.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="sidebar" data-background-color="white" data-active-color="danger">
    	<%
    	NhanVien objNhanVien = null;
    	if(request.getSession().getAttribute("userInfo") != null){ 
    		objNhanVien = (NhanVien) request.getSession().getAttribute("userInfo");
			    	
			    %>
    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="#" class="simple-text"><%=objNhanVien.getTenNhanVien() %></a>
 
			    <!-- normal -->
			    <div class="ih-item circle effect1">
			    <a href="<%=request.getContextPath()%>/admin/show-editSales?idSales=<%=objNhanVien.getIdNhanVien()%>">
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
			        %>
			       	</div>
			        <div class="info">
			          <div class="info-back">
			            <h3><%=objNhanVien.getTenChucVu() %></h3>
			            <p>Chức vụ</p>
			          </div>
			        </div></a>
			       </div>
			    <!-- end normal -->
            </div>
			
            <ul class="nav">

            	<li class="<%=active1 %>">
                    <a href="<%=request.getContextPath()%>/thanhvien/canhos">
                        <i class="ti-map"></i>
                        <p>Danh Sách Căn Hộ</p>
                    </a>
                </li>
            	 <li class="<%=active2 %>">
                    <a href="<%=request.getContextPath()%>/thanhvien/khachhang">
                        <i class="ti-view-list-alt"></i>
                        <p>Danh Sách Khách Hàng</p>
                    </a>
                </li>
                <li class="<%=active3 %>">
                    <a href="<%=request.getContextPath()%>/ShowNKTV">
                        <i class="ti-panel"></i>
                        <p>Nhật Ký Tư Vấn</p>
                    </a>
                </li>
                <li class="<%=active4 %>">
                    <a href="<%=request.getContextPath()%>/admin/showSetCalendar?idSale=<%=((objNhanVien!=null)?objNhanVien.getIdNhanVien():0)%>">
                        <i class="ti-user"></i>
                        <p>Lịch Làm Việc</p>
                    </a>
                </li>
            </ul>
    	</div>
    </div>