<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<%--
  ~ 版权所有 2018 ，xieyunbo.com
  --%>

<%--
  ~ 版权所有 2018 ，xieyunbo.com
  --%>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>CMS后台管理</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-grid.min.css" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-reboot.min.css" />
        <link href="<%=request.getContextPath()%>/css/vendors.bundle.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/css/style.bundle.css" rel="stylesheet" type="text/css" />
        <link href="<%=request.getContextPath()%>/css/fullcalendar.bundle.css" rel="stylesheet" type="text/css" />
        <script src="<%=request.getContextPath()%>/js/jquery-3.3.1.slim.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/popper.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/bootstrap.bundle.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/vendors.bundle.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/js/fullcalendar.bundle.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/js/dashboard.js" type="text/javascript"></script>
        <script type="text/javascript" charset="utf-8">
        function loadDashboard ()
        {
            
            
            $.ajax(
                    {
                        url : "<%=request.getContextPath()%>/news/newsList",
                        dataType : "html",
                        type : "post",
                        error : function (data)
                        {
                            alert('与服务器的连接发生异常！');
                            return;
                        },
                        success : function (data)
                        {
                            $("#mainContent").html(data);
                            Dashboard.init();
                            // 这句不加左侧菜单的子菜单无法展现
                            mLayout.init();
                        }
                    });
        }
        function loadTopMenu ()
        {
            $.ajax(
                    {
                        url : "<%=request.getContextPath()%>/admin/getTopMenu",
                        dataType : "html",
                        type : "post",
                        error : function (data)
                        {
                            alert('与服务器的连接发生异常！');
                            return;
                        },
                        success : function (data)
                        {
                            $("#m_header_nav").html(data);
                            loadDashboard ();
                            
                        }
                    });
        }
        function loadLeftMenu ()
        {
            $.ajax(
                    {
                        url : "<%=request.getContextPath()%>/admin/getLeftMenu",
                        dataType : "html",
                        type : "post",
                        error : function (data)
                        {
                            alert('与服务器的连接发生异常！');
                            return;
                        },
                        success : function (data)
                        {
                            $("#m_aside_left").html(data);
                            loadDashboard ();
                            
                        }
                    });
        }
        function toProfile ()
        {
            $.ajax(
                    {
                        url : "<%=request.getContextPath()%>/admin/toProfile",
                        dataType : "html",
                        type : "post",
                        error : function (data)
                        {
                            alert('与服务器的连接发生异常！');
                            return;
                        },
                        success : function (data)
                        {
                            $("#mainContent").html(data);
                        }
                    });
        }
        function toTest ()
        {
            $.ajax(
                    {
                        url : "<%=request.getContextPath()%>/admin/toTest",
                        dataType : "html",
                        type : "post",
                        error : function (data)
                        {
                            alert('与服务器的连接发生异常！');
                            return;
                        },
                        success : function (data)
                        {
                            $("#mainContent").html(data);
                        }
                    });
        }
        </script>
    </head>

   <body onload="loadLeftMenu ()" class="m-page--fluid m--skin- m-content--skin-light2 m-header--fixed m-header--fixed-mobile m-aside-left--enabled m-aside-left--skin-dark m-aside-left--offcanvas m-footer--push m-aside--offcanvas-default">
        <div class="m-grid m-grid--hor m-grid--root m-page">
            <!-- BEGIN: Header -->
            <header class="m-grid__item    m-header " data-minimize-offset="200" data-minimize-mobile-offset="200">
                <div class="m-container m-container--fluid m-container--full-height">
                    <div class="m-stack m-stack--ver m-stack--desktop">
                        <!-- BEGIN: Brand -->
                        <div class="m-stack__item m-brand  m-brand--skin-dark ">
                            <div class="m-stack m-stack--ver m-stack--general">
                                <div class="m-stack__item m-stack__item--middle m-brand__logo">
                                    <a href="<%=request.getContextPath()%>/admin/index" class="m-brand__logo-wrapper">
                                        <img alt="" style="width:40px" src="<%=request.getContextPath()%>/images/logo64.png" />
                                    </a>
                                </div>
                                <div class="m-stack__item m-stack__item--middle m-brand__tools">
                                    <!-- BEGIN: Left Aside Minimize Toggle 桌面端左侧菜单隐藏、显示按钮 -->
                                    <a href="javascript:;" id="m_aside_left_minimize_toggle" class="m-brand__icon m-brand__toggler m-brand__toggler--left m--visible-desktop-inline-block">
                                       <span></span>
                                    </a>
                                    <!-- END -->
                                    <!-- BEGIN: Responsive Aside Left Menu Toggler 移动端左侧菜单显示按钮 -->
                                    <a href="javascript:;" id="m_aside_left_offcanvas_toggle" class="m-brand__icon m-brand__toggler m-brand__toggler--left m--visible-tablet-and-mobile-inline-block">
                                        <span></span>
                                    </a>
                                    <!-- END -->
                                    <!-- BEGIN: Responsive Header Menu Toggler 桌面端的左侧顶部菜单在移动端的显示按钮 -->
                                    <a id="m_aside_header_menu_mobile_toggle" href="javascript:;" class="m-brand__icon m-brand__toggler m--visible-tablet-and-mobile-inline-block">
                                        <span></span>
                                    </a>
                                    <!-- END -->
                                    <!-- BEGIN: Topbar Toggler 桌面端的右侧顶部菜单在移动端的隐藏显示按钮 -->
                                    <a id="m_aside_header_topbar_mobile_toggle" href="javascript:;" class="m-brand__icon m--visible-tablet-and-mobile-inline-block">
                                        <i class="flaticon-more"></i>
                                    </a>
                                    <!-- BEGIN: Topbar Toggler -->
                                </div>
                            </div>
                        </div>
                        <!-- END: Brand -->
                        <!-- begin 顶部菜单栏 -->
                        <div class="m-stack__item m-stack__item--fluid m-header-head" id="m_header_nav">
                        <!-- BEGIN: Horizontal Menu -->
<!-- BEGIN: Topbar Toggler 桌面端的左侧顶部菜单在移动端的隐藏按钮 -->
<button
    class="m-aside-header-menu-mobile-close  m-aside-header-menu-mobile-close--skin-dark "
    id="m_aside_header_menu_mobile_close_btn">
    <i class="la la-close"></i>
