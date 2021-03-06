
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.bean.Image"%>
<%@page import="model.bean.CanHo"%>
<%@page import="model.bean.KhuVucBDS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp"%>


<!-- Banner
================================================== -->
<div class="parallax" data-background="<%=request.getContextPath()%>/templates/public/images/home-parallax.jpg" data-color="#36383e" data-color-opacity="0.45" data-img-width="2500" data-img-height="1600">
	<div class="parallax-content">

		<div class="container">
			<div class="row">
				<div class="col-md-12">

					<!-- Main Search Container -->
					<div class="main-search-container">
						<h2>Find Your Dream Home</h2>
						
						<!-- Main Search -->
						<form class="main-search-form">
							
							<!-- Type -->
							<div class="search-type">
								<label class="active"><input class="first-tab" name="tab" checked="checked" type="radio">Any Status</label>
								<label><input name="tab" type="radio">For Sale</label>
								<label><input name="tab" type="radio">For Rent</label>
								<div class="search-type-arrow"></div>
							</div>

							
							<!-- Box -->
							<div class="main-search-box">
								
								<!-- Main Search Input -->
								<div class="main-search-input larger-input">
									<input type="text" class="ico-01" placeholder="Enter address e.g. street, city and state or zip" value=""/>
									<button class="button">Search</button>
								</div>

								<!-- Row -->
								<div class="row with-forms">

									<!-- Property Type -->
									<div class="col-md-4">
										<select data-placeholder="Any Type" class="chosen-select-no-single" >
											<option>Any Type</option>	
											<option>Apartments</option>
											<option>Houses</option>
											<option>Commercial</option>
											<option>Garages</option>
											<option>Lots</option>
										</select>
									</div>


									<!-- Min Price -->
									<div class="col-md-4">
										
										<!-- Select Input -->
										<div class="select-input">
											<input type="text" placeholder="Min Price" data-unit="USD">
										</div>
										<!-- Select Input / End -->

									</div>


									<!-- Max Price -->
									<div class="col-md-4">
										
										<!-- Select Input -->
										<div class="select-input">
											<input type="text" placeholder="Max Price" data-unit="USD">
										</div>
										<!-- Select Input / End -->

									</div>

								</div>
								<!-- Row / End -->


								<!-- More Search Options -->
								<a href="#" class="more-search-options-trigger" data-open-title="More Options" data-close-title="Less Options"></a>

								<div class="more-search-options">
									<div class="more-search-options-container">

										<!-- Row -->
										<div class="row with-forms">

											<!-- Min Price -->
											<div class="col-md-6">
												
												<!-- Select Input -->
												<div class="select-input">
													<input type="text" placeholder="Min Area" data-unit="Sq Ft">
												</div>
												<!-- Select Input / End -->

											</div>

											<!-- Max Price -->
											<div class="col-md-6">
												
												<!-- Select Input -->
												<div class="select-input">
													<input type="text" placeholder="Max Area" data-unit="Sq Ft">
												</div>
												<!-- Select Input / End -->

											</div>

										</div>
										<!-- Row / End -->


										<!-- Row -->
										<div class="row with-forms">

											<!-- Min Area -->
											<div class="col-md-6">
												<select data-placeholder="Beds" class="chosen-select-no-single" >
													<option label="blank"></option>	
													<option>Beds (Any)</option>	
													<option>1</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
													<option>5</option>
												</select>
											</div>

											<!-- Max Area -->
											<div class="col-md-6">
												<select data-placeholder="Baths" class="chosen-select-no-single" >
													<option label="blank"></option>	
													<option>Baths (Any)</option>	
													<option>1</option>
													<option>2</option>
													<option>3</option>
													<option>4</option>
													<option>5</option>
												</select>
											</div>

										</div>
										<!-- Row / End -->
			

										<!-- Checkboxes -->
										<div class="checkboxes in-row">
									
											<input id="check-2" type="checkbox" name="check">
											<label for="check-2">Air Conditioning</label>

											<input id="check-3" type="checkbox" name="check">
											<label for="check-3">Swimming Pool</label>

											<input id="check-4" type="checkbox" name="check" >
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
								</div>
								<!-- More Search Options / End -->


							</div>
							<!-- Box / End -->

						</form>
						<!-- Main Search -->

					</div>
					<!-- Main Search Container / End -->

				</div>
			</div>
		</div>

	</div>
