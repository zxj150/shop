<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> 地址管理
		<button type="button" class="btn btn-info btn-sm float-right" id="button_add">添加</button>
	</div>
	<div class="card-body">
		<!-- 搜索页面开始 -->
				<div class="row">
					<div class="col-sm-12 col-md-12">
						<form id="form_search">
							<div class="form-row align-items-center">
							<div class="col-auto my-1">
									<input type="text" class="form-control" name="userId" placeholder="用户ID">
								</div>
								<div class="col-auto my-1">
									<input type="text" class="form-control" name="consigneeTlp" placeholder="联系电话">
								</div>
								<div class="col-auto my-1">
									<input type="text" class="form-control" name="zipCode" placeholder="邮编">
								</div>
								<div class="col-auto my-1">
									<button type="reset" class="btn btn-dark">重置</button>
									<button type="button" class="btn btn-primary" id="button_search">搜索</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<!-- 搜索页面结束 -->
		<div class="table-responsive">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				
			</div>
		</div>
	</div>
</div>
<!-- Logout Modal-->
<div class="modal fade" id="modal_shop" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">地址修改<span id="action_info"></span></h5>
				<button class="close" type="button" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form id="form_role_add_edit">
			<div class="modal-body">
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">用户ID</label>
						<div class="col-sm-7">
							<input type="text" class="form-control validate[required]"
							 id="userId" name="userId">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">省</label>
						<div class="col-sm-7">
							<select class="provinceCode " name="provinceCode" id="provinceCode">
							<c:if test="${!empty addressList}">
								<c:forEach items="${addressList}" var="address">
									<option value="${address.provinceCode}" data-rowId="${address.provinceCode}">${address.provinceCode}</option>
								</c:forEach>                                                                          
							</c:if>
						</select>
						</div>
					</div>
					<input type="hidden" name="provinceParentCode" id="provinceParentCode" value="-1"/>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">市</label>
						<div class="col-sm-7">
							<select class="cityCode " name="cityCode" id="cityCode">
							<c:if test="${!empty addressList}">
								<c:forEach items="${addressList}" var="address">
									<option value="${address.cityCode}" data-rowId="${address.cityCode}">${address.cityCode}</option>
								</c:forEach>                                                                          
							</c:if>
						</select>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">县/区</label>
						<div class="col-sm-7">
							<select class="districtCode " name="districtCode" id="districtCode">
							<c:if test="${!empty addressList}">
								<c:forEach items="${addressList}" var="address">
									<option value="${address.districtCode}" data-rowId="${address.districtCode}">${address.districtCode}</option>
								</c:forEach>                                                                          
							</c:if>
						</select>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">邮政编码</label>
						<div class="col-sm-7">
								<input type="text" class="form-control validate[required]"
							 id="detailedAddress" name="detailedAddress">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">详细地址</label>
						<div class="col-sm-7">
								<input type="text" class="form-control validate[required]"
							 id="detailedAddress" name="detailedAddress">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">联系电话</label>
						<div class="col-sm-7">
								<input type="text" class="form-control validate[required]"
							 id="consigneeTlp" name="consigneeTlp">
						</div>
					</div>
					
					<input type="hidden" name="rowId" id="rowId"/>
			</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">取消</button>
				<button class="btn btn-primary" type="button" id="button_submit">提交</button>
			</div>
			</form>
		</div>
	</div>
</div>
<script src="assert/page/address.js"></script>