</button>
<!-- END -->
<!-- BEGIN: 左侧顶部菜单 -->
<div id="m_header_menu"
    class="m-header-menu m-aside-header-menu-mobile m-aside-header-menu-mobile--offcanvas  m-header-menu--skin-light m-header-menu--submenu-skin-light m-aside-header-menu-mobile--skin-dark m-aside-header-menu-mobile--submenu-skin-dark ">
    <ul class="m-menu__nav  m-menu__nav--submenu-arrow ">
        <li class="m-menu__item  m-menu__item--submenu m-menu__item--rel"
            data-menu-submenu-toggle="click" data-redirect="true"
            aria-haspopup="true"><a href="#"
            class="m-menu__link m-menu__toggle"> <i
                class="m-menu__link-icon flaticon-add"></i> <span
                class="m-menu__link-text"> 操作 </span> <i
                class="m-menu__hor-arrow la la-angle-down"></i> <i
                class="m-menu__ver-arrow la la-angle-right"></i>
        </a>
            <div
                class="m-menu__submenu m-menu__submenu--classic m-menu__submenu--left">
                <span class="m-menu__arrow m-menu__arrow--adjust"></span>
                <ul class="m-menu__subnav">
                    <li class="m-menu__item " aria-haspopup="true"><a
                        href="header/actions.html" class="m-menu__link "> <i
                            class="m-menu__link-icon flaticon-file"></i> <span
                            class="m-menu__link-text"> Create New Post </span>
                    </a></li>
                    <li class="m-menu__item " data-redirect="true" aria-haspopup="true">
                        <a href="header/actions.html" class="m-menu__link "> <i
                            class="m-menu__link-icon flaticon-diagram"></i> <span
                            class="m-menu__link-title"> <span
                                class="m-menu__link-wrap"> <span
                                    class="m-menu__link-text"> Generate Reports </span> <span
                                    class="m-menu__link-badge"> <span
                                        class="m-badge m-badge--success"> 2 </span>
                                </span>
                            </span>
                        </span>
                    </a>
                    </li>
                    <li class="m-menu__item  m-menu__item--submenu"
                        data-menu-submenu-toggle="hover" data-redirect="true"
                        aria-haspopup="true"><a href="#"
                        class="m-menu__link m-menu__toggle"> <i
                            class="m-menu__link-icon flaticon-business"></i> <span
                            class="m-menu__link-text"> Manage Orders </span> <i
                            class="m-menu__hor-arrow la la-angle-right"></i> <i
                            class="m-menu__ver-arrow la la-angle-right"></i>
                    </a>
                        <div
                            class="m-menu__submenu m-menu__submenu--classic m-menu__submenu--right">
                            <span class="m-menu__arrow "></span>
                            <ul class="m-menu__subnav">
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <span class="m-menu__link-text">
                                            Latest Orders </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <span class="m-menu__link-text">
                                            Pending Orders </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <span class="m-menu__link-text">
                                            Processed Orders </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <span class="m-menu__link-text">
                                            Delivery Reports </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <span class="m-menu__link-text">
                                            Payments </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <span class="m-menu__link-text">
                                            Customers </span>
                                </a></li>
                            </ul>
                        </div></li>
                    <li class="m-menu__item  m-menu__item--submenu"
                        data-menu-submenu-toggle="hover" data-redirect="true"
                        aria-haspopup="true"><a href="#"
                        class="m-menu__link m-menu__toggle"> <i
                            class="m-menu__link-icon flaticon-chat-1"></i> <span
                            class="m-menu__link-text"> Customer Feedbacks </span> <i
                            class="m-menu__hor-arrow la la-angle-right"></i> <i
                            class="m-menu__ver-arrow la la-angle-right"></i>
                    </a>
                        <div
                            class="m-menu__submenu m-menu__submenu--classic m-menu__submenu--right">
                            <span class="m-menu__arrow "></span>
                            <ul class="m-menu__subnav">
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <span class="m-menu__link-text">
                                            Customer Feedbacks </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <span class="m-menu__link-text">
                                            Supplier Feedbacks </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <span class="m-menu__link-text">
                                            Reviewed Feedbacks </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <span class="m-menu__link-text">
                                            Resolved Feedbacks </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <span class="m-menu__link-text">
                                            Feedback Reports </span>
                                </a></li>
                            </ul>
                        </div></li>
                    <li class="m-menu__item " data-redirect="true" aria-haspopup="true">
                        <a href="header/actions.html" class="m-menu__link "> <i
                            class="m-menu__link-icon flaticon-users"></i> <span
                            class="m-menu__link-text"> Register Member </span>
                    </a>
                    </li>
                </ul>
            </div></li>
        <li class="m-menu__item  m-menu__item--submenu m-menu__item--rel"
            data-menu-submenu-toggle="click" data-redirect="true"
            aria-haspopup="true"><a href="#"
            class="m-menu__link m-menu__toggle"> <i
                class="m-menu__link-icon flaticon-line-graph"></i> <span
                class="m-menu__link-text"> Reports </span> <i
                class="m-menu__hor-arrow la la-angle-down"></i> <i
                class="m-menu__ver-arrow la la-angle-right"></i>
        </a>
            <div
                class="m-menu__submenu  m-menu__submenu--fixed m-menu__submenu--left"
                style="width: 1000px">
                <span class="m-menu__arrow m-menu__arrow--adjust"></span>
                <div class="m-menu__subnav">
                    <ul class="m-menu__content">
                        <li class="m-menu__item">
                            <h3 class="m-menu__heading m-menu__toggle">
                                <span class="m-menu__link-text"> Finance Reports </span> <i
                                    class="m-menu__ver-arrow la la-angle-right"></i>
                            </h3>
                            <ul class="m-menu__inner">
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-icon flaticon-map"></i> <span
                                        class="m-menu__link-text"> Annual Reports </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-icon flaticon-user"></i> <span
                                        class="m-menu__link-text"> HR Reports </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-icon flaticon-clipboard"></i> <span
                                        class="m-menu__link-text"> IPO Reports </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-icon flaticon-graphic-1"></i> <span
                                        class="m-menu__link-text"> Finance Margins </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-icon flaticon-graphic-2"></i> <span
                                        class="m-menu__link-text"> Revenue Reports </span>
                                </a></li>
                            </ul>
                        </li>
                        <li class="m-menu__item">
                            <h3 class="m-menu__heading m-menu__toggle">
                                <span class="m-menu__link-text"> Project Reports </span> <i
                                    class="m-menu__ver-arrow la la-angle-right"></i>
                            </h3>
                            <ul class="m-menu__inner">
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-bullet m-menu__link-bullet--line"> <span></span>
                                    </i> <span class="m-menu__link-text"> Coca Cola CRM </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-bullet m-menu__link-bullet--line"> <span></span>
                                    </i> <span class="m-menu__link-text"> Delta Airlines Booking
                                            Site </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-bullet m-menu__link-bullet--line"> <span></span>
                                    </i> <span class="m-menu__link-text"> Malibu Accounting </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-bullet m-menu__link-bullet--line"> <span></span>
                                    </i> <span class="m-menu__link-text"> Vineseed Website
                                            Rewamp </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-bullet m-menu__link-bullet--line"> <span></span>
                                    </i> <span class="m-menu__link-text"> Zircon Mobile App </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-bullet m-menu__link-bullet--line"> <span></span>
                                    </i> <span class="m-menu__link-text"> Mercury CMS </span>
                                </a></li>
                            </ul>
                        </li>
                        <li class="m-menu__item">
                            <h3 class="m-menu__heading m-menu__toggle">
                                <span class="m-menu__link-text"> HR Reports </span> <i
                                    class="m-menu__ver-arrow la la-angle-right"></i>
                            </h3>
                            <ul class="m-menu__inner">
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-bullet m-menu__link-bullet--dot"> <span></span>
                                    </i> <span class="m-menu__link-text"> Staff Directory </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-bullet m-menu__link-bullet--dot"> <span></span>
                                    </i> <span class="m-menu__link-text"> Client Directory </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-bullet m-menu__link-bullet--dot"> <span></span>
                                    </i> <span class="m-menu__link-text"> Salary Reports </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-bullet m-menu__link-bullet--dot"> <span></span>
                                    </i> <span class="m-menu__link-text"> Staff Payslips </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-bullet m-menu__link-bullet--dot"> <span></span>
                                    </i> <span class="m-menu__link-text"> Corporate Expenses </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-bullet m-menu__link-bullet--dot"> <span></span>
                                    </i> <span class="m-menu__link-text"> Project Expenses </span>
                                </a></li>
                            </ul>
                        </li>
                        <li class="m-menu__item">
                            <h3 class="m-menu__heading m-menu__toggle">
                                <span class="m-menu__link-text"> Reporting Apps </span> <i
                                    class="m-menu__ver-arrow la la-angle-right"></i>
                            </h3>
                            <ul class="m-menu__inner">
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <span class="m-menu__link-text">
                                            Report Adjusments </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <span class="m-menu__link-text">
                                            Sources & Mediums </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <span class="m-menu__link-text">
                                            Reporting Settings </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <span class="m-menu__link-text">
                                            Conversions </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <span class="m-menu__link-text">
                                            Report Flows </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <span class="m-menu__link-text">
                                            Audit & Logs </span>
                                </a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div></li>
        <li class="m-menu__item  m-menu__item--submenu m-menu__item--rel"
            data-menu-submenu-toggle="click" data-redirect="true"
            aria-haspopup="true"><a href="#"
            class="m-menu__link m-menu__toggle"> <i
                class="m-menu__link-icon flaticon-paper-plane"></i> <span
                class="m-menu__link-title"> <span class="m-menu__link-wrap">
                        <span class="m-menu__link-text"> Apps </span> <span
                        class="m-menu__link-badge"> <span
                            class="m-badge m-badge--brand m-badge--wide"> new </span>
                    </span>
                </span>
            </span> <i class="m-menu__hor-arrow la la-angle-down"></i> <i
                class="m-menu__ver-arrow la la-angle-right"></i>
        </a>
            <div
                class="m-menu__submenu m-menu__submenu--classic m-menu__submenu--left">
                <span class="m-menu__arrow m-menu__arrow--adjust"></span>
                <ul class="m-menu__subnav">
                    <li class="m-menu__item " data-redirect="true" aria-haspopup="true">
                        <a href="header/actions.html" class="m-menu__link "> <i
                            class="m-menu__link-icon flaticon-business"></i> <span
                            class="m-menu__link-text"> eCommerce </span>
                    </a>
                    </li>
                    <li class="m-menu__item  m-menu__item--submenu"
                        data-menu-submenu-toggle="hover" data-redirect="true"
                        aria-haspopup="true"><a href="crud/datatable_v1.html"
                        class="m-menu__link m-menu__toggle"> <i
                            class="m-menu__link-icon flaticon-computer"></i> <span
                            class="m-menu__link-text"> Audience </span> <i
                            class="m-menu__hor-arrow la la-angle-right"></i> <i
                            class="m-menu__ver-arrow la la-angle-right"></i>
                    </a>
                        <div
                            class="m-menu__submenu m-menu__submenu--classic m-menu__submenu--right">
                            <span class="m-menu__arrow "></span>
                            <ul class="m-menu__subnav">
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-icon flaticon-users"></i> <span
                                        class="m-menu__link-text"> Active Users </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-icon flaticon-interface-1"></i> <span
                                        class="m-menu__link-text"> User Explorer </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-icon flaticon-lifebuoy"></i> <span
                                        class="m-menu__link-text"> Users Flows </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-icon flaticon-graphic-1"></i> <span
                                        class="m-menu__link-text"> Market Segments </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-icon flaticon-graphic"></i> <span
                                        class="m-menu__link-text"> User Reports </span>
                                </a></li>
                            </ul>
                        </div></li>
                    <li class="m-menu__item " data-redirect="true" aria-haspopup="true">
                        <a href="header/actions.html" class="m-menu__link "> <i
                            class="m-menu__link-icon flaticon-map"></i> <span
                            class="m-menu__link-text"> Marketing </span>
                    </a>
                    </li>
                    <li class="m-menu__item " data-redirect="true" aria-haspopup="true">
                        <a href="header/actions.html" class="m-menu__link "> <i
                            class="m-menu__link-icon flaticon-graphic-2"></i> <span
                            class="m-menu__link-title"> <span
                                class="m-menu__link-wrap"> <span
                                    class="m-menu__link-text"> Campaigns </span> <span
                                    class="m-menu__link-badge"> <span
                                        class="m-badge m-badge--success"> 3 </span>
                                </span>
                            </span>
                        </span>
                    </a>
                    </li>
                    <li class="m-menu__item  m-menu__item--submenu"
                        data-menu-submenu-toggle="hover" data-redirect="true"
                        aria-haspopup="true"><a href="#"
                        class="m-menu__link m-menu__toggle"> <i
                            class="m-menu__link-icon flaticon-infinity"></i> <span
                            class="m-menu__link-text"> Cloud Manager </span> <i
                            class="m-menu__hor-arrow la la-angle-right"></i> <i
                            class="m-menu__ver-arrow la la-angle-right"></i>
                    </a>
                        <div
                            class="m-menu__submenu m-menu__submenu--classic m-menu__submenu--left">
                            <span class="m-menu__arrow "></span>
                            <ul class="m-menu__subnav">
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-icon flaticon-add"></i> <span
                                        class="m-menu__link-title"> <span
                                            class="m-menu__link-wrap"> <span
                                                class="m-menu__link-text"> File Upload </span> <span
                                                class="m-menu__link-badge"> <span
                                                    class="m-badge m-badge--danger"> 3 </span>
                                            </span>
                                        </span>
                                    </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-icon flaticon-signs-1"></i> <span
                                        class="m-menu__link-text"> File Attributes </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-icon flaticon-folder"></i> <span
                                        class="m-menu__link-text"> Folders </span>
                                </a></li>
                                <li class="m-menu__item " data-redirect="true"
                                    aria-haspopup="true"><a href="header/actions.html"
                                    class="m-menu__link "> <i
                                        class="m-menu__link-icon flaticon-cogwheel-2"></i> <span
                                        class="m-menu__link-text"> System Settings </span>
                                </a></li>
                            </ul>
                        </div></li>
                </ul>
            </div></li>
    </ul>
    <!-- END -->
