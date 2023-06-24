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
    <div class="swiper-container">
        <div class="swiper-wrapper">
            <div class="swiper-slide"><img src="/Express/static/image/banner1.png" /></div>
            <div class="swiper-slide"><img src="/Express/static/image/banner2.jpg" /></div>
            <div class="swiper-slide"><img src="/Express/static/image/banner3.jpg" /></div>
        </div>
        <!-- Add Pagination -->
        <div class="swiper-pagination"></div>
    </div>
    <!-- Swiper JS -->

    <div class="content">
        <div class="width1003">
            <h2 class="title">产品与服务 <span>/ Proudct & Service</span></h2>
            <div class="index-pro">
                <dl>
                    <a href="product.html">
                        <dt><img src="/Express/static/images/pcon1.png" width="100" height="100" /></dt>
                        <dd>
                            <h3>收件管理</h3>
                            <p>操作快捷，经济实用</p>
                        </dd>
                    </a>
                </dl>
                <dl>
                    <a href="product.html">
                        <dt><img src="/Express/static/images/pcon2.png" width="100" height="100" /></dt>
                        <dd>
                            <h3>定制派件</h3>
                            <p>个性定制，高效派件</p>
                        </dd>
                    </a>
                </dl>
                <dl>
                    <a href="product.html">
                        <dt><img src="/Express/static/images/pcon3.png" width="100" height="100" /></dt>
                        <dd>
                            <h3>查询服务</h3>
                            <p>响应快速，便捷实用</p>
                        </dd>
                    </a>
                </dl>
                <dl>
                    <a href="product.html">
                        <dt><img src="/Express/static/images/pcon4.png" width="100" height="100" /></dt>
                        <dd>
                            <h3>寄件服务</h3>
                            <p>专业打包，暖心服务</p>
                        </dd>
                    </a>
                </dl>
                <dl>
                    <a href="product.html">
                        <dt><img src="/Express/static/images/pcon5.png" width="100" height="100" /></dt>
                        <dd>
                            <h3>仓储物流</h3>
                            <p>定时定点，足不出户</p>
                        </dd>
                    </a>
                </dl>
                <div class="clearfix"></div>
            </div><!--index-pro/-->
        </div><!--width1003/-->
        <div class="index-search">
            <div class="width1003">
                <h2 class="title">自助服务 <span>/ Self Inquiry</span></h2>
                <div class="index-search-list">
                    <div class="isl-box">
                        <h2>收件查询</h2>
                        <form action="#" method="get">
                            <div class="islinput"><input type="text" placeholder="请输入订单号" /></div>
                            <div class="islsub"><input type="submit" value="查询" /></div>
                        </form>
                    </div>
                </div><!--index-search-list/-->
                <div class="index-search-list">
                    <div class="isl-box">
                        <h2>寄件查询</h2>
                        <form action="#" method="get">
                            <div class="islinput"><input type="text" placeholder="请输入订单号" /></div>
                            <div class="islsub"><input type="submit" value="查询" /></div>
                        </form>
                    </div>
                </div><!--index-search-list/-->
                <div class="index-search-list">
                    <div class="isl-box">
                        <h2>时间管理</h2>
                        <form action="choose_index" name="choose" method="get">
                            <div class="islinput">
                                <span ><big>时间管理类型:</big></span>
                                <select>
                                    <option value="快递柜"><big>录入时间表</big></option>
                                    <option value="货架区"><big>申请延迟</big></option>
                                </select>
                            </div><br>
                            <div class="islsub"><input type="submit" value="管理" /></div>
                        </form>
                    </div>
                </div><!--index-search-list/-->
                <div class="clearfix"></div>
            </div><!--index-search/-->
        </div><!--index-search/-->
        <div class="width1003">
            <h2 class="title">新闻快讯 <span>/ News</span></h2>
            <div class="index-new">
                <ul class="new fl">
                    <li><a href="newinfo.html">送1单快件能挣1块钱,郑州月薪过万的“五星快递员”是如何炼成的?</a><span>2020-05-02</span></li>
                    <li><a href="newinfo.html">专访省快递行业协会会长 送包裹也是送温暖</a><span>2020-05-02</span></li>
                    <li><a href="newinfo.html">D市快递业发展忧思，快递业竞争不应泛品牌集中</a><span>2020-05-02</span></li>
                    <li><a href="newinfo.html">快递柜超时收费，网友炸锅！丰巢负责人：请容我解释！</a><span>2020-05-02</span></li>
                    <li><a href="newinfo.html">黑龙江：快递小哥上了新闻发布会！</a><span>2020-05-02</span></li>
                    <li><a href="newinfo.html">阿里“集齐”四通一达，京东系众邮快递入局成鲇鱼？</a><span>2020-05-02</span></li>
                    <li><a href="newinfo.html">快递定情信物丢失，谁来买单？</a><span>2020-05-02</span></li>
                    <li><a href="newinfo.html">4月30日起，快递柜超时要收费了？你愿意买单吗？</a><span>2020-05-02</span></li>
                    <li><a href="newinfo.html">快递行业观察报告：强者愈强的高壁垒生态，“入侵者”们难以突围</a><span>2020-05-02</span></li>
                </ul>
                <div class="inde-new-img fr">
                    <img src="/Express/static/image/page1.jpeg" />
                </div>
                <div class="clearfix"></div>
            </div><!--index-new/-->
        </div><!--width1003/-->
        <div class="links">
            <div class="width1003">
                <h2 class="title">合作伙伴 <span>/ Partners</span></h2>
                <ul>
                    <li><a href="javascript:;"><img src="/Express/static/images/link1.jpg" /></a></li>
                    <li><a href="javascript:;"><img src="/Express/static/images/link2.jpg" /></a></li>
                    <li><a href="javascript:;"><img src="/Express/static/images/link3.jpg" /></a></li>
                    <li><a href="javascript:;"><img src="/Express/static/images/link4.jpg" /></a></li>
                    <li><a href="javascript:;"><img src="/Express/static/images/link5.jpg" /></a></li>
                    <li><a href="javascript:;"><img src="/Express/static/images/link6.jpg" /></a></li>
                    <li><a href="javascript:;"><img src="/Express/static/images/link7.jpg" /></a></li>
                    <li><a href="javascript:;"><img src="/Express/static/images/link8.jpg" /></a></li>
                    <li><a href="javascript:;"><img src="/Express/static/images/link9.jpg" /></a></li>
                    <li><a href="javascript:;"><img src="/Express/static/images/link1.jpg" /></a></li>
                    <div class="clearfix"></div>
                </ul>
            </div><!--width1003/-->
        </div><!--links/-->
    </div><!--content/-->
   <footer>
      <div class="width1003">
      <ul>
        <li class="ft-title">快件查询</li>
        <li><a href="/Express/receive_client.jsp">收件查询</a></li>
        <li><a href="/Express/send_client.jsp">寄件查询</a></li>
    
       </ul>
       <ul>
        <li class="ft-title">寄件</li>
        <li><a href="/Express/send.jsp">寄件申请</a></li>
       </ul>
       <ul>
        <li class="ft-title">时间管理</li>
        <li><a href="/Express/timetable.jsp">录入时间表</a></li>
        <li><a href="/Express/timedelay.jsp">申请延迟</a></li>
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

            $(".nav li:eq(0) a:first").addClass("navCur");
        })
    </script>

</body>
</html>