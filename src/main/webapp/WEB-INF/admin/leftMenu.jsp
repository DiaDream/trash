<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--
  ~ 版权所有 2018 ，xieyunbo.com
  --%>

<%--
  ~ 版权所有 2018 ，xieyunbo.com
  --%>

<!-- BEGIN: Aside Menu 左侧导航菜单 -->
<div id="m_ver_menu"
	class="m-aside-menu  m-aside-menu--skin-dark m-aside-menu--submenu-skin-dark "
	data-menu-vertical="true" data-menu-scrollable="false"
	data-menu-dropdown-timeout="500">
	<ul class="m-menu__nav  m-menu__nav--dropdown-submenu-arrow ">
		<li class="m-menu__item  m-menu__item--active" aria-haspopup="true">
			<a href="index.html" class="m-menu__link "> <i
				class="m-menu__link-icon flaticon-line-graph"></i> <span
				class="m-menu__link-title"> <span class="m-menu__link-wrap">
						<span class="m-menu__link-text"> 公告板 </span> <span
						class="m-menu__link-badge"> <span
							class="m-badge m-badge--danger"> 1 </span>
					</span>
				</span>
			</span>
		</a>
		</li>
		<li class="m-menu__section">
			<h4 class="m-menu__section-text">一级菜单</h4> <i
			class="m-menu__section-icon flaticon-more-v3"></i>
		</li>
		<li class="m-menu__item  m-menu__item--submenu" aria-haspopup="true"
			data-menu-submenu-toggle="hover"><a href="#"
			class="m-menu__link m-menu__toggle"> <i
				class="m-menu__link-icon flaticon-suitcase"></i> <span
				class="m-menu__link-text"> 二级菜单 </span> <i
				class="m-menu__ver-arrow la la-angle-right"></i>
		</a>
			<div class="m-menu__submenu">
				<span class="m-menu__arrow"></span>
				<ul class="m-menu__subnav">
					<li class="m-menu__item  m-menu__item--parent" aria-haspopup="true">
						<a href="#" class="m-menu__link "> <span
							class="m-menu__link-text"> 三级菜单 </span>
					</a>
					</li>
					<li class="m-menu__item  m-menu__item--submenu"
						aria-haspopup="true" data-menu-submenu-toggle="hover"><a
						href="#" class="m-menu__link m-menu__toggle"> <i
							class="m-menu__link-bullet m-menu__link-bullet--dot"> <span></span>
						</i> <span class="m-menu__link-text"> User Pages </span> <i
							class="m-menu__ver-arrow la la-angle-right"></i>
					</a>
						<div class="m-menu__submenu">
							<span class="m-menu__arrow"></span>
							<ul class="m-menu__subnav">
								<li class="m-menu__item " aria-haspopup="true"><a
									target="_blank" href="#"
									class="m-menu__link "> <i
										class="m-menu__link-bullet m-menu__link-bullet--dot"> <span></span>
									</i> <span class="m-menu__link-text"> Login - 1 </span>
								</a></li>
								<li class="m-menu__item " aria-haspopup="true"><a
									target="_blank" href="#"
									class="m-menu__link "> <i
										class="m-menu__link-bullet m-menu__link-bullet--dot"> <span></span>
									</i> <span class="m-menu__link-text"> Login - 2 </span>
								</a></li>
								<li class="m-menu__item " aria-haspopup="true"><a
									target="_blank" href="#"
									class="m-menu__link "> <i
										class="m-menu__link-bullet m-menu__link-bullet--dot"> <span></span>
									</i> <span class="m-menu__link-text"> Login - 3 </span>
								</a></li>
							</ul>
						</div></li>
					<li class="m-menu__item  m-menu__item--submenu"
						aria-haspopup="true" data-menu-submenu-toggle="hover"><a
						href="#" class="m-menu__link m-menu__toggle"> <i
							class="m-menu__link-bullet m-menu__link-bullet--dot"> <span></span>
						</i> <span class="m-menu__link-text"> Error Pages </span> <i
							class="m-menu__ver-arrow la la-angle-right"></i>
					</a>
						<div class="m-menu__submenu">
							<span class="m-menu__arrow"></span>
							<ul class="m-menu__subnav">
								<li class="m-menu__item " aria-haspopup="true"><a
									target="_blank" href="#"
									class="m-menu__link "> <i
										class="m-menu__link-bullet m-menu__link-bullet--dot"> <span></span>
									</i> <span class="m-menu__link-text"> Error 1 </span>
								</a></li>
								<li class="m-menu__item " aria-haspopup="true"><a
									target="_blank" href="#"
									class="m-menu__link "> <i
										class="m-menu__link-bullet m-menu__link-bullet--dot"> <span></span>
									</i> <span class="m-menu__link-text"> Error 2 </span>
								</a></li>
								<li class="m-menu__item " aria-haspopup="true"><a
									target="_blank" href="#"
									class="m-menu__link "> <i
										class="m-menu__link-bullet m-menu__link-bullet--dot"> <span></span>
									</i> <span class="m-menu__link-text"> Error 3 </span>
								</a></li>
							</ul>
						</div></li>
				</ul>
			</div></li>
	</ul>
</div>
<!-- END: Aside Menu 左侧导航菜单 -->