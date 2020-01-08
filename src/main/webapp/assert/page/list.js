$(document).ready(function() {
	$('#form_role_add_edit').validationEngine('attach', {
		onValidationComplete : function(form, status) {
			
			if(status){
				
				saveOrUpdate();
			}
		}
	});
	initTalbeData();
	
	$('#button_add').off('click').on('click',function(){
		
		$('#form_role_add_edit')[0].reset();
		$('#modal_role').modal('show');
		$('#parentListIp').val("-1");
		$('.formError').remove();
		$('#roleName').removeAttr('data-skip');
		$('#rowId').removeAttr('value');
		$('#action_info').html('新增');
		$("#parentListIp").attr("disabled",true);
	});
	
	$('#dataTable_wrapper').off('click','#addA').on('click','#addA',function(){
		
		$('#form_role_add_edit')[0].reset();
		$('#modal_role').modal('show');
		var rowId = $(this).attr("data-rowId");
		$('#rowId').removeAttr('value');
		$('#parentListIp').val(rowId);
		$("#parentListIp").attr("disabled",true);
		
	});
$('#dataTable_wrapper').off('click','#deleteA').on('click','#deleteA',function(){
	var rowId = $(this).attr("data-rowId");
	
	if(confirm("您确定要删除吗？")){	
	$.ajax({
		url:"list/delete/"+rowId,
		dataType:"json",
		success:function(result){
			initTalbeData();
		}
	});
	}	
	});
$('#dataTable_wrapper').off('click','#updateA').on('click','#updateA',function(){
	var rowId = $(this).attr("data-rowId");
	
	$.ajax({
	url:'list/goupdate/'+rowId,
	dataType:'json',
	success:function(list){
		
		if(list){
			
			$('#modal_role').modal('show');
			$('.formError').remove();
			var listName = list.listName;
			
			$('#listName').val(listName).attr('data-skip',listName);
			$('#parentListIp').val(list.parentListIp);
			$('#listInfo').val(list.listInfo);
			$('#rowId').val(list.rowId);
			
			
		}
	}
});
	});
	
	$("#button_submit").off('click').on('click',function(){
		$("#parentListIp").attr("disabled",false);
		$('#form_role_add_edit').submit();
		
	});	

});

function initTalbeData(){
	
	 $.ajax({
		 url:'list/find',
		
		 success:function(htmlData){
			
			 $('#dataTable_wrapper').html(htmlData);
		 }
	 });
}


//执行 新增或修改
function saveOrUpdate(){
	var rowId = $('#rowId').val();
	if(rowId){//如果主键有信息，则判断进行的是修改
		$.ajax({
			type:'post',
			url:'list/doupdate',
			data:$('#form_role_add_edit').serialize(),
			dataType:'json',
			success:function(result){
				if(result){
					$('#modal_role').modal('hide');
					initTalbeData();
				}
			}
		});
	}else{//则判断执行的是新增
		$.ajax({
			type:'post',
			url:'list/add',
			data:$('#form_role_add_edit').serialize(),
			dataType:'json',
			success:function(result){
				if(result){
					$('#modal_role').modal('hide');
					initTalbeData();
				}
			}
		});
	}

}






