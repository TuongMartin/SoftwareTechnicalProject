<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp"%>

<!-- Map
================================================== -->
<div id="map-container" class="homepage-map margin-bottom-0">

    <div id="map">
        <!-- map goes here -->
    </div>

    <!-- Map Navigation -->
	<a href="#" id="scrollEnabling" title="Enable or disable scrolling on map">Enable Scrolling</a>
	<ul id="mapnav-buttons">
	    <li><a href="#" id="prevpoint" title="Previous point on map">Prev</a></li>
	    <li><a href="#" id="nextpoint" title="Next point on mp">Next</a></li>
	</ul>


	<!-- Main Search Container -->
	<div class="main-search-container">

		<div class="container">
			<div class="row">
				<div class="col-md-12">
					
					<!-- Trigger Button -->
					<a href="#" class="adv-search-btn button">Advanced Search <i class="fa fa-caret-up"></i></a>

					<!-- Main Search -->
					<form class="main-search-form">
						
						<!-- Type -->
						<div class="search-type" style="display: none;">
							<label class="active"><input class="first-tab" name="tab" checked="checked" type="radio">Any Status</label>
							<label><input name="tab" type="radio">For Sale</label>
							<label><input name="tab" type="radio">For Rent</label>
							<div class="search-type-arrow"></div>
						</div>

						
						<!-- Box -->
						<div class="main-search-box">
							
						<!-- Row With Forms -->
							<div class="row with-forms">

								<!-- Status -->
								<div class="col-md-3 col-sm-6">
									<select data-placeholder="Any Status" class="chosen-select-no-single" >
										<option>Any Status</option>	
										<option>For Sale</option>
										<option>For Rent</option>
									</select>
								</div>

								<!-- Property Type -->
								<div class="col-md-3 col-sm-6">
									<select data-placeholder="Any Type" class="chosen-select-no-single" >
										<option>Any Type</option>	
										<option>Apartments</option>
										<option>Houses</option>
										<option>Commercial</option>
										<option>Garages</option>
										<option>Lots</option>
									</select>
								</div>

								<!-- Main Search Input -->
								<div class="col-md-6">
									<div class="main-search-input">
										<input type="text" placeholder="Enter address e.g. street, city or state" value=""/>
										<button class="button">Search</button>
									</div>
								</div>

							</div>
							<!-- Row With Forms / End -->


							<!-- Row With Forms -->
							<div class="row with-forms">

								<!-- Min Price -->
								<div class="col-md-3 col-sm-6">
									
									<!-- Select Input -->
									<div class="select-input disabled-first-option">
										<input type="text" placeholder="Min Area" data-unit="Sq Ft">
										<select>	
											<option>Min Area</option>
											<option>300</option>
											<option>400</option>
											<option>500</option>
											<option>700</option>
											<option>800</option>
											<option>1000</option>
											<option>1500</option>
										</select>
									</div>
									<!-- Select Input / End -->

								</div>

								<!-- Max Price -->
								<div class="col-md-3 col-sm-6">
									
									<!-- Select Input -->
									<div class="select-input disabled-first-option">
										<input type="text" placeholder="Max Area" data-unit="Sq Ft">
										<select>	
											<option>Max Area</option>
											<option>300</option>
											<option>400</option>
											<option>500</option>
											<option>700</option>
											<option>800</option>
											<option>1000</option>
											<option>1500</option>
										</select>
									</div>
									<!-- Select Input / End -->

								</div>


								<!-- Min Price -->
								<div class="col-md-3 col-sm-6">
									
									<!-- Select Input -->
									<div class="select-input disabled-first-option">
										<input type="text" placeholder="Min Price" data-unit="USD">
										<select>		
											<option>Min Price</option>
											<option>1 000</option>
											<option>2 000</option>	
											<option>3 000</option>	
											<option>4 000</option>	
											<option>5 000</option>	
											<option>10 000</option>	
											<option>15 000</option>	
											<option>20 000</option>	
											<option>30 000</option>
											<option>40 000</option>
											<option>50 000</option>
											<option>60 000</option>
											<option>70 000</option>
											<option>80 000</option>
											<option>90 000</option>
											<option>100 000</option>
											<option>110 000</option>
											<option>120 000</option>
											<option>130 000</option>
											<option>140 000</option>
											<option>150 000</option>
										</select>
									</div>
									<!-- Select Input / End -->

								</div>


								<!-- Max Price -->
								<div class="col-md-3 col-sm-6">
									
									<!-- Select Input -->
									<div class="select-input disabled-first-option">
										<input type="text" placeholder="Max Price" data-unit="USD">
										<select>		
											<option>Max Price</option>
											<option>1 000</option>
											<option>2 000</option>	
											<option>3 000</option>	
											<option>4 000</option>	
											<option>5 000</option>	
											<option>10 000</option>	
											<option>15 000</option>	
											<option>20 000</option>	
											<option>30 000</option>
											<option>40 000</option>
											<option>50 000</option>
											<option>60 000</option>
											<option>70 000</option>
											<option>80 000</option>
											<option>90 000</option>
											<option>100 000</option>
											<option>110 000</option>
											<option>120 000</option>
											<option>130 000</option>
											<option>140 000</option>
											<option>150 000</option>
										</select>
									</div>
									<!-- Select Input / End -->

								</div>

							</div>
							<!-- Row With Forms / End -->

						</div>
						<!-- Box / End -->

					</form>
					<!-- Main Search -->

				</div>
			</div>
		</div>
	</div>
	<!-- Main Search Container / End -->

