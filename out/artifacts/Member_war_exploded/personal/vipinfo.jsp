<%@ page import="java.util.Map"%>
<%@ page import="java.util.Set"%>
<%@ page import="entity.Province"%>
<%@ page import="java.util.Iterator"%><%--suppress ALL --%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jslib/myfile.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/layer/layer-v2.0/layer/layer.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jslib/currency.js"></script>
<style type="text/css">
.main {
	width: 800px;
	margin-left: 3%;
}

.img {
	width: 198px;
	height: 198px;
}

.controls {
	float: left;
}

#info {
	margin-left: 60px;
	color: red;
	font-size: 16px;
}
</style>
<script type="text/javascript">
        var bron = null, now = null, school = null, exit_flag = false, a, b, c;

        $(function () {
//            $("#exit").hide();

            getMeb(); // 得到当前会员的小助手信息
            getCover(); // 得到用户封面
            function getCover() {
                $.ajaxSetup({async: false});
                $.post("${pageContext.request.contextPath}/picture/getCover.action", {"id": $("#uid").val()}, function (data) {
                    if (data != "") {
                        $("#imgdiv").html("<a href='javascript:void(0)' class='setcover'><img src='data: image/jpeg;base64," + data.photo + "' alt='用户头像' class='img'>");
                    }

                });
            }

            $("#uploading").click(function () {
                $.ajaxSetup({async: false});
                layer.open({
                    type: 2,
                    title: '图片上传',
                    area: ['450px', '520px'],
                    shift: 5,
                    maxmin: true,
                    content: '${pageContext.request.contextPath}/uploading/uploading.jsp',
                    end: function () {
                        // location.href="${pageContext.request.contextPath}/personal/navbar.jsp";
                    }
                });
            });
            $("#image").click(function () {
                var uid = ${myuser.id};
                var allconut =${allconut};
                if (allconut == 0) {
                    layer.msg('请上传图片');
                }
                else {
                    //location.href="${pageContext.request.contextPath}/uploading/photo.jsp?uid="+uid;
                }
            });
            $(".setcover").click(function () {
                //先判断是否有未审核的照片,遵循代码重构规范
                $.post("${pageContext.request.contextPath}/picture/isFlag.action", function (data) {
                    var returnMap = eval("(" + data + ")").returnMap;
                    var statusCode = returnMap.statusCode;
                    if (statusCode.errNum != 100) {
                        layer.msg("<strong style='color:red;'>" + statusCode.errMsg + "</strong>", {icon: 2});
                        return;
                    }
               
                if (returnMap.flag == 1) {
                    layer.confirm('您有照片未审核,是否上传新照片覆盖待审核的照片？', {
                        btn: ['是', '否'] //按钮
                    }, function () {
                        layer.msg('请上传新照片', {icon: 1});
                        photo();
                    }, function () {
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                    });
                } else {
                    photo();
                    }
});
  });
            function photo() {
                layer.open({
                    type: 2,
                    title: '封面设置',
                    area: ['700px', '550px'],
                    shift: 5,
                    maxmin: true,
                    content: '${pageContext.request.contextPath}/uploading/setcover1.jsp',
                    end: function () {
                        layer.msg('新上传照片需要管理员审核才能显示，请耐心等待！', {time: 3000});
                        //getCover();
                    }
                });
            }

            //设置小助手
            function getMeb() {
                $.ajaxSetup({async: false});
                $.post("${pageContext.request.contextPath}/member/getMemberById.action", {"id": $("#id").val()}, function (data) {
                    if (data.admin != null) {
                        $(".assist").html("<td>学习小助手:</td><td>" + data.admin.realname + "</td>");
                    }
                });
            }


            /**
             * 编辑资料的修改
             *  最后修改日期：2017-09-09
             *  修改人：曾小晨
             *  添加了退出编辑功能，修复了城市选择的bug
             */
            $(document).on("click", ".btn", function () {

                if (!exit_flag) {
                    a = $("#born_place").text();
                    b = $("#now_place").html();
                    c = $("#school_place").text();
                }

                // 下拉生成的代码
                $("#born_place").html("<td><select id = 'bron_city'><c:forEach items='${citys}' var='city'><option value='${city.id}' <c:if test='${city.id == place.born_place.id}'>selected</c:if>>${city.name}</option></c:forEach></select></td>");
                $("#now_place").html("<td><select id = 'now_city'><c:forEach items='${citys}' var='city'><option value='${city.id}' <c:if test='${city.id == place.now_place.id}'>selected</c:if>>${city.name}</option></c:forEach></select></td>");
                $("#school_place").html("<td><select id = 'school_city'><c:forEach items='${citys}' var='city'><option value='${city.id}' <c:if test='${city.id == place.school_place.id}'>selected</c:if>>${city.name}</option></c:forEach></select></td>");


                var val = $("#a_bron").val();
                var query = $("#bron_city option");
                for (var i = 0; i < query.length; i++) {
                    if (query[i].value === val) {
                        query[i].selected = true;
                    }
                }


                var val = $("#b_proince").val();
                var query = $("#now_city option");
                for (var i = 0; i < query.length; i++) {
                    if (query[i].value === val) {
                        query[i].selected = true;
                    }
                }



                var val = $("#c_shcool").val();
                var query = $("#school_city option");
                for (var i = 0; i < query.length; i++) {
                    if (query[i].value === val) {
                        query[i].selected = true;
                    }
                }

                $("#btn").html("<input class='btn' type='button' value='保存信息' id='save'>");
                $("#exit").html("<input class='btn' type='button' value='退出编辑' id='outInt'>");


                $("#outInt").click(function () {
                    exit_flag = true;  // true
                });

                if (exit_flag) { // false
                    $("#btn").html("<input class='btn' type='button' value='编辑信息'>");
                    $("#exit").html("");
                    $("#born_place").html(a);
                    $("#now_place").html(b);
                    $("#school_place").html(c);
                    exit_flag = false;
                    return;
                }

                $("#save").click(function () {

                    var born_options = $("#born_place option:selected");
                    $("#a_bron").val(born_options.val());

                    var now_options = $("#now_place option:selected");
                    $("#b_proince").val(now_options.val());

                    var school_options = $("#school_place option:selected");
                    $("#c_shcool").val(school_options.val());


                    bron = $("#bron_city option:selected").text();
                    now = $("#now_city option:selected").text();
                    school = $("#school_city option:selected").text();

                    $.ajaxSetup({async: false});
                    $.post("${pageContext.request.contextPath}/member/updateMember1.action", {
                        "id": $("#id").val(),
                        "uid": $("#uid").val(),
                        "name": $("#name").text(),
                        "company": $("#company").text(),
                        "mobile": $("#mobile").text(),
                        "sex": $("#sex").text(),
                        "school": $("#school").text(),
                        "graduateDate": $("#graduateDate").text(),
                        "provid": $("#now_city option:selected").val(),
                        "schProId": $("#school_city option:selected").val(),
                        "seat_provid": $("#bron_city option:selected").val()
                    }, function (data) {
                        if (data == 1) {
                            layer.msg('保存成功', {
                                icon: 1,
                                time: 600,
                                end: function () {

                                    $("#born_place").html(bron);
                                    $("#now_place").html(now);
                                    $("#school_place").html(school);
                                    $("#btn").html("<input class='btn' type='button' value='编辑信息'>");
                                    $("#exit").html("");
                                }
                            })
                        }
                        else {
                            layer.msg('登录过期，请重新登录', {
                                icon: 0
                            })
                        }
                    });
                });
            });

        });
    </script>
