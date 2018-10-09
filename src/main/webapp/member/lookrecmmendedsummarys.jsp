<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看周报</title>

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
<style>
.summarypics {
	width: 70px;
	height: 70px;
	margin: 5px 5px 0px 5px;
	border-radius: 50%;
}

#weekinfop {
	font-size: 17px;
	margin-top: 0px;
	border: none;
	margin-right: 20px;
	width: 200px;
}

#selectweekdiv {
	margin-bottom: 10px;
}

.scroll-wrapper {
	-webkit-overflow-scrolling: touch;
	overflow-y: scroll;
}

@media ( max-width :767px) {
	.summarypics {
		width: 80px;
		height: 75px;
	}
	#preweekbtn {
		width: 100%
	}
	#currentweekbtn {
		width: 100%
	}
	#nextweekbtn {
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
var summarycount = 0;
$(function(){
	//默认当前的周报周期
	function getData(weekType,oldTitle){
		$.ajaxSetup({async:false});
		$.post("${pageContext.request.contextPath}/summary/getRecommendvalSummarys.action",
				{weekType:weekType,oldTitle:oldTitle},function(data){ 
			drawTable(data);
			$.post("${pageContext.request.contextPath}/user/logger.action",{content:"lookmemededsummarys.jsp: drawtable"});
		})
	}
    <%-- 当前周的周报 --%>
    $("#currentweekbtn").click(function(){
    	var weekType="current";
    	$("#weektypehdn").val(weekType);
    	getData(weekType);
    })
    <%-- 前一周的周报 --%>
    $("#preweekbtn").click(function(){
    	var weekType="previous";
    	var oldTitle=$("#weekinfop").val();
    	$("#weektypehdn").val(weekType);
    	getData(weekType,oldTitle);
    })   
    <%-- 后一周的周报--%>
    $("#nextweekbtn").click(function(){
    	var weekType="next";
    	var oldTitle=$("#weekinfop").val();
    	$("#weektypehdn").val(weekType);
    	getData(weekType,oldTitle); 
    })
    
   	$("#currentweekbtn").click();
	if (summarycount == 0){
		$("#preweekbtn").click();
	}

	//打开窗口，查看周报	
	function showSum(id){
		$.post("${pageContext.request.contextPath}/user/logger.action",{content:"lookrecmmendedsummarys.jsp:begin showsum"});
    	//根据屏幕设置推荐周报弹出的宽和高
    	var swinWidth,swinHeight;
    	if($("body").width()<=500){
    		swinWidth='95%';
    		swinHeight='80%' 
    	}else{
    		swinWidth='80%';
    		swinHeight='80%'
    	}
		layer.open({
			  type: 2,
			  title: '查看周报',
			  area: [swinWidth, swinHeight],
			  // closeBtn: 0, //不显示关闭按钮 
			  shift: 1,
			  maxmin: true,
			  shade: 0.5, //开启遮罩关闭
			  content: '${pageContext.request.contextPath}/summary/membersumcomment1.jsp?id='+id,
	          success: function(layero){
	                $(layero).addClass("scroll-wrapper");//苹果 iframe 滚动条失效解决方式
	          },
			  end: function(){}
		});
    	
	}
	//生成推荐周报div的内容，其中如果没有头像的使用默认头像
	function drawTable(data){ 
		$("#summarydiv").html("");
		var line="";
		if(data==null || data==null) return ; 
		var dataObj = eval("("+data+")");
		var title=dataObj.title;
		$("#weekinfop").val(title);
		//把最后一周的titlt保存
		if($("#weektypehdn").val()=="current"){
			$("#currentweekbtn").attr("lang",title);
		}
		//判断如果当前是最后一周，下一周按钮变灰，否则恢复
		if($("#currentweekbtn").attr("lang")==title){
			//$("#nextweekbtn").attr("disabled",true);
			$("#nextweekbtn").hide();
		}else{
			//$("#nextweekbtn").attr("disabled",false);
			$("#nextweekbtn").show();
		}
		
		var list=dataObj.list;
		summarycount = list.length;
		if (data!=null && list.length>0){
			for(var i=0;i<list.length;i++){
				if (list[i].photo!=null && list[i].photo!=""){
					line=line + "<img class='summarypics ' lang='"
							+list[i].pid+","+list[i].sid+"' src='data: image/jpeg;base64,"+list[i].photo+"'alt='用户头像'/>";
				}else{
					if (list[i].sex=="男"){
						line=line + "<img class='summarypics ' lang='"
							+list[i].pid+","+list[i].sid+"' src='${pageContext.request.contextPath}/images/user_male.png'alt='用户头像'/>";
					}else{
						line=line + "<img class='summarypics ' lang='"
							+list[i].pid+","+list[i].sid+"' src='${pageContext.request.contextPath}/images/user_female.png'alt='用户头像'/>";
					}
				}
			} 
			$("#summarydiv").html(line); 
			//显示真实头像 
			$(".summarypics").each(function(){
				var ids = $(this).attr("lang").split(",");
				var pid = ids[0];
				if(pid!="0"){
					var src = "${pageContext.request.contextPath}/picture/getPictureByid.action?id=" + pid;
					$(this).attr("src",src);
				}
			});
			//重新生成img后要重新绑定点击代码和鼠标变化代码
			$(".summarypics").mouseenter(function(){
				$(this).css("cursor","pointer");
			});
			//点击，打开周报内容
			$(".summarypics").click(function(){
				var ids = $(this).attr("lang").split(",");
				var sid = ids[1];
				showSum(sid);
			})
		}
		
	} 

});	
</script>

</head>
<body>
	<div class="panel panel-primary" style="height: 100%;">
		<div class="panel-heading">
			<h5 class="panel-title">周报推荐</h5>
		</div>

		<div class="panel-body">
			<div class="text-c" id="selectweekdiv">
				<div class="container">
					<input type="text" id="weekinfop"> <input type="button"
						class="btn btn-info" id="preweekbtn" name="weekType" title="上一周"
						value="<<"> <input type="button" class="btn btn-primary"
						id="currentweekbtn" name="weekType" title="最近一周" value="本周">
					<input type="button" class="btn btn-info" id="nextweekbtn"
						name="weekType" title="下一周" value=">>"> <input
						type="hidden" id="weektypehdn">

				</div>
			</div>
			<div class="" id="summarydiv" style="margin-bottom: 0px;"></div>
		</div>

	</div>
</body>
</html>