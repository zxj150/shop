<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 顶部tab -->
	<div class="tab-header">
		<div class="inner">
			<div class="pull-left">
				<div class="pull-left">嗨，欢迎来到<span class="cr">U袋网</span></div>
				<a href="agent_level.jsp">网店代销</a>
				<a href="temp_article/udai_article4.jsp">帮助中心</a>
			</div>
			<div class="pull-right">
				<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
						<c:if test="${empty sessionScope.user_return}">
					<a href="login"><span class="cr">登录/注册</span></a>
					</c:if>
					<c:if test="${!empty sessionScope.user_return}">
					<span class="name c6">已登录</span>
					</c:if>
				<!-- <a href="login.jsp?p=register">注册</a> -->
				<a href="login">我的订单</a>
			</div>
		</div>
	</div>
</body>
</html>