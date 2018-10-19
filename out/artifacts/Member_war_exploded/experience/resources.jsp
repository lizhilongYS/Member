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
	width: 35%;
}

#paging {
	width: 35%;
}

table {
	border: solid 2px #ddd; rgba (0, 0, 0, 0.3);
	text-align: center;
	width: 35%;
}

table th {
	border: 2px solid #ddd;
	background-color: rgb(245, 250, 254, 1);
	height: 70px;
	font-weight: normal;
}

table td {
	border: 2px solid #ddd;
	text-align: center;
	width: 100px;
	height: 45px;
	font-size: 14px;
	font-family: "微软雅黑";
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
$.ajaxSetup({async : false});
getDate();
$(function() {
	$("#addResource").mouseover(function(){
		$("#addResource").css("background-color","#5687d8");
		
	});
	  $("#addResource").mouseout(function(){
		    $("#addResource").css("background-color","#a4bfea");
		  });

	//按章节查找资源
	$("#submitCachapter").click(function(){
		$.post("${pageContext.request.contextPath}/resources/cachapter.action",
				{category:$("#category").val(),
			     title:$("#cachapter").val()},
				function(date){
					setTaleDate(date);
				});
		
	});
	
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
						/* content+="<option value="+date[i].id+">"+date[i].title+"</option>" */
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
		search(id,this.lang);
	});
}
function getDate(){
		setCategory();
		setCachapter();
		search(0,1);
		//setTaleDate(date);
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
				 content+="<option value='0'>全</option>";
				}
			content+=  "<option value=" + date[i].id +">" + date[i].title + "</option>"
			/* content+="<option value="+date[i].id+">"+date[i].title+"</option>" */
		}
		$("#cachapter").html(content);
	});
}
function setTaleDate(date){
	var content;
	if(date.length>0){
	for(var i=0;i<date.length;i++){
		content+="<tr>"+
		"<td style='width:30px'>"+(i+1)+"</td>"+
		"<td style='text-align:left'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+date[i].resourceName+"</td>"+
               "<td style='width:60px'><a href="+date[i].url+" onclick='forWordPage("+date[i].url+") ' target='_blank'>前往下载</a></td>"+
            "</tr>";
	}
	}else{
		content+="tr >"+
          	 "<td colspan='6'> #暂时没有相关资源	，请等待管理员添加#</td>"+
            	"</tr>";
	}
	$(".tbody").html(content);
}



</script>
<title>学习资源</title>
</head>
<body>
	<div id="topDiv"></div>
	<div id="DivTitle">
		<h1 align="center">学习所需资源</h1>
	</div>
	<div id="content">
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

					</tr>
				</thead>
				<tbody>
					<tr>
						<td style='width: 30px'>序号</td>
						<td>名称</td>
						<td style='width: 60px'>下载地址</td>

					</tr>
				</tbody>
				<tfoot class="tbody">

				</tfoot>
			</table>
		</div>
		<div id="paging" style="margin-left: 409px; margin-top: 10px;"></div>
	</div>
</body>
</html>