</div>

		
<!-- Content
================================================== -->
<div class="container">
	<div class="row">
	
		<div class="col-md-12">
			<h3 class="headline margin-bottom-25 margin-top-60">For Sale</h3>
		</div>
		
		<!-- Carousel -->
		<div class="col-md-12">
			<div class="carousel">
				
				<!-- Listing Item -->
					<div class="carousel-item">
					<div class="listing-item">

						<a href="single-property-page-1.html" class="listing-img-container">

							<div class="listing-badges">
								<span class="featured">Featured</span>
								<span>For Sale</span>
							</div>

							<div class="listing-img-content">
								<span class="listing-price">$275,000 <i>$520 / sq ft</i></span>
								<span class="like-icon tooltip"></span>
							</div>

							<div class="listing-carousel">
								<div><img src="<%=request.getContextPath()%>/templates/public/images/listing-01.jpg" alt=""></div>
								<div><img src="<%=request.getContextPath()%>/templates/public/images/listing-01b.jpg" alt=""></div>
								<div><img src="<%=request.getContextPath()%>/templates/public/images/listing-01c.jpg" alt=""></div>
							</div>

						</a>
						
						<div class="listing-content">

							<div class="listing-title">
								<h4><a href="single-property-page-1.html">Eagle Apartments</a></h4>
								<a href="https://maps.google.com/maps?q=221B+Baker+Street,+London,+United+Kingdom&amp;hl=en&amp;t=v&amp;hnear=221B+Baker+St,+London+NW1+6XE,+United+Kingdom" class="listing-address popup-gmaps">
									<i class="fa fa-map-marker"></i>
									9364 School St. Lynchburg, NY
								</a>
							</div>

							<ul class="listing-features">
								<li>Area <span>530 sq ft</span></li>
								<li>Bedrooms <span>2</span></li>
								<li>Bathrooms <span>1</span></li>
							</ul>

							<div class="listing-footer">
								<a href="#"><i class="fa fa-user"></i> David Strozier</a>
								<span><i class="fa fa-calendar-o"></i> 1 day ago</span>
							</div>

						</div>

					</div>
				</div>
				<!-- Listing Item / End -->


				<!-- Listing Item -->
				<div class="carousel-item">
					<div class="listing-item">

						<a href="single-property-page-2.html" class="listing-img-container">

							<div class="listing-badges">
								<span>For Rent</span>
							</div>

							<div class="listing-img-content">
								<span class="listing-price">$900 <i>monthly</i></span>
								<span class="like-icon"></span>
							</div>

							<img src="<%=request.getContextPath()%>/templates/public/images/listing-02.jpg" alt="">

						</a>
						
						<div class="listing-content">

							<div class="listing-title">
								<h4><a href="single-property-page-2.html">Serene Uptown</a></h4>
								<a href="https://maps.google.com/maps?q=221B+Baker+Street,+London,+United+Kingdom&amp;hl=en&amp;t=v&amp;hnear=221B+Baker+St,+London+NW1+6XE,+United+Kingdom" class="listing-address popup-gmaps">
									<i class="fa fa-map-marker"></i>
									6 Bishop Ave. Perkasie, PA
								</a>
							</div>

							<ul class="listing-features">
								<li>Area <span>440 sq ft</span></li>
								<li>Bedrooms <span>2</span></li>
								<li>Bathrooms <span>1</span></li>
							</ul>

							<div class="listing-footer">
								<a href="#"><i class="fa fa-user"></i> Harriette Clark</a>
								<span><i class="fa fa-calendar-o"></i> 2 days ago</span>
							</div>

						</div>

					</div>
				</div>
				<!-- Listing Item / End -->


				<!-- Listing Item -->
				<div class="carousel-item">
					<div class="listing-item">


						<a href="single-property-page-1.html" class="listing-img-container">

							<div class="listing-badges">
								<span class="featured">Featured</span>
								<span>For Rent</span>
							</div>

							<div class="listing-img-content">
								<span class="listing-price">$1700 <i>monthly</i></span>
								<span class="like-icon"></span>
							</div>

							<img src="<%=request.getContextPath()%>/templates/public/images/listing-03.jpg" alt="">

						</a>
						
						<div class="listing-content">

							<div class="listing-title">
								<h4><a href="single-property-page-1.html">Meridian Villas</a></h4>
								<a href="https://maps.google.com/maps?q=221B+Baker+Street,+London,+United+Kingdom&amp;hl=en&amp;t=v&amp;hnear=221B+Baker+St,+London+NW1+6XE,+United+Kingdom" class="listing-address popup-gmaps">
									<i class="fa fa-map-marker"></i>
									778 Country St. Panama City, FL
								</a>
							</div>

							<ul class="listing-features">
								<li>Area <span>1450 sq ft</span></li>
								<li>Bedrooms <span>2</span></li>
								<li>Bathrooms <span>3</span></li>
							</ul>

							<div class="listing-footer">
								<a href="#"><i class="fa fa-user"></i> Chester Miller</a>
								<span><i class="fa fa-calendar-o"></i> 4 days ago</span>
							</div>

						</div>
						<!-- Listing Item / End -->

					</div>
				</div>
				<!-- Listing Item / End -->


				<!-- Listing Item -->
				<div class="carousel-item">
					<div class="listing-item">


						<a href="single-property-page-3.html" class="listing-img-container">

							<div class="listing-badges">
								<span>For Sale</span>
							</div>

							<div class="listing-img-content">
								<span class="listing-price">$420,000 <i>$770 / sq ft</i></span>
								<span class="like-icon"></span>
							</div>

							<div class="listing-carousel">
								<div><img src="<%=request.getContextPath()%>/templates/public/images/listing-04.jpg" alt=""></div>
								<div><img src="<%=request.getContextPath()%>/templates/public/images/listing-04b.jpg" alt=""></div>
							</div>

						</a>
						
						<div class="listing-content">

							<div class="listing-title">
								<h4><a href="single-property-page-3.html">Selway Apartments</a></h4>
								<a href="https://maps.google.com/maps?q=221B+Baker+Street,+London,+United+Kingdom&amp;hl=en&amp;t=v&amp;hnear=221B+Baker+St,+London+NW1+6XE,+United+Kingdom" class="listing-address popup-gmaps">
									<i class="fa fa-map-marker"></i>
									33 William St. Northbrook, IL
								</a>
							</div>

							<ul class="listing-features">
								<li>Area <span>540 sq ft</span></li>
								<li>Bedrooms <span>2</span></li>
								<li>Bathrooms <span>2</span></li>
							</ul>

							<div class="listing-footer">
								<a href="#"><i class="fa fa-user"></i> Kristen Berry</a>
								<span><i class="fa fa-calendar-o"></i> 3 days ago</span>
							</div>

						</div>
						<!-- Listing Item / End -->

					</div>
				</div>
				<!-- Listing Item / End -->


				<!-- Listing Item -->
				<div class="carousel-item">
					<div class="listing-item">


						<a href="single-property-page-1.html" class="listing-img-container">
							<div class="listing-badges">
								<span>For Sale</span>
							</div>

							<div class="listing-img-content">
								<span class="listing-price">$535,000 <i>$640 / sq ft</i></span>
								<span class="like-icon"></span>
							</div>

							<img src="<%=request.getContextPath()%>/templates/public/images/listing-05.jpg" alt="">
						</a>
						
						<div class="listing-content">

							<div class="listing-title">
								<h4><a href="single-property-page-1.html">Oak Tree Villas</a></h4>
								<a href="https://maps.google.com/maps?q=221B+Baker+Street,+London,+United+Kingdom&amp;hl=en&amp;t=v&amp;hnear=221B+Baker+St,+London+NW1+6XE,+United+Kingdom" class="listing-address popup-gmaps">
									<i class="fa fa-map-marker"></i>
									71 Lower River Dr. Bronx, NY
								</a>
							</div>

							<ul class="listing-features">
								<li>Area <span>350 sq ft</span></li>
								<li>Bedrooms <span>2</span></li>
								<li>Bathrooms <span>1</span></li>
							</ul>

							<div class="listing-footer">
								<a href="#"><i class="fa fa-user"></i> Mabel Gagnon</a>
								<span><i class="fa fa-calendar-o"></i> 4 days ago</span>
							</div>

						</div>
						<!-- Listing Item / End -->

					</div>
				</div>
				<!-- Listing Item / End -->



			</div>
		</div>
		<!-- Carousel / End -->

	</div>
