<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width; initial-scale=1.0">
    <title>校园快递收发管理系统</title>
    <meta name="keywords" content="jQuery,选座">
    <!-- Bootstrap -->
    <link href="/Express/static/css1/bootstrap.min.css" rel="stylesheet">
    <link href="/Express/static/css1/style.css" rel="stylesheet">
    <link href="/Express/static/css1/response.css" rel="stylesheet">
    <link href="/Express/static/css1/silde.css" rel="stylesheet">
    <link href="/Express/static/css/reset.css" rel="stylesheet" />
     
    <style type="text/css">
        .demo {
            width: 700px;
            margin: 40px auto 0 auto;
            min-height: 450px;
        }

        @media screen and (max-width: 360px) {
            .demo {
                width: 340px
            }
        }

        .front {
            width: 300px;
            margin: 5px 32px 45px 32px;
            background-color: #f0f0f0;
            color: #666;
            text-align: center;
            padding: 3px;
            border-radius: 5px;
        }

        .booking-details {
            float: right;
            position: relative;
            width: 200px;
            height: 450px;
        }

            .booking-details h3 {
                margin: 5px 5px 0 0;
                font-size: 16px;
            }

            .booking-details p {
                line-height: 26px;
                font-size: 16px;
                color: #999
            }

                .booking-details p span {
                    color: #666
                }

        div.seatCharts-cell {
            color: #182C4E;
            height: 25px;
            width: 25px;
            line-height: 25px;
            margin: 3px;
            float: left;
            text-align: center;
            outline: none;
            font-size: 13px;
        }

        div.seatCharts-seat {
            color: #fff;
            cursor: pointer;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
        }

        div.seatCharts-row {
            height: 35px;
        }

        div.seatCharts-seat.available {
            background-color: #B9DEA0;
        }

        div.seatCharts-seat.focused {
            background-color: #76B474;
            border: none;
        }

        div.seatCharts-seat.selected {
            background-color: #E6CAC4;
        }

        div.seatCharts-seat.unavailable {
            background-color: #472B34;
            cursor: not-allowed;
        }

        div.seatCharts-container {
            border-right: 1px dotted #adadad;
            width: 400px;
            padding: 20px;
            float: left;
        }

        div.seatCharts-legend {
            padding-left: 0px;
            position: absolute;
            bottom: 16px;
        }

        ul.seatCharts-legendList {
            padding-left: 0px;
        }

        .seatCharts-legendItem {
            float: left;
            width: 90px;
            margin-top: 10px;
            line-height: 2;
        }

        span.seatCharts-legendDescription {
            margin-left: 5px;
            line-height: 30px;
        }

        .checkout-button {
            display: block;
            width: 80px;
            height: 24px;
            line-height: 20px;
            margin: 10px auto;
            border: 1px solid #999;
            font-size: 14px;
            cursor: pointer
        }

        #selected-seats {
            max-height: 150px;
            overflow-y: auto;
            overflow-x: none;
            width: 200px;
        }

            #selected-seats li {
                float: left;
                width: 72px;
                height: 26px;
                line-height: 26px;
                border: 1px solid #d3d3d3;
                background: #f7f7f7;
                margin: 6px;
                font-size: 14px;
                font-weight: bold;
                text-align: center
            }
    </style>

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
    <div id="main">

        <div class="demo">
            <div id="seat-map">
                <div class="front">货架区</div>
            </div>
            <div class="booking-details">
                <p>总货架数：<span>8</span></p>
                <p>最大可存快递数：<span>80</span></p>
                <p>已满货架数：<span>9</span></p>
                <p>未满货架数：<span>71</span></p>
                <p>货架区使用率：<span>10%</span></p>
                <form action="#" method="get">
                    <div><p>快递柜选择：<ul id="selected-seats"></ul></p></div>
                    <div class="islinput"><p>请输入订单号：<input type="text"/></p></div>
                    <div><p></p><input type="submit" class="checkout-button" value="存入快递" /></div>
                </form>  

                <div id="legend"></div>
            </div>
            <div style="clear:both"></div>
        </div>

        <br />
    </div>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.12.1.min.js"></script>
    <script type="text/javascript" src="/Express/static/js1/jquery.seat-charts.min.js"></script>
    <script type="text/javascript">
        var price = 70; /*票价*/
        $(document).ready(function () {
            var $cart = $('#selected-seats'), /*座位区*/
                $counter = $('#counter'), /*票数*/
                $total = $('#total'); /*总计金额*/

            var sc = $('#seat-map').seatCharts({
                map: [  /*座位图*/
                    'aaaaaa____',
                    'aaaaaa____',
                    'aaaaaa____',
                    'aaaaaa____',
                    'aaaaaa____',
                    'aaaaaa____',
                    'aaaaaa____',
                    'aaaaaa____'
                ],
                naming: {
                    top: false,
                    getLabel: function (character, row, column) {
                        return column;
                    }
                },
                legend: { /*定义图例*/
                    node: $('#legend'),
                    items: [
                        ['a', 'available', '未满'],
                        ['a', 'unavailable', '已满']
                    ]
                },
                click: function () { /*点击事件*/
                    if (this.status() == 'available') { /*可选座*/
                        $('<li>' + (this.settings.row + 1) + '货架' + this.settings.label + '层</li>')
                            .attr('id', 'cart-item-' + this.settings.id)
                            .data('seatId', this.settings.id)
                            .appendTo($cart);

                        $counter.text(sc.find('selected').length + 1);
                        $total.text(recalculateTotal(sc) + 1);

                        return 'selected';
                    } else if (this.status() == 'selected') { /*已选中*/
                        /*更新数量*/
                        $counter.text(sc.find('selected').length - 1);
                        /*更新总计*/
                        $total.text(recalculateTotal(sc) - 1);

                        /*删除已预订座位*/
                        $('#cart-item-' + this.settings.id).remove();
                        /*空闲*/
                        return 'available';
                    } else if (this.status() == 'unavailable') { /*已占用*/
                        return 'unavailable';
                    } else {
                        return this.style();
                    }
                }
            });
            /*已售出的座位*/
            //sc.get(['1_2', '4_1', '4_2', '6_1', '6_7', '8_5', '8_6', '8_7', '8_8', '10_1', '10_2']).status('unavailable');

        });
        /*计算总金额*/
        function recalculateTotal(sc) {
            var total = 0;
            sc.find('selected').each(function () {
                total += 1;
            });

            return total;
        }
    </script>
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
</body>
</html>