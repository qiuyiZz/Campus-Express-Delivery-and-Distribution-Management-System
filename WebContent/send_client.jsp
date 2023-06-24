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
     <%  

   int num=Integer.parseInt(session.getAttribute("num_sc").toString());
   String jsonStringrr=session.getAttribute("array_sc").toString();
 // System.out.println( jsonStringrr);

%> 
    <style type="text/css">
 
    
    </style>
</head>
<body>
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

       <div class="content" style="background:#f8f8f8">
        <div class="width1003">
          <div class="PublicContentBox">
                <!--公用指向页面名字-->
                <div class="PublicPointToAgeText">
                    <span class="span1">我寄的</span> <span class="span2">寄件列表</span>
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
                            <span class="span1">寄件列表</span>
                        </div>
                        

                       <!-- <div class="PublicBtnIcon Color2Btn fr Js_edit">
                            <i class="iconfont icon-changyongtubiao-mianxing-"></i>
                            <span>添加</span>
                        </div>-->
                    </div>

                    <!--查询到的表格-->

                    <div class="InquireSelectTable">
                        <table class="PublicTableCss">
                            <thead>
                                <tr>
                                   
                                     <td>快递单号</td>  
                                    <td>快递公司</td>                                  
                                    <td>寄件人</td>
                                    <td>寄件人电话</td>
                                    <td>寄件地址</td>
                                    <td>收件人</td>
                                    <td>收件人电话</td>
                                    <td>收件地址</td>
                                    <td>寄件时间</td>
                                    <td>支付金额</td>
                                  
                                </tr>

                            </thead>
                            <tbody id="result_sc">
                               
                               


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
        Copyright © 2020 Wliu Co.,Ltd.    京ICP备00000000号    北京市昌平区沙河高教园 技术支持：Reserved
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
        $(function () {

            $(".nav li:eq(1) a:first").addClass("navCur");
        })
         var html="";
 var num="<%=num%>";

 var data=<%=jsonStringrr%>;
 for(var i=0;i<num;i++){
	 html+= '<tr>'+
    
' <td>'+data[i].a+'</td>'+
' <td>'+data[i].b+'</td>'+
' <td>'+data[i].c+'</td>'+
' <td>'+data[i].d+'</td>'+
' <td>'+data[i].e+'</td>'+
' <td>'+data[i].f+'</td>'+
' <td>'+data[i].g+'</td>'+
' <td>'+data[i].h+'</td>'+
' <td>'+data[i].i+'</td>'+
' <td>'+data[i].j+'</td>'+
'</tr>';}
document.getElementById("result_sc").innerHTML = html;
    </script>

</body>
</html>