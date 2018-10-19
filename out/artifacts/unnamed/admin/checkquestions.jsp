<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>问答审核-Java互助学习VIP群业务运行系统</title>

<link
	href="${pageContext.request.contextPath}/tableTemplet/css/H-ui.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/tableTemplet/lib/Hui-iconfont/1.0.1/iconfont.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/jslib/accordion.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/layer/layer-v2.0/layer/layer.js"></script>
<script type="text/javascript">
$(function() {
	//默认显示所有未审核的问答
	var checkType="allno";
	var aid=$("#admin").val();
	showQuestions(aid,checkType);
	
	$("#sel").change(function(){
		checkType=$("#sel").val();
		showQuestions(aid,checkType);
	})
});

function showQuestions(aid,checkType){
	var line="";
	$.post("${pageContext.request.contextPath}/question/getQuestionForAdmin.action",{spId:aid,checkType:checkType},function(data){
		for(i=0;i<data.length;i++){
			var flag_nocheck=data[i].state=="0";
			var flag_pass=data[i].state=="1";
			var flag_tomodify=data[i].state=="2";
			var flag_modified=data[i].state=="3";
			//已通过的提问不予显示
			if(flag_pass){
				continue;
			}
			line+="<div class='basic-grey'><div><span class='word'>"+ data[i].qpId+"</span>&nbsp;号会员<span class='word'>&nbsp;"+ data[i].qperson+"</span><span>&nbsp;&nbsp;&nbsp;于：</span><span class='word'>"+getMyDate(data[i].time)+"</span>&nbsp;发布在&nbsp;<span class='word'>"+data[i].ctitle+"</span>";
			if(flag_nocheck){
				line+="<span class='isc'><font style='color:black;'>待审核</font></span>";
			}else if(flag_tomodify){
				line+="<span class='isc'><font style='color:red;'>待修改</font></span>";
			}else if(flag_modified){
				line+="<span class='isc'><font style='color:blue;'>已修改</font></span>";
			}
			line+="</div><hr><strong>问题</strong><div class='text'>"+data[i].question+"</div><strong>解答</strong><div class='text'>"+data[i].solution+"</div><div><input type='hidden' value='"+ data[i].id +"'><button onclick='pass(this)' class='btn-primary'>通过</button>&nbsp;&nbsp;<button onclick='deleteit(this)' class='btn-primary'>删除</button>&nbsp;&nbsp;<button  onclick='tomodify(this)' class='btn-primary'>待修改</button>";	
			if(flag_tomodify||flag_modified){
				line+="&nbsp;&nbsp;<span>"+ data[i].sperson+"</span>&nbsp;审核于：<span class='qt'>"+getMyDate(data[i].checktime)+"</span>";
			}
			line+="</div></div><br/><br/>";
		}
	})
	$("#q_list").html(line);
}

function pass(e){
	var qId=$(e).siblings('input').val();
	var aid=$("#admin").val();
	var checkType="allno";
	if(!confirm("确定审核通过该问答吗？一旦确定不可修改！")){
		return;
	}
	$.post("${pageContext.request.contextPath}/question/passQuestion.action",
			{
				Id:qId,
				checktime:new Date()
			},function(data){
				if(data=="1"){
					layer.msg("审核通过成功！");
					showQuestions(aid,checkType)
				}else if(data=="2"){
					layer.msg("对不起，该问答已通过审核！");
				}else{
					//session过期，重新登录
					location.href="${pageContext.request.contextPath}/logins.jsp"
				}
			})
}

function deleteit(e){
	var qId=$(e).siblings('input').val();
	var aid=$("#admin").val();
	var checkType="allno";
	if(!confirm("确定删除该问答吗？一旦删除不可恢复！")){
		return;
	}
	$.post("${pageContext.request.contextPath}/question/delQuestion.action",
			{
				Id:qId
			},function(data){
				if(data=="1"){
					layer.msg("成功删除该问答！");
					showQuestions(aid,checkType)
				}else if(data=="2"){
					layer.msg("对不起，该问答已通过审核！");
				}else{
					//session过期，重新登录
					location.href="${pageContext.request.contextPath}/logins.jsp"
				}
	})
}

function tomodify(e){
	var qId=$(e).siblings('input').val();
	var aid=$("#admin").val();
	var checkType="tomodify";
	if(!confirm("确定通知修改该问答吗？您需要线下联系该问答发布者。")){
		return;
	}
	$.post("${pageContext.request.contextPath}/question/modQuestion.action",
			{
				Id:qId,
				checktime:new Date()
			},function(data){
				if(data=="1"){
					layer.msg("成功设置问答状态为【待修改】！");
					showQuestions(aid,checkType)
				}else if(data=="2"){
					layer.msg("对不起，该问答已通过审核！");
				}else{
					//session过期，重新登录
					location.href="${pageContext.request.contextPath}/logins.jsp"
				}
			})
}

//转换时间格式
function getMyDate(str){  
    var oDate = new Date(str),  
    oYear = oDate.getFullYear(),  
    oMonth = oDate.getMonth()+1,  
    oDay = oDate.getDate(),  
    oHour = oDate.getHours(),  
    oMin = oDate.getMinutes(),  
    oSen = oDate.getSeconds(),  
    oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':'+getzf(oSen);//最后拼接时间  
    return oTime;  
};  
//补0操作  
function getzf(num){  
    if(parseInt(num) < 10){  
        num = '0'+num;  
    }  
    return num;  
}  
</script>
<style type="text/css">
/*定位*/
.none {
	display: none
}

/*问题展示*/
.basic-grey {
	margin-left: auto;
	margin-right: auto;
	max-width: 800px;
	background: #F7F7F7;
	padding: 25px 15px 25px 10px;
	font: 15px;
	color: #888;
	text-shadow: 1px 1px 1px #FFF;
	border: 1px solid #E4E4E4;
}

.basic-grey .word {
	display: inline-block;
	font-size: 15px;
	color: black;
}

.basic-grey .isc {
	float: right
}

.basic-grey strong {
	font-size: 15px;
}

.basic-grey .text {
	border: 1px solid #CCC;
	background: #FFF;
	margin-top: 10px;
	margin-bottom: 10px;
	padding: 10px;
	line-height: 25px;
	text-indent: 2em;
	font-size: 15px;
}

.basic-grey .modify {
	display: inline-block;
	font-size: 15px;
	margin-right: 50px;
	margin-left: 50px;
	color: #606060;
	border: solid 1px #b7b7b7;
}
</style>
</head>
<body>

	<input type="hidden" id="admin" value="${admin.id }">

	<h1 style="text-align: center">问答审核</h1>
	<br>
	<div class="text-c">
		<span class="select-box inline"> <select id="sel"
			class="select" style="float: left;">
				<option value="allno">所有未审核的问答</option>
				<option value="allnopass">所有未通过的问答</option>
				<option value="tomodify">我审核的待修改的问答</option>
				<option value="modified">我审核的已修改的问答</option>
		</select>
		</span>&nbsp; &nbsp;
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20" style="text-align: center">
		<span
			style="font-size: 20px; display: inline-block; width: 500px; height: 30px; text-align: center;"
			id="cTitle"></span>
	</div>
	<br>
	<br>

	<div id="q_list"></div>
</body>
</html>