$(document).ready(function(){
	//对表单绑定校验。
	$('#form_role_add_edit').validationEngine('attach', {
		onValidationComplete : function(form, status) {
			//如果校验通过
			if(status){
				//执行 新增或修改
				saveOrUpdate();
			}
		}
	});
	//查询所有的数据
	initTalbeData(1);
	//绑定新增按钮
	$('#button_add').off('click').on('click',function(){
		$('#form_role_add_edit')[0].reset();
		$('#modal_role').modal('show');
		//尝试清空所有的校验信息
		$('.formError').remove();
		//尝试移除data-skip这个属性（为了唯一性校验）
		$('#userName').removeAttr('data-skip');
		//$('#rowId').val('');
		$('#rowId').removeAttr('value');
		$('#action_info').html('新增');
	});
	//绑定Submit按钮
	$('#button_submit').off('click').on('click',function(){
		//让当前的表单执行提交动作
		//表单提交动作会触发表单的校验。
		$('#form_role_add_edit').submit();
	});
	
	//绑定 删除超连接事件 
	$('#dataTable_wrapper').off('click','#deleteA').on('click','#deleteA',function(){
		var rowId = $(this).attr("data-rowId");
		if(confirm("您确定要删除吗？")){
			$.ajax({
				url:'user/dodelete/'+ rowId,
				success:function(result){
					if(result){
						initTalbeData(1);
					}
				}
			});
		}
	});
	
	//绑定搜索按钮
	$('#button_search').on('click',function(){
		//查询所有的数据
		initTalbeData(1);
	});
});
//执行 新增或修改
function saveOrUpdate(){
	var rowId = $('#rowId').val();
	if(rowId){//如果主键有信息，则判断进行的是修改
		$.ajax({
			type:'post',
			url:'user/doupdate',
			data:$('#form_role_add_edit').serialize(),
			dataType:'json',
			success:function(result){
				if(result){
					$('#modal_role').modal('hide');
					initTalbeData(1);
				}
			}
		});
	}else{//则判断执行的是新增
		$.ajax({
			type:'post',
			url:'user/add',
			data:$('#form_role_add_edit').serialize(),
			dataType:'json',
			success:function(result){
				if(result){
					$('#modal_user').modal('hide');
					initTalbeData(1);
				}
			}
		});
	}
}
// go update
function goupdate(rowId){
	$.ajax({
		url:'user/goupdate/'+rowId,
		dataType:'json',
		success:function(user){
			//if(true) js false()
			if(user){
				//将modal表单显示
				$('#modal_role').modal('show');
				//尝试清空所有的校验信息
				$('.formError').remove();
				//$('#roleName').val(role.roleName);
				var userName = user.userName;
				//在需要进行唯一性校验的field里面增加 data-skip这个属性并赋值。
				$('#userName').val(userName).attr('data-skip',userName);
				$('#userCode').val(user.userCode);
				$('#userTlp').val(user.userTlp);
				$('#rowId').val(user.rowId);
				$('#action_info').html('修改');
			}
		}
	});
}

//init table data
 function initTalbeData(pageNo){
	 $.ajax({
		 type:'post',
		 url:'user/find/'+pageNo,
		 data:$('#form_search').serialize(),
		 success:function(htmlData){
			 $('#dataTable_wrapper').html(htmlData);
		 }
	 });
 }
 //响应分页
 function page_select(pageNo){
	 initTalbeData(pageNo);
 }
 //上一页
 function page_prev(){
	var current_page = $('#ul_pagination').find('.active').find('span').text();
	//console.log(current_page);
	initTalbeData(current_page-1);
 }
 //下一页
 function page_next(){
	 var current_page = $('#ul_pagination').find('.active').find('span').text();
	 initTalbeData(parseInt(current_page)+1);
 }