<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="servlet.result"%>
     <%@ page import=" com.alibaba.fastjson.*"%>
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
  
       <%  

   int num=Integer.parseInt(session.getAttribute("num1").toString());
   String jsonStringrr=session.getAttribute("array1").toString();
 // System.out.println( jsonStringrr);

%> 
   
  </head>
  <body>

   <div class="header">
        <div class="width1003">
            <h3 class="logo"><a href="/Express/index.jsp"><img src="/Express/static/image/logo.jpg" width="80" />&nbsp;&nbsp;&nbsp;元创易站</a></h3>
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
            <li><a href="/Express/index.jsp">首页</a></li>
            <li>
                <a href="/Express/servlet/sign">收件管理</a>
                <div class="chilNav">
                    <a href="/Express/servlet/sign">签收录入</a>
                    <a href="/Express/servlet/distribute">派件</a>
                    <a href="/Express/servlet/example">问题件</a>

                </div>
            </li>
            <li>
                <a href="/Express/servlet/order">寄件管理</a>
                

            </li>
            <li>
                <a href="#">查看空间信息</a>
                <div class="chilNav">
                    <a href="/Express/enter_grid">自提柜</a>
                    <a href="/Express/enter_shelf">货架区</a>
                </div>
            </li>
            <li>
                <a href="/Express/servlet/report">查看每日报告</a>

            </li>

            <li>
            </li>
            <li>
                <a href="/Express/enter_profile"><img src="/Express/static/image/个人中心.png" width="45"/>个人中心</a>
            </li>
       <div class="clears"></div>
      </ul>
     </div><!--nav/-->
     
   
   
       <div class="content" style="background:#f8f8f8">
        <div class="width1003">
          <div class="PublicContentBox">
                <!--公用指向页面名字-->
                <div class="PublicPointToAgeText">
                    <span class="span1">签收录入</span> <span class="span2">签收录入快件列表</span>
                </div>
                <!--查询-->
                
                <div class="InquireBox clearfix">
                <form action="servlet/sign" method="post" >
                    <div class="InquireleftBox">
                        <div class="Text">快递单号：</div>
                        <div class="InputDiv">   <input class="phoneInput" placeholder="请输入你需要查询的快递单号" /></div>
                    </div>
                    <div class="PublicBtnIcon Color1Btn fr">
                        <i class="iconfont icon-icon-chaxun"></i>
                        <input type="submit" value="签收查询">
                       
                    </div>
                    </form>
                </div>
                <!--表修改-->
                <div class="InquireTableBox">
                    <div class="headbox">
                        <div class="headboxtext">
                            <span class="span1">签收录入快件列表</span>
                        </div>

                        <div class="PublicBtnIcon Color2Btn fr Js_edit">
                            <i class="iconfont icon-changyongtubiao-mianxing-"></i>
                            <span>添加</span>
                        </div>
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
                                    <td>收件人</td>
                                    <td>收件人电话</td>
                                    <td>签收时间</td>
                                </tr>

                            </thead>
                            <tbody id="result">
                            

                               
                              

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

   


    <!-- alert通用 提示是否删除-->
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
                    <span>确定删除此信息？</span>
                </div>
                <!--按钮-->
                <div class="f_pormatBtn  clearfix">
                    <div class="f_pormatBtn1">
                        确定
                    </div>
                    <div class="f_pormatBtn2">
                        删除
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--签收录入-->
    <div class="PublicFloatBox adduser">
        <div class="f_MiddleBox wid400">
            <div class="f_Head">
                <span>签收录入</span>
                <i class="Js_closeBtn iconfont icon-buoumaotubiao20 fr"></i>
            </div>
            <div class="f_content">
                <div class="f_alonediv">
                    <div class="f_alone_name">
                        快递单号:
                    </div>
                    <div class="f_alone_input">
                        <input class="f_p_input1" />
                    </div>
                    <!--提示消息-->
                    <div class="f_pormat">
                        请输入快递单号
                    </div>
                </div>
                <div class="f_alonediv">
                    <div class="f_alone_name">
                        收件人:
                    </div>
                    <div class="f_alone_input">
                        <input class="f_p_input2" />
                    </div>
                    <!--提示消息-->
                    <div class="f_pormat">
                        请输入正确的收件人姓名
                    </div>
                </div>
                <div class="f_alonediv">
                    <div class="f_alone_name">
                       收件人电话:
                    </div>
                    <div class="f_alone_input">
                        <input class="f_p_input3" />
                    </div>
                    <!--提示消息-->
                    <div class="f_pormat">
                        请输入正确的收件人电话
                    </div>
                </div>
                  <!--
                <div class="f_alonediv">
                    <div class="f_alone_name">
                        签收时间:
                    </div>
                    <div class="f_alone_input">
                        <input class="f_p_input4" />
                    </div>
                    <!--提示消息
                    <div class="f_pormat">
                        请输入正确的签收时间
                    </div>
                </div>
                -->
                <div class="f_alonediv1">
                    <div class="f_alone_name">
                    </div>
                    <div class="f_alone_input1">
                        <!--publicbtn-->
                        <div class="publicf_btn">
                            <div class="publicf_btn1">
                                确定
                            </div>
                            <div class="publicf_btn2 fr Js_closeBtn">
                                取消
                            </div>
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
		 
		 $(".nav li:eq(1) a:first").addClass("navCur");
		 })
	</script>
	
    <script>
     // 获取元素
     var number = document.querySelector('.f_p_input1');
     var name1 = document.querySelector('.f_p_input2');
       var phone = document.querySelector('.f_p_input3');
     var time = document.querySelector('.f_p_input4');
     var btn = document.querySelector('.publicf_btn1');
     var tbody = document.querySelector('tbody');
 
     btn.onclick =function () {
         //检测输入的内容不为空
         if(number.value === '' || name.value === ''|| phone.value === ''|| time.value === '')
             alert('请输入内容');
         else {
             //创建节点
             var tr = document.createElement('tr');
             var td1 = document.createElement('td');
             var td2 = document.createElement('td');
             var td3 = document.createElement('td');
             var td4 = document.createElement('td');
             var td0=document.createElement('td');
             var td5= document.createElement('td');
             //获取元素内容
             td0.innerHTML = '<td>'+
             ' <input id="aa" class="inputcheck" type="checkbox" name="inputcheck" />'+
             ' <label for="aa"></label>'+
         ' </td>'
             td1.innerHTML = number.value;
             td2.innerHTML = name1.value;
             td3.innerHTML = phone.value;
             td4.innerHTML = time.value;
             td5.innerHTML = '<td>'+

             ' <div class="PublicTableBtnIcon Color3Btn Js_edit">'+
                 ' <i class="iconfont icon-tubiaozhizuomobanyihuifu-"></i>'+
                 ' <span>编辑</span>'+
             ' </div>'+

             ' <div class="PublicTableBtnIcon Color4Btn Js_delete">'+
                 ' <i class="iconfont icon-shanchu"></i>'+
                  '<span>删除</span>'+
              '</div>'+
         ' </td>'
             //添加内容到表格中
            tr.append(td0);
             tr.append(td1);
             tr.append(td2);
             tr.append(td3);
             tr.append(td4);
             tr.append(td5);
             
             tbody.append(tr);
         }
     }
 </script>
 <script type="text/javascript">


 function del(a){
 	var tmp=document.createElement("form");
 	var action="/sign.do?param1="+a;
 	tmp.action=action;
 	 tmp.method = "post"; 
 	 document.body.appendChild(tmp); 
      tmp.submit(); 
      return tmp; 

 }
 
 </script>
   <script>
 var html="";
 var num="<%=num%>";

 var data=<%=jsonStringrr%>;
 for(var i=0;i<num;i++){
	 html+= '<tr>'+
    ' <td>'+
   ' <input id="aa" class="inputcheck" type="checkbox" name="inputcheck" />'+
     '<label for="aa"></label>'+
 '</td>'+
' <td>'+data[i].a+'</td>'+
' <td>'+data[i].b+'</td>'+
' <td>'+data[i].c+'</td>'+
' <td>'+data[i].d+'</td>'+
'</tr>';}
document.getElementById("result").innerHTML = html;
	 
 </script>
  </body>
</html>