</div>


<!-- Content
================================================== -->
<div class="container">
	<div class="row">
		<div style="text-align: center;" class="col-md-12 location">
	      <h4>MAP</h4>
	      <div style="width: 100%;height: 500px;" id="map">
	      </div>
	 	</div>
		<div class="col-md-12">
			<h3 class="headline margin-bottom-25 margin-top-65">Newly Added</h3>
		</div>
		
		<!-- Carousel -->
		<div class="col-md-12">
			<div class="carousel">
				<%
					ArrayList<CanHo> listApartmentNewly = (ArrayList<CanHo>)request.getAttribute("listApartmentNewly");
					ArrayList<ArrayList<Image>> listImageApartmentNewly = (ArrayList<ArrayList<Image>>)request.getAttribute("listImageApartmentNewly");
					for(int i = 0; i < listApartmentNewly.size(); i++) {
				%>
						<!-- Listing Item -->
						<div class="carousel-item">
							<div class="listing-item">
								<a href="single-property-page-3.html" class="listing-img-container">
									<div class="listing-img-content">
									<%
										DecimalFormat formatter = new DecimalFormat("###,###,###");
										String giatien = formatter.format(listApartmentNewly.get(i).getGiatien());
									%>
										<span class="listing-price">$<%=giatien %> <i>$<%=(listApartmentNewly.get(i).getGiatien() / listApartmentNewly.get(i).getDientich()) %> / sq ft</i></span>
										<span class="like-icon"></span>
									</div>
									<div class="listing-carousel">
										<%
											for(Image objImage : listImageApartmentNewly.get(i)) {
										%>
												<div><img style="width: 333px;height: 254px" src="<%=request.getContextPath()%>/files/<%=objImage.getHinhAnh() %>" alt=""></div>		
										<%
											}
										%>
									</div>
								</a>
								<div class="listing-content">
									<div class="listing-title">
										<h4><a href="single-property-page-3.html"><%=listApartmentNewly.get(i).getTen() %></a></h4>
										<a href="https://maps.google.com/maps?q=221B+Baker+Street,+London,+United+Kingdom&amp;hl=en&amp;t=v&amp;hnear=221B+Baker+St,+London+NW1+6XE,+United+Kingdom" class="listing-address popup-gmaps">
											<i class="fa fa-map-marker"></i>
											<%=listApartmentNewly.get(i).getDiachi() %>
										</a>
									</div>
									<ul class="listing-features">
										<li>Area <span><%=listApartmentNewly.get(i).getDientich() %> sq ft</span></li>
										<li>Bedrooms <span><%=listApartmentNewly.get(i).getSophongngu() %></span></li>
										<li>Bathrooms <span><%=listApartmentNewly.get(i).getSophongtam() %></span></li>
									</ul>
									<div class="listing-footer">
										<a href="#"><i class="fa fa-user"></i> <%=listApartmentNewly.get(i).getTennhanvien() %></a>
										<span><i class="fa fa-calendar-o"></i> 3 days ago</span>
									</div>
								</div>
							</div>
						</div>
						<!-- Listing Item / End -->
				<%
					}
				%>
			</div>
		</div>
		<!-- Carousel / End -->
	</div>
</div>