</head>
<body>
	<div class="main">
		${myuser.member.admin.realname } <input type="hidden" id="uid"
			value="${myuser.id}"> <input type="hidden" id="id"
			value="${myuser.member.id}">
		<table>
			<tr>
				<td width="500px;">
					<h1>会员信息</h1>
					<table class="table table-hover">
						<tr>
							<td>用户名:</td>
							<td>${myuser.name}</td>
						</tr>
						<tr>
							<td>真实姓名:</td>
							<td id="name">${myuser.member.name}</td>
						</tr>
						<tr>
							<td>性别:</td>
							<td id="sex">${myuser.member.sex}</td>
						</tr>
						<tr>
							<td>学校:</td>
							<td id="school">${myuser.member.school}</td>
						</tr>
						<tr>
							<td>工作单位:</td>
							<td id="company">${myuser.member.company}</td>
						</tr>
						<tr>
							<td>移动电话:</td>
							<td id="mobile">${myuser.member.mobile}</td>
						</tr>
						<tr>
							<td>是否毕业:</td>
							<td><c:if test="${myuser.member.student=='true'}">未毕业</c:if>
								<c:if test="${myuser.member.student=='false'}">已毕业</c:if></td>
						</tr>
						<tr>
							<td>毕业时间:</td>
							<td id="graduateDate"><fmt:formatDate
									value="${myuser.member.graduateDate}" pattern="yyyy-MM-dd" /></td>
						</tr>
						<tr>
							<td>注册时间:</td>
							<td id=""><fmt:formatDate value="${myuser.member.time}"
									pattern="yyyy-MM-dd" /></td>
						</tr>
						<%--
                        修改人：曾小晨
                        修改时间：2017-08-20
                        修改内容：增加了所在地的修改，展示出生地等信息
                    --%>
						<tr>
							<td>出生地:</td>
							<input type="hidden" value="${place.born_place.id}" id="a_bron">
							<td id="born_place">${place.born_place.name}</td>
							<%-- seat_provid --%>
						<tr>
							<td>现在地:</td>
							<input type="hidden" value="${place.now_place.id}" id="b_proince">
							<td id="now_place">${place.now_place.name}</td>
							<%-- provid --%>
						</tr>
						<tr>
							<td>学校所在地:</td>
							<input type="hidden" value="${place.school_place.id}"
								id="c_shcool">
							<td id="school_place">${place.school_place.name}</td>
						</tr>
						<tr class="assist"></tr>
					</table> <%-- 恢复编辑功能 --%>
					<div class="controls" id="btn">
						<input class="btn" type="button" value="编辑信息">
					</div> <%-- 编辑按钮 --%>
					<div class="controls" id="exit" style="margin-left: 25px;"></div>


					<div id="info" class="controls"></div>
				</td>
				<td>
					<div style="margin-left: 30px">
						<div id="imgdiv">
							<c:choose>
								<c:when test="${myuser.member.sex=='男'}">
									<a class="setcover"><img
										src="${pageContext.request.contextPath}/images/user_male.png"
										alt="用户头像" class="img"></a>
								</c:when>
								<c:otherwise>
									<a class="setcover"><img
										src="${pageContext.request.contextPath}/images/user_female.png"
										alt="用户头像" class="img"></a>
								</c:otherwise>
							</c:choose>
							<!--  	<br />
		<c:if test="${conut==0}"><a href="#" class="setcover"><img src="${pageContext.request.contextPath}/images/22.jpg" alt="用户上传图片" class="img" id="imageshow"></a></c:if>
		<c:if test="${conut!=0}"><img src="${pageContext.request.contextPath}/picture/getCover.action?id=${myuser.id}" class="img"  alt="用户上传图片"  id="imageshow"></c:if>
		-->
						</div>
						<div id="cnav" style="margin-top: 15px; margin-left: 100px;">
							<a class="setcover">设置头像</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<!-- <a href="#" id="uploading">图片上传</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#" id="image">用户相册</a> -->
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>