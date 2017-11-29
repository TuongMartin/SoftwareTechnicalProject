<%@page import="model.dao.TinTucDAO"%>
<%@page import="model.bean.TinTuc"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<!-- Mirrored from www.vasterad.com/themes/findeo/blog.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 10 Oct 2017 13:18:54 GMT -->
<head>

<!-- Basic Page Needs
================================================== -->
<title>Findeo</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS
================================================== -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/css/search.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/css/colors/main.css" id="colors">

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
					<li><i class="fa fa-envelope"></i> <a href="#"><span class="__cf_email__" data-cfemail="68070e0e010b0d280d10090518040d460b0705">[email&#160;protected]</span></a></li>
					<li>
						<div class="top-bar-dropdown">
							<span>Dropdown Menu</span>
							<ul class="options">
								<li><div class="arrow"></div></li>
								<li><a href="#">Nice First Link</a></li>
								<li><a href="#">Second Link With Long Title</a></li>
								<li><a href="#">Third Link</a></li>
							</ul>
						</div>
					</li>
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
					<a href="index-2.html"><img src="<%=request.getContextPath()%>/templates/public/images/logo.png" alt=""></a>
				</div>


				<!-- Mobile Navigation -->
				<div class="menu-responsive">
					<i class="fa fa-reorder menu-trigger"></i>
				</div>


				<!-- Main Navigation -->
				<nav id="navigation" class="style-1">
					<ul id="responsive">

						<li><a href="#">Home</a>
							<ul>
								<li><a href="index-2.html">Home 1</a></li>
								<li><a href="index-3.html">Home 2</a></li>
								<li><a href="index-4.html">Home 3</a></li>
								<li><a href="index-5.html">Home 4</a></li>
							</ul>
						</li>

						<li><a href="#">Listings</a>
							<ul>
								<li><a href="#">List Layout</a>
									<ul>
										<li><a href="listings-list-with-sidebar.html">With Sidebar</a></li>
										<li><a href="listings-list-with-map.html">With Map</a></li>
										<li><a href="listings-list-full-width.html">Full Width</a></li>
									</ul>
								</li>
								<li><a href="#">Grid Layout</a>
									<ul>
										<li><a href="listings-grid-standard-with-sidebar.html">Standard With Sidebar</a></li>
										<li><a href="listings-grid-compact-with-sidebar.html">Compact With Sidebar</a></li>
										<li><a href="listings-grid-with-map.html">With Map</a></li>
										<li><a href="listings-grid-full-width.html">Full Width</a></li>
									</ul>
								</li>
								<li><a href="#">Half Map</a>
									<ul>
										<li><a href="listings-half-map-list.html">List Layout</a></li>
										<li><a href="listings-half-map-grid-standard.html">Grid Standard Layout</a></li>
										<li><a href="listings-half-map-grid-compact.html">Grid Compact Layout</a></li>
									</ul>
								</li>
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
					<a href="login-register.html" class="sign-in"><i class="fa fa-user"></i> Log In / Register</a>
					<a href="submit-property.html" class="button border">Submit Property</a>
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



<!-- Titlebar
================================================== -->
<div id="titlebar">
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<h2>Blog</h2>
				<span>Keep up to date with the latest news</span>
				
				<!-- Breadcrumbs -->
				<nav id="breadcrumbs">
					<ul>
						<li><a href="#">Home</a></li>
						<li>Blog</li>
					</ul>
				</nav>

			</div>
		</div>
	</div>
</div>


<!-- Content
================================================== -->
<div class="container">

	<!-- Blog Posts -->
	<div class="blog-page">
	<div class="row">
		<div class="col-md-8">

			<% 
			if(request.getAttribute("listTinTuc") != null)
			{
				ArrayList<TinTuc> listTinTuc = (ArrayList<TinTuc>) request.getAttribute("listTinTuc");
				if(listTinTuc != null && listTinTuc.size() > 0)
				{
					for(TinTuc obj : listTinTuc)
					{
			%>
						<!-- Blog Post -->
						<div class="blog-post">
							<!-- Img -->
							<a href="<%= request.getContextPath() %>/blog-post?idTinTuc=<%= obj.getIdTinTuc() %>" class="post-img">
								<img src="<%= obj.getHinhAnh() %>" alt="">
							</a>
				
							<!-- Content -->
							<div class="post-content">
								<h3><a href="<%= request.getContextPath() %>/blog-post?idTinTuc=<%= obj.getIdTinTuc() %>"><%= obj.getTieuDe() %></a></h3>

								<ul class="post-meta">
									<li><%= obj.getNgayDangTin() %></li>
									<li><a href="#">5 Comments</a></li>
								</ul>
								<p><%= obj.getQuote() %></p>

								<a href="<%= request.getContextPath() %>/blog-post?idTinTuc=<%= obj.getIdTinTuc() %>" class="read-more">Read More <i class="fa fa-angle-right"></i></a>
							</div>

						</div>
						<!-- Blog Post / End -->
			<%			
					}
				}
			}
			%>

			<!-- Pagination -->
			<div class="clearfix"></div>
			<div class="pagination-container">
				<nav class="pagination">
				<ul>
			<%
			if(request.getAttribute("sumPage") != null && request.getAttribute("search") == null)
			{
				String active = "";
				int sumPage = (Integer) request.getAttribute("sumPage");
				int currentPage = (Integer) request.getAttribute("currentPage");
				for(int i = 1 ; i <= sumPage ; i++)
				{
					if(currentPage == i)
					{
						active = "class = 'current'";
					}
					else
					{
						active = "";
					}
			%>
					<li><a <%=active%> href="<%=request.getContextPath() %>/blog?page=<%=i%>" title="" class="current-page"><%=i%></a></li>
				<%
				}
				%>
				</ul>
				</nav>
				<nav class="pagination-next-prev">
				<ul>
				<%
				if(currentPage - 1 > 0)
				{
				%>
					<li><a href="<%=request.getContextPath() %>/blog?page=<%=currentPage - 1%>" class="prev">Previous</a></li>
				<%	
				}
				if(currentPage + 1 <= sumPage)
				{
				%>
					<li><a href="<%=request.getContextPath() %>/blog?page=<%=currentPage + 1%>" class="next">Next</a></li>
				<%	
				}
				%>
				</ul>
				</nav>		
			<%	
			}
			else if(request.getAttribute("sumPage") != null && request.getAttribute("search") != null)
			{
				String active = "";
				int sumPage = (Integer) request.getAttribute("sumPage");
				int currentPage = (Integer) request.getAttribute("currentPage");
				for(int i = 1 ; i <= sumPage ; i++)
				{
					if(currentPage == i)
					{
						active = "class = 'current'";
					}
					else
					{
						active = "";
					}
			%>
					<li><a <%=active%> href="<%=request.getContextPath() %>/SearchTT?search=<%= request.getAttribute("search") %>&page=<%=i%>" title="" class="current-page"><%=i%></a></li>
				<%
				}
				%>
				</ul>
				</nav>
				<nav class="pagination-next-prev">
				<ul>
				<%
				if(currentPage - 1 > 0)
				{
				%>
					<li><a href="<%=request.getContextPath() %>/SearchTT?search=<%=request.getAttribute("search")%>&page=<%=currentPage - 1%>" class="prev">Previous</a></li>
				<%	
				}
				if(currentPage + 1 <= sumPage)
				{
				%>
					<li><a href="<%=request.getContextPath() %>/SearchTT?search=<%=request.getAttribute("search")%>&page=<%=currentPage + 1%>" class="next">Next</a></li>
				<%	
				}
				%>
				</ul>
				</nav>		
			<%
			}
			%>
			</div>
			<div class="clearfix"></div>

		</div>

	<!-- Blog Posts / End -->


	<!-- Widgets -->
	<div class="col-md-4">
		<div class="sidebar right">

			<!-- Widget -->
			<div class="widget">
				<h3 class="margin-top-0 margin-bottom-25">Search Blog</h3>
				<form class="form-wrapper cf" action="${pageContext.request.contextPath}/SearchTT">
					<input type="text" name="search" placeholder="Search here..." required> 
					<button type="submit">Search</button>
				</form>
				<div class="clearfix"></div>
			</div>
			<!-- Widget / End -->

			<!-- Widget -->
			<div class="widget">
				<h3>Got any questions?</h3>
				<div class="info-box margin-bottom-10">
					<p>If you are having any questions, please feel free to ask.</p>
					<a href="contact.html" class="button fullwidth margin-top-20"><i class="fa fa-envelope-o"></i> Drop Us a Line</a>
				</div>
			</div>
			<!-- Widget / End -->


			<!-- Widget -->
			<div class="widget">

				<h3>Bài Viết Phổ Biến</h3>
				<ul class="widget-tabs">
				<%
				ArrayList<TinTuc> listPopular = (ArrayList<TinTuc>) request.getAttribute("listPopular");
				if(listPopular != null && listPopular.size() > 0)
				{
					for(TinTuc objTinTuc : listPopular)
					{
				%>
					<!-- Post #1 -->
					<li>
						<div class="widget-content">
								<div class="widget-thumb">

								<a href="<%= request.getContextPath() %>/blog-post?idTinTuc=<%= objTinTuc.getIdTinTuc() %>">
									<img src="<%= objTinTuc.getHinhAnh() %>" alt="">
								</a>

							</div>
							
							<div class="widget-text">
								<h5>
									<a href="<%= request.getContextPath() %>/blog-post?idTinTuc=<%= objTinTuc.getIdTinTuc() %>">
										<%= objTinTuc.getTieuDe() %>
									</a>
								</h5>
								<span><%= objTinTuc.getNgayDangTin() %></span>
							</div>
							<div class="clearfix"></div>
						</div>
					</li>
				<%		
					}
				}
				%>

				</ul>

			</div>
			<!-- Widget / End-->


			<!-- Widget -->
			<div class="widget">
				<h3 class="margin-top-0 margin-bottom-25">Social</h3>
				<ul class="social-icons rounded">
					<li><a class="facebook" href="#"><i class="icon-facebook"></i></a></li>
					<li><a class="twitter" href="#"><i class="icon-twitter"></i></a></li>
					<li><a class="gplus" href="#"><i class="icon-gplus"></i></a></li>
					<li><a class="linkedin" href="#"><i class="icon-linkedin"></i></a></li>
				</ul>

			</div>
			<!-- Widget / End-->

			<div class="clearfix"></div>
			<div class="margin-bottom-40"></div>
		</div>
	</div>
	</div>
	<!-- Sidebar / End -->


</div>
</div>


<!-- Footer
================================================== -->
<div class="margin-top-55"></div>

<div id="footer" class="sticky-footer">
	<!-- Main -->
	<div class="container">
		<div class="row">
			<div class="col-md-5 col-sm-6">
				<img class="footer-logo" src="<%=request.getContextPath()%>/templates/public/images/logo.png" alt="">
				<br><br>
				<p>Morbi convallis bibendum urna ut viverra. Maecenas quis consequat libero, a feugiat eros. Nunc ut lacinia tortor morbi ultricies laoreet ullamcorper phasellus semper.</p>
			</div>

			<div class="col-md-4 col-sm-6 ">
				<h4>Helpful Links</h4>
				<ul class="footer-links">
					<li><a href="#">Login</a></li>
					<li><a href="#">Sign Up</a></li>
					<li><a href="#">My Account</a></li>
					<li><a href="#">Add Property</a></li>
					<li><a href="#">Pricing</a></li>
					<li><a href="#">Privacy Policy</a></li>
				</ul>

				<ul class="footer-links">
					<li><a href="#">FAQ</a></li>
					<li><a href="#">Blog</a></li>
					<li><a href="#">Our Agents</a></li>
					<li><a href="#">How It Works</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
				<div class="clearfix"></div>
			</div>		

			<div class="col-md-3  col-sm-12">
				<h4>Contact Us</h4>
				<div class="text-widget">
					<span>12345 Little Lonsdale St, Melbourne</span> <br>
					Phone: <span>(123) 123-456 </span><br>
					E-Mail:<span> <a href="#"><span class="__cf_email__" data-cfemail="28474e4e414b4d684d50494558444d064b4745">[email&#160;protected]</span></a> </span><br>
				</div>

				<ul class="social-icons margin-top-20">
					<li><a class="facebook" href="#"><i class="icon-facebook"></i></a></li>
					<li><a class="twitter" href="#"><i class="icon-twitter"></i></a></li>
					<li><a class="gplus" href="#"><i class="icon-gplus"></i></a></li>
					<li><a class="vimeo" href="#"><i class="icon-vimeo"></i></a></li>
				</ul>

			</div>

		</div>
		
		<!-- Copyright -->
		<div class="row">
			<div class="col-md-12">
				<div class="copyrights">Â© 2016 Findeo. All Rights Reserved.</div>
			</div>
		</div>

	</div>

</div>
<!-- Footer / End -->


<!-- Back To Top Button -->
<div id="backtotop"><a href="#"></a></div>


<!-- Scripts
================================================== -->
<script style="display: none !important;">!function(e,t,r,n,c,a,l){function i(t,r){return r=e.createElement('div'),r.innerHTML='<a href="'+t.replace(/"/g,'&quot;')+'"></a>',r.childNodes[0].getAttribute('href')}function o(e,t,r,n){for(r='',n='0x'+e.substr(t,2)|0,t+=2;t<e.length;t+=2)r+=String.fromCharCode('0x'+e.substr(t,2)^n);return i(r)}try{for(c=e.getElementsByTagName('a'),l='/cdn-cgi/l/email-protection#',n=0;n<c.length;n++)try{(t=(a=c[n]).href.indexOf(l))>-1&&(a.href='mailto:'+o(a.href,t+l.length))}catch(e){}for(c=e.querySelectorAll('.__cf_email__'),n=0;n<c.length;n++)try{(a=c[n]).parentNode.replaceChild(e.createTextNode(o(a.getAttribute('data-cfemail'),0)),a)}catch(e){}}catch(e){}}(document);</script><script type="text/javascript" src="scripts/jquery-2.2.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/chosen.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/magnific-popup.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/owl.carousel.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/rangeSlider.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/sticky-kit.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/slick.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/masonry.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/jquery.jpanelmenu.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/tooltips.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/custom.js"></script>


<!-- Style Switcher
================================================== -->
<script src="<%=request.getContextPath()%>/templates/public/scripts/switcher.js"></script>

<div id="style-switcher">
	<h2>Color Switcher <a href="#"><i class="sl sl-icon-settings"></i></a></h2>
	
	<div>
		<ul class="colors" id="color1">
			<li><a href="#" class="blue" title="Blue"></a></li>
			<li><a href="#" class="green" title="Green"></a></li>
			<li><a href="#" class="orange" title="Orange"></a></li>
			<li><a href="#" class="navy" title="Navy"></a></li>
			<li><a href="#" class="yellow" title="Yellow"></a></li>
			<li><a href="#" class="peach" title="Peach"></a></li>
			<li><a href="#" class="beige" title="Beige"></a></li>
			<li><a href="#" class="purple" title="Purple"></a></li>
			<li><a href="#" class="celadon" title="Celadon"></a></li>
			<li><a href="#" class="pink" title="Pink"></a></li>
			<li><a href="#" class="red" title="Red"></a></li>
			<li><a href="#" class="brown" title="Brown"></a></li>
			<li><a href="#" class="cherry" title="Cherry"></a></li>
			<li><a href="#" class="cyan" title="Cyan"></a></li>
			<li><a href="#" class="gray" title="Gray"></a></li>
			<li><a href="#" class="olive" title="Olive"></a></li>
		</ul>
	</div>
		
</div>
<!-- Style Switcher / End -->


</div>
<!-- Wrapper / End -->


</body>

<!-- Mirrored from www.vasterad.com/themes/findeo/blog.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 10 Oct 2017 13:19:04 GMT -->
</html>