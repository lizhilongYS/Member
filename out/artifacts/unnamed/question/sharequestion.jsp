<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>问题分享-Java互助学习VIP群业务运行系统</title>

<link
	href="${pageContext.request.contextPath}/tableTemplet/css/H-ui.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/tableTemplet/lib/Hui-iconfont/1.0.1/iconfont.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
<script
	src="${pageContext.request.contextPath}/jslib/jquery-1.9.0.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/jslib/accordion.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/layer/layer-v2.0/layer/layer.js"></script>
<script type="text/javascript">
$(function() {
	//默认显示所有问答
	var checkType="all";
	var id="";
	//获取专业
	$.post("${pageContext.request.contextPath}/courseandpro/getOnlineStudentCategory.action",function(data){
		if(data.length>0){
			showdata(data);
		}
		categoryclick();
	});

	//accordion折叠菜单插件
 	$(".J_navlist").accordion({
        //accordion: true,
        speed: 500,
	    closedSign: '[+]',
		openedSign: '[-]'
	}); 
	
	//选择问题分类 all or mine
	$("#sel").change(function(){
		var id=$("#cId").val();
		checkType=$("#sel").val();
		if(id=="0"){
			return;
		}
		showQuestions(id,checkType);
	})
	
	//选择课程的弹窗
	$("#btn1").click(function(){
		layer.open({
		type: 1,
		offset: 't',
		title: '选择课程',
		area: ['380px', '350px'],
		shadeClose: true, //点击遮罩关闭
		content:$("#c_layer")
		});
	})
	
	$(".lesson").click(function(){
		layer.close(layer.index);
		var arr=this.lang.split(",");
		var id=arr[0];
		var title=arr[1];
		$("#cId").val(id);
		$("#cTitle").html(title);
		showQuestions(id,checkType);
	})
	
	//富文本编辑器的初始化-提交问题
	var ue1 = UE.getEditor('editor_s',{
		toolbars: [[
	    	'removeformat','undo','redo','italic','underline','|','fontfamily','forecolor','backcolor','fontsize','|',
	    	'lineheight','|','justifyleft','justifyright','ustifycenter','justifyjustify','|','simpleupload'//单图上传
		]],
		initialFrameWidth:680,
		enableAutoSave: false
	});

	ue1.ready(function(){
		ue1.setContent("请在此输入您的解答~");
	});

	
	$("#btn2").click(function(){
		if($("#cId").val()=="0"){
			layer.msg('请先选择课程哦~~');
			return;
		}
		var index1 = layer.open({
			type: 1,
			offset: 't',
			title: '编辑您的问答',
			area: ['750px', '450px'],
			maxmin: true,
			shadeClose: true, //点击遮罩关闭
			content:$("#q_layer")
		})
		
		//保存提交的问题
		$("#btn3").click(function(){
			$.ajaxSetup({async:false});
			var ques=$("#ed_q").val();
			var solution = ue1.getContent();
			var cId=$("#cId").val()
			if(ques == "" ){
				alert("周报标题不能为空！");
				return;
			}
			if(solution == "" ){
				alert("周报内容不能为空！");
				return;
			}
			$.post("${pageContext.request.contextPath}/question/addQuestion.action",
				{
					question:ques,
					solution:solution,
					cId:cId,
					time:new Date()
				},
				function(data){
					if(data=="1"){
						layer.close(index1);
						layer.msg("成功提交问答~请耐心等待管理员审核~")
						showQuestions(cId,checkType);
					}else if(data=="0"){
						//session过期，重新登录
						location.href="${pageContext.request.contextPath}/logins.jsp"
					}
					
			})
		})

	})
	
	
});

function getcachapter(id){
	$.ajaxSetup({async:false});
	var str="";
	$.post("${pageContext.request.contextPath}/course/getcachapter.action",{caid:id},function(data){	
		str=showchapter(data);		
	});
	return str;
}
function categoryclick(){
	$(".category").each(function(index, element) {
        var arr=this.lang.split(",");
		id=arr[0];
		var str=getcachapter(id);//id=0,7,8
		$(this).siblings("ul").html(str);
    });
}

//表头专业 
function showdata(data){
	var line="";
	for(i=0;i<data.length;i++){
			line=line + "<li><a herf='#'  class='category' lang='"+data[i].caid+","+"'>"+data[i].title+"</a><ul></ul></li>";
	}
	$(".J_navlist").html(line);
}