</div>


<!-- For Rent -->
<section class="fullwidth margin-top-55 padding-top-65 padding-bottom-55" data-background-color="#f9f9f9">
<div class="container">

	<div class="row">
	
		<div class="col-md-12">
			<h3 class="headline margin-bottom-25 margin-top-0">For Rent</h3>
		</div>
		
		<!-- Carousel -->
		<div class="col-md-12">
			<div class="carousel">


				<!-- Listing Item -->
				<div class="carousel-item">
					<div class="listing-item">


						<a href="single-property-page-1.html" class="listing-img-container">

							<div class="listing-badges">
								<span class="featured">Featured</span>
								<span>For Rent</span>
							</div>

							<div class="listing-img-content">
								<span class="listing-price">$1700 <i>monthly</i></span>
								<span class="like-icon"></span>
							</div>

							<img src="<%=request.getContextPath()%>/templates/public/images/listing-03.jpg" alt="">

						</a>
						
						<div class="listing-content">

							<div class="listing-title">
								<h4><a href="single-property-page-1.html">Meridian Villas</a></h4>
								<a href="https://maps.google.com/maps?q=221B+Baker+Street,+London,+United+Kingdom&amp;hl=en&amp;t=v&amp;hnear=221B+Baker+St,+London+NW1+6XE,+United+Kingdom" class="listing-address popup-gmaps">
									<i class="fa fa-map-marker"></i>
									778 Country St. Panama City, FL
								</a>
							</div>

							<ul class="listing-features">
								<li>Area <span>1450 sq ft</span></li>
								<li>Bedrooms <span>2</span></li>
								<li>Bathrooms <span>3</span></li>
							</ul>

							<div class="listing-footer">
								<a href="#"><i class="fa fa-user"></i> Chester Miller</a>
								<span><i class="fa fa-calendar-o"></i> 4 days ago</span>
							</div>

						</div>
						<!-- Listing Item / End -->

					</div>
				</div>
				<!-- Listing Item / End -->


				<!-- Listing Item -->
				<div class="carousel-item">
					<div class="listing-item">


						<a href="single-property-page-3.html" class="listing-img-container">

							<div class="listing-badges">
								<span>For Sale</span>
							</div>

							<div class="listing-img-content">
								<span class="listing-price">$420,000 <i>$770 / sq ft</i></span>
								<span class="like-icon"></span>
							</div>

							<div class="listing-carousel">
								<div><img src="<%=request.getContextPath()%>/templates/public/images/listing-04.jpg" alt=""></div>
								<div><img src="<%=request.getContextPath()%>/templates/public/images/listing-04b.jpg" alt=""></div>
							</div>

						</a>
						
						<div class="listing-content">

							<div class="listing-title">
								<h4><a href="single-property-page-3.html">Selway Apartments</a></h4>
								<a href="https://maps.google.com/maps?q=221B+Baker+Street,+London,+United+Kingdom&amp;hl=en&amp;t=v&amp;hnear=221B+Baker+St,+London+NW1+6XE,+United+Kingdom" class="listing-address popup-gmaps">
									<i class="fa fa-map-marker"></i>
									33 William St. Northbrook, IL
								</a>
							</div>

							<ul class="listing-features">
								<li>Area <span>540 sq ft</span></li>
								<li>Bedrooms <span>2</span></li>
								<li>Bathrooms <span>2</span></li>
							</ul>

							<div class="listing-footer">
								<a href="#"><i class="fa fa-user"></i> Kristen Berry</a>
								<span><i class="fa fa-calendar-o"></i> 3 days ago</span>
							</div>

						</div>
						<!-- Listing Item / End -->

					</div>
				</div>
				<!-- Listing Item / End -->


				<!-- Listing Item -->
				<div class="carousel-item">
					<div class="listing-item">


						<a href="single-property-page-1.html" class="listing-img-container">
							<div class="listing-badges">
								<span>For Sale</span>
							</div>

							<div class="listing-img-content">
								<span class="listing-price">$535,000 <i>$640 / sq ft</i></span>
								<span class="like-icon"></span>
							</div>

							<img src="<%=request.getContextPath()%>/templates/public/images/listing-05.jpg" alt="">
						</a>
						
						<div class="listing-content">

							<div class="listing-title">
								<h4><a href="single-property-page-1.html">Oak Tree Villas</a></h4>
								<a href="https://maps.google.com/maps?q=221B+Baker+Street,+London,+United+Kingdom&amp;hl=en&amp;t=v&amp;hnear=221B+Baker+St,+London+NW1+6XE,+United+Kingdom" class="listing-address popup-gmaps">
									<i class="fa fa-map-marker"></i>
									71 Lower River Dr. Bronx, NY
								</a>
							</div>

							<ul class="listing-features">
								<li>Area <span>350 sq ft</span></li>
								<li>Bedrooms <span>2</span></li>
								<li>Bathrooms <span>1</span></li>
							</ul>

							<div class="listing-footer">
								<a href="#"><i class="fa fa-user"></i> Mabel Gagnon</a>
								<span><i class="fa fa-calendar-o"></i> 4 days ago</span>
							</div>

						</div>
						<!-- Listing Item / End -->

					</div>
				</div>
				<!-- Listing Item / End -->


				<!-- Listing Item -->
					<div class="carousel-item">
					<div class="listing-item">

						<a href="single-property-page-1.html" class="listing-img-container">

							<div class="listing-badges">
								<span class="featured">Featured</span>
								<span>For Sale</span>
							</div>

							<div class="listing-img-content">
								<span class="listing-price">$275,000 <i>$520 / sq ft</i></span>
								<span class="like-icon tooltip"></span>
							</div>

							<div class="listing-carousel">
								<div><img src="<%=request.getContextPath()%>/templates/public/images/listing-01.jpg" alt=""></div>
								<div><img src="<%=request.getContextPath()%>/templates/public/images/listing-01b.jpg" alt=""></div>
								<div><img src="<%=request.getContextPath()%>/templates/public/images/listing-01c.jpg" alt=""></div>
							</div>

						</a>
						
						<div class="listing-content">

							<div class="listing-title">
								<h4><a href="single-property-page-1.html">Eagle Apartments</a></h4>
								<a href="https://maps.google.com/maps?q=221B+Baker+Street,+London,+United+Kingdom&amp;hl=en&amp;t=v&amp;hnear=221B+Baker+St,+London+NW1+6XE,+United+Kingdom" class="listing-address popup-gmaps">
									<i class="fa fa-map-marker"></i>
									9364 School St. Lynchburg, NY
								</a>
							</div>

							<ul class="listing-features">
								<li>Area <span>530 sq ft</span></li>
								<li>Bedrooms <span>2</span></li>
								<li>Bathrooms <span>1</span></li>
							</ul>

							<div class="listing-footer">
								<a href="#"><i class="fa fa-user"></i> David Strozier</a>
								<span><i class="fa fa-calendar-o"></i> 1 day ago</span>
							</div>

						</div>

					</div>
				</div>
				<!-- Listing Item / End -->


				<!-- Listing Item -->
				<div class="carousel-item">
					<div class="listing-item">

						<a href="single-property-page-2.html" class="listing-img-container">

							<div class="listing-badges">
								<span>For Rent</span>
							</div>

							<div class="listing-img-content">
								<span class="listing-price">$900 <i>monthly</i></span>
								<span class="like-icon"></span>
							</div>

							<img src="<%=request.getContextPath()%>/templates/public/images/listing-02.jpg" alt="">

						</a>
						
						<div class="listing-content">

							<div class="listing-title">
								<h4><a href="single-property-page-2.html">Serene Uptown</a></h4>
								<a href="https://maps.google.com/maps?q=221B+Baker+Street,+London,+United+Kingdom&amp;hl=en&amp;t=v&amp;hnear=221B+Baker+St,+London+NW1+6XE,+United+Kingdom" class="listing-address popup-gmaps">
									<i class="fa fa-map-marker"></i>
									6 Bishop Ave. Perkasie, PA
								</a>
							</div>

							<ul class="listing-features">
								<li>Area <span>440 sq ft</span></li>
								<li>Bedrooms <span>2</span></li>
								<li>Bathrooms <span>1</span></li>
							</ul>

							<div class="listing-footer">
								<a href="#"><i class="fa fa-user"></i> Harriette Clark</a>
								<span><i class="fa fa-calendar-o"></i> 2 days ago</span>
							</div>

						</div>

					</div>
				</div>
				<!-- Listing Item / End -->

			</div>
		</div>
		<!-- Carousel / End -->

	</div>
