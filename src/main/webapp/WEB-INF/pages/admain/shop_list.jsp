<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-12">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">商品编号</th>
					<th scope="col">商品名称</th>
					<th scope="col">商品价格</th>
					<th scope="col">商品图片</th>
					<th scope="col">商品介绍</th>
					<th scope="col">库存数量</th>
					<th scope="col">商品状态</th>
					<th scope="col">操作 </th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty shopList}">
					<c:forEach items="${shopList}" var="shop" varStatus="status">
						<tr>
							<th scope="row">${status.index+1}</th>
							<td>${shop.shopCode}</td>
							<td>${shop.shopName}</td>
							<td>${shop.shopPrice}</td>
							<td>${shop.shopPicture}</td>
							<td>${shop.shopInfo}</td>
							<td>${shop.shopNumber}</td>
							<%-- <td><c:if test="${shop.listId ==1}">男装</c:if>
							<c:if test="${shop.listId ==2}">女装</c:if>
							</td> --%>
							<td><c:if test="${shop.shopState ==1}">已上架</c:if></td>
							<td><a class="btn btn-primary btn-sm" href="javascript:goupdate(${shop.rowId});">修改</a> 
							<!-- data-xxx H5以后允许自定义元素的属性 --> 
							<a class="btn btn-primary btn-sm" href="javascript:;" data-rowId="${shop.rowId}" id="deleteA">下架</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</div>
<%-- 引入分页 --%>
<%@ include file="/page.jsp" %>