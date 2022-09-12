<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="app" >
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>校园快递收发管理系统</title>
    <link rel="shortcut icon" href="/Express/static/images/favicon.ico" />
    <link rel="stylesheet" type="text/css" href="css_timedelay/css/wui.min.css">
    <!-- Bootstrap -->
    <link href="/Express/static/css1/bootstrap.min.css" rel="stylesheet">
    <link href="/Express/static/css1/style.css" rel="stylesheet">
    <link href="/Express/static/css1/response.css" rel="stylesheet">
    <link href="/Express/static/css1/silde.css" rel="stylesheet">
    <link href="/Express/static/css/reset.css" rel="stylesheet" />
    <script type="text/javascript" src="js_timedelay/jquery.min.js"></script>
    <script type="text/javascript" src="js_timedelay/angular.min.js"></script>
    <script type="text/javascript" src="js_timedelay/wui-date.js" charset="utf-8"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <div class="header">
        <div class="width1003">
            <h3 class="logo"><a href="index.jsp"><img src="/Express/static/image/logo.jpg" width="80" />&nbsp;&nbsp;&nbsp;元创易站</a></h3>
            <div class="topLink">
                <a href="contact.html" class="tl1">联系我们</a>
                <a href="service.html" class="tl2">投诉建议</a>
                <a href="download.html" class="tl3">下载中心</a>
                <a href="job.html" class="tl4">人才招聘</a>
            </div><!--topLink/-->
            <div class="phones">
                <div>
                    <a href="javascript:;" onclick="AddFavorite(window.location,document.title)">加入收藏</a>&nbsp;
                    <a href="javascript:;" onclick="SetHome(this,window.location)">设为首页</a>
                </div>
                <p>服务热线：<strong>4001001717</strong></p>
            </div><!--phones/-->
            <div class="clears"></div>
        </div><!--width1003/-->
    </div><!--header/-->
    <div class="nav-toggle">
        <div class="nav-open"><span class="glyphicon glyphicon-th-list"></span></div>
        <div class="nav-close"><span class="glyphicon glyphicon-remove"></span></div>
    </div>
    <div class="clearfix"></div>
    <div class="nav">
        <ul class="width1003">
            <li><a href="index_client.jsp">首页</a></li>
            <li>
                <a href="sign.jsp">快件查询</a>
                <div class="chilNav">
                    <a href="sign.jsp">收件查询</a>
                    <a href="distribute.jsp">寄件查询</a>
                </div>
            </li>
            <li>
                <a href="order.jsp">寄件</a>

            </li>
             <li>
                <a href="space_gui.jsp">时间管理</a>
                <div class="chilNav">
                    <a href="timetable.jsp">录入时间表</a>
                    <a href="timedelay.jsp">申请延迟取件</a>

                </div>
            </li>
            <li>
            </li>
            <li>
                <a href="my-profile.jsp"><img src="/Express/static/image/个人中心.png" width="45"/>个人中心</a>
            </li>
            <div class="clears"></div>
        </ul>
    </div><!--nav/-->
    <div class="wui-content">
        <div class="wui-area">
            <h2 class="h2" align="center">请输入您繁忙的时间段</h2>
        </div>
        <div class="wui-area" align="center">
            <h4 class="h4">开始日期</h4>
            <wui-date format="yyyy-mm-dd"
                      placeholder="请选择或输入日期"
                      id="date1"
                      btns="{'ok':'确定','now':'此刻'}"
                      ng-model="date1">
            </wui-date>
        </div>
        <div class="wui-area" align="center">
            <h4 class="h4">结束日期</h4>
            <wui-date format="yyyy-mm-dd"
                      placeholder="请选择或输入日期"
                      id="date1"
                      btns="{'ok':'确定','now':'此刻'}"
                      ng-model="date2">
            </wui-date>
        </div>
        <div class="islsub" style="text-align:center;" ><input type="submit" style="width:120px;height:40px;font-size:1.6em;"value="申请延迟" /></div>
   <footer>
      <div class="width1003">
      <ul>
        <li class="ft-title">快件查询</li>
        <li><a href="sign.jsp">收件查询</a></li>
        <li><a href="distribute.jsp">寄件查询</a></li>
    
       </ul>
       <ul>
        <li class="ft-title">寄件</li>
        <li><a href="space_gui.jsp">寄件申请</a></li>
       </ul>
       <ul>
        <li class="ft-title">时间管理</li>
        <li><a href="timetable.jsp">录入时间表</a></li>
        <li><a href="timedelay.jsp">申请延迟</a></li>
       </ul>
     
    
     
       <div class="footcontact">
        <h2 class="ft-title">联系我们</h2>
        <div class="fttext">
         咨询热线：<br />
         总部地址：<br />
         官方网站：
        </div>
       
       </div><!--footcontact/-->
       <div class="clearfix"></div>
      </div><!--width1003/-->
     </footer>
    <div class="copy">
        Copyright © 2020 Wliu Co.,Ltd.    京ICP备00000000号    北京市昌平区沙河高教园 技术支持：Reserved
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
     <script type="text/javascript">
        var app = angular.module('app', ["wui.date"]);
    </script>
    <script src="/Express/static/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/Express/static/js/bootstrap.min.js"></script>
    <script src="/Express/static/js/style.js"></script>
    <!--焦点轮换-->
    <script src="/Express/static/js/jquery.excoloSlider.js"></script>
    <script>
        var swiper = new Swiper('.swiper-container', {
            pagination: '.swiper-pagination',
            paginationClickable: true
        });
    </script>
    <script type="text/javascript">
        $(function () {

            $(".nav li:eq(3) a:first").addClass("navCur");
        })
    </script>

</body>
</html>