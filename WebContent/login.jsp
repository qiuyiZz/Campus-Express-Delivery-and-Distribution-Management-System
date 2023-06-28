<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>元创易站校园快递收发管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Tab Widget Form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

<link href="static/css_login/style.css" rel="stylesheet" type="text/css" media="all" />
<!--//Custom Theme files -->
<!--js-->
<script src="static/js_login/jquery.min.js"></script>
<script src="static/js_login/easyResponsiveTabs.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			$('#horizontalTab').easyResponsiveTabs({
				type: 'default',
				width: 'auto',
				fit: true   
			});
		});
	   </script>
<script type="text/javascript">
           var tip = null;
     <% String msg=(String)request.getAttribute("msg");if(msg!=null){String temp = "tip = '"+msg+"'";out.println(temp);}%>
    if(tip!=null){
        window.onload = function(){
        alert(tip);
         }
     }
 </script>
<!--//js-->
</head>
<body>
	<!-- main -->
	<div class="main">
		<h1>元创易站校园快递收发管理系统</h1>
		<div class="main-info">
			<div class="sap_tabs">
				<div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
					<ul class="resp-tabs-list">
						<li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><h2><span>登录</span></h2></li>
						<li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>注册</span></li>
						<div class="clear"> </div>
					</ul>				  	 
					<div class="resp-tabs-container">
						<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
							<div class="login-top">
								<form action="login" method="get" >
									<input type="text" name="username" class="name" placeholder="账号"  required=""/>
									<input type="password" name="password" class="password" placeholder="密码" required=""/>
									<div >
									  <span style="width: 20%;font-size: 1em;color: #999;">您的角色：</span>
									  <select name="role" style="width: 50%; margin: 0px; font-size: 1em;color: #999;">
                                           <option value="用户">用户</option>
                                           <option value="员工">员工</option>
                                      </select>
									</div>	
									<input type="checkbox" id="brand" value="">
							
								<div class="login-bottom">
									<ul>
										<li>
											<a href="#">忘记密码?</a>
										</li>
										<li>
											<input type="submit" value="登录"/>
										</li>
									<ul>
					            </form>
									<div class="clear"></div>
								</div>	
							</div>
						</div>
						<div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
							<div class="login-top sign-top">
								<form action="login" method="post">
									<input type="text" class="name active" name="name" placeholder="您的姓名" required=""/>
									<input type="text" class="email" name="phone" placeholder="您的手机号" required=""/>
									<input type="password" class="password" name="password" placeholder="密码" required=""/>		
									<input type="checkbox" id="brand1" value="">
								<div class="login-bottom">
									<ul>
										<li>
											<a href="#">忘记密码?</a>
										</li>
										<li>
											
												<input type="submit" value="注册"/>
											
										</li>
									<ul>
								</form>
								
									<div class="clear"></div>
								</div>	
							</div>
						</div>
					</div>	
				</div>
				<div class="clear"> </div>
			</div>
		</div>	
		<!--copyright-->
		<div class="copyright">
			<p> Copyright © 2020 Wliu Co.,Ltd.    京ICP备00000000号    北京市昌平区沙河高教园 技术支持：Reserved</p>
		</div>
		<!--//copyright-->
	</div>	
</body>
</html>

