<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理后台</title>
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/navbar/css/index.css"
	type="text/css" media="screen" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/navbar/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/navbar/js/tendina.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/navbar/js/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/layer/layer-v2.0/layer/layer.js"></script>
<!--[if lt IE 9]>
<script src="http://cdn.static.runoob.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
<![endif]-->
<style>
.left-menu {
	left: 0px;
	z-index: 9999
}

.right-content {
	z-index: 0;
}

.content {
	height: auto;
}

.bg {
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.5);
	position: fixed;
	top: 0;
	left: 0;
	z-index: 10;
	display: none;
}

@media ( max-width :992px) {
	.left-menu {
		left: -180px;
	}
	.left-menu.on {
		left: 0px;
	}
	.right-content {
		margin-left: 0px;
	}
}
/*html5兼容*/
article, aside, dialog, footer, header, section, footer, nav, figure,
	menu {
	display: block
}
</style>
<script type="text/javascript">
$(function(){
	$(".menu_icon").click(function(){
		$(".left-menu").addClass("on");
		$(".bg").fadeIn();
	}) 
	$(".bg").click(function(){
		$(".left-menu").removeClass("on");
		$(".bg").fadeOut();	
	})	
	$.ajaxSetup({
		  async: false
		  });
	/*
	//音乐播放器初始化
	myMusic.init();
	//音乐播放
	myMusic.play(); 
	*/
	$(".wrap").load("${pageContext.request.contextPath}/member/infoshow.jsp");	
	$("[title='主页']").click(function(){
		hidePhoneMenu();
		$(".wrap").load("${pageContext.request.contextPath}/member/infoshow.jsp");
	});	
	$("[title='进度选择']").click(function(){
		hidePhoneMenu();
		$(".wrap").load("${pageContext.request.contextPath}/course/chooseprogress.jsp");
	});	
	$("[title='会员进度']").click(function(){
		hidePhoneMenu();
		$(".wrap").load("${pageContext.request.contextPath}/course/progressbycategory.jsp");
	});
	$("[title='问题分享']").click(function(){
		hidePhoneMenu();
		$(".wrap").load("${pageContext.request.contextPath}/experience/sharequestion.jsp");
	});	
	$("[title='查看周报']").click(function(){
		hidePhoneMenu();
		$(".wrap").load("${pageContext.request.contextPath}/member/looksummarys.jsp");
	});	
	$("[title='我的周报']").click(function(){
		hidePhoneMenu();
		$(".wrap").load("${pageContext.request.contextPath}/personal/mysummarys.jsp");
	});
	$("[title='学习资源']").click(function(){
		hidePhoneMenu();
		$(".wrap").load("${pageContext.request.contextPath}/experience/resources.jsp");
	});
	taggleWriteAndModify();
	writeclick();
	modifyclick();	
	
});

function exit(){
	if(confirm("确定要退出吗？")) {
		$.post("${pageContext.request.contextPath}/user/clearSession.action",function(data) {
			window.location.href="${pageContext.request.contextPath}/index.jsp";
		});
	 }		
}	
function personal(){
	window.open("${pageContext.request.contextPath}/personal/navbar.jsp");
}

function taggleWriteAndModify(){
	$.ajaxSetup({ async : false });
	$.post("${pageContext.request.contextPath}/summary/checkIsRepeatByTit.action",function(data){
		if(data=="1")
		{
			$("#taggleWriteAndModify").html("<a style='cursor:pointer' href='javascript:;' title='编写周报'><i></i><i></i><i></i>编写周报</a>");
		}else{
			$("#taggleWriteAndModify").html("<a style='cursor:pointer' href='javascript:;' title='修改周报'><i></i><i></i><i></i>修改周报</a>");
		}
	
	});
	modifyclick();
}
	
function writeclick(){
		$("[title='编写周报']").click(function(){
			hidePhoneMenu();
			$(".wrap").load("${pageContext.request.contextPath}/summary/write.jsp");
		});
}
	