</div>
<!-- END: Horizontal Menu -->
<!-- BEGIN: Topbar 右侧顶部菜单 -->
<div id="m_header_topbar"
    class="m-topbar  m-stack m-stack--ver m-stack--general">
    <div class="m-stack__item m-topbar__nav-wrapper">
        <ul class="m-topbar__nav m-nav m-nav--inline">
            <!-- begin 搜索按钮 -->
            <li
                class="m-nav__item m-dropdown m-dropdown--large m-dropdown--arrow m-dropdown--align-center m-dropdown--mobile-full-width m-dropdown--skin-light    m-list-search m-list-search--skin-light"
                data-dropdown-toggle="click" data-dropdown-persistent="true"
                id="m_quicksearch" data-search-type="dropdown"><a href="#"
                class="m-nav__link m-dropdown__toggle"> <span
                    class="m-nav__link-icon"> <i class="flaticon-search-1"></i>
                </span>
            </a> <!-- begin 搜索框 -->
                <div class="m-dropdown__wrapper">
                    <span class="m-dropdown__arrow m-dropdown__arrow--center"></span>
                    <div class="m-dropdown__inner ">
                        <div class="m-dropdown__header">
                            <form class="m-list-search__form">
                                <div class="m-list-search__form-wrapper">
                                    <!-- 搜索输入框 -->
                                    <span class="m-list-search__form-input-wrapper"> <input
                                        id="m_quicksearch_input" autocomplete="off" type="text"
                                        name="q" class="m-list-search__form-input" value=""
                                        placeholder="Search...">
                                    </span>
                                    <!-- 搜索输入框右边的X -->
                                    <span class="m-list-search__form-icon-close"
                                        id="m_quicksearch_close"> <i class="la la-remove"></i>
                                    </span>
                                </div>
                            </form>
                        </div>
                        <!-- begin 搜索内容显示div -->
                        <div class="m-dropdown__body">
                            <div class="m-dropdown__scrollable m-scrollable"
                                data-scrollable="true" data-max-height="300"
                                data-mobile-max-height="200">
                                <div class="m-dropdown__content"></div>
                            </div>
                        </div>
                        <!-- end 搜索内容显示div -->
                    </div>
                </div> <!-- end 搜索框 --></li>
            <!-- end 搜索按钮 -->
            <!-- 消息通知div弹出菜单(点右上角三个点以后出现的铃铛以及点铃铛后出现的div) -->
            <li
                class="m-nav__item m-topbar__notifications m-topbar__notifications--img m-dropdown m-dropdown--large m-dropdown--header-bg-fill m-dropdown--arrow m-dropdown--align-center  m-dropdown--mobile-full-width"
                data-dropdown-toggle="click" data-dropdown-persistent="true"><a
                href="http://www.baidu.com" class="m-nav__link m-dropdown__toggle"
                id="m_topbar_notification_icon"> <span
                    class="m-nav__link-badge m-badge m-badge--accent"> 3 </span> <span
                    class="m-nav__link-icon"> <i class="flaticon-music-2"></i>
                </span>
            </a>
                <div class="m-dropdown__wrapper">
                    <span class="m-dropdown__arrow m-dropdown__arrow--center"></span>
                    <div class="m-dropdown__inner">
                        <div class="m-dropdown__header m--align-center"
                            style="background: url(<%=request.getContextPath()%>/images/notification_bg.jpg); background-size: cover;">
                            <span class="m-dropdown__header-title"> 9 未读 </span> <span
                                class="m-dropdown__header-subtitle"> 用户通知 </span>
                        </div>
                        <div class="m-dropdown__body">
                            <div class="m-dropdown__content">
                                <ul class="nav nav-tabs m-tabs m-tabs-line m-tabs-line--brand"
                                    role="tablist">
                                    <li class="nav-item m-tabs__item"><a
                                        class="nav-link m-tabs__link active" data-toggle="tab"
                                        href="#topbar_notifications_notifications" role="tab">
                                            Alerts </a></li>
                                    <li class="nav-item m-tabs__item"><a
                                        class="nav-link m-tabs__link" data-toggle="tab"
                                        href="#topbar_notifications_events" role="tab"> Events </a></li>
                                    <li class="nav-item m-tabs__item"><a
                                        class="nav-link m-tabs__link" data-toggle="tab"
                                        href="#topbar_notifications_logs" role="tab"> Logs </a></li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane active"
                                        id="topbar_notifications_notifications" role="tabpanel">
                                        <div class="m-scrollable" data-scrollable="true"
                                            data-max-height="250" data-mobile-max-height="200">
                                            <div class="m-list-timeline m-list-timeline--skin-light">
                                                <div class="m-list-timeline__items">
                                                    <div class="m-list-timeline__item">
                                                        <span
                                                            class="m-list-timeline__badge -m-list-timeline__badge--state-success"></span>
                                                        <span class="m-list-timeline__text"> 12 new users
                                                            registered </span> <span class="m-list-timeline__time">
                                                            Just now </span>
                                                    </div>
                                                    <div class="m-list-timeline__item">
                                                        <span class="m-list-timeline__badge"></span> <span
                                                            class="m-list-timeline__text"> System shutdown <span
                                                            class="m-badge m-badge--success m-badge--wide">
                                                                pending </span>
                                                        </span> <span class="m-list-timeline__time"> 14 mins </span>
                                                    </div>
                                                    <div class="m-list-timeline__item">
                                                        <span class="m-list-timeline__badge"></span> <span
                                                            class="m-list-timeline__text"> New invoice
                                                            received </span> <span class="m-list-timeline__time"> 20
                                                            mins </span>
                                                    </div>
                                                    <div class="m-list-timeline__item">
                                                        <span class="m-list-timeline__badge"></span> <span
                                                            class="m-list-timeline__text"> DB overloaded 80% <span
                                                            class="m-badge m-badge--info m-badge--wide">
                                                                settled </span>
                                                        </span> <span class="m-list-timeline__time"> 1 hr </span>
                                                    </div>
                                                    <div class="m-list-timeline__item">
                                                        <span class="m-list-timeline__badge"></span> <span
                                                            class="m-list-timeline__text"> System error - <a
                                                            href="#" class="m-link"> Check </a>
                                                        </span> <span class="m-list-timeline__time"> 2 hrs </span>
                                                    </div>
                                                    <div class="m-list-timeline__item">
                                                        <span class="m-list-timeline__badge"></span> <span
                                                            class="m-list-timeline__text"> Production server
                                                            down </span> <span class="m-list-timeline__time"> 3 hrs </span>
                                                    </div>
                                                    <div class="m-list-timeline__item">
                                                        <span class="m-list-timeline__badge"></span> <span
                                                            class="m-list-timeline__text"> Production server
                                                            up </span> <span class="m-list-timeline__time"> 5 hrs </span>
                                                    </div>
                                                    <div class="m-list-timeline__item">
                                                        <span class="m-list-timeline__badge"></span> <span href=""
                                                            class="m-list-timeline__text"> New order received
                                                            <span class="m-badge m-badge--danger m-badge--wide">
                                                                urgent </span>
                                                        </span> <span class="m-list-timeline__time"> 7 hrs </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="topbar_notifications_events"
                                        role="tabpanel">
                                        <div class="m-scrollable" data-scrollable="true"
                                            data-max-height="250" data-mobile-max-height="200">
                                            <div class="m-list-timeline m-list-timeline--skin-light">
                                                <div class="m-list-timeline__items">
                                                    <div class="m-list-timeline__item">
                                                        <span
                                                            class="m-list-timeline__badge m-list-timeline__badge--state1-success"></span>
                                                        <a href="" class="m-list-timeline__text"> New order
                                                            received </a> <span class="m-list-timeline__time">
                                                            Just now </span>
                                                    </div>
                                                    <div class="m-list-timeline__item">
                                                        <span
                                                            class="m-list-timeline__badge m-list-timeline__badge--state1-danger"></span>
                                                        <a href="" class="m-list-timeline__text"> New invoice
                                                            received </a> <span class="m-list-timeline__time"> 20
                                                            mins </span>
                                                    </div>
                                                    <div class="m-list-timeline__item">
                                                        <span
                                                            class="m-list-timeline__badge m-list-timeline__badge--state1-success"></span>
                                                        <a href="" class="m-list-timeline__text"> Production
                                                            server up </a> <span class="m-list-timeline__time"> 5
                                                            hrs </span>
                                                    </div>
                                                    <div class="m-list-timeline__item">
                                                        <span
                                                            class="m-list-timeline__badge m-list-timeline__badge--state1-info"></span>
                                                        <a href="" class="m-list-timeline__text"> New order
                                                            received </a> <span class="m-list-timeline__time"> 7
                                                            hrs </span>
                                                    </div>
                                                    <div class="m-list-timeline__item">
                                                        <span
                                                            class="m-list-timeline__badge m-list-timeline__badge--state1-info"></span>
                                                        <a href="" class="m-list-timeline__text"> System
                                                            shutdown </a> <span class="m-list-timeline__time"> 11
                                                            mins </span>
                                                    </div>
                                                    <div class="m-list-timeline__item">
                                                        <span
                                                            class="m-list-timeline__badge m-list-timeline__badge--state1-info"></span>
                                                        <a href="" class="m-list-timeline__text"> Production
                                                            server down </a> <span class="m-list-timeline__time">
                                                            3 hrs </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="tab-pane" id="topbar_notifications_logs"
                                        role="tabpanel">
                                        <div class="m-stack m-stack--ver m-stack--general"
                                            style="min-height: 180px;">
                                            <div
                                                class="m-stack__item m-stack__item--center m-stack__item--middle">
                                                <span class=""> All caught up! <br> No new logs.
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div></li>
            <li
                class="m-nav__item m-topbar__quick-actions m-topbar__quick-actions--img m-dropdown m-dropdown--large m-dropdown--header-bg-fill m-dropdown--arrow m-dropdown--align-right m-dropdown--align-push m-dropdown--mobile-full-width m-dropdown--skin-light"
                data-dropdown-toggle="click"><a href="#"
                class="m-nav__link m-dropdown__toggle"> <span
                    class="m-nav__link-badge m-badge m-badge--dot m-badge--info m--hide"></span>
                    <span class="m-nav__link-icon"> <i class="flaticon-share"></i>
                </span>
            </a>
                <div class="m-dropdown__wrapper">
                    <span
                        class="m-dropdown__arrow m-dropdown__arrow--right m-dropdown__arrow--adjust"></span>
                    <div class="m-dropdown__inner">
                        <div class="m-dropdown__header m--align-center"
                            style="background: url(assets/app/media/img/misc/quick_actions_bg.jpg); background-size: cover;">
                            <span class="m-dropdown__header-title"> Quick Actions </span> <span
                                class="m-dropdown__header-subtitle"> Shortcuts </span>
                        </div>
                        <div class="m-dropdown__body m-dropdown__body--paddingless">
                            <div class="m-dropdown__content">
                                <div class="m-scrollable" data-scrollable="false"
                                    data-max-height="380" data-mobile-max-height="200">
                                    <div class="m-nav-grid m-nav-grid--skin-light">
                                        <div class="m-nav-grid__row">
                                            <a href="#" class="m-nav-grid__item"> <i
                                                class="m-nav-grid__icon flaticon-file"></i> <span
                                                class="m-nav-grid__text"> Generate Report </span>
                                            </a> <a href="#" class="m-nav-grid__item"> <i
                                                class="m-nav-grid__icon flaticon-time"></i> <span
                                                class="m-nav-grid__text"> Add New Event </span>
                                            </a>
                                        </div>
                                        <div class="m-nav-grid__row">
                                            <a href="#" class="m-nav-grid__item"> <i
                                                class="m-nav-grid__icon flaticon-folder"></i> <span
                                                class="m-nav-grid__text"> Create New Task </span>
                                            </a> <a href="#" class="m-nav-grid__item"> <i
                                                class="m-nav-grid__icon flaticon-clipboard"></i> <span
                                                class="m-nav-grid__text"> Completed Tasks </span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div></li>
            <!--
                                            点右上角三个点以后出现的当前登录人头像以及点头像后出现的操作
                                        -->
            <li
                class="m-nav__item m-topbar__user-profile m-topbar__user-profile--img  m-dropdown m-dropdown--medium m-dropdown--arrow m-dropdown--header-bg-fill m-dropdown--align-right m-dropdown--mobile-full-width m-dropdown--skin-light"
                data-dropdown-toggle="click"><a href="#"
                class="m-nav__link m-dropdown__toggle"> <span
                    class="m-topbar__userpic"> <img src="<%=request.getContextPath()%>/images/defaultUser.jpg"
                        class="m--img-rounded m--marginless m--img-centered" alt="" />
                </span> <span class="m-topbar__username m--hide"> Nick </span>
            </a>
                <div class="m-dropdown__wrapper">
                    <span
                        class="m-dropdown__arrow m-dropdown__arrow--right m-dropdown__arrow--adjust"></span>
                    <div class="m-dropdown__inner">
                        <div class="m-dropdown__header m--align-center"
                            style="background: url(<%=request.getContextPath()%>/images/user_profile_bg.jpg); background-size: cover;">
                            <div class="m-card-user m-card-user--skin-dark">
                                <div class="m-card-user__pic">
                                    <img src="<%=request.getContextPath()%>/images/defaultUser.jpg"
                                        class="m--img-rounded m--marginless" alt="" />
                                </div>
                                <div class="m-card-user__details">
                                    <span class="m-card-user__name m--font-weight-500">
                                        foxkissme </span> <a href=""
                                        class="m-card-user__email m--font-weight-300 m-link">
                                        foxkissme@qq.com </a>
                                </div>
                            </div>
                        </div>
                        <div class="m-dropdown__body">
                            <div class="m-dropdown__content">
                                <ul class="m-nav m-nav--skin-light">
                                    <li class="m-nav__section m--hide"><span
                                        class="m-nav__section-text"> Section </span></li>
                                    <li class="m-nav__item"><a onclick="toProfile ()"
                                        class="m-nav__link"> <i
                                            class="m-nav__link-icon flaticon-profile-1"></i> <span
                                            class="m-nav__link-title"> <span
                                                class="m-nav__link-wrap"> <span
                                                    class="m-nav__link-text"> 个人信息 </span> <span
                                                    class="m-nav__link-badge"> <span
                                                        class="m-badge m-badge--success"> 2 </span>
                                                </span>
                                            </span>
                                        </span>
                                    </a></li>
                                    <li class="m-nav__item"><a onclick="toProfile ()"
                                        class="m-nav__link"> <i
                                            class="m-nav__link-icon flaticon-share"></i> <span
                                            class="m-nav__link-text"> Activity </span>
                                    </a></li>
                                    <li class="m-nav__item"><a onclick="toProfile ()"
                                        class="m-nav__link"> <i
                                            class="m-nav__link-icon flaticon-chat-1"></i> <span
                                            class="m-nav__link-text"> Messages </span>
                                    </a></li>
                                    <li class="m-nav__separator m-nav__separator--fit"></li>
                                    <li class="m-nav__item"><a onclick="toProfile ()"
                                        class="m-nav__link"> <i
                                            class="m-nav__link-icon flaticon-info"></i> <span
                                            class="m-nav__link-text"> FAQ </span>
                                    </a></li>
                                    <li class="m-nav__item"><a onclick="toProfile ()"
                                        class="m-nav__link"> <i
                                            class="m-nav__link-icon flaticon-lifebuoy"></i> <span
                                            class="m-nav__link-text"> Support </span>
                                    </a></li>
                                    <li class="m-nav__separator m-nav__separator--fit"></li>
                                    <li class="m-nav__item"><a
                                        href="<%=request.getContextPath()%>/admin/toLogin"
                                        class="btn m-btn--pill    btn-secondary m-btn m-btn--custom m-btn--label-brand m-btn--bolder">
                                            注销 </a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div></li>
            <!-- 九个点 -->
            <li id="m_quick_sidebar_toggle" class="m-nav__item"><a href="#"
                class="m-nav__link m-dropdown__toggle"> <span
                    class="m-nav__link-icon"> <i class="flaticon-grid-menu"></i>
                </span>
            </a></li>
        </ul>
    </div>
