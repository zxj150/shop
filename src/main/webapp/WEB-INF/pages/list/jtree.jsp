<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> 目录管理
		<button type="button" class="btn btn-info btn-sm float-right" id="button_add">新增</button>
	</div>
	<div class="card-body">
		<!-- 搜索页面开始 -->
			<!-- 	<div class="row">
					<div class="col-sm-12 col-md-12">
						<form id="form_search">
							<div class="form-row align-items-center">
								<div class="col-auto my-1">
									<select class="form-control">
										<option value="">角色级别</option>
										<option value="1">一级</option>
										<option value="2">二级</option>
										<option value="3">三级</option>
									</select>
								</div>
								<div class="col-auto my-1">
									<input type="text" class="form-control" id="inlineFormInputName" placeholder="角色名称">
								</div>
								<div class="col-auto my-1">
									<button type="reset" class="btn btn-dark">重置</button>
									<button type="button" class="btn btn-primary">搜索</button>
								</div>
							</div>
						</form>
					</div>
				</div> -->
				<!-- 搜索页面结束 -->
		<div class="table-responsive">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				
			</div>
		</div>
	</div>
</div>
<!-- Logout Modal-->
<div class="modal fade" id="modal_role" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">目录<span id="action_info"></span></h5>
				<button class="close" type="button" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form id="form_role_add_edit">
			<div class="modal-body">
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">目录名称</label>
						<div class="col-sm-7">
							<input type="text" class="form-control validate[required]"
							 id="listName" name="listName">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">父目录</label>
						<div class="col-sm-7">
							<select class="form-control" name="parentListIp" id="parentListIp"  >
								<option value="-1">一级</option>
							 <c:if test="${!empty menu}">
			                    <c:forEach items="${menu}" var="menu">
								<option value="${menu.rowId }">${menu.listName}</option>
								</c:forEach>
								</c:if> 
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">目录简介</label>
						<div class="col-sm-7">
							<textarea  class="form-control validate[required]" name="listInfo" id="listInfo"></textarea>
						</div>
					</div>
					<input type="hidden" name="rowId" id="rowId" />
			</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">取消</button>
				<button class="btn btn-primary" type="button" id="button_submit">提交</button>
			</div>
			</form>
		</div>
	</div>
</div>
<script src="assert/page/list.js"></script>

