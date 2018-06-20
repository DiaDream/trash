<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- BEGIN: Subheader -->
<!-- END: Subheader -->
<script src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.js"></script>
<div class="m-content">
	<div class="row">
		<div class="col-lg-12">
			<div class="m-portlet m-portlet--mobile ">
				<div class="m-portlet__head">
					<div class="m-portlet__head-caption">
						<div class="m-portlet__head-title">
							<h3 class="m-portlet__head-text">公司新闻</h3>
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
															class="m-nav__section-text"> 新闻管理</span></li>
														<li class="m-nav__item"><a href="javascript:;" onclick="toAddpage()"
															class="m-nav__link"> <i
																class="m-nav__link-icon flaticon-add"></i> <span
																class="m-nav__link-text"> 新建新闻 </span>
														</a></li>
														<li class="m-nav__item"><a href=""
															class="m-nav__link"> <i
																class="m-nav__link-icon flaticon-chat-1"></i> <span
																class="m-nav__link-text"> 新建栏目</span>
														</a></li>
														<li class="m-nav__item"><a href=""
															class="m-nav__link"> <i
																class="m-nav__link-icon flaticon-refresh"></i> <span
																class="m-nav__link-text"> 刷新新闻</span>
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
				<!-- 搜索框 -->
				<div class="m-portlet__body" style="padding-bottom: 0px;padding-top: 0px;">
				<div class="m-portlet__head-caption">
				<form id="searchNewsForm" class="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed">
					<div class="form-group m-form__group row" style="padding-bottom: 0px;">
					<!-- end 选择栏目框 -->
					<label class="col-form-label"> 新闻标题 </label>
					<div class="col-lg-3">
						<input type="text" placeholder="标题"   class="form-control m-input" name="title">
					</div>
					<label class="col-form-label"> 作者 </label>
					<div class="col-lg-3">
						<input type="text" placeholder="作者"   class="form-control m-input" name="author">
					</div>
					<label class="col-form-label"> 发布时间 </label>
					<div class="col-lg-3">
						<div class="input-daterange input-group" id="m_datepicker_5">
												<input type="text" class="form-control m-input" name="start" />
												<span class="input-group-addon">
													<i class="la la-ellipsis-h"></i>
												</span>
												<input type="text" class="form-control" name="end" />
						</div>
					</div>
					<input type="hidden" value="1" name="curPage" id="cur_input">
					<button type="button" id="btn_search" onclick="searchNews('<%=request.getContextPath()%>')" class="btn m-btn--square  btn-success m-btn--wide">
							查询
					</button>
					</div>
					</form>
				</div>
				</div>
				<!-- searchend -->
				<div class="m-portlet__body">
					<!--begin: Datatable -->
					<table class="table">
						<thead class="thead-default">
							<tr>
								<th>编号</th>
								<th>标题</th>
								<th>栏目</th>
								<th>发布时间</th>
								<th>发布人</th>
								<th>点击数量</th>
								<th>文章状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="tb_news">
							<!--  <tr>
								<th scope="row">1</th>
								<td>十二届国际脑血管病高峰论坛胜利闭幕
								<span class="m-badge m-badge--danger m-badge--wide">
								荐
								</span></td>
								<td>公司动态</td>
								<td>2018-06-07 09:26</td>
								<td>管理员</td>
								<td>22</td>
								<td>
								<span class="m-badge m-badge--danger m-badge--wide">
								有效
								</span>
								</td>
								<td>
								<a href="#" class="m-portlet__nav-link btn m-btn m-btn--hover-danger m-btn--icon m-btn--icon-only m-btn--pill" title="Delete">
								 <i class="la la-trash"></i>
								</a>
								</td>
							</tr>
							<tr>
								<th scope="row">1</th>
								<td>十二届国际脑血管病高峰论坛胜利闭幕
								</td>
								<td>公司动态</td>
								<td>2018-06-07 09:26</td>
								<td>管理员</td>
								<td>22</td>
								<td>
								<span class="m-badge m-badge--danger m-badge--wide">
								有效
								</span>
								</td>
								<td>
								<a href="#" class="m-portlet__nav-link btn m-btn m-btn--hover-danger m-btn--icon m-btn--icon-only m-btn--pill" title="Edit details">
								   <i class="la la-thumbs-o-up"></i>                        
								</a>
								<a href="#" class="m-portlet__nav-link btn m-btn m-btn--hover-accent m-btn--icon m-btn--icon-only m-btn--pill" title="Edit details">
								   <i class="la la-edit"></i>                        
								</a>
								</td>
							</tr>
							<tr>
								<th scope="row">1</th>
								<td>十二届国际脑血管病高峰论坛胜利闭幕
								</td>
								<td>公司动态</td>
								<td>2018-06-07 09:26</td>
								<td>管理员</td>
								<td>22</td>
								<td>
								<span class="m-badge m-badge--danger m-badge--wide">
								有效
								</span>
								</td>
								<td>
								<a href="#" class="m-portlet__nav-link btn m-btn m-btn--hover-danger m-btn--icon m-btn--icon-only m-btn--pill" title="Delete">
								 <i class="la la-trash"></i>
								</a>
								</td>
							</tr>-->
						</tbody>
					</table>
					
					<div class="clearfix">
					<div id="pagenation" style="float: right">
						<!--<button type="button" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">
											《
						</button>
						<button type="button" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">
											1
						</button>
						<button type="button" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">
										...
						</button>
						<button type="button" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">
										13
						</button>
						<button type="button" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">
										14
						</button>
						<button type="button" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">
										...
						</button>
						<button type="button" style="padding: 5px 10px" class="btn m-btn--square  btn-outline-metal">
											》
						</button>
					</div>-->
					</div>
					<!--end: Datatable -->
				</div>
			</div>
		</div>
	</div>
</div>

<script src="<%=request.getContextPath()%>/js/newsmanager.js"></script>
<script>
searchNews('<%=request.getContextPath()%>');
</script>