function modifyclick(){
	$("[title='修改周报']").click(function(){
		//判断是否管理员是否审核，审核则layer弹出不用修改		
		$.post("${pageContext.request.contextPath}/summary/isCheckSum.action",function(data){
			if(data == 1)
			{
				layer.msg('已经通过审核，不用修改了', {
				    icon: 1,
				    time: 2000
				});				
			}
			else{				
				hidePhoneMenu();
				$(".wrap").load("${pageContext.request.contextPath}/summary/modify.jsp");
			}
		});

	});
}
function hidePhoneMenu(){
	if($("body").width()<992){
		$(".left-menu").removeClass("on");
		$(".bg").fadeOut();	
	}
}
</script>

</head>
<body>
	<!--  <audio id="audio" src="${pageContext.request.contextPath}/css/mp3/星光雪,冰凝雪枫 - 涙の物語（Cover 有里知花）.mp3" loop></audio>-->
	<!--顶部-->
	<div class="top">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-2 col-xs-2">
					<div class="menu">
						<div class="menu_icon">
							<img src="../images/menu_icon.png" alt="" />
						</div>
						<span style="background-color: #333; color: #fff">菜单</span>
					</div>
				</div>
				<div class="col-sm-10 col-xs-10">
					<div style="float: left">
						<span
							style="font-size: 16px; line-height: 45px; padding-left: 20px; color: #fff; width: 100%;">VIP会员管理中心</span>
					</div>
					<div id="ad_setting" class="ad_setting">
						<a class="ad_setting_a" href="javascript:; ">${experience.name}</a>
						<ul class="dropdown-menu-uu" style="display: none"
							id="ad_setting_ul">
							<li class="ad_setting_ul_li" onclick="exit()"><a
								href="javascript:;"><i class="icon-signout glyph-icon"></i>
									<span class="font-bold">退出</span> </a></li>
						</ul>
						<img class="use_xl"
							src="${pageContext.request.contextPath}/navbar/images/right_menu.png" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--顶部结束-->
	<!--菜单-->

	<div class="left-menu">
		<ul id="menu">
			<li class="menu-list"><a style="cursor: pointer"
				href="javascript:;" title="主页"><i></i><i></i>主页</a></li>
			<li class="menu-list"><a style="cursor: pointer"><i></i><i></i>周报</a>

				<ul class="child-menu">
					<li id="taggleWriteAndModify"></li>
					<li><a style="cursor: pointer" href="javascript:;"
						title="我的周报"><i></i><i></i><i></i>我的周报</a></li>
					<li><a style="cursor: pointer" href="javascript:;"
						title="查看周报"><i></i><i></i><i></i>查看周报</a></li>
				</ul></li>
			<li class="menu-list"><a style="cursor: pointer"><i></i><i></i>课程进度</a>
				<ul class="child-menu">
					<li><a style="cursor: pointer" href="javascript:;"
						title="进度选择"><i></i><i></i><i></i>进度选择</a></li>
					<li><a style="cursor: pointer" href="javascript:;"
						title="会员进度"><i></i><i></i><i></i>会员进度</a></li>
					<li><a style="cursor: pointer" href="javascript:;"
						title="问题分享"><i></i><i></i>问题分享</a></li>
				</ul></li>
			<li class="menu-list"><a style="cursor: pointer" title="学习资源"><i></i><i></i>学习资源</a>
			</li>
			<li class="menu-list"><a style="cursor: pointer"
				href="${pageContext.request.contextPath}/index.jsp"><i></i><i></i>返回首页</a>
			</li>
		</ul>
	</div>
	<div class="bg"></div>
	<div class="right-content">
		<div class="content">
			<div class="container-fluid">
				<%-- <div class="wrap" style="padding-left:50px;margin-top:30px"></div>--%>
				<div class="wrap" style="padding-left: 0; margin-top: 0;"></div>
			</div>
		</div>
	</div>


</body>
</html>