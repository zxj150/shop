$(document).ready(function(){
	//选择省信息
    $('#provinceCode').on('change',function(){
    	//alert("111");
    	$("#cityCode option").remove();
    	$("#areaCode option").remove();
    	var option='<option>市信息</option>';
		var code=$("#provinceCode").val();
		//alert(code);
		console.log(code);
		$.ajax({
			 url:'address/findByCode/'+code,
			 success:function(result){
				 $.each(result, function(index, item) {
					 
					 option+= '<option value="'+item.areaCode+'">'+item.areaName+'</option>';

					 console.log(option);

				 });
				 $("#cityCode").append(option);

			 }
		 });
    
	});
    //选择市信息
    $('#cityCode').on('change',function(){
    	//alert("22");
    	$("#areaCode option").remove();
    	var option='<option>区信息</option>';
		var code=$("#cityCode").val();
		
		console.log(code);
		$.ajax({
			 url:'address/findByCode/'+code,
			 success:function(result){
				 $.each(result, function(index, item) {
					 
					 option+= '<option value="'+item.areaCode+'">'+item.areaName+'</option>';
					 
					 console.log(option);
	
				 });
				 $("#areaCode").append(option);
				
			 }
		 });
    });
    $('#button_submit1').off('click').on('click',function(){
    	alert("11");
		$.ajax({
			type:'post',
			url:'address/add',
			data:$('#form_role_add_edit').serialize(),
			success:function(result){
					if(result){
						alert("地址新增成功");
						initTalbeData(1);
					}
				}
		})
	});
	//查询所有的数据
	initTalbeData(1);
	//绑定新增按钮
	$('#button_submit').off('click').on('click',function(){
		$('#form_role_add_edit')[0].reset();
		$('#modal_address').modal('show');
		//尝试清空所有的校验信息
		$('.formError').remove();
		//尝试移除data-skip这个属性（为了唯一性校验）
		$('#addressName').removeAttr('data-skip');
		//$('#rowId').val('');
		$('#rowId').removeAttr('value');
		$('#action_info').html('新增');
	});
	//绑定Submit按钮
	$('#button_submit').off('click').on('click',function(){
		$('#form_role_add_edit').submit();
	});
	//绑定 删除超连接事件 
	$('#deleteA').off('click').on('click','#deleteA',function(){
		var rowId = $(this).attr("data-rowId");
		if(confirm("您确定要删除吗？")){
			$.ajax({
				url:'address/dodelete/'+ rowId,
				success:function(result){
					if(result){
						initTalbeData(1);
					}
				}
			});
		}
	});
});

//init table data
 function initTalbeData(pageNo){
	 $.ajax({
		 type:'post',
		 url:'address/find/'+pageNo,
		 data:$('#form_role_add_edit').serialize(),
		 success:function(htmlData){
			 $('#dataTable_wrapper').html(htmlData);
		 }
	 });
 } 
