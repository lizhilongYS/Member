/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-06 10:31:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class feedetailTwo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"", true, 1120256, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/H-ui_v3.0/css/H-ui.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/page.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/jslib/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/layer-v2.4/layer.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/jslib/currency.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t$.ajaxSetup({\r\n");
      out.write("\t\t\tasync : false\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tvar page2 = 1;\r\n");
      out.write("\t\tgetData(page2);\r\n");
      out.write("\t\t$(\".choices\").click(function() {\r\n");
      out.write("\t\t\tvar type = this.lang;\r\n");
      out.write("\t\t\t$(\".choices\").removeClass(\"active\");\r\n");
      out.write("\t\t\t$(this).addClass(\"active\");\r\n");
      out.write("\t\t\tif(type==6){\r\n");
      out.write("\t\t\t\tgetData(page2);\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tgetData2(type,page2);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\tfunction getData(page2) {\r\n");
      out.write("\t\t$.ajaxSetup({\r\n");
      out.write("\t\t\tasync : false\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/getUserByPage.action\", {type : 6,page2 : page2}, function(data) {\r\n");
      out.write("\t\t\tvar dataObj = eval(\"(\" + data + \")\");\r\n");
      out.write("\t\t\tvar navbar = dataObj.returnMap.navbar;\r\n");
      out.write("\t\t\tvar list = dataObj.returnMap.list; \r\n");
      out.write("\t\t\tdrawTable(list);\r\n");
      out.write("\t\t\t$(\".page-nav\").html(navbar);\r\n");
      out.write("\t\t\tbtnpage();\r\n");
      out.write("\t\t})\r\n");
      out.write("\t}\r\n");
      out.write("\t function getData2(type,page2) {\r\n");
      out.write("\t\t$.ajaxSetup({\r\n");
      out.write("\t\t\tasync : false\r\n");
      out.write("\t\t});        \r\n");
      out.write("\t\t $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/member/getAccountLogLast.action\", {type : 1,page2 : page2}, function(data) {\r\n");
      out.write("\t\t\tshowTable(data.data);\r\n");
      out.write("\t\t\t$(\"#paging\").html(showpage(data.page, 10));\r\n");
      out.write("\t\t\tbtnpage2();\r\n");
      out.write("\t\t}) \r\n");
      out.write("\t\t\r\n");
      out.write("\t} \r\n");
      out.write("\t function showTable(data){\r\n");
      out.write("\t\tvar line = \"\";\r\n");
      out.write("\t\tline=line+\"<tr>\"+\r\n");
      out.write("\t\t\"<th>会员号</th>\"+\r\n");
      out.write("\t\t\"<th>姓名</th>\" +\r\n");
      out.write("\t\t\"<th>校名</th>\" +\r\n");
      out.write("\t\t\"<th>电话</th>\" +\r\n");
      out.write("\t\t\"<th>金额</th>\" +\r\n");
      out.write("\t\t\"<th>缴费日期</th>\" +\r\n");
      out.write("\t\t\"<th>审核人</th>\" +\r\n");
      out.write("\t\t\"</tr>\";\t\t\t\t\t \r\n");
      out.write("\t\tfor(var i=0;i<data.length;i++){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar row = \"\";\r\n");
      out.write("\t\t\trow += \"<tr>\"\t\t\t\t\t\r\n");
      out.write(" \t\t\trow += \"<td>\" + data[i].user.name + \"</td>\";\r\n");
      out.write("\t\t\trow += \"<td>\" + data[i].member.name + \"</td>\";\r\n");
      out.write("\t\t\tif(data[i].member.school==null){\r\n");
      out.write("\t\t\t\trow += \"<td></td>\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse{\r\n");
      out.write(" \t\t\t\trow += \"<td>\" + data[i].member.school + \"</td>\";\r\n");
      out.write("\t\t\t};\r\n");
      out.write(" \t\t\trow += \"<td>\" + data[i].member.mobile + \"</td>\";\r\n");
      out.write("\t\t\trow += \"<td>\" + data[i].amount + \"</td>\";\r\n");
      out.write("\t\t\trow += \"<td>\" + new Date(data[i].date).pattern(\"yyyy年MM月dd日\")  + \"</td>\";\r\n");
      out.write("\t\t\tif(data[i].admin==null){\r\n");
      out.write("\t\t\t\t\trow += \"<td></td>\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\trow += \"<td>\" + data[i].admin.realname + \"</td>\";\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\t\t\t\t\trow += \"</tr>\";\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tline =line+row;\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\t$(\"#tbody\").html(line);\r\n");
      out.write("\t\t\r\n");
      out.write("\t} \r\n");
      out.write("\tfunction drawTable(data) {\r\n");
      out.write("\t\tvar line = \"\";\r\n");
      out.write("\t\tline=line+\"<tr>\"+\r\n");
      out.write("\t\t\"<th>会员号</th>\"+\r\n");
      out.write("\t\t\"<th>姓名</th>\" +\r\n");
      out.write("\t\t\"<th>校名</th>\" +\r\n");
      out.write("\t\t\"<th>电话</th>\" +\r\n");
      out.write("\t\t\"<th>金额</th>\" +\r\n");
      out.write("\t\t\"<th>日期</th>\" +\r\n");
      out.write("\t\t\"<th>小助手</th>\" +\r\n");
      out.write("\t\t\"<th>操作</th>\" +\r\n");
      out.write("\t\t\"</tr>\";\r\n");
      out.write("\t\tfor (i = 0; i < data.length; i++) {\r\n");
      out.write("\t\t\tvar row = \"\";\r\n");
      out.write("\t\t\trow += \"<tr>\"\r\n");
      out.write("\t\t\trow += \"<td>\" + data[i].name + \"</td>\";\r\n");
      out.write("\t\t\trow += \"<td>\" + data[i].member.name + \"</td>\";\r\n");
      out.write("\t\t\trow += \"<td>\" + data[i].member.school + \"</td>\";\r\n");
      out.write("\t\t\trow += \"<td>\" + data[i].member.mobile + \"</td>\";\r\n");
      out.write("\t\t\tif(data[i].member.alog >0) {\r\n");
      out.write("\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/member/getByMidAndFlag.action\",{mid : data[i].member.id},function(data2) {\r\n");
      out.write("\t\t\t\t\tvar dataObj = eval(\"(\"+data2+\")\");\r\n");
      out.write("\t\t\t\t\tvar lists = dataObj.returnMap.list;\r\n");
      out.write("\t\t\t\t\tfor(j = 0; j <lists.length; j++) {\r\n");
      out.write("\t\t\t\t\t\tline = line + row + \"<td style='color:red;'>\" + lists[j].amount + \"</td>\";\r\n");
      out.write("\t\t\t\t\t\tline = line + \"<td>\" + lists[j].formatDate + \"</td>\";\r\n");
      out.write("\t\t\t\t\t\tif (data[i].admin != null) {\r\n");
      out.write("\t\t\t\t\t\t\tline = line + \"<td>\" + data[i].admin.realname + \"</td>\";\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\tline = line + \"<td></td>\";\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\tline = line + \"<td>\";\r\n");
      out.write("\t\t\t\t\t\tvar date = lists[j].formatDate.split(\" \");\r\n");
      out.write("\t\t\t\t\t\tvar str = data[i].member.id + \",\" + lists[j].id + \",\" + data[i].member.name + \",\" + date[0] + \"&nbsp;\" + date[1] + \",\" + lists[j].amount + \",\" + lists[j].fileflag + \",\" + lists[j].upflag + \",\" + lists[j].type;\r\n");
      out.write("\t\t\t\t\t\tvar disabled = \"\";\r\n");
      out.write("\t\t\t\t\t\tvar css = \"\";\r\n");
      out.write("\t\t\t\t\t\tif(j != 0) {\r\n");
      out.write("\t\t\t\t\t\t\tdisabled = \"disabled='disabled'\";\r\n");
      out.write("\t\t\t\t\t\t\tcss = \"disabled\";\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\tline = line + \"&nbsp;&nbsp;<input type='button' value='审核' class='btn btn-danger radius auditing \" + css + \"'\" + disabled +\"lang=\" + str + \">\";\r\n");
      out.write("\t\t\t\t\t\tline = line + \"&nbsp;&nbsp;<input type='button' value='删除' class='btn btn-warning radius del \" + css + \"'\" + disabled +\"lang=\" + str + \">\";\r\n");
      out.write("\t\t\t\t\t\tline = line + \"</td></tr>\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tif(data[i].accountLog!=null){\r\n");
      out.write("\t\t\t\t\tline = line + row + \"<td style='color:red;'>\" + data[i].accountLog.amount + \"</td>\";\r\n");
      out.write("\t\t\t\t\tline = line + \"<td>\" + data[i].accountLog.formatDate + \"</td>\";\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\tline = line + row + \"<td>\" +data[0].amount + \"</td>\";\r\n");
      out.write("\t\t\t\t\tline = line + \"<td>\" + \"123\" + \"</td>\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif (data[i].admin != null) {\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tline = line + \"<td>\" + data[i].admin.realname + \"</td>\";\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\tline = line + \"<td>\" + \"\" + \"</td>\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tline = line + \"<td>\";\r\n");
      out.write("\t\t\t\t//不知道为什么用SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\")格式化完成后中间的空格会被识别成换行符\r\n");
      out.write("\t\t\t\tif(data[i].accountLog!=null){\t\r\n");
      out.write("\t\t\t\tvar date = data[i].accountLog.formatDate.split(\" \");\r\n");
      out.write("\t\t\t\tvar str = data[i].member.id + \",\" + data[i].accountLog.id + \",\" + data[i].member.name + \",\" + date[0] + \"&nbsp;\" + date[1] + \",\" + data[i].accountLog.amount + \",\" + data[i].accountLog.fileflag + \",\" + data[i].accountLog.upflag + \",\" + data[i].accountLog.type;\r\n");
      out.write("\t\t\t\tline = line + \"&nbsp;&nbsp;<input type='button' value='审核' class='btn btn-danger radius auditing' lang=\" + str + \">\";\r\n");
      out.write("\t\t\t\tline = line + \"&nbsp;&nbsp;<input type='button' value='删除' class='btn btn-warning radius del' lang=\" + str + \">\";\r\n");
      out.write("\t\t\t\tline = line + \"</td></tr>\";\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\talert(\"data数据为空\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$(\"#tbody\").html(line);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\".auditing\").click(function() {\r\n");
      out.write("\t\t\tvar str = this.lang.split(\",\");\r\n");
      out.write("\t\t\tvar s1 = \"您确定要<b style='color:red;'>通过</b>【\" + str[2] + \"】在【\" + str[3] + \"】时，金额为【<b style='color:red;'>\" + str[4] + \"</b>】的缴费?<br />\";\r\n");
      out.write("\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/member/auditing.action\",{mid : str[0]}, function(data) {\r\n");
      out.write("\t\t\t\tif(data != \"\") {\r\n");
      out.write("\t\t\t\t\tvar str1 = data.split(\",\");\r\n");
      out.write("\t\t\t\t\ts1 += \"上一次的缴费时间是【<b style='color:red;'>\" + str1[0] + \"</b>】，金额为【<b style='color:red;'>\" + str1[1] + \"</b>】！\";\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\ts1 += \"本次是第一次缴费！\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\ts1 += \"<br />\";\r\n");
      out.write("\t\t\tvar s2 = \"\";\r\n");
      out.write("\t\t\tif (str[5] == \"1\") {\r\n");
      out.write("\t\t\t\tvar ratio = str[7].split(\"*\");\r\n");
      out.write("\t\t\t\ts2 = \"<img src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/member/getPhoto.action?accountLogId=\" + str[1] + \"&random=\" + Math.random() + \"' style='height:\" + ratio[0] + \";width:\" + ratio[1] + \";'>\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tlayer.confirm(s1 + s2, {\r\n");
      out.write("\t\t\t\tbtn : [ '确定', '放弃' ],\r\n");
      out.write("\t\t\t\tarea : [ '570px']\r\n");
      out.write("\t\t\t}, function() {\r\n");
      out.write("\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/member/checkLog.action\",{id : str[0], accountlogID : str[1], upflag : str[6]}, function(data) {\r\n");
      out.write("\t\t\t\t\tlayer.closeAll();\r\n");
      out.write("\t\t\t\t\tif(data == \"1\") {\r\n");
      out.write("\t\t\t\t\t\tlayer.msg(\"<strong style='color:red;'>操作失败,数据已被删除</strong>\", {icon: 2});\r\n");
      out.write("\t\t\t\t\t} else if(data == \"2\") {\r\n");
      out.write("\t\t\t\t\t\tlayer.msg(\"<strong>数据不是最新的，请等待刷新后再审核</strong>\", {icon: 0});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tgetData($(\"b\").text());\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\".del\").click(function() {\r\n");
      out.write("\t\t\tvar str = this.lang.split(\",\");\r\n");
      out.write("\t\t\tvar s1 = \"您确定要<b style='color:red;'>删除</b>【\" + str[2] + \"】在【\" + str[3] + \"】时，金额为【<b style='color:red;'>\" + str[4] + \"</b>】的缴费?<br />\";\r\n");
      out.write("\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/member/auditing.action\",{mid : str[0]}, function(data) {\r\n");
      out.write("\t\t\t\tif(data != \"\") {\r\n");
      out.write("\t\t\t\t\tvar str1 = data.split(\",\");\r\n");
      out.write("\t\t\t\t\ts1 += \"上一次的缴费时间是【<b style='color:red;'>\" + str1[0] + \"</b>】，金额为【<b style='color:red;'>\" + str1[1] + \"</b>】！\";\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\ts1 += \"本次是第一次缴费！\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\ts1 += \"<br />\";\r\n");
      out.write("\t\t\tvar s2 = \"\";\r\n");
      out.write("\t\t\tif (str[5] == \"1\") {\r\n");
      out.write("\t\t\t\tvar ratio = str[7].split(\"*\");\r\n");
      out.write("\t\t\t\ts2 = \"<img src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/member/getPhoto.action?accountLogId=\" + str[1] + \"&random=\" + Math.random() + \"' style='height:\" + ratio[0] + \";width:\" + ratio[1] + \";'>\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tlayer.confirm(s1 + s2,{\r\n");
      out.write("\t\t\t\tbtn : [ '确定', '放弃' ],\r\n");
      out.write("\t\t\t\tarea : [ '570px' ]\r\n");
      out.write("\t\t\t},function() {\r\n");
      out.write("\t\t\t\t$.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/member/deleteLog.action\",{id : str[0], accountlogID : str[1], upflag : str[6]}, function(data) {\r\n");
      out.write("\t\t\t\t\tlayer.closeAll();\r\n");
      out.write("\t\t\t\t\tif(data == \"1\") {\r\n");
      out.write("\t\t\t\t\t\tlayer.msg(\"<strong style='color:red;'>操作失败,数据已被删除</strong>\", {icon: 2});\r\n");
      out.write("\t\t\t\t\t} else if(data == \"2\") {\r\n");
      out.write("\t\t\t\t\t\tlayer.msg(\"<strong>数据不是最新的，请等待刷新后再审核</strong>\", {icon: 0});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tgetData($(\"b\").text());\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction btnpage() {\r\n");
      out.write("\t\t$(\".nav-btn\").click(function() {\r\n");
      out.write("\t\t\tgetData(this.lang);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction btnpage2() {\r\n");
      out.write("\t\t$(\".nav-btn\").click(function() {\r\n");
      out.write("\t\t\tvar page2 = this.lang;\r\n");
      out.write("\t\t\tgetData2(1 ,page2);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t<!-- 如果不是超级管理员则返回起始页 -->\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t<h1 class=\"text-c\">VIP会员缴费审核</h1>\r\n");
      out.write("\t<div class=\"mt-20\">\r\n");
      out.write("\t\t<table class=\"table table-border table-bg table-bordered radius\"\r\n");
      out.write("\t\t\tid=\"period\">\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"panel panel-secondary\">\r\n");
      out.write("\t\t<!-- <div class=\"panel-header\"></div> -->\r\n");
      out.write("\t\t<div class=\"panel-header cl\">\r\n");
      out.write("\t\t\t<div class=\"btn-group f-l\">\r\n");
      out.write("\t\t\t\t<span class=\"btn btn-primary radius active choices\" lang=\"6\">未审核信息</span>\r\n");
      out.write("\t\t\t\t<span class=\"btn btn-primary radius choices\" lang=\"1\">已审核信息</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"panel-primary\">\r\n");
      out.write("\t\t\t<table class=\"table table-border table-bg table-bordered radius\">\r\n");
      out.write("\t\t\t\t<thead class='text-c'>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t<tbody id=\"tbody\" class='text-c'></tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class='page-nav' style=\"float: right; margin-top: 10px;\"\r\n");
      out.write("\t\tid=\"paging\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /admin/feedetailTwo.jsp(255,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ADMIN==null}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t");
        if (true) {
          _jspx_page_context.forward("/user/login.jsp");
          return true;
        }
        out.write('\r');
        out.write('\n');
        out.write('	');
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /admin/feedetailTwo.jsp(259,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ADMIN.authority!='1'}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t");
        if (true) {
          _jspx_page_context.forward("/user/login.jsp");
          return true;
        }
        out.write('\r');
        out.write('\n');
        out.write('	');
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }
}
