<!DOCTYPE html>

<!-- Mirrored from www.vasterad.com/themes/findeo/single-property-page-2.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 10 Oct 2017 13:18:51 GMT -->
<%@page import="model.bean.Image"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.CanHo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
					<li><i class="fa fa-envelope"></i> <a href="#"><span class="__cf_email__" data-cfemail="deb1b8b8b7bdbb9ebba6bfb3aeb2bbf0bdb1b3">[email&#160;protected]</span></a></li>
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
										<li><a href="listings-list-with-sidebar.jsp">With Sidebar</a></li>
										<li><a href="listings-list-with-map.jsp">With Map</a></li>
										<li><a href="listings-list-full-width.jsp">Full Width</a></li>
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

						<li><a class="current" href="#">Features</a>
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

						<li><a href="#">Pages</a>
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

<%
CanHo objCanHo = (CanHo)request.getAttribute("objCanHo");
if(objCanHo != null)
{
%>

<!-- Titlebar
================================================== -->
<div id="titlebar" class="property-titlebar margin-bottom-0">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				
				<a href="listings-list-with-sidebar.html" class="back-to-listings"></a>
				<div class="property-title">
					<h2><%= objCanHo.getTen() + " " + objCanHo.getTentheloai() %><span class="property-badge">For Sale</span></h2>
					<span>
						<a href="#location" class="listing-address">
							<i class="fa fa-map-marker"></i>
							<%= objCanHo.getDiachi() %>
						</a>
					</span>
				</div>

				<div class="property-pricing">
					<div><%= objCanHo.getGiatien() + " $" %></div>
					<div class="sub-price">$<%= objCanHo.getGiatien() / objCanHo.getDientich() %> / sq ft</div>
				</div>


			</div>
		</div>
	</div>
</div>


<!-- Content
================================================== -->
<div class="container">
	<div class="row margin-bottom-50">
		<div class="col-md-12">
		
			<!-- Slider Container -->
			<div class="property-slider-container">

				<!-- Agent Widget -->
				<div class="agent-widget">
					<div class="agent-title">
						<div class="agent-photo"><img src="<%=request.getContextPath()%>/templates/public/images/agent-avatar.jpg" alt="" /></div>
						<div class="agent-details">
							<h4><a href="#"><%= objCanHo.getTennhanvien() %></a></h4>
							<span><i class="sl sl-icon-call-in"></i>(123) 123-456</span>
						</div>
						<div class="clearfix"></div>
					</div>

					<!--<input type="text" placeholder="Your Email" pattern="^[A-Za-z0-9](([_\.\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\.\-]?[a-zA-Z0-9]+)*)\.([A-Za-z]{2,})$">
					<input type="text" placeholder="Your Phone">
					<textarea>I'm interested in this property [ID 123456] and I'd like to know more details.</textarea>
					-->
					<button class="button fullwidth margin-top-5">Đăng Ký Mua</button>
				</div>
				<!-- Agent Widget / End -->

				<%
				ArrayList<Image> listImage = (ArrayList<Image>) request.getAttribute("listImage");
				if(listImage != null && listImage.size() > 0)
				{
					for(Image objImage : listImage)
					{
				%>
				<!-- Slider -->
				<div class="property-slider no-arrows">
					<a href="<%= objImage.getHinhAnh() %>" data-background-image="<%= objImage.getHinhAnh() %>" class="item mfp-gallery"></a>
				</div>
				<!-- Slider / End -->

			</div>
			<!-- Slider Container / End -->

			<!-- Slider Thumbs -->
			<div class="property-slider-nav">
				<div class="item"><img src="<%= objImage.getHinhAnh() %>" alt=""></div>
			</div>
				<%
					}
				}
				%>

		</div>
	</div>
</div>


<div class="container">
	<div class="row">

		<!-- Property Description -->
		<div class="col-lg-8 col-md-7">
			<div class="property-description">

				<!-- Main Features -->
				<ul class="property-main-features">
					<li>Area <span><%= objCanHo.getTenkhuvuc() %></span></li>
					<li>Rooms <span><%= objCanHo.getSophong() %></span></li>
					<li>Bedrooms <span><%= objCanHo.getSophongngu() %></span></li>
					<li>Bathrooms <span><%= objCanHo.getSophongtam() %></span></li>
				</ul>


				<!-- Description -->
				<h3 class="desc-headline">Description</h3>
				<div class="show-more">
					<%= objCanHo.getMota() %>
					<a href="#" class="show-more-button">Show More <i class="fa fa-angle-down"></i></a>
				</div>

				<!-- Details -->
				<h3 class="desc-headline">Details</h3>
				<ul class="property-features margin-top-0">
					<li>Building Age: <span><%= objCanHo.getTuoi() %></span></li>
					<li>Parking: <span><%= objCanHo.getParking() %></span></li>
					<li>Cooling: <span><%= objCanHo.getCooling() %></span></li>
					<li>Heating: <span><%= objCanHo.getHeating() %></span></li>
					<li>Sewer: <span><%= objCanHo.getSewer() %></span></li>
					<li>Water: <span><%= objCanHo.getWater() %></span></li>
					<li>Exercise Room: <span><%= objCanHo.getPhongtap() %></span></li>
					<li>Storage Room: <span><%= objCanHo.getNhakho() %></span></li>
				</ul>


				<!-- Features -->
				<h3 class="desc-headline">Features</h3>
				<ul class="property-features checkboxes margin-top-0">
					<li>Air Conditioning</li>
					<li>Swimming Pool</li>
					<li>Central Heating</li>
					<li>Laundry Room</li>
					<li>Gym</li>
					<li>Alarm</li>
					<li>Window Covering</li>
					<li>Internet</li>
				</ul>


				<!-- Location -->
				<h3 class="desc-headline no-border" id="location">Location</h3>
				<div id="propertyMap-container">
					<div id="propertyMap" data-latitude="40.7427837" data-longitude="73.11445617675781"></div>
					<a href="#" id="streetView">Street View</a>
				</div>


				<!-- Similar Listings Container -->
				<h3 class="desc-headline no-border margin-bottom-35 margin-top-60">Similar Properties</h3>

				<!-- Layout Switcher -->

				<div class="layout-switcher hidden"><a href="#" class="list"><i class="fa fa-th-list"></i></a></div>
				<div class="listings-container list-layout">
				
				<%
				ArrayList<CanHo> listSimilar = (ArrayList<CanHo>) request.getAttribute("listSimilar");
				if(listSimilar != null)
				{
					for(CanHo objSimilar : listSimilar)
					{
				%>

					<!-- Listing Item -->
					<div class="listing-item">

						<a href="<%=request.getContextPath()%>/chitietcanho?canho=<%= objSimilar.getId() %>" class="listing-img-container">

							<div class="listing-badges">
								<span>For Rent</span>
							</div>

							<div class="listing-img-content">
								<span class="listing-price">$<%= objSimilar.getGiatien() %> <i>monthly</i></span>
								<span class="like-icon"></span>
							</div>

							<img src="<%=request.getContextPath()%>/templates/public/images/listing-03.jpg" alt="">

						</a>
						
						<div class="listing-content">

							<div class="listing-title">
								<h4><a href="<%=request.getContextPath()%>/chitietcanho?canho=<%= objSimilar.getId() %>"><%= objSimilar.getTen() %></a></h4>
								<a href="https://maps.google.com/maps?q=221B+Baker+Street,+London,+United+Kingdom&amp;hl=en&amp;t=v&amp;hnear=221B+Baker+St,+London+NW1+6XE,+United+Kingdom" class="listing-address popup-gmaps">
									<i class="fa fa-map-marker"></i>
									<%= objSimilar.getDiachi() %>
								</a>

								<a href="<%=request.getContextPath()%>/chitietcanho?canho=<%= objSimilar.getId() %>" class="details button border">Details</a>
							</div>

							<ul class="listing-details">
								<li>$<%= objSimilar.getGiatien() / objSimilar.getDientich() %> sq ft</li>
								<li><%= objSimilar.getSophongngu() %> Bedroom</li>
								<li><%= objSimilar.getSophongtam() %> Rooms</li>
								<li><%= objSimilar.getNhakho() %> Rooms</li>
							</ul>

							<div class="listing-footer">
								<a href="#"><i class="fa fa-user"></i><%= objSimilar.getTennhanvien() %></a>
								<span><i class="fa fa-calendar-o"></i>4 days ago</span>
							</div>

						</div>
						<!-- Listing Item / End -->

					</div>
					<!-- Listing Item / End -->
					
				<%		
					}
				}
				%>	
					

				</div>
				<!-- Similar Listings Container / End -->

			</div>
		</div>
		<!-- Property Description / End -->


		<!-- Sidebar -->
		<div class="col-lg-4 col-md-5">
			<div class="sidebar sticky right">

				<!-- Widget -->
				<div class="widget margin-bottom-35">
					<button class="widget-button"><i class="sl sl-icon-printer"></i> Print</button>
					<button class="widget-button save" data-save-title="Save" data-saved-title="Saved"><span class="like-icon"></span></button>
				</div>
				<!-- Widget / End -->


				<!-- Widget -->
				<div class="widget">
					<h3 class="margin-bottom-35">Bất Động Sản Đặc Sắc</h3>
					<div class="listing-carousel outer">
					
					<%
					ArrayList<CanHo> listFeaturead = (ArrayList<CanHo>) request.getAttribute("listFeaturead");
					if(listFeaturead != null)
					{
						for(CanHo objFeaturead : listFeaturead)
						{
					%>
				
						<!-- Item -->
						<div class="item">
							<div class="listing-item compact">

								<a href="#" class="listing-img-container">

									<div class="listing-badges">
										<span class="featured">Đặc Sắc</span>
										<span>For Sale</span>
									</div>

									<div class="listing-img-content">
									<span class="listing-compact-title"><%= objFeaturead.getTen() + " " + objFeaturead.getTentheloai() %><i><%= objFeaturead.getGiatien() %></i></span>
										<ul class="listing-hidden-content">
											<li>Area <span><%= objFeaturead.getTenkhuvuc() %></span></li>
											<li>Rooms <span><%= objFeaturead.getSophong() %></span></li>
											<li>Beds <span><%= objFeaturead.getSophongngu() %></span></li>
											<li>Baths <span><%= objFeaturead.getSophongtam() %></span></li>
										</ul>
									</div>

									<img src="<%=request.getContextPath()%>/templates/public/images/listing-01.jpg" alt="">
								</a>

							</div>
						</div>
						<!-- Item / End -->
					
					<%		
						}
					}
					%>
					</div>

				</div>
				<!-- Widget / End -->

				<!-- Widget -->
				<div class="widget margin-bottom-40">
					<h3 class="margin-top-0 margin-bottom-35">Find New Home</h3>
					<form action="${pageContext.request.contextPath}/SearchBDS" method="post">
					<!-- Row -->
					<div class="row with-forms">
						<!-- Status -->
						<div class="col-md-12">
							<select data-placeholder="Any Status" class="chosen-select-no-single" name="status">
								<option>Any</option>	
								<option>For Sale</option>
								<option>For Rent</option>
							</select>
						</div>
					</div>
					<!-- Row / End -->


					<!-- Row -->
					<div class="row with-forms">
						<!-- Type -->
						<div class="col-md-12">
							<select data-placeholder="Any Type" class="chosen-select-no-single" name="typeBDS">
								<option>Any</option>	
								<option>Apartments</option>
								<option>Houses</option>
								<option>Commercial</option>
								<option>Garages</option>
								<option>Lots</option>
							</select>
						</div>
					</div>
					<!-- Row / End -->

					<!-- Row -->
					<div class="row with-forms">
						<!-- Cities -->
						<div class="col-md-12">
							<select data-placeholder="All Cities" class="chosen-select" name="khuvuc">
								<option>Any</option>
								<option>New York</option>
								<option>Los Angeles</option>
								<option>Chicago</option>
								<option>Brooklyn</option>
								<option>Queens</option>
								<option>Houston</option>
								<option>Manhattan</option>
								<option>Philadelphia</option>
								<option>Phoenix</option>
								<option>San Antonio</option>
								<option>Bronx</option>
								<option>San Diego</option>
								<option>Dallas</option>
								<option>San Jose</option>
							</select>
						</div>
					</div>
					<!-- Row / End -->


					<!-- Row -->
					<div class="row with-forms">
					
						<!-- Min Area -->
						<div class="col-md-6">
							<select data-placeholder="Beds" class="chosen-select-no-single" name="beds" >
								<option label="blank"></option>	
								<option>Any</option>	
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>

						<!-- Max Area -->
						<div class="col-md-6">
							<select data-placeholder="Baths" class="chosen-select-no-single" name="baths">
								<option label="blank"></option>	
								<option>Any</option>	
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>

					</div>
					<!-- Row / End -->

					<br>

					<!-- Area Range -->
					<div class="range-slider">
						<label>Area Range</label>
						<div id="area-range" data-min="0" data-max="1500" data-unit="sq ft"></div>
						<div class="clearfix"></div>
					</div>

					<br>
					
					<!-- Price Range -->
					<div class="range-slider">
						<label>Price Range</label>
						<div id="price-range" data-min="0" data-max="400000" data-unit="$"></div>
						<div class="clearfix"></div>
					</div>



					<!-- More Search Options -->
					<a href="#" class="more-search-options-trigger margin-bottom-10 margin-top-30" data-open-title="Additional Features" data-close-title="Additional Features"></a>
					
					<div class="more-search-options relative">

						<!-- Checkboxes -->
						<div class="checkboxes one-in-row margin-bottom-10">
					
							<input id="check-2" type="checkbox" name="check" value="Air Conditioning">
							<label for="check-2">Air Conditioning</label>

							<input id="check-3" type="checkbox" name="check" value="Swimming Pool">
							<label for="check-3">Swimming Pool</label>

							<input id="check-4" type="checkbox" name="check" value="Central Heating">
							<label for="check-4">Central Heating</label>

							<input id="check-5" type="checkbox" name="check">
							<label for="check-5">Laundry Room</label>	


							<input id="check-6" type="checkbox" name="check">
							<label for="check-6">Gym</label>

							<input id="check-7" type="checkbox" name="check">
							<label for="check-7">Alarm</label>

							<input id="check-8" type="checkbox" name="check">
							<label for="check-8">Window Covering</label>
					
						</div>
						<!-- Checkboxes / End -->

					</div>
					<!-- More Search Options / End -->
					
					<button type="submit" class="button fullwidth margin-top-30" name="search">Search</button>
					</form>


				</div>
				<!-- Widget / End -->

			</div>
		</div>
		<!-- Sidebar / End -->

	</div>
</div>

<%	
}
%>

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
					E-Mail:<span> <a href="#"><span class="__cf_email__" data-cfemail="345b52525d575174514c55594458511a575b59">[email&#160;protected]</span></a> </span><br>
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
<script style="display: none !important;">!function(e,t,r,n,c,a,l){function i(t,r){return r=e.createElement('div'),r.innerHTML='<a href="'+t.replace(/"/g,'&quot;')+'"></a>',r.childNodes[0].getAttribute('href')}function o(e,t,r,n){for(r='',n='0x'+e.substr(t,2)|0,t+=2;t<e.length;t+=2)r+=String.fromCharCode('0x'+e.substr(t,2)^n);return i(r)}try{for(c=e.getElementsByTagName('a'),l='/cdn-cgi/l/email-protection#',n=0;n<c.length;n++)try{(t=(a=c[n]).href.indexOf(l))>-1&&(a.href='mailto:'+o(a.href,t+l.length))}catch(e){}for(c=e.querySelectorAll('.__cf_email__'),n=0;n<c.length;n++)try{(a=c[n]).parentNode.replaceChild(e.createTextNode(o(a.getAttribute('data-cfemail'),0)),a)}catch(e){}}catch(e){}}(document);</script><script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/jquery-2.2.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/chosen.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/magnific-popup.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/owl.carousel.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/rangeSlider.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/sticky-kit.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/slick.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/jquery.jpanelmenu.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/tooltips.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/masonry.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/custom.js"></script>

<!-- Maps -->
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/infobox.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/markerclusterer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/scripts/maps.js"></script>


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

<!-- Mirrored from www.vasterad.com/themes/findeo/single-property-page-2.html by HTTrack Website Copier/3.x [XR&CO'2014], Tue, 10 Oct 2017 13:18:51 GMT -->
</html>