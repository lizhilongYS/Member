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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/layer/layer-v2.0/layer/layer.js"></script>
<!--[if lt IE 9]>
<script src="http://cdn.static.runoob.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
<![endif]-->
<title>留言信息</title>
<style>
#historymessagediv {
	margin-bottom: 5px;
	width: 100%;
	height: 70%;
}

#showmessagesdiv {
	height: 90%;
	width: 100%;
	overflow: auto;
}

#savemessagediv {
	height: 11%;
	width: auto;
	margin-bottom: 5px;
}

#messagecontenttxt {
	width: 100%;
	height: 100%
}

.userimg {
	width: 25px;
	height: 25px;
	border-radius: 50%;
}

@media ( max-width :767px) {
	#historybtngroup {
		width: 90%;
		left: 5%;
	}
	#historymessagediv {
		margin-bottom: 5px;
		width: 100%;
		height: 300px;
		overflow: auto;
	}
	#showmessagesdiv {
		font-size: 70%
	}
	#savemessagediv {
		height: 50px;
	}
	#savemessagebtn {
		position: static;
		left: 0px;
		width: 49%;
		bottom: 0px;
	}
	#historymessagebtn {
		position: static;
		left: 50%;
		width: 49%;
		bottom: 0px;
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
	initMaxMessageId();
	showmessages(); 
	$("#showmessagesdiv").scrollTop(99999);
	//指定10分钟刷新一次最新留言板
	setInterval(showmessages,1000*5);
	//初始化最大留言数
	function initMaxMessageId(){
		$.ajaxSetup({async:false});
		$.post("${pageContext.request.contextPath}/usermessage/initMaxMessageId.action");
	}
	//根据屏幕设置推荐周报弹出的宽和高
	var swinWidth,swinHeight;
	if(screen.width<=500){
		swinWidth='95%';
		swinHeight='80%' 
	}else{
		swinWidth='80%';
		swinHeight='80%'
	}
	$("#historymessagebtn").click(function(){
		layer.open({
			  type: 2,
			  title: '历史留言',
			  area: [swinWidth, swinHeight],
			  closeBtn: 1, 
			  shift: 1,
			  maxmin: true,
			  shade: 0.5, //开启遮罩关闭
			  scrollbar: false,
			  content: '${pageContext.request.contextPath}/member/messageboardhistory.jsp',
			  end: function(){}
		});
	})
	//发布留言函数
	function sendMessage(){
		var message = $("#messagecontenttxt").val();
		if (message=="" || message==null){
			layer.tips("请输入留言内容！","#messagecontenttxt");
			//alert("请输入留言内容！");
			return ;
		}
		//判断用户类型，并从session中取值
		var loginnumber = "";
		var name = "";
		var usertype = "";
		if("${ADMIN.realname}"!=null && "${ADMIN.realname}"!=""){
			usertype="admin";
			loginnumber = "${ADMIN.name}";
			name = "${ADMIN.realname}"			
		}else if("${myuser.name}"!=null && "${myuser.name}"!=""){ 
			usertype="user";
			loginnumber = "${myuser.name}";
			name = "${myuser.member.name}";
		}else if("${EXPERIENCE.num}"!=null && "${EXPERIENCE.num}"!=""){
			usertype="experience";
			loginnumber = "${EXPERIENCE.num}";
			name = "${EXPERIENCE.name}";			
		}else if ("${CLUE.num}"!=null && "${CLUE.num}"!=""){
			usertype="clue";
			loginnumber = "${CLUE.num}";
			name = "${CLUE.realName}";
		}else{
			alert("用户未登录，请重新登录！");
			return ;
		}
		//ajax请求保存留言，成功后重新加载最新留言
		$.post("${pageContext.request.contextPath}/usermessage/saveUserMessage.action",
				{usertype:usertype, loginnumber: loginnumber,name:name,message:message},function(data){
			if(data=="1"){//重新加载留言板
				showmessages();
				$("#messagecontenttxt").val("");
			}
		})		
	}
	//按保存按钮发留言
	$("#savemessagebtn").click(function(){
		sendMessage();
	})
	
	//按回车键发留言
    $('textarea').keydown(function(event){
        if(event.keyCode==13){
        	sendMessage();
        }
    });
	//根据ajax请求来的数据组合生成留言面板的内容，相邻留言用不同颜色表示
	function getMessages(data){
		var colors=new Array("red","CornflowerBlue","Chocolate","purple","Gold","BlueViolet");
		if(data==null || data=="") {
			return "";
		}
		var dataObj = eval("("+data+")");
		var count = dataObj.COUNT; 
		if (count==0){
			return "";
		}
		var list = dataObj.LIST; 
		var line = ""; 
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
			line = line +"<img class='userimg' src='"+src+"'></img>&nbsp;&nbsp;<b><big>"+ dateinfo + "</big></b>" + ",<b><big>" + list[i].name + "[" + list[i].loginnumber + "]" + "：</big></b><br/>&emsp;&emsp;&ensp;"
				 	+ list[i].message; 
			line = line + "</p>";
		}
		return line;
	}

	//显示第一批留言
	function showmessages(){
		$.ajaxSetup({async:false});
		$.post("${pageContext.request.contextPath}/usermessage/getNewUserMessages.action",
				{gettype:"0"},function(data){
			var newline = getMessages(data);
			if (newline=="") return ;
			$("#showmessagesdiv").html(newline);
			//$("#showmessagesdiv").scrollTop(99999);
			$.post("${pageContext.request.contextPath}/user/logger.action",{content:"messageboard.jsp:showmessage"});
		})
	}
});
</script>
</head>
<body>

	<div class="panel panel-primary" id="historymessagediv">
		<div class="panel-heading">
			<h5 class="panel-title">留言板</h5>
		</div>
		<div id="showmessagesdiv" class="panel-body"></div>
	</div>

	<div id="savemessagediv" class="panel panel-primary">
		<textarea id="messagecontenttxt"></textarea>
	</div>
	<div class="btn-group " id="historybtngroup"
		style="position: absolute; right: 0%">
		<input type="button" class="btn btn-primary" id="savemessagebtn"
			value="提交留言"> <input type="button" class="btn btn-info"
			id="historymessagebtn" value="历史留言">
	</div>

</body>
</html>