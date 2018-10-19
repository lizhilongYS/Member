<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息展示-Java互助学习VIP群业务运行系统</title>

<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/images/favicon.ico" />
<link
	href="${pageContext.request.contextPath}/tableTemplet/css/H-ui.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/tableTemplet/lib/Hui-iconfont/1.0.1/iconfont.css"
	rel="stylesheet" type="text/css" />

<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<!--[if lt IE 9]>
<script src="http://cdn.static.runoob.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
<![endif]-->
<style type="text/css">
#infodiv {
	margin-top: 0px;
	padding-top: 0px;
	height: 600px;
	width: 100%;
	overflow: hidden;
}

#infop {
	height: 40px;
	margin: 0 0;
}

#noticediv {
	width: 100%;
	height: 50%;
	margin-left: 0px;
	margin-bottom: 5px;
	margin-right: 5px;
}

#summarysdiv {
	width: 100%;
	height: 42%;
	margin-left: 0px;
}

/*#messageboarddiv {*/
	/*position: absolute;*/
	/*right: 0%;*/
	/*top: 40px;*/
	/*width: 35%;*/
	/*height: 620px;*/
	/*overflow: auto;*/
/*}*/

@media ( max-width :767px) {
	#infonav {
		width: auto;
	}
	#infop {
		display: none;
	}
	#infodiv {
		height: auto;
		overflow: auto
	}
	#noticediv {
		width: auto;
		height: auto;
	}
	#summarysdiv {
		width: 100%;
		height: 100%;
		margin-left: 0px;
		display: none;
	}
	/*#messageboarddiv {*/
		/*position: static;*/
		/*left: 0px;*/
		/*bottom: 0px;*/
		/*width: 100%;*/
		/*height: auto;*/
		/*display: none;*/
	/*}*/
}
/*html5兼容*/
article, aside, dialog, footer, header, section, footer, nav, figure,
	menu {
	display: block
}
</style>

<script type="text/javascript">
$(function(){
	//登录后显示三个div，公告，推荐周报，留言板，通过ajax请求加载
	$.ajaxSetup({async:false});
	$.post("${pageContext.request.contextPath}/user/logger.action",{content:"infoshow.jsp:historyinboard.jsp"});
	$("#noticediv").load("${pageContext.request.contextPath}/notice/historyinboard.jsp");
	$.post("${pageContext.request.contextPath}/user/logger.action",{content:"infoshow.jsp:lookrecmmendedsummarys.jsp"});
	$("#summarysdiv").load("${pageContext.request.contextPath}/member/lookrecmmendedsummarys.jsp"); 
 	<%--$.post("${pageContext.request.contextPath}/user/logger.action",{content:"infoshow.jsp:messageboard.jsp"});--%>
	<%--$("#messageboarddiv").load("${pageContext.request.contextPath}/member/messageboard.jsp");--%>
	$("#noticeli").click(function(){
		$("#summaryli").removeClass("active");
		$("#noticeli").addClass("active");
		$("#messageli").removeClass("active");
		$("#noticediv").show();
		$("#summarysdiv").hide();
		$("#messageboarddiv").hide();
	})
	$("#summaryli").click(function(){
		$("#summaryli").addClass("active");
		$("#noticeli").removeClass("active");
		$("#messageli").removeClass("active");
		$("#summarysdiv").show();
		$("#noticediv").hide();
		$("#messageboarddiv").hide();
	})
	// $("#messageli").click(function(){
	// 	$("#summaryli").removeClass("active");
	// 	$("#noticeli").removeClass("active");
	// 	$("#messageli").addClass("active");
	// 	$("#noticediv").hide();
	// 	$("#summarysdiv").hide();
	// 	$("#messageboarddiv").show();
	// })
});
</script>
</head>
<body>

	<div id="infodiv">
		<p id="infop" class="f-20 text-success">欢迎登录VIP会员系统！</p>
		<div id="infonav">
			<ul class="nav nav-pills visible-xs">
				<li id="noticeli" class="active"><a class="text-center"
					href="#">公告</a></li>
				<li id="summaryli"><a class="text-center" href="#">周报推荐</a></li>
				<%--<li id="messageli"><a class="text-center" href="#">留言板</a></li>--%>
			</ul>
		</div>
		<div id="noticediv"></div>
		<!-- 周报div summarysdiv-->
		<div id="summarysdiv"></div>
		<%--<div id="messageboarddiv"></div>--%>
	</div>


</body>
</html>