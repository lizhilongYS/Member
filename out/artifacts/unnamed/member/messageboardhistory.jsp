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
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<!--
		<script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer-v2.0/layer/layer.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/notice.css" />
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" />
        
        <link href="${pageContext.request.contextPath}/tableTemplet/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/css/history.css" rel="stylesheet" type="text/css"/>
        -->
<!--[if lt IE 9]>
	<script src="http://cdn.static.runoob.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
<title>历史留言</title>
<style>
/*html5兼容*/
article, aside, dialog, footer, header, section, footer, nav, figure,
	menu {
	display: block
}
</style>
<script type="text/javascript">
$(function(){
	showmessages(); 
	//根据ajax请求到的数据组合生成历史留言内容
	function getMessages(data){
		var colors=new Array("red","CornflowerBlue","Chocolate","purple","Gold","BlueViolet");
		if(data==null || data=="") {
			return "";
		}
		var dataObj = eval("("+data+")");
		var count = dataObj.COUNT; 
		var list = dataObj.LIST; 
		var line = ""; 
		if (count==0){//如果取完了，显示所有留言已显示
			line = line + "<p>(所有留言已显示)</p>"
		}
		for (var i=list.length-1;i>=0;i--){ //按时间倒序，新的排前面
			line = line + "<p style='color:"+colors[i % colors.length]+";width:100%;height:auto;border:none;margin:5px;'>";
			//使用yyyy/MM/dd 初始化 date，
			var datestr = list[i].created ; 
			//使用正则表达式替换"-"为"/"
			datestr = datestr.replace(/-/g,"/");  
			var msgdate = new Date(datestr); 
			var lastmsgseconds =  Math.floor((new Date().getTime() - msgdate.getTime())/1000);
			var lastmsgminutes = Math.floor(lastmsgseconds / 60);
			var lastmsghours = Math.floor(lastmsgminutes / 60);
			var lastmsgdays = Math.floor(lastmsghours / 24);
			//超过30天按实际日期显示，如果介于1到30天就按天显示,如果介于1小时到24小时间用小时显示,1小时以内用分钟显示
			var dateinfo = "";
			if(lastmsgdays>30){ 
				dateinfo = msgdate.getFullYear()+"/"+(msgdate.getMonth()+1)+"/"+msgdate.getDate();
			}else if(lastmsgdays >=1 ){ 
				dateinfo = 	lastmsgdays + "天前";
			}else if(lastmsghours >= 1 ){ 
				dateinfo = 	lastmsghours + "小时前";
			}else if(lastmsgminutes>=1 ){
				dateinfo = 	lastmsgminutes + "分钟前";
			}else{
				dateinfo = 	"1分钟前";
			} 
			//增加头像图片
			var pid = list[i].pid;
			var sex = list[i].sex;
			var src;
			if (pid !=0 && pid!=null){
				$.ajaxSetup({async:false});
				src = "${pageContext.request.contextPath}/picture/getPictureByid.action?id=" + pid;
			}else if(sex=='男'){
				src = '${pageContext.request.contextPath}/images/user_male.png';
			}else{
				src = '${pageContext.request.contextPath}/images/user_female.png';
			}
			line = line +"<img style='width:25px;height:25px;border-radius: 50%;' src='"+src+"'></img>&nbsp;&nbsp;<b><big>"+ dateinfo + "</big></b>" + ",<b><big>" + list[i].name + "[" + list[i].loginnumber + "]" + "：</big></b><br/>&emsp;&emsp;&ensp;"
				 + list[i].message; 
			line = line + "</p>";
		}
		return line;
	}

	//显示第一批留言
	function showmessages(){
		$.ajaxSetup({async:false});
		$("#showmessageshistorydiv").html("");
		$.post("${pageContext.request.contextPath}/usermessage/getUserMessages.action",
				{gettype:"0"},function(data){
			var newline = getMessages(data);
			$("#showmessageshistorydiv").html(newline);
			$("#showmessageshistorydiv").scrollTop(99999);
			//$("body").scrollTop(99999);
			//滚动条拉到最前面，继续加载下一批留言数据
			$("#showmessageshistorydiv").scroll(function(){
			//$("body").scroll(function(){
				if($(this).scrollTop()==0){
					//加载数据
					showmessagesplus();
				}
			})					
		})
	}
	
	//显示再次获取的留言
	function showmessagesplus(){
		var oldline = $("#showmessageshistorydiv").html();
		//alert(oldline.index("<p>(所有留言已显示)</p>"))
		if(oldline.indexOf("<p>(所有留言已显示)</p>")>=0){
			return ;
		}
		$.ajaxSetup({async:false});
		$.post("${pageContext.request.contextPath}/usermessage/getUserMessages.action",
				{gettype:"1"},function(data){
			var newline = getMessages(data);		
			$("#showmessageshistorydiv").html(newline + oldline);
			$("#showmessageshistorydiv").scrollTop(50);
			//$("body").scrollTop(50);
		})
	}
});
</script>
</head>
<body style="overflow: auto;">
	<div class="container">
		<div class="panel panel-primary"
			style="margin-bottom: 5px; height: 500px; width: 100%; overflow: auto;">
			<div id="showmessageshistorydiv" class="panel-body"
				style="height: 90%; width: 100%; overflow: auto;"></div>
		</div>
	</div>
</html>