function showchapter(data){
	$.ajaxSetup({async:false});
	var chaptitle="";
	var line="";
	for(i=0;i<data.length;i++){		
		line+= "<li >";
		if(data[i].optional_flag==true){
			chaptitle = "<a href='#'><font style='color:#76EE00;'>"+ data[i].title+ "（选修课）</font></a>";
		}else{
			chaptitle = "<a href='#'>"+data[i].title+"</a>";
		}
		line+= chaptitle;
		line+="<ul>";
		$.post("${pageContext.request.contextPath}/course/getLessons.action",{chid:data[i].id},function(data2){	
			for(j=0;j<data2.length;j++){
				line=line+"<li ><a class='lesson' lang='"+ data2[j].id +","+ data2[j].title +"'>"+data2[j].title +"</a></li>";	
			}
		line+="</ul>";
		line+="</li>";	
		});			
	}
	return line;
}

function showQuestions(id,checkType){
	var line="";
	var current_user=$("#current_user").val();
	$.post("${pageContext.request.contextPath}/question/getQuestion.action",{cId:id,qpId:current_user,checkType:checkType},function(data){
		for(i=0;i<data.length;i++){
			var flag_nocheck=data[i].state=="0";
			var flag_pass=data[i].state=="1";
			var flag_tomodify=data[i].state=="2";
			var flag_modified=data[i].state=="3";
			var flag_thisuser=data[i].qpId==$("#current_user").val();
			//其他用户的未审核的提问不予显示
			if(!flag_thisuser && (!flag_pass)){
				continue;
			}
			line+="<div class='basic-grey'><div><span class='qp'>"+ data[i].qpId+"</span><span>"+ data[i].qperson+"</span><span>&nbsp;&nbsp;发布于：</span><span class='qt'>"+getMyDate(data[i].time)+"</span>";
			if(flag_thisuser){
				if(flag_nocheck){
					line+="<button class='modify' onclick='open_m(this)' lang='"+ data[i].id+"'>修改我的问答</button><span class='isc'><font style='color:black;'>待审核</font></span>";
				}else if(flag_tomodify){
					line+="<button class='modify' onclick='open_m(this)' lang='"+ data[i].id+"'>修改我的问答</button><span class='isc'><font style='color:red;'>待修改</font></span>";
				}else if(flag_modified){
					line+="<button class='modify' onclick='open_m(this)' lang='"+ data[i].id+"'>修改我的问答</button><span class='isc'><font style='color:blue;'>已修改</font></span>";
				}else{
					line+="<span class='isc'>已审核</span>";
				}
			}else{
				line+="<span class='isc'>已审核</span>";
			}
			line+="</div><hr><strong>问题</strong><div class='text'>"+data[i].question+"</div><strong>解答</strong><div class='text'>"+data[i].solution+"</div></div><br/><br/>";			
		}
	})
	$("#q_list").html(line);
}

