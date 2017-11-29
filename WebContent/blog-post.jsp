<%@page import="model.dao.TinTucDAO"%>
<%@page import="model.bean.TinTuc"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>

<!-- Mirrored from www.vasterad.com/themes/findeo/blog-post.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 10 Oct 2017 13:19:04 GMT -->
<%@page import="model.bean.TinTuc"%>
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
					<li><i class="fa fa-envelope"></i> <a href="#"><span class="__cf_email__" data-cfemail="19767f7f707a7c597c61787469757c377a7674">[email&#160;protected]</span></a></li>
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
					<a href="index-2.html"><img src="/public/images/logo.png" alt=""></a>
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


		<!-- Post Content -->
		<div class="col-md-8">


			<!-- Blog Post -->
				<%
				TinTuc objTinTuc = (TinTuc)request.getAttribute("objTinTuc");
				
				if(objTinTuc != null)
				{
				%>
					<div class="blog-post single-post">
				
						<!-- Img -->
						<img class="post-img" src="<%= objTinTuc.getHinhAnh() %>" alt="">

						<!-- Content -->
						<div class="post-content">
							<h3><%= objTinTuc.getTieuDe() %></h3>

							<ul class="post-meta">
								<li><%= objTinTuc.getNgayDangTin() %></li>
								<li><a href="#">5 Comments</a></li>
							</ul>

							<div class="post-quote">
								<span class="icon"></span>
								<blockquote>
									<%= objTinTuc.getQuote() %>	
								</blockquote>
							</div>

							<p><%= objTinTuc.getNoiDung() %></p>
				<%	
				}
				%>
				

							<!-- Share Buttons -->
							<ul class="share-buttons margin-top-40 margin-bottom-0">
								<li><a class="fb-share" href="#"><i class="fa fa-facebook"></i> Share</a></li>
								<li><a class="twitter-share" href="#"><i class="fa fa-twitter"></i> Tweet</a></li>
								<li><a class="gplus-share" href="#"><i class="fa fa-google-plus"></i> Share</a></li>
								<li><a class="pinterest-share" href="#"><i class="fa fa-pinterest-p"></i> Pin</a></li>
							</ul>
							<div class="clearfix"></div>

						</div>
					</div>
			
			<!-- Blog Post / End -->


			<!-- Post Navigation -->
			<ul id="posts-nav" class="margin-top-0 margin-bottom-40">
				<li class="next-post">
					<a href="#"><span>Next Post</span>
					Tips For Newbie Hitchhiker</a>
				</li>
				<li class="prev-post">
					<a href="#"><span>Previous Post</span>
					What's So Great About Merry?</a>
				</li>
			</ul>


			<!-- About Author -->
			<div class="about-author">
				<img src="/public/images/agent-avatar.jpg" alt="" />
				<div class="about-description">
					<h4>Jennie Wilson</h4>
					<a href="#"><span class="__cf_email__" data-cfemail="d7bdb2b9b9beb297b2afb6baa7bbb2f9b4b8ba">[email&#160;protected]</span></a>
					<p>Nullam ultricies, velit ut varius molestie, ante metus condimentum nisi, dignissim facilisis turpis ex in libero. Sed porta ante tortor, a pulvinar mi facilisis nec. Proin finibus dolor ac convallis congue.</p>
				</div>
			</div>


			<!-- new Posts -->
			<div class="clearfix"></div>
			<h4 class="headline margin-top-25">Bài Đăng Mới</h4>
			<div class="row">
			<%
			ArrayList<TinTuc> listNewItems = (ArrayList<TinTuc>)request.getAttribute("listNewItems");
			if (listNewItems != null && listNewItems.size() > 0)
			{
				for(TinTuc obj : listNewItems)
				{
			%>
					<div class="col-md-6">
					<!-- Blog Post -->
					<div class="blog-post">
						
						<!-- Img -->
						<a href="${pageContext.request.contextPath}/ShowChiTietTinTuc?idTinTuc=<%= obj.getIdTinTuc() %>" class="post-img">
							<img src="<%= obj.getHinhAnh() %>" alt="">
						</a>
						
						<!-- Content -->
						<div class="post-content">
							<h3><a href="${pageContext.request.contextPath}/ShowChiTietTinTuc?idTinTuc=<%= obj.getIdTinTuc() %>"><%= obj.getTieuDe() %></a></h3>
							<p><%= obj.getQuote() + "..." %></p>

							<a href="${pageContext.request.contextPath}/ShowChiTietTinTuc?idTinTuc=<%= obj.getIdTinTuc() %>" class="read-more">Read More <i class="fa fa-angle-right"></i></a>
						</div>

					</div>
					<!-- Blog Post / End -->
					</div>
			<%		
				}
			}
			%>
				
			</div>
			<!-- Related Posts / End -->


			<div class="margin-top-50"></div>

			<!-- Reviews -->
			<section class="comments">
			<h4 class="headline margin-bottom-35">Comments <span class="comments-amount">(5)</span></h4>

				<ul>
					<li>
						<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>
						<div class="comment-content"><div class="arrow-comment"></div>
							<div class="comment-by">Kathy Brown<span class="date">12th, June 2015</span>
								<a href="#" class="reply"><i class="fa fa-reply"></i> Reply</a>
							</div>
							<p>Morbi velit eros, sagittis in facilisis non, rhoncus et erat. Nam posuere tristique sem, eu ultricies tortor imperdiet vitae. Curabitur lacinia neque non metus</p>
						</div>

						<ul>
							<li>
								<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>
								<div class="comment-content"><div class="arrow-comment"></div>
									<div class="comment-by">Tom Smith<span class="date">12th, June 2015</span>
										<a href="#" class="reply"><i class="fa fa-reply"></i> Reply</a>
									</div>
									<p>Rrhoncus et erat. Nam posuere tristique sem, eu ultricies tortor imperdiet vitae. Curabitur lacinia neque.</p>
								</div>
							</li>
							<li>
								<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>
								<div class="comment-content"><div class="arrow-comment"></div>
									<div class="comment-by">Kathy Brown<span class="date">12th, June 2015</span>
										<a href="#" class="reply"><i class="fa fa-reply"></i> Reply</a>
									</div>
									<p>Nam posuere tristique sem, eu ultricies tortor.</p>
								</div>

								<ul>
									<li>
										<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /></div>
										<div class="comment-content"><div class="arrow-comment"></div>
											<div class="comment-by">John Doe<span class="date">12th, June 2015</span>
												<a href="#" class="reply"><i class="fa fa-reply"></i> Reply</a>
											</div>
											<p>Great template!</p>
										</div>
									</li>
								</ul>

							</li>
						</ul>

					</li>

					<li>
						<div class="avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="" /> </div>
						<div class="comment-content"><div class="arrow-comment"></div>
							<div class="comment-by">John Doe<span class="date">15th, May 2015</span>
								<a href="#" class="reply"><i class="fa fa-reply"></i> Reply</a>
							</div>
							<p>Commodo est luctus eget. Proin in nunc laoreet justo volutpat blandit enim. Sem felis, ullamcorper vel aliquam non, varius eget justo. Duis quis nunc tellus sollicitudin mauris.</p>
						</div>

					</li>
				 </ul>

			</section>
			<div class="clearfix"></div>
			<div class="margin-top-55"></div>


			<!-- Add Comment -->
			<h4 class="headline">Add Comment</h4>
			<div class="margin-top-15"></div>
			
			<!-- Add Comment Form -->
			<form id="add-comment" class="add-comment">
				<fieldset>

					<div>
						<label>Name:</label>
						<input type="text" value=""/>
					</div>
						
					<div>
						<label>Email: <span>*</span></label>
						<input type="text" value=""/>
					</div>

					<div>
						<label>Comment: <span>*</span></label>
						<textarea cols="40" rows="3"></textarea>
					</div>

				</fieldset>

				<a href="#" class="button">Add Comment</a>
				<div class="clearfix"></div>
				<div class="margin-bottom-20"></div>

			</form>

	</div>
	<!-- Content / End -->



	<!-- Sidebar
	================================================== -->

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

				<h3>Bài Đăng Liên Quan</h3>
				<ul class="widget-tabs">
				
				<%
				ArrayList<TinTuc> listRelatedItems = (ArrayList<TinTuc>)request.getAttribute("listRelatedItems");
				if(listRelatedItems != null && listRelatedItems.size() > 0)
				{
					for(TinTuc obj : listRelatedItems)
					{
				%>
						<!-- Post #1 -->
						<li>
						<div class="widget-content">
							<div class="widget-thumb">
								<a href="${pageContext.request.contextPath}/ShowChiTietTinTuc?idTinTuc=<%= obj.getIdTinTuc() %>"><img src="<%= obj.getHinhAnh() %>" alt=""></a>
							</div>
							
							<div class="widget-text">
								<h5><a href="${pageContext.request.contextPath}/ShowChiTietTinTuc?idTinTuc=<%= obj.getIdTinTuc() %>"><%= obj.getTieuDe() %></a></h5>
								<span><%= obj.getNgayDangTin() %></span>
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
				<img class="footer-logo" src="/public/images/logo.png" alt="">
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
					E-Mail:<span> <a href="#"><span class="__cf_email__" data-cfemail="234c45454a404663465b424e534f460d404c4e">[email&#160;protected]</span></a> </span><br>
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
<script type="text/javascript" src="scripts/chosen.min.js"></script>
<script type="text/javascript" src="scripts/magnific-popup.min.js"></script>
<script type="text/javascript" src="scripts/owl.carousel.min.js"></script>
<script type="text/javascript" src="scripts/rangeSlider.js"></script>
<script type="text/javascript" src="scripts/sticky-kit.min.js"></script>
<script type="text/javascript" src="scripts/slick.min.js"></script>
<script type="text/javascript" src="scripts/masonry.min.js"></script>
<script type="text/javascript" src="scripts/jquery.jpanelmenu.js"></script>
<script type="text/javascript" src="scripts/tooltips.min.js"></script>
<script type="text/javascript" src="scripts/custom.js"></script>


<!-- Style Switcher
================================================== -->
<script src="scripts/switcher.js"></script>

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

<!-- Mirrored from www.vasterad.com/themes/findeo/blog-post.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 10 Oct 2017 13:19:04 GMT -->
</html>