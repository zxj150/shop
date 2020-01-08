<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jtree-table-demo</title>
<!-- http://www.jq22.com/demo/jquery-treetable201707260025/  -->
<link href="assert/vendor/jquery-treetable/css/jquery.treetable.css" rel="stylesheet" type="text/css" />
<link href="assert/vendor/jquery-treetable/css/jquery.treetable.theme.default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<table id="example-basic-expandable"class="table table-bordered">
		<tr>
			<th scope="col">目录名称</th>
			<th scope="col">目录简介</th>
			<th scope="col">操作</th>
		</tr>
		<c:if test="${!empty list}">
			<c:forEach items="${list}" var="lists">
			
			
				<tr data-tt-id="${lists.rowId}" data-tt-parent-id="${lists.parentListIp }" scope="row">
				
					<td>${lists.listName}</td>
					<td>${lists.listInfo}</td>
					<td><a class="btn btn-primary btn-sm" href="javascript:;"data-rowId="${lists.rowId}" id="deleteA">删除</a> 
					<a  class="btn btn-primary btn-sm" href="javascript:;"data-rowId="${lists.rowId}" id="updateA">修改</a> 
					<a class="btn btn-primary btn-sm" href="javascript:;" data-rowId="${lists.rowId}" id="addA">增加子目录</a></td>
				</tr>
			</c:forEach>
		</c:if>
		</table>
</body>
<script type="text/javascript" src="assert/vendor/jquery-treetable/js/jquery.treetable.js"></script>
<script>
	$("#example-basic-expandable").treetable({ expandable: true });
</script>

</html>