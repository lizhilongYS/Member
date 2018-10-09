<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link
	href="${pageContext.request.contextPath}/resources/H-ui_v3.0/css/H-ui.min.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jslib/myfile.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/layer/layer-v2.0/layer/layer.js"></script>
<style type="text/css">
.main {
	width: 800px;
	margin-left: 25%;
}

.img {
	height: 200px;
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
$(function(){
	getMeb();
	getCover();
	
	var bron = null, now = null, school_place = null, name = null, school = null, company = null, mobile = null, graduateDate = null, exit_flag = false, a, b, c, flag = false;
	
	function getCover() {
		$.ajaxSetup({async: false});
		$.post("${pageContext.request.contextPath}/picture/getCover.action", {
			"id": $("#uid").val()
		}, function (data) {
			if (data != "") {
				$("#imgdiv").html("<a href='javascript:void(0)' class='setcover'><img src='data: image/jpeg;base64," + data.photo + "' alt='用户头像' class='img'>");
			}
		});
	}
	//设置小助手
	function getMeb(){
		$.ajaxSetup({async: false});
		$.post("${pageContext.request.contextPath}/member/getMemberById.action",{"id":$("#id").val()},function(data){
			if(data.admin!=null){
				$(".assist").html("<td>学习小助手:</td><td>"+data.admin.realname+"</td>");
			}	
		});
	}

    //编辑资料
    /* $(".btn").click(function(){ */
    $(document).on("click", ".btn", function (){

        if (!exit_flag) {
            a = $("#born_place").text();
            b = $("#now_place").html();
            c = $("#school_place").text();
        }

    	$("#name").html("<input type='text' placeholder='必填项' value="+$("#name").text()+" name='name' >");
        $("#school").html("<input type='text' placeholder='必填项' value="+$("#school").text()+" name='school'> ");
        $("#company").html("<input type='text' placeholder='必填项' value="+$("#company").text()+" name='company'> ");
        $("#mobile").html("<input type='text' placeholder='必填项' value="+$("#mobile").text()+" name='mobile'> ");
        $("#graduateDate").html("<input type='text' placeholder='必填项' value="+$("#graduateDate").text()+" name='graduateDate'> ");

        // 下拉列表
        $("#born_place").html("<td><select id = 'bron_city'><c:forEach items='${citys}' var='city'><option value='${city.id}' <c:if test='${city.id == _a}'>selected</c:if>>${city.name}</option></c:forEach></select></td>");//place.born.id
        $("#now_place").html("<td><select id = 'now_city'><c:forEach items='${citys}' var='city'><option value='${city.id}' <c:if test='${city.id == place.province.id}'>selected</c:if>>${city.name}</option></c:forEach></select></td>");
        $("#school_place").html("<td><select id = 'school_city'><c:forEach items='${citys}' var='city'><option value='${city.id}' <c:if test='${city.id == place.school.id}'>selected</c:if>>${city.name}</option></c:forEach></select></td>");


        /**
         * 重置下拉框的选择状态
         * 	曾小晨
         * @type {*}
         */
        var val = $("#a_bron").val();
        var query = $("#bron_city option");
        for (var i = 0; i < query.length; i++) {
            if (query[i].value === val) {
                query[i].selected = true;
            }
        }


        /**
         * 重置下拉框的选择状态
         * 	曾小晨
         * @type {*}
         */
        var val = $("#b_proince").val();
        var query = $("#now_city option");
        for (var i = 0; i < query.length; i++) {
            if (query[i].value === val) {
                query[i].selected = true;
            }
        }



        /**
         * 重置下拉框的选择状态
		 * 	曾小晨
         * @type {*}
         */
        var val = $("#c_shcool").val();
        var query = $("#school_city option");
        for (var i = 0; i < query.length; i++) {
            if (query[i].value === val) {
                query[i].selected = true;
            }
        }


        $("#btn").html("<input class='btn' type='button' value='保存信息' id='save'>");
        /**
		 * 增加退出编辑功能：曾小晨
         */
        $("#exit").html("<input class='btn' type='button' value='退出编辑' id='outInt'>");

        $("#outInt").click(function () {
            exit_flag = true;  // true
			flag = true;
        });


        if (!flag) {
            name = $("[name = 'name']").val();
            school = $("[name = 'school']").val();
            company = $("[name = 'company']").val();
            mobile = $("[name = 'mobile']").val();
            graduateDate = $("[name = 'graduateDate']").val();
        }

        if (exit_flag) { // false
            $("#btn").html("<input class='btn' type='button' value='编辑信息'>");
            $("#exit").html("");
            $("#born_place").html(a);
            $("#now_place").html(b);
            $("#school_place").html(c);

            $("#name").html(name);
            $("#school").html(school);
            $("#company").html(company);
            $("#mobile").html(mobile);
            $("#graduateDate").html(graduateDate);

            exit_flag = false;
            return;
        }

        $("#save").click(function(){

            flag = true;

            var born_options = $("#born_place option:selected");
            $("#a_bron").val(born_options.val());
            
            var now_options = $("#now_place option:selected");
            $("#b_proince").val(now_options.val());
            
            var school_options = $("#school_place option:selected");
            $("#c_shcool").val(school_options.val());
            
        	bron = $("#bron_city option:selected").text();
            now = $("#now_city option:selected").text();
            school_place = $("#school_city option:selected").text();
            name = $("[name = 'name']").val();
            school = $("[name = 'school']").val();
            company = $("[name = 'company']").val();
            mobile = $("[name = 'mobile']").val();
            graduateDate = $("[name = 'graduateDate']").val();
            
        	var name=$.trim($("[name='name']").val());
            var mobile=$.trim($("[name='mobile']").val());
            var reg=/[\u4e00-\u9fa5]+/;
            var regTel=/^0[\d]{2,3}-[\d]{7,8}$/;
            var regMobile = /^0?1[3|4|5|8|7][0-9]\d{8}$/;
            var regDate=/^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$/;
            if (name=="" || mobile==""){
                $("#info").html("真实姓名和移动电话不能为空");
                return false;
            }
            var tflag = regTel.test(mobile);
            var mflag = regMobile.test(mobile);
            if (!(tflag||mflag)){
                $("#info").html("移动电话输入不合法");
                return false;
            }
            if(!regDate.test($("[name='graduateDate']").val()))
            {
                $("#info").html("日期输入不合法,例: 2000-07-15");
                return false;
            }
            $.ajaxSetup({async: false});
            $.post("${pageContext.request.contextPath}/member/updateMember1.action",{"id":$("#id").val(),"uid":$("#uid").val(),"name":name,
                "company":$("[name='company']").val(),"mobile":mobile,"sex":$("#sex").text(),"school":$("[name='school']").val(),
                "graduateDate":$("[name='graduateDate']").val(), "provid": $("#now_city option:selected").val(), "schProId": $("#school_city option:selected").val(), "seat_provid": $("#bron_city option:selected").val()},function(data){
                if(data==1)
                {
                    layer.msg('保存成功',{
                        icon:1,
                        time:600,
                        end: function(){

        					$("#name").html(name);
        					$("#school").html(school);
        					$("#company").html(company);
        					$("#mobile").html(mobile);
        					$("#graduateDate").html(graduateDate);
                            
                            $("#born_place").html(bron);
						    $("#now_place").html(now);
						   	$("#school_place").html(school_place);
						   	$("#btn").html("<input class='btn' type='button' value='编辑信息'>");
                            $("#exit").html("");
                        }
                    })
                }
                else{
                    layer.msg('登录过期，请重新登录',{
                        icon:0
                    })
                }
            });
        });
    });
});
</script>
</head>
<body>
	<div class="main" style="margin: 0px;">
		${myuser.member.admin.realname } <input type="hidden" id="uid"
			value="${myuser.id}"> <input type="hidden" id="id"
			value="${myuser.member.id}">
		<table>
			<tr>
				<td width="500px;">
					<table class="table table-border table-bg table-bordered radius">
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
						<tr>
							<td>身份证号:</td>
							<td id="id_card">${myuser.userInfo.idNo}</td>
						</tr>
						<tr>
							<td>QQ号码:</td>
							<td id="qq">${myuser.userInfo.qqNo}</td>
						</tr>
						<tr>
							<td>支付宝账号:</td>
							<td id="pay_treasure">${myuser.userInfo.payAccount}</td>
						</tr>
						<tr>
							<td>家庭联系人:</td>
							<td id="family">${myuser.userInfo.contactName}</td>
						</tr>
						<tr>
							<td>家庭联系人手机:</td>
							<td id="family_tel">${myuser.userInfo.contactMobile}</td>
						</tr>
						<tr>
							<td>与家庭联系人关系:</td>
							<td id="family_relation">${myuser.userInfo.relation}</td>
						</tr>
						<tr>
							<td>本人收件地址:</td>
							<td id="receipt">${myuser.userInfo.address}</td>
						</tr>


						<%--
			曾小晨
			2017-08-21 增加了会员地区的修改
		--%>
						<tr>
							<td>出生地:</td>
							<input type="hidden" value="${place.born.id}" id="a_bron">
							<td id="born_place">${place.born.name}</td>
							<%-- seat_provid --%>
						<tr>
							<td>现在地:</td>
							<input type="hidden" value="${place.province.id}" id="b_proince">
							<td id="now_place">${place.province.name}</td>
							<%-- provid --%>
						</tr>
						<tr>
							<td>学校所在地:</td>
							<input type="hidden" value="${place.school.id}" id="c_shcool">
							<td id="school_place">${place.school.name}</td>
						</tr>
						<tr class="assist"></tr>
					</table> <!-- 去掉编辑功能 --> <%-- 曾小晨：打开编辑功能 --%>
					<div class="controls" id="btn">
						<input class="btn" type="button" value="编辑信息">
					</div> <%-- 编辑按钮 --%>
					<div class="controls" id="exit" style="margin-left: 25px;"></div>

					<div id="info" class="controls"></div>
				</td>
				<td>
					<div style="margin-left: 30px">
						<div id="imgdiv" style="width: 250px; height: 350px;">
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
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>