</div>
</section>


<!-- Container -->
<div class="container">
	<div class="row">

		<div class="col-md-12">
			<h3 class="headline centered margin-bottom-35 margin-top-10">Get Exposure for Your Listings</h3>
		</div>

		<div class="col-md-12">
			<div class="pricing-container margin-top-40">

			<!-- Plan #1 -->

				<div class="plan">

					<div class="plan-price">
						<h3>Basic</h3>
						<span class="value">Free</span>
						<span class="period">Free of charge one standard listing active for 30 days</span>
					</div>

					<div class="plan-features">
						<ul>
							<li>One Listing</li>
							<li>30 Days Availability</li>
							<li>Standard Listing</li>
							<li>Limited Support</li>
						</ul>
						<a class="button border" href="submit-property.html">Get Started</a>
					</div>

				</div>

				<!-- Plan #3 -->
				<div class="plan featured">

					<div class="listing-badges">
						<span class="featured">Featured</span>
					</div>

					<div class="plan-price">
						<h3>Extended</h3>
						<span class="value">$9.99</span>
						<span class="period">One time fee for one listing, highlighted in the search results</span>
					</div>
					<div class="plan-features">
						<ul>
							<li>One Time Fee</li>
							<li>One Listing</li>
							<li>90 Days Availability</li>
							<li>Featured In Search Results</li>
							<li>24/7 Support</li>
						</ul>
						<a class="button" href="submit-property.html">Get Started</a>
					</div>
				</div>

				<!-- Plan #3 -->
				<div class="plan">

					<div class="plan-price">
						<h3>Professional</h3>
						<span class="value">$19.99</span>
						<span class="period">Monthly subscription for unlimited listings and availability</span>
					</div>

					<div class="plan-features">
						<ul>
							<li>Unlimited Listings</li>
							<li>Unlimited Availability</li>
							<li>Featured In Search Results</li>
							<li>24/7 Support</li>
						</ul>
						<a class="button border" href="submit-property.html">Get Started</a>
					</div>
				</div>

			</div>
		</div>

	</div>
