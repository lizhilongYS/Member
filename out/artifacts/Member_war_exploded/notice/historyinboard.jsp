<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- 
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/notice.css" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" />
<link href="${pageContext.request.contextPath}/tableTemplet/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/history.css" rel="stylesheet" type="text/css"/>
 -->
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<!--	
<script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer-v2.0/layer/layer.js"></script>
-->
<title></title>
<style>
#noticeboarddiv {
	margin: 0px 0px 0px 0px;
	padding: 0px 0px 0px 0px;
	width: 100%;
	height: 100%;
	overflow: hidden;
}

#noticeheaddiv {
	width: 100%;
}

#noticehead h5 {
	margin-top: 0px;
	padding-top: 0px;
}

#noticebodydiv {
	margin: 0px 0px 0px 0px;
	padding: 0px 0px 0px 0px;
	width: auto;
	height: 90%;
	overflow: auto;
}

#contentdiv {
	margin: 0px 0px 0px 0px;;
	padding: 0px 10px 0px 10px;
	height: 85%;
	overflow: auto;
}

.page-nav {
	height: 15%;
	padding-right: 120px;
}

.inscribediv {
	text-align: right
}

@media ( max-width :767px) {
	.page-nav {
		padding-right: 0px;
	}
}
</style>
<script type="text/javascript">
$(function(){
		var page2=1;
		getDate(page2);
		function getDate(page2){
			$.ajaxSetup({async:false});
			$.post("${pageContext.request.contextPath}/notice/getNotices.action",{page2:page2},function(data){
				if(data==null || data==null) return ; 
				var dataObj = eval("("+data+")");
				var navbar=dataObj.returnMap.navbar;
				var list=dataObj.returnMap.list;
				$(".page-nav").html(navbar);
				btnclick();
				if(list.length>0){
					drawTable(list);
					$.post("${pageContext.request.contextPath}/user/logger.action",{content:"historyinboard.jsp:notice drawtable"});
				}
				else{
					$("#title").html("*暂无数据...");
				}
			})
		}
		function drawTable(list){
			
			$("#contentdiv").empty();
			for(var i=0;i<list.length;i++){
				var condiv=$("<div>").addClass("condiv").appendTo($("#contentdiv"));
				var title=$("<p>").addClass("title").appendTo(condiv);
				$("<h4 class='text-center'>"+list[i].title+"</h4>").addClass("title").appendTo(title);
				$("<span>"+list[i].content+"</span>").addClass("condivtil").appendTo(title);
				//$("<br>").appendTo(condiv);
				//var iconspan=$("<span>").addClass("condivicon").appendTo(condiv);
				var inscribediv=$("<div>").addClass("inscribediv").appendTo(condiv);
				var iconspaniner=$("<span>").attr({style:"font-size: 14px;"}).addClass("glyphicon glyphicon-time").appendTo(inscribediv);
				$("<span>"+"管理员 "+list[i].realname+" 发表于 "+list[i].publishtime.substring(0,10)+"</span>").addClass("icon1iner").appendTo(iconspaniner);
				$("<hr/>").appendTo(condiv);
			}
			 
		}
		//分页按钮点击事件
		function btnclick(){
			$(".nav-btn").click(function(){
				page2=this.lang;
				getDate(page2);
			})
		}
});
</script>
</head>
<body>
	<div class="panel panel-primary " id="noticeboarddiv">

		<div class="panel-heading" id="noticeheaddiv">
			<h5 class="panel-title">最新公告</h5>
		</div>

		<div class="panel-body" id="noticebodydiv">

			<div id="contentdiv" class="text-justify"></div>

			<div class='page-nav'></div>
		</div>
	</div>
</body>
</html>