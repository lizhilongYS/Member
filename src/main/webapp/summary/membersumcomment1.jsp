<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的周报-专注建立IT精英圈子</title>
<!-- 
	<link href="${pageContext.request.contextPath}/tableTemplet/css/H-ui.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/tableTemplet/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer-v2.0/layer/layer.js"></script>	
	<link href="${pageContext.request.contextPath}/resources/plugin/ueditor/themes/default/css/ueditor.css" rel="stylesheet" type="text/css" />
	
	 -->
<link
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<!-- 
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
   	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/ueditor.all.js"></script>
   	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
   	 -->
<!--[if lt IE 9]>
	<script src="http://cdn.static.runoob.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
<style type="text/css">
/*html5兼容*/
article, aside, dialog, footer, header, section, footer, nav, figure,
	menu {
	display: block
}

.commcontendivcodd {
	padding-left: 35px;
	padding-right: 35px;
}
/*
	 * 修改：添加imgdiv,img;删除left,left span的样式以适应更新的周报界面
	 * 作者：王德斌
	 * 日期：2016-10-13
	*/
div#imgdiv {
	width: 50px;
	height: 50px;
	float: right;
	margin-top: 10px;
	margin-right: 15px;
}

#editordiv {
	width: 100%;
	height: 100px;
}

#editor {
	width: 100%;
	height: 100%;
}

.img {
	border-radius: 50%;
	width: 50px;
	height: 50px;
}
/* 
	 * 修改：添加username,commentcdivseatprovince,commentcdivprovince样式;
	 *		修改commentcdivname,commentcdivtime,commentcdivassistant样式使其与新界面匹配
	 * 作者：王德斌
	 * 日期：2016-10-13 
	 */
.username {
	font-weight: 600;
	position: relative;
	top: 0px;
	margin-left: 10px;
}

.commentcdivname {
	position: relative;
	font-weight: 600;
	top: 0px;
	margin-left: 10px;
}

.commentcdivtime {
	position: relative;
	font-weight: 600;
	top: 0px;
	margin-left: 10px;
}

.commentcdivseatprovince {
	position: relative;
	font-weight: 600;
	top: 0px;
	margin-left: 10px;
}

.commentcdivprovince {
	position: relative;
	font-weight: 600;
	top: 0px;
	margin-left: 10px;
}

.commentcdivassistant {
	position: absolute;
	top: 50px;
	right: 100px;
	text-align: center;
	font-size: 13px;
	color: #1C86EE;
}

.label-clue {
	background-color: #39c3be;
}
</style>
<script type="text/javascript">

