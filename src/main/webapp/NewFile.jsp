<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<table id="example-basic-expandable">
		<tr>
			<th>目录名称</th>
			<th>目录简介</th>
			<th>操作</th>
		</tr>
		<tr data-tt-id="0">
			<td>服装</td>
			<td>这是服装大类</td>
			<td>
				<a href="">删除</a>
				<a href="">修改</a>
				<a href="">增加子目录</a>
			</td>
		</tr>
		<tr data-tt-id="1" data-tt-parent-id="0">
			<td>女装</td>
			<td>这是女装大类</td>
			<td>
				<a href="">删除</a>
				<a href="">修改</a>
				<a href="">增加子目录</a>
			</td>
		</tr>
		<tr data-tt-id="5" data-tt-parent-id="1">
			<td>大衣外套</td>
			<td>这是女装大类</td>
			<td>
				<a href="">删除</a>
				<a href="">修改</a>
				<a href="">增加子目录</a>
			</td>
		</tr>
		<tr data-tt-id="2" data-tt-parent-id="0">
			<td>男装</td>
			<td>这是男装大类</td>
			<td>
				<a href="">删除</a>
				<a href="">修改</a>
				<a href="">增加子目录</a>
			</td>
		</tr>
		<tr data-tt-id="3" data-tt-parent-id="0">
			<td>童装</td>
			<td>这是童装大类</td>
			<td>
				<a href="">删除</a>
				<a href="">修改</a>
				<a href="">增加子目录</a>
			</td>
		</tr>
		<tr data-tt-id="10">
			<td>家电</td>
			<td>这是家电大类</td>
			<td>
				<a href="">删除</a>
				<a href="">修改</a>
				<a href="">增加子目录</a>
			</td>
		</tr>
		<tr data-tt-id="13" data-tt-parent-id="10">
			<td>家用家电</td>
			<td>这是家用家电大类</td>
			<td>
				<a href="">删除</a>
				<a href="">修改</a>
				<a href="">增加子目录</a>
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript" src="assert/vendor/jquery/jquery.min.js"></script>
<script type="text/javascript" src="assert/vendor/jquery-treetable/js/jquery.treetable.js"></script>
<script>
	$("#example-basic-expandable").treetable({ expandable: true });
</script>
</html>