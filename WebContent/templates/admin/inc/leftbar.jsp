<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="sidebar" data-background-color="white" data-active-color="danger">
    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="<%=request.getContextPath()%>/admin" class="simple-text">AdminCP</a>
            </div>

            <ul class="nav">
            	<li>
                    <a href="<%=request.getContextPath()%>/admin/cat">
                        <i class="ti-map"></i>
                        <p>Danh mục bạn bè</p>
                    </a>
                </li>
            	 <li class="active">
                    <a href="<%=request.getContextPath()%>/admin">
                        <i class="ti-view-list-alt"></i>
                        <p>Danh sách bạn bè</p>
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/admin/video">
                        <i class="ti-panel"></i>
                        <p>Danh sách video</p>
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