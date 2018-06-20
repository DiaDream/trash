<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!-- BEGIN: Subheader 
<div class="m-subheader ">
	<div class="d-flex align-items-center">
		<div class="mr-auto">
			<h3 class="m-subheader__title ">${sessionScope.siteName}新闻 编辑页面
			</h3>
		</div>
		<div>
			<span class="m-subheader__daterange" id="m_dashboard_daterangepicker">
				<span class="m-subheader__daterange-label"> <span
					class="m-subheader__daterange-title"></span> <span
					class="m-subheader__daterange-date m--font-brand"></span>
			</span> <a href="#"
				class="btn btn-sm btn-brand m-btn m-btn--icon m-btn--icon-only m-btn--custom m-btn--pill">
					<i class="la la-angle-down"></i>
			</a>
			</span>
		</div>
	</div>
</div>-->
<!-- END: Subheader -->
<div class="m-content">
	<!--Begin::Main Portlet-->
	<div class="m-portlet">
		<div class="m-portlet__head">
			<div class="m-portlet__head-caption">
				<div class="m-portlet__head-title">
					<span class="m-portlet__head-icon m--hide"> <i
						class="la la-gear"></i>
					</span>
					<h3 class="m-portlet__head-text">新闻修改</h3>
				</div>
			</div>
		</div>
		<!--begin::Form-->
		<form
			id="newsupdateform" method="post" action="<%=request.getContextPath()%>/news/updateNews"  enctype="multipart/form-data" class="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed">
			<div class="m-portlet__body">
				<div class="form-group m-form__group row">
					<label class="col-lg-2 col-form-label"> 所属栏目: </label>
					<input type="hidden" name="articleId" value="${article.articleId }">
					<div class="col-lg-3">
						<select class="form-control m-select2" id="m_select2_1" name="columnId">
							<c:forEach var="column" items="${columnlist}">
                                    <option <c:if test="${column.columnId==article.columnId}">selected="selected" </c:if> value="${column.columnId }">${column.columnName }</option>
                            </c:forEach>
						</select>
						<input type="hidden" value="${article.columnName }" name="columnName" id="columnName">
					</div>
					<!-- end 选择栏目框 -->
					<label class="col-lg-2 col-form-label"> 标题图片 </label>
					<div class="col-lg-3">
						<input type="text" onclick="toclick(this)"  class="form-control m-input" placeholder="标题图片" value="${article.filePath}">
						<input type="file" onchange="toval(this)" name="titleimage" style="display: none">
					</div>
				</div>

				<div class="form-group m-form__group row">
					<label class="col-lg-2 col-form-label"> 新闻标题: </label>
					<div class="col-lg-3">
						<input type="text" class="form-control m-input" name="title" id="title" value="${article.title}"
							placeholder="输入新闻标题">
					</div>
					<label class="col-lg-2 col-form-label"> 副标题 </label>
					<div class="col-lg-3">
						<input type="email" class="form-control m-input" name="shortTitle" id="shorttitle" value="${article.shortTitle}"
							placeholder="输入新闻副标题">
					</div>
				</div>

				<div class="form-group m-form__group row">
					<label class="col-lg-2 col-form-label"> 来源: </label>
					<div class="col-lg-3">
						<div class="m-input-icon m-input-icon--right">
							<input type="text" class="form-control m-input" name="origin" id="origin" value="${article.origin}"
								placeholder="不填则为本站">
						</div>
					</div>
					<label class="col-lg-2 col-form-label"> 来源链接: </label>
					<div class="col-lg-3">
						<div class="m-input-icon m-input-icon--right">
							<input type="text" class="form-control m-input" name="outurl" id="outurl" value="${article.outurl}"
								placeholder="本站不填 默认格式 http://www.baidu.com"> 
							</span>
							</span>
						</div>
						<!--  注释掉提示功能<span class="m-form__help">
														Please enter your postcode
													</span>-->
					</div>
				</div>
				<div class="form-group m-form__group row">
					<label class="col-lg-2 col-form-label"> 作者: </label>
					<div class="col-lg-3">
						<input type="text" class="form-control m-input" name="author" id="author" value="${article.author}"
							placeholder="作者名字">
					</div>
					<label class="col-lg-2 col-form-label"> 发布日期 </label>
					<div class="col-lg-3">
						<div class="input-group date" id="m_datetimepicker_1_validate">
							<input type="text" class="form-control m-input" value="${article.releaseTimeStr}" readonly="readonly" name="releaseTimeStr" id="releaseTime"
								placeholder="选择发布日期"> <span
								class="input-group-addon"> <i
								class="la la-calendar-check-o glyphicon-th"></i>
							</span>
						</div>
					</div>
				</div>

				<div class="form-group m-form__group row">
					<label class="col-lg-2 col-form-label"> 关键字: </label>
					<div class="col-lg-3">
						<input type="text" class="form-control m-input" name="tags" id="tags" value="${article.tags}"
							placeholder="关键字 以,分割">
					</div>
					<label class="col-lg-2 col-form-label"> 文章类型 </label>
					<div class="col-lg-3" id="seldiv">
						<select class="form-control" name="articleType" id="articleType">
										<option value="1">
											新闻
										</option>
										<option value="2">
											通知
										</option>
									</select>
					</div>
				</div>

				<div class="form-group m-form__group row">
					<label class="col-form-label col-lg-2">摘要 </label>
					<div class="col-lg-8">
						<textarea class="form-control" rows="3" id="previewabstract" name="previewabstract"
							style="overflow: hidden; word-wrap: break-word; resize: none; height: 88px;">${article.previewabstract}</textarea>
					</div>
				</div>
				<div class="form-group m-form__group row">
					<label class="col-form-label col-lg-2">内容</label>
					<div class="col-lg-8">
						<div id="updatesummernote">
							
						</div>
						<input type="hidden" name="content" id="content">
					</div>
				</div>


			</div>
			<div
				class="m-portlet__foot m-portlet__no-border m-portlet__foot--fit">
				<div class="m-form__actions m-form__actions--solid">
					<div class="row">
						<div class="col-lg-2"></div>
						<div class="col-lg-10">
							<button type="button" class="btn btn-success" onclick="validaUpdateForm()">提交</button>
							<button type="button" class="btn btn-secondary">返回</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		<!--end::Form-->
	</div>
	<!--End::Main Portlet-->
</div>
<!-- 初始化Dashboard，因为该页面是异步加载的div，加载时父页面已经完成所有元素的初始化，所以需要重新初始化页面中的元素 -->
<!-- 引入时间选择时间控件 <script src="<%=request.getContextPath()%>/js/bootstrap-select.js"></script>-->
<script src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.js"></script>

<script src="<%=request.getContextPath()%>/js/select2.js"></script>
<script src="<%=request.getContextPath()%>/js/summernote/summernote.js"></script>
<script src="<%=request.getContextPath()%>/js/summernote/lang/summernote-zh-CN.js"></script>
<script src="<%=request.getContextPath()%>/js/newsmanager.js"></script>
					<script type="text/javascript" charset="utf-8">
					//表单赋值 默认值
					$("#releaseTime").val(getNowFormatDate());
					 $('#updatesummernote').summernote({
	                    	height: 200,  
	                    	lang: 'zh-CN'
						});
					 $('#updatesummernote').summernote('code', '${article.content}');
                    //文本编辑器
                    </script>