<!-- Fullwidth Section -->
<section class="fullwidth margin-top-105" data-background-color="#f7f7f7">

	<!-- Box Headline -->
	<h3 class="headline-box">What are you looking for?</h3>
	
	<!-- Content -->
	<div class="container">
		<%
			ArrayList<TheLoaiBDS> listRealEstates = (ArrayList<TheLoaiBDS>)request.getAttribute("listRealEstate");
			int row = (int)Math.ceil((float)listRealEstate.size() / 4);
			int k = 0;
			for(int i = 0; i < row; i++) {
		%>
				<div class="row">
				<%
					for(int j = k; j < listRealEstate.size(); j++) {
				%>
					<div class="col-md-3 col-sm-6">
						<!-- Icon Box -->
						<div class="icon-box-1">
							<a href="<%=request.getContextPath() %>/listapartment?idTheLoai=<%=listRealEstate.get(j).getId() %>">
								<div class="icon-container" style="background-color: #F7F7F7">
									<img style="border-radius: 50%" src="<%=request.getContextPath() %>/files/<%=listRealEstate.get(j).getImage() %>">
								</div>
							</a>
							<h3><%=listRealEstate.get(j).getTen() %></h3>
						</div>
					</div>
				<%
						k++;
						if(k % 4 == 0) break;
					}
				%>
				</div>
		<%
			}
		%>
	</div>
</section>
<!-- Fullwidth Section / End -->


<!-- Container -->
<div class="container">
	<div class="row">

		<div class="col-md-12">
			<h3 class="headline centered margin-bottom-35 margin-top-10">Most Popular Places <span>Properties In Most Popular Places</span></h3>
		</div>
		<%
			ArrayList<KhuVucBDS> listAreas = (ArrayList<KhuVucBDS>)request.getAttribute("listAreas");
			int i = 1;
			for(KhuVucBDS objKV : listAreas) {
				int j = 0;
				if(i % 4 == 1 || i % 4 == 0) {
					j = 4;
				}else {
					j = 8;
				}
				i++;
		%>
					<div class="col-md-<%=j %>">
						<!-- Image Box -->
						<a href="<%=request.getContextPath() %>/listapartment?idKhuVuc=<%=objKV.getId() %>" class="img-box" data-background-image="<%=request.getContextPath()%>/files/<%=objKV.getImage() %>">
							<!-- Badge -->
							<div class="img-box-content visible">
								<h4><%=objKV.getTen() %> </h4>
								<span><%=objKV.getCountBDS() %> Properties</span>
							</div>
						</a>
					</div>	
		<%
			}
		%>
	</div>
</div>
<!-- Container / End -->


<!-- Fullwidth Section -->
<section class="fullwidth margin-top-95 margin-bottom-0">

	<!-- Box Headline -->
	<h3 class="headline-box">Articles & Tips</h3>

	<div class="container">
		<div class="row">

			<div class="col-md-4">

				<!-- Blog Post -->
				<div class="blog-post">
					
					<!-- Img -->
					<a href="blog-post.html" class="post-img">
						<img src="<%=request.getContextPath()%>/templates/public/images/blog-post-01.jpg" alt="">
					</a>
					
					<!-- Content -->
					<div class="post-content">
						<h3><a href="#">8 Tips to Help You Finding New Home</a></h3>
						<p>Nam nisl lacus, dignissim ac tristique ut, scelerisque eu massa. Vestibulum ligula nunc, rutrum in malesuada vitae. </p>

						<a href="blog-post.html" class="read-more">Read More <i class="fa fa-angle-right"></i></a>
					</div>

				</div>
				<!-- Blog Post / End -->

			</div>

			<div class="col-md-4">

				<!-- Blog Post -->
				<div class="blog-post">
					
					<!-- Img -->
					<a href="blog-post.html" class="post-img">
						<img src="<%=request.getContextPath()%>/templates/public/images/blog-post-02.jpg" alt="">
					</a>
					
					<!-- Content -->
					<div class="post-content">
						<h3><a href="#">Bedroom Colors You'll Never Regret</a></h3>
						<p>Nam nisl lacus, dignissim ac tristique ut, scelerisque eu massa. Vestibulum ligula nunc, rutrum in malesuada vitae. </p>

						<a href="blog-post.html" class="read-more">Read More <i class="fa fa-angle-right"></i></a>
					</div>

				</div>
				<!-- Blog Post / End -->

			</div>

			<div class="col-md-4">

				<!-- Blog Post -->
				<div class="blog-post">
					
					<!-- Img -->
					<a href="blog-post.html" class="post-img">
						<img src="<%=request.getContextPath()%>/templates/public/images/blog-post-03.jpg" alt="">
					</a>
					
					<!-- Content -->
					<div class="post-content">
						<h3><a href="#">What to Do a Year Before Buying Apartment</a></h3>
						<p>Nam nisl lacus, dignissim ac tristique ut, scelerisque eu massa. Vestibulum ligula nunc, rutrum in malesuada vitae. </p>

						<a href="blog-post.html" class="read-more">Read More <i class="fa fa-angle-right"></i></a>
					</div>

				</div>
				<!-- Blog Post / End -->

			</div>

		</div>
	</div>