</div>
                        </div>
                        <!-- end 顶部菜单栏 -->
                    </div>
                </div>
            </header>
            <!-- END: Header -->
            <!-- begin::Body -->
            <div class="m-grid__item m-grid__item--fluid m-grid m-grid--ver-desktop m-grid--desktop m-body">
                <!-- BEGIN: Left Aside -->
                <!-- BEGIN: 桌面端的左侧菜单在移动端的隐藏按钮 -->
                <button class="m-aside-left-close  m-aside-left-close--skin-dark " id="m_aside_left_close_btn">
                    <i class="la la-close"></i>
                </button>
                <!-- end -->
                <div id="m_aside_left" class="m-grid__item  m-aside-left  m-aside-left--skin-dark ">
                </div>
                <!-- END: Left Aside -->
                <!--  这个div就是页面右侧要显示的所有内容 -->
                <div class="m-grid__item m-grid__item--fluid m-wrapper" id="mainContent">
                </div>
            </div>
            <!-- end:: Body -->
            <!-- begin::Footer -->
            <footer class="m-grid__item     m-footer ">
                <div class="m-container m-container--fluid m-container--full-height m-page__container">
                    <div class="m-stack m-stack--flex-tablet-and-mobile m-stack--ver m-stack--desktop">
                        <div class="m-stack__item m-stack__item--left m-stack__item--middle m-stack__item--last">
                            <span class="m-footer__copyright">
                                2017 &copy; Metronic theme by
                                <a href="#" class="m-link">
                                    Keenthemes
                                </a>
                            </span>
                        </div>
                        <div class="m-stack__item m-stack__item--right m-stack__item--middle m-stack__item--first">
                            <ul class="m-footer__nav m-nav m-nav--inline m--pull-right">
                                <li class="m-nav__item">
                                    <a href="#" class="m-nav__link">
                                        <span class="m-nav__link-text">
                                            About
                                        </span>
                                    </a>
                                </li>
                                <li class="m-nav__item">
                                    <a href="#" class="m-nav__link">
                                        <span class="m-nav__link-text">
                                            Privacy
                                        </span>
                                    </a>
                                </li>
                                <li class="m-nav__item">
                                    <a href="#" class="m-nav__link">
                                        <span class="m-nav__link-text">
                                            T&C
                                        </span>
                                    </a>
                                </li>
                                <li class="m-nav__item">
                                    <a href="#" class="m-nav__link">
                                        <span class="m-nav__link-text">
                                            Purchase
                                        </span>
                                    </a>
                                </li>
                                <li class="m-nav__item m-nav__item">
                                    <a href="#" class="m-nav__link" data-toggle="m-tooltip" title="Support Center" data-placement="left">
                                        <i class="m-nav__link-icon flaticon-info m--icon-font-size-lg3"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </footer>
            <!-- end::Footer -->
        </div>
        <!-- end:: Page -->
        <!-- begin::Quick Sidebar  聊天sidebar -->
        <div id="m_quick_sidebar" class="m-quick-sidebar m-quick-sidebar--tabbed m-quick-sidebar--skin-light">
            <div class="m-quick-sidebar__content m--hide">
                <span id="m_quick_sidebar_close" class="m-quick-sidebar__close">
                    <i class="la la-close"></i>
                </span>
                <ul id="m_quick_sidebar_tabs" class="nav nav-tabs m-tabs m-tabs-line m-tabs-line--brand" role="tablist">
                    <li class="nav-item m-tabs__item">
                        <a class="nav-link m-tabs__link active" data-toggle="tab" href="#m_quick_sidebar_tabs_messenger" role="tab">
                            Messages
                        </a>
                    </li>
                    <li class="nav-item m-tabs__item">
                        <a class="nav-link m-tabs__link" data-toggle="tab" href="#m_quick_sidebar_tabs_settings" role="tab">
                            Settings
                        </a>
                    </li>
                    <li class="nav-item m-tabs__item">
                        <a class="nav-link m-tabs__link" data-toggle="tab" href="#m_quick_sidebar_tabs_logs" role="tab">
                            Logs
                        </a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active m-scrollable" id="m_quick_sidebar_tabs_messenger" role="tabpanel">
                        <div class="m-messenger m-messenger--message-arrow m-messenger--skin-light">
                            <div class="m-messenger__messages">
                                <div class="m-messenger__message m-messenger__message--in">
                                    <div class="m-messenger__message-pic">
                                        <img src="<%=request.getContextPath()%>/images/user3.jpg" alt="" />
                                    </div>
                                    <div class="m-messenger__message-body">
                                        <div class="m-messenger__message-arrow"></div>
                                        <div class="m-messenger__message-content">
                                            <div class="m-messenger__message-username">
                                                Megan wrote
                                            </div>
                                            <div class="m-messenger__message-text">
                                                Hi Bob. What time will be the meeting ?
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="m-messenger__message m-messenger__message--out">
                                    <div class="m-messenger__message-body">
                                        <div class="m-messenger__message-arrow"></div>
                                        <div class="m-messenger__message-content">
                                            <div class="m-messenger__message-text">
                                                Hi Megan. It's at 2.30PM
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="m-messenger__message m-messenger__message--in">
                                    <div class="m-messenger__message-pic">
                                        <img src="<%=request.getContextPath()%>/images/user3.jpg" alt="" />
                                    </div>
                                    <div class="m-messenger__message-body">
                                        <div class="m-messenger__message-arrow"></div>
                                        <div class="m-messenger__message-content">
                                            <div class="m-messenger__message-username">
                                                Megan wrote
                                            </div>
                                            <div class="m-messenger__message-text">
                                                Will the development team be joining ?
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="m-messenger__message m-messenger__message--out">
                                    <div class="m-messenger__message-body">
                                        <div class="m-messenger__message-arrow"></div>
                                        <div class="m-messenger__message-content">
                                            <div class="m-messenger__message-text">
                                                Yes sure. I invited them as well
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="m-messenger__datetime">
                                    2:30PM
                                </div>
                                <div class="m-messenger__message m-messenger__message--in">
                                    <div class="m-messenger__message-pic">
                                        <img src="<%=request.getContextPath()%>/images/user3.jpg" alt="" />
                                    </div>
                                    <div class="m-messenger__message-body">
                                        <div class="m-messenger__message-arrow"></div>
                                        <div class="m-messenger__message-content">
                                            <div class="m-messenger__message-username">
                                                Megan wrote
                                            </div>
                                            <div class="m-messenger__message-text">
                                                Noted. For the Coca-Cola Mobile App project as well ?
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="m-messenger__message m-messenger__message--out">
                                    <div class="m-messenger__message-body">
                                        <div class="m-messenger__message-arrow"></div>
                                        <div class="m-messenger__message-content">
                                            <div class="m-messenger__message-text">
                                                Yes, sure.
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="m-messenger__message m-messenger__message--out">
                                    <div class="m-messenger__message-body">
                                        <div class="m-messenger__message-arrow"></div>
                                        <div class="m-messenger__message-content">
                                            <div class="m-messenger__message-text">
                                                Please also prepare the quotation for the Loop CRM project as well.
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="m-messenger__datetime">
                                    3:15PM
                                </div>
                                <div class="m-messenger__message m-messenger__message--in">
                                    <div class="m-messenger__message-no-pic m--bg-fill-danger">
                                        <span>
                                            M
                                        </span>
                                    </div>
                                    <div class="m-messenger__message-body">
                                        <div class="m-messenger__message-arrow"></div>
                                        <div class="m-messenger__message-content">
                                            <div class="m-messenger__message-username">
                                                Megan wrote
                                            </div>
                                            <div class="m-messenger__message-text">
                                                Noted. I will prepare it.
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="m-messenger__message m-messenger__message--out">
                                    <div class="m-messenger__message-body">
                                        <div class="m-messenger__message-arrow"></div>
                                        <div class="m-messenger__message-content">
                                            <div class="m-messenger__message-text">
                                                Thanks Megan. I will see you later.
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="m-messenger__message m-messenger__message--in">
                                    <div class="m-messenger__message-pic">
                                        <img src="<%=request.getContextPath()%>/images/user3.jpg" alt="" />
                                    </div>
                                    <div class="m-messenger__message-body">
                                        <div class="m-messenger__message-arrow"></div>
                                        <div class="m-messenger__message-content">
                                            <div class="m-messenger__message-username">
                                                Megan wrote
                                            </div>
                                            <div class="m-messenger__message-text">
                                                Sure. See you in the meeting soon.
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="m-messenger__seperator"></div>
                            <div class="m-messenger__form">
                                <div class="m-messenger__form-controls">
                                    <input type="text" name="" placeholder="Type here..." class="m-messenger__form-input">
                                </div>
                                <div class="m-messenger__form-tools">
                                    <a href="" class="m-messenger__form-attachment">
                                        <i class="la la-paperclip"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane  m-scrollable" id="m_quick_sidebar_tabs_settings" role="tabpanel">
                        <div class="m-list-settings">
                            <div class="m-list-settings__group">
                                <div class="m-list-settings__heading">
                                    General Settings
                                </div>
                                <div class="m-list-settings__item">
                                    <span class="m-list-settings__item-label">
                                        Email Notifications
                                    </span>
                                    <span class="m-list-settings__item-control">
                                        <span class="m-switch m-switch--outline m-switch--icon-check m-switch--brand">
                                            <label>
                                                <input type="checkbox" checked="checked" name="">
                                                <span></span>
                                    </label>
                                    </span>
                                    </span>
                                </div>
                                <div class="m-list-settings__item">
                                    <span class="m-list-settings__item-label">
                                        Site Tracking
                                    </span>
                                    <span class="m-list-settings__item-control">
                                        <span class="m-switch m-switch--outline m-switch--icon-check m-switch--brand">
                                            <label>
                                                <input type="checkbox" name="">
                                                <span></span>
                                    </label>
                                    </span>
                                    </span>
                                </div>
                                <div class="m-list-settings__item">
                                    <span class="m-list-settings__item-label">
                                        SMS Alerts
                                    </span>
                                    <span class="m-list-settings__item-control">
                                        <span class="m-switch m-switch--outline m-switch--icon-check m-switch--brand">
                                            <label>
                                                <input type="checkbox" name="">
                                                <span></span>
                                    </label>
                                    </span>
                                    </span>
                                </div>
                                <div class="m-list-settings__item">
                                    <span class="m-list-settings__item-label">
                                        Backup Storage
                                    </span>
                                    <span class="m-list-settings__item-control">
                                        <span class="m-switch m-switch--outline m-switch--icon-check m-switch--brand">
                                            <label>
                                                <input type="checkbox" name="">
                                                <span></span>
                                    </label>
                                    </span>
                                    </span>
                                </div>
                                <div class="m-list-settings__item">
                                    <span class="m-list-settings__item-label">
                                        Audit Logs
                                    </span>
                                    <span class="m-list-settings__item-control">
                                        <span class="m-switch m-switch--outline m-switch--icon-check m-switch--brand">
                                            <label>
                                                <input type="checkbox" checked="checked" name="">
                                                <span></span>
                                    </label>
                                    </span>
                                    </span>
                                </div>
                            </div>
                            <div class="m-list-settings__group">
                                <div class="m-list-settings__heading">
                                    System Settings
                                </div>
                                <div class="m-list-settings__item">
                                    <span class="m-list-settings__item-label">
                                        System Logs
                                    </span>
                                    <span class="m-list-settings__item-control">
                                        <span class="m-switch m-switch--outline m-switch--icon-check m-switch--brand">
                                            <label>
                                                <input type="checkbox" name="">
                                                <span></span>
                                    </label>
                                    </span>
                                    </span>
                                </div>
                                <div class="m-list-settings__item">
                                    <span class="m-list-settings__item-label">
                                        Error Reporting
                                    </span>
                                    <span class="m-list-settings__item-control">
                                        <span class="m-switch m-switch--outline m-switch--icon-check m-switch--brand">
                                            <label>
                                                <input type="checkbox" name="">
                                                <span></span>
                                    </label>
                                    </span>
                                    </span>
                                </div>
                                <div class="m-list-settings__item">
                                    <span class="m-list-settings__item-label">
                                        Applications Logs
                                    </span>
                                    <span class="m-list-settings__item-control">
                                        <span class="m-switch m-switch--outline m-switch--icon-check m-switch--brand">
                                            <label>
                                                <input type="checkbox" name="">
                                                <span></span>
                                    </label>
                                    </span>
                                    </span>
                                </div>
                                <div class="m-list-settings__item">
                                    <span class="m-list-settings__item-label">
                                        Backup Servers
                                    </span>
                                    <span class="m-list-settings__item-control">
                                        <span class="m-switch m-switch--outline m-switch--icon-check m-switch--brand">
                                            <label>
                                                <input type="checkbox" checked="checked" name="">
                                                <span></span>
                                    </label>
                                    </span>
                                    </span>
                                </div>
                                <div class="m-list-settings__item">
                                    <span class="m-list-settings__item-label">
                                        Audit Logs
                                    </span>
                                    <span class="m-list-settings__item-control">
                                        <span class="m-switch m-switch--outline m-switch--icon-check m-switch--brand">
                                            <label>
                                                <input type="checkbox" name="">
                                                <span></span>
                                    </label>
                                    </span>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane  m-scrollable" id="m_quick_sidebar_tabs_logs" role="tabpanel">
                        <div class="m-list-timeline">
                            <div class="m-list-timeline__group">
                                <div class="m-list-timeline__heading">
                                    System Logs
                                </div>
                                <div class="m-list-timeline__items">
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-success"></span>
                                        <a href="" class="m-list-timeline__text">
                                            12 new users registered
                                            <span class="m-badge m-badge--warning m-badge--wide">
                                                important
                                            </span>
                                        </a>
                                        <span class="m-list-timeline__time">
                                            Just now
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-info"></span>
                                        <a href="" class="m-list-timeline__text">
                                            System shutdown
                                        </a>
                                        <span class="m-list-timeline__time">
                                            11 mins
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-danger"></span>
                                        <a href="" class="m-list-timeline__text">
                                            New invoice received
                                        </a>
                                        <span class="m-list-timeline__time">
                                            20 mins
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-warning"></span>
                                        <a href="" class="m-list-timeline__text">
                                            Database overloaded 89%
                                            <span class="m-badge m-badge--success m-badge--wide">
                                                resolved
                                            </span>
                                        </a>
                                        <span class="m-list-timeline__time">
                                            1 hr
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-success"></span>
                                        <a href="" class="m-list-timeline__text">
                                            System error
                                        </a>
                                        <span class="m-list-timeline__time">
                                            2 hrs
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-info"></span>
                                        <a href="" class="m-list-timeline__text">
                                            Production server down
                                            <span class="m-badge m-badge--danger m-badge--wide">
                                                pending
                                            </span>
                                        </a>
                                        <span class="m-list-timeline__time">
                                            3 hrs
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-success"></span>
                                        <a href="" class="m-list-timeline__text">
                                            Production server up
                                        </a>
                                        <span class="m-list-timeline__time">
                                            5 hrs
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="m-list-timeline__group">
                                <div class="m-list-timeline__heading">
                                    Applications Logs
                                </div>
                                <div class="m-list-timeline__items">
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-info"></span>
                                        <a href="" class="m-list-timeline__text">
                                            New order received
                                            <span class="m-badge m-badge--info m-badge--wide">
                                                urgent
                                            </span>
                                        </a>
                                        <span class="m-list-timeline__time">
                                            7 hrs
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-success"></span>
                                        <a href="" class="m-list-timeline__text">
                                            12 new users registered
                                        </a>
                                        <span class="m-list-timeline__time">
                                            Just now
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-info"></span>
                                        <a href="" class="m-list-timeline__text">
                                            System shutdown
                                        </a>
                                        <span class="m-list-timeline__time">
                                            11 mins
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-danger"></span>
                                        <a href="" class="m-list-timeline__text">
                                            New invoices received
                                        </a>
                                        <span class="m-list-timeline__time">
                                            20 mins
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-warning"></span>
                                        <a href="" class="m-list-timeline__text">
                                            Database overloaded 89%
                                        </a>
                                        <span class="m-list-timeline__time">
                                            1 hr
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-success"></span>
                                        <a href="" class="m-list-timeline__text">
                                            System error
                                            <span class="m-badge m-badge--info m-badge--wide">
                                                pending
                                            </span>
                                        </a>
                                        <span class="m-list-timeline__time">
                                            2 hrs
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-info"></span>
                                        <a href="" class="m-list-timeline__text">
                                            Production server down
                                        </a>
                                        <span class="m-list-timeline__time">
                                            3 hrs
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="m-list-timeline__group">
                                <div class="m-list-timeline__heading">
                                    Server Logs
                                </div>
                                <div class="m-list-timeline__items">
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-success"></span>
                                        <a href="" class="m-list-timeline__text">
                                            Production server up
                                        </a>
                                        <span class="m-list-timeline__time">
                                            5 hrs
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-info"></span>
                                        <a href="" class="m-list-timeline__text">
                                            New order received
                                        </a>
                                        <span class="m-list-timeline__time">
                                            7 hrs
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-success"></span>
                                        <a href="" class="m-list-timeline__text">
                                            12 new users registered
                                        </a>
                                        <span class="m-list-timeline__time">
                                            Just now
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-info"></span>
                                        <a href="" class="m-list-timeline__text">
                                            System shutdown
                                        </a>
                                        <span class="m-list-timeline__time">
                                            11 mins
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-danger"></span>
                                        <a href="" class="m-list-timeline__text">
                                            New invoice received
                                        </a>
                                        <span class="m-list-timeline__time">
                                            20 mins
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-warning"></span>
                                        <a href="" class="m-list-timeline__text">
                                            Database overloaded 89%
                                        </a>
                                        <span class="m-list-timeline__time">
                                            1 hr
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-success"></span>
                                        <a href="" class="m-list-timeline__text">
                                            System error
                                        </a>
                                        <span class="m-list-timeline__time">
                                            2 hrs
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-info"></span>
                                        <a href="" class="m-list-timeline__text">
                                            Production server down
                                        </a>
                                        <span class="m-list-timeline__time">
                                            3 hrs
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-success"></span>
                                        <a href="" class="m-list-timeline__text">
                                            Production server up
                                        </a>
                                        <span class="m-list-timeline__time">
                                            5 hrs
                                        </span>
                                    </div>
                                    <div class="m-list-timeline__item">
                                        <span class="m-list-timeline__badge m-list-timeline__badge--state-info"></span>
                                        <a href="" class="m-list-timeline__text">
                                            New order received
                                        </a>
                                        <span class="m-list-timeline__time">
                                            1117 hrs
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end::Quick Sidebar -->
        <!-- begin::Scroll Top -->
        <div class="m-scroll-top m-scroll-top--skin-top" data-toggle="m-scroll-top" data-scroll-offset="500" data-scroll-speed="300">
            <i class="la la-arrow-up"></i>
        </div>
        <!-- end::Scroll Top -->
        <!-- begin::Quick Nav -->
        <ul class="m-nav-sticky" style="margin-top: 30px;">
            <!--
            <li class="m-nav-sticky__item" data-toggle="m-tooltip" title="Showcase" data-placement="left">
                <a href="">
                    <i class="la la-eye"></i>
                </a>
            </li>
            <li class="m-nav-sticky__item" data-toggle="m-tooltip" title="Pre-sale Chat" data-placement="left">
                <a href="" >
                    <i class="la la-comments-o"></i>
                </a>
            </li>
            -->
            <li class="m-nav-sticky__item" data-toggle="m-tooltip" title="Purchase" data-placement="left">
                <a href="#" target="_blank">
                    <i class="la la-cart-arrow-down"></i>
                </a>
            </li>
            <li class="m-nav-sticky__item" data-toggle="m-tooltip" title="Documentation" data-placement="left">
                <a href="#" target="_blank">
                    <i class="la la-code-fork"></i>
                </a>
            </li>
            <li class="m-nav-sticky__item" data-toggle="m-tooltip" title="Support" data-placement="left">
                <a href="#" target="_blank">
                    <i class="la la-life-ring"></i>
                </a>
            </li>
        </ul>
        <script src="<%=request.getContextPath()%>/js/scripts.bundle.js" type="text/javascript"></script>
    </body>
</html>