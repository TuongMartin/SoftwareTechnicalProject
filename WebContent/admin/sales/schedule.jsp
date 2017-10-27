<%@page import="model.bean.ChucVu"%>
<%@page import="model.dao.ChucVuDAO"%>
<%@page import="model.bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.SalesDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/templates/admin/inc/header.jsp"%>
<%@include file="/templates/admin/inc/leftbar.jsp"%>
<div class="main-panel">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar bar1"></span> <span class="icon-bar bar2"></span>
					<span class="icon-bar bar3"></span>
				</button>
				<a class="navbar-brand" href="/admin">Trang quản lý</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="http://vinenter.edu.vn"> <i
							class="ti-settings"></i>
							<p>Settings</p>
					</a></li>
				</ul>

			</div>
		</div>
	</nav>

	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="header">
							<h4 class="title">Lịch làm việc nhân viên 
							<% if(session.getAttribute("objSales") != null) {
								NhanVien objSales = (NhanVien) session.getAttribute("objSales"); %>
								<span style = "font-weight: bold;text-transform: uppercase;"><%=objSales.getTenNhanVien()%></span>
							</h4>
							<form action="<%=request.getContextPath() %>/admin/schedule?idSales=<%=objSales.getIdNhanVien()%>" method="post">
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											 <INPUT type="text" name="title" size="35" class="form-control border-input" placeholder="Course Name:"><BR>
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<SELECT class="form-control"  name="starttime">
											<OPTION value="8">8:00am</OPTION>
											<OPTION value="9">9:00am</OPTION>
											<OPTION value="10">10:00am</OPTION>
											<OPTION value="11">11:00am</OPTION>
											<OPTION value="12">12:00pm</OPTION>
											<OPTION value="13">1:00pm</OPTION>
											<OPTION value="14">2:00pm</OPTION>
											<OPTION value="15">3:00pm</OPTION>
											<OPTION value="16">4:00pm</OPTION>
											<OPTION value="17">5:00pm</OPTION>
											<OPTION value="18">6:00pm</OPTION>
											<OPTION value="19">7:00pm</OPTION>
											<OPTION value="20">8:00pm</OPTION>
											<OPTION value="21">9:00pm</OPTION>
										</SELECT> 
										</div>
									</div>
									<div class="col-md-3">
									    <div class="form-group">	 
										<SELECT class="form-control" name="endtime">
											<OPTION value="9">9:00am</OPTION>
											<OPTION value="10">10:00am</OPTION>
											<OPTION value="11">11:00am</OPTION>
											<OPTION value="12">12:00pm</OPTION>
											<OPTION value="13">1:00pm</OPTION>
											<OPTION value="14">2:00pm</OPTION>
											<OPTION value="15">3:00pm</OPTION>
											<OPTION value="16">4:00pm</OPTION>
											<OPTION value="17">5:00pm</OPTION>
											<OPTION value="18">6:00pm</OPTION>
											<OPTION value="19">7:00pm</OPTION>
											<OPTION value="20">8:00pm</OPTION>
											<OPTION value="21">9:00pm</OPTION>
											<OPTION value="22">10:00pm</OPTION>
										</SELECT> <BR> <BR> 
										</div>
									</div>
								</div>
								<div class= "row">
									<div class="col-md-8">
										<div class="form-group">
										Course Time: <label class="checkbox-inline"><INPUT type="checkbox" name="day" value="sun">Sun</label>
												<label class="checkbox-inline"><INPUT type="checkbox" name="day" value="mon">Mon</label>
												<label class="checkbox-inline"><INPUT type="checkbox" name="day" value="tue">Tue</label> 
												<label class="checkbox-inline"><INPUT type="checkbox" name="day" value="wed">Wed</label>
												<label class="checkbox-inline"><INPUT type="checkbox" name="day" value="thu">Thu</label> 
												<label class="checkbox-inline"><INPUT type="checkbox" name="day" value="fri">Fri</label> 
												<label class="checkbox-inline"><INPUT type="checkbox" name="day" value="sat">Sat</label> 
										</div>		
									</div>
								</div>
								<INPUT type="submit" name="Submit" class="btn btn-success" value="Add Course">
							</form>
						</div>
				            <div class="content table-responsive table-full-width">
								<div class="table-responsive">    
									<TABLE border="1" cellspacing="0" class="table table-bordered">
										<TBODY>
											<TR>
												<TH align="center" valign="middle" width="80"></TH>
												<TH align="center" valign="middle" class="active">Sunday</TH>
												<TH align="center" valign="middle" class="bg-warning text-white">Monday</TH>
												<TH align="center" valign="middle" class="bg-danger text-white">Tuesday</TH>
												<TH align="center" valign="middle" class="bg-inverse text-white">Wednesday</TH>
												<TH align="center" valign="middle" class="bg-primary text-white">Thursday</TH>
												<TH align="center" valign="middle" class="bg-success text-white">Friday</TH>
												<TH align="center" valign="middle" class="bg-info text-white">Saturday</TH>
											</TR>
											<c:forEach begin="8" end="22" step="1" var="time">
												<TR>
													<TD align="center" valign="middle" width="80">
													   <c:choose>
															<c:when test="${time == 12}">
																<c:out value="${time}" />:00pm
															</c:when>
															<c:when test="${time > 12}">
																<c:out value="${time - 12}" />:00pm
															</c:when>
															<c:otherwise>
																<c:out value="${time}" />:00am
															</c:otherwise>
														</c:choose>
													</TD>
													<c:forEach begin="0" end="6" step="1" var="day">
														<TD align="center" valign="middle" width="100">
														
														<c:if test="${agendaItemSale ne null }">
															<c:forEach items="${agendaItemSale}" var="item">
																<c:if test="${item.startTime == time && item.day == day}">
																	<div id ="active${item.idItemAgenda}" onclick="return editInline(${item.idItemAgenda},${item.idAgenda});"><span style = "color: black;" class="btn"><c:out value="${item.title}" /></span></div>
																</c:if>
															</c:forEach>
														</c:if>
														</TD>
													</c:forEach>
												</TR>
											</c:forEach>
										</TBODY>
									</TABLE>
								</div>
							</div>
							<script type="text/javascript">
											function editInline(idItemAgenda,idAgenda){
												if (confirm("Do you want to delete it?")){
													$.ajax({
														url: '<%=request.getContextPath()%>/admin/activeSchedule',
														type: 'POST',
														cache: false, 
														data: {
															idItemAgenda: idItemAgenda,
															idAgenda: idAgenda,
														},
														success: function(data){
															$("#active"+idItemAgenda).html(data);
														},
														error: function (){
															alert("Có lỗi trong quá trình xử lý");
														}
													});
													return false;
												}
											}
									</script>
							<%}%>
					</div>
				</div>


			</div>
		</div>
	</div>
	<%@include file="/templates/admin/inc/footer.jsp"%>