//弹出修改问题的弹窗
function open_m(e){
	//富文本编辑器的初始化-修改问题
	UE.delEditor('m_editor_s');
	var ue2 = UE.getEditor('m_editor_s',{
		toolbars: [[
	    	'removeformat','undo','redo','italic','underline','|','fontfamily','forecolor','backcolor','fontsize','|',
	    	'lineheight','|','justifyleft','justifyright','ustifycenter','justifyjustify','|','simpleupload'//单图上传
		]],
		initialFrameHeight:250,
		initialFrameWidth:680,
		enableAutoSave: false
	});
	
	var m_qId=$(e).attr('lang');
	var m_pId=$(e).siblings('.qp').html();
	var m_ed_q=$(e).parent('div').siblings('div').eq(0).html();
	var m_editor_s=$(e).parent('div').siblings('div').eq(1).html();
	$("#m_qId").val(m_qId);
	$("#m_pId").val(m_pId);
	$("#m_ed_q").val(m_ed_q);
	ue2.ready(function(){
		ue2.setContent(m_editor_s);
	});
	
	var index2 = layer.open({
		type: 1,
		offset: 't',
		title: '修改您的问答',
		area: ['750px', '450px'],
		maxmin: true,
		shadeClose: true, //点击遮罩关闭
		content:$("#m_layer")
	}) 
	
	$("#btn4").click(function(){
		var cId=$("#cId").val();
		var checkType="all";
		if($("#m_ed_q").val() == "" ){
			alert("周报标题不能为空！");
			return;
		}
		if(ue2.getContent() == "" ){
			alert("周报内容不能为空！");
			return;
		}
		$.post("${pageContext.request.contextPath}/question/modifyQuestion.action",
			{
				Id:$("#m_qId").val(),
				qpId:$("#m_pId").val(),
				question:$("#m_ed_q").val(),
				solution:ue2.getContent()
			},function(data){
				if(data=="1"){
					layer.close(index2);
					showQuestions(cId,checkType);
				}else if(data=="2"){
					layer.msg("您的该问答已经通过审核，不能再修改了~");
					layer.close(index2);
				}else{
					//session过期，重新登录
					location.href="${pageContext.request.contextPath}/logins.jsp"
				}
		})
		
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

/*选择课程弹窗*/
ul {
	list-style: none
}

.demo {
	width: 300px;
	margin: 40px auto;
	padding: 10px;
	background: #f7f7f7;
}

.J_navlist {
	width: 270px;
	padding: 40px 28px 25px 0;
	font-family: "Microsoft yahei", Arial, Helvetica, sans-serif;
}

ul.J_navlist {
	padding: 0;
	margin: 0;
	font-size: 1em;
	line-height: 0.5em;
	list-style: none;
}

ul.J_navlist li {
	
}

ul.J_navlist li a {
	line-height: 15px;
	font-size: 14px;
	padding: 10px 5px;
	color: #000;
	display: block;
	text-decoration: none;
	font-weight: bolder;
}

ul.J_navlist li a:hover {
	background-color: #675C7C;
	color: white;
}

ul.J_navlist ul {
	margin: 0;
	padding: 0;
	display: none;
}

ul.J_navlist ul li {
	margin: 0;
	padding: 0;
	clear: both;
}

ul.J_navlist ul li a {
	padding-left: 20px;
	font-size: 12px;
	font-weight: normal;
}

ul.J_navlist ul li a:hover {
	background-color: #D3C99C;
	color: #675C7C;
}

ul.J_navlist ul ul li a {
	color: silver;
	padding-left: 40px;
}

ul.J_navlist ul ul li a:hover {
	background-color: #D3CEB8;
	color: #675C7C;
}

ul.J_navlist span {
	float: right;
}

/* hr分割线    渐变 color1 - color2 - color1 */
hr.style-one {
	border: 0;
	height: 2px;
	background: #333;
	background-image: linear-gradient(to right, #ccc, #333, #ccc);
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

.basic-grey .qp {
	display: inline-block;
	font-size: 30px;
	margin-right: 20px;
}

.basic-grey .qt {
	display: inline-block;
	font-size: 15px;
	margin-right: 60px;
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

	<c:if test="${sessionScope.myuser!=null}">
		<input type="hidden" id="current_user" value="${myuser.name }">
	</c:if>
	<c:if test="${sessionScope.experience!=null}">
		<input type="hidden" id="current_user" value="${experience.num }">
	</c:if>

	<h1 style="text-align: center">问题分享</h1>
	<br>
	<div class="text-c">
		<button id="btn1" style="float: left;" class="btn btn-success">
			<i class="Hui-iconfont">&#xe6bf;</i>选择课程
		</button>
		&nbsp; &nbsp; <input type="hidden" id="cId" value="0" /> <span
			class="select-box inline"> <select id="sel" class="select"
			style="float: left;">
				<option value="all">该课程下所有问答</option>
				<option value="mine">该课程下我提交的问答</option>
		</select>
		</span>&nbsp; &nbsp;
		<button id="btn2" style="float: right;" class="btn btn-success">
			<i class="Hui-iconfont">&#xe600;</i>发布问题
		</button>
		&nbsp; &nbsp;
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20" style="text-align: center">
		<span
			style="font-size: 20px; display: inline-block; width: 500px; height: 30px; text-align: center;"
			id="cTitle"></span>
	</div>
	<br>
	<br>

	<div id="c_layer" style="display: none;">
		<div class="demo">
			<ul class="J_navlist">
			</ul>
		</div>
	</div>

	<div id="q_layer" style="display: none;">
		<div style="text-align: center;">
			<br> <label><span>问题：</span><input type="text" id="ed_q"
				style="width: 670px; height: 30px;" placeholder="请在此输入您的问题"></label><br>
			<label><span>解答：</span>
			<script id="editor_s" type="text/plain" style="height: 230px;"></script></label><br />
			<label><span>&nbsp;</span><input type="button" id="btn3"
				value="保存"></label>
		</div>
	</div>

	<div id="m_layer" style="display: none;">
		<div>
			<br> <input type="hidden" id="m_qId"> <input
				type="hidden" id="m_pId"> <label><span>问题：</span><input
				type="text" id="m_ed_q" style="width: 670px; height: 30px;"></label><br>
			<label><span>解答：</span>
			<script id="m_editor_s" type="text/plain" style="height: 230px;"></script></label><br />
			<div style="text-align: center;">
				<input type="button" id="btn4" value="保存">
			</div>
		</div>
	</div>

	<div id="q_list"></div>
</body>
</html>