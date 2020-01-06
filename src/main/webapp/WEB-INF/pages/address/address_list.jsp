<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-12">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">用户名称</th>
					<th scope="col">联系电话</th>
					<th scope="col">收货地址</th>
					<th scope="col">邮政编码</th>
					<th scope="col">操作 </th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty addressList}">
					<c:forEach items="${addressList}" var="address" varStatus="status">
						<tr>
							<th scope="row">${status.index+1}</th>
							<td>${address.userId}</td>
							<td>${address.consigneeTlp}</td>
							<td>${address.detailedAddress}</td>
							<td><a class="btn btn-primary btn-sm" href="javascript:goupdate(${address.rowId});">修改地址</a> 
							<!-- data-xxx H5以后允许自定义元素的属性 --> 
							<a class="btn btn-primary btn-sm" href="javascript:;" data-rowId="${address.rowId}" id="deleteA">删除地址</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</div>
<%-- 引入分页 --%>
<%@ include file="/page.jsp" %>