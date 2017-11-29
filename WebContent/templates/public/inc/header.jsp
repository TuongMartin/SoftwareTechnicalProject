<%@page import="model.dao.RealEstateDAO"%>
<%@page import="model.bean.TheLoaiBDS"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array"%>
<%@page import="model.dao.CustomersDAO"%>
<%@page import="model.bean.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Mirrored from www.vasterad.com/themes/findeo/login-register.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 10 Oct 2017 13:19:25 GMT -->
<head>

<!-- Basic Page Needs
================================================== -->
<title>Findeo</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS
================================================== -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/css/colors/main.css" id="colors">
<script src="<%=request.getContextPath()%>/templates/admin/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/templates/admin/js/jquery.validate.js" type="text/javascript"></script>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAGw-bQBkDDF3ERpXRELFIbMnvEuxtlXBc" async defer>
</script>

</head>

<body>

<!-- Wrapper -->
<div id="wrapper">


<!-- Header Container
================================================== -->
<header id="header-container">

	<!-- Topbar -->
	<div id="top-bar">
		<div class="container">

			<!-- Left Side Content -->
			<div class="left-side">

				<!-- Top bar -->
				<ul class="top-bar-menu">
					<li><i class="fa fa-phone"></i> (123) 123-456 </li>
					<li><i class="fa fa-envelope"></i> <a href="#"><span class="__cf_email__" data-cfemail="bdd2dbdbd4ded8fdd8c5dcd0cdd1d893ded2d0">[email&#160;protected]</span></a></li>
				</ul>

			</div>
			<!-- Left Side Content / End -->


			<!-- Left Side Content -->
			<div class="right-side">

				<!-- Social Icons -->
				<ul class="social-icons">
					<li><a class="facebook" href="#"><i class="icon-facebook"></i></a></li>
					<li><a class="twitter" href="#"><i class="icon-twitter"></i></a></li>
					<li><a class="gplus" href="#"><i class="icon-gplus"></i></a></li>
					<li><a class="pinterest" href="#"><i class="icon-pinterest"></i></a></li>
				</ul>

			</div>
			<!-- Left Side Content / End -->

		</div>
	</div>
	<div class="clearfix"></div>
	<!-- Topbar / End -->


	<!-- Header -->
	<div id="header">
		<div class="container">
			
			<!-- Left Side Content -->
			<div class="left-side">
				
				<!-- Logo -->
				<div id="logo">
					<a href="<%=request.getContextPath() %>/public/home"><img src="<%=request.getContextPath()%>/templates/public/images/logo.png" alt=""></a>
				</div>


				<!-- Mobile Navigation -->
				<div class="menu-responsive">
					<i class="fa fa-reorder menu-trigger"></i>
				</div>


				<!-- Main Navigation -->
				<nav id="navigation" class="style-1">
					<ul id="responsive">

						<li><a href="<%=request.getContextPath() %>/public/home">Home</a></li>

						<li><a href="#">Listings Apartment</a>
							<ul>
							<%
								RealEstateDAO realEstateDA0 = new RealEstateDAO();
								ArrayList<TheLoaiBDS> listRealEstate = (ArrayList<TheLoaiBDS>)realEstateDA0.getItem();
								for(TheLoaiBDS objTheLoai : listRealEstate) {
							%>
								<li><a href="listings-list-with-sidebar.html"><%=objTheLoai.getTen() %></a></li>
							<%
								}
							%>
							</ul>
						</li>

						<li><a href="#">Features</a>
							<ul>
								<li><a href="#">Single Properties</a>
									<ul>
										<li><a href="single-property-page-1.html">Property Style 1</a></li>
										<li><a href="single-property-page-2.html">Property Style 2</a></li>
										<li><a href="single-property-page-3.html">Property Style 3</a></li>
									</ul>
								</li>
								<li><a href="#">Search Styles</a>
									<ul>
										<li><a href="index-2.html">Home Search 1</a></li>
										<li><a href="index-3.html">Home Search 2</a></li>
										<li><a href="index-4.html">Home Search 3</a></li>
										<li><a href="listings-list-full-width.html">Advanced Style</a></li>
										<li><a href="listings-list-with-sidebar.html">Sidebar Search</a></li>
									</ul>
								</li>
								<li><a href="#">My Account</a>
									<ul>
										<li><a href="my-profile.html">My Profile</a></li>
										<li><a href="my-bookmarks.html">Bookmarked Listings</a></li>
										<li><a href="my-properties.html">My Properties</a></li>
										<li><a href="change-password.html">Change Password</a></li>
									</ul>
								</li>
								<li><a href="#">Agents</a>
									<ul>
										<li><a href="agents-list.html">Agents List</a></li>
										<li><a href="agent-page.html">Agent Page</a></li>
									</ul>
								</li>

								<li><a href="submit-property.html">Submit Property</a></li>
							</ul>
						</li>

						<li><a class="current" href="#">Pages</a>
							<ul>
								<li><a href="blog.html">Blog</a>
									<ul>
										<li><a href="blog.html">Blog</a></li>
										<li><a href="blog-post.html">Blog Post</a></li>
									</ul>
								</li>
								<li><a href="contact.html">Contact</a></li>
								<li><a href="elements.html">Elements</a></li>
								<li><a href="pricing-tables.html">Pricing Tables</a></li>
								<li><a href="typography.html">Typography</a></li>
								<li><a href="icons.html">Icons</a></li>
							</ul>
						</li>

					</ul>
				</nav>
				<div class="clearfix"></div>
				<!-- Main Navigation / End -->
				
			</div>
			<!-- Left Side Content / End -->

			<!-- Right Side Content / End -->
			<div class="right-side">
				<!-- Header Widget -->
				<div class="header-widget">
				<%
					CustomersDAO customerDAO = new CustomersDAO();
					if(session.getAttribute("sObjKHId") == null) {
						
				%>
						<a href="<%=request.getContextPath() %>/public/login" class="sign-in"><i class="fa fa-user"></i> Log In / Register</a>
				<%
					}
					else {
						KhachHang objKH = customerDAO.getItemCustomerById((Integer)session.getAttribute("sObjKHId"));
				%>
						<a href="<%=request.getContextPath() %>/public/my-profile?id=<%=objKH.getId() %>" class="sign-in">Hello <%=objKH.getTenKhachHang() %></a>
				<%
					}
				%>
					
					<a href="<%=request.getContextPath() %>/public/logout" class="button border">Logout</a>
				</div>
				<!-- Header Widget / End -->
			</div>
			<!-- Right Side Content / End -->

		</div>
	</div>
	<!-- Header / End -->

</header>
<div class="clearfix"></div>
<!-- Header Container / End -->