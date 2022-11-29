<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.Bean.Manufacturer"%>
<%@page import="model.Bean.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% DecimalFormat df = new DecimalFormat("#.00"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<!-- <li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
						<li class="breadcrumb-item"><a href="#">Nhà sản xuất</a></li>
						<li class="breadcrumb-item active" aria-current="#">Sub-Nhà sản xuất</li> -->
					</ol>
				</nav>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<jsp:include page="Left.jsp"></jsp:include>

			<div class="col-sm-9">
				<div class="row">
					<c:forEach items="${listProduct}" var="p">
						<div class="col-12 col-md-6 col-lg-4">
							<div class="card">
								<img class="card-img-top" src="${p.image}" alt="Card image cap">
								<div class="card-body">
									<h4 class="card-title show_txt">
										<a href="detail?pid=${p.id }" title="View Product">${p.name}</a>
									</h4>
									<p class="card-text show_txt">${p.title}</p>
									<div class="row">
										<div class="col">
											<p class="btn btn-danger btn-block"><fmt:setLocale value="vi_VN"/><fmt:formatNumber value="${p.price}" type="currency"/></p>
										</div>
										<div class="col">
											<a href="#" class="btn btn-success btn-block">Add to cart</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

		</div>
	</div>

	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>