$(function(){
	$.ajaxSetup({async:false});
	$.post("${pageContext.request.contextPath}/user/logger.action",{content:"membersumcomment1.jsp:summary load begin"});
	//获取url中的参数,以便返回
    (function ($) {
        $.getUrlParam = function (name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]); return null;
        }
    })(jQuery);
    var userType=null;
	var userID=null;
    var id = $.getUrlParam('id');
    var page2 = $.getUrlParam('page2');
    var ownerType = $.getUrlParam('ownerType');	
    var checkType = $.getUrlParam('checkType');
    var weekType = $.getUrlParam('weekType');
    var title = $.getUrlParam('title');

    var aa=0;
    var sumId;
    getSum(id);
    getComs(sumId);
    var contents=$("#editor").val();
    /*
	var ue = UE.getEditor('editor',{
		initialFrameWidth: $("#contas").width() * 0.9,
		initialContent:'请在此输入评论内容',
		autoClearinitialContent:true,
		enableAutoSave: false
	});
	ue.ready(function(){
		aa= UE.getEditor('editor').getContent();
	});
	*/
	//在这里如果是看自己的最后一篇周报   就删除remind记录
	$.post("${pageContext.request.contextPath}/summary/remind.action",{pid:sumId});	
	$.post("${pageContext.request.contextPath}/user/logger.action",{content:"membersumcomment1.jsp:summary load ok"});
	//审核
	$("#icon").click(function(){
		$.ajaxSetup({async:false});
		$.post("${pageContext.request.contextPath}/summary/approveSumarry.action",{id:sumId},function(){
			$("#icon").attr({style:"color:red"});
		});					
		//设置审核隐藏域的值
		parent.$("#look").val('1');
	});
	
	//判断周报是否已推荐
	$.ajaxSetup({ async : false });
	$.post("${pageContext.request.contextPath}/summary/checkRepeatRecommend.action",{id:sumId},function(data){
		if(data=="1")
			{		
				$("#recommendtd").html("<a href='javascript:;' id='cancelreco' ><span class='layui-btn layui-btn-mini layui-btn-danger'>取消推荐</span></a>");		
			}
		else
			{
				$("#recommendtd").html("<a href='javascript:;' id='reco' ><span class='layui-btn layui-btn-mini' style='font-size: 15px;' >推荐</span></a>");
			}	
			reco();
			cancelreco();
		});
	//推荐周报
	function reco(){
		$("#reco").click(function(){
			$.ajaxSetup({async:false});
			$.post("${pageContext.request.contextPath}/summary/referralSumarry.action",{id:sumId},function(data){
				$("#images").css("background-image","url(${pageContext.request.contextPath}/images/119.png)");				
				$("#recommendtd").html("<a href='javascript:;' id='cancelreco' ><span class='layui-btn layui-btn-mini layui-btn-danger'>取消推荐</span></a>");		
				$("#images").show();
				cancelreco();
			});					
		});
	}	
	//取消推荐
	function cancelreco(){			
		$("#cancelreco").click(function(){
			$.ajaxSetup({async:false});
			$.post("${pageContext.request.contextPath}/summary/cancelSumarry.action",{id:sumId},function(){
				$("#recommendtd").html("<a href='javascript:;' id='reco' ><span class='layui-btn layui-btn-mini' style='font-size: 15px;' >推荐</span></a>");
				$("#images").hide();
				reco();
			});					
		});
	}			

	
	//会员评论				
	$("#comment").click(function(){	
		/*
		var ue = UE.getEditor('editor');
		
		$.ajaxSetup({async:false});
		var contents=ue.getContent();
		*/
		$.ajaxSetup({async:false});
		var contents=$("#editor").val();
		//评论不能为空
		if(contents == "" || contents == aa){
			alert("评论内容不能为空");
			return;
		}
		$.post("${pageContext.request.contextPath}/summary/addComment.action",{content:contents,pid:sumId},function(data){
			if(data=="1"){
				//改变summary表中remind字段
				$.post("${pageContext.request.contextPath}/summary/remind.action",{pid:sumId});
				/*
				ue.ready(function(){
					ue.setContent("");
				});	
				*/
				$("#editor").val("");
			}
			else{
				layer.open({
 					  type: 2,
 					  title: '登录',
 					  area: ['600px', '361px'],
 					  closeBtn: 0, //不显示关闭按钮
 					  shift: 1,
 					  shade: 0.5, //开启遮罩关闭
 					  content: '${pageContext.request.contextPath}/summary/login.jsp?state=3&id=0&contents='+contents,
 					  end: function(){
  	     					parent.layer.msg('登录成功', {
	    					    icon: 1,
	    					    time: 1000
	    					});
	     					var time=null;
	  		 					time=setInterval(function(){
	    	     				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	    						parent.layer.close(index);
	    					},1000);
 					    }
 					});
			}	
			getComs(sumId);	
		});
	});
	//管理员评论
	$("#commentadmin").click(function(){
		/*
		var contents=UE.getEditor('editor').getContent();
		*/
		var contents=$("#editor").val();
		//评论不能为空
		if(contents == "" || contents == aa){
			alert("评论内容不能为空");
			return;
		}
		$.post("${pageContext.request.contextPath}/summary/addComment.action",{content:contents,pid:sumId},function(data){
			if(data=="1"){
				//改变summary表中remind字段
				$.post("${pageContext.request.contextPath}/summary/remind.action",{pid:sumId});
				$("#editor").val("");
				/*
				ue.ready(function(){
					ue.setContent("");
				});	
				*/
			}
			else{
				layer.open({
					  type: 2,
					  title: '登录',
					  area: ['600px', '361px'],
					  closeBtn: 0, //不显示关闭按钮
					  shift: 1,
					  shade: 0.5, //开启遮罩关闭
					  content: '${pageContext.request.contextPath}/summary/login.jsp?state=3&id=0&contents='+contents,
					  end: function(){
	     					parent.layer.msg('登录成功', {
	    					    icon: 1,
	    					    time: 1000
	    					});
	     					var time=null;
	  		 					time=setInterval(function(){
	    	     				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	    						parent.layer.close(index);
	    					},1000);
					    }
					});
			}	
			getComs(sumId);					
		});
	});	
	/*
	//管理员返回
	$("#adminreturn").click(function(){
		//location.href="${pageContext.request.contextPath}/admin/looksummarys.jsp?page2="+page2+"&checkType="+checkType+"&weekType="+weekType+"&title="+title;
		history.go(-1);
	});	
	//会员返回
	$("#memberreturn").click(function(){
			//location.href="${pageContext.request.contextPath}/member/looksummarys.jsp?page2="+page2+"&ownerType="+ownerType+"&checkType="+checkType+"&weekType="+weekType+"&title="+title;
		history.go(-1);
	})	*/
	
	//获取周报
	/*
	 * 修改：添加获取用户头像、出生地和所在地的代码
	 * 作者：王德斌
	 * 日期：2016-10-13
	 
	 * 修改：添加sex参数，修复默认头像显示问题
	 * 作者：王德斌
	 * 日期：2016-10-16
	*/	
    function getSum(id){
		$.ajaxSetup({async:false});
		var uid = "";
		var provid = "";
		var seat_provid = "";
    	$.post("${pageContext.request.contextPath}/summary/getSumById.action",{id:id},function(data){
    	/* 	alert(data); */
    		var id=0;
    		var name="";
    		var adminname="";
    		var num="";
    		var sex;
    		
			if(data.mid!=0){
				userID=id=data.member.id;
				//修改此处 name=data.member.id;
				userType="member";
				if(data.member.admin!=null){
					adminname="学习助手："+data.member.admin.realname;
				}				
				//num=data.member.user.name;
				num=data.member.user.name+"&nbsp;&nbsp;"+data.member.name;
				uid = data.member.uid;
				provid = data.member.provid;
				seat_provid = data.member.seat_provid;
				sex=data.member.sex;
			}else  if(data.eid!=0){
				userID=id=data.experience.id;
				//修改此处 name=data.experience.id;
				userType="experience";
				if(data.experience.admin!=null){
					adminname="学习小助手："+data.experience.admin.realname;
				}			
				num=data.experience.name;
				provid = data.experience.province;
				seat_provid = data.experience.seat_provid;
				sex=data.experience.sex;
				//解决体验者序号显示不全的问题
				$(".username").css("font-size",1+"em");
			}else{
				userID=id=data.clue.id;
				userType="clue";
				if(data.clue.admin!=null){
					adminname="学习小助手："+data.clue.admin.realname;
				}			
				num=data.clue.num;
				
				provid = "未知";
				seat_provid = "未知";
 				sex=data.clue.sex;
				
			} 
			
			$("#memid").val(id);
			$(".commentcdivname").html(name);
			//取年月日
			$(".commentcdivtime").html(data.time.substring(0,11)); 
			$(".commentcdivassistant").html(adminname);			
			$(".username").html(num);
			$("#sex").val(sex);
			/* $("#cont").html($(data.content).text()); */
			$("#cont").html(data.content);
			sumId=data.id;
			/* alert(sumId); */

			if(data.ischeck==1)
				{
					$("#icon2").attr({style:"color:red"});
					$("#icon").attr({style:"color:red"});
				}
			if(data.recommend==1)
			{
				$("#images").css("background-image","url(${pageContext.request.contextPath}/images/119.png)");
			}			
    	})
    	if(seat_provid=="未知"){
    		$(".commentcdivseatprovince").html("出生地:不告诉你");
    	}else{
    		getSeatProvince(seat_provid);
    	}
    	if(provid=="未知"){
    		$(".commentcdivprovince").html("所在地:不知道");
    	}else{
    		getProvince(provid);
    	}
		getCover(uid);
		
		
    
    }
	//获取评论和浏览记录
    function getComs(id){
    	$.ajaxSetup({async:false});
		$.post("${pageContext.request.contextPath}/summary/getComments.action",{id:id},function(data){
			if(data.summaries !="")
			{
				var commentsString="";
				$.each(data.summaries,function(i) {
					var memberid=0;
					var experienceid=0;
					var contentname;
					var contenttime=data.summaries[i].time;
					var content=data.summaries[i].content;
					if(data.summaries[i].member!=null)
					{
						memberid=data.summaries[i].member.id;
						contentname=data.summaries[i].member.name;
					}
					if(data.summaries[i].experience!=null)
					{
						experienceid=data.summaries[i].experience.id;
						contentname=data.summaries[i].experience.name;
					}
					if(data.summaries[i].admin !=null)
					{
						contentname="<font color='red'><b>"+data.summaries[i].admin.realname+"</b></font>";					
					}
					var commentString="<div class='commcontendivcod'>";
					commentString+="<span class='commcontendivcods'>"+contentname+"&nbsp;&nbsp;"+"</span>";
					commentString+="<span class='commcontendivcodsins'>"+contenttime+"</span>";
					if($("#isAdmin").val()=="admin"||memberid==$("#memberId").val()||experienceid==$("#experienceId").val()){
						commentString+="<span><a class='icon-delete-small' href='javascript:;' lang="+data.summaries[i].id+"><i class='Hui-iconfont'>&#xe6e2;</i></a></span>";
					}	
					if(($("#isAdmin").val()=="admin"&&memberid==0&&experienceid==0)||memberid==$("#memberId").val()||experienceid==$("#experienceId").val()){
						commentString+="<span><a class='icon-update-small' href='javascript:;' lang="+data.summaries[i].id+"><i class='Hui-iconfont'>&#xe60c;</i></a></span>";
					}
					commentString+="<div class='commcontendivcodd'>";
					commentString+="<br>";
					commentString+="<div>"+content+"</div>";
					commentString+="<br>";
					commentString+="</div>";	
					commentString+="</div>";						
					commentsString+=commentString;	
				});	
				$("#comments").html(commentsString);
			}
			else{
				var commentString="<div class='commcontendivcod'>";
				commentString+="<div class='commcontendivcodd2'>";
				commentString+="<div class='nocondiv'>";
				commentString+="<br>";
				commentString+="<span class='nocontent'>"+"暂无评论......"+"</span>";
				commentString+="<br>";	
				commentString+="</div>";	
				commentString+="</div>";
				commentString+="</div>";
				$("#comments").html(commentString);
			};
			if(data.summaryVisits !="") {
				var visitString = "";
				var visitAdmin = "";
				var visitUser = "";
				var visitExperience = "";
				$.each(data.summaryVisits,function(i) {
					if(data.summaryVisits[i].flag == 1) {
						visitAdmin += "<span class='label label-warning'>" + data.summaryVisits[i].name + "</span>\t";
					} else if(data.summaryVisits[i].flag == 2) {
						visitUser += "<span class='label label-success'>" + data.summaryVisits[i].name + "</span>\t";
					} else if(data.summaryVisits[i].flag == 3){
						visitExperience += "<span class='label label-info'>" + data.summaryVisits[i].name + "</span>\t";
					}else{
						visitExperience += "<span class='label label-clue'>" + data.summaryVisits[i].name + "</span>\t";
					}
				});
				visitString += "<div class='commcontendivcod'><div class='commcontendivcodd'><br />";
				visitString += visitAdmin;	
				visitString += visitUser;
				visitString += visitExperience;	
				visitString += "<br /><br /></div></div>";
				$("#visit").html(visitString);
			}
			delComment();
			updateComment();
		});
    }
	//删除评论
    function delComment(){
		$(".icon-delete-small").click(function(){
			var id=this.lang;
			if(!confirm('您真的要删除此评论吗？'))
			{
				return;
			}
			else
			{
			$.post("${pageContext.request.contextPath}/summary/delComment.action",{id:id},function(){
				getComs(sumId);
			});
			}
		});
	}
	
	//修改评论
	function updateComment(){
		$(".icon-update-small").click(function(){
			var id=this.lang;
			layer.open({
				type: 2,
				title: '修改评论',
				area: ['700px', '361px'],
				closeBtn: 1, //不显示关闭按钮
				shift: 1,
				shade: 0.5, //开启遮罩关闭
				content: '${pageContext.request.contextPath}/summary/modifycomment.jsp?id='+id
			});
		});
	}
	
	// 得到用户头像
	/* 
	 * 修改：添加sex参数，修复默认头像显示问题
	 * 作者：王德斌
	 * 日期：2016-10-16 
	 */
    function getCover(uid) {
		if(uid == ""){
			if($("#sex").val()=='男'){
				$("#imgdiv").html("<img src='${pageContext.request.contextPath}/images/user_male.png' alt='用户头像' class='img'>");
			}
			else{
				$("#imgdiv").html("<img src='${pageContext.request.contextPath}/images/user_female.png' alt='用户头像' class='img'>");
			}
		} else {
			$.ajaxSetup({
				async : false
			});
			$.post("${pageContext.request.contextPath}/picture/getCover.action", {
				id : uid
			}, function(data) {
				if (data != "") {
					$("#imgdiv").html("<img src='data: image/jpeg;base64," + data.photo + "' alt='用户头像' class='img'>");
				}
				else if($("#sex").val()=='男'){
					$("#imgdiv").html("<img src='${pageContext.request.contextPath}/images/user_male.png' alt='用户头像' class='img'>");
				}
				else{
					$("#imgdiv").html("<img src='${pageContext.request.contextPath}/images/user_female.png' alt='用户头像' class='img'>");
				}
			});
		}
	}

	// 得到用户出生地
	function getSeatProvince(seat_provid) {
		$.post("${pageContext.request.contextPath}/member/getProvByProvId.action", {
			provid : seat_provid
		}, function(data) {
			var seat_province = data.name;
			if (typeof (seat_province) == "undefined") {
				seat_province = "未设置";
			}
			var info = "出生地:" + seat_province;
			$(".commentcdivseatprovince").html(info);
		});
	}

	// 得到用户所在地
	function getProvince(provid) {
		$.post("${pageContext.request.contextPath}/member/getProvByProvId.action", {
			provid : provid
		}, function(data) {
			var province = data.name;
			if (typeof (province) == "undefined") {
				province = "未设置";
			}
			var info = "所在地:" + province;
			$(".commentcdivprovince").html(info);
		});
	}
	
	//管理员点击用户头像，跳出其个人信息和所有沟通信息
	/* 
	 * 作者：巨李岗
	 * 日期：2016-10-21 
	 */
	$("#imgdiv").click(function(){
		//location.href="${pageContext.request.contextPath}/admin/PersonalInfoAndCommunication.jsp";
		//alert($("#memid").val());
		if($("#isAdmin").val()=="admin")    //添加管理员权限
		{
			layer.open({
				  type: 2,
				  title: '会员信息和沟通信息',
				  area: ['700px', '450px'],
				 // closeBtn: 0, //不显示关闭按钮
				  shift: 1,
				  //maxmin: true,
				  shade: 0.5, //开启遮罩关闭
				  content: '${pageContext.request.contextPath}/admin/PersonalInfoAndCommunication.jsp?userID='+userID+"&userType="+userType,
				  end: function(){}
					//getData(checkType,weekType,title,page2,assistant);
				});
		}
	});
	<%--获取该用户上一周的周报 --%>
	$("#presummary").click(function(){
		$.post("${pageContext.request.contextPath}/summary/getPreSummaryIdByUserId.action",{userType:userType, userId:userID, sid:sumId},function(data){
			if(data!=null && data!=""){ 
				if(data!="0"){
					var preId = data;
					location.href = "${pageContext.request.contextPath}/summary/membersumcomment1.jsp?id=" + preId;			
				}else{
					alert("已是第一周！");
				}
			}
		})
	})
	<%--获取该用户下一周的周报 --%>
	$("#nextsummary").click(function(){
		$.post("${pageContext.request.contextPath}/summary/getNextSummaryIdByUserId.action",{userType:userType, userId:userID, sid:sumId},function(data){
			if(data!=null && data!="" ){
				if(data!="0"){
					var nextId = data;
					location.href = "${pageContext.request.contextPath}/summary/membersumcomment1.jsp?id=" + nextId;	
				}else{
					alert("已是最后一周");
				}
			}
		}) 
	})
	<%--获取该用户当前周（最近一周）的周报 --%>
	$("#currentsummary").click(function(){
		$.post("${pageContext.request.contextPath}/summary/getCurrentSummaryIdByUserId.action",{userType:userType, userId:userID},function(data){
			if(data!=null && data!="" && data!="0"){
				var nextId = data;
				location.href = "${pageContext.request.contextPath}/summary/membersumcomment1.jsp?id=" + nextId;			
			}
		})
	})	
	<%--获取该用户第一周的周报 --%>
	$("#firstsummary").click(function(){
		$.post("${pageContext.request.contextPath}/summary/getFirstSummaryIdByUserId.action",{userType:userType, userId:userID},function(data){
			if(data!=null && data!="" && data!="0"){
				var nextId = data;
				location.href = "${pageContext.request.contextPath}/summary/membersumcomment1.jsp?id=" + nextId;			
			}
		})
	})	
 });
