<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文本编辑器</title>
<!-- include libraries(jQuery, bootstrap) -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<link href="assets/vendor/summernote/summernote-bs4.css" rel="stylesheet">
</head>
<body>
<form method="post" action="test/add">
  <textarea id="summernote" name="proInfo"></textarea>
  <input type="submit" value="提交"/>
</form>
</body>
<script src="assets/js/vendor/jquery-3.3.1.min.js"></script> 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<!-- include summernote css/js -->
<script src="assets/vendor/summernote/summernote-bs4.js"></script>
<script src="assets/vendor/summernote/lang/summernote-zh-CN.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#summernote').summernote({
			lang: 'zh-CN', // default: 'en-US'
	        placeholder: 'Hello bootstrap 4',
	        tabsize: 2,
	        height: 100
	      });
	});
</script>
</html>