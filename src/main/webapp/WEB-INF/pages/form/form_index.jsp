<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<jsp:include page="/base.jsp" />
<!-- Custom fonts for this template-->
<link href="assert/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css" />
<!-- Page level plugin CSS-->
<link href="assert/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet" type="text/css" />
<!-- Custom styles for this template-->
<link href="assert/css/sb-admin.css" rel="stylesheet">
</head>
<body>
	<div class="table-responsive">
		<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
			<div class="row">
				<div class="col-sm-12">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th scope="col">订单编号</th>
								<th scope="col">用户名称</th>
								<th scope="col">订单总价</th>
								<th scope="col">订单状态</th>
								<th scope="col">收货地址</th>
								<th scope="col">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr id="tr1">
								<td><a href="javascript:findChild(1);"><i class="fa fa-chevron-right"></i></a> 191231001</td>
								<td>张三</td>
								<td>￥1200.00</td>
								<td>待发货</td>
								<td>山东省青岛市城阳区中享思途</td>
								<td><a href="">发货</a>
								<a href="">取消订单</a></td>
							</tr>
							<tr id="tr2">
								<td><a href="javascript:findChild(2);"><i class="fa fa-chevron-right"></i></a> 191231001</td>
								<td>张三</td>
								<td>￥1200.00</td>
								<td>待发货</td>
								<td>山东省青岛市城阳区中享思途</td>
								<td><a href="">发货</a>
								<a href="">取消订单</a></td>
							</tr>
							<tr id="tr3">
								<td><a href="javascript:findChild(3);"><i class="fa fa-chevron-right"></i></a> 191231001</td>
								<td>张三</td>
								<td>￥1200.00</td>
								<td>待发货</td>
								<td>山东省青岛市城阳区中享思途</td>
								<td><a href="">发货</a>
									<a href="">取消订单</a>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="assets/vendor/jquery/jquery.min.js"></script>
<script src="assert/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
	function findChild(id) {
		//根据id取得tr的jQuery对象
		var $tr = $('#tr' + id);
		// 通过 tr找到有 fa这个样式的 i 
		var $i = $tr.find('.fa');
		//判断 如果是 右向图标，则执行 下拉数据的查询
		if ($i.hasClass('fa-chevron-right')) {
			$i.removeClass('fa-chevron-right').addClass('fa-chevron-down');
			$.ajax({
				//url:'test/child/'+id,
				url : 'form/list',
				success : function(htmlData) {
					console.log(htmlData);
					$tr.after(htmlData);
				}
			});
		} else {
			//否则清空下拉列表数据
			$i.removeClass('fa-chevron-down').addClass('fa-chevron-right');
			$('#child' + id).remove();
		}

	}
</script>
</html>