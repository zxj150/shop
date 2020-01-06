<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
	<meta charset="UTF-8">
	<link rel="shortcut icon" href="favicon.ico">
	<link rel="stylesheet" href="css/iconfont.css">
	<link rel="stylesheet" href="css/global.css">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="css/login.css">
	<script src="js/jquery.1.12.4.min.js" charset="UTF-8"></script>
	<script src="js/bootstrap.min.js" charset="UTF-8"></script>
	<script src="js/jquery.form.js" charset="UTF-8"></script>
	<script src="js/global.js" charset="UTF-8"></script>
	<script src="js/login.js" charset="UTF-8"></script>
	<script src="assert/page/admain.js"></script>
	<title>管理员登陆</title>
	<jsp:include page="/base.jsp"></jsp:include>
</head>
<body>
	<div class="public-head-layout container">
		<a class="logo" href="index.jsp"><img src="images/icons/logo.jpg" alt="管理员页面" class="cover"></a>
	</div>
	<div style="background:url(images/login_bg.jpg) no-repeat center center; ">
		<div class="login-layout container">
			<div class="form-box login">
				<div class="tabs-nav">
					<h2>管理员登陆</h2>
				</div>
				<div class="tabs_container">
					<form class="tabs_form" action="" method="post" id="admain_form">
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-phone" aria-hidden="true"></span>
								</div>
								<input class="form-control phone" name="userCode" id="userCode" required placeholder="账号" maxlength="11" autocomplete="off" type="text">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
								</div>
								<input class="form-control password" name="userPass" id="userPass" placeholder="请输入密码" autocomplete="off" type="password">
								<div class="input-group-addon pwd-toggle" title="显示密码"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></div>
							</div>
						</div>
						<div class="checkbox">
	                    </div>
						<div class="form-group">
							<div class="error_msg" id="login_error">
							</div>
						</div>
	                    <button class="btn btn-large btn-primary btn-lg btn-block submit" id="admain_button_submit" type="button">登录</button><br>
                    </form>
                </div>
			</div>
			<script>
				$(document).ready(function() {
					// 判断直接进入哪个页面 例如 login.php?p=register
					switch($.getUrlParam('p')) {
						case 'register': $('.register').show(); break;
						case 'resetpwd': $('.resetpwd').show(); break;
						default: $('.login').show();
					};
					// 发送验证码事件
					/* $('.getsms').click(function() {
						var phone = $(this).parents('form').find('input.phone');
						var error = $(this).parents('form').find('.error_msg');
						switch(phone.validatemobile()) {
							case 0:
								// 短信验证码的php请求
								error.jsp(msgtemp('验证码 <strong>已发送</strong>','alert-success'));
								$(this).rewire(60);
							break;
							case 1: error.jsp(msgtemp('<strong>手机号码为空</strong> 请输入手机号码',    'alert-warning')); break;
							case 2: error.jsp(msgtemp('<strong>手机号码错误</strong> 请输入11位数的号码','alert-warning')); break;
							case 3: error.jsp(msgtemp('<strong>手机号码错误</strong> 请输入正确的号码',  'alert-warning')); break;
						}
					}); */
					// 以下确定按钮仅供参考
					$('.submit').click(function() {
						var form = $(this).parents('form')
						var phone = form.find('input.phone');
						var pwd = form.find('input.password');
						var error = form.find('.error_msg');
						var success = form.siblings('.tabs_div');
						var options = {
							beforeSubmit: function () {
								console.log('喵喵喵')
							},
							success: function (data) {
								console.log(data)
							}
						}
						// 验证手机号参考这个
					/* 	switch(phone.validatemobile()) {
							case 1: error.jsp(msgtemp('<strong>账号为空</strong> 请输入账号',    'alert-warning')); return; break;
							case 2: error.jsp(msgtemp('<strong>账号错误</strong> 请输入11位数的号码','alert-warning')); return; break;
							case 3: error.jsp(msgtemp('<strong>账号错误</strong> 请输入正确的账号',  'alert-warning')); return; break;
						}
						// 验证密码复杂度参考这个
						switch(pwd.validatepwd()) {
							case 1: error.jsp(msgtemp('<strong>密码不能为空</strong> 请输入密码',    'alert-warning')); return; break;
							case 2: error.jsp(msgtemp('<strong>密码过短</strong> 请输入6位以上的密码','alert-warning')); return; break;
							case 3: error.jsp(msgtemp('<strong>密码过于简单</strong><br>密码需为字母、数字或特殊字符组合',  'alert-warning')); return; break;
						} */
						form.ajaxForm(options);
						// 请求成功执行类似这样的事件
						// form.fadeOut(150,function() {
						// 	success.fadeIn(150);
						// });
					})
				});
			</script>
		</div>
	</div>
</body>
</html>