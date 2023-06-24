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
    
            <link rel="stylesheet" href="/Express/static/css_send/font.css">
        <link rel="stylesheet" href="/Express/static/css_send/xadmin.css">
                <link rel="stylesheet" href="/Express/static/css_send/layui.css">
        <script src="/Express/static/js_send/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="/Express/static/js_send/xadmin.js"></script>
   
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    .layui-form-label{
    width:100px;
    }
    .layui-input.a{
    width:600px;
    }
    .layui-input.e1{
    width:190px;
    }
 
    .layui-input-inline {
    float: left;
    width:190px;
    height:38px;
    margin-right: 10px;
    }
    
    </style>
    <script>
    <% 
    HttpSession isession = request.getSession();
	String phone=(String) isession.getAttribute("userID");
	//String name="";//(String) su.select("users", "userName", "userID='"+phone+"'").get(0).get(0);
    String name="发件人";
	%>
	
	var name="<%=name%>";
	var phone="<%=phone%>";
	
             window.onload = function(){
                var oName = document.getElementById('sname');
                var oPhone = document.getElementById('sphone');
                oName.setAttribute("placeholder",name);
                oPhone.setAttribute("placeholder",phone);
             };
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
            <li><a href=" ">首页</a ></li>
            <li>
                <a href="/Express/servlet/receiveC">快件查询</a >
                <div class="chilNav">
                    <a href="/Express/servlet/receiveC">收件查询</a >
                    <a href="/Express/servlet/sendC">寄件查询</a >
                </div>
            </li>
            <li>
                <a href="/Express/send.jsp">寄件</a >

            </li>
             <li>
                <a href="/Express/timetable.jsp">时间管理</a >
                <div class="chilNav">
                    <a href="/Express/timetable.jsp">录入时间表</a >
                    <a href="/Express/timedelay.jsp">申请延迟取件</a >

                </div>
            </li>
            <li>
            </li>
            <li>
                <a href="enter_profile1"><img src="/Express/static/image/个人中心.png" width="45"/>个人中心</a >
            </li>
            <div class="clears"></div>
        </ul>
    </div><!--nav/-->
  <div class="content" style="background:#f8f8f8">
        <div class="width1003">
          <div class="PublicContentBox">
                <!--公用指向页面名字-->
               
               
                <!--表修改-->
                <div class="InquireTableBox">
                    
                       
                        
    <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                <form class="layui-form" action="send" method="post">
                 <fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px; margin-left: 3%;">
                        <legend>寄件人信息</legend>
                    </fieldset>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            
                            姓名
                        </label>
                        <div class="layui-input-block lafite_width_30">
                        <input type="text" name="sname" id="sname" required  lay-verify="required" placeholder="guo" autocomplete="off" class="layui-input a">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            
                             电话
                        </label>
                        <div class="layui-input-block lafite_width_30">
                        <input type="text" name="sphone" id="sphone" required  lay-verify="required" placeholder="13120498011" autocomplete="off" class="layui-input a">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">
                             寄件地址
                        </label>
                        <div class="layui-input-block lafite_width_30">
                        <input type="text" name="sadress" required  lay-verify="required" placeholder="中央财经大学" autocomplete="off" class="layui-input a">
                        </div>
                    </div>

              

                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px; margin-left: 3%;">
                        <legend>收件人信息</legend>
                    </fieldset>

                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            姓名
                        </label>
                        <div class="layui-input-block lafite_width_30">
                        <input type="text" name="rname" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input a">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            电话
                        </label>
                        <div class="layui-input-block lafite_width_30">
                        <input type="text" name="rphone" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input a">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                             收件地址
                        </label>
                        <div class="layui-input-block lafite_width_30">
                        <input type="text" name="radress" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input a">
                        </div>
                    </div>
                    
                    
                    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 40px; margin-left: 3%;">
                        <legend>其他信息</legend>
                    </fieldset>
                     <div class="layui-form-item">
                      <div class="layui-inline">
                        <label class="layui-form-label">
                            快递公司
                        </label>
                       <div class="layui-input-inline">
                                <select name="kuaidi" lay-verify="required">
                                    <option value=""></option>
                                    <option value="0">圆通快递</option>
                                    <option value="1">中通快递</option>
                                    <option value="2">申通快递</option>
                                    <option value="3">韵达快递</option>
                                    <option value="4">百世快递</option>
                                </select>
                            </div>
                    
                        <label class="layui-form-label">
                            物品重量
                        </label>
                     <div class="layui-input-inline">
                                <select name="weight" lay-verify="required">
                                    <option value=""></option>
                                    <option value="0">1KG</option>
                                    <option value="1">2KG</option>
                                    <option value="2">3KG</option>
                                    <option value="3">其他</option>
                                
                                </select>
                            </div>
                    </div>
 </div>
                
                   
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="lafite-layui-btn" onclick="xadmin.del_tab()">取消</button>
                          <button lay-submit lay-filter="formDemo" class="lafite-layui-btn2 lafite_margin_left_20px" onclick="sub()" >提交</button>
                           
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

            $(".nav li:eq(2) a:first").addClass("navCur");
        })
    </script>
<script>
       function sub(){
      var r="<%=session.getAttribute("right")%>"
      if(r=="y")
    	  alert("success!");
      else
    	  alert("failed!");
      
       }
       
layui.use(['laydate', 'form', 'upload'],
        function() {
            var $ = layui.jquery
            ,upload = layui.upload;

            var laydate = layui.laydate;

});  

            /*用户-取消*/
            function member_del() {
                layer.confirm('离开将不保存填写内容！',
                function(index) {
                    //发异步删除数据
                });
            }
          
            
            </script>
</body>
</html>