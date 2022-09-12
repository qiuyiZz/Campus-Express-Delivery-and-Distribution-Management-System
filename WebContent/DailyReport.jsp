<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>元创驿站</title>
    <link rel="shortcut icon" href="/Express/static/images/favicon.ico" />
    
    <!-- Bootstrap -->
    <link href="/Express/static/css/bootstrap.min.css" rel="stylesheet">
 
    <link href="/Express/static/css/response.css" rel="stylesheet">
    <link href="/Express/static/css/silde.css" rel="stylesheet">
    <link href="/Express/static/css1/style.css" rel="stylesheet">
    
     <link href="/Express/static/css/reset.css" rel="stylesheet" />
    <link href="/Express/static/css/iconfont.css" rel="stylesheet" />
    <link href="/Express/static/css/index.css" rel="stylesheet" />
    
    <link href="/Express/static/css/style1.css" rel="stylesheet">
    
    <script src="/Express/static/js/jquery-1.9.1.min.js"></script>
    <script src="/Express/static/js/f.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script language="javascript">
function preview(fang)
{
if (fang < 10){
bdhtml=window.document.body.innerHTML;//获取当前页的html代码
sprnstr="<!--startprint"+fang+"-->";//设置打印开始区域
eprnstr="<!--endprint"+fang+"-->";//设置打印结束区域
prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+18); //从开始代码向后取html
prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//从结束代码向前取html
window.document.body.innerHTML=prnhtml;
window.print();
window.document.body.innerHTML=bdhtml;
} else {
window.print();
}
}
</script>
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
            <li><a href="index.jsp">首页</a></li>
            <li>
                <a href="sign.jsp">收件管理</a>
                <div class="chilNav">
                    <a href="sign.jsp">签收录入</a>
                    <a href="distribute.jsp">派件</a>
                    <a href="example.jsp">问题件</a>

                </div>
            </li>
            <li>
                <a href="order.jsp">寄件管理</a>

            </li>
            <li>
                <a href="space_gui.jsp">查看空间信息</a>
                <div class="chilNav">
                    <a href="space_gui.jsp">自提柜</a>
                    <a href="space_shelf.jsp">货架区</a>

                </div>
            </li>
            <li>
                <a href="DailyReport.jsp">查看每日报告</a>

            </li>

            <li>
            </li>
            <li>
                <a href="my-profile.jsp"><img src="/Express/static/image/个人中心.png" width="45"/>个人中心</a>
            </li>
      
     
       <div class="clears"></div>
      </ul>
     </div><!--nav/-->
     
   <!--startprint1-->

<!--打印内容开始-->
   <div id=wdf>
       <div class="content" style="background:#f8f8f8">
        <div class="width1003">
       <div class="row">
									<div class="col-xl-12">
											<div class="breadcrumb-holder">
													<h1 class="main-title float-left">今日报告</h1>
														<div class="clearfix"></div>
											</div>
									</div>
									<input class="f_pormatBtn2" type='button' name='button_export' title='打印每日报告' onclick=preview(1) value='打印每日报告' style="width:90px;hight:25px;float:right;margin:0,5px,10px,0; ">
   
						</div>
						<!-- end row -->
    								
						
						
							<div class="row">
									<div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
											<div class="card-box noradius noborder bg-default">
													<i class="fa fa-file-text-o float-right text-white"></i>
													<h6 class="text-white text-uppercase m-b-20">日期</h6>
													<h1 class="m-b-20 text-white counter">2020/05/03</h1>
													<span class="text-white"></span>
											</div>
									</div>

									<div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
											<div class="card-box noradius noborder bg-warning">
													<i class="fa fa-bar-chart float-right text-white"></i>
													<h6 class="text-white text-uppercase m-b-20">签收数量</h6>
													<h1 class="m-b-20 text-white counter">250</h1>
													<span class="text-white"></span>
											</div>
									</div>

									<div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
											<div class="card-box noradius noborder bg-info">
													<i class="fa fa-user-o float-right text-white"></i>
													<h6 class="text-white text-uppercase m-b-20">取件数量</h6>
													<h1 class="m-b-20 text-white counter">213</h1>
													<span class="text-white"></span>
											</div>
									</div>

									<div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
											<div class="card-box noradius noborder bg-danger">
													<i class="fa fa-bell-o float-right text-white"></i>
													<h6 class="text-white text-uppercase m-b-20">寄件数量</h6>
													<h1 class="m-b-20 text-white counter">58</h1>
													<span class="text-white"></span>
											</div>
									</div>
									
									<div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
											<div class="card-box noradius noborder bg-dark">
													<i class="fa fa-bar-chart float-right text-white"></i>
													<h6 class="text-white text-uppercase m-b-20">问题件数量</h6>
													<h1 class="m-b-20 text-white counter">21</h1>
													<span class="text-white"></span>
											</div>
									</div>
									<div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
											<div class="card-box noradius noborder bg-pink">
													<i class="fa fa-bar-chart float-right text-white"></i>
													<h6 class="text-white text-uppercase m-b-20">自提柜利用率</h6>
													<h1 class="m-b-20 text-white counter">67%</h1>
													<span class="text-white"></span>
											</div>
									</div>
									
									
							</div>
							<!-- end row -->
      
         
         </div><!--width1003/-->
     </div><!--content/-->
     
     </div>
<!--打印内容结束-->

<!--endprint1-->

      <footer>
      <div class="width1003">
      <ul>
        <li class="ft-title">收件管理</li>
        <li><a href="sign.jsp">签收录入</a></li>
        <li><a href="distribute.jsp">派件</a></li>
        <li><a href="example.jsp">问题件</a></li>
    
       </ul>
       <ul>
        <li class="ft-title">寄件管理</li>
        <li><a href="order.jsp">删除订单</a></li>
        <li><a href="order.jsp">提交订单</a></li>
   
       </ul>
       <ul>
        <li class="ft-title">查看空间信息</li>
        <li><a href="space_gui.jsp">自提柜</a></li>
        <li><a href="space_shelf.jsp">货架区</a></li>
  
       </ul>
       <ul>
        <li class="ft-title">查看每日报告</li>
        <li><a href="DailyReport.jsp">生成报告</a></li>
        <li><a href="DailyReport.jsp">打印报告</a></li>
    
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
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
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
	 $(function(){
		 
		 $(".nav li:eq(4) a:first").addClass("navCur");
		 })
	</script>
    
   
  </body>
</html>