</script>

</head>
<body style="background-color: #EEEEEE;" id="mybody">
	<c:if
		test="${myuser.member==null && admin==null && experience==null && clue==null}">
		<c:redirect url="/user/login.jsp" />
	</c:if>
	<!-- 正文 -->
	<!-- <div class="content-wrap"> -->

	<div id="contas">
		<div class="container">
			<!-- 
		 * 修改：添加用户头像imgdiv、出生地commentcdivseatprovince及所在地commentcdivprovince
		 * 作者：王德斌
		 * 日期：2016-10-13
		 
		 * 修改：添加sex参数，修复默认头像显示问题
		 * 作者：王德斌
		 * 日期：2016-10-16 
		 -->
			<div class="commentcdiv">
				<div style="height: 50px; background-color: rgb(71, 201, 255)">
					<input type="hidden" id="sex" /> <input type="button"
						id="firstsummary" title="第一周" value="&lt;&lt;"
						style="margin-right: -5px;"> <input type="button"
						id="presummary" title="上一周" value="&lt;&nbsp;"
						style="margin-right: -5px;"> <input type="button"
						id="nextsummary" title="下一周" value="&gt;&nbsp;"
						style="margin-right: -5px;"> <input type="button"
						id="currentsummary" title="最近一周" value="&gt;&gt;"> <span
						class="username"></span> <span class="commentcdivname"></span> <span
						class="commentcdivtime"></span> <span
						class="commentcdivseatprovince"></span> <span
						class="commentcdivprovince"></span> <span
						class="commentcdivassistant"></span>
					<div id="imgdiv"></div>
					<input type="hidden" id="memid">
				</div>
				<hr color="#00CCFF" style="height: 3px;" />
				<div class="commtent">
					<div id="cont"></div>
				</div>
				<br>
				<br>
			</div>
			<!--
        	作者：615893265@qq.com
        	时间：2015-11-23
        	描述：这是审阅标记
        -->
			<div class="approvedi">
				<div id="images"
					style='transform: rotate(-15deg); position: absolute; margin-top: -170px; width: 517px; height: 307px; left: 100px; z-index: 999;'></div>
				<div class="approvedidiv">
					<c:choose>
						<c:when test="${admin!=null}">
							<ul class="layui-tab-title">
								<li id="recommendtd" class="layui-nav-item"></li>
								<li class="layui-nav-item"><a href="javascript:;" id="icon">
										<span class="glyphicon glyphicon-eye-open"
										style="font-size: 24px; float: right"></span>
								</a></li>
							</ul>
						</c:when>
						<c:when test="${admin==null}">
							<div id="icon2">
								<span class="glyphicon glyphicon-eye-open"
									style="font-size: 24px;"></span>
							</div>
						</c:when>
					</c:choose>
				</div>
				<br>
				<br>
			</div>
			<!--
        	作者：615893265@qq.com
        	时间：2015-11-23
        	描述：这是评论内容列表
        -->
			<div class="commcontendiv" id="commcontendiv">
				<div class="commcontendivtd">
					<span class="commcontendivtdspan">评论</span>
				</div>
				<div id="comments"></div>
			</div>
			<div class="commcontendiv" id="commcontendiv">
				<div class="commcontendivtd">
					<span class="commcontendivtdspan">谁看过我</span>
				</div>
				<div id="visit"></div>
			</div>
			<!--
        	作者：615893265@qq.com
        	时间：2015-11-23
        	描述：这是写评论的编辑器
        -->
			<br>
			<br>
			<div id="editordiv">
				<!-- 
			<script id="editor" type="text/plain" style="width: 120px;height: 100px;"></script>
			 -->
				<textarea id="editor" placeholder="请在此输入评论内容"></textarea>
			</div>
			<div style="float: left;">
				<c:choose>
					<c:when
						test="${admin==null&&(myuser.member!=null||experience!=null)}">
						<button class="btn-sm btn-primary" id="comment">
							<span>发表评论</span>
						</button>
					</c:when>
					<c:when test="${admin!=null}">
						<button class="btn-sm btn-primary" id="commentadmin">
							<span>发表评论</span>
						</button>
					</c:when>
				</c:choose>
				&nbsp;&nbsp;&nbsp;
				<!-- 去除返回功能
		<c:choose>
			<c:when test="${admin!=null}">
				<button class="btn" id="adminreturn"><span style="color:red ;">返回</span></button>
			</c:when>
			<c:when test="${admin==null&&myuser.member!=null}">
				<button class="btn" id="memberreturn"><span style="color:red ;">返回</span></button>
			</c:when>
		</c:choose>	
		 -->
				<c:choose>
					<c:when
						test="${admin==null&&(myuser.member!=null||experience!=null)}">
						<input type="hidden" value="notadmin" id="isAdmin">
						<input type="hidden" value="${myuser.member.id}" id="memberId">
						<input type="hidden" value="${myuser.member.id}" id="experienceId">
					</c:when>
					<c:when test="${admin!=null}">
						<input type="hidden" value="admin" id="isAdmin">
					</c:when>
				</c:choose>
				<div>&nbsp;</div>
				<div>&nbsp;</div>
				<div>&nbsp;</div>
				<div>&nbsp;</div>
				<div>&nbsp;</div>
			</div>
			<div></div>
		</div>
	</div>



</body>
</html>