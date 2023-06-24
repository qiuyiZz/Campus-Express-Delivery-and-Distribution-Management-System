<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <title>校园快递收发管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">

    <!-- External CSS libraries -->
    <link rel="stylesheet" type="text/css" href="/Express/static/css1/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/Express/static/css1/animate.min.css">
    <link rel="stylesheet" type="text/css" href="/Express/static/css1/bootstrap-submenu.css">

    <link rel="stylesheet" type="text/css" href="/Express/static/css1/bootstrap-select.min.css">
    <link rel="stylesheet" type="text/css" href="/Express/static/css1/magnific-popup.css">
    <link rel="stylesheet" href="/Express/static/css1/leaflet.css" type="text/css">
    <link rel="stylesheet" href="/Express/static/css1/map.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="/Express/static/fonts1/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="/Express/static/fonts1/flaticon/font/flaticon.css">
    <link rel="stylesheet" type="text/css" href="/Express/static/fonts1/linearicons/style.css">
    <link rel="stylesheet" type="text/css" href="/Express/static/css1/jquery.mCustomScrollbar.css">
    <link rel="stylesheet" type="text/css" href="/Express/static/css1/dropzone.css">
    <link rel="stylesheet" type="text/css" href="/Express/static/css1/slick.css">
    <link href="/Express/static/css/reset.css" rel="stylesheet" />

    <!-- Custom stylesheet -->
    <link rel="stylesheet" type="text/css" href="/Express/static/css1/style.css">
     
    <link rel="stylesheet" type="text/css" id="style_sheet" href="/Express/static/css1/skins/default.css">

    <!-- Favicon icon -->
    <!-- Google fonts -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,600,300,700">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link rel="stylesheet" type="text/css" href="/Express/static/css1/ie10-viewport-bug-workaround.css">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script  src="js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/Express/static/js1/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script  src="js/html5shiv.min.js"></script>
    <script  src="js/respond.min.js"></script>
    <![endif]-->
    <!-- Bootstrap -->
    <link href="/Express/static/css1/bootstrap.min.css" rel="stylesheet">
    <link href="/Express/static/css1/style.css" rel="stylesheet">
    <link href="/Express/static/css1/response.css" rel="stylesheet">
    <link href="/Express/static/css1/silde.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script>
    
    <% 
    String name=(String)request.getAttribute("name");
    String role=(String)request.getAttribute("role");
    String address=(String)request.getAttribute("address");
    String phone=(String)request.getAttribute("phone");
	%>
	
	var name="<%=name%>";
	var role="<%=role%>";
	var address="<%=address%>";
	var phone="<%=phone%>";
	
             window.onload = function(){
                var oName = document.getElementById('name');
                var oPhone = document.getElementById('phone');
                var oRole = document.getElementById('role');
                var oAddress = document.getElementById('address');
                oName.setAttribute("placeholder",name);
                oPhone.setAttribute("placeholder",phone);
                oRole.setAttribute("placeholder",role);
                oAddress.setAttribute("placeholder",address);
             };
     </script>
