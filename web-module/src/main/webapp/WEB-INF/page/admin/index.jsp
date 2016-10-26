<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/22
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh" ng-app="backManagerApp">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="keywords" content="admin, dashboard, bootstrap, template, flat, modern, theme, responsive, fluid, retina, backend, html5, css, css3">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>兴趣金融后台管理系统</title>

    <!--icheck-->
    <link href="/asset/admin/js/iCheck/skins/minimal/minimal.css" rel="stylesheet">
    <link href="/asset/admin/js/iCheck/skins/square/square.css" rel="stylesheet">
    <link href="/asset/admin/js/iCheck/skins/square/red.css" rel="stylesheet">
    <link href="/asset/admin/js/iCheck/skins/square/blue.css" rel="stylesheet">

    <!-- sweet-alert弹出框 -->
    <link href="/plugs/sweet-alert/css/sweet-alert.css" rel="stylesheet">

    <!--dashboard calendar-->
    <link href="/asset/admin/css/clndr.css" rel="stylesheet">

    <!--Morris Chart CSS -->
    <link rel="stylesheet" href="/asset/admin/js/morris-chart/morris.css">

    <!--common-->
    <link href="/asset/admin/css/style.css" rel="stylesheet">
    <link href="/asset/admin/css/style-responsive.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/plugs/flatpickr/dist/flatpickr.min.css"/>

    <!-- select2 -->
    <link rel="stylesheet" type="text/css" href="/plugs/select2/css/select2.min.css"/>
    <link rel="stylesheet" type="text/css" href="/asset/css/animate.css">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/asset/admin/js/html5shiv.js"></script>
    <script src="/asset/admin/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="sticky-header">

<section>
    <!-- left side start-->
    <div class="left-side sticky-left-side">

        <!--logo and iconic logo start-->
        <div class="logo">
            <a href="index.html"><img src="/asset/admin/images/logo.png" alt=""></a>
        </div>

        <div class="logo-icon text-center">
            <a href="index.html"><img src="/asset/admin/images/logo_icon.png" alt=""></a>
        </div>
        <!--logo and iconic logo end-->

        <div class="left-side-inner">

            <!-- visible to small devices only -->
            <div class="visible-xs hidden-sm hidden-md hidden-lg">
                <div class="media logged-user">
                    <img alt="" src="/asset/admin/images/photos/user-avatar.png" class="media-object">
                    <div class="media-body">
                        <h4><a href="#">John Doe</a></h4>
                        <span>"Hello There..."</span>
                    </div>
                </div>

                <h5 class="left-nav-title">Account Information</h5>
                <ul class="nav nav-pills nav-stacked custom-nav">
                    <li><a href="#"><i class="fa fa-user"></i> <span>Profile</span></a></li>
                    <li><a href="#"><i class="fa fa-cog"></i> <span>Settings</span></a></li>
                    <li><a href="#"><i class="fa fa-sign-out"></i> <span>Sign Out</span></a></li>
                </ul>
            </div>

            <!-- 左边菜单栏 -->
            <jsp:include page="leftSider.jsp"></jsp:include>
            <!--sidebar nav end-->

        </div>
    </div>
    <!-- left side end-->

    <!-- main content start-->
    <div class="main-content" style="height: auto" >

        <!-- header section start-->
        <jsp:include page="header.jsp"></jsp:include>
        <!-- header section end-->

        <!--body 路由视图跳转 start-->
        <div class="wrapper" ui-view>

        </div>
        <!--body 路由视图跳转 end-->

        <!--footer section start-->
        <footer>
            2016 &copy; 兴趣金融后台管理系统 by <a href="http://www.adxin.net/" target="_blank">深圳前海艾德信科技有限公司</a>
        </footer>
        <!--footer section end-->


    </div>
    <!-- main content end-->
</section>
<!-- angularjs -->
<script src="/asset/admin/js/jquery-1.10.2.min.js"></script>
<script src="/plugs/mw-upload.js"></script>
<%--<script src="/asset/js/jquery.js"></script>--%>
<script src="/plugs/angularjs/angular-1.2.22.min.js"></script>
<script src="/plugs/angularjs/angular-route.js"></script>
<script src="/plugs/angularjs/angular-ui-router.js"></script>
<script src="/asset/admin/js/angularjs/backManager.js"></script>
<!-- Placed js at the end of the document so the pages load faster -->
<script src="/asset/admin/js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="/asset/admin/js/jquery-migrate-1.2.1.min.js"></script>
<script src="/asset/admin/js/bootstrap.min.js"></script>
<script src="/asset/admin/js/modernizr.min.js"></script>
<script src="/asset/admin/js/jquery.nicescroll.js"></script>

<!--easy pie chart-->
<script src="/asset/admin/js/easypiechart/jquery.easypiechart.js"></script>
<script src="/asset/admin/js/easypiechart/easypiechart-init.js"></script>

<!--Sparkline Chart-->
<script src="/asset/admin/js/sparkline/jquery.sparkline.js"></script>
<script src="/asset/admin/js/sparkline/sparkline-init.js"></script>

<!--icheck -->
<script src="/asset/admin/js/iCheck/jquery.icheck.js"></script>
<script src="/asset/admin/js/icheck-init.js"></script>

<!-- sweet-alert弹出框 -->
<script src="/plugs/sweet-alert/js/sweet-alert.min.js"></script>

<!-- jQuery Flot Chart-->
<script src="/asset/admin/js/flot-chart/jquery.flot.js"></script>
<script src="/asset/admin/js/flot-chart/jquery.flot.tooltip.js"></script>
<script src="/asset/admin/js/flot-chart/jquery.flot.resize.js"></script>


<!--Morris Chart-->
<script src="/asset/admin/js/morris-chart/morris.js"></script>
<script src="/asset/admin/js/morris-chart/raphael-min.js"></script>

<!--Calendar-->
<script src="/asset/admin/js/calendar/clndr.js"></script>
<script src="/asset/admin/js/calendar/evnt.calendar.init.js"></script>
<script src="/asset/admin/js/calendar/moment-2.2.1.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.5.2/underscore-min.js"></script>
<script src="/plugs/flatpickr/dist/flatpickr.min.js" type="text/javascript"></script>

<!--common scripts for all pages-->
<script src="/asset/admin/js/scripts.js"></script>

<!--Dashboard Charts-->
<script src="/asset/admin/js/dashboard-chart-init.js"></script>
<!-- select2 -->
<script src="/plugs/select2/js/select2.min.js" type="text/javascript"></script>
</body>
</html>

