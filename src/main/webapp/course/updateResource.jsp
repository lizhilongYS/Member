<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">		
$(function(){	
	var flag=true;
	var msg="";
	
	$("[name='resourceTitle']").blur(function(){
		var title=$.trim($("[name='resourceTitle']").val());
		if(title==""){
			$("#msg").html("资源名称不能为空!");
		flag=false;
			return flag;
		}
		$("#msg").html("");
		msg="";
	});
	$("[name='resourceUrl']").blur(function(){
		var title=$.trim($("[name='resourceUrl']").val());
		if(title==""){
			$("#msg").html("资源路径名称不能为空!");
			flag=false;
			return flag;
		}
		$("#msg").html("");
		msg="";
	});
	
	$("#add").click(function(){	
		if(flag==false){			
			$("#msg").html(msg);
			return falg;
		}
		$.ajaxSetup({async:false});
		$.post("${pageContext.request.contextPath}/resources/update2.action",
				{
			title:$("[name='title']").val(),
			resourceName:$("[name='resourceTitle']").val(),
			url:$("[name='resourceUrl']").val(),
			category:$("[name='category']").val()},function(data){
			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index);	
		})
				
	});
	$("[name=category]").change(function(){
		$.post("${pageContext.request.contextPath}/resources/selectCategory.action",
				{num:$("[name=category]").val()},
				function(date){
					$("[name=title]").html("");
					var content;
					for(var i=0;i<date.length;i++){
						content+="<option value="+date[i].id+">"+date[i].title+"</option>"
					}
					$("[name=title]").html(content);
				});
	});
});
</script>
</head>
<body>
	<div class="container">
		<div class="well well-sm text-center">章节信息</div>
		<div class="panel panel-default">
			<div class="panel-body">
				<form name="add">
					<table class="table table-hover">
						<tr>
							<th>专业</th>
							<td><select style="width: 100px" name="category">
									<c:forEach items="${sessionScope.getcategory}" var="category">
										<c:if
											test="${sessionScope.updateResource.category==category.id}">
											<option value="${category.id}" selected="selected">${category.title}</option>
										</c:if>
										<c:if
											test="${sessionScope.updateResource.category!=category.id}">
											<option value="${category.id}">${category.title}</option>
										</c:if>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<th>章节</th>
							<td><select style="width: 200px" name="title">
									<c:forEach items="${sessionScope.chapters}" var="title">
										<c:if test="${sessionScope.updateResource.title==title.id}">
											<option value="${title.id}" selected="selected">${title.title}</option>
										</c:if>
										<c:if test="${sessionScope.updateResource.title!=title.id}">
											<option value="${title.id}">${title.title}</option>
										</c:if>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<th>资源名称</th>
							<td><input
								value="${sessionScope.updateResource.resourceName}"
								name="resourceTitle" type="text" style="width: 200px"
								class="form-control" required /></td>
						</tr>
						<tr>
							<th>资源路径</th>
							<td><input value="${sessionScope.updateResource.url}"
								name="resourceUrl" type="text" style="width: 200px"
								class="form-control" required /></td>
						</tr>
						<tr>
							<td colspan="2">
								<div id="msg"
									style="color: red; font-weight: bold; font-size: 15px;"
									align="center"></div>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<div style="margin-left: 110px">
									<button type="button" class="btn btn-default" id="add">确定</button>
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>

	</div>
</body>
</html>