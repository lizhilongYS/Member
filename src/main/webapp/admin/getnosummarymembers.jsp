<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>周报管理-未及时提交周报学员名单</title>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/images/Icon.ico" />
<link
	href="${pageContext.request.contextPath}/resources/H-ui_v3.0/css/H-ui.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/page.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jslib/currency.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/layer/layer-v2.0/layer/layer.js"></script>
<script type="text/javascript">
	$(function(){
		getData(1);
		function getData(page){
			$.ajaxSetup({async : false});
			$.post("${pageContext.request.contextPath}/member/getNoSummaryMembersByPage.action",
					{page:page},function(data){
				//alert(data);
				var dataObj = eval("(" + data + ")");
				//alert(dataObj.COUNT);
				var list = dataObj.LIST;
				drawTable(list);
				var navbar = dataObj.navbar;
				$(".page-nav").html(navbar);
				$(".nav-btn").click(function(){
					var page=this.lang;
					getData(page);
				})
			})	
		}
		
		function drawTable(list){
			var line = "";
			for(var i=0;i<list.length;i++){
				line = line + "<tr>";
				line = line + "<td>" + (i+1) + "</td>";
				line = line + "<td>" + list[i].num + "</td>";
				line = line + "<td>" + list[i].name + "</td>";
				line = line + "<td>" + list[i].sex + "</td>";
				line = line + "<td style='text-align:left;'>" + list[i].school + "</td>";
				line = line + "<td><u><a target='_blank' href='http://wpa.qq.com/msgrd?v=1&uin=" 
						+ list[i].qq + "&site=qq&menu=yes'>" + list[i].qq
						+"</a></u></td>";
				line = line + "<td>" + list[i].phone + "</td>";
				/*
				var begintime = new Date(list[i].begintime);
				var strdate = begintime.getFullYear()+"-"+(begintime.getMonth()+1)+"-"+begintime.getDate();
				line = line + "<td>" + strdate + "</td>";
				line = line + "<td>" + list[i].adminname + "</td>";
				*/
				line = line + "<td> <input type='checkbox'checked='true' class='cancelsummarycb' lang='" + list[i].usertype+"," + list[i].id + "'" +  + "</td>";
				line = line + "</tr>";
			}
			$("#tbody").html(line);
		}
		
		$(".cancelsummarycb").click(function(){
			var str = $(this).attr("lang").split(",");
			var usertype = str[0];
			var id = str[1];
			
			if($(this).prop("checked")==true){
				//alert("true");
				$.post("${pageContext.request.contextPath}/member/setSummaryFlag.action",
						{usertype:usertype,id:id,flag:1});
			}else{
				//alert("false");
				$.post("${pageContext.request.contextPath}/member/setSummaryFlag.action",
						{usertype:usertype,id:id,flag:0});	
			}
		})

	})

</script>
</head>
<body>
	<c:if test="${ADMIN==null}">
		<jsp:forward page="/user/login.jsp"></jsp:forward>
	</c:if>
	<h1 class="text-c"
		style="width: 95%; margin-bottom: 10px; margin-top: -20px;">未及时提交周报的学员名单</h1>
	<div class="panel panel-secondary"
		style="width: 80%; margin-left: 5%; margin-right: 10%;">
		<div class="panel-header">
			<div class="btn-group">
				<button type="button" class="btn btn-primary radius" id="download">生成表格</button>
				<a class="btn btn-primary radius" target="_blank" id="dl">点击下载</a>
			</div>
		</div>
		<div class="panel-primary">
			<table class="table table-border table-bg table-bordered radius">
				<thead class='text-c'>
					<tr>
						<th>序号</th>
						<th>学号</th>
						<th>真实姓名</th>
						<th>性别</th>
						<th>学校名称</th>
						<th>QQ号码</th>
						<th>电话号码</th>
						<th>需交周报</th>
					</tr>
				</thead>
				<tbody id="tbody" class='text-c'></tbody>
			</table>
		</div>
	</div>
	<div class='page-nav'
		style="width: 80%; margin-top: 10px; margin-left: 5%; margin-right: 10%;"></div>
</body>
</html>