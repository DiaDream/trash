<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<%--
  ~ 版权所有 2018 ，xieyunbo.com
  --%>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>${sessionScope.siteName}-系统登录</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-grid.min.css" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-reboot.min.css" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css" />
        <script src="<%=request.getContextPath()%>/js/jquery-3.3.1.slim.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/popper.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/bootstrap.bundle.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    </head>

    <body class="text-center">
        <form class="form-signin" method="post" action="<%=request.getContextPath()%>/admin/login">
            <img class="mb-4" src="images/logo.png" alt="" width="72" height="72">
            <h1 class="h3 mb-3 font-weight-normal">登录</h1>
            <label for="inputEmail" class="sr-only">用户名</label>
            <input type="text" name="userName" id="userNameInput" class="form-control" placeholder="用户名" required autofocus>
            <label for="inputPassword" class="sr-only">密码</label>
            <input type="password" name="password" id="passwordInput" class="form-control" placeholder="密码" required>
            <div class="checkbox mb-3">
                <label>
          <input type="checkbox" value="remember-me" /> 记住登录信息
        </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">登入</button>
            <p class="mt-5 mb-3 text-muted">
                <a href="#"><b style="color:#007bff">${sessionScope.siteName}</b></a><b style="color:#007bff">&copy; 2018-2019</b></p>
        </form>
    </body>

</html>