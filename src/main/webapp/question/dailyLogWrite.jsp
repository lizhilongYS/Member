<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编写工作日志</title>
<link
	href="${pageContext.request.contextPath}/resources/plugin/jeDate/css/jedate.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/plugin/ueditor/ueditor.config.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/plugin/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/plugin/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/layer/layer-v2.0/layer/layer.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/plugin/jeDate/jedate/jquery.jedate.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jslib/currency.js"></script>
<script type="text/javascript">
	$(function() {
		var index = parent.layer.getFrameIndex(window.name);
		/* 初始化编辑器 */
		var ue = UE
				.getEditor(
						'editor',
						{
							enableAutoSave : false,
							UEDITOR_HOME_URL : "${pageContext.request.contextPath}/resources/plugin/ueditor/",
							serverUrl : "${pageContext.request.contextPath}/resources/plugin/ueditor/jsp/controller.jsp"
						});

		ue.ready(function() {
			ue.setContent(data.content);
		});

		$("#wdate").jeDate({
			isinitVal : true,
			festival : true,
			ishmsVal : false,
			festival : false,
			isClear : false,
			format : "YYYY-MM-DD",
			zIndex : 3000,
		})
		$("#btn").click(
						function() {
							var contents = UE.getEditor('editor').getContent();
							if (contents == "") {
								layer.msg("问题答案内容不能为空", {
									icon : 0,
									time : 1000
								});
								return false;
							}
							$.ajaxSetup({
								async : false
							});
							;
							$.post("${pageContext.request.contextPath}/question/addQuestion.action",{"question":$("[name='question']").val(),"time":new Date($("#wdate").val()),"solution":contents}, function(data) {			
													parent.layer.close(index);							
											});
						});
	});
</script>

</head>
<body>
	<br />
	<br />
	<div
		style="background-color: #EEEEEE; width: 703px; height: 150px; border-radius: 6px; position: relative;">

		<span
			style="font-weight: 600; color: #666666; position: relative; left: 20px; top: 17px;">问题分享
			选择时间:<input class="form-control" id="wdate" type="text" readonly
			name="time">
		</span> <br /> <br /> <span
			style="font-weight: 600; color: #666666; position: relative; left: 20px; top: 17px;">问题:<br />
			<textarea style="width: 80%;" rows="1" name="question"></textarea></span>

	</div>
	<div>
		<span
			style="font-weight: 600; color: #666666; position: relative; left: 20px; top: 17px;">解决方法:<br />
			<script id="editor" type="text/plain" style="height: 300px;"></script></span>

	</div>
	<br />
	<input type="button" style="margin-left: 650px; padding-bottom: 20px;"
		id="btn" value="提交" />

</body>
</html>