</div>
<!-- Container / End -->



<section class="fullwidth border-top margin-top-55 margin-bottom-0 padding-top-60 padding-bottom-65" data-background-color="#ffffff">
	<!-- Logo Carousel -->
	<div class="container">
		<div class="row">

			<div class="col-md-12">
				<h3 class="headline centered margin-bottom-40 margin-top-10">Companies We've Worked With <span>We can assist you with your innovation or commercialisation journey!</span></h3>
			</div>
			
			<!-- Carousel -->
			<div class="col-md-12">
				<div class="logo-carousel dot-navigation">
					
					<div class="item">
						<img src="<%=request.getContextPath()%>/templates/public/images/logo-01.png" alt="">
					</div>
					
					<div class="item">
						<img src="<%=request.getContextPath()%>/templates/public/images/logo-02.png" alt="">
					</div>
					
					<div class="item">
						<img src="<%=request.getContextPath()%>/templates/public/images/logo-03.png" alt="">
					</div>
					
					<div class="item">
						<img src="<%=request.getContextPath()%>/templates/public/images/logo-04.png" alt="">
					</div>
					
					<div class="item">
						<img src="<%=request.getContextPath()%>/templates/public/images/logo-05.png" alt="">
					</div>		

					<div class="item">
						<img src="<%=request.getContextPath()%>/templates/public/images/logo-06.png" alt="">
					</div>	

					<div class="item">
						<img src="<%=request.getContextPath()%>/templates/public/images/logo-07.png" alt="">
					</div>


				</div>
			</div>
			<!-- Carousel / End -->

		</div>
	</div>
	<!-- Logo Carousel / End -->
</section>



<%@include file="/templates/public/inc/footer.jsp"%>