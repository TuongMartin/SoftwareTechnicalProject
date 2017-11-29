<%
CanHo objCanHo = (CanHo)request.getAttribute("objCanHo");
if(objCanHo != null)
{
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="model.bean.TienIch"%>
<%@page import="model.bean.Image"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.CanHo"%>
<%@include file="/templates/public/inc/header.jsp"%>

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
					<a href="<%=request.getContextPath() %>/files/<%= objImage.getHinhAnh() %>" data-background-image="<%=request.getContextPath() %>/files/<%= objImage.getHinhAnh() %>" class="item mfp-gallery"></a>
				</div>
				<!-- Slider / End -->

			</div>
			<!-- Slider Container / End -->

			<!-- Slider Thumbs -->
			<div class="property-slider-nav">
				<div class="item"><img src="<%=request.getContextPath() %>/files/<%= objImage.getHinhAnh() %>" alt=""></div>
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
				<%
				ArrayList<TienIch> listTienIch = (ArrayList<TienIch>) request.getAttribute("listTienIch");
				if(listTienIch != null)
				{
					for(TienIch obj : listTienIch)
					{
				%>
				<li><%= obj.getTenTienIch() %></li>
				<%		
					}
				}
				%>
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
				ArrayList<Image> listImageOfListSimilar = (ArrayList<Image>) request.getAttribute("listImageOfListSimilar");
				if(listSimilar != null)
				{
					for(CanHo objSimilar : listSimilar)
					{
						//asdasdasdasdasdasdasdasdasdasdasd
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
							
							<%
							if(listImageOfListSimilar != null)
							{
								for(Image obj : listImageOfListSimilar)
								{
									if(obj.getIdCanHo() == objSimilar.getId())
									{
							%>
							<img src="<%=request.getContextPath() %>/files/<%= obj.getHinhAnh() %>" alt="">
							<%		
									}
								}
							}
							%>
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
					ArrayList<Image> listImageOfListFeaturead = (ArrayList<Image>) request.getAttribute("listImageOfListFeaturead");
					
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

									<%
							if(listImageOfListFeaturead != null)
							{
								for(Image obj : listImageOfListFeaturead)
								{
									if(obj.getIdCanHo() == objFeaturead.getId())
									{
							%>
							<img src="<%=request.getContextPath() %>/files/<%= obj.getHinhAnh() %>" alt="">
							<%		
									}
								}
							}
							%>
									
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

<%@include file="/templates/public/inc/footer.jsp"%>
