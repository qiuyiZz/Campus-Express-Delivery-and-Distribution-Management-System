<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>校园快递收发管理系统</title>
    <link rel="shortcut icon" href="/Express/static/images/favicon.ico" />

    <!-- Bootstrap -->
    <link href="/Express/static/css1/bootstrap.min.css" rel="stylesheet">
    <link href="/Express/static/css1/style.css" rel="stylesheet">
    <link href="/Express/static/css1/response.css" rel="stylesheet">
    <link href="/Express/static/css1/silde.css" rel="stylesheet">
    <link href="/Express/static/css/reset.css" rel="stylesheet" />
    <link href="static/time_table/index.css" rel="stylesheet" />
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
           var tip = null;
     <% String msg=(String)request.getAttribute("msg");if(msg!=null){String temp = "tip = '"+msg+"'";out.println(temp);}%>
    if(tip!=null){
        window.onload = function(){
        alert(tip);
         }
     }
 </script>
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
    <!-- Swiper -->
                <body text="#000000">
                <br>
                <br>
                <form action="timetable" method="POST">
                        <div style="margin-left:30px">
                        <table border="2" cellspacing="0" cellpadding="0" class="doctor_table" width="1200">
                            <tr>
                                <td colspan="10"><div><h3>时间安排表</h3></div></td>
                            </tr>
                            <tr>
                                <td>时段</td>
                                <td><div class="time">周一</div></td>
                            	<td><div class="time">周二</div></td>
                            	<td><div class="time">周三</div></td>
                            	<td><div class="time">周四</div></td>
                            	<td><div class="time">周五</div></td>
                            	<td><div class="time">周六</div></td>
                            	<td><div class="time">周日</div></td>
                            </tr>
                            <tr>
                                <td class="tb_header">6:00-8:00</td>
                                <td> 
                                   <select name="11" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                            	<td> 
                                   <select name="21" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="31" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="41" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="51" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="61" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="71" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="tb_header">8:00-10:00</td>
                                <td> 
                                   <select name="12" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                            	<td> 
                                   <select name="22" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="32" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="42" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="52" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="62" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="72" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                            </tr>
                             <tr>
                                <td class="tb_header">10:00-12:00</td>
                                <td> 
                                   <select name="13" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                            	<td> 
                                   <select name="23" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="33" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="43" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="53" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="63" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="73" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                            </tr>
                             <tr>
                                <td class="tb_header">12:00-14:00</td>
                                <td> 
                                   <select name="14" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                            	<td> 
                                   <select name="24" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="34" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="44" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="54" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="64" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="74" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                            </tr>
                             <tr>
                                <td class="tb_header">14:00-16:00</td>
                                <td> 
                                   <select name="15" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                            	<td> 
                                   <select name="25" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="35" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="45" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="55" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="65" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="75" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                            </tr>
                             <tr>
                                <td class="tb_header">16:00-18:00</td>
                                <td> 
                                   <select name="16" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                            	<td> 
                                   <select name="26" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="36" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="46" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="56" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="66" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="76" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                            </tr>
                             <tr>
                                <td class="tb_header">18:00-19:00</td>
                                <td> 
                                   <select name="17" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                            	<td> 
                                   <select name="27" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="37" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="47" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="57" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="67" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="77" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td> 
                                </tr>
                                <tr>
                                <td class="tb_header">19:00-21:00</td>
                                <td> 
                                   <select name="18" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                            	<td> 
                                   <select name="28" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="38" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="48" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="58" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="68" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="78" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                            </tr>
                           <tr>
                                <td class="tb_header">21:00-23:00</td>
                                <td> 
                                   <select name="19" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                            	<td> 
                                   <select name="29" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="39" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="49" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="59" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="69" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                                <td> 
                                   <select name="79" style="font-size:1em">
                                      <option style="font-size:1em">空闲</option>
                                      <option style="font-size:1em">繁忙</option>
                                   </select>
                                </td>
                            </tr>
                            
                        </table>
                        </div>
                        <div class="islsub" style="text-align:center;" >
                              <input type="submit" style="width:120px;height:40px;font-size:1.6em;"value="提交时间表" />
                        </div>
                </form>
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

            $(".nav li:eq(3) a:first").addClass("navCur");
        })
    </script>
    <script type="text/javascript" src="static/time_table/jquery.min.js"></script>
</body>
</html>