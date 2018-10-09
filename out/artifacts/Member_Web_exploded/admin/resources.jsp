<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
#contentTop {
	width: 100%
}

#addResource {
	width: 150px;
	height: 50px;
	border-radius: 10px;
	background-color: #a4bfea;
}

body {
	font-size: 14px;
	font-family: "微软雅黑";
}

.addyangshi {
	background-color: red;
}

#topSpanHunt {
	float: left;
	border-radius: 5px;
	height: 60px;
}

#category {
	margin: 15px;
}

#DivTitle {
	width: 40%;
}

#paging {
	width: 40%;
}

#contentCenter table {
	border: solid 2px #ddd; rgba (0, 0, 0, 0.3);
	text-align: center;
	width: 40%;
}

#contentCenter table th {
	border: 2px solid #ddd;;
	background-color: rgb(245, 250, 254, 1);
	height: 70px;
	font-weight: normal;
}

#contentCenter table td {
	border: 2px solid #ddd;
	text-align: center;
	width: 100px;
	height: 45px;
}

select {
	border-radius: 5px;
}
</style>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/bootstrap.css" />
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/layer-v2.4/layer.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jslib/currency.js"></script>
<script type="text/javascript">
getDate();
$(function() {
	$(".id").hide();
	$("#addResource").mouseover(function(){
		$("#addResource").css("background-color","#5687d8");
		
	});
	  $("#addResource").mouseout(function(){
		    $("#addResource").css("background-color","#a4bfea");
		  });

	//添加章节点击事件
	$("#addResource").click(function() {
			updateAndAdd("${pageContext.request.contextPath}/course/addResources.jsp");		
	});
	//按专业查找资源
/* 	$("#submitCategory").click(function(){
		$.post("${pageContext.request.contextPath}/resources/category.action",
				{category:$("#category").val()},
				function(date){
					setTaleDate(date);
				});
		
	}); */
	//按章节查找资源
	/* $("#cachapter").click(function(){
		
		$.post("${pageContext.request.contextPath}/resources/cachapter.action",
				{category:$("#category").val(),
			     title:$("#cachapter").val()},
				function(date){
			    	 alert(date.length)
					setTaleDate(date);
				});
		
	});  */
	
	//二级联动
	$("#category").change(function(){
		$.post("${pageContext.request.contextPath}/resources/selectCategory.action",
				{num:$("#category").val()},
				function(date){
					$("#cachapter").html("");
					var content;
					for(var i=0;i<date.length;i++){
						if(i==0){
							content+="<option value='0'>全</option>";
							}
						content+=  "<option value=" + date[i].id +">" + date[i].title + "</option>"
					}
					search(0,1);
					$("#cachapter").html(content);
				});
		
	});

	
});
function search(id,page){
	$.post("${pageContext.request.contextPath}/resources/cachapter.action",
			{category:$("#category").val(),
		     title:id,
		     pages:page},
			function(date){
				setTaleDate(date.data);
				$("#paging").html(showpage(date.page, date.count));
				btnPage(id);
			});
}
//分页点击事件，将当前页值放入hidden域 
function btnPage(id) {
	$(".nav-btn").click(function() {
		$("#lang").val(this.lang);
		search(id,this.lang);
	});
}
function getDate(){
	$.post("${pageContext.request.contextPath}/resources/initDate.action",
			function(date){
		setCategory();
		setCachapter();
		search(0,1);
		//setTaleDate(date);
	});
	
}
function setCategory(){
	$.post("${pageContext.request.contextPath}/resources/initCategory.action",
			function(date){
		var content;
		for(var i=0;i<date.length;i++){
			
			content+="<option value="+date[i].id+">"+date[i].title+"</option>"
		}
		$("#category").html(content);
	});
}
function setCachapter(){
	$.post("${pageContext.request.contextPath}/resources/initCachapter.action",
			function(date){
		var content;
		for(var i=0;i<date.length;i++){
			if(i==0){
				content+="<option value='0' >全</option>";
				}
			content+=  "<option value=" + date[i].id +" >" + date[i].title + "</option>"
		}
		$("#cachapter").html(content);
	});
}
function setTaleDate(date){
	var content;
	if(date.length>0){
	for(var i=0;i<date.length;i++){
		content+="<tr>"+
		 "<td style='width:20px'>"+(i+1)+"</td>"+
		       "<td style='width:50%';'text-align:left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+date[i].resourceName+"</td>"+
           "<td style='width:20%'><a href="+date[i].url+" onclick='forWordPage("+date[i].url+")' target='_blank' >前往下载</a></td>"+
               "<td style='width:50px'><a href='#' onclick='update("+date[i].id+")'>修改</a>"+
               "&nbsp;<a href='#' onclick='deleteResource("+date[i].id+")'>删除</a></td>"+
            "</tr>";
	}
	}else{
		content+="tr >"+
          	 "<td colspan='6'> #暂时没有相关资源	，请等待管理员添加#</td>"+
            	"</tr>";
	}
	$(".tbody").html(content);
}
function forWordPage(url){
	 location.replace(url); 
}
function update(id){
	$.post("${pageContext.request.contextPath}/resources/update1.action",{"id":id},
			function(date){
		
	});
	var url="${pageContext.request.contextPath}/course/updateResource.jsp"
		updateAndAdd(url);
}
function updateAndAdd(url){
	layer.open({
	    type: 2,
	    title:'添加章节资源',
	    area: ['380px', '380px'],
	    shift:1,
	    shade: 0.5, //开启遮罩关闭
	    content: url,
	    end: function() {
	    	$.post("${pageContext.request.contextPath}/resources/initDate.action", function(date){
	    		var lang = $("#lang").val();
	    		search($("#cachapter").val(),lang);
	    	});
	    }
	});
	
}
function deleteResource(id){
	layer.confirm(
			'您确定要删除当前章节的学习资源吗？',
			{
				btn : [ '是', '否' ]
			},//按钮一的回调函数
			function() {
				 $.post("${pageContext.request.contextPath}/resources/delete.action",{"id":id},function(date){
					 setTaleDate(date);
				});
				layer.closeAll('dialog');
				var lang = $("#lang").val();
				search($("#cachapter").val(),lang);
			});
}
</script>
<title>学习资源</title>
</head>
<body>
	<div id="topDiv"></div>
	<div id="DivTitle">
		<h1 align="center">学习所需资源</h1>
	</div>
	<hr />
	<div id="content">
		<hr />
		<div id="contentCenter">
			<table>
				<thead>
					<tr>
						<th colspan="3"><div id="topSpanHunt">
								<select style="width: 120px" id="category">
								</select> &nbsp; <select
									onchange="search(this.options[this.selectedIndex].value,1);"
									style="width: 200px" id="cachapter">
								</select>
							</div></th>
						<th><span id="topSpanAdd"> <input type="button"
								id="addResource" value="十添加章节资源">
						</span></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style='width: 20px'>序号</td>
						<td style='width: 50%'>名称</td>
						<td style='width: 20%'>下载地址</td>
						<td style='width: 50px'>操作</td>
					</tr>
				</tbody>
				<tfoot class="tbody">

				</tfoot>
			</table>
		</div>
		<input type="hidden" value="1" id="lang">
		<div id="paging" style="margin-left: 477px; margin-top: 10px;"></div>
	</div>
</body>
</html>