</section>
<!-- Fullwidth Section / End -->


<!-- Flip banner -->
<a href="listings-half-map-grid-standard.html" class="flip-banner parallax" data-background="images/flip-banner-bg.jpg" data-color="#274abb" data-color-opacity="0.9" data-img-width="2500" data-img-height="1600">
	<div class="flip-banner-content">
		<h2 class="flip-visible">We help people and homes find each other</h2>
		<h2 class="flip-hidden">Browse Properties <i class="sl sl-icon-arrow-right"></i></h2>
	</div>
</a>
<!-- Flip banner / End -->
	<%
 		String address = "Phan Bá Phiến, Sơn Trà, Đà Nẵng";
 	%>
 	<script type="text/javascript">
	 	$(document).ready(function() {
			var geocoder = new google.maps.Geocoder();
			var address = { 'address': "<%=address %>" };
			geocoder.geocode(address, function(results, status) {
				if(status == google.maps.GeocoderStatus.OK) {
					var latitude = results[0].geometry.location.lat();
					var longitude = results[0].geometry.location.lng();
				}
				var mapCanvas = document.getElementById('map');
			 	var location = new google.maps.LatLng(latitude, longitude);
			 	var mapOptions  = {
		 			center: location,
		 			zoom: 18,
		 			panControle: false,
		 			mapTypeId: google.maps.MapTypeId.ROADMAP
			 	};
			 	var markerIcon  = {
			 		url: 'http://image.flaticon.com/icons/svg/252/252025.svg',
			 		scaledSize: new google.maps.Size(80, 80),
			 		origin: new google.maps.Point(0, 0),
			 		anchor: new google.maps.Point(32, 65),
			 		labelOrigin:  new google.maps.Point(40, 33)
			 	};
			 	var map = new google.maps.Map(mapCanvas, mapOptions);
			 	var markerLabel = 'GO!';
			 	var marker = new google.maps.Marker({
			 		position: location,
			 		draggable: true,
			 		animation: google.maps.Animation.DROP,
			 		map: map,
			 		icon: markerIcon,
			 		label: {
			 			text: markerLabel,
			 			color: "#eb3a44",
			 			 fontSize: "16px",
			 			 fontWeight: "bold",
			 		}
			 	});
			 	marker.addListener('click', function() {
			 		 marker.setAnimation(google.maps.Animation.BOUNCE);
			 	});
			 	var contentString = '<div class="info-window" style="border-radius: 50px;">' +
			 							'<div style="float: left; width: 100%; color: gray; font-size: 16px">' +
				 							'<span style="display: inline-block">Địa chỉ : ' + address.address + '</span>' +
			 							'</div>' +
		 							'</div>';
		 		var inforWindow = new google.maps.InfoWindow({
		 			content: contentString,
		 			maxWidth: 250
		 		});
		 		marker.addListener('click', function() {
		 			inforWindow.open(map, marker);
		 		})
			})		 	
		});
 	</script>

<%@include file="/templates/public/inc/footer.jsp"%>