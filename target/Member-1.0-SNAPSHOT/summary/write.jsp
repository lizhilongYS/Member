<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编写周报-专注建立IT精英圈子</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/ueditor/themes/default/css/ueditor.css">
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/layer/layer-v2.0/layer/layer.js"></script>
<!--[if lt IE 9]>
<script src="http://cdn.static.runoob.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
<![endif]-->
<style>
.summarydiv {
	height: 300px;
	z-index: 5;
}

.titlediv {
	background-color: #EEEEEE;
}

#lastsummarybtn {
	margin-bottom: 5px
}

#btn {
	margin-top: 5px;
	position: absolute;
	left: 15px;
}

@media ( max-width :767px) {
	#lastsummarybtn {
		width: 100%;
		z-index: 5;
	}
	#btn {
		position: static;
		width: 100%
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
		$.ajaxSetup({async:false});
		$.post("${pageContext.request.contextPath}/user/logger.action",{content:"write.jsp:begin load"});
   		var ue = UE.getEditor('editor',{
   			initialFrameWidth: $(".summarydiv").width(),
   			initialFrameHeight: $(".summarydiv").height(),
   			enableAutoSave: false
   		});
   		ue.ready(function(){
				ue.setContent(data.content);
		});
   		$.ajaxSetup({async:false});
   		$.post("${pageContext.request.contextPath}/user/logger.action",{content:"write.jsp:load ok"});
   		$("#btn").click(function(){
   			var contents=UE.getEditor('editor').getContent();
   			if(contents == "" ){
   				alert("周报内容不能为空");
   				return false;
   			}
   			$.ajaxSetup({async:false});
    			$.post("${pageContext.request.contextPath}/summary/addSummary.action",{"content":contents},function(data){
    				if(data=="1"){
     					layer.msg('保存成功', {
    					    icon: 1,
    					    time: 1000
    					});
     					taggleWriteAndModify();
    				}else if(data=="2"){
     					layer.msg('别点啦~~ 已经提交过了', {
    					    icon: 1,
    					    time: 1000
     					});
     					taggleWriteAndModify();
    				}
      				else{
      					layer.open({
   					  type: 2,
   					  title: '登录',
   					  area: ['600px', '361px'],
   					  closeBtn: 1, //显示关闭按钮
   					  shift: 1,
   					  shade: 0.5, //开启遮罩关闭
   					  content: '${pageContext.request.contextPath}/summary/login.jsp?state=1&id=0&contents='+contents,
   					  end: function(){
						  
						  $.post("${pageContext.request.contextPath}/summary/updateSummary.action",{"content":contents},function(data){
						  if(data=="1"){
  	     					parent.layer.msg('保存成功', {
	    					    icon: 1,
	    					    time: 1000
	    					});
	     					var time=null;
	  		 					time=setInterval(function(){
	    	     				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	    						parent.layer.close(index);
	    					},1000);
						  }
						  else
						  {
							  parent.layer.msg('未保存成功', {
	    					    icon: 1,
	    					    time: 1000
	    					});
						  }
						  });
						  
   					    }
   					});
      				}
   			});
   		});
   		$("#lastsummarybtn").click(function(){
   			var userType = "";
			var userId = 0; 
   			if("${myuser.name}"!=null && "${myuser.name}"!=""){ 
   				userType = "member";
   				userId = "${myuser.member.id}";
   			}else if("${EXPERIENCE.num}"!=null && "${EXPERIENCE.num}"!=""){
   				userType="experience";
				userId = "${EXPERIENCE.id}";
   			}else if ("${CLUE.num}"!=null && "${CLUE.num}"!=""){
   				userType="clue";
				userId = "${CLUE.id}";
   			}else{
   				alert("用户未登录，请重新登录！");
   				return ;
   			}
   			
   	    	//根据屏幕设置推荐周报弹出的宽和高
   	    	var swinWidth,swinHeight;
   	    	if($("body").width()<=767){
   	    		swinWidth='95%';
   	    		swinHeight='80%' 
   	    	}else{
   	    		swinWidth='80%';
   	    		swinHeight='80%'
   	    	}
   			$.post("${pageContext.request.contextPath}/summary/getCurrentSummaryIdByUserId.action",{userType:userType, userId:userId},function(data){
   				if(data!=null && data!="" ){
   					if (data!="0"){
   						var nextId = data;
   						layer.open({
   						  type: 2,
   						  title: '查看周报',
   						  area: [swinWidth, swinHeight],
   						  shift: 1,
   						  maxmin: true,
   						  shade: 0.5, //开启遮罩关闭
   						  content: '${pageContext.request.contextPath}/summary/membersumcomment1.jsp?id='+nextId,
   						  end: function(){}
   						});   						
   					}
   					else{
   						alert("抱歉，你之前没有周报！");
   					}
   				}
   			})
   		})
	
});
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
</script>

</head>
<body>
	<c:if
		test="${myuser.member==null && experience==null && clue.num==null}">
		<c:redirect url="/user/login.jsp" />
	</c:if>
	<div>
		<div>
			<br /> <input style="" type="button" class="btn btn-info "
				value="历史周报" id="lastsummarybtn">
		</div>

		<input type="hidden" value="0" id="contc">
		<div class="titlediv panel-heading ">
			<h3 class="panel-title">编写周报</h3>
		</div>
		<div class="summarydiv">
			<script id="editor" type="text/plain"></script>
			<input style="" type="button" class="btn btn-primary " id="btn"
				value="保存" />
		</div>
		<br />
	</div>
</body>
</html>