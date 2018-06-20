<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- BEGIN: Subheader -->
<!-- END: Subheader -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery.treegrid.css" />
<div class="m-content">
	<div class="row">
		<div class="col-lg-12">
			<div class="m-portlet m-portlet--mobile ">
				<div class="m-portlet__head">
					<div class="m-portlet__head-caption">
						<div class="m-portlet__head-title">
							<h3 class="m-portlet__head-text">栏目管理</h3>
						</div>
					</div>
					<div class="m-portlet__head-tools">
						<ul class="m-portlet__nav">
							<li class="m-portlet__nav-item">
								<div
									class="m-dropdown m-dropdown--inline m-dropdown--arrow m-dropdown--align-right m-dropdown--align-push"
									data-dropdown-toggle="hover" aria-expanded="true">
									<a href="#"
										class="m-portlet__nav-link btn btn-lg btn-secondary  m-btn m-btn--icon m-btn--icon-only m-btn--pill  m-dropdown__toggle">
										<i class="la la-ellipsis-h m--font-brand"></i>
									</a>
									<div class="m-dropdown__wrapper">
										<span
											class="m-dropdown__arrow m-dropdown__arrow--right m-dropdown__arrow--adjust"></span>
										<div class="m-dropdown__inner">
											<div class="m-dropdown__body">
												<div class="m-dropdown__content">
													<ul class="m-nav">
														<li class="m-nav__section m-nav__section--first"><span
															class="m-nav__section-text"> 栏目管理</span></li>
														<li class="m-nav__item"><a href="javascript:;" onclick="toAddpage()"
															class="m-nav__link"> <i
																class="m-nav__link-icon flaticon-add"></i> <span
																class="m-nav__link-text"> 新闻页面 </span>
														</a></li>
														<li class="m-nav__item"><a  onclick="addRoot()"
															class="m-nav__link"> <i
																class="m-nav__link-icon flaticon-chat-1"></i> <span
																class="m-nav__link-text"> 新建主栏目</span>
														</a></li>
														<li class="m-nav__item"><a href=""
															class="m-nav__link"> <i
																class="m-nav__link-icon flaticon-refresh"></i> <span
																class="m-nav__link-text"> 刷新栏目</span>
														</a></li>
													</ul>
												</div>
											</div>
										</div>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<!-- searchend -->
				<div class="m-portlet__body">
					<!--begin: Datatable -->
            			<table class="tree table">
                		<thead class="thead-default">
                    		<tr>
                       		 <th>栏目名称</th>
                       		 <th>栏目排序</th>
                        	 <th>栏目状态</th>
                        	 <th>栏目介绍</th>
                        	 <th>创建时间</th>
                        	 <th>栏目操作</th>
                    		</tr>
                		</thead>
                		<tbody id="channel_tbody"></tbody>
            			</table>
					
				<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- modal -->
					<div class="modal fade" id="modal_channel" tabindex="-1" role="dialog" aria-labelledby="添加菜单" aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="modaltitle">
											添加子菜单
										</h5>
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">
												&times;
											</span>
										</button>
									</div>
									<div class="modal-body">
									<form id="channel_form" enctype="multipart/form-data">
										<div class="form-group m-form__group row">
											<label class="col-lg-3 col-form-label"> 栏目名称: </label>
											<div class="col-lg-8">
												<input type="text" class="form-control m-input" name="columnName" id="columnName"
													placeholder="输入栏目名称">
													<input type="hidden" name="columnId" id="columnId">
													<input type="hidden" name="columnParentid" id="columnParentid">
											</div>
										</div>
										<div class="form-group m-form__group row">
											<label class="col-lg-3 col-form-label"> 栏目图片: </label>
											<div class="col-lg-8">
												<input type="file" class="form-control m-input" name="columnimage" id="columnimage"
													placeholder="栏目图片(如无则不上传)">
											</div>
										</div>
										<div class="form-group m-form__group row">
											<label class="col-lg-3 col-form-label"> 栏目序号: </label>
											<div class="col-lg-8">
												<input type="number" class="form-control m-input" name="ordinal" id="ordinal"
													placeholder="请输入数字">
											</div>
										</div>
										<div class="form-group m-form__group row">
											<label class="col-lg-3 col-form-label"> 栏目介绍: </label>
											<div class="col-lg-8">
												<textarea class="form-control" rows="3" id="columnIntroduce" name="columnIntroduce"
													style="overflow: hidden; word-wrap: break-word; resize: none; height: 88px;"></textarea>
											</div>
										</div>
									</form>
										
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary" data-dismiss="modal">
											取消
										</button>
										<button type="button" onclick="addColumn()" class="btn btn-primary">
											保存
										</button>
									</div>
								</div>
							</div>
						</div>

<script src="<%=request.getContextPath()%>/js/jquery.treegrid.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery-form.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/channelmanager.js" type="text/javascript"></script>
<script>
selectAllMenu('<%=request.getContextPath()%>');
</script>