</head>
<body>
    <!-- Main header start -->
    <div class="header">
        <div class="width1003">
            <h3 class="logo"><a href="index_client.jsp"><img src="/Express/static/image/logo.jpg" width="80" />&nbsp;&nbsp;&nbsp;元创易站</a></h3>
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
            <li><a href="/Express/index_client.jsp">首页</a></li>
            <li>
                <a href="/Express/servlet/receiveC">快件查询</a>
                <div class="chilNav">
                    <a href="/Express/servlet/receiveC">收件查询</a>
                    <a href="/Express/servlet/sendC">寄件查询</a>
                </div>
            </li>
            <li>
                <a href="/Express/send.jsp">寄件</a>

            </li>
             <li>
                <a href="/Express/timetable.jsp">时间管理</a>
                <div class="chilNav">
                    <a href="/Express/timetable.jsp">录入时间表</a>
                    <a href="/Express/timedelay.jsp">申请延迟取件</a>

                </div>
            </li>
            <li>
            </li>
            <li>
                <a href="/Express/enter_profile1"><img src="/Express/static/image/个人中心.png" width="45"/>个人中心</a>
            </li>
            <div class="clears"></div>
        </ul>
    </div><!--nav/-->
    <!-- Main header end -->
    <!-- Dashbord start -->
    <div class="dashboard">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-3 col-md-12 col-sm-12 col-pad">
                    <div class="dashboard-nav d-none d-xl-block d-lg-block">
                        <div class="dashboard-inner">
                            <h4>消息</h4>
                            <ul>
                                <li><a href="message1.jsp"><i class="flaticon-mail"></i>消息提醒<span class="nav-tag">6</span></a></li>
                            </ul>
                            <h4>账户</h4>
                            <ul>
                                <li class="active"><a href="my-profile1.jsp"><i class="flaticon-people"></i>个人信息</a></li>
                                <li><a href="change_password1.jsp"><i class="flaticon-people"></i>修改密码</a></li>
                                <li><a href="login.jsp"><i class="flaticon-logout"></i>退出登录</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9 col-md-12 col-sm-12 col-pad">
                    <div class="dashboard-list">
                        <h3 class="heading">个人信息</h3>
                        <div class="dashboard-message contact-2 bdr clearfix">
                            <div class="row">
                                <div class="col-lg-3 col-md-3">
                                    <!-- Edit profile photo -->
                                    <div class="edit-profile-photo">
                                        <img src="/Express/static/img/avatar/avatar-6.jpg" alt="profile-photo" class="img-fluid">
                                        <div class="change-photo-btn">
                                            <div class="photoUpload">
                                                <span><i class="fa fa-upload"></i></span>
                                                <input type="file" class="upload">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-9 col-md-9">
                                    <form action="#" method="GET" enctype="multipart/form-data">
                                        <div class="row">
                                            <div class="col-lg-6 col-md-6">
                                                <div class="form-group name">
                                                    <label>姓名</label>
                                                    <input type="text" name="name" id="name" class="form-control" placeholder="张三">
                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-md-6">
                                                <div class="form-group email">
                                                    <label>角色</label>
                                                    <input type="text" name="role" id="role" class="form-control" placeholder="学生">
                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-md-6">
                                                <div class="form-group subject">
                                                    <label>电话</label>
                                                    <input type="text" name="phone" id="phone" class="form-control" placeholder="2017312281">
                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-md-6">
                                                <div class="form-group number">
                                                    <label>个人住址</label>
                                                    <input type="text" name="address" id="address" class="form-control" placeholder="中央财经大学">
                                                </div>
                                            </div>
                                            <div class="col-lg-12 col-md-12 col-sm-12">
                                                <div class="form-group message">
                                                    <label>其他信息</label>
                                                    <textarea class="form-control" name="message" placeholder="Personal info"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
            </div>
                    <!-- Dashbord end -->
            <footer>
      <div class="width1003">
      <ul>
        <li class="ft-title">快件查询</li>
        <li><a href="receive_client.jsp">收件查询</a></li>
        <li><a href="send_client.jsp">寄件查询</a></li>
    
       </ul>
       <ul>
        <li class="ft-title">寄件</li>
        <li><a href="send.jsp">寄件申请</a></li>
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
                        Copyright © 2020 Wliu Co.,Ltd.    京ICP备00000000号    北京市昌平区沙河高教园 技术支持：<a href="http://www.bootstrapmb.com/" title="bootstrapmb">Reserved</a>
                    </div>
                    <!-- Full Page Search -->
                    <div id="full-page-search">
                        <button type="button" class="close">×</button>
                        <form action="index.jsp#">
                            <input type="search" value="" placeholder="type keyword(s) here" />
                            <button type="submit" class="btn btn-sm button-theme">Search</button>
                        </form>
                    </div>

                    <script src="/Express/static/js1/jquery-2.2.0.min.js"></script>
                    <script src="/Express/static/js1/popper.min.js"></script>
                    <script src="/Express/static/js1/bootstrap.min.js"></script>
                    <script src="/Express/static/js1/bootstrap-submenu.js"></script>
                    <script src="/Express/static/js1/rangeslider.js"></script>
                    <script src="/Express/static/js1/jquery.mb.YTPlayer.js"></script>
                    <script src="/Express/static/js1/bootstrap-select.min.js"></script>
                    <script src="/Express/static/js1/jquery.easing.1.3.js"></script>
                    <script src="/Express/static/js1/jquery.scrollUp.js"></script>
                    <script src="/Express/static/js1/jquery.mCustomScrollbar.concat.min.js"></script>
                    <script src="/Express/static/js1/leaflet.js"></script>
                    <script src="/Express/static/js1/leaflet-providers.js"></script>
                    <script src="/Express/static/js1/leaflet.markercluster.js"></script>
                    <script src="/Express/static/js1/dropzone.js"></script>
                    <script src="/Express/static/js1/slick.min.js"></script>
                    <script src="/Express/static/js1/jquery.filterizr.js"></script>
                    <script src="/Express/static/js1/jquery.magnific-popup.min.js"></script>
                    <script src="/Express/static/js1/jquery.countdown.js"></script>
                    <script src="/Express/static/js1/maps.js"></script>
                    <script src="/Express/static/js1/app.js"></script>

                    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
                    <script src="/Express/static/js/ie10-viewport-bug-workaround.js"></script>
                    <!-- Custom javascript -->
                    <script src="/Express/static/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
