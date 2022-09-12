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
    <script src="/Express/static/js/jquery-1.9.1.min.js"></script>
    <script src="/Express/static/js/f.js"></script>
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
     
   
   
       <div class="content" style="background:#f8f8f8">
        <div class="width1003">
           <div class="PublicContentBox">
                <!--公用指向页面名字-->
                <div class="PublicPointToAgeText">
                    <span class="span1">运单管理 </span> <span class="span2">后台运单管理列表</span>
                </div>
                <!--查询-->
                <div class="InquireBox clearfix">
                    <div class="InquireleftBox">
                        <div class="Text">快递单号：</div>
                        <div class="InputDiv">   <input class="phoneInput" placeholder="请输入你需要查询的快递单号" /></div>
                    </div>
                    <div class="PublicBtnIcon Color1Btn fr">
                        <i class="iconfont icon-icon-chaxun"></i>
                        <span>查询</span>
                    </div>
                </div>
                <!--表修改-->
                <div class="InquireTableBox">
                    <div class="headbox">
                        <div class="headboxtext">
                            <span class="span1">后台运单管理列表</span>
                        </div>
                        <!--批量提交-->
                        <div class="PublicBtnIcon Color5Btn">
                            <i class="iconfont  icon-shanchu"></i>
                            <span>批量提交</span>
                        </div>

                        <!--<div class="PublicBtnIcon Color2Btn fr Js_edit">
                            <i class="iconfont icon-changyongtubiao-mianxing-"></i>
                            <span>添加</span>
                        </div>-->
                    </div>

                    <!--查询到的表格-->

                    <div class="InquireSelectTable">
                        <table class="PublicTableCss">
                            <thead>
                                <tr>
                                    <td>
                                        <input id="inputcheck" class="inputcheck" type="checkbox" name="inputcheck" />
                                        <label for="inputcheck"></label>
                                        <span>全选</span>
                                    </td>
                                    
                                    <td>快递单号</td>
                                    <td>寄件人</td>
                                    <td>寄件人电话</td>
                                    <td>寄件地址</td>
                                    <td>收件人</td>
                                    <td>收件人电话</td>
                                    <td>收件地址</td>
                                    <td>寄件时间</td>
                                    <td>寄出时间</td>
                                    <td>支付金额</td>
                                    <td>操作</td>
                                </tr>

                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <input id="aa" class="inputcheck" type="checkbox" name="inputcheck" />
                                        <label for="aa"></label>
                                    </td>
                                    <td>11111111111</td>
                                    <td>张三</td>
                                    <td>13100000000</td>
                                    <td>中央财经大学</td>
                                    <td>李四</td>
                                    <td>15100000000</td>
                                    <td>天津大学</td>
                                    <td>2020-05-01 13:15:23</td>
                                    <td>2020-05-01 18:00:00</td>
                                    <td>0</td>

                                    <td>

                                        <div class="PublicTableBtnIcon Color3Btn Js_edit">
                                            <i class="iconfont icon-tubiaozhizuomobanyihuifu-"></i>
                                            <span>提醒</span>
                                        </div>

                                        <div class="PublicTableBtnIcon Color4Btn Js_delete">
                                            <i class="iconfont icon-shanchu"></i>
                                            <span>提交</span>
                                        </div>
                                    </td>
                                </tr>

                              


                            </tbody>
                        </table>

                    </div>
                    <!--分页-->
                    <div class="PageNumber">
                        <div class="NumbersBox">
                            <div class="LeftArrow">
                                上一页
                            </div>
                            <ul>
                                <li class="Select">1</li>
                                <li class="">2</li>
                                <li class="">...</li>
                                <li class="">4</li>
                                <li class="">5</li>
                            </ul>
                            <div class="RightArrow ">
                                下一页
                            </div>
                        </div>
                    </div>


                </div>
            </div>

        </div>
    </div>


    <!-- alert通用 提示是否提交-->
    <div class="PublicFloatBox f_delete">
        <div class="f_MiddleBox wid260">
            <div class="f_Head">
                <span>提示消息</span>
                <i class="Js_closeBtn iconfont icon-buoumaotubiao20 fr"></i>
            </div>
            <div class="f_content clearfix">
                <!--提示消息内容-->
                <div class="f_someText">
                    <i class="iconfont icon-tishi"></i>
                    <span>确定提交此订单？</span>
                </div>
                <!--按钮-->
                <div class="f_pormatBtn  clearfix">
                    <div class="f_pormatBtn1">
                        确定
                    </div>
                    <div class="f_pormatBtn2">
                        取消
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--发送支付提醒-->
    <div class="PublicFloatBox adduser">
        <div class="f_MiddleBox wid400">
            <div class="f_Head">
                <span>提示消息</span>
                <i class="Js_closeBtn iconfont icon-buoumaotubiao20 fr"></i>
            </div>
            <div class="f_content clearfix">
                <!--提示消息内容-->
                <div class="f_someText">
                    <i class="iconfont icon-tishi"></i>
                    <span>确定向寄件人发送支付提醒？</span>
                </div>
                <!--按钮-->
                <div class="f_pormatBtn  clearfix">
                    <div class="f_pormatBtn1">
                        确定
                    </div>
                    <div class="f_pormatBtn2">
                        取消
                    </div>
                </div>
                    </div>
                </div>
                </div>
         </div><!--width1003/-->
     </div><!--content/-->
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
		 
		 $(".nav li:eq(2) a:first").addClass("navCur");
		 })
	</script>
    
  </body>
</html>