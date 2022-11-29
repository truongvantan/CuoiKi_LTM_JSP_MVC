<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-sm-3">
	<div class="card bg-light mb-3">
		<div class="card-header bg-primary text-white text-uppercase">
			<i class="fa fa-list"></i> nhà sản xuất
		</div>
		<ul class="list-group category_block">
			<c:forEach items="${listManufacturer}" var="m">
				<li class="list-group-item text-white ${tag == m.mid ? "active" : ""}"><a
					href="manufacturer?mid=${m.mid}">${m.mname}</a></li>
			</c:forEach>

		</ul>
	</div>
	<div class="card bg-light mb-3">
		<div class="card-header bg-success text-white text-uppercase">sản phẩm mới nhất</div>
		<div class="card-body">
			<img class="img-fluid" src="${latestProduct.image}" />
			<h5 class="card-title">${latestProduct.name}</h5>
			<p class="card-text">${latestProduct.title}</p>
			<p class="bloc_left_price">
				<fmt:setLocale value="vi_VN" />
				<fmt:formatNumber value="${latestProduct.price}" type="currency" />
			</p>
		</div>
	</div>
</div>