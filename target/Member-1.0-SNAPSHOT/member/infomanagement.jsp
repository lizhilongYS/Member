<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="hello" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有周报</title>
<link
	href="${pageContext.request.contextPath}/tableTemplet/css/H-ui.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/css/style.css?time=20161215"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/tableTemplet/lib/Hui-iconfont/1.0.1/iconfont.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/layer/layui/css/layui.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/layer/layer-v2.0/layer/layer.js"></script>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/images/favicon.ico" />
<style type="text/css">
body {
	margin: 0 auto;
}
</style>
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jslib/myfile.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jslib/currency.js"></script>
<script type="text/javascript">
$(function(){
	
 	var checkType="all";
	var ownerType="";
	var weekType="all";
	var title;
	var page2=1;
	var assistant=0;
	
	//控制隐藏和显示div
	//$(".showinfo").hide();
	//设置选中会员的id
	$("#tabsC").on('click','.setMember',function(){
		$("#tabsC li a span").css("color","#212122")
		$(this).children("span").css("color","red");
		//current.style.display="block"; 
		var reStripTags = /<\/?.*?>/g;
		var textOnly = this.innerHTML.replace(reStripTags, ''); //只有文字的结果
		ownerType=textOnly;
		$("#tabsC2").html("");
		getData(checkType,weekType,ownerType,title,page2,assistant);
	}) 
	
	function getData(checkType,weekType,ownerType,title,page2,assistant){
		$.ajaxSetup({async:false});
		$.post("${pageContext.request.contextPath}/summary/getSummarysByNameWithPage.action",{checkType:checkType,weekType:weekType,ownerType:ownerType,title:title,page2:page2,assistant:assistant},function(data){
			//alert(data);
			var dataObj = eval("("+data+")");
			var navbar=dataObj.returnMap.navbar;
			var tatolCount=dataObj.returnMap.totalCount;
			var list=dataObj.returnMap.list;
			var title=dataObj.returnMap.title;
			var titleTip=dataObj.returnMap.titleTip;
			//alert(title)
			$("#titleTip").html(titleTip);
			$(".page-nav").html(navbar);
			btnclick();
			$("#TATOLCOUNT").html(tatolCount);
			$("[name='title']").val(title);
			drawTable(list);
			titclick();
			trclick();
			select();
		})
	}	
	
	//如果第一个被选中，下面的所有都要被选中，如果第一个没有被选中，下面的所有都不要被选中。
	function select()
	{
		$("input[type='checkbox']:first").click(function(){
			$("input[type='checkbox']").not(":first").prop("checked",$(this).prop("checked"));
		});
	}
	
	function btnclick(){
		$(".nav-btn").click(function(){
			page2=this.lang;
			getData(checkType,weekType,ownerType,title,page2,assistant);
		})
	}	
	
	function titclick(){
		$(".tit").click(function(){
			var id=this.lang;
			showSum(id);
		})
	}
	
	function trclick(){
		//火狐对last不支持，在不该被点的td里面加上noclick的class
		//$("tr td:not(':first,:last')").click(function(){
		$("tr td:not(.noclick)").click(function(){
			var id=this.parentNode.lang;
			showSum(id);
		})
	}
		
	//查看周报	
	function showSum(id){
			//location.href="${pageContext.request.contextPath}/summary/membersumcomment1.jsp?page2="+page2+"&checkType="+checkType+"&weekType="+weekType+"&title="+title+"&id="+id;
			//window.open("${pageContext.request.contextPath}/summary/membersumcomment1.jsp?id="+id);
		layer.open({
			  type: 2,
			  title: '查看周报',
			  area: ['800px', '500px'],
			 // closeBtn: 0, //不显示关闭按钮
			  shift: 1,
			  maxmin: true,
			  shade: 0.5, //开启遮罩关闭
			  content: '${pageContext.request.contextPath}/summary/membersumcomment1.jsp?id='+id,
			  end: function(){
				  getData(checkType,weekType,ownerType,title,page2,assistant);
			  }
		});
	
	}
	
	//添加表格内容
	function drawTable(data){
		var line="";
		var recom="";
		line=line + "<thead>";
		line=line + "<tr class='text-c'>";
		line=line + "<th width='25'><input type='checkbox' name='' value=''></th>";
		line=line + "<th width='80'>序号</th>";
		line=line + "<th width='80'>会员姓名</th>";
		line=line + "<th width='180'>周报标题</th>";	
		line=line + "<th width='150'>提交时间</th>";
		line=line + "<th width='60'>状态</th>";
		line=line + "<th width='150'>操作</th>";
		line=line + "</tr>";
		line=line + "</thead>";
		line=line + "<tbody>";
		for(i=0;i<data.length;i++){
			line=line + "<tr class='text-c tr' lang='"+data[i].id+"'>";
			line=line + "<td class='noclick'>" + "<input type='checkbox' name='' value=''>" + "</td>";
			if(data[i].recommendval=='1')
			{
					recom="<span class='layui-badge layui-bg-orange' style='text-align: right;'>荐</span>";
			}
			else
			{
					recom="&nbsp;&nbsp;&nbsp;&nbsp;";
			}
			line=line + "<td>" + (i+1) + "</td>";
			line=line + "<td>" + data[i].name + "</td>";
			line=line + "<td>" + data[i].title + "</td>";
			line=line + "<td>" + data[i].time +"&nbsp;&nbsp;"+recom + "</td>";
			line=line +"<td class='td-status'>";
			if(data[i].ischeckval == '0')
			{
				line=line+"<span class='label label-danger radius'>未审核</span>";
			}else{
				line=line+"<span class='label label-success radius'>已审核</span>";
			}
			line=line +"</td>";	
			line=line + "<td class='noclick'><a href='javascript:void(0)' class='tit' lang='"+data[i].sid+"'>查看</a></td>";
			line=line + "</tr>";
				
		}
		line=line + "</tbody>";
		$("#period").html(line);
		$(".showinfo").show();
	}
         
});	
</script>
</head>
<body>

	<div id="tag" style="padding-right: 50px;">
		<h:showNum className2="setMember" className1="num"
			url="${pageContext.request.contextPath}/member/getAllNames.action" />
	</div>
	<div id="msg"></div>
	<div id="tabsC" style="margin-bottom: 20px;"></div>
	<div id="tabsC2" style="margin-bottom: 20px;"></div>
	<div class="showinfo" style="display:none;">
		<h1 class="text-c" style="text-align: center; margin: 20px;">
			<span style="font-size: 30px">此会员所有周报</span>
		</h1>
		<div class="cl pd-5 bg-1 bk-gray mt-20" id="title">
			<span style="margin-left: 180px;" id="titleTip"></span> <span
				class="r">共有数据：<strong id="TATOLCOUNT"></strong> 条
			</span>
		</div>
		<div class="mt-20" style="overflow: auto; width: 100%;">
			<table
				class="table table-border table-bordered table-bg table-hover table-sort"
				id="period">
			</table>
		</div>
		<br>
		<div class='page-nav' style="margin-right: 4%;"></div>
	</div>
</body>
</html>