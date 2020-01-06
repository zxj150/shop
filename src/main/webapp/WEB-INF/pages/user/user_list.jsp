<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-12">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">用户名称</th>
					<th scope="col">用户类型</th>
					<th scope="col">用户账号</th>
					<th scope="col">用户电话</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty userList}">
					<c:forEach items="${userList}" var="user" varStatus="status">
						<tr>
							<th scope="row">${status.index+1}</th>
							<td>${user.userName}</td>
							<td><c:if test="${user.userClazz ==1}">一级</c:if></td>
							<td>${user.userCode}</td>
							<td>${user.userTlp}</td>
							<td><a class="btn btn-primary btn-sm" href="javascript:goupdate(${user.rowId});">修改</a> 
							<!-- data-xxx H5以后允许自定义元素的属性 --> 
							<a class="btn btn-primary btn-sm" href="javascript:;" data-rowId="${user.rowId}" id="deleteA">删除</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</div>
<%-- 引入分页 --%>
<%@ include file="/page.jsp" %>